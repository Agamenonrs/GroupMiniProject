import enumeration.BoardIcons;

public class King extends Piece {

    public  King(boolean isWhite, Position position){
        super(1000, isWhite, position);
    }

    public King(){
        super(1000);
    }

    public void move(Position position) {
        if (super.isValidMove(position) && isValidMove(position)){
            System.out.println("Valid move");
            this.oldPosition= this.position;
            this.position= position;
        }else{
            System.out.println("Invalid move");
        }
    }

    @Override
    public boolean isValidMove(Position position){
        if ( (position.getRow() == this.position.getRow()+1 || position.getRow() == this.position.getRow()-1)
                ||
                (position.getCol() == this.position.getCol()+1 || position.getCol() == this.position.getCol()-1)){
            return true;
        }

        return false;
    }

    @Override
    public String getIcon(){
        return isWhite ? BoardIcons.WHITE_KING.getCode() : BoardIcons.BLACK_KING.getCode();
    }

    @Override
    public String toString() {
        return "King{value= " +getValue()+ " }";
    }

}
