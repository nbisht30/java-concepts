package timbuchalka.ImmutabilityExample2;

public class Immutable {
    private final int value;

    public Immutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}