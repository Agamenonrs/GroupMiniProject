import enumeration.HelpOptions;
import exception.InvalidMovement;
import util.ApplicationUtils;
import enumeration.BoardIcons;
import util.InputCollector;

import java.util.Scanner;

public class Game {
    private Piece[][] board;

    public Game(){
        board = new Piece[8][8];
        createBoard();
        printBoard();
    }

    private void createBoard() {
        for (int row = 7; row >= 0;row--){
            for (int column = 0; column < board[row].length; column ++ ){
                Piece p = null;
                if(row == 0){
                    if (column == 0 || column == 7){
                        p = new Rook(true, new Position(column,row));
                    }else if (column == 1 || column == 6){
                        p= new Knight(true,new Position(column,row));
                    }else if (column == 2 || column == 5){
                        p = new Bishop(true,new Position(column,row));
                    }else if (column == 4){
                        p = new Queen(true,new Position(column,row));
                    }else if (column == 3){
                        p = new King(true,new Position(column,row));
                    }
                }else if(row == 1){
                    p = new Pawn(true,new Position(column,row));
                }else if (row == 6){
                    p = new Pawn(false,new Position(column,row));
                }else if (row == 7){
                    if (column == 0 || column == 7){
                        p = new Rook(false, new Position(column,row));
                    }else if (column == 1 || column == 6){
                        p = new Knight(false,new Position(column,row));
                    }else if (column == 2 || column == 5){
                        p = new Bishop(false,new Position(column,row));
                    }else if (column == 4){
                        p = new Queen(false,new Position(column,row));
                    }else if (column == 3){
                        p = new King(false,new Position(column,row));
                    }
                }
                board[row][column] = p;
            }
        }
    }

    public void printBoard(){
        for (int row = 7; row >= 0;row--) {
            for (int column = 0; column < board[row].length; column++) {
                Piece piece = board[row][column];
                if(piece !=null){
                    System.out.print(" " +((Piece)board[row][column]).getIcon());
                }else{
                    System.out.print(" "+BoardIcons.EMPTY.getCode());
                }
            }
            System.out.println(" " + (row+1));
        }
        ApplicationUtils.axis_x.forEach(c-> System.out.print(" " + c));
        System.out.println("\n " + "White move ");

    }

    public void askForMove(String ask){
        InputCollector.getUserInput(ask);
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void changePosition(int[] positions) throws InvalidMovement {
        Position newPosition = new Position(positions[2],positions[3]);
        Piece piece = this.board[positions[1]][positions[0]];
        Position oldPosition = piece.getPosition();
        piece.move(newPosition);
        this.board[oldPosition.getRow()][oldPosition.getCol()] = null;
        this.board[piece.getPosition().getRow()][piece.getPosition().getCol()] = piece;
        printBoard();
    }
    public void printHelOptions(){
        for(HelpOptions help : HelpOptions.values()){
            System.out.println(help.getDescription());
        }

    }

}
