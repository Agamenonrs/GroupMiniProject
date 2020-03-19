import enumeration.BoardIcons;
import exception.InvalidMovement;

public class King extends Piece {

    public King(boolean isWhite, Position position) {
        super(1000, isWhite, position);
    }

    public King() {
        super(1000);
    }

    public void move(Position position) throws InvalidMovement {
        if (super.isValidMove(position) && isValidMove(position)) {
            System.out.println("Valid move");
            this.position = position;
        } else {
            throw new InvalidMovement();
        }
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        /* If the piece moves from (X1, Y1) to (X2, Y2), the move is valid if and only if |X2 ‐ X1| <=1, and
                |Y2 ‐ Y1| <= 1 .*/
        if (Math.abs(newPosition.getCol() - this.position.getCol()) <= 1
                && Math.abs(newPosition.getRow() - this.position.getRow()) <= 1) {
            return true;
        }
        /*if ( (position.getRow() == this.position.getRow()+1 || position.getRow() == this.position.getRow()-1)
                ||
                (position.getCol() == this.position.getCol()+1 || position.getCol() == this.position.getCol()-1)){
            return true;
        }*/

        return false;
    }

    @Override
    public String getIcon() {
        return isWhite ? BoardIcons.WHITE_KING.getCode() : BoardIcons.BLACK_KING.getCode();
    }

    @Override
    public String toString() {
        return "King{value= " + getValue() + " }";
    }

}
