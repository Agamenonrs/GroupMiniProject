import enumeration.BoardIcons;

public class Rook extends Piece {

    public  Rook(boolean isWhite,Position position){
        super(5,isWhite,position);
    }

    public Rook(){
        super(5);
    }

    @Override
    public boolean isValidMove(Position newPosition){
        if(newPosition.getCol() == this.position.getCol()
        || newPosition.getRow() == this.position.getCol()){
            return true;
        }
        return false;
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
    public String getIcon(){
        return isWhite ? BoardIcons.WHITE_ROOK.getCode() : BoardIcons.BLACK_ROOK.getCode();
    }

    @Override
    public String toString() {
        return "Rook{value= "+getValue()+"}";
    }
}
