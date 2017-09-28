package com.osu.cse3341.Parser;
import com.osu.cse3341.Scanner.Scanner;
import com.osu.cse3341.Scanner.TOKEN;
import java.io.IOException;

public class Out {
    private Expr expr;
    private Scanner scanner;

    public Out(Scanner scanner) {
        this.scanner = scanner;
    }

    public void parse() throws IOException {
        expr = new Expr(scanner);
        expr.parse();
        if (scanner.getCurrentToken().type != TOKEN.SEMICOLON) {
            // Error missing ;
            System.out.println("ERROR: missing \";\" and get " + scanner.getCurrentToken().val);
            System.exit(1);
        }
   }

    public void print(int val) {
        System.out.println(val);
    }

    public void exec() {
        if (expr != null) {
            print(expr.exec());
        } else {
            print(0);
        }
    }
}
