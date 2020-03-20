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
                || newPosition.getRow() == this.position.getRow()) {
            return true;
        }
        return false;
    }

    @Override
    public void move(Position newPosition, Game game) throws InvalidMovement {
        //System.out.println("path--->"+checkPath(this.position,newPosition,game));
        if (isValidMove(newPosition, game)){
            System.out.println("OK");
            this.position= newPosition;
        }else{
            throw  new InvalidMovement();
        }
    }

    public boolean isValidMove(Position newPosition, Game game) {
        return super.isValidMove(newPosition) && isValidMove(newPosition) && checkPath(this.position,newPosition,game);
    }

    @Override
    public String getIcon() {
        return isWhite ? BoardIcons.WHITE_ROOK.getCode() : BoardIcons.BLACK_ROOK.getCode();
    }

    @Override
    public String toString() {
        return "Rook{value= " + getValue() + "}";
    }

    @Override
    public boolean checkPath(Position oldPosition, Position newPosition, Game game) {
        boolean vertical = oldPosition.getCol()==newPosition.getCol()?true:false;
        //System.out.println(vertical);
        if (vertical){
            boolean goUp =oldPosition.getRow()<newPosition.getRow()? true:false;
            if(goUp){
                for (int i = oldPosition.getRow()+1;i<= newPosition.getRow();i++){
                    if (game.getBoard()[i][oldPosition.getCol()] != null)
                        return  false;
                }
            }else{
                for (int i = oldPosition.getRow()+-1;i>= newPosition.getRow();i--){
                    if (game.getBoard()[i][oldPosition.getCol()] != null)
                        return false;
                }
            }
        }else{// if I move horizontal
            boolean goRight =oldPosition.getCol()<newPosition.getCol()? true:false;
            //System.out.println(goRight);
            if(goRight){
                for (int i = oldPosition.getCol()+1;i<= newPosition.getCol();i++){
                    if (game.getBoard()[oldPosition.getRow()][i] != null)
                        return  false;
                }
            }else{
                for (int i = oldPosition.getCol()-1;i>= newPosition.getCol();i--){
                    if (game.getBoard()[oldPosition.getRow()][i] != null)
                        return  false;
                }
            }
        }
        return true;
    }

}
