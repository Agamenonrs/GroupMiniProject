package util;/*
@author Agamenon
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ApplicationUtils {

    public  static List<Character> axis_x;
    public static final String UCI_PATTERN = "^[1-8]{1}[a-hA-H]{1}[1-8]{1}[a-hA-H]{1}$";

    static {
        axis_x = Arrays.asList('A','B','C','D','E','F','G','H');

    }

    public static boolean regexValitation(String input, String stringPattern){
        Pattern pattern = Pattern.compile(stringPattern);
        return pattern.matcher(input).matches();
    }

    public static int[] convertToIntegerArray(String input){
        int[] positions = new int[4];
        char[] chars = input.toCharArray();
        positions [0] = Character.getNumericValue(chars[0]) - 1;
        positions [2] = Character.getNumericValue(chars[2]) - 1;
        positions [1] = axis_x.indexOf(Character.toUpperCase(chars[1]));
        positions [3] = axis_x.indexOf(Character.toUpperCase(chars[3]));

        return positions;
    }

}
