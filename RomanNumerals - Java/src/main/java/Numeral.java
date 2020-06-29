public enum Numeral{
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    M(1000);

    public int value;

    Numeral(int value) {
        this.value = value;
    }

    public char getNextChar(int next){
        if((ordinal() + next) < values().length)
            return values()[this.ordinal() + next].name().charAt(0);
        return Character.MIN_VALUE;
    }
}
