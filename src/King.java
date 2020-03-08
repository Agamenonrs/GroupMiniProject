import enumeration.BoardIcons;

public class King extends Piece {

    public  King(boolean isWhite, Position position){
        super(1000, isWhite, position);
    }

    public King(){
        super(1000);
    }

    @Override
    public void move() {
        System.out.println("One square");
    }

    @Override
    public String getIcon(){
        return isWhite ? BoardIcons.WHITE_KING.getCode() : BoardIcons.BLACK_KING.getCode();
    }

    @Override
    public String toString() {
        return "King{value= " +getValue()+ " }";
    }

}
