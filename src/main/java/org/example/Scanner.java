package org.example;

import java.io.IOException;
import java.io.PushbackReader;

// token types
enum TOKEN {
    VAR,
    WRITE,
    INIT,
    IF,
    THEN,
    ENDIF,
    WHILE,
    DO,
    ENDWHILE,
    CALCULATE,
    PLUS,
    EQUALS,
    NOTEQUALS,
    SCANEOF,
    ID,
    INTLITERAL,

}

public class Scanner {

    private final String[] reservedWords;
    private final PushbackReader reader;
    private final StringBuilder tokenBuffer = new StringBuilder();

    // constructor
    public Scanner (PushbackReader reader){
        this.reader = reader;
        reservedWords = new String[]{"var", "write", "init", "if", "then","endif", "while","do","endwhile","calculate"};
    }

    // scan one token at a time
    public TOKEN scan() throws IOException {
        int ch;
        //skip whitespace in first
        while ((ch = reader.read()) != -1) {
            if (!Character.isWhitespace(ch)) {
                reader.unread(ch);
                break;
            }
        }

        //end of scan
        if(ch == -1){
            return TOKEN.SCANEOF;
        }
        //read token
        StringBuilder token = new StringBuilder();
        while ((ch = reader.read()) != -1) {
            if (Character.isWhitespace(ch)) {
                break;
            }
            token.append((char) ch);
        }

        TOKEN tokenType = getTokenType(token.toString());

        if(tokenType == null){
            System.out.println("Error: Invalid token: " + token);
        }else if (tokenType == TOKEN.ID || tokenType == TOKEN.INTLITERAL) {
            tokenBuffer.append(token).append(" ");
        }else {
            tokenBuffer.append(tokenType).append(" ");
        }

        return tokenType;
    }

    // get token type
    public TOKEN getTokenType(String token){

        for (String reservedWord : reservedWords) {
            if (token.equals(reservedWord)) {
                return TOKEN.valueOf(token.toUpperCase());
            }
        }

        if(token.equals("=")){
            return TOKEN.EQUALS;
        }else if(token.equals("!=")){
            return TOKEN.NOTEQUALS;
        }else if(token.equals("+")){
            return TOKEN.PLUS;
        }else if(token.matches("[0-9]+")){
            return TOKEN.INTLITERAL;
        } else if(token.matches("[a-zA-Z][a-zA-Z0-9]*")){
            return TOKEN.ID;
        }

        return null;
    }

    public String getTokenBufferString(){
        return tokenBuffer.toString();
    }
}
