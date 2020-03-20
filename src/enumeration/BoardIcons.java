package enumeration;/*
@author Agamenon
*/

public enum
BoardIcons {

    BLACK_QUEEN("\u2654"),
    BLACK_KING("\u2655"),
    BLACK_ROOK("\u2656"),
    BLACK_BISHOP("\u2657"),
    BLACK_KNIGHT("\u2658"),
    BLACK_PAWN("\u2659"),


    WHITE_QUEEN("\u265a"),
    WHITE_KING("\u265b"),
    WHITE_ROOK("\u265c"),
    WHITE_BISHOP("\u265d"),
    WHITE_KNIGHT("\u265e"),
    WHITE_PAWN("\u265f"),


    EMPTY(".");

    private String code;

    BoardIcons(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
