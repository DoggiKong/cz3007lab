package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

import lexer.Lexer;

import org.junit.Test;

import frontend.Token;
import frontend.Token.Type;
import static frontend.Token.Type.*;

/**
 * This class contains unit tests for your lexer. Currently, there is only one
 * test, but you are strongly encouraged to write your own tests.
 */
public class LexerTests {
    // helper method to run tests; no need to change this

    private final void runtest(String input, Token... output) {
        Lexer lexer = new Lexer(new StringReader(input));
        int i = 0;
        Token actual, expected;
        try {
            do {
                assertTrue(i < output.length);
                expected = output[i++];
                try {
                    actual = lexer.nextToken();
                    assertEquals(expected, actual);
                } catch (Error e) {
                    if (expected != null) {
                        fail(e.getMessage());
                    }
                    return;
                }
            } while (!actual.isEOF());
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testModKW() {
        runtest("module",
                new Token(MODULE, 0, 0, "module"),
                new Token(EOF, 0, 6, ""));
    }

    /**
     * Example unit test.
     */
    @Test
    public void testKWs() {
        // first argument to runtest is the string to lex; the remaining arguments
        // are the expected tokens
        runtest("module false return while",
                new Token(MODULE, 0, 0, "module"),
                new Token(FALSE, 0, 7, "false"),
                new Token(RETURN, 0, 13, "return"),
                new Token(WHILE, 0, 20, "while"),
                new Token(EOF, 0, 25, ""));
    }

    @Test
    public void testKWsLine() {
        runtest("module false\n\treturn while",
                new Token(MODULE, 0, 0, "module"),
                new Token(FALSE, 0, 7, "false"),
                new Token(RETURN, 1, 1, "return"),
                new Token(WHILE, 1, 8, "while"),
                new Token(EOF, 1, 13, ""));
    }

    @Test
    public void testOperator() {
        runtest("13==13",
                new Token(INT_LITERAL, 0, 0, "13"),
                new Token(EQEQ, 0, 2, "=="),
                new Token(INT_LITERAL, 0, 4, "13"),
                new Token(EOF, 0, 6, ""));
    }

    @Test
    public void testOperators() {
        runtest("3/3==3/3",
                new Token(INT_LITERAL, 0, 0, "3"),
                new Token(DIV, 0, 1, "/"),
                new Token(INT_LITERAL, 0, 2, "3"),
                new Token(EQEQ, 0, 3, "=="),
                new Token(INT_LITERAL, 0, 5, "3"),
                new Token(DIV, 0, 6, "/"),
                new Token(INT_LITERAL, 0, 7, "3"),
                new Token(EOF, 0, 8, ""));
    }

    @Test
    public void testStringLiteralWithDoubleQuote() {
        runtest("\"\"\"",
                new Token(STRING_LITERAL, 0, 0, ""),
                (Token) null);
    }

    @Test
    public void testStringLiteral() {
        runtest("\"\\n\"",
                new Token(STRING_LITERAL, 0, 0, "\\n"),
                new Token(EOF, 0, 4, ""));

    }

    @Test
    public void testIntLitereral() {
        runtest("123",
                new Token(INT_LITERAL, 0, 0, "123"),
                new Token(EOF, 0, 3, ""));
        runtest("000123",
                new Token(INT_LITERAL, 0, 0, "000123"),
                new Token(EOF, 0, 6, ""));

        // Also need to test for false input
    }

    @Test
    public void testID() {
        runtest("a",
                new Token(ID, 0, 0, "a"),
                new Token(EOF, 0, 1, ""));
        runtest("B",
                new Token(ID, 0, 0, "B"),
                new Token(EOF, 0, 1, ""));
        runtest("DA_142",
                new Token(ID, 0, 0, "DA_142"),
                new Token(EOF, 0, 6, ""));
        runtest("K_142",
                new Token(ID, 0, 0, "K_142"),
                new Token(EOF, 0, 5, ""));
        runtest("v1_42",
                new Token(ID, 0, 0, "v1_42"),
                new Token(EOF, 0, 5, ""));
        runtest("v1_42",
                new Token(ID, 0, 0, "v1_42"),
                new Token(EOF, 0, 5, ""));
        runtest("v_",
                new Token(ID, 0, 0, "v_"),
                new Token(EOF, 0, 2, ""));
    }

}
