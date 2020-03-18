package exception;
/*
@author Agamenon
*/

public class InvalidMovement extends Exception {
    private String message = "Invalid Movement";

    @Override
    public String getMessage() {
        return message;
    }
}
