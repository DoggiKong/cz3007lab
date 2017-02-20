package parser;

import beaver.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "parser.beaver".
 */
public class Parser extends beaver.Parser {
	static public class Terminals {
		static public final short EOF = 0;
		static public final short ID = 1;
		static public final short LBRACKET = 2;
		static public final short LPAREN = 3;
		static public final short MINUS = 4;
		static public final short STRING_LITERAL = 5;
		static public final short INT_LITERAL = 6;
		static public final short TRUE = 7;
		static public final short FALSE = 8;
		static public final short RCURLY = 9;
		static public final short INT = 10;
		static public final short BOOLEAN = 11;
		static public final short VOID = 12;
		static public final short RPAREN = 13;
		static public final short LCURLY = 14;
		static public final short SEMICOLON = 15;
		static public final short RBRACKET = 16;
		static public final short IF = 17;
		static public final short WHILE = 18;
		static public final short BREAK = 19;
		static public final short RETURN = 20;
		static public final short PUBLIC = 21;
		static public final short EQL = 22;
		static public final short IMPORT = 23;
		static public final short COMMA = 24;
		static public final short PLUS = 25;
		static public final short TIMES = 26;
		static public final short DIV = 27;
		static public final short MOD = 28;
		static public final short TYPE = 29;
		static public final short MODULE = 30;
		static public final short ELSE = 31;
		static public final short EQEQ = 32;
		static public final short NEQ = 33;
		static public final short LT = 34;
		static public final short LEQ = 35;
		static public final short GT = 36;
		static public final short GEQ = 37;
	}

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9p5LWbRLLKKNVSozI86HK0QK4aHK2HGn3G8POOefInBSMe0SHuAXr8RD2rfi1$HrwHbMPO" +
		"Dsc1bgPLDQjf0Da#QPc2wM$Uy8#zoUPS7oFVvthVEtllijVU#zzmp0UOwJC0eN8iIt8YRK8" +
		"t9k0vvc8lBCHA9c8y5w8zuz4O2BiH5k1YNa5$guEV3HD9PvnaZHx4G0mBcYMsJftr#MYVvw" +
		"PtaPpdujsCARa4H9c8IfkDcEO1bM8x5A4C$#GjBa8mX68fiLzuLw8TQUTADXz6Q5qJUbQXn" +
		"vGLhtaEi#oVkTEM5Q5uOUNzWXUlpYPSd$v5t17UqyFoDprWrFkwUA3LoL#CgnxECn$MuGKw" +
		"YgfDPKvH7HMEgNyPbhh4vhfvSLq#vg#TMvN6#LoH2SHxEnmNIZE5EhnhDIccIZMtYOX2D1j" +
		"IY5#BGnu$VQTUmaiTR2PTY1kem4xCm6tC2HZhjGiVgTFgB0$W3sP48ryyPYGYjhSPzQbweL" +
		"fhGLy#u9lcALWyCn63qv7Yinhsucsq3smRSZpLw1dlRGV83Kf61J0pZMXc10gwy2bJY7chN" +
		"O1fkmpZv6$Em2ejGZxLu04jn5rRAZtWG3sCT7iKZ05TDCkkbC5CQ1h5kEcTx1cTH9jVxK6R" +
		"EvdVCONRhQu$YcitroqzaxRFFOt1$xOuyvvPllKKGTwKGheKmVd4Fltaulxh96M3vUl3Rnd" +
		"2ck$7Yo0lcF7BZ5McUGLu5zsCtNgJcnGUeMw9vdW0ykF3SnoVGo1MqgU4zMppqT2MhDxfhi" +
		"TthSRvN7a#mVAxICNotg3PUh#tX$k3qM3snjAtTpk0UwJ$IPoUqgjIN9sSIzyV#l6q4YdJQ" +
		"pdVhh3#GxNjEdsReUU5jhP4wC#EiVn3$VRXVnv9dxThMo9GIKRoBU7dUjfoZ5a5k13r5H34" +
		"hHzFkJIs2MWGrGts5Q3MYSKfQ$I6glmHHl0F4SxwlNmdr2oOE48U8VO2nbV8aPI$0BA2CeY" +
		"obpASifzn0MKYvct8SCO7wTk9jnksXt6dbRG$ax6LSdgx$EEr6hREsMKPKiI#NiffzZPGvs" +
		"d$2AyrQ#Z#Zd48PhlicwznFQ7jgwvhOHDz1pTb57AMoWxAP64o#gUDw#cBCkKGICLtRyyZT" +
		"GZb3szE8DDjxLGHwTnlt7SRMjEupiuYP7OitPscvX0s$XpbRvzr6VOv#vytKvslz2FK5cXD" +
		"2VQ6EdqHC9Eg9PTgVe7tBYJg2fhdOLdiLiPHOvEl32fl#CdFOV6U#YN5An#knDi9iEMDiyK" +
		"aT6GCxH6I$JJzjgvsbSuvaZKIjLzdy1RglpfwF$MFTQj5NhMCUOotE8pELUfmr5#Wxh3d77" +
		"J6E$6Xs#ErZaT7HzsRS03zzzHsDxqxmkUEw63VQAx4U#YUdv9YIntnm$kHVEIpVIwDy9z$A" +
		"D$ArwZkaseEjU5$AVhRxMkmlYCy9xY3ogNmY7mldgtma7xBzWE1E9jk8hVAAvQ6sI$OekKc" +
		"UbOtodEoMj#HrUKrUbJTaYxmaByfcUK6ULvmDyemyhRIdv4tPBZlbVNbFtfKTmXKlU$Kp$6" +
		"nbb5#K$gjgVrVjRorF#HDneiNwHuxhSJbDCPutg53kvS44UCAODe3dZOSdJZ3Fd52UFmO1d" +
		"Zf62uRPaCspmubIvYcaBAH$U3l88MS4KQPkjk0jCPJdaqbOgos4DqQJTqOBGRmvchmz60gP" +
		"j0TIMaZXSretYYpsLL3wGmPz6PH56aDeM$VfOXkIcJ#PChKTfB5M0MEjcnbFDfxjGJpT3OL" +
		"qwfN$0qmySBK=");

	static final Action RETURN6 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 6];
		}
	};

	static final Action RETURN4 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 4];
		}
	};

	static final Action RETURN2 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 2];
		}
	};

	static final Action RETURN9 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 9];
		}
	};

	static final Action RETURN3 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 3];
		}
	};

	static final Action RETURN5 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 5];
		}
	};

	// turn off automated error recovery
	@Override
	protected void recoverFromError(Symbol token, TokenStream in) throws java.io.IOException, Exception {
		super.recoverFromError(new Symbol(0), in);
	}

	private final Action[] actions;

	public Parser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			RETURN6,	// [0] Module = MODULE ID LCURLY Import Declaration RCURLY; returns 'RCURLY' although none is marked
			RETURN4,	// [1] Import = IMPORT ID SEMICOLON Import; returns 'Import' although none is marked
			Action.NONE,  	// [2] Import = 
			RETURN2,	// [3] Declaration = Function_Declaration Declaration; returns 'Declaration' although none is marked
			RETURN2,	// [4] Declaration = Field_Declaration Declaration; returns 'Declaration' although none is marked
			RETURN2,	// [5] Declaration = Type_Declaration Declaration; returns 'Declaration' although none is marked
			Action.NONE,  	// [6] Declaration = 
			RETURN9,	// [7] Function_Declaration = Accessibility Type_Name ID LPAREN Parameter_List RPAREN LCURLY Statement RCURLY; returns 'RCURLY' although none is marked
			RETURN4,	// [8] Field_Declaration = Accessibility Type_Name ID SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN6,	// [9] Type_Declaration = Accessibility TYPE ID EQL STRING_LITERAL SEMICOLON; returns 'SEMICOLON' although none is marked
			Action.RETURN,	// [10] Accessibility = PUBLIC
			Action.NONE,  	// [11] Accessibility = 
			Action.RETURN,	// [12] Type_Name = Primitive_Type
			Action.RETURN,	// [13] Type_Name = Array_Type
			Action.RETURN,	// [14] Type_Name = ID
			Action.RETURN,	// [15] Primitive_Type = VOID
			Action.RETURN,	// [16] Primitive_Type = INT
			Action.RETURN,	// [17] Primitive_Type = BOOLEAN
			RETURN3,	// [18] Array_Type = INT LBRACKET RBRACKET; returns 'RBRACKET' although none is marked
			RETURN3,	// [19] Array_Type = BOOLEAN LBRACKET RBRACKET; returns 'RBRACKET' although none is marked
			RETURN3,	// [20] Array_Type = VOID LBRACKET RBRACKET; returns 'RBRACKET' although none is marked
			RETURN3,	// [21] Array_Type = ID LBRACKET RBRACKET; returns 'RBRACKET' although none is marked
			RETURN3,	// [22] Array_Type = Array_Type LBRACKET RBRACKET; returns 'RBRACKET' although none is marked
			RETURN2,	// [23] Parameter = Type_Name ID; returns 'ID' although none is marked
			RETURN3,	// [24] Parameter_List = Parameter COMMA Parameter_List; returns 'Parameter_List' although none is marked
			Action.RETURN,	// [25] Parameter_List = Parameter
			Action.RETURN,	// [26] Statement = Local_Variable
			Action.RETURN,	// [27] Statement = Block_Statement
			Action.RETURN,	// [28] Statement = If_Statement
			Action.RETURN,	// [29] Statement = While_Statement
			Action.RETURN,	// [30] Statement = Break_Statement
			Action.RETURN,	// [31] Statement = Return_Statement
			Action.RETURN,	// [32] Statement = Expression_Statement
			RETURN3,	// [33] Local_Variable = Type_Name ID SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN3,	// [34] Block_Statement = LCURLY Statement_List RCURLY; returns 'RCURLY' although none is marked
			RETURN2,	// [35] Statement_List = Statement Statement_List; returns 'Statement_List' although none is marked
			Action.NONE,  	// [36] Statement_List = 
			RETURN6,	// [37] If_Statement = IF LPAREN Expression RPAREN Statement Else_Optional; returns 'Else_Optional' although none is marked
			RETURN2,	// [38] Else_Optional = ELSE Statement; returns 'Statement' although none is marked
			Action.NONE,  	// [39] Else_Optional = 
			RETURN5,	// [40] While_Statement = WHILE LPAREN Expression RPAREN Statement; returns 'Statement' although none is marked
			RETURN2,	// [41] Break_Statement = BREAK SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN2,	// [42] Return_Statement = RETURN SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN3,	// [43] Return_Statement = RETURN Expression SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN2,	// [44] Expression_Statement = Expression SEMICOLON; returns 'SEMICOLON' although none is marked
			Action.RETURN,	// [45] Expression = Assignment
			Action.RETURN,	// [46] Expression = RHS_Expression
			RETURN3,	// [47] Assignment = LHS_Expression EQL Expression; returns 'Expression' although none is marked
			Action.RETURN,	// [48] LHS_Expression = ID
			Action.RETURN,	// [49] LHS_Expression = Array_Access
			RETURN4,	// [50] Array_Access = LHS_Expression LBRACKET Expression RBRACKET; returns 'RBRACKET' although none is marked
			Action.RETURN,	// [51] RHS_Expression = Arithmetic_Expression
			RETURN3,	// [52] RHS_Expression = Arithmetic_Expression Comparison_Operator Arithmetic_Expression; returns 'Arithmetic_Expression' although none is marked
			Action.RETURN,	// [53] Comparison_Operator = EQEQ
			Action.RETURN,	// [54] Comparison_Operator = NEQ
			Action.RETURN,	// [55] Comparison_Operator = LT
			Action.RETURN,	// [56] Comparison_Operator = LEQ
			Action.RETURN,	// [57] Comparison_Operator = GT
			Action.RETURN,	// [58] Comparison_Operator = GEQ
			new Action() {	// [59] Arithmetic_Expression = Arithmetic_Expression Additive_Operator Term
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 3]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [60] Arithmetic_Expression = Term
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			Action.RETURN,	// [61] Additive_Operator = PLUS
			Action.RETURN,	// [62] Additive_Operator = MINUS
			new Action() {	// [63] Term = Term Multiplicative_Operator Factor
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 3]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [64] Term = Factor
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			Action.RETURN,	// [65] Multiplicative_Operator = TIMES
			Action.RETURN,	// [66] Multiplicative_Operator = DIV
			Action.RETURN,	// [67] Multiplicative_Operator = MOD
			RETURN2,	// [68] Factor = MINUS Factor; returns 'Factor' although none is marked
			Action.RETURN,	// [69] Factor = Primary_Expression
			Action.RETURN,	// [70] Primary_Expression = LHS_Expression
			Action.RETURN,	// [71] Primary_Expression = Function_Call
			Action.RETURN,	// [72] Primary_Expression = Array_Expression
			Action.RETURN,	// [73] Primary_Expression = STRING_LITERAL
			Action.RETURN,	// [74] Primary_Expression = INT_LITERAL
			Action.RETURN,	// [75] Primary_Expression = Boolean_Literal
			Action.RETURN,	// [76] Primary_Expression = Paren_Expression
			RETURN4,	// [77] Function_Call = ID LPAREN Expression_List RPAREN; returns 'RPAREN' although none is marked
			RETURN3,	// [78] Expression_List = Expression COMMA Expression_List; returns 'Expression_List' although none is marked
			Action.RETURN,	// [79] Expression_List = Expression
			Action.NONE,  	// [80] Expression_List = 
			RETURN3,	// [81] Array_Expression = LBRACKET Expression_List RBRACKET; returns 'RBRACKET' although none is marked
			Action.RETURN,	// [82] Boolean_Literal = TRUE
			Action.RETURN,	// [83] Boolean_Literal = FALSE
			RETURN3	// [84] Paren_Expression = LPAREN Expression RPAREN; returns 'RPAREN' although none is marked
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
