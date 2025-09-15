package org.example;

import org.junit.Test;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

import static org.testng.AssertJUnit.assertEquals;

public class ScannerTest {

    @Test
    public void test1() throws IOException {
        String input = "var score123";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);


        assertEquals(TOKEN.VAR, scanner.scan());
        assertEquals("var", scanner.getTokenBufferString());
        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("score123", scanner.getTokenBufferString());

    }

    @Test
    public void test2() throws IOException {
        String input = "init score = 600";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);


        assertEquals(TOKEN.INIT, scanner.scan());
        assertEquals("init", scanner.getTokenBufferString());

        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("score", scanner.getTokenBufferString());

        assertEquals(TOKEN.EQUALS, scanner.scan());
        assertEquals("=", scanner.getTokenBufferString());

        assertEquals(TOKEN.INTLITERAL, scanner.scan());
        assertEquals("600", scanner.getTokenBufferString());
    }

    @Test
    public void test3() throws IOException {
        String input = "calculate newsalary = originalsalary + raise";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);


        assertEquals(TOKEN.CALCULATE, scanner.scan());
        assertEquals("calculate", scanner.getTokenBufferString());

        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("newsalary", scanner.getTokenBufferString());

        assertEquals(TOKEN.EQUALS, scanner.scan());
        assertEquals("=", scanner.getTokenBufferString());

        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("originalsalary", scanner.getTokenBufferString());

        assertEquals(TOKEN.PLUS, scanner.scan());
        assertEquals("+", scanner.getTokenBufferString());

        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("raise", scanner.getTokenBufferString());
    }

    @Test
    public void test4() throws IOException {
        String input = "write salary";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);


        assertEquals(TOKEN.WRITE, scanner.scan());
        assertEquals("write", scanner.getTokenBufferString());

        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("salary", scanner.getTokenBufferString());
    }

    @Test
    public void test5() throws IOException {
        String input = "if x = y then endif";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);


        assertEquals(TOKEN.IF, scanner.scan());
        assertEquals("if", scanner.getTokenBufferString());

        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("x", scanner.getTokenBufferString());

        assertEquals(TOKEN.EQUALS, scanner.scan());
        assertEquals("=", scanner.getTokenBufferString());

        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("y", scanner.getTokenBufferString());

        assertEquals(TOKEN.THEN, scanner.scan());
        assertEquals("then", scanner.getTokenBufferString());

        assertEquals(TOKEN.ENDIF, scanner.scan());
        assertEquals("endif", scanner.getTokenBufferString());
    }

    @Test
    public void test6() throws IOException {
        String input = "if x = y then write x endif";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);


        assertEquals(TOKEN.IF, scanner.scan());
        assertEquals("if", scanner.getTokenBufferString());

        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("x", scanner.getTokenBufferString());

        assertEquals(TOKEN.EQUALS, scanner.scan());
        assertEquals("=", scanner.getTokenBufferString());

        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("y", scanner.getTokenBufferString());

        assertEquals(TOKEN.THEN, scanner.scan());
        assertEquals("then", scanner.getTokenBufferString());

        assertEquals(TOKEN.WRITE, scanner.scan());
        assertEquals("write", scanner.getTokenBufferString());

        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("x", scanner.getTokenBufferString());

        assertEquals(TOKEN.ENDIF, scanner.scan());
        assertEquals("endif", scanner.getTokenBufferString());

    }

    @Test
    public void test7() throws IOException {
        String input = "while x != y do calculate x = x + 1 endwhile";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);

        assertEquals(TOKEN.WHILE, scanner.scan());
        assertEquals("while", scanner.getTokenBufferString());

        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("x", scanner.getTokenBufferString());

        assertEquals(TOKEN.NOTEQUALS, scanner.scan());
        assertEquals("!=", scanner.getTokenBufferString());

        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("y", scanner.getTokenBufferString());

        assertEquals(TOKEN.DO, scanner.scan());
        assertEquals("do", scanner.getTokenBufferString());

        assertEquals(TOKEN.CALCULATE, scanner.scan());
        assertEquals("calculate", scanner.getTokenBufferString());

        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("x", scanner.getTokenBufferString());

        assertEquals(TOKEN.EQUALS, scanner.scan());
        assertEquals("=", scanner.getTokenBufferString());

        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals("x", scanner.getTokenBufferString());

        assertEquals(TOKEN.PLUS, scanner.scan());
        assertEquals("+", scanner.getTokenBufferString());

        assertEquals(TOKEN.INTLITERAL, scanner.scan());
        assertEquals("1", scanner.getTokenBufferString());

        assertEquals(TOKEN.ENDWHILE, scanner.scan());
        assertEquals("endwhile", scanner.getTokenBufferString());

    }

    @Test
    public void test8() throws IOException {
        String input = "";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);

        assertEquals(TOKEN.SCANEOF, scanner.scan());
    }

}