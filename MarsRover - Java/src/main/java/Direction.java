public enum Direction {
    NORTH {@Override public Direction rotateRight() {return EAST;}
        @Override public Direction rotateLeft() { return WEST; }
        @Override public String toString() { return "N"; }},
    WEST {@Override public Direction rotateRight() {return NORTH;}
        @Override public Direction rotateLeft() { return SOUTH; }
        @Override public String toString() { return "W"; }},
    SOUTH {@Override public Direction rotateRight() {return WEST;}
        @Override public Direction rotateLeft() { return EAST; }
        @Override public String toString() { return "S"; }},
    EAST {@Override public Direction rotateRight() {return SOUTH;}
        @Override public Direction rotateLeft() { return NORTH; }
        @Override public String toString() { return "E"; }};

    public abstract Direction rotateRight();
    public abstract Direction rotateLeft();
}
