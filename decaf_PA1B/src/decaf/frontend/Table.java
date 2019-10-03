/* This is auto-generated source by LL1-Parser-Gen.
 * Specification file: C:\code\java\decaf_PA1_B\src\decaf\frontend\Parser.spec
 * Options: unstrict mode
 * Generated at: Sat Nov 03 16:46:34 CST 2018
 * Please do NOT modify it!
 *
 * Project repository: https://github.com/paulzfm/LL1-Parser-Gen
 * Version: special version for decaf-PA1-B
 * Author: Zhu Fengmin (Paul)
 */

package decaf.frontend;

import decaf.Location;
import decaf.tree.Tree;
import decaf.tree.Tree.*;
import java.util.*;

public class Table
 {
    public static final int eof = -1;
    public static final int eos = 0;
    
    /* tokens and symbols */
    public static final int VOID = 257; //# line 13
    public static final int BOOL = 258; //# line 13
    public static final int INT = 259; //# line 13
    public static final int STRING = 260; //# line 13
    public static final int CLASS = 261; //# line 13
    public static final int NULL = 262; //# line 14
    public static final int EXTENDS = 263; //# line 14
    public static final int THIS = 264; //# line 14
    public static final int WHILE = 265; //# line 14
    public static final int FOR = 266; //# line 14
    public static final int IF = 267; //# line 15
    public static final int ELSE = 268; //# line 15
    public static final int RETURN = 269; //# line 15
    public static final int BREAK = 270; //# line 15
    public static final int NEW = 271; //# line 15
    public static final int PRINT = 272; //# line 16
    public static final int READ_INTEGER = 273; //# line 16
    public static final int READ_LINE = 274; //# line 16
    public static final int LITERAL = 275; //# line 17
    public static final int IDENTIFIER = 276; //# line 18
    public static final int AND = 277; //# line 18
    public static final int OR = 278; //# line 18
    public static final int STATIC = 279; //# line 18
    public static final int INSTANCEOF = 280; //# line 18
    public static final int LESS_EQUAL = 281; //# line 19
    public static final int GREATER_EQUAL = 282; //# line 19
    public static final int EQUAL = 283; //# line 19
    public static final int NOT_EQUAL = 284; //# line 19
    public static final int SCOPY = 285; //# line 20
    public static final int SEALED = 286; //# line 20
    public static final int VAR = 287; //# line 20
    public static final int SEP = 288; //# line 20
    public static final int INIT = 289; //# line 20
    public static final int CONCAT = 290; //# line 20
    public static final int DEFAULT = 291; //# line 20
    public static final int COMPLEFT = 292; //# line 21
    public static final int COMPRIGHT = 293; //# line 21
    public static final int IN = 294; //# line 21
    public static final int FOREACH = 295; //# line 21
    
    public static final int ExprT44 = 296;
    public static final int VariableDef = 297;
    public static final int ExprT5 = 298;
    public static final int Condition = 299;
    public static final int Guard = 300;
    public static final int BoundVariable = 301;
    public static final int Oper3 = 302;
    public static final int Oper6 = 303;
    public static final int SubConstantList = 304;
    public static final int VariableList = 305;
    public static final int Formals = 306;
    public static final int Oper7 = 307;
    public static final int Expr8 = 308;
    public static final int AfterSimpleTypeExpr = 309;
    public static final int Expr2 = 310;
    public static final int SubGuardList = 311;
    public static final int Expr44 = 312;
    public static final int Oper2 = 313;
    public static final int WhileCondition = 314;
    public static final int Expr6 = 315;
    public static final int ExprT444 = 316;
    public static final int ExprT9 = 317;
    public static final int BreakStmt = 318;
    public static final int ExprT2 = 319;
    public static final int StmtList = 320;
    public static final int Oper44 = 321;
    public static final int Constant = 322;
    public static final int SubVariableList = 323;
    public static final int PrintStmt = 324;
    public static final int ConstantList = 325;
    public static final int ForStmt = 326;
    public static final int IfBegin = 327;
    public static final int Expr9 = 328;
    public static final int Expr1 = 329;
    public static final int ForeachStmt = 330;
    public static final int ArrayConstant = 331;
    public static final int AfterExpr = 332;
    public static final int GuardedStmt = 333;
    public static final int Oper1 = 334;
    public static final int ElseClause = 335;
    public static final int Expr444 = 336;
    public static final int FieldList = 337;
    public static final int SubExprList = 338;
    public static final int AfterParenExpr = 339;
    public static final int ClassDef = 340;
    public static final int ReturnStmt = 341;
    public static final int ExprList = 342;
    public static final int StmtBlock = 343;
    public static final int Oper444 = 344;
    public static final int FunctionField = 345;
    public static final int AfterIdentExpr = 346;
    public static final int Program = 347;
    public static final int Expr = 348;
    public static final int Type = 349;
    public static final int Expr5 = 350;
    public static final int AfterNewExpr = 351;
    public static final int Assignment = 352;
    public static final int ExtendsClause = 353;
    public static final int Oper5 = 354;
    public static final int ArrayType = 355;
    public static final int GuardList = 356;
    public static final int Expr3 = 357;
    public static final int Actuals = 358;
    public static final int Variable = 359;
    public static final int ExprT3 = 360;
    public static final int Stmt = 361;
    public static final int SimpleStmt = 362;
    public static final int SimpleType = 363;
    public static final int WhileStmt = 364;
    public static final int ExprT1 = 365;
    public static final int Expr4 = 366;
    public static final int ExprT4 = 367;
    public static final int ReturnExpr = 368;
    public static final int IfStmt = 369;
    public static final int OCStmt = 370;
    public static final int ExprT6 = 371;
    public static final int ExprT8 = 372;
    public static final int Expr7 = 373;
    public static final int ClassList = 374;
    public static final int Oper4 = 375;
    public static final int Field = 376;
    
    /* start symbol */
    public final int start = Program;
    
    /**
      * Judge if a symbol (within valid range) is non-terminal.
      *
      * @param symbol the symbol to be judged.
      * @return true if and only if the symbol is non-terminal.
      */
        
    public boolean isNonTerminal(int symbol) {
        return symbol >= 296;
    }
    
    private final String[] allSymbols = {
        "VOID", "BOOL", "INT", "STRING", "CLASS",
        "NULL", "EXTENDS", "THIS", "WHILE", "FOR",
        "IF", "ELSE", "RETURN", "BREAK", "NEW",
        "PRINT", "READ_INTEGER", "READ_LINE", "LITERAL", "IDENTIFIER",
        "AND", "OR", "STATIC", "INSTANCEOF", "LESS_EQUAL",
        "GREATER_EQUAL", "EQUAL", "NOT_EQUAL", "SCOPY", "SEALED",
        "VAR", "SEP", "INIT", "CONCAT", "DEFAULT",
        "COMPLEFT", "COMPRIGHT", "IN", "FOREACH", "ExprT44",
        "VariableDef", "ExprT5", "Condition", "Guard", "BoundVariable",
        "Oper3", "Oper6", "SubConstantList", "VariableList", "Formals",
        "Oper7", "Expr8", "AfterSimpleTypeExpr", "Expr2", "SubGuardList",
        "Expr44", "Oper2", "WhileCondition", "Expr6", "ExprT444",
        "ExprT9", "BreakStmt", "ExprT2", "StmtList", "Oper44",
        "Constant", "SubVariableList", "PrintStmt", "ConstantList", "ForStmt",
        "IfBegin", "Expr9", "Expr1", "ForeachStmt", "ArrayConstant",
        "AfterExpr", "GuardedStmt", "Oper1", "ElseClause", "Expr444",
        "FieldList", "SubExprList", "AfterParenExpr", "ClassDef", "ReturnStmt",
        "ExprList", "StmtBlock", "Oper444", "FunctionField", "AfterIdentExpr",
        "Program", "Expr", "Type", "Expr5", "AfterNewExpr",
        "Assignment", "ExtendsClause", "Oper5", "ArrayType", "GuardList",
        "Expr3", "Actuals", "Variable", "ExprT3", "Stmt",
        "SimpleStmt", "SimpleType", "WhileStmt", "ExprT1", "Expr4",
        "ExprT4", "ReturnExpr", "IfStmt", "OCStmt", "ExprT6",
        "ExprT8", "Expr7", "ClassList", "Oper4", "Field",
    };
    
    /**
      * Debugging function (pretty print).
      * Get string presentation of some token or symbol.
      *
      * @param symbol either terminal or non-terminal.
      * @return its string presentation.
      */
        
    public String name(int symbol) {
        if (symbol == eof) return "<eof>";
        if (symbol == eos) return "<eos>";
        if (symbol > 0 && symbol <= 256) return "'" + (char) symbol + "'";
        return allSymbols[symbol - 257];
    }
    
    /* begin lookahead symbols */
    private ArrayList<Set<Integer>> begin = new ArrayList<Set<Integer>>();
    private final Integer[][] beginRaw = {
        {CONCAT, Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';')},
        {VOID, CLASS, INT, STRING, BOOL},
        {Integer.valueOf('+'), Integer.valueOf('-'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {IF, COMPRIGHT},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {VOID, CLASS, INT, STRING, BOOL, VAR},
        {EQUAL, NOT_EQUAL},
        {Integer.valueOf('*'), Integer.valueOf('/'), Integer.valueOf('%')},
        {Integer.valueOf(','), Integer.valueOf(']')},
        {VOID, CLASS, INT, STRING, BOOL},
        {VOID, CLASS, INT, STRING, BOOL, Integer.valueOf(')')},
        {Integer.valueOf('-'), Integer.valueOf('!')},
        {READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf(']'), Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {SEP, Integer.valueOf('}')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {AND},
        {WHILE, Integer.valueOf(')')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {INIT, Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%'), DEFAULT},
        {BREAK},
        {AND, Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, IF, Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, IDENTIFIER, NEW, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{'), Integer.valueOf('}')},
        {CONCAT},
        {LITERAL, NULL, Integer.valueOf('[')},
        {Integer.valueOf(','), Integer.valueOf(')')},
        {PRINT},
        {LITERAL, NULL, Integer.valueOf('[')},
        {FOR},
        {Integer.valueOf('{'), Integer.valueOf('(')},
        {LITERAL, NULL, Integer.valueOf('['), READ_INTEGER, READ_LINE, THIS, NEW, INSTANCEOF, Integer.valueOf('('), IDENTIFIER, COMPLEFT},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {FOREACH},
        {LITERAL, NULL, Integer.valueOf('['), Integer.valueOf(']')},
        {Integer.valueOf(':'), Integer.valueOf(']')},
        {Integer.valueOf('{')},
        {OR},
        {ELSE, PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, SEP, NEW, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {VOID, CLASS, INT, STRING, STATIC, BOOL, Integer.valueOf('}')},
        {Integer.valueOf(','), Integer.valueOf(')')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, CLASS},
        {SEALED, CLASS},
        {RETURN},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('{')},
        {INIT},
        {Integer.valueOf('('), Integer.valueOf(';')},
        {Integer.valueOf('('), Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {SEALED, CLASS},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {VOID, CLASS, INT, STRING, BOOL},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {IDENTIFIER, VOID, CLASS, INT, STRING, BOOL},
        {Integer.valueOf('='), Integer.valueOf(';'), Integer.valueOf(')')},
        {EXTENDS, Integer.valueOf('{')},
        {Integer.valueOf('+'), Integer.valueOf('-')},
        {Integer.valueOf('['), IDENTIFIER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, Integer.valueOf('}')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, Integer.valueOf(')')},
        {VOID, CLASS, INT, STRING, BOOL},
        {EQUAL, NOT_EQUAL, Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';')},
        {VOID, CLASS, INT, STRING, BOOL, Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, VAR, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), READ_INTEGER, IF, WHILE, FOR, RETURN, PRINT, BREAK, SCOPY, FOREACH, Integer.valueOf('{')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, VAR, Integer.valueOf(';'), Integer.valueOf(')')},
        {INT, VOID, BOOL, STRING, CLASS},
        {WHILE},
        {OR, Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), IF, Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {LESS_EQUAL, GREATER_EQUAL, Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, Integer.valueOf(';')},
        {Integer.valueOf('(')},
        {SCOPY},
        {Integer.valueOf('*'), Integer.valueOf('/'), Integer.valueOf('%'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('['), Integer.valueOf('.'), Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('-'), Integer.valueOf('!'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {SEALED, CLASS, eof, eos},
        {LESS_EQUAL, GREATER_EQUAL, Integer.valueOf('<'), Integer.valueOf('>')},
        {STATIC, VOID, CLASS, INT, STRING, BOOL},
    };
    
    /**
      * Get begin lookahead tokens for `symbol`.
      *
      * @param symbol the non-terminal.
      * @return its begin lookahead tokens.
      */
        
    public Set<Integer> beginSet(int symbol) {
        return begin.get(symbol - 296);
    }
    
    /* follow set */
    private ArrayList<Set<Integer>> follow = new ArrayList<Set<Integer>>();
    private final Integer[][] followRaw = {
        {Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, SEP, NEW, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, COMPLEFT, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {COMPRIGHT},
        {SEP, Integer.valueOf('}')},
        {IN},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf(']')},
        {Integer.valueOf(')')},
        {Integer.valueOf(')')},
        {READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, IF, Integer.valueOf(';')},
        {Integer.valueOf('}')},
        {Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf(')')},
        {LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(';')},
        {Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, IF, Integer.valueOf(';')},
        {Integer.valueOf('}')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(')')},
        {Integer.valueOf(';')},
        {Integer.valueOf(']')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, SEP, NEW, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, COMPLEFT, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, SEP, NEW, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, COMPLEFT, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), IF, Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, SEP, NEW, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, COMPLEFT, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(']')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, SEP, NEW, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, COMPLEFT, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, SEP, NEW, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, COMPLEFT, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';')},
        {Integer.valueOf('}')},
        {Integer.valueOf(')')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {SEALED, CLASS, eof, eos},
        {Integer.valueOf(';')},
        {Integer.valueOf(')')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, SEP, NEW, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, STATIC, COMPLEFT, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {VOID, CLASS, INT, Integer.valueOf('}'), STRING, STATIC, BOOL},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {eof, eos},
        {Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), IF, Integer.valueOf(';')},
        {IDENTIFIER},
        {LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(';'), Integer.valueOf(')')},
        {Integer.valueOf('{')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {IDENTIFIER},
        {Integer.valueOf('}')},
        {Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';')},
        {Integer.valueOf(')')},
        {Integer.valueOf(';'), Integer.valueOf(','), Integer.valueOf(')')},
        {Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, SEP, NEW, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, COMPLEFT, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(';'), Integer.valueOf(')')},
        {Integer.valueOf('['), IDENTIFIER},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, SEP, NEW, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, COMPLEFT, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), IF, Integer.valueOf(';')},
        {Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';')},
        {Integer.valueOf(']'), FOR, COMPRIGHT, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, AND, IF, Integer.valueOf(';')},
        {Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, SEP, NEW, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, COMPLEFT, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(';')},
        {LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, COMPRIGHT, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, INIT, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), IF, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {eof, eos},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, COMPLEFT, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {VOID, CLASS, INT, Integer.valueOf('}'), STRING, STATIC, BOOL},
    };
    
    /**
      * Get follow set for `symbol`.
      *
      * @param symbol the non-terminal.
      * @return its follow set.
      */
        
    public Set<Integer> followSet(int symbol) {
        return follow.get(symbol - 296);
    }
    
    public Table() {
        for (int i = 0; i < 81; i++) {
            begin.add(new HashSet<>(Arrays.asList(beginRaw[i])));
            follow.add(new HashSet<>(Arrays.asList(followRaw[i])));
        }
    }
    
    /**
      * Predictive table `M` query function.
      * `query(A, a)` will return the corresponding term `M(A, a)`, i.e., the target production
      * for non-terminal `A` when the lookahead token is `a`.
      *
      * @param nonTerminal   the non-terminal.
      * @param lookahead     the lookahead symbol.
      * @return a pair `<id, right>` where `right` is the right-hand side of the target
      * production `nonTerminal -> right`, and `id` is the corresponding action id. To execute
      * such action, call `act(id, params)`.
      * If the corresponding term is undefined in the table, `null` will be returned.
      */
        
    public Map.Entry<Integer, List<Integer>> query(int nonTerminal, int lookahead) {
        switch (nonTerminal) {
            //# line 575
            case ExprT44: {
                switch (lookahead) {
                    case CONCAT:
                        return new AbstractMap.SimpleEntry<>(0, Arrays.asList(Oper44, Expr44, ExprT44));
                    case ']':
                    case FOR:
                    case COMPRIGHT:
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case '=':
                    case OR:
                    case AND:
                    case IF:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 49
            case VariableDef: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(2, Arrays.asList(Variable, Integer.valueOf(';')));
                    default: return null;
                }
            }
            //# line 662
            case ExprT5: {
                switch (lookahead) {
                    case '+':
                    case '-':
                        return new AbstractMap.SimpleEntry<>(3, Arrays.asList(Oper5, Expr6, ExprT5));
                    case LESS_EQUAL:
                    case ']':
                    case FOR:
                    case GREATER_EQUAL:
                    case COMPRIGHT:
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case CONCAT:
                    case INIT:
                    case '=':
                    case OR:
                    case AND:
                    case IF:
                    case ';':
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 851
            case Condition: {
                switch (lookahead) {
                    case IF:
                        return new AbstractMap.SimpleEntry<>(5, Arrays.asList(IF, Expr));
                    case COMPRIGHT:
                        return new AbstractMap.SimpleEntry<>(6, Arrays.asList());
                    default: return null;
                }
            }
            //# line 331
            case Guard: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(7, Arrays.asList(Expr, Integer.valueOf(':'), Stmt));
                    default: return null;
                }
            }
            //# line 286
            case BoundVariable: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(8, Arrays.asList(Type, IDENTIFIER));
                    case VAR:
                        return new AbstractMap.SimpleEntry<>(9, Arrays.asList(VAR, IDENTIFIER));
                    default: return null;
                }
            }
            //# line 375
            case Oper3: {
                switch (lookahead) {
                    case EQUAL:
                        return new AbstractMap.SimpleEntry<>(10, Arrays.asList(EQUAL));
                    case NOT_EQUAL:
                        return new AbstractMap.SimpleEntry<>(11, Arrays.asList(NOT_EQUAL));
                    default: return null;
                }
            }
            //# line 435
            case Oper6: {
                switch (lookahead) {
                    case '*':
                        return new AbstractMap.SimpleEntry<>(12, Arrays.asList(Integer.valueOf('*')));
                    case '/':
                        return new AbstractMap.SimpleEntry<>(13, Arrays.asList(Integer.valueOf('/')));
                    case '%':
                        return new AbstractMap.SimpleEntry<>(14, Arrays.asList(Integer.valueOf('%')));
                    default: return null;
                }
            }
            //# line 931
            case SubConstantList: {
                switch (lookahead) {
                    case ',':
                        return new AbstractMap.SimpleEntry<>(15, Arrays.asList(Integer.valueOf(','), Constant, SubConstantList));
                    case ']':
                        return new AbstractMap.SimpleEntry<>(16, Arrays.asList());
                    default: return null;
                }
            }
            //# line 170
            case VariableList: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(17, Arrays.asList(Variable, SubVariableList));
                    default: return null;
                }
            }
            //# line 160
            case Formals: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(18, Arrays.asList(VariableList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(19, Arrays.asList());
                    default: return null;
                }
            }
            //# line 452
            case Oper7: {
                switch (lookahead) {
                    case '-':
                        return new AbstractMap.SimpleEntry<>(20, Arrays.asList(Integer.valueOf('-')));
                    case '!':
                        return new AbstractMap.SimpleEntry<>(21, Arrays.asList(Integer.valueOf('!')));
                    default: return null;
                }
            }
            //# line 718
            case Expr8: {
                switch (lookahead) {
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(22, Arrays.asList(Expr9, ExprT8));
                    default: return null;
                }
            }
            //# line 875
            case AfterSimpleTypeExpr: {
                switch (lookahead) {
                    case ']':
                        return new AbstractMap.SimpleEntry<>(23, Arrays.asList(Integer.valueOf(']'), Integer.valueOf('['), AfterSimpleTypeExpr));
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(24, Arrays.asList(Expr, Integer.valueOf(']')));
                    default: return null;
                }
            }
            //# line 500
            case Expr2: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(25, Arrays.asList(Expr3, ExprT2));
                    default: return null;
                }
            }
            //# line 323
            case SubGuardList: {
                switch (lookahead) {
                    case SEP:
                        return new AbstractMap.SimpleEntry<>(26, Arrays.asList(SEP, Guard, SubGuardList));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 592
            case Expr44: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(28, Arrays.asList(Expr444, ExprT444));
                    default: return null;
                }
            }
            //# line 368
            case Oper2: {
                switch (lookahead) {
                    case AND:
                        return new AbstractMap.SimpleEntry<>(29, Arrays.asList(AND));
                    default: return null;
                }
            }
            //# line 296
            case WhileCondition: {
                switch (lookahead) {
                    case WHILE:
                        return new AbstractMap.SimpleEntry<>(30, Arrays.asList(WHILE, Expr));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(31, Arrays.asList());
                    default: return null;
                }
            }
            //# line 679
            case Expr6: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(32, Arrays.asList(Expr7, ExprT6));
                    default: return null;
                }
            }
            //# line 604
            case ExprT444: {
                switch (lookahead) {
                    case INIT:
                        return new AbstractMap.SimpleEntry<>(33, Arrays.asList(Oper444, Expr444, ExprT444));
                    case ']':
                    case FOR:
                    case COMPRIGHT:
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case CONCAT:
                    case '=':
                    case OR:
                    case AND:
                    case IF:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 777
            case ExprT9: {
                switch (lookahead) {
                    case '/':
                    case LESS_EQUAL:
                    case ']':
                    case FOR:
                    case GREATER_EQUAL:
                    case COMPRIGHT:
                    case '.':
                    case '-':
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case CONCAT:
                    case INIT:
                    case '=':
                    case OR:
                    case '+':
                    case AND:
                    case '*':
                    case IF:
                    case ';':
                    case '<':
                    case '[':
                    case '>':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(35, Arrays.asList(ExprT8));
                    case DEFAULT:
                        return new AbstractMap.SimpleEntry<>(36, Arrays.asList(DEFAULT, Expr9));
                    default: return null;
                }
            }
            //# line 986
            case BreakStmt: {
                switch (lookahead) {
                    case BREAK:
                        return new AbstractMap.SimpleEntry<>(37, Arrays.asList(BREAK));
                    default: return null;
                }
            }
            //# line 512
            case ExprT2: {
                switch (lookahead) {
                    case AND:
                        return new AbstractMap.SimpleEntry<>(38, Arrays.asList(Oper2, Expr3, ExprT2));
                    case ']':
                    case FOR:
                    case COMPRIGHT:
                    case ':':
                    case ')':
                    case ',':
                    case WHILE:
                    case '=':
                    case OR:
                    case IF:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 197
            case StmtList: {
                switch (lookahead) {
                    case PRINT:
                    case VOID:
                    case FOR:
                    case '!':
                    case FOREACH:
                    case '-':
                    case CLASS:
                    case READ_LINE:
                    case WHILE:
                    case RETURN:
                    case NULL:
                    case INT:
                    case SCOPY:
                    case IDENTIFIER:
                    case NEW:
                    case IF:
                    case VAR:
                    case THIS:
                    case INSTANCEOF:
                    case STRING:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case ';':
                    case '[':
                    case BOOL:
                    case BREAK:
                    case READ_INTEGER:
                    case '{':
                        return new AbstractMap.SimpleEntry<>(40, Arrays.asList(Stmt, StmtList));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 387
            case Oper44: {
                switch (lookahead) {
                    case CONCAT:
                        return new AbstractMap.SimpleEntry<>(42, Arrays.asList(CONCAT));
                    default: return null;
                }
            }
            //# line 899
            case Constant: {
                switch (lookahead) {
                    case LITERAL:
                        return new AbstractMap.SimpleEntry<>(43, Arrays.asList(LITERAL));
                    case NULL:
                        return new AbstractMap.SimpleEntry<>(44, Arrays.asList(NULL));
                    case '[':
                        return new AbstractMap.SimpleEntry<>(45, Arrays.asList(Integer.valueOf('['), ArrayConstant));
                    default: return null;
                }
            }
            //# line 180
            case SubVariableList: {
                switch (lookahead) {
                    case ',':
                        return new AbstractMap.SimpleEntry<>(46, Arrays.asList(Integer.valueOf(','), Variable, SubVariableList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 1018
            case PrintStmt: {
                switch (lookahead) {
                    case PRINT:
                        return new AbstractMap.SimpleEntry<>(48, Arrays.asList(PRINT, Integer.valueOf('('), ExprList, Integer.valueOf(')')));
                    default: return null;
                }
            }
            //# line 923
            case ConstantList: {
                switch (lookahead) {
                    case LITERAL:
                    case NULL:
                    case '[':
                        return new AbstractMap.SimpleEntry<>(49, Arrays.asList(Constant, SubConstantList));
                    default: return null;
                }
            }
            //# line 980
            case ForStmt: {
                switch (lookahead) {
                    case FOR:
                        return new AbstractMap.SimpleEntry<>(50, Arrays.asList(FOR, Integer.valueOf('('), SimpleStmt, Integer.valueOf(';'), Expr, Integer.valueOf(';'), SimpleStmt, Integer.valueOf(')'), Stmt));
                    default: return null;
                }
            }
            //# line 261
            case IfBegin: {
                switch (lookahead) {
                    case '{':
                        return new AbstractMap.SimpleEntry<>(51, Arrays.asList(GuardedStmt));
                    case '(':
                        return new AbstractMap.SimpleEntry<>(52, Arrays.asList(IfStmt));
                    default: return null;
                }
            }
            //# line 802
            case Expr9: {
                switch (lookahead) {
                    case LITERAL:
                    case NULL:
                    case '[':
                        return new AbstractMap.SimpleEntry<>(53, Arrays.asList(Constant));
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(54, Arrays.asList(READ_INTEGER, Integer.valueOf('('), Integer.valueOf(')')));
                    case READ_LINE:
                        return new AbstractMap.SimpleEntry<>(55, Arrays.asList(READ_LINE, Integer.valueOf('('), Integer.valueOf(')')));
                    case THIS:
                        return new AbstractMap.SimpleEntry<>(56, Arrays.asList(THIS));
                    case NEW:
                        return new AbstractMap.SimpleEntry<>(57, Arrays.asList(NEW, AfterNewExpr));
                    case INSTANCEOF:
                        return new AbstractMap.SimpleEntry<>(58, Arrays.asList(INSTANCEOF, Integer.valueOf('('), Expr, Integer.valueOf(','), IDENTIFIER, Integer.valueOf(')')));
                    case '(':
                        return new AbstractMap.SimpleEntry<>(59, Arrays.asList(Integer.valueOf('('), AfterParenExpr));
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(60, Arrays.asList(IDENTIFIER, AfterIdentExpr));
                    case COMPLEFT:
                        return new AbstractMap.SimpleEntry<>(61, Arrays.asList(COMPLEFT, Expr, FOR, IDENTIFIER, IN, Expr, Condition, COMPRIGHT));
                    default: return null;
                }
            }
            //# line 471
            case Expr1: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(62, Arrays.asList(Expr2, ExprT1));
                    default: return null;
                }
            }
            //# line 271
            case ForeachStmt: {
                switch (lookahead) {
                    case FOREACH:
                        return new AbstractMap.SimpleEntry<>(63, Arrays.asList(FOREACH, Integer.valueOf('('), BoundVariable, IN, Expr, WhileCondition, Integer.valueOf(')'), Stmt));
                    default: return null;
                }
            }
            //# line 913
            case ArrayConstant: {
                switch (lookahead) {
                    case LITERAL:
                    case NULL:
                    case '[':
                        return new AbstractMap.SimpleEntry<>(64, Arrays.asList(ConstantList, Integer.valueOf(']')));
                    case ']':
                        return new AbstractMap.SimpleEntry<>(65, Arrays.asList(Integer.valueOf(']')));
                    default: return null;
                }
            }
            //# line 787
            case AfterExpr: {
                switch (lookahead) {
                    case ':':
                        return new AbstractMap.SimpleEntry<>(66, Arrays.asList(Integer.valueOf(':'), Expr));
                    case ']':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 306
            case GuardedStmt: {
                switch (lookahead) {
                    case '{':
                        return new AbstractMap.SimpleEntry<>(68, Arrays.asList(Integer.valueOf('{'), GuardList, Integer.valueOf('}')));
                    default: return null;
                }
            }
            //# line 361
            case Oper1: {
                switch (lookahead) {
                    case OR:
                        return new AbstractMap.SimpleEntry<>(69, Arrays.asList(OR));
                    default: return null;
                }
            }
            //# line 998
            case ElseClause: {
                switch (lookahead) {
                    case ELSE:
                        return new AbstractMap.SimpleEntry<>(70, Arrays.asList(ELSE, Stmt));
                    case PRINT:
                    case VOID:
                    case FOR:
                    case '!':
                    case FOREACH:
                    case '-':
                    case CLASS:
                    case READ_LINE:
                    case WHILE:
                    case RETURN:
                    case NULL:
                    case INT:
                    case SCOPY:
                    case '}':
                    case IDENTIFIER:
                    case SEP:
                    case NEW:
                    case IF:
                    case VAR:
                    case THIS:
                    case INSTANCEOF:
                    case STRING:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case ';':
                    case '[':
                    case BOOL:
                    case BREAK:
                    case READ_INTEGER:
                    case '{':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 621
            case Expr444: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(72, Arrays.asList(Expr5, ExprT4));
                    default: return null;
                }
            }
            //# line 120
            case FieldList: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case STATIC:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(73, Arrays.asList(Field, FieldList));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(74, Arrays.asList());
                    default: return null;
                }
            }
            //# line 961
            case SubExprList: {
                switch (lookahead) {
                    case ',':
                        return new AbstractMap.SimpleEntry<>(75, Arrays.asList(Integer.valueOf(','), Expr, SubExprList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(76, Arrays.asList());
                    default: return null;
                }
            }
            //# line 887
            case AfterParenExpr: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(77, Arrays.asList(Expr, Integer.valueOf(')')));
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(78, Arrays.asList(CLASS, IDENTIFIER, Integer.valueOf(')'), Expr9));
                    default: return null;
                }
            }
            //# line 102
            case ClassDef: {
                switch (lookahead) {
                    case SEALED:
                        return new AbstractMap.SimpleEntry<>(79, Arrays.asList(SEALED, CLASS, IDENTIFIER, ExtendsClause, Integer.valueOf('{'), FieldList, Integer.valueOf('}')));
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(80, Arrays.asList(CLASS, IDENTIFIER, ExtendsClause, Integer.valueOf('{'), FieldList, Integer.valueOf('}')));
                    default: return null;
                }
            }
            //# line 1005
            case ReturnStmt: {
                switch (lookahead) {
                    case RETURN:
                        return new AbstractMap.SimpleEntry<>(81, Arrays.asList(RETURN, ReturnExpr));
                    default: return null;
                }
            }
            //# line 953
            case ExprList: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(82, Arrays.asList(Expr, SubExprList));
                    default: return null;
                }
            }
            //# line 191
            case StmtBlock: {
                switch (lookahead) {
                    case '{':
                        return new AbstractMap.SimpleEntry<>(83, Arrays.asList(Integer.valueOf('{'), StmtList, Integer.valueOf('}')));
                    default: return null;
                }
            }
            //# line 394
            case Oper444: {
                switch (lookahead) {
                    case INIT:
                        return new AbstractMap.SimpleEntry<>(84, Arrays.asList(INIT));
                    default: return null;
                }
            }
            //# line 152
            case FunctionField: {
                switch (lookahead) {
                    case '(':
                        return new AbstractMap.SimpleEntry<>(85, Arrays.asList(Integer.valueOf('('), Formals, Integer.valueOf(')'), StmtBlock));
                    case ';':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList(Integer.valueOf(';')));
                    default: return null;
                }
            }
            //# line 795
            case AfterIdentExpr: {
                switch (lookahead) {
                    case '(':
                        return new AbstractMap.SimpleEntry<>(87, Arrays.asList(Integer.valueOf('('), Actuals, Integer.valueOf(')')));
                    case '/':
                    case LESS_EQUAL:
                    case ']':
                    case FOR:
                    case GREATER_EQUAL:
                    case COMPRIGHT:
                    case '.':
                    case '-':
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case CONCAT:
                    case INIT:
                    case '=':
                    case OR:
                    case '+':
                    case AND:
                    case '*':
                    case IF:
                    case ';':
                    case '<':
                    case '[':
                    case '>':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 27
            case Program: {
                switch (lookahead) {
                    case SEALED:
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(89, Arrays.asList(ClassDef, ClassList));
                    default: return null;
                }
            }
            //# line 465
            case Expr: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(90, Arrays.asList(Expr1));
                    default: return null;
                }
            }
            //# line 83
            case Type: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(91, Arrays.asList(SimpleType, ArrayType));
                    default: return null;
                }
            }
            //# line 650
            case Expr5: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(92, Arrays.asList(Expr6, ExprT5));
                    default: return null;
                }
            }
            //# line 861
            case AfterNewExpr: {
                switch (lookahead) {
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(93, Arrays.asList(IDENTIFIER, Integer.valueOf('('), Integer.valueOf(')')));
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(94, Arrays.asList(SimpleType, Integer.valueOf('['), AfterSimpleTypeExpr));
                    default: return null;
                }
            }
            //# line 352
            case Assignment: {
                switch (lookahead) {
                    case '=':
                        return new AbstractMap.SimpleEntry<>(95, Arrays.asList(Integer.valueOf('='), Expr));
                    case ';':
                    case ')':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 113
            case ExtendsClause: {
                switch (lookahead) {
                    case EXTENDS:
                        return new AbstractMap.SimpleEntry<>(97, Arrays.asList(EXTENDS, IDENTIFIER));
                    case '{':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 423
            case Oper5: {
                switch (lookahead) {
                    case '+':
                        return new AbstractMap.SimpleEntry<>(99, Arrays.asList(Integer.valueOf('+')));
                    case '-':
                        return new AbstractMap.SimpleEntry<>(100, Arrays.asList(Integer.valueOf('-')));
                    default: return null;
                }
            }
            //# line 92
            case ArrayType: {
                switch (lookahead) {
                    case '[':
                        return new AbstractMap.SimpleEntry<>(101, Arrays.asList(Integer.valueOf('['), Integer.valueOf(']'), ArrayType));
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(102, Arrays.asList());
                    default: return null;
                }
            }
            //# line 312
            case GuardList: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(103, Arrays.asList(Guard, SubGuardList));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(104, Arrays.asList());
                    default: return null;
                }
            }
            //# line 529
            case Expr3: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(105, Arrays.asList(Expr4, ExprT3));
                    default: return null;
                }
            }
            //# line 943
            case Actuals: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(106, Arrays.asList(ExprList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(107, Arrays.asList());
                    default: return null;
                }
            }
            //# line 55
            case Variable: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(108, Arrays.asList(Type, IDENTIFIER));
                    default: return null;
                }
            }
            //# line 541
            case ExprT3: {
                switch (lookahead) {
                    case EQUAL:
                    case NOT_EQUAL:
                        return new AbstractMap.SimpleEntry<>(109, Arrays.asList(Oper3, Expr4, ExprT3));
                    case ']':
                    case FOR:
                    case COMPRIGHT:
                    case ':':
                    case ')':
                    case ',':
                    case WHILE:
                    case '=':
                    case OR:
                    case AND:
                    case IF:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 205
            case Stmt: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(111, Arrays.asList(VariableDef));
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case VAR:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case ';':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(112, Arrays.asList(SimpleStmt, Integer.valueOf(';')));
                    case IF:
                        return new AbstractMap.SimpleEntry<>(113, Arrays.asList(IF, IfBegin));
                    case WHILE:
                        return new AbstractMap.SimpleEntry<>(114, Arrays.asList(WhileStmt));
                    case FOR:
                        return new AbstractMap.SimpleEntry<>(115, Arrays.asList(ForStmt));
                    case RETURN:
                        return new AbstractMap.SimpleEntry<>(116, Arrays.asList(ReturnStmt, Integer.valueOf(';')));
                    case PRINT:
                        return new AbstractMap.SimpleEntry<>(117, Arrays.asList(PrintStmt, Integer.valueOf(';')));
                    case BREAK:
                        return new AbstractMap.SimpleEntry<>(118, Arrays.asList(BreakStmt, Integer.valueOf(';')));
                    case SCOPY:
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList(OCStmt, Integer.valueOf(';')));
                    case FOREACH:
                        return new AbstractMap.SimpleEntry<>(120, Arrays.asList(ForeachStmt));
                    case '{':
                        return new AbstractMap.SimpleEntry<>(121, Arrays.asList(StmtBlock));
                    default: return null;
                }
            }
            //# line 337
            case SimpleStmt: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(122, Arrays.asList(Expr, Assignment));
                    case VAR:
                        return new AbstractMap.SimpleEntry<>(123, Arrays.asList(VAR, IDENTIFIER, Integer.valueOf('='), Expr));
                    case ';':
                    case ')':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 61
            case SimpleType: {
                switch (lookahead) {
                    case INT:
                        return new AbstractMap.SimpleEntry<>(125, Arrays.asList(INT));
                    case VOID:
                        return new AbstractMap.SimpleEntry<>(126, Arrays.asList(VOID));
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(127, Arrays.asList(BOOL));
                    case STRING:
                        return new AbstractMap.SimpleEntry<>(128, Arrays.asList(STRING));
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(129, Arrays.asList(CLASS, IDENTIFIER));
                    default: return null;
                }
            }
            //# line 974
            case WhileStmt: {
                switch (lookahead) {
                    case WHILE:
                        return new AbstractMap.SimpleEntry<>(130, Arrays.asList(WHILE, Integer.valueOf('('), Expr, Integer.valueOf(')'), Stmt));
                    default: return null;
                }
            }
            //# line 483
            case ExprT1: {
                switch (lookahead) {
                    case OR:
                        return new AbstractMap.SimpleEntry<>(131, Arrays.asList(Oper1, Expr2, ExprT1));
                    case ']':
                    case FOR:
                    case COMPRIGHT:
                    case ':':
                    case ')':
                    case ',':
                    case WHILE:
                    case '=':
                    case IF:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 558
            case Expr4: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(133, Arrays.asList(Expr44, ExprT44));
                    default: return null;
                }
            }
            //# line 633
            case ExprT4: {
                switch (lookahead) {
                    case LESS_EQUAL:
                    case GREATER_EQUAL:
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(134, Arrays.asList(Oper4, Expr5, ExprT4));
                    case ']':
                    case FOR:
                    case COMPRIGHT:
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case CONCAT:
                    case INIT:
                    case '=':
                    case OR:
                    case AND:
                    case IF:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 1011
            case ReturnExpr: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList(Expr));
                    case ';':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 992
            case IfStmt: {
                switch (lookahead) {
                    case '(':
                        return new AbstractMap.SimpleEntry<>(138, Arrays.asList(Integer.valueOf('('), Expr, Integer.valueOf(')'), Stmt, ElseClause));
                    default: return null;
                }
            }
            //# line 255
            case OCStmt: {
                switch (lookahead) {
                    case SCOPY:
                        return new AbstractMap.SimpleEntry<>(139, Arrays.asList(SCOPY, Integer.valueOf('('), IDENTIFIER, Integer.valueOf(','), Expr, Integer.valueOf(')')));
                    default: return null;
                }
            }
            //# line 691
            case ExprT6: {
                switch (lookahead) {
                    case '*':
                    case '/':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(140, Arrays.asList(Oper6, Expr7, ExprT6));
                    case LESS_EQUAL:
                    case ']':
                    case FOR:
                    case GREATER_EQUAL:
                    case COMPRIGHT:
                    case '-':
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case CONCAT:
                    case INIT:
                    case '=':
                    case OR:
                    case '+':
                    case AND:
                    case IF:
                    case ';':
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 743
            case ExprT8: {
                switch (lookahead) {
                    case '[':
                        return new AbstractMap.SimpleEntry<>(142, Arrays.asList(Integer.valueOf('['), Expr, AfterExpr, Integer.valueOf(']'), ExprT9));
                    case '.':
                        return new AbstractMap.SimpleEntry<>(143, Arrays.asList(Integer.valueOf('.'), IDENTIFIER, AfterIdentExpr, ExprT8));
                    case '/':
                    case LESS_EQUAL:
                    case ']':
                    case FOR:
                    case GREATER_EQUAL:
                    case COMPRIGHT:
                    case '-':
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case CONCAT:
                    case INIT:
                    case '=':
                    case OR:
                    case '+':
                    case AND:
                    case '*':
                    case IF:
                    case ';':
                    case '<':
                    case '>':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 708
            case Expr7: {
                switch (lookahead) {
                    case '-':
                    case '!':
                        return new AbstractMap.SimpleEntry<>(145, Arrays.asList(Oper7, Expr8));
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case COMPLEFT:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList(Expr8));
                    default: return null;
                }
            }
            //# line 38
            case ClassList: {
                switch (lookahead) {
                    case SEALED:
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(147, Arrays.asList(ClassDef, ClassList));
                    case eof:
                    case eos:
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList());
                    default: return null;
                }
            }
            //# line 401
            case Oper4: {
                switch (lookahead) {
                    case LESS_EQUAL:
                        return new AbstractMap.SimpleEntry<>(149, Arrays.asList(LESS_EQUAL));
                    case GREATER_EQUAL:
                        return new AbstractMap.SimpleEntry<>(150, Arrays.asList(GREATER_EQUAL));
                    case '<':
                        return new AbstractMap.SimpleEntry<>(151, Arrays.asList(Integer.valueOf('<')));
                    case '>':
                        return new AbstractMap.SimpleEntry<>(152, Arrays.asList(Integer.valueOf('>')));
                    default: return null;
                }
            }
            //# line 136
            case Field: {
                switch (lookahead) {
                    case STATIC:
                        return new AbstractMap.SimpleEntry<>(153, Arrays.asList(STATIC, Type, IDENTIFIER, Integer.valueOf('('), Formals, Integer.valueOf(')'), StmtBlock));
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(154, Arrays.asList(Type, IDENTIFIER, FunctionField));
                    default: return null;
                }
            }
            default: return null;
        }
    }
    
    /**
      * Execute some user-defined semantic action on the specification file.
      * Note that `$$ = params[0], $1 = params[1], ...`. Nothing will be returned, so please
      * do not forget to store the parsed AST result in `params[0]`.
      *
      * @param id      the action id.
      * @param params  parameter array.
      */
        
    public void act(int id, SemValue[] params) {
        switch (id) {
            case 0: {
                //# line 576
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 1: {
                /* no action */
                return;
            }
            case 2: {
                //# line 50
                params[0].vdef = params[1].vdef;
                return;
            }
            case 3: {
                //# line 663
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 4: {
                /* no action */
                return;
            }
            case 5: {
                //# line 852
                params[0].expr = params[2].expr;
                return;
            }
            case 6: {
                //# line 856
                params[0].expr = null;
                return;
            }
            case 7: {
                //# line 332
                params[0].stmt = new Tree.Guard(params[1].expr, params[3].stmt, params[1].loc);
                return;
            }
            case 8: {
                //# line 287
                params[0].vdef = new Tree.VarDef(params[2].ident, params[1].type, params[2].loc);
                return;
            }
            case 9: {
                //# line 291
                params[0].lvalue = new Tree.Ident(true, null, params[2].ident, params[2].loc);
                return;
            }
            case 10: {
                //# line 376
                params[0].counter = Tree.EQ;
                params[0].loc = params[1].loc;
                return;
            }
            case 11: {
                //# line 381
                params[0].counter = Tree.NE;
                params[0].loc = params[1].loc;
                return;
            }
            case 12: {
                //# line 436
                params[0].counter = Tree.MUL;
                params[0].loc = params[1].loc;
                return;
            }
            case 13: {
                //# line 441
                params[0].counter = Tree.DIV;
                params[0].loc = params[1].loc;
                return;
            }
            case 14: {
                //# line 446
                params[0].counter = Tree.MOD;
                params[0].loc = params[1].loc;
                return;
            }
            case 15: {
                //# line 932
                params[0].elist = new ArrayList<Tree.Expr>();
                params[0].elist.add(params[2].expr);
                params[0].elist.addAll(params[3].elist);
                return;
            }
            case 16: {
                //# line 938
                params[0].elist = new ArrayList<Tree.Expr>();
                return;
            }
            case 17: {
                //# line 171
                params[0].vlist = new ArrayList<VarDef>();
                params[0].vlist.add(params[1].vdef);
                if (params[2].vlist != null) {
                    params[0].vlist.addAll(params[2].vlist);
                }
                return;
            }
            case 18: {
                //# line 161
                params[0].vlist = params[1].vlist;
                return;
            }
            case 19: {
                //# line 165
                params[0].vlist = new ArrayList<VarDef>();
                return;
            }
            case 20: {
                //# line 453
                params[0].counter = Tree.NEG;
                params[0].loc = params[1].loc;
                return;
            }
            case 21: {
                //# line 458
                params[0].counter = Tree.NOT;
                params[0].loc = params[1].loc;
                return;
            }
            case 22: {
                //# line 719
                params[0].expr = params[1].expr;
                params[0].loc = params[1].loc;
                if (params[2].vec != null) {
                    for (SemValue v : params[2].vec) {
                        if (v.expr1 != null) {
                        	if (v.isDefault == false)
                        		params[0].expr = new Tree.Sliced(params[0].expr, v.expr, v.expr1, params[0].loc);
                        	else
                        		params[0].expr = params[0].expr = new Tree.Default(params[0].expr, v.expr, v.expr1, params[0].loc); 
                        } else if (v.expr != null) {
                            params[0].expr = new Tree.Indexed(params[0].expr, v.expr, params[0].loc);
                        } else if (v.elist != null) {
                            params[0].expr = new Tree.CallExpr(params[0].expr, v.ident, v.elist, v.loc);
                            params[0].loc = v.loc;
                        } else {
                            params[0].expr = new Tree.Ident(false, params[0].expr, v.ident, v.loc);
                            params[0].loc = v.loc;
                        }
                    }
                }
                return;
            }
            case 23: {
                //# line 876
                params[0].expr = params[3].expr;
                params[0].counter = 1 + params[3].counter;
                return;
            }
            case 24: {
                //# line 881
                params[0].expr = params[1].expr;
                params[0].counter = 0;
                return;
            }
            case 25: {
                //# line 501
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 26: {
                //# line 324
                params[0].slist.add(params[2].stmt);
                               params[0].slist.addAll(params[3].slist);
                return;
            }
            case 27: {
                /* no action */
                return;
            }
            case 28: {
                //# line 593
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 29: {
                //# line 369
                params[0].counter = Tree.AND;
                params[0].loc = params[1].loc;
                return;
            }
            case 30: {
                //# line 297
                params[0].expr = params[2].expr;
                return;
            }
            case 31: {
                //# line 301
                params[0].expr = null;
                return;
            }
            case 32: {
                //# line 680
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 33: {
                //# line 605
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 34: {
                /* no action */
                return;
            }
            case 35: {
                //# line 778
                params[0].vec = params[1].vec;
                return;
            }
            case 36: {
                //# line 782
                params[0].expr1 = params[2].expr;
                return;
            }
            case 37: {
                //# line 987
                params[0].stmt = new Tree.Break(params[1].loc);
                return;
            }
            case 38: {
                //# line 513
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 39: {
                /* no action */
                return;
            }
            case 40: {
                //# line 198
                params[0].slist.add(params[1].stmt);
                params[0].slist.addAll(params[2].slist);
                return;
            }
            case 41: {
                /* no action */
                return;
            }
            case 42: {
                //# line 388
                params[0].counter = Tree.CONCAT;
                params[0].loc = params[1].loc;
                return;
            }
            case 43: {
                //# line 900
                params[0].expr = new Tree.Literal(params[1].typeTag, params[1].literal, params[1].loc);
                return;
            }
            case 44: {
                //# line 904
                params[0].expr = new Null(params[1].loc);
                return;
            }
            case 45: {
                //# line 908
                params[0].expr = params[2].expr;
                return;
            }
            case 46: {
                //# line 181
                params[0].vlist = new ArrayList<VarDef>();
                params[0].vlist.add(params[2].vdef);
                if (params[3].vlist != null) {
                    params[0].vlist.addAll(params[3].vlist);
                }
                return;
            }
            case 47: {
                /* no action */
                return;
            }
            case 48: {
                //# line 1019
                params[0].stmt = new Tree.Print(params[3].elist, params[1].loc);
                return;
            }
            case 49: {
                //# line 924
                params[0].elist = new ArrayList<Tree.Expr>();
                params[0].elist.add(params[1].expr);
                params[0].elist.addAll(params[2].elist);
                return;
            }
            case 50: {
                //# line 981
                params[0].stmt = new Tree.ForLoop(params[3].stmt, params[5].expr, params[7].stmt, params[9].stmt, params[1].loc);
                return;
            }
            case 51: {
                //# line 262
                params[0].stmt = params[1].stmt;
                return;
            }
            case 52: {
                //# line 266
                params[0].stmt = params[1].stmt;
                return;
            }
            case 53: {
                //# line 803
                params[0].expr = params[1].expr;
                return;
            }
            case 54: {
                //# line 807
                params[0].expr = new Tree.ReadIntExpr(params[1].loc);
                return;
            }
            case 55: {
                //# line 811
                params[0].expr = new Tree.ReadLineExpr(params[1].loc);
                return;
            }
            case 56: {
                //# line 815
                params[0].expr = new Tree.ThisExpr(params[1].loc);
                return;
            }
            case 57: {
                //# line 819
                if (params[2].ident != null) {
                    params[0].expr = new Tree.NewClass(params[2].ident, params[1].loc);
                } else {
                    params[0].expr = new Tree.NewArray(params[2].type, params[2].expr, params[1].loc);
                }
                return;
            }
            case 58: {
                //# line 827
                params[0].expr = new Tree.TypeTest(params[3].expr, params[5].ident, params[1].loc);
                return;
            }
            case 59: {
                //# line 831
                params[0].expr = params[2].expr;
                return;
            }
            case 60: {
                //# line 835
                if (params[2].elist != null) {
                    params[0].expr = new Tree.CallExpr(null, params[1].ident, params[2].elist, params[1].loc);
                } else {
                    params[0].expr = new Tree.Ident(false, null, params[1].ident, params[1].loc);
                }
                return;
            }
            case 61: {
                //# line 843
                if (params[7].expr != null)
                	params[0].expr = new Tree.Comprehension(params[2].expr, params[4].ident, params[6].expr, params[7].expr, params[1].loc);
                else
                	params[0].expr = new Tree.Comprehension(params[2].expr, params[4].ident, params[6].expr, new Tree.Literal(Tree.BOOL, true, params[8].loc), params[1].loc);
                return;
            }
            case 62: {
                //# line 472
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 63: {
                //# line 272
                if (params[3].vdef == null)
                	if (params[6].expr != null)
                		params[0].stmt = new Tree.ForEach(null, params[3].lvalue, params[5].expr, params[6].expr, params[8].stmt, params[1].loc);
                	else
                		params[0].stmt = new Tree.ForEach(null, params[3].lvalue, params[5].expr, new Tree.Literal(Tree.BOOL, true,params[7].loc), params[8].stmt, params[1].loc);
                else
                	if (params[6].expr != null)
                		params[0].stmt = new Tree.ForEach(params[3].vdef, null, params[5].expr, params[6].expr, params[8].stmt, params[1].loc);
                	else
                		params[0].stmt = new Tree.ForEach(params[3].vdef, null, params[5].expr, new Tree.Literal(Tree.BOOL, true, params[7].loc), params[8].stmt, params[1].loc);	
                return;
            }
            case 64: {
                //# line 914
                params[0].expr = new Tree.ArrayConst(params[1].elist, params[1].loc);
                return;
            }
            case 65: {
                //# line 918
                params[0].expr = new Tree.ArrayConst(null, params[1].loc);
                return;
            }
            case 66: {
                //# line 788
                params[0].expr1 = params[2].expr;
                return;
            }
            case 67: {
                /* no action */
                return;
            }
            case 68: {
                //# line 307
                params[0].stmt = new Tree.GuardStmt(params[2].slist, params[1].loc);                     
                return;
            }
            case 69: {
                //# line 362
                params[0].counter = Tree.OR;
                params[0].loc = params[1].loc;
                return;
            }
            case 70: {
                //# line 999
                params[0].stmt = params[2].stmt;
                return;
            }
            case 71: {
                /* no action */
                return;
            }
            case 72: {
                //# line 622
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 73: {
                //# line 121
                params[0].flist = new ArrayList<Tree>();
                if (params[1].vdef != null) {
                    params[0].flist.add(params[1].vdef);
                } else {
                    params[0].flist.add(params[1].fdef);
                }
                params[0].flist.addAll(params[2].flist);
                return;
            }
            case 74: {
                //# line 131
                params[0].flist = new ArrayList<Tree>();
                return;
            }
            case 75: {
                //# line 962
                params[0].elist = new ArrayList<Tree.Expr>();
                params[0].elist.add(params[2].expr);
                params[0].elist.addAll(params[3].elist);
                return;
            }
            case 76: {
                //# line 968
                params[0].elist = new ArrayList<Tree.Expr>();
                return;
            }
            case 77: {
                //# line 888
                params[0].expr = params[1].expr;
                return;
            }
            case 78: {
                //# line 892
                params[0].expr = new Tree.TypeCast(params[2].ident, params[4].expr, params[4].loc);
                return;
            }
            case 79: {
                //# line 103
                params[0].cdef = new Tree.ClassDef(true, params[3].ident, params[4].ident, params[6].flist, params[2].loc);
                return;
            }
            case 80: {
                //# line 108
                params[0].cdef = new Tree.ClassDef(false, params[2].ident, params[3].ident, params[5].flist, params[1].loc);
                return;
            }
            case 81: {
                //# line 1006
                params[0].stmt = new Tree.Return(params[2].expr, params[1].loc);
                return;
            }
            case 82: {
                //# line 954
                params[0].elist = new ArrayList<Tree.Expr>();
                params[0].elist.add(params[1].expr);
                params[0].elist.addAll(params[2].elist);
                return;
            }
            case 83: {
                //# line 192
                params[0].stmt = new Tree.Block(params[2].slist, params[1].loc);
                return;
            }
            case 84: {
                //# line 395
                params[0].counter = Tree.INIT;
                params[0].loc = params[1].loc;
                return;
            }
            case 85: {
                //# line 153
                params[0].vlist = params[2].vlist;
                params[0].stmt = params[4].stmt;
                return;
            }
            case 86: {
                /* no action */
                return;
            }
            case 87: {
                //# line 796
                params[0].elist = params[2].elist;
                return;
            }
            case 88: {
                /* no action */
                return;
            }
            case 89: {
                //# line 28
                params[0].clist = new ArrayList<ClassDef>();
                params[0].clist.add(params[1].cdef);
                if (params[2].clist != null) {
                    params[0].clist.addAll(params[2].clist);
                }
                params[0].prog = new Tree.TopLevel(params[0].clist, params[0].loc);
                return;
            }
            case 90: {
                //# line 466
                params[0].expr = params[1].expr;
                return;
            }
            case 91: {
                //# line 84
                params[0].type = params[1].type;
                for (int i = 0; i < params[2].counter; ++i) {
                    params[0].type = new Tree.TypeArray(params[0].type, params[1].loc);
                }
                return;
            }
            case 92: {
                //# line 651
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 93: {
                //# line 862
                params[0].ident = params[1].ident;
                return;
            }
            case 94: {
                //# line 866
                params[0].type = params[1].type;
                for (int i = 0; i < params[3].counter; ++i) {
                    params[0].type = new Tree.TypeArray(params[0].type, params[1].loc);
                }
                params[0].expr = params[3].expr;
                return;
            }
            case 95: {
                //# line 353
                params[0].loc = params[1].loc;
                params[0].expr = params[2].expr;
                return;
            }
            case 96: {
                /* no action */
                return;
            }
            case 97: {
                //# line 114
                params[0].ident = params[2].ident;
                return;
            }
            case 98: {
                /* no action */
                return;
            }
            case 99: {
                //# line 424
                params[0].counter = Tree.PLUS;
                params[0].loc = params[1].loc;
                return;
            }
            case 100: {
                //# line 429
                params[0].counter = Tree.MINUS;
                params[0].loc = params[1].loc;
                return;
            }
            case 101: {
                //# line 93
                params[0].counter = 1 + params[3].counter;
                return;
            }
            case 102: {
                //# line 97
                params[0].counter = 0;
                return;
            }
            case 103: {
                //# line 313
                params[0].slist.add(params[1].stmt);
                params[0].slist.addAll(params[2].slist);
                return;
            }
            case 104: {
                //# line 318
                params[0].slist = null;
                return;
            }
            case 105: {
                //# line 530
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 106: {
                //# line 944
                params[0].elist = params[1].elist;
                return;
            }
            case 107: {
                //# line 948
                params[0].elist = new ArrayList<Tree.Expr>();
                return;
            }
            case 108: {
                //# line 56
                params[0].vdef = new Tree.VarDef(params[2].ident, params[1].type, params[2].loc);
                return;
            }
            case 109: {
                //# line 542
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 110: {
                /* no action */
                return;
            }
            case 111: {
                //# line 206
                params[0].stmt = params[1].vdef;
                return;
            }
            case 112: {
                //# line 210
                if (params[1].stmt == null) {
                    params[0].stmt = new Tree.Skip(params[2].loc);
                } else {
                    params[0].stmt = params[1].stmt;
                }
                return;
            }
            case 113: {
                //# line 218
                params[0].stmt = params[2].stmt;
                return;
            }
            case 114: {
                //# line 222
                params[0].stmt = params[1].stmt;
                return;
            }
            case 115: {
                //# line 226
                params[0].stmt = params[1].stmt;
                return;
            }
            case 116: {
                //# line 230
                params[0].stmt = params[1].stmt;
                return;
            }
            case 117: {
                //# line 234
                params[0].stmt = params[1].stmt;
                return;
            }
            case 118: {
                //# line 238
                params[0].stmt = params[1].stmt;
                return;
            }
            case 119: {
                //# line 242
                params[0].stmt = params[1].stmt;
                return;
            }
            case 120: {
                //# line 246
                params[0].stmt = params[1].stmt;
                return;
            }
            case 121: {
                //# line 250
                params[0].stmt = params[1].stmt;
                return;
            }
            case 122: {
                //# line 338
                if (params[2].expr == null) {
                    params[0].stmt = new Tree.Calculate(params[1].expr, params[1].loc);
                } else {
                    params[0].stmt = new Tree.Assign(params[1].expr, params[2].expr, params[2].loc);
                }
                return;
            }
            case 123: {
                //# line 346
                params[0].stmt = new Tree.Assign(new Tree.Ident(true, null, params[2].ident, params[2].loc), params[4].expr, params[3].loc);
                return;
            }
            case 124: {
                /* no action */
                return;
            }
            case 125: {
                //# line 62
                params[0].type = new Tree.TypeIdent(Tree.INT, params[1].loc);
                return;
            }
            case 126: {
                //# line 66
                params[0].type = new Tree.TypeIdent(Tree.VOID, params[1].loc);
                return;
            }
            case 127: {
                //# line 70
                params[0].type = new Tree.TypeIdent(Tree.BOOL, params[1].loc);
                return;
            }
            case 128: {
                //# line 74
                params[0].type = new Tree.TypeIdent(Tree.STRING, params[1].loc);
                return;
            }
            case 129: {
                //# line 78
                params[0].type = new Tree.TypeClass(params[2].ident, params[1].loc);
                return;
            }
            case 130: {
                //# line 975
                params[0].stmt = new Tree.WhileLoop(params[3].expr, params[5].stmt, params[1].loc);
                return;
            }
            case 131: {
                //# line 484
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 132: {
                /* no action */
                return;
            }
            case 133: {
                //# line 559
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                	SemValue cache = new SemValue();
                	int size = params[2].svec.size();
                    cache.expr = params[2].evec.get(size - 1);
                    for (int i = size - 2; i > -1; --i) {
                        cache.expr = new Tree.Binary(params[2].svec.get(i + 1), params[2].evec.get(i),
                            cache.expr, params[2].lvec.get(i + 1));
                    }
                    params[0].expr = new Tree.Binary(params[2].svec.get(0), params[0].expr, cache.expr, params[2].lvec.get(0));
                }
                return;
            }
            case 134: {
                //# line 634
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 135: {
                /* no action */
                return;
            }
            case 136: {
                //# line 1012
                params[0].expr = params[1].expr;
                return;
            }
            case 137: {
                /* no action */
                return;
            }
            case 138: {
                //# line 993
                params[0].stmt = new Tree.If(params[2].expr, params[4].stmt, params[5].stmt, params[1].loc);
                return;
            }
            case 139: {
                //# line 256
                params[0].stmt = new Tree.Scopy(params[5].expr, params[3].ident, params[1].loc);
                return;
            }
            case 140: {
                //# line 692
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 141: {
                /* no action */
                return;
            }
            case 142: {
                //# line 744
                SemValue sem = new SemValue();
                sem.expr = params[2].expr;                
                if (params[3].expr1 != null) {
                	sem.expr1 = params[3].expr1;
                	sem.isDefault = false;
                }
                else if (params[5].expr1 != null) {
                	sem.expr1 = params[5].expr1;
                	sem.isDefault = true;
                }                     
                params[0].vec = new Vector<SemValue>();
                params[0].vec.add(sem);
                if (params[5].vec != null) {
                    params[0].vec.addAll(params[5].vec);
                }
                return;
            }
            case 143: {
                //# line 763
                SemValue sem = new SemValue();
                sem.ident = params[2].ident;
                sem.loc = params[2].loc;
                sem.elist = params[3].elist;
                params[0].vec = new Vector<SemValue>();
                params[0].vec.add(sem);
                if (params[4].vec != null) {
                    params[0].vec.addAll(params[4].vec);
                }
                return;
            }
            case 144: {
                /* no action */
                return;
            }
            case 145: {
                //# line 709
                params[0].expr = new Tree.Unary(params[1].counter, params[2].expr, params[1].loc);
                return;
            }
            case 146: {
                //# line 713
                params[0].expr = params[1].expr;
                return;
            }
            case 147: {
                //# line 39
                params[0].clist = new ArrayList<ClassDef>();
                params[0].clist.add(params[1].cdef);
                if (params[2].clist != null) {
                    params[0].clist.addAll(params[2].clist);
                }
                return;
            }
            case 148: {
                /* no action */
                return;
            }
            case 149: {
                //# line 402
                params[0].counter = Tree.LE;
                params[0].loc = params[1].loc;
                return;
            }
            case 150: {
                //# line 407
                params[0].counter = Tree.GE;
                params[0].loc = params[1].loc;
                return;
            }
            case 151: {
                //# line 412
                params[0].counter = Tree.LT;
                params[0].loc = params[1].loc;
                return;
            }
            case 152: {
                //# line 417
                params[0].counter = Tree.GT;
                params[0].loc = params[1].loc;
                return;
            }
            case 153: {
                //# line 137
                params[0].fdef = new Tree.MethodDef(true, params[3].ident, params[2].type, params[5].vlist,
                    (Block) params[7].stmt, params[3].loc);
                return;
            }
            case 154: {
                //# line 142
                if (params[3].vlist != null) {
                    params[0].fdef = new Tree.MethodDef(false, params[2].ident, params[1].type, params[3].vlist,
                        (Block) params[3].stmt, params[2].loc);
                } else {
                    params[0].vdef = new Tree.VarDef(params[2].ident, params[1].type, params[2].loc);
                }
                return;
            }
        }
    }
}
/* end of file */
