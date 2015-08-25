package parser;

import java_cup.runtime.*;
import static parser.RelaySymbols.*;
import java_cup.runtime.ComplexSymbolFactory.Location;

%%

%public
%class Lexer

%unicode

%line
%column

%cupsym RelaySymbols
%cup
%cupdebug


%{
	StringBuffer string = new StringBuffer();

    public Lexer(java.io.Reader in, ComplexSymbolFactory sf) {
		this(in);
		symbolFactory = sf;
    }
    ComplexSymbolFactory symbolFactory;

  private Symbol symbol(String name, int sym) {
      return symbolFactory.newSymbol(name, sym, new Location(yyline+1,yycolumn+1,yychar), new Location(yyline+1,yycolumn+yylength(),yychar+yylength()));
  }

  private Symbol symbol(String name, int sym, Object val) {
      Location left = new Location(yyline+1,yycolumn+1,yychar);
      Location right= new Location(yyline+1,yycolumn+yylength(), yychar+yylength());
      return symbolFactory.newSymbol(name, sym, left, right,val);
  }
  private Symbol symbol(String name, int sym, Object val,int buflength) {
      Location left = new Location(yyline+1,yycolumn+yylength()-buflength,yychar+yylength()-buflength);
      Location right= new Location(yyline+1,yycolumn+yylength(), yychar+yylength());
      return symbolFactory.newSymbol(name, sym, left, right,val);
  }
%}

/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

WhiteSpace = [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | 
					{DocumentationComment}

TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/*" "*"+ [^/*] ~"*/"

/* identifiers */
Identifier = [:jletter:] (-|_|[:jletterdigit:])*

/* integer literals */
DecIntegerLiteral = 0 | [1-9][0-9]*
DecLongLiteral    = {DecIntegerLiteral} [lL]

HexIntegerLiteral = 0 [xX] 0* {HexDigit} {1,8}
HexLongLiteral    = 0 [xX] 0* {HexDigit} {1,16} [lL]
HexDigit          = [0-9a-fA-F]

OctIntegerLiteral = 0+ [1-3]? {OctDigit} {1,15}
OctLongLiteral    = 0+ 1? {OctDigit} {1,21} [lL]
OctDigit          = [0-7]
		
/* floating point literals */        
FloatLiteral  = ({FLit1}|{FLit2}|{FLit3}) {Exponent}? [fF]
DoubleLiteral = ({FLit1}|{FLit2}|{FLit3}) {Exponent}?

FLit1    = [0-9]+ \. [0-9]* 
FLit2    = \. [0-9]+ 
FLit3    = [0-9]+ 
Exponent = [eE] [+-]? [0-9]+

/* string and character literals */
StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]

%state STRING, CHARLITERAL

%%

<YYINITIAL> {

	/* keywords */
	{LineTerminator}			{ return symbol("newline", NEW_LINE); }
	":"							{ return symbol(":", COLON); }
	";"							{ return symbol(";", SEMICOLON); }
	"."							{ return symbol(".", DOT); }
	","							{ return symbol(",", COMMA); }

	"("							{ return symbol("block_open", BLOCK_OPEN); }
	")"							{ return symbol("block_close", BLOCK_CLOSE); }

	"{"							{ return symbol("code_block_open", CODE_BLOCK_OPEN); }
	"}"							{ return symbol("code_block_close", CODE_BLOCK_CLOSE); }

	"px"						{ return symbol("unit_pixels", UNIT_PIXELS); }
	"%"							{ return symbol("unit_percent", UNIT_PERCENT); }

	"+"							{ return symbol("operator_plus", OPERATOR_PLUS); }
	"-"							{ return symbol("operator_minus", OPERATOR_MINUS); }

	"line"						{ return symbol("keyword_line", KEYWORD_LINE); }
	"from"						{ return symbol("keyword_from", KEYWORD_FROM); }
	"to"						{ return symbol("keyword_to", KEYWORD_TO); }
	
	{DoubleLiteral}				{ return symbol("number", NUMBER, new Double(Double.parseDouble(yytext()))); }
	{Identifier}				{ return symbol("identifyer", IDENTIFYER, yytext()); }
	{Comment}					{ return symbol("comment", NEW_LINE); }
	{WhiteSpace}				{ /* ignore */ }
}

/* error fallback */
[^]                              { throw new RuntimeException("Illegal character" + yytext());}
<<EOF>>                          { return symbol("end_of_file", EOF); }