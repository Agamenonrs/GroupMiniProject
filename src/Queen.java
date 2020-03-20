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
        if(newPosition.getCol() == this.position.getCol()
                || newPosition.getRow() == this.position.getCol()){
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
    public void move(Position newPosition,Game game) throws InvalidMovement {
        if (isValidMove(newPosition, game)){
            System.out.println("OK");
            this.position= newPosition;
        }else{
            throw  new InvalidMovement();
        }
    }

    public boolean isValidMove(Position newPosition, Game game) {
        return super.isValidMove(newPosition) && isValidMove(newPosition)&& checkPath(this.position,newPosition,game);
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
        return checkPathLikeRook(oldPosition,newPosition,game) && checkPathLikeBishop(oldPosition,newPosition,game);
    }

    public boolean checkPathLikeRook(Position oldPosition, Position newPosition, Game game) {
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
    public boolean checkPathLikeBishop(Position oldPosition, Position newPosition, Game game) {
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
