package com.osu.cse3341.Parser;
import com.osu.cse3341.Scanner.Scanner;
import com.osu.cse3341.Scanner.TOKEN;
import java.io.IOException;

public class Expr {

    private Expr expr;
    private Term term;
    private Scanner scanner;
    private int flag = 0; // 0 => term; 1 => +; -1 => -

    public Expr(Scanner scanner) {
        this.scanner = scanner;
    }

    public void parse() throws IOException {
        term = new Term(scanner);
        term.parse();
        if (scanner.getCurrentToken().type == TOKEN.PLUS) {
            flag = 1;
            scanner.nextToken(); // consume +
            expr = new Expr(scanner);
            expr.parse();
        } else if (scanner.getCurrentToken().type == TOKEN.MINUS) {
            flag = -1;
            scanner.nextToken(); // consume -
            expr = new Expr(scanner);
            expr.parse();
        } else {
            // Error: not +/-/
            System.out.println("ERROR: Invalid <expr>, but got " + scanner.getCurrentToken().val);
            System.exit(2);
        }
    }

    public void print() {

    }

    public int exec() {
        if (flag == 0) {
            return term.exec();
        } else if (flag == 1) {
            return term.exec() + expr.exec();
        } else {
            return term.exec() - expr.exec();
        }
    }
}
