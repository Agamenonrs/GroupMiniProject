import enumeration.BoardIcons;
import exception.InvalidMovement;

import java.util.Objects;

public class Pawn extends Piece {

    private boolean promoted;
    private Piece newPiece;

    public Pawn(boolean isWite, Position position){
        this(isWite,false,null,position);
    }

    public Pawn(boolean isWhite, boolean promoted, Piece newPiece, Position position){
        super(1,isWhite,position);
        this.promoted = promoted;
        this.newPiece = newPiece;
        if (this.newPiece != null)
            this.newPiece.setWhite(isWhite);
    }

    public Pawn(){
        super(1);
    }


    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public Piece getNewPiece() {
        return newPiece;
    }

    public void setNewPiece(Piece newPiece) {
        this.newPiece = newPiece;
    }

    @Override
    public void move(Position position, Game game) throws InvalidMovement {
        if (super.isValidMove(position) && isValidMove(position) && checkPath(this.position,position,game)){
            System.out.println("Valid move");
            this.position= position;
        }else{
            throw  new InvalidMovement();
        }
    }

    @Override
    public String getIcon(){
        return isWhite ? BoardIcons.WHITE_PAWN.getCode() : BoardIcons.BLACK_PAWN.getCode();
    }

    @Override
    public String toString() {
        return "Pawn{value= "+getValue()+"}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), promoted, newPiece);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pawn pawn = (Pawn) o;
        return promoted == pawn.promoted &&
                Objects.equals(newPiece, pawn.newPiece);
    }

    @Override
    public boolean isValidMove(Position newPosition){

        /*If the piece moves from (X1, Y1) to (X2, Y2),
        the move is valid if and only if X2 = X1 and Y2 ‐ Y1 = 1*/

        if( newPosition.getCol() == position.getCol()
            && newPosition.getRow() - position.getRow() == 1 ){
            return true;
        }
        if (super.isWhite && position.getRow()==1){
            if ( newPosition.getRow() == 2 || newPosition.getRow() == 3){
                return true;
            }
        }else if (!(super.isWhite) && this.position.getRow()== 6){
            if ( newPosition.getRow() == 4 || newPosition.getRow() == 5){
                return true;
            }
        }
        return false;
    }

    private int getDiff(){
        return super.isWhite ? +1 : -1 ;
    }

    private boolean isSameColumn(Position p1, Position p2){
        return p1.getCol() == p2.getCol();
    }

    @Override
    public boolean checkPath(Position oldPosition, Position newPosition, Game game) {
        for(int i = oldPosition.getRow()+1;i<=newPosition.getRow();i++){
            if(game.getBoard()[i][oldPosition.getCol()] != null){
                return false;
            }
        }
        return true;
    }
}
