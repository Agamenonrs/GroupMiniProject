import enumeration.BoardIcons;

public class Knight extends Piece {

    public  Knight(boolean isWhite, Position position){
        super(2, isWhite, position);
    }

    public Knight(){
        super(2);
    }

    @Override
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
        if ( (position.getRow() == this.position.getRow()+2 || position.getRow() == this.position.getRow()-2)
                &&
                (position.getCol() == this.position.getCol()+1 || position.getCol() == this.position.getCol()-1)){
                return true;
        }
        if ( (position.getCol() == this.position.getCol()+2 || position.getCol() == this.position.getCol()-2)
                &&
                (position.getRow() == this.position.getRow()+1 || position.getRow() == this.position.getRow()-1)){
            return true;
        }

        return false;
    }
    @Override
    public String getIcon(){
        return isWhite ? BoardIcons.WHITE_KNIGHT.getCode() : BoardIcons.BLACK_KNIGHT.getCode();
    }

    @Override
    public String toString() {
        return "Knight{value= "+getValue()+"}";
    }
}
