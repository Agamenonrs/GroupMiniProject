import exception.InvalidMovement;

import java.util.Objects;

public abstract class Piece {

    protected int value;
    protected boolean isWhite;
    protected Position position;

    public Piece(int value, boolean isWhite,Position position){
        this(value);
        this.isWhite = isWhite;
        this.position = position;
    }

    public Piece(int value){
        this.value = value;
    }

    public boolean isValidMove(Position newPosition ){
        if(newPosition.getRow() >= 0 && newPosition.getCol() >= 0
            && newPosition.getCol() <= 8 && newPosition.getCol() <= 8)
            return true;

        return false;
    }

    public abstract boolean isValidMove(Position newPosition, Game game );

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public abstract void move(Position position, Game game) throws InvalidMovement;

    public abstract String getIcon();

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "value=" + value +
                ", isWhite=" + isWhite +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return value == piece.value &&
                isWhite == piece.isWhite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, isWhite);
    }


    public abstract boolean checkPath(Position oldPosition, Position newPosition, Game game);
}
