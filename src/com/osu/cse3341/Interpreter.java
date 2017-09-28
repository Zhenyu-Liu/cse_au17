package com.osu.cse3341;
import com.osu.cse3341.Parser.Out;
import com.osu.cse3341.Scanner.Scanner;
import com.osu.cse3341.Scanner.TOKEN;
import java.io.IOException;

public class Interpreter {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(args[0]);
        if (sc.getCurrentToken().type == TOKEN.OUTPUT) {
            sc.nextToken();
            Out out = new Out(sc);
            out.parse();
            out.exec();
        }
    }
}
