import java.util.Objects;

public abstract class Piece {

    protected int value;
    protected boolean isWhite;
    protected Position position;
    protected Position oldPosition;

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

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Position getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(Position oldPosition) {
        this.oldPosition = oldPosition;
    }

    public abstract void move(Position position);

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
}
