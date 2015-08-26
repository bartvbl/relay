
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20150326 (SVN rev 63)
//----------------------------------------------------

package parser;

import java_cup.runtime.*;
import parser.nodes.AdditionExpressionSymbol;
import parser.nodes.BlockContentItemSymbol;
import parser.nodes.BlockContentListSymbol;
import parser.nodes.BlockPropertySymbol;
import parser.nodes.CodeBlockSymbol;
import parser.nodes.CodeStatementSymbol;
import parser.nodes.ExpressionSymbol;
import parser.nodes.FunctionCallSymbol;
import parser.nodes.IdentifyerSYmbol;
import parser.nodes.ParameterListSymbol;
import parser.nodes.RootSymbol;
import parser.nodes.BlockSymbol;
import parser.nodes.StatementListSymbol;
import parser.nodes.SubtractionExpressionSymbol;
import parser.nodes.UnitSymbol;
import parser.nodes.ValueSymbol;
import parser.nodes.VariableAccessSymbol;
import parser.nodes.types.StatementType;
import relay.data.Unit;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20150326 (SVN rev 63) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class RelayParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return RelaySymbols.class;
}

  /** Default constructor. */
  @Deprecated
  public RelayParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public RelayParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public RelayParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\036\000\002\002\004\000\002\002\003\000\002\003" +
    "\007\000\002\003\006\000\002\005\002\000\002\005\004" +
    "\000\002\006\004\000\002\006\004\000\002\007\003\000" +
    "\002\007\003\000\002\007\003\000\002\007\002\000\002" +
    "\015\005\000\002\016\004\000\002\016\003\000\002\017" +
    "\017\000\002\010\005\000\002\011\004\000\002\011\005" +
    "\000\002\011\005\000\002\011\003\000\002\011\003\000" +
    "\002\014\006\000\002\020\005\000\002\020\002\000\002" +
    "\013\005\000\002\013\003\000\002\012\003\000\002\012" +
    "\003\000\002\004\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\075\000\004\013\005\001\002\000\004\002\077\001" +
    "\002\000\006\004\010\011\011\001\002\000\004\002\000" +
    "\001\002\000\004\004\074\001\002\000\016\004\ufffd\007" +
    "\ufffd\011\ufffd\013\ufffd\014\ufffd\015\ufffd\001\002\000\022" +
    "\004\uffe4\006\uffe4\007\uffe4\010\uffe4\012\uffe4\014\uffe4\021" +
    "\uffe4\022\uffe4\001\002\000\016\004\ufff6\007\ufff6\011\011" +
    "\013\005\014\017\015\020\001\002\000\004\006\072\001" +
    "\002\000\006\004\071\007\070\001\002\000\016\004\ufffc" +
    "\007\ufffc\011\ufffc\013\ufffc\014\ufffc\015\ufffc\001\002\000" +
    "\006\004\ufff9\007\ufff9\001\002\000\010\002\ufffe\004\ufffe" +
    "\007\ufffe\001\002\000\004\023\025\001\002\000\006\004" +
    "\ufff8\007\ufff8\001\002\000\006\004\ufff7\007\ufff7\001\002" +
    "\000\006\016\ufff3\023\025\001\002\000\004\016\066\001" +
    "\002\000\004\024\026\001\002\000\004\013\027\001\002" +
    "\000\006\005\032\011\033\001\002\000\016\004\uffed\007" +
    "\uffed\012\uffed\014\uffed\021\uffed\022\uffed\001\002\000\020" +
    "\004\uffe7\007\uffe7\010\064\012\uffe7\014\uffe7\021\uffe7\022" +
    "\uffe7\001\002\000\006\017\061\020\062\001\002\000\022" +
    "\004\uffe4\007\uffe4\010\uffe4\012\uffe4\013\053\014\uffe4\021" +
    "\uffe4\022\uffe4\001\002\000\010\012\036\021\040\022\037" +
    "\001\002\000\016\004\uffec\007\uffec\012\uffec\014\uffec\021" +
    "\uffec\022\uffec\001\002\000\006\005\032\011\033\001\002" +
    "\000\006\005\032\011\033\001\002\000\006\005\032\011" +
    "\033\001\002\000\016\004\uffef\007\uffef\012\uffef\014\uffef" +
    "\021\uffef\022\uffef\001\002\000\016\004\uffee\007\uffee\012" +
    "\uffee\014\uffee\021\uffee\022\uffee\001\002\000\010\014\044" +
    "\021\040\022\037\001\002\000\004\025\045\001\002\000" +
    "\004\013\046\001\002\000\006\005\032\011\033\001\002" +
    "\000\010\012\050\021\040\022\037\001\002\000\006\005" +
    "\032\011\033\001\002\000\010\014\052\021\040\022\037" +
    "\001\002\000\006\016\ufff2\023\ufff2\001\002\000\010\005" +
    "\032\011\033\014\uffe9\001\002\000\004\014\060\001\002" +
    "\000\010\012\056\021\040\022\037\001\002\000\010\005" +
    "\032\011\033\014\uffe9\001\002\000\004\014\uffea\001\002" +
    "\000\016\004\uffeb\007\uffeb\012\uffeb\014\uffeb\021\uffeb\022" +
    "\uffeb\001\002\000\016\004\uffe6\007\uffe6\012\uffe6\014\uffe6" +
    "\021\uffe6\022\uffe6\001\002\000\016\004\uffe5\007\uffe5\012" +
    "\uffe5\014\uffe5\021\uffe5\022\uffe5\001\002\000\016\004\ufff0" +
    "\007\ufff0\012\ufff0\014\ufff0\021\ufff0\022\ufff0\001\002\000" +
    "\004\011\011\001\002\000\016\004\uffe8\007\uffe8\012\uffe8" +
    "\014\uffe8\021\uffe8\022\uffe8\001\002\000\006\004\ufff5\007" +
    "\ufff5\001\002\000\004\016\ufff4\001\002\000\016\004\ufffa" +
    "\007\ufffa\011\ufffa\013\ufffa\014\ufffa\015\ufffa\001\002\000" +
    "\016\004\ufffb\007\ufffb\011\ufffb\013\ufffb\014\ufffb\015\ufffb" +
    "\001\002\000\006\005\032\011\033\001\002\000\012\004" +
    "\ufff1\007\ufff1\021\040\022\037\001\002\000\016\004\ufffd" +
    "\007\ufffd\011\ufffd\013\ufffd\014\ufffd\015\ufffd\001\002\000" +
    "\016\004\ufff6\007\ufff6\011\011\013\005\014\076\015\020" +
    "\001\002\000\010\002\uffff\004\uffff\007\uffff\001\002\000" +
    "\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\075\000\006\002\003\003\005\001\001\000\002\001" +
    "\001\000\004\004\006\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\005\011\001\001\000\002\001\001\000" +
    "\016\003\015\004\012\006\014\007\013\010\020\015\021" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\006\016\023" +
    "\017\022\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\016\066\017\022\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\012\004\030\011\033\013" +
    "\027\014\034\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\012\062\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\012\004\030\011\042\013\027" +
    "\014\034\001\001\000\012\004\030\011\041\013\027\014" +
    "\034\001\001\000\012\004\030\011\040\013\027\014\034" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\012\004\030" +
    "\011\046\013\027\014\034\001\001\000\002\001\001\000" +
    "\012\004\030\011\050\013\027\014\034\001\001\000\002" +
    "\001\001\000\002\001\001\000\014\004\030\011\054\013" +
    "\027\014\034\020\053\001\001\000\002\001\001\000\002" +
    "\001\001\000\014\004\030\011\054\013\027\014\034\020" +
    "\056\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\004" +
    "\030\013\064\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\012\004\030\011\072\013\027\014\034\001\001\000\002" +
    "\001\001\000\004\005\074\001\001\000\016\003\015\004" +
    "\012\006\014\007\013\010\020\015\021\001\001\000\002" +
    "\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$RelayParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$RelayParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$RelayParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$RelayParser$actions {
  private final RelayParser parser;

  /** Constructor */
  CUP$RelayParser$actions(RelayParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$RelayParser$do_action_part00000000(
    int                        CUP$RelayParser$act_num,
    java_cup.runtime.lr_parser CUP$RelayParser$parser,
    java.util.Stack            CUP$RelayParser$stack,
    int                        CUP$RelayParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$RelayParser$result;

      /* select the action based on the action number */
      switch (CUP$RelayParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= goal EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).right;
		RootSymbol start_val = (RootSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).value;
		RESULT = start_val;
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$RelayParser$parser.done_parsing();
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // goal ::= block 
            {
              RootSymbol RESULT =null;
		int blockleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int blockright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		BlockSymbol block = (BlockSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new RootSymbol(block); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("goal",0, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // block ::= BLOCK_OPEN identifyer NEW_LINE block_content_list BLOCK_CLOSE 
            {
              BlockSymbol RESULT =null;
		int blockNameleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-3)).left;
		int blockNameright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-3)).right;
		IdentifyerSYmbol blockName = (IdentifyerSYmbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-3)).value;
		int blockContentleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).left;
		int blockContentright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).right;
		BlockContentListSymbol blockContent = (BlockContentListSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).value;
		 RESULT = new BlockSymbol(blockName, blockContent); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("block",1, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-4)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // block ::= BLOCK_OPEN NEW_LINE block_content_list BLOCK_CLOSE 
            {
              BlockSymbol RESULT =null;
		int blockContentleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).left;
		int blockContentright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).right;
		BlockContentListSymbol blockContent = (BlockContentListSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).value;
		 RESULT = new BlockSymbol(new IdentifyerSYmbol("[untitled block]"), blockContent); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("block",1, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-3)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // block_content_list ::= 
            {
              BlockContentListSymbol RESULT =null;
		 RESULT = null; 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("block_content_list",3, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // block_content_list ::= block_content_list block_content_line 
            {
              BlockContentListSymbol RESULT =null;
		int remainingNodesleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).left;
		int remainingNodesright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).right;
		BlockContentListSymbol remainingNodes = (BlockContentListSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).value;
		int listNodeleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int listNoderight = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		BlockContentItemSymbol listNode = (BlockContentItemSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new BlockContentListSymbol(listNode, remainingNodes); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("block_content_list",3, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // block_content_line ::= block_content_item NEW_LINE 
            {
              BlockContentItemSymbol RESULT =null;
		int itemleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).left;
		int itemright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).right;
		BlockContentItemSymbol item = (BlockContentItemSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).value;
		 RESULT = item; 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("block_content_line",4, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // block_content_line ::= block_content_item SEMICOLON 
            {
              BlockContentItemSymbol RESULT =null;
		int itemleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).left;
		int itemright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).right;
		BlockContentItemSymbol item = (BlockContentItemSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).value;
		 RESULT = item; 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("block_content_line",4, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // block_content_item ::= block 
            {
              BlockContentItemSymbol RESULT =null;
		int itemleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int itemright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		BlockSymbol item = (BlockSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new BlockContentItemSymbol(item); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("block_content_item",5, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // block_content_item ::= block_property 
            {
              BlockContentItemSymbol RESULT =null;
		int itemleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int itemright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		BlockPropertySymbol item = (BlockPropertySymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new BlockContentItemSymbol(item); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("block_content_item",5, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // block_content_item ::= code_block 
            {
              BlockContentItemSymbol RESULT =null;
		int itemleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int itemright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		CodeBlockSymbol item = (CodeBlockSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new BlockContentItemSymbol(item); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("block_content_item",5, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // block_content_item ::= 
            {
              BlockContentItemSymbol RESULT =null;
		 RESULT = new BlockContentItemSymbol(); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("block_content_item",5, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // code_block ::= CODE_BLOCK_OPEN code_statement_list CODE_BLOCK_CLOSE 
            {
              CodeBlockSymbol RESULT =null;
		int statementListleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).left;
		int statementListright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).right;
		StatementListSymbol statementList = (StatementListSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).value;
		 RESULT = new CodeBlockSymbol(statementList); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("code_block",11, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // code_statement_list ::= code_statement code_statement_list 
            {
              StatementListSymbol RESULT =null;
		int statementleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).left;
		int statementright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).right;
		CodeStatementSymbol statement = (CodeStatementSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).value;
		int remainingNodesleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int remainingNodesright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		StatementListSymbol remainingNodes = (StatementListSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new StatementListSymbol(statement, remainingNodes); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("code_statement_list",12, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // code_statement_list ::= code_statement 
            {
              StatementListSymbol RESULT =null;
		int statementleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int statementright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		CodeStatementSymbol statement = (CodeStatementSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new StatementListSymbol(statement, null); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("code_statement_list",12, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // code_statement ::= KEYWORD_LINE KEYWORD_FROM BLOCK_OPEN expression COMMA expression BLOCK_CLOSE KEYWORD_TO BLOCK_OPEN expression COMMA expression BLOCK_CLOSE 
            {
              CodeStatementSymbol RESULT =null;
		int fromXleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-9)).left;
		int fromXright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-9)).right;
		ExpressionSymbol fromX = (ExpressionSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-9)).value;
		int fromYleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-7)).left;
		int fromYright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-7)).right;
		ExpressionSymbol fromY = (ExpressionSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-7)).value;
		int toXleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-3)).left;
		int toXright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-3)).right;
		ExpressionSymbol toX = (ExpressionSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-3)).value;
		int toYleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).left;
		int toYright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).right;
		ExpressionSymbol toY = (ExpressionSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).value;
		 RESULT = new CodeStatementSymbol(StatementType.LINE, fromX, fromY, toX, toY); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("code_statement",13, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-12)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // block_property ::= identifyer COLON expression 
            {
              BlockPropertySymbol RESULT =null;
		int identifyerleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).left;
		int identifyerright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).right;
		IdentifyerSYmbol identifyer = (IdentifyerSYmbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).value;
		int expressionleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int expressionright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		ExpressionSymbol expression = (ExpressionSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new BlockPropertySymbol(identifyer, expression); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("block_property",6, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // expression ::= NUMBER unit 
            {
              ExpressionSymbol RESULT =null;
		int valueleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).left;
		int valueright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).right;
		Double value = (Double)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).value;
		int unitleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int unitright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		UnitSymbol unit = (UnitSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new ValueSymbol(value, unit); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("expression",7, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // expression ::= expression OPERATOR_PLUS expression 
            {
              ExpressionSymbol RESULT =null;
		int lefthandsideleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).left;
		int lefthandsideright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).right;
		ExpressionSymbol lefthandside = (ExpressionSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).value;
		int righthandsideleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int righthandsideright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		ExpressionSymbol righthandside = (ExpressionSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new AdditionExpressionSymbol(lefthandside, righthandside); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("expression",7, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // expression ::= expression OPERATOR_MINUS expression 
            {
              ExpressionSymbol RESULT =null;
		int lefthandsideleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).left;
		int lefthandsideright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).right;
		ExpressionSymbol lefthandside = (ExpressionSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).value;
		int righthandsideleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int righthandsideright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		ExpressionSymbol righthandside = (ExpressionSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new SubtractionExpressionSymbol(lefthandside, righthandside); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("expression",7, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // expression ::= variable_access 
            {
              ExpressionSymbol RESULT =null;
		int variable_accessleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int variable_accessright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		VariableAccessSymbol variable_access = (VariableAccessSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = variable_access; 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("expression",7, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // expression ::= function_call 
            {
              ExpressionSymbol RESULT =null;
		int callleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int callright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		FunctionCallSymbol call = (FunctionCallSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = call; 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("expression",7, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // function_call ::= IDENTIFYER BLOCK_OPEN parameter_list BLOCK_CLOSE 
            {
              FunctionCallSymbol RESULT =null;
		int identifyerleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-3)).left;
		int identifyerright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-3)).right;
		String identifyer = (String)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-3)).value;
		int parametersleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).left;
		int parametersright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).right;
		ParameterListSymbol parameters = (ParameterListSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-1)).value;
		 RESULT = new FunctionCallSymbol(identifyer, parameters); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("function_call",10, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-3)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // parameter_list ::= expression COMMA parameter_list 
            {
              ParameterListSymbol RESULT =null;
		int expressionleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).left;
		int expressionright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).right;
		ExpressionSymbol expression = (ExpressionSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).value;
		int remainingNodesleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int remainingNodesright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		ParameterListSymbol remainingNodes = (ParameterListSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new ParameterListSymbol(expression, remainingNodes); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("parameter_list",14, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // parameter_list ::= 
            {
              ParameterListSymbol RESULT =null;
		 RESULT = null; 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("parameter_list",14, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // variable_access ::= identifyer DOT variable_access 
            {
              VariableAccessSymbol RESULT =null;
		int identifyerleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).left;
		int identifyerright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).right;
		IdentifyerSYmbol identifyer = (IdentifyerSYmbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)).value;
		int remainingAccessleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int remainingAccessright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		VariableAccessSymbol remainingAccess = (VariableAccessSymbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new VariableAccessSymbol(identifyer, remainingAccess); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("variable_access",9, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.elementAt(CUP$RelayParser$top-2)), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // variable_access ::= identifyer 
            {
              VariableAccessSymbol RESULT =null;
		int identifyerleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int identifyerright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		IdentifyerSYmbol identifyer = (IdentifyerSYmbol)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new VariableAccessSymbol(identifyer); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("variable_access",9, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // unit ::= UNIT_PIXELS 
            {
              UnitSymbol RESULT =null;
		 RESULT = new UnitSymbol(Unit.PIXELS); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("unit",8, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // unit ::= UNIT_PERCENT 
            {
              UnitSymbol RESULT =null;
		 RESULT = new UnitSymbol(Unit.PERCENT); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("unit",8, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // identifyer ::= IDENTIFYER 
            {
              IdentifyerSYmbol RESULT =null;
		int identifyerleft = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).left;
		int identifyerright = ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()).right;
		String identifyer = (String)((java_cup.runtime.Symbol) CUP$RelayParser$stack.peek()).value;
		 RESULT = new IdentifyerSYmbol(identifyer); 
              CUP$RelayParser$result = parser.getSymbolFactory().newSymbol("identifyer",2, ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$RelayParser$stack.peek()), RESULT);
            }
          return CUP$RelayParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$RelayParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$RelayParser$do_action(
    int                        CUP$RelayParser$act_num,
    java_cup.runtime.lr_parser CUP$RelayParser$parser,
    java.util.Stack            CUP$RelayParser$stack,
    int                        CUP$RelayParser$top)
    throws java.lang.Exception
    {
              return CUP$RelayParser$do_action_part00000000(
                               CUP$RelayParser$act_num,
                               CUP$RelayParser$parser,
                               CUP$RelayParser$stack,
                               CUP$RelayParser$top);
    }
}

}
