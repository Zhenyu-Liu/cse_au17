import Parser.Out;
import Parser.Prog;
import Scanner.Scanner;
import Scanner.TOKEN;
import java.io.IOException;

public class Interpreter {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(args[0]);
        if (sc.getCurrentToken().type == TOKEN.PROG) {
            Prog prog = new Prog(sc);
            prog.parse();
        }
//        while (sc.getCurrentToken().type != TOKEN.EOF) {
//            System.out.println(sc.getCurrentToken().val);
//            sc.nextToken();
//        }

    }
}
