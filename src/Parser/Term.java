package Parser;

import Scanner.Scanner;
import Scanner.TOKEN;

import java.io.IOException;

public class Term {
    private Factor factor;
    private Term term;
    private Scanner scanner;
    private boolean flag = false;
    private ID_MAP id_map;

    public Term(Scanner scanner, ID_MAP id_map) {
        this.scanner = scanner;
        this.id_map = id_map;
    }

    public void parse() throws IOException {

        // factor
        factor = new Factor(scanner, id_map);
        factor.parse();
        scanner.nextToken(); // Take a look for next token

        if (scanner.getCurrentToken().type == TOKEN.MULTIPLY) {
            flag = true;
            scanner.nextToken(); // consume " * "
            term = new Term(scanner, id_map);
            term.parse();
        }
    }

    public int exec() {
        if (flag && term != null) {
            return factor.exec() * term.exec();
        } else if (!flag && factor != null) {
            return factor.exec();
        } else {
            return 0;
        }
    }
}
