package com.osu.cse3341.Parser;

import com.osu.cse3341.Scanner.Scanner;
import com.osu.cse3341.Scanner.TOKEN;

import java.io.IOException;

public class Term {
    private Factor factor;
    private Term term;
    private Scanner scanner;
    private boolean flag = false;

    public Term(Scanner scanner) {
        this.scanner = scanner;
    }

    public void parse() throws IOException {

        // factor
        factor = new Factor(scanner);
        factor.parse();
        scanner.nextToken(); // Take a look for next token

        if (scanner.getCurrentToken().type == TOKEN.MULTIPLY) {
            flag = true;
            scanner.nextToken(); // consume " * "
            term = new Term(scanner);
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
