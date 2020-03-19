import enumeration.BoardIcons;
import exception.InvalidMovement;

public class Rook extends Piece {

    public Rook(boolean isWhite, Position position) {
        super(5, isWhite, position);
    }

    public Rook() {
        super(5);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        /*If the piece moves from (X1, Y1) to (X2, Y2),
        the move is valid if and only if  X2 = X1  or  Y2 = Y1 .*/
        if (newPosition.getCol() == this.position.getCol()
                || newPosition.getRow() == this.position.getCol()) {
            return true;
        }
        return false;
    }

    @Override
    public void move(Position position) throws InvalidMovement {
        if (super.isValidMove(position) && isValidMove(position)) {
            System.out.println("Valid move");
            this.position = position;
        } else {
            throw new InvalidMovement();
        }
    }

    @Override
    public String getIcon() {
        return isWhite ? BoardIcons.WHITE_ROOK.getCode() : BoardIcons.BLACK_ROOK.getCode();
    }

    @Override
    public String toString() {
        return "Rook{value= " + getValue() + "}";
    }
}
