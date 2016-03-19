package relay.parser;

import java_cup.runtime.*;
import static relay.parser.RelaySymbols.*;
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
		Location left = new Location(yyline + 1, yycolumn + 1, yychar);
		Location right = new Location(yyline + 1, yycolumn + yylength(), yychar + yylength());
		return symbolFactory.newSymbol(name, sym, left, right);
	}

	private Symbol symbol(String name, int sym, Object val) {
		Location left = new Location(yyline + 1, yycolumn + 1, yychar);
		Location right = new Location(yyline + 1, yycolumn + yylength(), yychar + yylength());
		return symbolFactory.newSymbol(name, sym, left, right, val);
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

Identifier = [:jletter:] (-|_|[:jletterdigit:])*    
DoubleLiteral = ({FLit1}|{FLit2}|{FLit3}) {Exponent}?

FLit1    = [0-9]+ \. [0-9]* 
FLit2    = \. [0-9]+ 
FLit3    = [0-9]+ 
Exponent = [eE] [+-]? [0-9]+

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

	"px"						{ return symbol("unit_pixels", UNIT_PIXELS); }
	"%"							{ return symbol("unit_percent", UNIT_PERCENT); }

	"of"						{ return symbol("operator_of", OPERATOR_OF); }
	"+"							{ return symbol("operator_plus", OPERATOR_PLUS); }
	"-"							{ return symbol("operator_minus", OPERATOR_MINUS); }
	
	"def"						{ return symbol("keyword_def", KEYWORD_DEF); }
	
	{DoubleLiteral}				{ return symbol("number", NUMBER, new Double(Double.parseDouble(yytext()))); }
	{Identifier}				{ return symbol("identifyer", IDENTIFYER, yytext()); }
	{Comment}					{ return symbol("comment", NEW_LINE); }
	{WhiteSpace}				{ /* ignore */ }
}

/* error fallback */
[^]                              { throw new RuntimeException("Illegal character" + yytext());}
<<EOF>>                          { return symbol("end_of_file", EOF); }