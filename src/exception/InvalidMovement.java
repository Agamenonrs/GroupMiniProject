package exception;
/*
@author Agamenon
*/

public class InvalidMovement extends Exception {
    private String message = "Invalid movement. Please try again";

    @Override
    public String getMessage() {
        return message;
    }
}
