package test;

import static org.junit.Assert.fail;

import java.io.StringReader;

import lexer.Lexer;

import org.junit.Test;

import parser.Parser;

public class ParserTests {

    private void runtest(String src) {
        runtest(src, true);
    }

    private void runtest(String src, boolean succeed) {
        Parser parser = new Parser();
        try {
            parser.parse(new Lexer(new StringReader(src)));
            if (!succeed) {
                fail("Test was supposed to fail, but succeeded");
            }
        } catch (beaver.Parser.Exception e) {
            if (succeed) {
                e.printStackTrace();
                fail(e.getMessage());
            }
        } catch (Throwable e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testEmptyModule() {
        runtest("module", false);
        runtest("module Test", false);
        runtest("module Test { ", false);
        runtest("module Test { }");
    }

    @Test
    public void testImports() {
        runtest("module Test { Test2 }", false);
        runtest("module Test { import }", false);
        runtest("module Test { import;  }", false);
        runtest("module Test { import Test2; }");
        runtest("module Test { import Test2; import Test3; }");
        runtest("module Test { import Test2; import Test3; import Test4;  }");
    }

    @Test
    public void testDeclarations() {
        // Function Declaration
        runtest("module Test { void foo() {  } }");
        runtest("module Test { public int foo() {  } }");
        runtest("module Test { public void foo(boolean isChar) {  } }");
        runtest("module Test { public void foo(boolean isChar, int count, int test2) {  } }");

        // Field Declaration
        // Primitive
        runtest("module Test { int count; }");
        runtest("module Test { boolean isChar; }");
        // Array
        runtest("module Test { int[] count; }");
        runtest("module Test { public boolean[] count; }");
        runtest("module Test { public boolean[][][] count; }");
        runtest("module Test { public boolean[0] count; }", false);
        // ID
        runtest("module Test { Identifier count; }");
        runtest("module Test { Apple[] apples; }");
        runtest("module Test { String[] message; }");
        runtest("module Test { public int isChar; }");

        // Type Declaration
        runtest("module Test { type String = \"STRING\"; }");
        runtest("module Test { public type Banana = \"BANANA\"; }");

        // Test 0 or more
        runtest("module Test { }");
        runtest("module Test {  }");
    }

    @Test
    public void testStatements() {
        // Local Variable Declaration
        runtest("module Test { "
                + "void foo() {"
                + "int[] test;"
                + "}"
                + "}");
        // Block of Statement
        runtest("module Test {"
                + "void foo() {"
                + "{}"
                + "}"
                + "}");
        runtest("module Test {"
                + "void foo() {"
                + "{"
                + "{ int[][] testss; }"
                + "}"
                + "}"
                + "}");
        // If
        runtest("module Test {"
                + "void foo() {"
                + "if(a==b){"
                + "int[][] testss;"
                + "}"
                + "}"
                + "} ");

        runtest("module Test {"
                + "void foo() {"
                + "if(a==b){"
                + "int[][] testss;"
                + "} else"
                + "a = a==b;"
                + "}"
                + "} ");
        // While
        runtest("module Test {"
                + "void foo() {"
                + "while(a==b){"
                + "int[][] testss;"
                + "}"
                + "}"
                + "} ");
        // Break & Return
        runtest("module Test {"
                + "void foo() {"
                + "break;return;"
                + "}"
                + "} ");
    }

    @Test
    public void testAssignment() {
        // Assignment (Focus Test on LeftExpression)
        runtest("module Test {"
                + "void foo() {"
                + "a = 11;"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "int[0] = 0;"
                + "}"
                + "} ", false);
    }

    @Test
    public void testPrimaryExpression() {
        // Left Expression
        runtest("module Test {"
                + "void foo() {"
                + "a;"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "a[0][0];"
                + "}"
                + "} ");
        // Function
        runtest("module Test {"
                + "void foo() {"
                + "test(a,b,c);"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "test(a);"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "test();"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "test(1,1==1);"
                + "}"
                + "} ");

        // Array Expression
        runtest("module Test {"
                + "void foo() {"
                + "[a,b==1,true];"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "[a];"
                + "}"
                + "} ");

        // String Expression
        runtest("module Test {"
                + "void foo() {"
                + "\"Hello World!\";"
                + "}"
                + "} ");

        // Integer Expression
        runtest("module Test {"
                + "void foo() {"
                + "1;"
                + "}"
                + "} ");

        // Boolean Expression
        runtest("module Test {"
                + "void foo() {"
                + "true;"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "false;"
                + "}"
                + "} ");

        // Parenthisized Expression
        runtest("module Test {"
                + "void foo() {"
                + "(false);"
                + "}"
                + "} ");
    }

    @Test
    public void testFactor() {
        runtest("module Test {"
                + "void foo() {"
                + "-Apple;"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "---Apple;"
                + "}"
                + "} ");
    }

    @Test
    public void testTerm() {
        runtest("module Test {"
                + "void foo() {"
                + "Banana*-Apple;"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "Banana/-Apple;"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "Banana%-Apple;"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "Banana%1*(-Apple+2);"
                + "}"
                + "} ");
    }

    @Test
    public void testArithmetic() {
        runtest("module Test {"
                + "void foo() {"
                + "1+2;"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "a+b-c;"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "a+b-(-c*\"1\");"
                + "}"
                + "} ");
    }

    @Test
    public void testComparison() {
        runtest("module Test {"
                + "void foo() {"
                + "a+b-(-c*\"1\")==B;"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "1!=0;"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "1<0;"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "1<=0;"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "1>0;"
                + "}"
                + "} ");
        runtest("module Test {"
                + "void foo() {"
                + "1>=0;"
                + "}"
                + "} ");
    }
}
