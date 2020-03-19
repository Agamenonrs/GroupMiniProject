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
                    Position oldPosition = new Position(typedPositions[0],typedPositions[1]);
                    Position newPosition = new Position(typedPositions[2],typedPositions[3]);
                    game.changePosition(oldPosition,newPosition,game);
                }
            }catch (InvalidMovement ex){
                System.out.println(ex.getMessage());
            }

        }
    }


}
