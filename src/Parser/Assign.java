package Parser;

import Scanner.*;
import java.io.IOException;

public class Assign {
    private Expr expr;
    private Scanner scanner;
    private ID_MAP id_map;
    String key;

    public Assign(Scanner scanner, ID_MAP id_map) {
        this.scanner = scanner;
        this.id_map = id_map;
    }

    public void parse() throws IOException {
        errorDetect(scanner, TOKEN.ID, "Invalid ID");
        key = scanner.getCurrentToken().val;

        scanner.nextToken(); // consume id
        errorDetect(scanner, TOKEN.COLON, "Miss COLON");
        scanner.nextToken(); // consume :
        errorDetect(scanner, TOKEN.EQUAL, "Miss Equal sign");
        scanner.nextToken(); // consume =

        expr = new Expr(scanner, id_map);
        expr.parse();
        int val = expr.exec();
        id_map.assign(key, val);

        errorDetect(scanner, TOKEN.SEMICOLON, "Missing ; assign");
        scanner.nextToken(); // consume ;
    }

    public void exec() {
    }

    private void errorDetect(Scanner scanner, TOKEN token, String msg) {
        if (scanner.getCurrentToken().type != token) {
            System.out.println("Error: " + msg + scanner.getCurrentToken().val);
            System.exit(9);
        }
    }
}
