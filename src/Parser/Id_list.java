package Parser;
import Scanner.*;
import Scanner.Scanner;

import java.io.IOException;

public class Id_list {
    private Id_list id_list;
    private Scanner scanner;
    private ID_MAP id_map;

    public Id_list(Scanner scanner, ID_MAP id_map) {
        this.scanner = scanner;
        this.id_map = id_map;
    }

    public void parse() throws IOException {
        errorDetect(scanner, TOKEN.ID, "Invaild ID name");
        id_map.insert(scanner.getCurrentToken().val);
        scanner.nextToken(); // consume current id
        if (scanner.getCurrentToken().type == TOKEN.COMMA) {
            scanner.nextToken(); // consume , TODO check if it is ,
            id_list = new Id_list(scanner, id_map);
            id_list.parse();
        }
    }

    public void exec() {
        // do nothing
    }

    private void errorDetect(Scanner scanner, TOKEN token, String msg) {
        if (scanner.getCurrentToken().type != token) {
            System.out.println("ERROR: " + msg + scanner.getCurrentToken().val);
            System.exit(6);
        }
    }
}
