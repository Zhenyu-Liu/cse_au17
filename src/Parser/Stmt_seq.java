package Parser;

import Scanner.Scanner;
import Scanner.*;
import java.io.IOException;

public class Stmt_seq {
    private Stmt stmt;
    private Stmt_seq stmt_seq;
    private Scanner scanner;
    private ID_MAP id_map;

    public Stmt_seq(Scanner scanner, ID_MAP id_map) {
        this.scanner = scanner;
        this.id_map = id_map;
    }

    public void parse() throws IOException {
//         System.out.println("+" +scanner.getCurrentToken().val + "+");
        stmt = new Stmt(scanner, id_map);
        stmt.parse();
//         System.out.println("-" + scanner.getCurrentToken().val + "-");
        if (scanner.getCurrentToken().type != TOKEN.END) {
            stmt_seq = new Stmt_seq(scanner, id_map);
            stmt_seq.parse();
        }
    }

    public void exec() {
    }
}
