import enumeration.BoardIcons;
import exception.InvalidMovement;

public class Queen extends Piece {

    public  Queen(boolean isWhite, Position position){
        super(9, isWhite, position);
    }

    public Queen(){
        super(9);
    }

    public boolean isValidMove(Position newPosition){
        //valid move as ROOK
        if(newPosition.getCol() == this.position.getCol()|| newPosition.getRow() == this.position.getCol()){
            return true;
        }
        //valid move of BISHOP
        if ( super.isValidMove(newPosition) &&
                Math.abs(newPosition.getCol() - this.position.getCol()) ==
                        Math.abs(newPosition.getRow() - this.position.getRow())){
            return true;
        }
        return false;
    }

    @Override

    public void move(Position position,Game game) throws InvalidMovement {
        if (super.isValidMove(position) && isValidMove(position)){
            System.out.println("Valid move");
            this.position= position;
        }else{
            throw  new InvalidMovement();
        }
    }


    @Override
    public String getIcon(){
        return isWhite ? BoardIcons.WHITE_QUEEN.getCode() : BoardIcons.BLACK_QUEEN.getCode();
    }

    @Override
    public String toString() {
        return "Queen{value= "+getValue()+"}";
    }

    @Override
    public boolean checkPath(Position oldPosition, Position newPosition, Game game) {
        return false;
    }

}
