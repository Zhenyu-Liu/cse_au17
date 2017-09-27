package com.osu.cse3341.Scanner;
import java.util.HashMap;

public class ScannerUtil {

    private final String constant = "-?[0-9]+";
    private HashMap<Character, TOKEN> map = new HashMap<Character, TOKEN>();
    private HashMap<String, TOKEN> keyword_map = new HashMap<String, TOKEN>();

    public ScannerUtil() {
        map.put(';', TOKEN.SEMICOLON);
        map.put(',', TOKEN.COMMA);
        map.put('(', TOKEN.LPAREN);
        map.put(')', TOKEN.RPAREN);
        map.put('+', TOKEN.PLUS);
        map.put('-', TOKEN.MINUS);
        map.put('*', TOKEN.MULTIPLY);
        map.put('=', TOKEN.EQUAL);
//        map.put('|', TOKEN.BAR);
        map.put(':', TOKEN.COLON);
//        map.put('!', TOKEN.MARK);
//        map.put('<', TOKEN.LESS);

        keyword_map.put("output", TOKEN.OUTPUT);
    }

    public TOKEN getType(char c) {
        return map.get(c);
    }
    public TOKEN getType(String s) {
        return keyword_map.get(s);
    }
}
