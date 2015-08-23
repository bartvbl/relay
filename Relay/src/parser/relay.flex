package parser;

import java_cup.runtime.*;
import static parser.RelaySymbols.*;

%%

%public
%class Scanner

%unicode

%line
%column

%cup
%cupdebug

%cupsym RelaySymbols

%{
	StringBuilder string = new StringBuilder();
	
	private Symbol symbol(int type) {
		return symbol(type, yytext());
	}

	private Symbol symbol(int type, Object value) {
		System.out.println("Created symbol on line " + (yyline+1) + " and column " + yycolumn + ". Value: " + value);
		return new Symbol(type, yyline+1, yycolumn, value);
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
	{LineTerminator}			{ return symbol(NEW_LINE); }
	":"							{ return symbol(COLON); }
	";"							{ return symbol(SEMICOLON); }
	"."							{ return symbol(DOT); }
	","							{ return symbol(COMMA); }

	"("							{ return symbol(BLOCK_OPEN); }
	")"							{ return symbol(BLOCK_CLOSE); }

	"{"							{ return symbol(CODE_BLOCK_OPEN); }
	"}"							{ return symbol(CODE_BLOCK_CLOSE); }

	"px"						{ return symbol(UNIT_PIXELS); }
	"%"							{ return symbol(UNIT_PERCENT); }

	"+"							{ return symbol(OPERATOR_PLUS); }
	"-"							{ return symbol(OPERATOR_MINUS); }

	"line"						{ return symbol(KEYWORD_LINE); }
	"from"						{ return symbol(KEYWORD_FROM); }
	"to"						{ return symbol(KEYWORD_TO); }
	
	{DoubleLiteral}				{ return symbol(NUMBER); }
	{Identifier}				{ return symbol(IDENTIFYER); }
	{Comment}					{ return symbol(NEW_LINE); }
	{WhiteSpace}				{ /* ignore */ }
}

/* error fallback */
[^]                              { throw new RuntimeException("Illegal character" + yytext());}
<<EOF>>                          { return symbol(EOF); }