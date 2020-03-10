package enumeration;/*
@author Agamenon
*/

public enum HelpOptions {

    HELP("help","* type 'help' for help"),
    BOARD("board","* type 'board' to see the board again"),
    RESIGN("resign","* type 'resign' to resign"),
    MOVES("moves","* type 'moves' to list all possible moves"),
    SQUARE("","* type square (e.g. b1, e2) to list possible moves for that square"),
    UCI("","* type UCI (e.g. b1c3, e7e8q) to make move");

    String code;
    String description;

    HelpOptions(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
