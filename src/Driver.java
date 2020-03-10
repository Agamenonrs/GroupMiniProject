import enumeration.BoardIcons;

public class Driver {
    public static void main(String[] args) {
        Game game = new Game();
        Piece piece = game.getBoard()[6][2];
        Position position = new Position(2,3);
        piece.move(position);
        game.changePosition(piece);


    }
}
