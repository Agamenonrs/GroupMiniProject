package enumeration;/*
@author Agamenon
*/

public enum BoardIcons {


    /*
       king \u2654
       Queen \u2655
       Rook \u2656
       Bishop \u2657
       Knight \u2658
       Pawn \u2659
       System.out.println("\u2654");
       System.out.println("\u2655");
       System.out.println("\u2656");
       System.out.println("\u2657");
       System.out.println("\u2658");
       System.out.println("\u2659");

       System.out.println("\u265a");
       System.out.println("\u265b");
       System.out.println("\u265c");
       System.out.println("\u265d");
       System.out.println("\u265e");
       System.out.println("\u265f");
       System.out.println("\u25CB"); circle
     */
    WHITE_KING("\u2654"),
    WHITE_QUEEN("\u2655"),
    WHITE_ROOK("\u2656"),
    WHITE_BISHOP("\u2657"),
    WHITE_KNIGHT("\u2658"),
    WHITE_PAWN("\u2659"),

    BLACK_KING("\u2654"),
    BLACK_QUEEN("\u2655"),
    BLACK_ROOK("\u2656"),
    BLACK_BISHOP("\u2657"),
    BLACK_KNIGHT("\u2658"),
    BLACK_PAWN("\u2659"),

    EMPTY("\u25CB");



    private String code;

    BoardIcons(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
