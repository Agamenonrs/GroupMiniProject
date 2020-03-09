package util;
import java.util.Scanner;

/**
 * Author: Agamenon
 */
public class InputCollector {

    public static Scanner in;

    static {
        in = new Scanner(System.in);
    }

    public static String getUserInput(String prompt){
        System.out.println(prompt);
        String input = in.nextLine();
        return input;
    }


}
