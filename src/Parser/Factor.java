package Parser;

import Scanner.Scanner;
import Scanner.TOKEN;

import java.io.IOException;

public class Factor {

    private int value;
    private Scanner scanner;
    private Expr expr;
    private ID_MAP id_map;

    public Factor(Scanner scanner, ID_MAP id_map) {
        this.scanner = scanner;
        value = Integer.MIN_VALUE;
        this.id_map = id_map;
    }

    public void parse() throws IOException {

        if (scanner.getCurrentToken().type == TOKEN.CONST) {
            String val = scanner.getCurrentToken().val;
            value = Integer.parseInt(val);
        } else if (scanner.getCurrentToken().type == TOKEN.ID) {
            if (id_map != null) {
                value = id_map.get(scanner.getCurrentToken().val);
            }
        } else if (scanner.getCurrentToken().type == TOKEN.LPAREN) {
            scanner.nextToken(); //consume "("
            this.expr = new Expr(scanner, id_map);
            this.expr.parse();
            if (scanner.getCurrentToken().type != TOKEN.RPAREN) {
                System.out.println("ERROR: Miss \")\" but get " + scanner.getCurrentToken().val);
                System.exit(4);
            }
        } else {
            System.out.println("Error: Not valid id/const/or miss (, but get " + scanner.getCurrentToken().val);
            System.exit(4);
        }
    }

    public void print() {
        System.out.println(value);
    }

    public int exec() {
        if (value != Integer.MIN_VALUE) {
            return value;
        } else if (expr != null) {
            return expr.exec();
        } else {
            System.out.println("ERROR: Invalid CONST or ID ");
            System.exit(3);
        }
        return 0;
    }
}
