package Parser;
import Scanner.Scanner;
import Scanner.TOKEN;
import java.io.IOException;

public class Out {
    private Expr expr;
    private Scanner scanner;
    private ID_MAP id_map;

    public Out(Scanner scanner, ID_MAP id_map) {
        this.scanner = scanner;
        this.id_map = id_map;
    }

    public void parse() throws IOException {
        // TODO Consume output here
        expr = new Expr(scanner, id_map);
        expr.parse();
        if (scanner.getCurrentToken().type != TOKEN.SEMICOLON) {
            // Error missing ;
            System.out.println("ERROR: missing \";\" and get " + scanner.getCurrentToken().val);
            System.exit(1);
        }

        scanner.nextToken();

//        if (scanner.getCurrentToken().type != TOKEN.EOF) {
//            System.out.println("ERROR: missing/extra \" ;\" but get " + scanner.getCurrentToken().val);
//        }
   }

    public void print(int val) {
        System.out.println(val);
    }

    public void exec() {
        if (expr != null) {
            print(expr.exec());
        } else {
            print(0);
        }
    }
}
