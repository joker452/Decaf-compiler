//### This file created by BYACC 1.8(/Java extension  1.13)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//###           14 Sep 06  -- Keltin Leung-- ReduceListener support, eliminate underflow report in error recovery
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 11 "Parser.y"
package decaf.frontend;

import decaf.tree.Tree;
import decaf.tree.Tree.*;
import decaf.error.*;
import java.util.*;
//#line 25 "Parser.java"
interface ReduceListener {
  public boolean onReduce(String rule);
}




public class Parser
             extends BaseParser
             implements ReduceListener
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

ReduceListener reduceListener = null;
void yyclearin ()       {yychar = (-1);}
void yyerrok ()         {yyerrflag=0;}
void addReduceListener(ReduceListener l) {
  reduceListener = l;}


//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//## **user defined:SemValue
String   yytext;//user variable to return contextual strings
SemValue yyval; //used to return semantic vals from action routines
SemValue yylval;//the 'lval' (result) I got from yylex()
SemValue valstk[] = new SemValue[YYSTACKSIZE];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
final void val_init()
{
  yyval=new SemValue();
  yylval=new SemValue();
  valptr=-1;
}
final void val_push(SemValue val)
{
  try {
    valptr++;
    valstk[valptr]=val;
  }
  catch (ArrayIndexOutOfBoundsException e) {
    int oldsize = valstk.length;
    int newsize = oldsize*2;
    SemValue[] newstack = new SemValue[newsize];
    System.arraycopy(valstk,0,newstack,0,oldsize);
    valstk = newstack;
    valstk[valptr]=val;
  }
}
final SemValue val_pop()
{
  return valstk[valptr--];
}
final void val_drop(int cnt)
{
  valptr -= cnt;
}
final SemValue val_peek(int relative)
{
  return valstk[valptr-relative];
}
//#### end semantic value section ####
public final static short VOID=257;
public final static short BOOL=258;
public final static short INT=259;
public final static short STRING=260;
public final static short CLASS=261;
public final static short NULL=262;
public final static short EXTENDS=263;
public final static short THIS=264;
public final static short WHILE=265;
public final static short FOR=266;
public final static short IF=267;
public final static short ELSE=268;
public final static short RETURN=269;
public final static short BREAK=270;
public final static short NEW=271;
public final static short PRINT=272;
public final static short READ_INTEGER=273;
public final static short READ_LINE=274;
public final static short LITERAL=275;
public final static short IDENTIFIER=276;
public final static short AND=277;
public final static short OR=278;
public final static short STATIC=279;
public final static short INSTANCEOF=280;
public final static short LESS_EQUAL=281;
public final static short GREATER_EQUAL=282;
public final static short EQUAL=283;
public final static short NOT_EQUAL=284;
public final static short SCOPY=285;
public final static short SEALED=286;
public final static short SEP=287;
public final static short VAR=288;
public final static short INIT=289;
public final static short DEFAULT=290;
public final static short FORACH=291;
public final static short IN=292;
public final static short UMINUS=293;
public final static short EMPTY=294;
public final static short FOREACH=295;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    3,    4,    5,    5,    5,    5,    5,
    5,    2,    2,    6,    6,    7,    7,    7,    9,    9,
   10,   10,    8,    8,   11,   12,   12,   13,   13,   13,
   13,   13,   13,   13,   13,   13,   13,   13,   13,   21,
   22,   22,   25,   25,   26,   14,   14,   14,   29,   29,
   27,   27,   27,   30,   28,   24,   24,   24,   24,   24,
   24,   24,   24,   24,   24,   24,   24,   24,   24,   24,
   24,   24,   24,   24,   24,   24,   24,   24,   24,   24,
   24,   24,   24,   32,   32,   31,   31,   33,   33,   16,
   17,   23,   23,   34,   34,   20,   15,   35,   35,   18,
   18,   19,
};
final static short yylen[] = {                            2,
    1,    2,    1,    2,    2,    1,    1,    1,    1,    2,
    3,    7,    6,    2,    0,    2,    2,    0,    1,    0,
    3,    1,    7,    6,    3,    2,    0,    1,    2,    1,
    1,    1,    2,    2,    2,    2,    1,    1,    1,    6,
    5,    3,    3,    0,    3,    3,    1,    0,    2,    0,
    2,    4,    1,    2,    5,    1,    1,    1,    3,    3,
    3,    3,    3,    3,    3,    3,    3,    3,    6,    3,
    3,    3,    3,    3,    2,    2,    3,    3,    1,    4,
    5,    6,    5,    1,    1,    1,    0,    3,    1,    5,
    9,    9,    7,    1,    1,    1,    6,    2,    0,    2,
    1,    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    3,    0,    0,    2,    0,    0,
    0,   14,   18,    0,    0,   18,    7,    8,    6,    9,
    0,    0,   13,   16,    0,    0,   17,    0,   10,    0,
    4,    0,    0,   12,    0,    0,   11,    0,   22,    0,
    0,    0,    0,    5,    0,    0,    0,   27,   24,   21,
   23,    0,   85,   79,    0,    0,    0,    0,   96,    0,
    0,    0,    0,   84,    0,    0,    0,    0,   25,    0,
    0,    0,   28,   39,   26,    0,   30,   31,   32,    0,
    0,    0,    0,   37,   38,    0,    0,    0,    0,   53,
   58,    0,    0,    0,    0,    0,   56,   57,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   54,
    0,   29,   33,   34,   35,   36,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   49,
    0,    0,    0,    0,    0,    0,    0,   42,    0,    0,
    0,    0,    0,   77,   78,    0,    0,   74,    0,   94,
   95,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   80,    0,    0,  102,    0,    0,
    0,    0,    0,    0,    0,   90,    0,    0,    0,   41,
   43,   81,    0,    0,   83,    0,    0,    0,   55,    0,
    0,   97,   45,   82,   40,    0,    0,   69,    0,   98,
    0,   93,    0,    0,   91,   92,
};
final static short yydgoto[] = {                          3,
    4,    5,   73,   25,   40,   10,   15,   27,   41,   42,
   74,   52,   75,   76,   77,   78,   79,   80,   81,   82,
   83,   84,   85,   86,  139,  174,   97,   98,   89,   90,
  184,   91,  143,  152,  202,
};
final static short yysindex[] = {                      -252,
 -270, -234,    0, -252,    0, -227, -228,    0, -224,  -67,
 -227,    0,    0,  -66,  -76,    0,    0,    0,    0,    0,
 -211,  -51,    0,    0,   13,  -83,    0,  302,    0,  -72,
    0,   26,  -18,    0,   38,  -51,    0,  -51,    0,  -71,
   43,   42,   46,    0,  -30,  -51,  -30,    0,    0,    0,
    0,   -1,    0,    0,   51,   54,  -19,  113,    0, -129,
   57,   60,   65,    0,   66,  113,  113,   56,    0,   73,
 -162,   76,    0,    0,    0,   58,    0,    0,    0,   59,
   62,   64,   74,    0,    0,  944,   79,    0, -157,    0,
    0,  113,  113,  113,   10,  944,    0,    0,   85,   45,
  113,  100,  102,  113,  -29,  -29, -128,  537, -127,    0,
 -178,    0,    0,    0,    0,    0,  113,  113,  113,  113,
  113,  113,  113,  113,  113,  113,  113,  113,  113,    0,
  113,  113,  113,  112,  563,   96,  589,    0,  113,  115,
   75,  944,   -3,    0,    0,  613,  116,    0,  117,    0,
    0, -130, 1017,  996,    8,    8, 1068, 1068,   21,   21,
  -29,  -29,  -29,    8,    8,  736,  -32,  944,  113,   31,
  113,   31,  791, -122,    0,  817,  113,    0, -113,  113,
  113,  113, -126,  126,  125,    0,  869,  -91,   31,    0,
    0,    0,  944,  137,    0,  893,  485,  113,    0,  113,
   31,    0,    0,    0,    0,  113,   31,    0,  138,    0,
  920,    0,   31,   31,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,  180,    0,   63,    0,    0,    0,    0,
   63,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  136,    0,    0,    0,  170,    0,  170,    0,    0,
    0,  171,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -58,    0,    0,    0,    0,    0,  -57,    0,    0,
    0,    0,    0,    0,    0,  -55,  -55,  -55,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  985,  511,    0,    0,
    0,  -55,  -58,  -55,   94,  164,    0,    0,    0,    0,
  -55,    0,    0,  -55,  404,  413,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  -55,  -55,  -55,  -55,
  -55,  -55,  -55,  -55,  -55,  -55,  -55,  -55,  -55,    0,
  -55,  -55,  -55,  129,    0,    0,    0,    0,  -55,    0,
  -55,   29,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   44,    2,  859, 1026,  101,  693, 1121, 1148,
  440,  449,  476, 1063, 1171,    0, 1179,  -12,  -25,  -58,
  -55,  -58,    0,    0,    0,    0,  -55,    0,    0,  -55,
  -55,  -55,  155,    0,  189,    0,    0,  -33,  -58,    0,
    0,    0,   33,    0,    0,    0,    0,  -55,    0,  -23,
  -58,    0,    0,    0,    0,  -55,  -58,    0,    0,    0,
    0,    0,  -58,  -58,    0,    0,
};
final static short yygindex[] = {                         0,
    0,  231,    7,  -13,    9,  233,  229,    0,  237,    0,
   -5,    0,  -63,  -89,    0,    0,    0,    0,    0,    0,
    0,    0,    0, 1375,    0,    0, 1153, 1193,    0,  165,
    0,    0,  108,    0,    0,
};
final static int YYTABLESIZE=1581;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         99,
   48,  101,  190,  136,  127,    6,   99,   33,    1,  125,
  123,   99,  124,  130,  126,   87,  130,   48,   33,   33,
   94,   24,   39,   26,   39,   99,    7,  129,   46,  128,
   30,   67,   50,    2,   24,    9,   26,  178,   68,   49,
  177,   51,   73,   66,  127,   73,   46,   11,   23,  125,
  123,   12,  124,  130,  126,   13,   16,  127,  131,   73,
   73,  131,  125,   67,   29,   36,  130,  126,  100,   89,
   68,   31,   89,   88,   37,   66,   88,   38,   17,   18,
   19,   20,   21,   45,   72,   46,   47,   72,   67,   99,
   92,   99,   48,   93,   73,   68,  101,  150,  131,  102,
   66,   72,   72,   95,  103,  104,  186,   67,  188,   71,
  209,  131,  109,  110,   68,  111,  112,  113,  134,   66,
  114,   48,  115,   69,  140,  203,   44,   17,   18,   19,
   20,   21,  116,   44,  138,  141,   72,  210,   44,  133,
  144,   64,  145,  212,   64,   67,   99,  147,  149,  215,
  216,  169,   68,   48,  171,  175,  180,   66,   64,   64,
  181,  182,  194,  198,  191,   51,  199,   37,  177,   51,
   51,   51,   51,   51,   51,   51,  201,  204,  213,    1,
   17,   18,   19,   20,   21,   15,   51,   51,   51,   51,
   51,   52,   32,   64,    5,   52,   52,   52,   52,   52,
   52,   52,   22,   35,   44,   17,   18,   19,   20,   21,
   20,   19,   52,   52,   52,   52,   52,   50,   50,   51,
   50,   51,  100,   99,   99,   99,   99,   99,   99,   86,
   99,   99,   99,   99,    8,   99,   99,   99,   99,   99,
   99,   99,   99,   14,   28,   52,   99,   52,  119,  120,
   50,   99,   50,   99,   99,   17,   18,   19,   20,   21,
   53,   99,   54,   55,   56,   57,   73,   58,   59,   60,
   61,   62,   63,   64,   43,  151,  185,    0,   65,   73,
    0,    0,    0,   70,    0,    0,   71,   17,   18,   19,
   20,   21,   53,   72,   54,   55,   56,   57,    0,   58,
   59,   60,   61,   62,   63,   64,    0,    0,   72,    0,
   65,    0,    0,    0,    0,   70,  107,   53,   71,   54,
   72,   72,    0,    0,    0,   72,   60,    0,   62,   63,
   64,    0,    0,    0,    0,   65,   53,    0,   54,    0,
    0,    0,    0,   71,    0,   60,    0,   62,   63,   64,
    0,    0,    0,    0,   65,   44,    0,   44,    0,    0,
    0,    0,   71,    0,   44,   64,   44,   44,   44,   44,
    0,    0,    0,   44,   53,    0,   54,   64,   64,    0,
    0,   44,    0,   60,    0,   62,   63,   64,    0,    0,
    0,    0,   65,   51,    0,    0,    0,    0,    0,    0,
   71,    0,    0,    0,    0,   51,   51,    0,    0,   51,
   51,   51,   51,    0,    0,    0,    0,   51,    0,   52,
    0,    0,    0,    0,    0,    0,   34,    0,    0,    0,
    0,   52,   52,    0,    0,   52,   52,   52,   52,    0,
   75,    0,    0,   52,   75,   75,   75,   75,   75,   76,
   75,    0,    0,   76,   76,   76,   76,   76,    0,   76,
    0,   75,   75,   75,    0,   75,    0,    0,    0,    0,
   76,   76,   76,    0,   76,    0,   61,    0,    0,    0,
   61,   61,   61,   61,   61,   62,   61,    0,    0,   62,
   62,   62,   62,   62,    0,   62,   75,   61,   61,   61,
    0,   61,    0,    0,    0,   76,   62,   62,   62,    0,
   62,    0,   63,    0,    0,    0,   63,   63,   63,   63,
   63,  127,   63,    0,    0,  207,  125,  123,    0,  124,
  130,  126,   61,   63,   63,   63,    0,   63,    0,    0,
    0,   62,    0,    0,  129,    0,  128,   57,    0,    0,
    0,   47,   57,   57,    0,   57,   57,   57,   17,   18,
   19,   20,   21,    0,    0,    0,    0,    0,   63,   47,
   57,    0,   57,  127,    0,  131,    0,  148,  125,  123,
   22,  124,  130,  126,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  129,    0,  128,  127,
    0,   57,    0,  170,  125,  123,    0,  124,  130,  126,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  129,    0,  128,  127,    0,  131,    0,  172,
  125,  123,    0,  124,  130,  126,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  129,  127,
  128,    0,    0,  131,  125,  123,  179,  124,  130,  126,
    0,    0,    0,    0,    0,    0,    0,    0,   75,    0,
    0,    0,  129,    0,  128,    0,    0,   76,    0,  131,
   75,   75,    0,    0,   75,   75,   75,   75,    0,   76,
   76,    0,   75,   76,   76,   76,   76,    0,    0,    0,
    0,   76,    0,  131,   61,    0,    0,    0,    0,    0,
    0,    0,    0,   62,    0,    0,   61,   61,    0,    0,
   61,   61,   61,   61,    0,   62,   62,    0,   61,   62,
   62,   62,   62,   65,    0,    0,   65,   62,    0,    0,
   63,    0,    0,    0,    0,    0,    0,    0,    0,  206,
   65,   65,   63,   63,    0,    0,   63,   63,   63,   63,
    0,  117,  118,    0,   63,  119,  120,  121,  122,    0,
    0,    0,  127,  132,    0,    0,    0,  125,  123,    0,
  124,  130,  126,    0,    0,   65,    0,   57,   57,    0,
    0,   57,   57,   57,   57,  129,    0,  128,    0,   57,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  117,  118,    0,    0,  119,  120,  121,
  122,    0,    0,    0,    0,  132,  131,  127,  183,    0,
    0,    0,  125,  123,    0,  124,  130,  126,    0,  117,
  118,    0,    0,  119,  120,  121,  122,    0,  189,    0,
  129,  132,  128,  127,    0,    0,    0,    0,  125,  123,
    0,  124,  130,  126,    0,  117,  118,    0,    0,  119,
  120,  121,  122,    0,    0,    0,  129,  132,  128,    0,
    0,  131,    0,    0,    0,    0,    0,    0,    0,  117,
  118,    0,    0,  119,  120,  121,  122,    0,    0,   70,
    0,  132,   70,    0,    0,  127,    0,  131,    0,  192,
  125,  123,    0,  124,  130,  126,   70,   70,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  200,  129,  127,
  128,    0,    0,  205,  125,  123,    0,  124,  130,  126,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   70,  129,    0,  128,    0,  127,   65,    0,  131,
  214,  125,  123,    0,  124,  130,  126,    0,    0,   65,
   65,    0,    0,    0,    0,    0,    0,    0,    0,  129,
  127,  128,    0,  131,    0,  125,  123,    0,  124,  130,
  126,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  129,    0,  128,    0,    0,    0,    0,
  131,    0,  117,  118,    0,    0,  119,  120,  121,  122,
    0,   56,    0,    0,  132,    0,   56,   56,    0,   56,
   56,   56,  127,    0,  131,    0,    0,  125,  123,    0,
  124,  130,  126,    0,   56,    0,   56,    0,    0,    0,
    0,    0,    0,  127,    0,  129,    0,  128,  125,  123,
    0,  124,  130,  126,    0,    0,   71,  117,  118,   71,
    0,  119,  120,  121,  122,   56,  129,    0,  128,  132,
    0,    0,    0,   71,   71,    0,  131,    0,    0,    0,
    0,    0,    0,  117,  118,    0,    0,  119,  120,  121,
  122,    0,    0,   67,  127,  132,   67,  131,    0,  125,
  123,    0,  124,  130,  126,    0,    0,    0,   71,    0,
   67,   67,    0,   70,    0,    0,    0,  129,    0,  128,
    0,    0,    0,    0,    0,   70,   70,    0,    0,    0,
    0,   70,   70,    0,    0,  117,  118,   70,    0,  119,
  120,  121,  122,    0,    0,   67,    0,  132,  131,    0,
    0,   59,    0,   59,   59,   59,    0,    0,    0,  117,
  118,    0,    0,  119,  120,  121,  122,    0,   59,   59,
   59,  132,   59,    0,    0,    0,    0,    0,   60,    0,
   60,   60,   60,    0,    0,    0,  117,  118,    0,    0,
  119,  120,  121,  122,   87,   60,   60,   60,  132,   60,
    0,   66,    0,   59,   66,    0,    0,    0,    0,   68,
  117,  118,   68,    0,  119,  120,  121,  122,   66,   66,
    0,    0,  132,    0,    0,    0,   68,   68,    0,    0,
   60,    0,    0,    0,   88,   87,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   56,   56,   66,    0,   56,   56,   56,   56,    0,
    0,   68,  117,   56,    0,    0,  119,  120,  121,  122,
    0,    0,    0,    0,  132,   88,    0,    0,    0,    0,
   71,    0,    0,    0,    0,    0,    0,  119,  120,  121,
  122,    0,   71,   71,    0,  132,    0,    0,   71,   71,
    0,    0,    0,    0,   71,    0,    0,    0,    0,    0,
    0,    0,   87,    0,   87,    0,    0,   67,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   67,
   67,   87,    0,    0,    0,   67,   67,    0,  119,  120,
    0,   67,   87,   87,    0,    0,  132,    0,    0,   87,
    0,    0,   88,    0,   88,   87,   87,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   88,    0,    0,    0,   59,    0,    0,    0,    0,
    0,    0,   88,   88,    0,    0,    0,   59,   59,   88,
    0,   59,   59,   59,   59,   88,   88,    0,    0,   59,
    0,    0,   60,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   60,   60,    0,    0,   60,   60,
   60,   60,   96,    0,    0,   66,   60,    0,    0,    0,
  105,  106,  108,   68,    0,    0,    0,   66,   66,    0,
    0,    0,    0,   66,   66,   68,   68,    0,    0,   66,
    0,   68,   68,    0,    0,    0,  135,   68,  137,    0,
    0,    0,    0,    0,    0,  142,    0,    0,  146,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  153,  154,  155,  156,  157,  158,  159,  160,  161,
  162,  163,  164,  165,    0,  166,  167,  168,    0,    0,
    0,    0,    0,  173,    0,  176,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  142,    0,  187,    0,    0,    0,    0,
    0,  193,    0,    0,  195,  196,  197,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  208,    0,    0,    0,    0,    0,    0,    0,
  211,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
   59,   59,  125,   93,   37,  276,   40,   91,  261,   42,
   43,   45,   45,   46,   47,   41,   46,   41,   91,   91,
   40,   15,   36,   15,   38,   59,  261,   60,   41,   62,
   22,   33,   46,  286,   28,  263,   28,   41,   40,   45,
   44,   47,   41,   45,   37,   44,   59,  276,  125,   42,
   43,  276,   45,   46,   47,  123,  123,   37,   91,   58,
   59,   91,   42,   33,  276,   40,   46,   47,   60,   41,
   40,   59,   44,   41,   93,   45,   44,   40,  257,  258,
  259,  260,  261,   41,   41,   44,   41,   44,   33,  123,
   40,  125,  123,   40,   93,   40,   40,  111,   91,   40,
   45,   58,   59,  123,   40,   40,  170,   33,  172,  288,
  200,   91,   40,  276,   40,   40,   59,   59,  276,   45,
   59,  123,   59,  125,   40,  189,   33,  257,  258,  259,
  260,  261,   59,   40,  125,   91,   93,  201,   45,   61,
   41,   41,   41,  207,   44,   33,  276,  276,  276,  213,
  214,   40,   40,  123,   59,   41,   41,   45,   58,   59,
   44,  292,  276,  290,  287,   37,   41,   93,   44,   41,
   42,   43,   44,   45,   46,   47,  268,   41,   41,    0,
  257,  258,  259,  260,  261,  123,   58,   59,   60,   61,
   62,   37,  276,   93,   59,   41,   42,   43,   44,   45,
   46,   47,  279,  276,  276,  257,  258,  259,  260,  261,
   41,   41,   58,   59,   60,   61,   62,  276,  276,   91,
  276,   93,   59,  257,  258,  259,  260,  261,  262,   41,
  264,  265,  266,  267,    4,  269,  270,  271,  272,  273,
  274,  275,  276,   11,   16,   91,  280,   93,  281,  282,
  276,  285,  276,  287,  288,  257,  258,  259,  260,  261,
  262,  295,  264,  265,  266,  267,  265,  269,  270,  271,
  272,  273,  274,  275,   38,  111,  169,   -1,  280,  278,
   -1,   -1,   -1,  285,   -1,   -1,  288,  257,  258,  259,
  260,  261,  262,  295,  264,  265,  266,  267,   -1,  269,
  270,  271,  272,  273,  274,  275,   -1,   -1,  265,   -1,
  280,   -1,   -1,   -1,   -1,  285,  261,  262,  288,  264,
  277,  278,   -1,   -1,   -1,  295,  271,   -1,  273,  274,
  275,   -1,   -1,   -1,   -1,  280,  262,   -1,  264,   -1,
   -1,   -1,   -1,  288,   -1,  271,   -1,  273,  274,  275,
   -1,   -1,   -1,   -1,  280,  262,   -1,  264,   -1,   -1,
   -1,   -1,  288,   -1,  271,  265,  273,  274,  275,  276,
   -1,   -1,   -1,  280,  262,   -1,  264,  277,  278,   -1,
   -1,  288,   -1,  271,   -1,  273,  274,  275,   -1,   -1,
   -1,   -1,  280,  265,   -1,   -1,   -1,   -1,   -1,   -1,
  288,   -1,   -1,   -1,   -1,  277,  278,   -1,   -1,  281,
  282,  283,  284,   -1,   -1,   -1,   -1,  289,   -1,  265,
   -1,   -1,   -1,   -1,   -1,   -1,  125,   -1,   -1,   -1,
   -1,  277,  278,   -1,   -1,  281,  282,  283,  284,   -1,
   37,   -1,   -1,  289,   41,   42,   43,   44,   45,   37,
   47,   -1,   -1,   41,   42,   43,   44,   45,   -1,   47,
   -1,   58,   59,   60,   -1,   62,   -1,   -1,   -1,   -1,
   58,   59,   60,   -1,   62,   -1,   37,   -1,   -1,   -1,
   41,   42,   43,   44,   45,   37,   47,   -1,   -1,   41,
   42,   43,   44,   45,   -1,   47,   93,   58,   59,   60,
   -1,   62,   -1,   -1,   -1,   93,   58,   59,   60,   -1,
   62,   -1,   37,   -1,   -1,   -1,   41,   42,   43,   44,
   45,   37,   47,   -1,   -1,   41,   42,   43,   -1,   45,
   46,   47,   93,   58,   59,   60,   -1,   62,   -1,   -1,
   -1,   93,   -1,   -1,   60,   -1,   62,   37,   -1,   -1,
   -1,   41,   42,   43,   -1,   45,   46,   47,  257,  258,
  259,  260,  261,   -1,   -1,   -1,   -1,   -1,   93,   59,
   60,   -1,   62,   37,   -1,   91,   -1,   41,   42,   43,
  279,   45,   46,   47,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   60,   -1,   62,   37,
   -1,   91,   -1,   41,   42,   43,   -1,   45,   46,   47,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   60,   -1,   62,   37,   -1,   91,   -1,   41,
   42,   43,   -1,   45,   46,   47,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   60,   37,
   62,   -1,   -1,   91,   42,   43,   44,   45,   46,   47,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,   -1,
   -1,   -1,   60,   -1,   62,   -1,   -1,  265,   -1,   91,
  277,  278,   -1,   -1,  281,  282,  283,  284,   -1,  277,
  278,   -1,  289,  281,  282,  283,  284,   -1,   -1,   -1,
   -1,  289,   -1,   91,  265,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  265,   -1,   -1,  277,  278,   -1,   -1,
  281,  282,  283,  284,   -1,  277,  278,   -1,  289,  281,
  282,  283,  284,   41,   -1,   -1,   44,  289,   -1,   -1,
  265,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,
   58,   59,  277,  278,   -1,   -1,  281,  282,  283,  284,
   -1,  277,  278,   -1,  289,  281,  282,  283,  284,   -1,
   -1,   -1,   37,  289,   -1,   -1,   -1,   42,   43,   -1,
   45,   46,   47,   -1,   -1,   93,   -1,  277,  278,   -1,
   -1,  281,  282,  283,  284,   60,   -1,   62,   -1,  289,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  277,  278,   -1,   -1,  281,  282,  283,
  284,   -1,   -1,   -1,   -1,  289,   91,   37,   93,   -1,
   -1,   -1,   42,   43,   -1,   45,   46,   47,   -1,  277,
  278,   -1,   -1,  281,  282,  283,  284,   -1,   58,   -1,
   60,  289,   62,   37,   -1,   -1,   -1,   -1,   42,   43,
   -1,   45,   46,   47,   -1,  277,  278,   -1,   -1,  281,
  282,  283,  284,   -1,   -1,   -1,   60,  289,   62,   -1,
   -1,   91,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  277,
  278,   -1,   -1,  281,  282,  283,  284,   -1,   -1,   41,
   -1,  289,   44,   -1,   -1,   37,   -1,   91,   -1,   93,
   42,   43,   -1,   45,   46,   47,   58,   59,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   59,   60,   37,
   62,   -1,   -1,   41,   42,   43,   -1,   45,   46,   47,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   93,   60,   -1,   62,   -1,   37,  265,   -1,   91,
   41,   42,   43,   -1,   45,   46,   47,   -1,   -1,  277,
  278,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   60,
   37,   62,   -1,   91,   -1,   42,   43,   -1,   45,   46,
   47,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   60,   -1,   62,   -1,   -1,   -1,   -1,
   91,   -1,  277,  278,   -1,   -1,  281,  282,  283,  284,
   -1,   37,   -1,   -1,  289,   -1,   42,   43,   -1,   45,
   46,   47,   37,   -1,   91,   -1,   -1,   42,   43,   -1,
   45,   46,   47,   -1,   60,   -1,   62,   -1,   -1,   -1,
   -1,   -1,   -1,   37,   -1,   60,   -1,   62,   42,   43,
   -1,   45,   46,   47,   -1,   -1,   41,  277,  278,   44,
   -1,  281,  282,  283,  284,   91,   60,   -1,   62,  289,
   -1,   -1,   -1,   58,   59,   -1,   91,   -1,   -1,   -1,
   -1,   -1,   -1,  277,  278,   -1,   -1,  281,  282,  283,
  284,   -1,   -1,   41,   37,  289,   44,   91,   -1,   42,
   43,   -1,   45,   46,   47,   -1,   -1,   -1,   93,   -1,
   58,   59,   -1,  265,   -1,   -1,   -1,   60,   -1,   62,
   -1,   -1,   -1,   -1,   -1,  277,  278,   -1,   -1,   -1,
   -1,  283,  284,   -1,   -1,  277,  278,  289,   -1,  281,
  282,  283,  284,   -1,   -1,   93,   -1,  289,   91,   -1,
   -1,   41,   -1,   43,   44,   45,   -1,   -1,   -1,  277,
  278,   -1,   -1,  281,  282,  283,  284,   -1,   58,   59,
   60,  289,   62,   -1,   -1,   -1,   -1,   -1,   41,   -1,
   43,   44,   45,   -1,   -1,   -1,  277,  278,   -1,   -1,
  281,  282,  283,  284,   52,   58,   59,   60,  289,   62,
   -1,   41,   -1,   93,   44,   -1,   -1,   -1,   -1,   41,
  277,  278,   44,   -1,  281,  282,  283,  284,   58,   59,
   -1,   -1,  289,   -1,   -1,   -1,   58,   59,   -1,   -1,
   93,   -1,   -1,   -1,   52,   93,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  277,  278,   93,   -1,  281,  282,  283,  284,   -1,
   -1,   93,  277,  289,   -1,   -1,  281,  282,  283,  284,
   -1,   -1,   -1,   -1,  289,   93,   -1,   -1,   -1,   -1,
  265,   -1,   -1,   -1,   -1,   -1,   -1,  281,  282,  283,
  284,   -1,  277,  278,   -1,  289,   -1,   -1,  283,  284,
   -1,   -1,   -1,   -1,  289,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  170,   -1,  172,   -1,   -1,  265,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  277,
  278,  189,   -1,   -1,   -1,  283,  284,   -1,  281,  282,
   -1,  289,  200,  201,   -1,   -1,  289,   -1,   -1,  207,
   -1,   -1,  170,   -1,  172,  213,  214,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  189,   -1,   -1,   -1,  265,   -1,   -1,   -1,   -1,
   -1,   -1,  200,  201,   -1,   -1,   -1,  277,  278,  207,
   -1,  281,  282,  283,  284,  213,  214,   -1,   -1,  289,
   -1,   -1,  265,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  277,  278,   -1,   -1,  281,  282,
  283,  284,   58,   -1,   -1,  265,  289,   -1,   -1,   -1,
   66,   67,   68,  265,   -1,   -1,   -1,  277,  278,   -1,
   -1,   -1,   -1,  283,  284,  277,  278,   -1,   -1,  289,
   -1,  283,  284,   -1,   -1,   -1,   92,  289,   94,   -1,
   -1,   -1,   -1,   -1,   -1,  101,   -1,   -1,  104,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  117,  118,  119,  120,  121,  122,  123,  124,  125,
  126,  127,  128,  129,   -1,  131,  132,  133,   -1,   -1,
   -1,   -1,   -1,  139,   -1,  141,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  169,   -1,  171,   -1,   -1,   -1,   -1,
   -1,  177,   -1,   -1,  180,  181,  182,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  198,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  206,
};
}
final static short YYFINAL=3;
final static short YYMAXTOKEN=295;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"'!'",null,null,null,"'%'",null,null,"'('","')'","'*'","'+'",
"','","'-'","'.'","'/'",null,null,null,null,null,null,null,null,null,null,"':'",
"';'","'<'","'='","'>'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,"'['",null,"']'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,"'{'",null,"'}'",null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,"VOID","BOOL","INT","STRING",
"CLASS","NULL","EXTENDS","THIS","WHILE","FOR","IF","ELSE","RETURN","BREAK",
"NEW","PRINT","READ_INTEGER","READ_LINE","LITERAL","IDENTIFIER","AND","OR",
"STATIC","INSTANCEOF","LESS_EQUAL","GREATER_EQUAL","EQUAL","NOT_EQUAL","SCOPY",
"SEALED","SEP","VAR","INIT","DEFAULT","FORACH","IN","UMINUS","EMPTY","FOREACH",
};
final static String yyrule[] = {
"$accept : Program",
"Program : ClassList",
"ClassList : ClassList ClassDef",
"ClassList : ClassDef",
"VariableDef : Variable ';'",
"Variable : Type IDENTIFIER",
"Type : INT",
"Type : VOID",
"Type : BOOL",
"Type : STRING",
"Type : CLASS IDENTIFIER",
"Type : Type '[' ']'",
"ClassDef : SEALED CLASS IDENTIFIER ExtendsClause '{' FieldList '}'",
"ClassDef : CLASS IDENTIFIER ExtendsClause '{' FieldList '}'",
"ExtendsClause : EXTENDS IDENTIFIER",
"ExtendsClause :",
"FieldList : FieldList VariableDef",
"FieldList : FieldList FunctionDef",
"FieldList :",
"Formals : VariableList",
"Formals :",
"VariableList : VariableList ',' Variable",
"VariableList : Variable",
"FunctionDef : STATIC Type IDENTIFIER '(' Formals ')' StmtBlock",
"FunctionDef : Type IDENTIFIER '(' Formals ')' StmtBlock",
"StmtBlock : '{' StmtList '}'",
"StmtList : StmtList Stmt",
"StmtList :",
"Stmt : VariableDef",
"Stmt : SimpleStmt ';'",
"Stmt : IfStmt",
"Stmt : WhileStmt",
"Stmt : ForStmt",
"Stmt : ReturnStmt ';'",
"Stmt : PrintStmt ';'",
"Stmt : BreakStmt ';'",
"Stmt : OCStmt ';'",
"Stmt : GuardedStmt",
"Stmt : ForeachStmt",
"Stmt : StmtBlock",
"OCStmt : SCOPY '(' IDENTIFIER ',' Expr ')'",
"GuardedStmt : IF '{' GuardList Guard '}'",
"GuardedStmt : IF '{' '}'",
"GuardList : GuardList Guard SEP",
"GuardList :",
"Guard : Expr ':' Stmt",
"SimpleStmt : LValue '=' Expr",
"SimpleStmt : Call",
"SimpleStmt :",
"Receiver : Expr '.'",
"Receiver :",
"LValue : Receiver IDENTIFIER",
"LValue : Expr '[' Expr ']'",
"LValue : AutoVariable",
"AutoVariable : VAR IDENTIFIER",
"Call : Receiver IDENTIFIER '(' Actuals ')'",
"Expr : LValue",
"Expr : Call",
"Expr : Constant",
"Expr : Expr '+' Expr",
"Expr : Expr '-' Expr",
"Expr : Expr '*' Expr",
"Expr : Expr '/' Expr",
"Expr : Expr '%' Expr",
"Expr : Expr EQUAL Expr",
"Expr : Expr NOT_EQUAL Expr",
"Expr : Expr '<' Expr",
"Expr : Expr '>' Expr",
"Expr : Expr INIT Expr",
"Expr : Expr '[' Expr ']' DEFAULT Expr",
"Expr : Expr LESS_EQUAL Expr",
"Expr : Expr GREATER_EQUAL Expr",
"Expr : Expr AND Expr",
"Expr : Expr OR Expr",
"Expr : '(' Expr ')'",
"Expr : '-' Expr",
"Expr : '!' Expr",
"Expr : READ_INTEGER '(' ')'",
"Expr : READ_LINE '(' ')'",
"Expr : THIS",
"Expr : NEW IDENTIFIER '(' ')'",
"Expr : NEW Type '[' Expr ']'",
"Expr : INSTANCEOF '(' Expr ',' IDENTIFIER ')'",
"Expr : '(' CLASS IDENTIFIER ')' Expr",
"Constant : LITERAL",
"Constant : NULL",
"Actuals : ExprList",
"Actuals :",
"ExprList : ExprList ',' Expr",
"ExprList : Expr",
"WhileStmt : WHILE '(' Expr ')' Stmt",
"ForStmt : FOR '(' SimpleStmt ';' Expr ';' SimpleStmt ')' Stmt",
"ForeachStmt : FOREACH '(' BoundVariable IN Expr WHILE Expr ')' Stmt",
"ForeachStmt : FOREACH '(' BoundVariable IN Expr ')' Stmt",
"BoundVariable : Variable",
"BoundVariable : AutoVariable",
"BreakStmt : BREAK",
"IfStmt : IF '(' Expr ')' Stmt ElseClause",
"ElseClause : ELSE Stmt",
"ElseClause :",
"ReturnStmt : RETURN Expr",
"ReturnStmt : RETURN",
"PrintStmt : PRINT '(' ExprList ')'",
};

//#line 501 "Parser.y"
    
	/**
	 * 打印当前归约所用的语法规则<br>
	 * 请勿修改。
	 */
    public boolean onReduce(String rule) {
		if (rule.startsWith("$$"))
			return false;
		else
			rule = rule.replaceAll(" \\$\\$\\d+", "");

   	    if (rule.endsWith(":"))
    	    System.out.println(rule + " <empty>");
   	    else
			System.out.println(rule);
		return false;
    }
    
    public void diagnose() {
		addReduceListener(this);
		yyparse();
	}
//#line 739 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    //if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      //if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        //if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        //if (yychar < 0)    //it it didn't work/error
        //  {
        //  yychar = 0;      //change it to default string (no -1!)
          //if (yydebug)
          //  yylexdebug(yystate,yychar);
        //  }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        //if (yydebug)
          //debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      //if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0 || valptr<0)   //check for under & overflow here
            {
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            //if (yydebug)
              //debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            //if (yydebug)
              //debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0 || valptr<0)   //check for under & overflow here
              {
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        //if (yydebug)
          //{
          //yys = null;
          //if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          //if (yys == null) yys = "illegal-symbol";
          //debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          //}
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    //if (yydebug)
      //debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    if (reduceListener == null || reduceListener.onReduce(yyrule[yyn])) // if intercepted!
      switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 54 "Parser.y"
{
						tree = new Tree.TopLevel(val_peek(0).clist, val_peek(0).loc);
					}
break;
case 2:
//#line 60 "Parser.y"
{
						yyval.clist.add(val_peek(0).cdef);
					}
break;
case 3:
//#line 64 "Parser.y"
{
                		yyval.clist = new ArrayList<Tree.ClassDef>();
                		yyval.clist.add(val_peek(0).cdef);
                	}
break;
case 5:
//#line 74 "Parser.y"
{
						yyval.vdef = new Tree.VarDef(val_peek(0).ident, val_peek(1).type, val_peek(0).loc);
					}
break;
case 6:
//#line 80 "Parser.y"
{
						yyval.type = new Tree.TypeIdent(Tree.INT, val_peek(0).loc);
					}
break;
case 7:
//#line 84 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.VOID, val_peek(0).loc);
                	}
break;
case 8:
//#line 88 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.BOOL, val_peek(0).loc);
                	}
break;
case 9:
//#line 92 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.STRING, val_peek(0).loc);
                	}
break;
case 10:
//#line 96 "Parser.y"
{
                		yyval.type = new Tree.TypeClass(val_peek(0).ident, val_peek(1).loc);
                	}
break;
case 11:
//#line 100 "Parser.y"
{
                		yyval.type = new Tree.TypeArray(val_peek(2).type, val_peek(2).loc);
                	}
break;
case 12:
//#line 106 "Parser.y"
{
						yyval.cdef = new Tree.ClassDef(true, val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, val_peek(5).loc);
					}
break;
case 13:
//#line 110 "Parser.y"
{
						yyval.cdef = new Tree.ClassDef(false, val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, val_peek(5).loc);
					}
break;
case 14:
//#line 116 "Parser.y"
{
						yyval.ident = val_peek(0).ident;
					}
break;
case 15:
//#line 120 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 16:
//#line 126 "Parser.y"
{
						yyval.flist.add(val_peek(0).vdef);
					}
break;
case 17:
//#line 130 "Parser.y"
{
						yyval.flist.add(val_peek(0).fdef);
					}
break;
case 18:
//#line 134 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.flist = new ArrayList<Tree>();
                	}
break;
case 20:
//#line 142 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.vlist = new ArrayList<Tree.VarDef>(); 
                	}
break;
case 21:
//#line 149 "Parser.y"
{
						yyval.vlist.add(val_peek(0).vdef);
					}
break;
case 22:
//#line 153 "Parser.y"
{
                		yyval.vlist = new ArrayList<Tree.VarDef>();
						yyval.vlist.add(val_peek(0).vdef);
                	}
break;
case 23:
//#line 160 "Parser.y"
{
						yyval.fdef = new MethodDef(true, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 24:
//#line 164 "Parser.y"
{
						yyval.fdef = new MethodDef(false, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 25:
//#line 170 "Parser.y"
{
						yyval.stmt = new Block(val_peek(1).slist, val_peek(2).loc);
					}
break;
case 26:
//#line 176 "Parser.y"
{
						yyval.slist.add(val_peek(0).stmt);
					}
break;
case 27:
//#line 180 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.slist = new ArrayList<Tree>();
                	}
break;
case 28:
//#line 187 "Parser.y"
{
						yyval.stmt = val_peek(0).vdef;
					}
break;
case 29:
//#line 192 "Parser.y"
{
                		if (yyval.stmt == null) {
                			yyval.stmt = new Tree.Skip(val_peek(0).loc);
                		}
                	}
break;
case 40:
//#line 210 "Parser.y"
{
						yyval.stmt = new Tree.Scopy(val_peek(1).expr, val_peek(3).ident, val_peek(5).loc);
					}
break;
case 41:
//#line 216 "Parser.y"
{
                        val_peek(2).slist.add(val_peek(1).stmt);
                        yyval.stmt = new Tree.GuardStmt(val_peek(2).slist, val_peek(4).loc);
                    }
break;
case 42:
//#line 221 "Parser.y"
{
				        yyval.stmt = new Tree.GuardStmt(null, val_peek(2).loc);
				    }
break;
case 43:
//#line 227 "Parser.y"
{
                       yyval.slist.add(val_peek(1).stmt);
                    }
break;
case 44:
//#line 231 "Parser.y"
{
				    	yyval = new SemValue();
				    	yyval.slist = new ArrayList<Tree>();
				    }
break;
case 45:
//#line 238 "Parser.y"
{
						yyval.stmt = new Tree.Guard(val_peek(2).expr, val_peek(0).stmt, val_peek(2).loc);
					}
break;
case 46:
//#line 244 "Parser.y"
{
						yyval.stmt = new Tree.Assign(val_peek(2).lvalue, val_peek(0).expr, val_peek(1).loc);
					}
break;
case 47:
//#line 248 "Parser.y"
{
                		yyval.stmt = new Tree.Exec(val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 48:
//#line 252 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 50:
//#line 259 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 51:
//#line 265 "Parser.y"
{
						yyval.lvalue = new Tree.Ident(false, val_peek(1).expr, val_peek(0).ident, val_peek(0).loc);
						if (val_peek(1).loc == null) {
							yyval.loc = val_peek(0).loc;
						}
					}
break;
case 52:
//#line 272 "Parser.y"
{
                		yyval.lvalue = new Tree.Indexed(val_peek(3).expr, val_peek(1).expr, val_peek(3).loc);
                	}
break;
case 54:
//#line 279 "Parser.y"
{
                    	yyval.lvalue = new Tree.Ident(true, null, val_peek(0).ident, val_peek(0).loc);
                    }
break;
case 55:
//#line 285 "Parser.y"
{
						yyval.expr = new Tree.CallExpr(val_peek(4).expr, val_peek(3).ident, val_peek(1).elist, val_peek(3).loc);
						if (val_peek(4).loc == null) {
							yyval.loc = val_peek(3).loc;
						}
					}
break;
case 56:
//#line 294 "Parser.y"
{
						yyval.expr = val_peek(0).lvalue;
					}
break;
case 59:
//#line 300 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.PLUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 60:
//#line 304 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MINUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 61:
//#line 308 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MUL, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 62:
//#line 312 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.DIV, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 63:
//#line 316 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MOD, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 64:
//#line 320 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.EQ, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 65:
//#line 324 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.NE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 66:
//#line 328 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 67:
//#line 332 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 68:
//#line 336 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.INIT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 69:
//#line 340 "Parser.y"
{
                		yyval.expr = new Tree.Default(val_peek(5).expr, val_peek(3).expr, val_peek(0).expr, val_peek(5).loc);
                	}
break;
case 70:
//#line 344 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 71:
//#line 348 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 72:
//#line 352 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.AND, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 73:
//#line 356 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.OR, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 74:
//#line 360 "Parser.y"
{
                		yyval = val_peek(1);
                	}
break;
case 75:
//#line 364 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NEG, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 76:
//#line 368 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NOT, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 77:
//#line 372 "Parser.y"
{
                		yyval.expr = new Tree.ReadIntExpr(val_peek(2).loc);
                	}
break;
case 78:
//#line 376 "Parser.y"
{
                		yyval.expr = new Tree.ReadLineExpr(val_peek(2).loc);
                	}
break;
case 79:
//#line 380 "Parser.y"
{
                		yyval.expr = new Tree.ThisExpr(val_peek(0).loc);
                	}
break;
case 80:
//#line 384 "Parser.y"
{
                		yyval.expr = new Tree.NewClass(val_peek(2).ident, val_peek(3).loc);
                	}
break;
case 81:
//#line 388 "Parser.y"
{
                		yyval.expr = new Tree.NewArray(val_peek(3).type, val_peek(1).expr, val_peek(4).loc);
                	}
break;
case 82:
//#line 392 "Parser.y"
{
                		yyval.expr = new Tree.TypeTest(val_peek(3).expr, val_peek(1).ident, val_peek(5).loc);
                	}
break;
case 83:
//#line 396 "Parser.y"
{
                		yyval.expr = new Tree.TypeCast(val_peek(2).ident, val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 84:
//#line 402 "Parser.y"
{
						yyval.expr = new Tree.Literal(val_peek(0).typeTag, val_peek(0).literal, val_peek(0).loc);
					}
break;
case 85:
//#line 406 "Parser.y"
{
						yyval.expr = new Null(val_peek(0).loc);
					}
break;
case 87:
//#line 413 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.elist = new ArrayList<Tree.Expr>();
                	}
break;
case 88:
//#line 420 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
					}
break;
case 89:
//#line 424 "Parser.y"
{
                		yyval.elist = new ArrayList<Tree.Expr>();
						yyval.elist.add(val_peek(0).expr);
                	}
break;
case 90:
//#line 431 "Parser.y"
{
						yyval.stmt = new Tree.WhileLoop(val_peek(2).expr, val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 91:
//#line 437 "Parser.y"
{
						yyval.stmt = new Tree.ForLoop(val_peek(6).stmt, val_peek(4).expr, val_peek(2).stmt, val_peek(0).stmt, val_peek(8).loc);
					}
break;
case 92:
//#line 443 "Parser.y"
{
						if (val_peek(6).vdef == null)
							yyval.stmt = new Tree.ForEach(null, val_peek(6).lvalue, val_peek(4).expr, val_peek(2).expr, val_peek(0).stmt, val_peek(8).loc);
						else
							yyval.stmt = new Tree.ForEach(val_peek(6).vdef, null, val_peek(4).expr, val_peek(2).expr, val_peek(0).stmt, val_peek(8).loc);
					}
break;
case 93:
//#line 450 "Parser.y"
{
						if (val_peek(4).vdef == null)
							yyval.stmt = new Tree.ForEach(null, val_peek(4).lvalue, val_peek(2).expr, new Tree.Literal(Tree.BOOL, true,val_peek(1).loc), val_peek(0).stmt, val_peek(6).loc);
						else
							yyval.stmt = new Tree.ForEach(val_peek(4).vdef, null, val_peek(2).expr, new Tree.Literal(Tree.BOOL, true, val_peek(1).loc), val_peek(0).stmt, val_peek(6).loc);
					}
break;
case 96:
//#line 463 "Parser.y"
{
						yyval.stmt = new Tree.Break(val_peek(0).loc);
					}
break;
case 97:
//#line 469 "Parser.y"
{
						yyval.stmt = new Tree.If(val_peek(3).expr, val_peek(1).stmt, val_peek(0).stmt, val_peek(5).loc);
					}
break;
case 98:
//#line 475 "Parser.y"
{
						yyval.stmt = val_peek(0).stmt;
					}
break;
case 99:
//#line 479 "Parser.y"
{
						yyval = new SemValue();
					}
break;
case 100:
//#line 485 "Parser.y"
{
						yyval.stmt = new Tree.Return(val_peek(0).expr, val_peek(1).loc);
					}
break;
case 101:
//#line 489 "Parser.y"
{
                		yyval.stmt = new Tree.Return(null, val_peek(0).loc);
                	}
break;
case 102:
//#line 495 "Parser.y"
{
						yyval.stmt = new Print(val_peek(1).elist, val_peek(3).loc);
					}
break;
//#line 1406 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    //if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      //if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        //if (yychar<0) yychar=0;  //clean, if necessary
        //if (yydebug)
          //yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      //if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
//## The -Jnorun option was used ##
//## end of method run() ########################################



//## Constructors ###############################################
//## The -Jnoconstruct option was used ##
//###############################################################



}
//################### END OF CLASS ##############################
