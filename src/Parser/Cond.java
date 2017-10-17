package Parser;

import Scanner.Scanner;
import Scanner.TOKEN;

import java.io.IOException;

public class Cond {
    private Cmpr cmpr;
    private Cond cond;
    private Scanner scanner;
    private int flag = 0;

    public Cond(Scanner scanner) {
        this.scanner = scanner;
    }

    public void parse() throws IOException {

        if (scanner.getCurrentToken().type == TOKEN.MARK) {
            flag = 1;
            scanner.nextToken();
            errorDetect(scanner, 0);

            scanner.nextToken();
            cond = new Cond(scanner);
            cond.parse();

            errorDetect(scanner, 1);
        }

        cmpr = new Cmpr(scanner);
        cmpr.parse();

        if (scanner.getCurrentToken().type == TOKEN.BAR) {
            flag = 2;
            cond = new Cond(scanner);
            cond.parse();
        }
    }

    public int exec() {
        if (flag == 0) {
            return cmpr.exec();
        } else if (flag == 1) {
            return cond.exec();
        } else {
            return cmpr.exec() + cond.exec();
        }
    }

    private void errorDetect(Scanner scanner, int i) {
        if (!checkParen(scanner, i)) {
            System.out.println("ERROR: Check parentheses"
                    + scanner.getCurrentToken().val);
            System.exit(5);
        }
    }

    private boolean checkParen(Scanner scanner, int i) {
        if (i == 0 && scanner.getCurrentToken().type == TOKEN.LPAREN) {
            return true;
        }
        if (i == 1 && scanner.getCurrentToken().type != TOKEN.RPAREN) {
            return true;
        }
        return false;
    }
}
