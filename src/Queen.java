import enumeration.BoardIcons;
import exception.InvalidMovement;

public class Queen extends Piece {

    public  Queen(boolean isWhite, Position position){
        super(9, isWhite, position);
    }

    public Queen(){
        super(9);
    }

    @Override
    public void move(Position newPosition) throws InvalidMovement {
        if(isValidMove(newPosition)){
            System.out.println("Valid move");
            this.position= position;

        }else{
            throw new InvalidMovement();
        }
    }

    @Override
    public boolean isValidMove(Position newPosition){
        if(super.isValidMove(newPosition) && (
                //bishop move
                (Math.abs(newPosition.getCol() - this.position.getCol()) ==
                        Math.abs(newPosition.getRow() - this.position.getRow()))
                        ||
                        //Rook move
                        ( newPosition.getCol() == this.position.getCol()
                                || newPosition.getRow() == this.position.getCol())

        )){
            return true;
        }
        return false;
    }


    @Override
    public String getIcon(){
        return isWhite ? BoardIcons.WHITE_QUEEN.getCode() : BoardIcons.BLACK_QUEEN.getCode();
    }

    @Override
    public String toString() {
        return "Queen{value= "+getValue()+"}";
    }

}
