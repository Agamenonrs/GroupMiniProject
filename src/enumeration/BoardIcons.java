package enumeration;/*
@author Agamenon
*/

public enum BoardIcons {

    WHITE_KING("\u2654"),
    WHITE_QUEEN("\u2655"),
    WHITE_ROOK("\u2656"),
    WHITE_BISHOP("\u2657"),
    WHITE_KNIGHT("\u2658"),
    WHITE_PAWN("\u2659"),

    BLACK_KING("\u265a"),
    BLACK_QUEEN("\u265b"),
    BLACK_ROOK("\u265c"),
    BLACK_BISHOP("\u265d"),
    BLACK_KNIGHT("\u265e"),
    BLACK_PAWN("\u265f"),

    EMPTY("\u25CB");

    private String code;

    BoardIcons(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
