package Parser;
import Scanner.*;
import Scanner.Scanner;

import java.io.IOException;

public class Decl_seq {
    private Decl decl;
    private Decl_seq decl_seq;
    private Scanner scanner;
    private ID_MAP id_map;

    public Decl_seq(Scanner scanner, ID_MAP id_map) {
        this.scanner = scanner;
        this.id_map = id_map;
    }

    public void parse() throws IOException {
        decl = new Decl(scanner, id_map);
        decl.parse();
        if (scanner.getCurrentToken().type == TOKEN.INT) {
            decl_seq = new Decl_seq(scanner, id_map);
            decl_seq.parse();
        }
    }

    public void exec() {
        // do nothing
    }
}
