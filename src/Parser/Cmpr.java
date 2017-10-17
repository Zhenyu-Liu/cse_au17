package Parser;

import Scanner.Scanner;
import Scanner.TOKEN;

import java.io.IOException;

public class Cmpr {
    private Expr expr_l, expr_r;
    private Scanner scanner;
    private int flag;
    private ID_MAP id_map;

    public Cmpr(Scanner scanner) {
        this.scanner = scanner;
    }

    public void parse() throws IOException {
        expr_l = new Expr(scanner, id_map);
        scanner.nextToken();
        switch (scanner.getCurrentToken().type) {
            case EQUAL:
                flag = 0;
                break;
            case LESS:
                flag = -1;
                break;
            case LEQ:
                flag = 1;
                break;
            default:
                flag = Integer.MAX_VALUE;
                break;
        }
        expr_r = new Expr(scanner, id_map);
    }

    public int exec() {
        if (flag != Integer.MAX_VALUE && expr_l != null && expr_r != null) {
            switch (flag) {
                case 0:
                    return expr_l.exec() == expr_r.exec()? 1 : 0;
                case 1:
                    return expr_l.exec() <= expr_r.exec()? 1 : 0;
                case -1:
                    return expr_l.exec() < expr_r.exec()? 1 : 0;
            }
        }
        return Integer.MAX_VALUE;
    }
}
