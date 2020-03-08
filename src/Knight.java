import enumeration.BoardIcons;

public class Knight extends Piece {

    public  Knight(boolean isWhite, Position position){
        super(2, isWhite, position);
    }

    public Knight(){
        super(2);
    }

    @Override
    public void move() {
        System.out.println("Like an L");
    }

    @Override
    public String getIcon(){
        return isWhite ? BoardIcons.WHITE_KNIGHT.getCode() : BoardIcons.BLACK_KNIGHT.getCode();
    }

    @Override
    public String toString() {
        return "Knight{value= "+getValue()+"}";
    }
}
