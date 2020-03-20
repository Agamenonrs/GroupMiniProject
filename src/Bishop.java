import enumeration.BoardIcons;
import exception.InvalidMovement;

public class Bishop extends Piece {

    public  Bishop(boolean isWhite, Position position){
        super(3, isWhite, position);
    }

    public Bishop(boolean b){
        super(3);
    }

    @Override
    public boolean isValidMove(Position newPosition){
       /* If the piece moves from (X1, Y1) to (X2, Y2),
            the move is valid if and only if |X2 ‐ X1| =|Y2 ‐ Y1*/
        if ( super.isValidMove(newPosition) &&
                Math.abs(newPosition.getCol() - this.position.getCol()) ==
                Math.abs(newPosition.getRow() - this.position.getRow())){
            return true;
        }
        return  false;
    }

    @Override
    public void move(Position position,Game game) throws InvalidMovement {
        if (super.isValidMove(position) && isValidMove(position)&& checkPath(this.position,position,game)){
            System.out.println("Valid move");
            this.position= position;

        }else{
            throw  new InvalidMovement();
        }
    }

    @Override
    public String getIcon(){
        return isWhite ? BoardIcons.WHITE_BISHOP.getCode() : BoardIcons.BLACK_BISHOP.getCode();
    }

    @Override
    public String toString() {
        return "Bishop{value= "+getValue()+"}";
    }

    @Override
    public boolean checkPath(Position oldPosition, Position newPosition, Game game) {
        int move = Math.abs(newPosition.getCol() - this.position.getCol());
        for(int i = move-1;i>0;i--){
            //left
            if(oldPosition.getCol()<newPosition.getCol()&&oldPosition.getRow()<newPosition.getRow()){
                if (!(super.isValidMove(new Position(oldPosition.getCol()+i,oldPosition.getRow()+i)))||game.getBoard()[oldPosition.getRow()+i][oldPosition.getCol()+i] != null){
                    return false;
                }
            }
           //right
            if(oldPosition.getCol()<newPosition.getCol()&&oldPosition.getRow()>newPosition.getRow()){
                if (!(super.isValidMove(new Position(oldPosition.getCol()+i,oldPosition.getRow()-i)))||game.getBoard()[oldPosition.getRow()-i][oldPosition.getCol()+i] != null){
                    return false;
                }
            }
        }
        return true;
    }
}