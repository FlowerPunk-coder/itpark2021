package lesson12.except;

public class MyArraySizeException extends RuntimeException {

    private String msg;

    public MyArraySizeException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
