package com.osu.cse3341.Parser;

import com.osu.cse3341.Scanner.Scanner;
import com.osu.cse3341.Scanner.TOKEN;

import java.io.IOException;

public class Factor {

    private int value;
    private String id;
    private Scanner scanner;
    private Expr expr;

    public Factor(Scanner scanner) {
        this.scanner = scanner;
        id = null;
        value = Integer.MIN_VALUE;
    }

    public void parse() throws IOException {

        if (scanner.getCurrentToken().type == TOKEN.CONST) {
            String val = scanner.getCurrentToken().val;
            value = Integer.parseInt(val);
        } else if (scanner.getCurrentToken().type == TOKEN.ID) {
            // for project 1
            if (scanner.getCurrentToken().val.equals("x")) {
                value = 1;
            }
            if (scanner.getCurrentToken().val.equals("y")) {
                value = 2;
            }
        } else if (scanner.getCurrentToken().type == TOKEN.LPAREN) {
            scanner.nextToken(); //consume "("
            this.expr = new Expr(scanner);
            this.expr.parse();
            scanner.nextToken(); // consume")" TODO what if missing or not a )
        } else {
            // TODO error checking
        }
    }

    public void print() {
        System.out.println(value);
    }

    public int exec() {
        if (value != Integer.MIN_VALUE) {
            return value;
        } else if (expr != null) {
            return expr.exec();
        } else {
            return 0; // error
        }
    }
}
