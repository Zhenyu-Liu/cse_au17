package Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Scanner {
    private BufferedReader in;
    private int buffer = Integer.MIN_VALUE;
    private TokenItem currentToken;
    private ScannerUtil util = new ScannerUtil();

    public Scanner(String file) throws IOException {
        in = new BufferedReader(new FileReader(file));
        nextToken();
    }

    public void nextToken() throws IOException {

        int next;
        if (buffer != Integer.MIN_VALUE) {
            next = buffer;
            buffer = Integer.MIN_VALUE;
        } else {
            next = in.read();
        }

        // check whitespace
        while (Character.isWhitespace(next)) {
            next = in.read();
        }
        // EOF
        if (next == -1) {
            currentToken = new TokenItem(TOKEN.EOF, "");
        } else if (Character.isLetter(next)) {
            // Letter
            StringBuilder sb = new StringBuilder();
            while (Character.isLetter(next) || Character.isDigit(next)) {
                sb.append((char) next);
                next = in.read();
            }
            buffer = next;
            String token = sb.toString();
            TOKEN type = util.getType(token);
            currentToken = new TokenItem(type, token);
        } else if (Character.isDigit(next)) {
            // Digit
            int digit = 0;
            while (Character.isDigit(next)) {
                digit = digit * 10 + next - '0';
                next = in.read();
            }
            buffer = next;
            currentToken = new TokenItem(TOKEN.CONST, digit + "");
        } else {
            // NOT Digit NOT Letter NOT EOF then it's a symbol
            TOKEN type;
            if (next == '<') {
                int tmp = in.read();
                if (tmp == '=') {
                    type = util.getType("<=");
                    currentToken = new TokenItem(type, "<=");
                } else {
                    buffer = tmp;
                }
            } else {
                type = util.getType((char) next);
                currentToken = new TokenItem(type, Character.toString((char) next));
            }
        }
    }

    public TokenItem getCurrentToken() {
        return currentToken;
    }
}
