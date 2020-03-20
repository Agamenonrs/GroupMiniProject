import enumeration.BoardIcons;
import exception.InvalidMovement;

public class Knight extends Piece {

    public Knight(boolean isWhite, Position position) {
        super(2, isWhite, position);
    }

    public Knight() {
        super(2);
    }

    @Override
    public void move(Position newPosition,Game game) throws InvalidMovement {
        if (isValidMove(newPosition, game)){
            System.out.println("OK");
            this.position = newPosition;
        }else{
            throw  new InvalidMovement();
        }
    }

    public boolean isValidMove(Position newPosition, Game game) {
        return super.isValidMove(newPosition) && isValidMove(newPosition) && checkPath(position,newPosition,game);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        /*If the piece moves from (X1, Y1) to (X2, Y2), the move is valid if and only if (|X2 ‐ X1| = 1 and
                |Y2 ‐ Y1| = 2) or ((|X2 ‐ X1| = 2 and |Y2 ‐ Y1| = 1) .*/
        if ((Math.abs(newPosition.getCol() - this.position.getCol()) == 1
                && Math.abs(newPosition.getRow() - this.position.getRow()) == 2)
                || (Math.abs(newPosition.getCol() - this.position.getCol()) == 2
                && Math.abs(newPosition.getRow() - this.position.getRow()) == 1)
        ){
            return true;
        }
        /*if ( (position.getRow() == this.position.getRow()+2 || position.getRow() == this.position.getRow()-2)
                &&
                (position.getCol() == this.position.getCol()+1 || position.getCol() == this.position.getCol()-1)){
                return true;
        }
        if ( (position.getCol() == this.position.getCol()+2 || position.getCol() == this.position.getCol()-2)
                &&
                (position.getRow() == this.position.getRow()+1 || position.getRow() == this.position.getRow()-1)){
            return true;
        }*/

        return false;
    }

    @Override
    public String getIcon() {
        return isWhite ? BoardIcons.WHITE_KNIGHT.getCode() : BoardIcons.BLACK_KNIGHT.getCode();
    }

    @Override
    public String toString() {
        return "Knight{value= " + getValue() + "}";
    }

    @Override
    public boolean checkPath(Position oldPosition, Position newPosition, Game game) {
        //TODO
        return true;
    }
}
