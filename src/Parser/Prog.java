package Parser;
import Scanner.*;
import Scanner.Scanner;
import Scanner.TOKEN;
import java.io.IOException;

public class Prog {
    private Decl_seq decl_seq;
    private Stmt_seq stmt_seq;
    private Scanner scanner;
    private ID_MAP id_map;

    public Prog(Scanner scanner) {
        this.scanner = scanner;
        this.id_map = new ID_MAP();
    }

    public void parse() throws IOException {
        errorDetect(scanner, TOKEN.PROG);
        scanner.nextToken(); // consume program
        decl_seq = new Decl_seq(scanner, id_map);
        decl_seq.parse();
        errorDetect(scanner, TOKEN.BEGIN);
        scanner.nextToken(); // consume begin
        stmt_seq = new Stmt_seq(scanner, id_map);
        stmt_seq.parse();
        errorDetect(scanner, TOKEN.END);
    }

    public void exec() {
    }

    private void errorDetect(Scanner scanner, TOKEN token) {
        if (scanner.getCurrentToken().type != token) {
            System.out.println("ERROR: Missing keyword"
                    + scanner.getCurrentToken().val);
            System.exit(6);
        }
    }
}
