package Parser;
import Scanner.*;
import Scanner.Scanner;

import java.io.IOException;

public class Decl {
    private Id_list id_list;
    private Scanner scanner;
    private ID_MAP id_map;

    public Decl(Scanner scanner, ID_MAP id_map) {
        this.scanner = scanner;
        this.id_map = id_map;
    }

    public void parse() throws IOException {
        errorDetect(scanner, TOKEN.INT, "Invalid keyword: suppose INPUT");
        scanner.nextToken(); // consume int
        id_list = new Id_list(scanner, id_map);
        id_list.parse();
        scanner.nextToken(); // consume ;
    }

    public void exec() {
    }

    private void errorDetect(Scanner scanner, TOKEN token, String msg) {
        if (scanner.getCurrentToken().type != token) {
            System.out.println("Error: " + msg + scanner.getCurrentToken().val);
            System.exit(8);
        }
    }
}
