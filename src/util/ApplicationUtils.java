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
    public static final String UCI_PATTERN = "^[a-hA-H]{1}[1-8]{1}[a-hA-H]{1}[1-8]{1}$";
    public static final String SQUARE_PATTERN = "^[a-hA-H]{1}[1-8]{1}";

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

        positions [0] = axis_x.indexOf(Character.toUpperCase(chars[0]));
        positions [1] = Character.getNumericValue(chars[1]) - 1;
        positions [2] = axis_x.indexOf(Character.toUpperCase(chars[2]));
        positions [3] = Character.getNumericValue(chars[3]) - 1;
        return positions;
    }

}
