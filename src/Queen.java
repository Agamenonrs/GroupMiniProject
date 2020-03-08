import enumeration.BoardIcons;

public class Queen extends Piece {

    public  Queen(boolean isWhite, Position position){
        super(9, isWhite, position);
    }

    public Queen(){
        super(9);
    }

    @Override
    public void move() {
        System.out.println("Like bishop and rook");
    }

    @Override
    public String getIcon(){
        return isWhite ? BoardIcons.WHITE_QUEEN.getCode() : BoardIcons.BLACK_QUEEN.getCode();
    }

    @Override
    public String toString() {
        return "Queen{value= "+getValue()+"}";
    }

}
