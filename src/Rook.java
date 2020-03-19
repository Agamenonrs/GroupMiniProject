import enumeration.BoardIcons;
import exception.InvalidMovement;

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
        || newPosition.getRow() == this.position.getRow()){
            return true;
        }
        return false;
    }

    @Override
    public void move(Position position, Game game) throws InvalidMovement {
        System.out.println("path--->"+checkPath(this.position,position,game));
        if (super.isValidMove(position) && isValidMove(position) && checkPath(this.position,position,game)){
            System.out.println("Valid move");
            this.position= position;
        }else{
            throw  new InvalidMovement();
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

    @Override
    public boolean checkPath(Position oldPosition, Position newPosition, Game game) {
        boolean vertical = oldPosition.getCol()==newPosition.getCol()?true:false;
        System.out.println(vertical);
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
            System.out.println(goRight);
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
