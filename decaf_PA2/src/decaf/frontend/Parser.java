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
public final static short FOREACH=291;
public final static short IN=292;
public final static short UMINUS=293;
public final static short EMPTY=294;
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
final static short yysindex[] = {                      -242,
 -251, -234,    0, -242,    0, -232, -243,    0, -240,  -86,
 -232,    0,    0,  -70, -104,    0,    0,    0,    0,    0,
 -216, -123,    0,    0,    8,  -88,    0,  -56,    0,  -87,
    0,   33,  -13,    0,   39, -123,    0, -123,    0,  -85,
   20,   45,   40,    0,  -24, -123,  -24,    0,    0,    0,
    0,    2,    0,    0,   51,   60,  -20,  119,    0,  162,
   64,   68,   69,    0,   70,  119,  119,   62,    0,   72,
 -163,   79,    0,    0,    0,   61,    0,    0,    0,   63,
   65,   71,   80,    0,    0,  945,   67,    0, -153,    0,
    0,  119,  119,  119,    6,  945,    0,    0,  101,   52,
  119,  103,  107,  119,  -29,  -29, -134,  536, -127,    0,
 -173,    0,    0,    0,    0,    0,  119,  119,  119,  119,
  119,  119,  119,  119,  119,  119,  119,  119,  119,    0,
  119,  119,  119,  110,  562,   92,  592,    0,  119,  117,
   81,  945,   11,    0,    0,  735,  120,    0,  118,    0,
    0, -129, 1025, 1014,  624,  624,  -32,  -32,   -8,   -8,
  -29,  -29,  -29,  624,  624,  761,    3,  945,  119,   37,
  119,   37,  820, -117,    0,  842,  119,    0, -110,  119,
  119,  119, -121,  126,  127,    0,  863,  -95,   37,    0,
    0,    0,  945,  131,    0,  895,  484,  119,    0,  119,
   37,    0,    0,    0,    0,  119,   37,    0,  135,    0,
  919,    0,   37,   37,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,  177,    0,   55,    0,    0,    0,    0,
   55,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  121,    0,    0,    0,  138,    0,  138,    0,    0,
    0,  143,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -58,    0,    0,    0,    0,    0,  -57,    0,    0,
    0,    0,    0,    0,    0,  -91,  -91,  -91,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  986,  510,    0,    0,
    0,  -91,  -58,  -91,  100,  128,    0,    0,    0,    0,
  -91,    0,    0,  -91,  403,  412,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  -91,  -91,  -91,  -91,
  -91,  -91,  -91,  -91,  -91,  -91,  -91,  -91,  -91,    0,
  -91,  -91,  -91,  153,    0,    0,    0,    0,  -91,    0,
  -91,   34,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   88,   13,  572,  996,  124,  582,  885, 1147,
  439,  448,  475, 1034, 1055,    0, 1071,  -18,  -25,  -58,
  -91,  -58,    0,    0,    0,    0,  -91,    0,    0,  -91,
  -91,  -91,  367,    0,  145,    0,    0,  -33,  -58,    0,
    0,    0,   57,    0,    0,    0,    0,  -91,    0,  -23,
  -58,    0,    0,    0,    0,  -91,  -58,    0,    0,    0,
    0,    0,  -58,  -58,    0,    0,
};
final static short yygindex[] = {                         0,
    0,  188,   28,  -14,   36,  182,  190,    0,  169,    0,
   21,    0,  -96,  -84,    0,    0,    0,    0,    0,    0,
    0,    0,    0, 1322,    0,    0, 1042, 1087,    0,   97,
    0,    0,   41,    0,    0,
};
final static int YYTABLESIZE=1528;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         99,
   48,  101,   33,   33,  127,   33,   99,  190,  136,  125,
  123,   99,  124,  130,  126,   87,  130,   48,    1,   94,
   23,   39,   46,   39,    6,   99,    7,  129,  127,  128,
    9,   50,   11,  125,   67,   12,   13,  130,  126,  127,
   46,   68,   24,    2,  125,  123,   66,  124,  130,  126,
   26,  178,   16,   73,  177,   24,   73,   30,  131,   29,
   45,  131,  129,   26,  128,   49,   31,   51,   34,   67,
   73,   73,   36,  186,   89,  188,   68,   89,   38,   37,
   47,   66,  131,   17,   18,   19,   20,   21,   46,   99,
   92,   99,  203,  131,   67,  100,  150,   88,   48,   93,
   88,   68,   95,  101,  210,   73,   66,  102,  103,  104,
  212,  109,  110,   67,   71,  209,  215,  216,  111,  112,
   68,  113,  134,  114,   48,   66,   69,  133,   72,  115,
  138,   72,   44,   17,   18,   19,   20,   21,  116,   44,
  140,  147,  141,  144,   44,   72,   72,  145,  149,  169,
  171,   67,   17,   18,   19,   20,   21,  175,   68,   48,
  180,  181,  182,   66,   64,  194,  199,   64,  198,  191,
  177,  204,  201,   37,   22,  213,    1,   15,   20,    5,
   72,   64,   64,   19,   50,   86,  100,   32,   35,   51,
   44,    8,   14,   51,   51,   51,   51,   51,   51,   51,
   17,   18,   19,   20,   21,   28,   43,  151,    0,  185,
   51,   51,   51,   51,   51,    0,   64,   50,   50,    0,
    0,    0,   22,   99,   99,   99,   99,   99,   99,    0,
   99,   99,   99,   99,    0,   99,   99,   99,   99,   99,
   99,   99,   99,   51,    0,   51,   99,    0,  119,  120,
   50,   99,   50,   99,   99,    0,  132,   99,   17,   18,
   19,   20,   21,   53,    0,   54,   55,   56,   57,    0,
   58,   59,   60,   61,   62,   63,   64,   73,    0,    0,
    0,   65,    0,  119,  120,    0,   70,    0,    0,   71,
   73,    0,   72,   17,   18,   19,   20,   21,   53,    0,
   54,   55,   56,   57,    0,   58,   59,   60,   61,   62,
   63,   64,    0,    0,    0,    0,   65,    0,    0,    0,
    0,   70,  107,   53,   71,   54,    0,   72,    0,    0,
    0,    0,   60,    0,   62,   63,   64,    0,    0,    0,
    0,   65,   53,    0,   54,    0,    0,    0,    0,   71,
    0,   60,   72,   62,   63,   64,    0,    0,    0,    0,
   65,   44,    0,   44,   72,   72,    0,    0,   71,    0,
   44,    0,   44,   44,   44,   44,    0,    0,    0,   44,
   53,    0,   54,    0,    0,    0,    0,   44,   64,   60,
    0,   62,   63,   64,    0,    0,    0,    0,   65,    0,
   64,   64,    0,   52,    0,    0,   71,   52,   52,   52,
   52,   52,   52,   52,    0,    0,    0,   51,   17,   18,
   19,   20,   21,    0,   52,   52,   52,   52,   52,   51,
   51,    0,    0,   51,   51,   51,   51,   99,    0,   75,
    0,   51,    0,   75,   75,   75,   75,   75,   76,   75,
    0,    0,   76,   76,   76,   76,   76,   52,   76,   52,
   75,   75,   75,    0,   75,    0,    0,    0,    0,   76,
   76,   76,    0,   76,    0,   61,    0,    0,    0,   61,
   61,   61,   61,   61,   62,   61,    0,    0,   62,   62,
   62,   62,   62,    0,   62,   75,   61,   61,   61,    0,
   61,    0,    0,    0,   76,   62,   62,   62,    0,   62,
    0,   63,    0,    0,    0,   63,   63,   63,   63,   63,
  127,   63,    0,    0,  207,  125,  123,    0,  124,  130,
  126,   61,   63,   63,   63,    0,   63,    0,    0,    0,
   62,    0,    0,  129,    0,  128,   57,    0,    0,    0,
   47,   57,   57,    0,   57,   57,   57,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   63,   47,   57,
    0,   57,  127,    0,  131,    0,  148,  125,  123,    0,
  124,  130,  126,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  129,    0,  128,  127,    0,
   57,    0,  170,  125,  123,    0,  124,  130,  126,    0,
    0,    0,   70,    0,    0,   70,    0,    0,    0,    0,
    0,  129,   65,  128,    0,   65,  131,    0,  127,   70,
   70,   52,  172,  125,  123,    0,  124,  130,  126,   65,
   65,    0,    0,   52,   52,    0,    0,   52,   52,   52,
   52,  129,  131,  128,    0,   52,    0,    0,    0,    0,
  127,    0,    0,    0,   70,  125,  123,   75,  124,  130,
  126,    0,    0,    0,   65,    0,   76,    0,    0,   75,
   75,    0,  131,   75,   75,   75,   75,    0,   76,   76,
    0,   75,   76,   76,   76,   76,    0,    0,    0,    0,
   76,    0,    0,   61,    0,    0,    0,    0,    0,    0,
    0,    0,   62,    0,  131,   61,   61,    0,    0,   61,
   61,   61,   61,    0,   62,   62,    0,   61,   62,   62,
   62,   62,    0,    0,    0,    0,   62,    0,    0,   63,
    0,    0,    0,    0,    0,    0,    0,    0,  206,    0,
    0,   63,   63,    0,    0,   63,   63,   63,   63,    0,
  117,  118,    0,   63,  119,  120,  121,  122,    0,    0,
    0,  127,  132,    0,    0,    0,  125,  123,  179,  124,
  130,  126,    0,    0,    0,    0,   57,   57,    0,    0,
   57,   57,   57,   57,  129,    0,  128,  127,   57,    0,
    0,    0,  125,  123,    0,  124,  130,  126,    0,    0,
    0,    0,  117,  118,    0,    0,  119,  120,  121,  122,
  129,    0,  128,    0,  132,  131,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   70,    0,  117,  118,
    0,    0,  119,  120,  121,  122,   65,    0,   70,   70,
  132,  131,    0,  183,   70,   70,  127,    0,   65,   65,
   70,  125,  123,    0,  124,  130,  126,    0,  117,  118,
    0,    0,  119,  120,  121,  122,    0,  189,  127,  129,
  132,  128,    0,  125,  123,    0,  124,  130,  126,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  127,
    0,  129,    0,  128,  125,  123,    0,  124,  130,  126,
  131,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  200,  129,    0,  128,   59,    0,   59,   59,   59,
    0,  127,  131,    0,  192,  205,  125,  123,    0,  124,
  130,  126,   59,   59,   59,    0,   59,    0,    0,    0,
    0,    0,    0,  131,  129,  127,  128,    0,    0,  214,
  125,  123,    0,  124,  130,  126,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   59,  129,    0,
  128,  127,    0,    0,    0,  131,  125,  123,    0,  124,
  130,  126,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  129,    0,  128,    0,    0,  131,
    0,  117,  118,    0,    0,  119,  120,  121,  122,    0,
    0,    0,   56,  132,    0,    0,    0,   56,   56,    0,
   56,   56,   56,    0,    0,  131,   71,  117,  118,   71,
    0,  119,  120,  121,  122,   56,    0,   56,    0,  132,
  127,    0,    0,   71,   71,  125,  123,    0,  124,  130,
  126,  127,    0,    0,    0,    0,  125,  123,    0,  124,
  130,  126,    0,  129,   67,  128,   56,   67,    0,    0,
    0,    0,    0,    0,  129,    0,  128,    0,   71,    0,
    0,   67,   67,   87,    0,   66,  117,  118,   66,    0,
  119,  120,  121,  122,  131,    0,    0,    0,  132,    0,
    0,   68,   66,   66,   68,  131,    0,    0,  117,  118,
    0,    0,  119,  120,  121,  122,   67,    0,   68,   68,
  132,    0,    0,    0,   87,    0,    0,    0,   88,  117,
  118,    0,    0,  119,  120,  121,  122,   66,    0,   59,
    0,  132,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   59,   59,   68,    0,   59,   59,   59,   59,    0,
    0,  117,  118,   59,    0,  119,  120,  121,  122,   88,
    0,    0,    0,  132,    0,    0,    0,   60,    0,   60,
   60,   60,    0,    0,    0,  117,  118,    0,    0,  119,
  120,  121,  122,    0,   60,   60,   60,  132,   60,    0,
    0,   87,    0,   87,    0,    0,    0,    0,    0,    0,
    0,  117,  118,    0,    0,  119,  120,  121,  122,    0,
   87,    0,    0,  132,    0,    0,    0,    0,    0,   60,
    0,   87,   87,    0,    0,    0,    0,    0,   87,    0,
    0,    0,    0,    0,   87,   87,   88,    0,   88,    0,
   71,    0,   56,   56,    0,    0,   56,   56,   56,   56,
    0,    0,   71,   71,   56,   88,    0,    0,   71,   71,
    0,    0,    0,    0,   71,    0,   88,   88,    0,    0,
  117,    0,    0,   88,  119,  120,  121,  122,   67,   88,
   88,    0,  132,    0,    0,  119,  120,  121,  122,    0,
   67,   67,    0,  132,    0,    0,   67,   67,    0,   66,
    0,    0,   67,    0,    0,    0,    0,    0,    0,    0,
    0,   66,   66,    0,    0,   68,    0,   66,   66,    0,
    0,    0,    0,   66,    0,    0,    0,   68,   68,    0,
    0,    0,    0,   68,   68,    0,    0,    0,    0,   68,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   96,
    0,    0,    0,    0,    0,    0,    0,  105,  106,  108,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   60,    0,  135,    0,  137,    0,    0,    0,    0,
    0,    0,  142,   60,   60,  146,    0,   60,   60,   60,
   60,    0,    0,    0,    0,   60,    0,    0,  153,  154,
  155,  156,  157,  158,  159,  160,  161,  162,  163,  164,
  165,    0,  166,  167,  168,    0,    0,    0,    0,    0,
  173,    0,  176,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  142,    0,  187,    0,    0,    0,    0,    0,  193,    0,
    0,  195,  196,  197,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  208,
    0,    0,    0,    0,    0,    0,    0,  211,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
   59,   59,   91,   91,   37,   91,   40,  125,   93,   42,
   43,   45,   45,   46,   47,   41,   46,   41,  261,   40,
  125,   36,   41,   38,  276,   59,  261,   60,   37,   62,
  263,   46,  276,   42,   33,  276,  123,   46,   47,   37,
   59,   40,   15,  286,   42,   43,   45,   45,   46,   47,
   15,   41,  123,   41,   44,   28,   44,   22,   91,  276,
   41,   91,   60,   28,   62,   45,   59,   47,  125,   33,
   58,   59,   40,  170,   41,  172,   40,   44,   40,   93,
   41,   45,   91,  257,  258,  259,  260,  261,   44,  123,
   40,  125,  189,   91,   33,   60,  111,   41,  123,   40,
   44,   40,  123,   40,  201,   93,   45,   40,   40,   40,
  207,   40,  276,   33,  288,  200,  213,  214,   40,   59,
   40,   59,  276,   59,  123,   45,  125,   61,   41,   59,
  125,   44,   33,  257,  258,  259,  260,  261,   59,   40,
   40,  276,   91,   41,   45,   58,   59,   41,  276,   40,
   59,   33,  257,  258,  259,  260,  261,   41,   40,  123,
   41,   44,  292,   45,   41,  276,   41,   44,  290,  287,
   44,   41,  268,   93,  279,   41,    0,  123,   41,   59,
   93,   58,   59,   41,  276,   41,   59,  276,  276,   37,
  276,    4,   11,   41,   42,   43,   44,   45,   46,   47,
  257,  258,  259,  260,  261,   16,   38,  111,   -1,  169,
   58,   59,   60,   61,   62,   -1,   93,  276,  276,   -1,
   -1,   -1,  279,  257,  258,  259,  260,  261,  262,   -1,
  264,  265,  266,  267,   -1,  269,  270,  271,  272,  273,
  274,  275,  276,   91,   -1,   93,  280,   -1,  281,  282,
  276,  285,  276,  287,  288,   -1,  289,  291,  257,  258,
  259,  260,  261,  262,   -1,  264,  265,  266,  267,   -1,
  269,  270,  271,  272,  273,  274,  275,  265,   -1,   -1,
   -1,  280,   -1,  281,  282,   -1,  285,   -1,   -1,  288,
  278,   -1,  291,  257,  258,  259,  260,  261,  262,   -1,
  264,  265,  266,  267,   -1,  269,  270,  271,  272,  273,
  274,  275,   -1,   -1,   -1,   -1,  280,   -1,   -1,   -1,
   -1,  285,  261,  262,  288,  264,   -1,  291,   -1,   -1,
   -1,   -1,  271,   -1,  273,  274,  275,   -1,   -1,   -1,
   -1,  280,  262,   -1,  264,   -1,   -1,   -1,   -1,  288,
   -1,  271,  265,  273,  274,  275,   -1,   -1,   -1,   -1,
  280,  262,   -1,  264,  277,  278,   -1,   -1,  288,   -1,
  271,   -1,  273,  274,  275,  276,   -1,   -1,   -1,  280,
  262,   -1,  264,   -1,   -1,   -1,   -1,  288,  265,  271,
   -1,  273,  274,  275,   -1,   -1,   -1,   -1,  280,   -1,
  277,  278,   -1,   37,   -1,   -1,  288,   41,   42,   43,
   44,   45,   46,   47,   -1,   -1,   -1,  265,  257,  258,
  259,  260,  261,   -1,   58,   59,   60,   61,   62,  277,
  278,   -1,   -1,  281,  282,  283,  284,  276,   -1,   37,
   -1,  289,   -1,   41,   42,   43,   44,   45,   37,   47,
   -1,   -1,   41,   42,   43,   44,   45,   91,   47,   93,
   58,   59,   60,   -1,   62,   -1,   -1,   -1,   -1,   58,
   59,   60,   -1,   62,   -1,   37,   -1,   -1,   -1,   41,
   42,   43,   44,   45,   37,   47,   -1,   -1,   41,   42,
   43,   44,   45,   -1,   47,   93,   58,   59,   60,   -1,
   62,   -1,   -1,   -1,   93,   58,   59,   60,   -1,   62,
   -1,   37,   -1,   -1,   -1,   41,   42,   43,   44,   45,
   37,   47,   -1,   -1,   41,   42,   43,   -1,   45,   46,
   47,   93,   58,   59,   60,   -1,   62,   -1,   -1,   -1,
   93,   -1,   -1,   60,   -1,   62,   37,   -1,   -1,   -1,
   41,   42,   43,   -1,   45,   46,   47,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   93,   59,   60,
   -1,   62,   37,   -1,   91,   -1,   41,   42,   43,   -1,
   45,   46,   47,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   60,   -1,   62,   37,   -1,
   91,   -1,   41,   42,   43,   -1,   45,   46,   47,   -1,
   -1,   -1,   41,   -1,   -1,   44,   -1,   -1,   -1,   -1,
   -1,   60,   41,   62,   -1,   44,   91,   -1,   37,   58,
   59,  265,   41,   42,   43,   -1,   45,   46,   47,   58,
   59,   -1,   -1,  277,  278,   -1,   -1,  281,  282,  283,
  284,   60,   91,   62,   -1,  289,   -1,   -1,   -1,   -1,
   37,   -1,   -1,   -1,   93,   42,   43,  265,   45,   46,
   47,   -1,   -1,   -1,   93,   -1,  265,   -1,   -1,  277,
  278,   -1,   91,  281,  282,  283,  284,   -1,  277,  278,
   -1,  289,  281,  282,  283,  284,   -1,   -1,   -1,   -1,
  289,   -1,   -1,  265,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  265,   -1,   91,  277,  278,   -1,   -1,  281,
  282,  283,  284,   -1,  277,  278,   -1,  289,  281,  282,
  283,  284,   -1,   -1,   -1,   -1,  289,   -1,   -1,  265,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,   -1,
   -1,  277,  278,   -1,   -1,  281,  282,  283,  284,   -1,
  277,  278,   -1,  289,  281,  282,  283,  284,   -1,   -1,
   -1,   37,  289,   -1,   -1,   -1,   42,   43,   44,   45,
   46,   47,   -1,   -1,   -1,   -1,  277,  278,   -1,   -1,
  281,  282,  283,  284,   60,   -1,   62,   37,  289,   -1,
   -1,   -1,   42,   43,   -1,   45,   46,   47,   -1,   -1,
   -1,   -1,  277,  278,   -1,   -1,  281,  282,  283,  284,
   60,   -1,   62,   -1,  289,   91,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  265,   -1,  277,  278,
   -1,   -1,  281,  282,  283,  284,  265,   -1,  277,  278,
  289,   91,   -1,   93,  283,  284,   37,   -1,  277,  278,
  289,   42,   43,   -1,   45,   46,   47,   -1,  277,  278,
   -1,   -1,  281,  282,  283,  284,   -1,   58,   37,   60,
  289,   62,   -1,   42,   43,   -1,   45,   46,   47,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   37,
   -1,   60,   -1,   62,   42,   43,   -1,   45,   46,   47,
   91,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   59,   60,   -1,   62,   41,   -1,   43,   44,   45,
   -1,   37,   91,   -1,   93,   41,   42,   43,   -1,   45,
   46,   47,   58,   59,   60,   -1,   62,   -1,   -1,   -1,
   -1,   -1,   -1,   91,   60,   37,   62,   -1,   -1,   41,
   42,   43,   -1,   45,   46,   47,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   93,   60,   -1,
   62,   37,   -1,   -1,   -1,   91,   42,   43,   -1,   45,
   46,   47,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   60,   -1,   62,   -1,   -1,   91,
   -1,  277,  278,   -1,   -1,  281,  282,  283,  284,   -1,
   -1,   -1,   37,  289,   -1,   -1,   -1,   42,   43,   -1,
   45,   46,   47,   -1,   -1,   91,   41,  277,  278,   44,
   -1,  281,  282,  283,  284,   60,   -1,   62,   -1,  289,
   37,   -1,   -1,   58,   59,   42,   43,   -1,   45,   46,
   47,   37,   -1,   -1,   -1,   -1,   42,   43,   -1,   45,
   46,   47,   -1,   60,   41,   62,   91,   44,   -1,   -1,
   -1,   -1,   -1,   -1,   60,   -1,   62,   -1,   93,   -1,
   -1,   58,   59,   52,   -1,   41,  277,  278,   44,   -1,
  281,  282,  283,  284,   91,   -1,   -1,   -1,  289,   -1,
   -1,   41,   58,   59,   44,   91,   -1,   -1,  277,  278,
   -1,   -1,  281,  282,  283,  284,   93,   -1,   58,   59,
  289,   -1,   -1,   -1,   93,   -1,   -1,   -1,   52,  277,
  278,   -1,   -1,  281,  282,  283,  284,   93,   -1,  265,
   -1,  289,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  277,  278,   93,   -1,  281,  282,  283,  284,   -1,
   -1,  277,  278,  289,   -1,  281,  282,  283,  284,   93,
   -1,   -1,   -1,  289,   -1,   -1,   -1,   41,   -1,   43,
   44,   45,   -1,   -1,   -1,  277,  278,   -1,   -1,  281,
  282,  283,  284,   -1,   58,   59,   60,  289,   62,   -1,
   -1,  170,   -1,  172,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  277,  278,   -1,   -1,  281,  282,  283,  284,   -1,
  189,   -1,   -1,  289,   -1,   -1,   -1,   -1,   -1,   93,
   -1,  200,  201,   -1,   -1,   -1,   -1,   -1,  207,   -1,
   -1,   -1,   -1,   -1,  213,  214,  170,   -1,  172,   -1,
  265,   -1,  277,  278,   -1,   -1,  281,  282,  283,  284,
   -1,   -1,  277,  278,  289,  189,   -1,   -1,  283,  284,
   -1,   -1,   -1,   -1,  289,   -1,  200,  201,   -1,   -1,
  277,   -1,   -1,  207,  281,  282,  283,  284,  265,  213,
  214,   -1,  289,   -1,   -1,  281,  282,  283,  284,   -1,
  277,  278,   -1,  289,   -1,   -1,  283,  284,   -1,  265,
   -1,   -1,  289,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  277,  278,   -1,   -1,  265,   -1,  283,  284,   -1,
   -1,   -1,   -1,  289,   -1,   -1,   -1,  277,  278,   -1,
   -1,   -1,   -1,  283,  284,   -1,   -1,   -1,   -1,  289,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   58,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   66,   67,   68,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  265,   -1,   92,   -1,   94,   -1,   -1,   -1,   -1,
   -1,   -1,  101,  277,  278,  104,   -1,  281,  282,  283,
  284,   -1,   -1,   -1,   -1,  289,   -1,   -1,  117,  118,
  119,  120,  121,  122,  123,  124,  125,  126,  127,  128,
  129,   -1,  131,  132,  133,   -1,   -1,   -1,   -1,   -1,
  139,   -1,  141,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  169,   -1,  171,   -1,   -1,   -1,   -1,   -1,  177,   -1,
   -1,  180,  181,  182,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  198,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  206,
};
}
final static short YYFINAL=3;
final static short YYMAXTOKEN=294;
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
"SEALED","SEP","VAR","INIT","DEFAULT","FOREACH","IN","UMINUS","EMPTY",
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
//#line 726 "Parser.java"
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
//#line 1393 "Parser.java"
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
