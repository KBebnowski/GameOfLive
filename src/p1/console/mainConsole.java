package p1.console;

/**
 * Created by Kamil on 21.04.2020.
 * KONSOLOWA WERSJA GRY W ZYCIE
 */

public class mainConsole {
    public static void main(String[] args) {
        Thread t1 = new Thread(new GameConsole());
        t1.start();
    }
}