package exception;
/*
@author Agamenon
*/

public class InvalidPlayer extends Exception {
    private String message = "Invalid Player";

    @Override
    public String getMessage() {
        return message;
    }
}
