package exeptions;

public class WrongLoginExeption extends Exception{

    public WrongLoginExeption() {
    }

    public WrongLoginExeption(String message) {
        super(message);
    }
}

