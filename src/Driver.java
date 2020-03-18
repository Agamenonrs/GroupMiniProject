import enumeration.BoardIcons;
import exception.InvalidMovement;
import util.ApplicationUtils;
import util.InputCollector;

import static util.ApplicationUtils.convertToIntegerArray;

public class Driver {
    public static void main(String[] args) {
        Game game = new Game();
        String input = "";
        while (!input.equalsIgnoreCase("exit")){
            try{
                input = InputCollector.getUserInput("Enter UCI (type 'Help' for help):");
                if(input !=null && !input.equals("")){
                    if(input.equalsIgnoreCase("exit")){
                        continue;
                    }
                    if(!ApplicationUtils.regexValitation(input,ApplicationUtils.UCI_PATTERN)){
                        System.out.println("Wrong code. Try again");
                        continue;
                    }
                    int[] typedPositions = convertToIntegerArray(input);
                    game.changePosition(typedPositions);
                }
            }catch (InvalidMovement ex){
                ex.getMessage();
            }

        }
    }
}
