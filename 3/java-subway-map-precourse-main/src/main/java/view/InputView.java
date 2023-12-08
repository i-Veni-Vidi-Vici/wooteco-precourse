package view;


import java.io.Console;
import java.util.Scanner;

public class InputView {
    public String getFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
        Console console = new Scanner(System.in);
        return
    }

    public String getMenu() {
        System.out.println("");
        return Console.readLine();
    }
}
