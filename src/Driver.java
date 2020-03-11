import enumeration.BoardIcons;

public class Driver {
    public static void main(String[] args) {
        Game game = new Game();
        Piece piece = game.getBoard()[0][3];
        Position position = new Position(1,2);
        piece.move(position);
        //game.changePosition(piece);
    }
}
