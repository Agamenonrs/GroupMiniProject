import com.sun.org.apache.xalan.internal.lib.ExsltStrings;
import enumeration.HelpOptions;
import exception.InvalidMovement;
import exception.InvalidPlayer;
import util.ApplicationUtils;
import enumeration.BoardIcons;
import util.InputCollector;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static util.ApplicationUtils.axis_x;

public class Game {
    private Piece[][] board;
    private boolean whitePlayer = true;

    public Game() {
        board = new Piece[8][8];
        createBoard();
        printBoard();
    }

    private void createBoard() {
        for (int row = 7; row >= 0; row--) {
            for (int column = 0; column < board[row].length; column++) {
                Piece p = null;
                if (row == 0) {
                    if (column == 0 || column == 7) {
                        p = new Rook(true, new Position(column, row));
                    } else if (column == 1 || column == 6) {
                        p = new Knight(true, new Position(column, row));
                    } else if (column == 2 || column == 5) {
                        p = new Bishop(true, new Position(column, row));
                    } else if (column == 4) {
                        p = new Queen(true, new Position(column, row));
                    } else if (column == 3) {
                        p = new King(true, new Position(column, row));
                    }
                } else if (row == 1) {
                    p = new Pawn(true, new Position(column, row));
                } else if (row == 6) {
                    p = new Pawn(false, new Position(column, row));
                } else if (row == 7) {
                    if (column == 0 || column == 7) {
                        p = new Rook(false, new Position(column, row));
                    } else if (column == 1 || column == 6) {
                        p = new Knight(false, new Position(column, row));
                    } else if (column == 2 || column == 5) {
                        p = new Bishop(false, new Position(column, row));
                    } else if (column == 4) {
                        p = new Queen(false, new Position(column, row));
                    } else if (column == 3) {
                        p = new King(false, new Position(column, row));
                    }
                }
                board[row][column] = p;
            }
        }
    }

    public void printBoard() {
        for (int row = 7; row >= 0; row--) {
            for (int column = 0; column < board[row].length; column++) {
                Piece piece = board[row][column];
                if (piece != null) {
                    System.out.print(" " + ((Piece) board[row][column]).getIcon());
                } else {
                    System.out.print(" " + BoardIcons.EMPTY.getCode());
                }
            }
            System.out.println(" " + (row + 1));
        }
        axis_x.forEach(c -> System.out.print(" " + c));
    }

    public void askForMove(String ask) {
        InputCollector.getUserInput(ask);
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void changePosition(Position oldPosition, Position newPosition, Game game) throws InvalidMovement, InvalidPlayer {
        Piece piece = getPieceFromBoard(oldPosition);

        /* throw invalidMoviment if threre is no piece or
            the color piece chosen is wrong*/
        if (piece == null)
            throw new InvalidMovement();
        if (piece.isWhite() != isWhitePlayer())
            throw new InvalidPlayer();

        piece.move(newPosition, game);
        this.board[oldPosition.getRow()][oldPosition.getCol()] = null;
        this.board[piece.getPosition().getRow()][piece.getPosition().getCol()] = piece;
        changePlayer();
        printBoard();
    }

    private Piece getPieceFromBoard(Position position) {
        return this.board[position.getRow()][position.getCol()];
    }

    public void printHelOptions() {
        for (HelpOptions help : HelpOptions.values()) {
            System.out.println(help.getDescription());
        }

    }

    public boolean isWhitePlayer() {
        return whitePlayer;
    }

    public void playerResign() {
        System.out.println(isWhitePlayer() ? "White player resigned! " : "Black player resigned! ");
    }

    /**
     * change de player's turn
     */
    private void changePlayer() {
        whitePlayer = !whitePlayer;
    }

    public void showValidMoves() {
        for (int row = 7; row >= 0; row--) {
            for (int column = 0; column < board[row].length; column++) {
                Piece piece = board[row][column];
                if (piece !=null && piece.isWhite == this.whitePlayer)
                    showValidMoves(piece);
            }
        }
    }

    public void showValidMoves(Piece source) {
        System.out.println("Possible moves for " +
                String.format("%s%d", axis_x.get(source.position.getCol()), source.position.getRow() + 1));
        System.out.print("{");
        for (int row = 7; row >= 0; row--) {
            for (int column = 0; column < board[row].length; column++) {
                Position target = new Position(column, row);
                if (source.isValidMove(target, this)) {
                    System.out.print(String.format("%s%d,", axis_x.get(column).toString(), row + 1));

                }
            }
        }
        System.out.println("}\n");


    }
}
