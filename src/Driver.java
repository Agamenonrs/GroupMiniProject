import enumeration.BoardIcons;
import enumeration.HelpOptions;
import exception.InvalidMovement;
import exception.InvalidPlayer;
import util.ApplicationUtils;
import util.InputCollector;

import static util.ApplicationUtils.convertToIntegerArray;

public class Driver {
    public static void main(String[] args) {
        Game game = new Game();
        String input = "";
        while (!HelpOptions.RESIGN.getCode().equalsIgnoreCase(input)){
            try{
                System.out.println( "\n\n" + (game.isWhitePlayer() ?  "White move " : "Black move" ));
                input = InputCollector.getUserInput("Enter UCI (type 'Help' for help):");

                if(input !=null && !input.equals("")){
                    if(input.equalsIgnoreCase("exit")){
                        continue;
                    }
                    if(HelpOptions.HELP.getCode().equalsIgnoreCase(input)){
                        game.printHelOptions();
                        continue;
                    }
                    if(HelpOptions.BOARD.getCode().equalsIgnoreCase(input)){
                        game.printBoard();
                        continue;
                    }
                    if(HelpOptions.RESIGN.getCode().equalsIgnoreCase(input)){
                        game.playerResign();
                        continue;
                    }
                    if(HelpOptions.MOVES.getCode().equalsIgnoreCase(input)){
                        System.out.println(HelpOptions.MOVES.getDescription());
                        continue;
                    }
                    if(ApplicationUtils.regexValitation(input,ApplicationUtils.SQUARE_PATTERN)){
                        System.out.println(HelpOptions.SQUARE.getDescription());
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
            }catch (InvalidPlayer ex){
                System.out.println(ex.getMessage());
            }

        }
    }


}
