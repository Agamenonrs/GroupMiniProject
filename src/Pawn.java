import enumeration.BoardIcons;
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
    public void move() {
        System.out.println("Forward 1");

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

}
