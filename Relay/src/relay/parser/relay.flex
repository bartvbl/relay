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
	"*"							{ return symbol("operator_multiply", OPERATOR_MULTIPLY); }
	"/"							{ return symbol("operator_division", OPERATOR_DIVIDE); }
	"<"							{ return symbol("operator_less_than", OPERATOR_LESS_THAN); }
	"<="						{ return symbol("operator_less_or_equal", OPERATOR_LESS_OR_EQUAL); }
	"=="						{ return symbol("operator_equals", OPERATOR_EQUALS); }
	">="						{ return symbol("operator_greater_or_equal", OPERATOR_GREATER_OR_EQUAL); }
	">"							{ return symbol("operator_greater_than", OPERATOR_GREATER_THAN); }
	"and"						{ return symbol("operator_boolean_and", OPERATOR_BOOLEAN_AND); }
	"or"						{ return symbol("operator_boolean_or", OPERATOR_BOOLEAN_OR); }
	"xor"						{ return symbol("operator_boolean_xor", OPERATOR_BOOLEAN_XOR); }
	"not"						{ return symbol("operator_boolean_not", OPERATOR_BOOLEAN_NOT); }
	
	"def"						{ return symbol("keyword_def", KEYWORD_DEF); }
	"for"						{ return symbol("keyword_for", KEYWORD_FOR); }
	"in"						{ return symbol("keyword_in", KEYWORD_IN); }
	"if"						{ return symbol("keyword_if", KEYWORD_IF); }
	"otherwise"					{ return symbol("keyword_otherwise", KEYWORD_OTHERWISE); }
	
	{DoubleLiteral}				{ return symbol("number", NUMBER, new Double(Double.parseDouble(yytext()))); }
	{Identifier}				{ return symbol("identifyer", IDENTIFYER, yytext()); }
	{Comment}					{ return symbol("comment", NEW_LINE); }
	{WhiteSpace}				{ /* ignore */ }
}

/* error fallback */
[^]                              { throw new RuntimeException("Illegal character" + yytext());}
<<EOF>>                          { return symbol("end_of_file", EOF); }