package Scanner;
import java.util.HashMap;

public class ScannerUtil {

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
        map.put('|', TOKEN.BAR);
        map.put(':', TOKEN.COLON);
        map.put('!', TOKEN.MARK);
        map.put('<', TOKEN.LESS);

        keyword_map.put("output", TOKEN.OUTPUT);
        keyword_map.put("<=", TOKEN.LEQ);
        keyword_map.put("program", TOKEN.PROG);
        keyword_map.put("begin", TOKEN.BEGIN);
        keyword_map.put("input", TOKEN.INPUT);
        keyword_map.put("if", TOKEN.IF);
        keyword_map.put("then", TOKEN.THEN);
        keyword_map.put("else", TOKEN.ELSE);
        keyword_map.put("endif", TOKEN.ENDIF);
        keyword_map.put("end", TOKEN.END);
        keyword_map.put("int", TOKEN.INT);
    }

    TOKEN getType(char c) {
        return map.get(c);
    }
    TOKEN getType(String s) {

        if (s.matches("[A-Z]+|[a-z]+")) {
            s = s.toLowerCase();
        }
        if (keyword_map.containsKey(s)) {
            return keyword_map.get(s);
        }
        return TOKEN.ID;
    }
}
