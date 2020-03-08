import enumeration.ApplicationUtils;
import enumeration.BoardIcons;

public class Game {
    private Piece[][] board;

    public Game(){
        board = new Piece[8][8];
        for (int i = 7; i >= 0;i--){
            for (int j = 0; j < board[i].length; j ++ ){
                Piece p = null;
                if(i == 0){
                    if (j == 0 || j == 7){
                        p = new Rook(true, new Position(i,j));
                        System.out.print(" "+BoardIcons.WHITE_ROOK.getCode());
                    }else if (j == 1 || j == 6){
                        p= new Knight(true,new Position(i,j));
                        System.out.print(" "+BoardIcons.WHITE_KNIGHT.getCode());
                    }else if (j == 2 || j == 5){
                        p = new Bishop(true,new Position(i,j));
                        System.out.print(" "+BoardIcons.WHITE_BISHOP.getCode());
                    }else if (j == 3){
                        p = new Queen(true,new Position(i,j));
                        System.out.print(" "+BoardIcons.WHITE_QUEEN.getCode());
                    }else if (j == 4){
                        p = new King(true,new Position(i,j));
                        System.out.print(" "+BoardIcons.WHITE_KING.getCode());
                    }
                }else if(i == 1){
                    p = new Pawn(true,new Position(i,j));
                    System.out.print(" "+BoardIcons.WHITE_PAWN.getCode());
                }else if (i == 6){
                    p = new Pawn(false,new Position(i,j));
                    System.out.print(" " +BoardIcons.BLACK_PAWN.getCode());
                }else if (i == 7){
                    if (j == 0 || j == 7){
                        p = new Rook(false, new Position(i,j));
                        System.out.print(" "+BoardIcons.BLACK_ROOK.getCode());
                    }else if (j == 1 || j == 6){
                        p = new Knight(false,new Position(i,j));
                        System.out.print(" "+BoardIcons.BLACK_KNIGHT.getCode());
                    }else if (j == 2 || j == 5){
                        p = new Bishop(false,new Position(i,j));
                        System.out.print(" "+BoardIcons.BLACK_BISHOP.getCode());
                    }else if (j == 3){
                        p = new Queen(false,new Position(i,j));
                        System.out.print(" "+BoardIcons.BLACK_QUEEN.getCode());
                    }else if (j == 4){
                        p = new King(false,new Position(i,j));
                        System.out.print(" "+BoardIcons.BLACK_KING.getCode());
                    }
                }else{
                    System.out.print(" "+BoardIcons.EMPTY.getCode());
                }
                board[i][j] = p;
            }
            System.out.println(" " + (i+1));
        }
        System.out.println("");
        ApplicationUtils.axis_x.forEach(c-> System.out.print(" " + c));
    }
}
