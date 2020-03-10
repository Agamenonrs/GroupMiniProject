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
    public void move(Position position) {
        if (super.isValidMove(position) && isValidMove(position)){
            this.oldPosition= this.position;
            this.position= position;
        }


        super.setPosition(position);
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
    public boolean isValidMove(Position position){
        if (super.isWhite && this.position.getRow()==2){
            if ( position.getRow() == 6 || position.getRow() == 5){
                return true;
            }
        }else if (!(super.isWhite) && this.position.getRow()==7){
            if ( position.getRow() == 3 || position.getRow() == 4){
                return true;
            }
        }else if(super.isWhite && position.getCol() == this.position.getCol() && position.getRow()==this.position.getRow()-1){
                return true;
        }else if(!(super.isWhite) && position.getCol() == this.position.getCol() && position.getRow()==this.position.getRow()+1){
            return true;
        }
        return true;
    }
}
