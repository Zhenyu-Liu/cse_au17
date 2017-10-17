package Parser;

import Scanner.*;

import java.io.IOException;

public class Stmt {
    private Assign assign;
    private If anIf;
    private Loop loop;
    private In in;
    private Out out;
    private Scanner scanner;
    private ID_MAP id_map;

    public Stmt(Scanner scanner, ID_MAP id_map) {
        this.scanner = scanner;
        this.id_map = id_map;
    }

    public void parse() throws IOException {
        switch (scanner.getCurrentToken().type) {
            case ID:
                assign = new Assign(scanner, id_map);
                assign.parse();
                break;
            case OUTPUT:
                scanner.nextToken(); // consume output
                out = new Out(scanner, id_map);
                out.parse();
                out.exec();
        }
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
