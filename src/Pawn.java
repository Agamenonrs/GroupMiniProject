import enumeration.BoardIcons;
import exception.InvalidMovement;
import jdk.nashorn.internal.ir.CallNode;

import java.util.Objects;

public class Pawn extends Piece {

    private boolean promoted;
    private Piece newPiece;

    public Pawn(boolean isWite, Position position){
        this(isWite,false,null,position);
    }

    public Pawn(boolean isWhite, boolean promoted, Piece newPiece,Position position){
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
    public void move(Position position) throws InvalidMovement {
        if (super.isValidMove(position) && isValidMove(position)){
            System.out.println("Valid move");
            this.position= position;
        }else{
            System.out.println("Invalid move");
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
        System.out.println(super.isWhite);

        if (!super.isValidMove(newPosition)){
            return false;
        }
        if( isSameColumn(this.position, newPosition)
            && this.position.getRow() + getDiff() == newPosition.getRow() ){
            return true;
        }
        if (super.isWhite && this.position.getRow()==1){
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

}
