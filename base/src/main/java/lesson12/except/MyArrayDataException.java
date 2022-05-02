package lesson12.except;

public class MyArrayDataException extends RuntimeException {

    private String msg;

    public MyArrayDataException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}
