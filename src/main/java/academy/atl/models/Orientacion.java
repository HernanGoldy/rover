package academy.atl.models;

public enum Orientacion {
    NORTE(1), ESTE(1), SUR(-1), OESTE(-1);

    private int value;

    Orientacion(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
