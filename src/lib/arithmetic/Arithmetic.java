package lib.arithmetic;

public abstract class Arithmetic {

    protected String first;
    protected String second;

    protected Arithmetic() {
    }

    protected Arithmetic(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public abstract String operation(String a, String b);

    public void setFirst(String first) {
        this.first = first;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}
