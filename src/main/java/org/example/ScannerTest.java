package org.example;

import org.junit.Test;
import static org.testng.AssertJUnit.assertEquals;

import java.io.StringReader;
import java.io.PushbackReader;
import java.io.IOException;

public class ScannerTest {

    @Test
    public void test1() throws IOException {
        String input = "var score123";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);

        assertEquals(TOKEN.VAR, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());

        assertEquals("VAR score123 ", scanner.getTokenBufferString());
    }

    @Test
    public void test2() throws IOException {
        String input = "init score = 600";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);


        assertEquals(TOKEN.INIT, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals(TOKEN.EQUALS, scanner.scan());
        assertEquals(TOKEN.INTLITERAL, scanner.scan());

        assertEquals("INIT score EQUALS 600 ", scanner.getTokenBufferString());
    }

    @Test
    public void test3() throws IOException {
        String input = "calculate newsalary = originalsalary + raise";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);


        assertEquals(TOKEN.CALCULATE, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals(TOKEN.EQUALS, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals(TOKEN.PLUS, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());

        assertEquals("CALCULATE newsalary EQUALS originalsalary PLUS raise ", scanner.getTokenBufferString());
    }

    @Test
    public void test4() throws IOException {
        String input = "write salary";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);

        assertEquals(TOKEN.WRITE, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());

        assertEquals("WRITE salary ", scanner.getTokenBufferString());
    }

    @Test
    public void test5() throws IOException {
        String input = "if x = y then endif";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);

        assertEquals(TOKEN.IF, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals(TOKEN.EQUALS, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals(TOKEN.THEN, scanner.scan());
        assertEquals(TOKEN.ENDIF, scanner.scan());

        assertEquals("IF x EQUALS y THEN ENDIF ", scanner.getTokenBufferString());
    }

    @Test
    public void test6() throws IOException {
        String input = "if x = y then write x endif";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);

        assertEquals(TOKEN.IF, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals(TOKEN.EQUALS, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals(TOKEN.THEN, scanner.scan());
        assertEquals(TOKEN.WRITE, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals(TOKEN.ENDIF, scanner.scan());

        assertEquals("IF x EQUALS y THEN WRITE x ENDIF ", scanner.getTokenBufferString());
    }

    @Test
    public void test7() throws IOException {
        String input = "while x != y do calculate x = x + 1 endwhile";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);

        assertEquals(TOKEN.WHILE, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals(TOKEN.NOTEQUALS, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals(TOKEN.DO, scanner.scan());
        assertEquals(TOKEN.CALCULATE, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals(TOKEN.EQUALS, scanner.scan());
        assertEquals(TOKEN.ID, scanner.scan());
        assertEquals(TOKEN.PLUS, scanner.scan());
        assertEquals(TOKEN.INTLITERAL, scanner.scan());
        assertEquals(TOKEN.ENDWHILE, scanner.scan());

        assertEquals("WHILE x NOTEQUALS y DO CALCULATE x EQUALS x PLUS 1 ENDWHILE ", scanner.getTokenBufferString());
    }

    @Test
    public void test8() throws IOException {
        String input = "";
        PushbackReader reader = new PushbackReader(new StringReader(input));
        Scanner scanner = new Scanner(reader);

        assertEquals(TOKEN.SCANEOF, scanner.scan());
    }

}
