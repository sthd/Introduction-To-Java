package Intro;

public class VehicleNotPresentException extends RuntimeException {
    public VehicleNotPresentException() {super();}
    public VehicleNotPresentException(String message) {
        super(message);
    }

}

