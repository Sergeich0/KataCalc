package me.sergeich0;

public enum Action {
    SUM("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    private final String textValue;

    Action(String action) {
        this.textValue = action;
    }

    public static Action fromString(String value) {
        for (Action a : Action.values()) {
            if (a.textValue.equals(value)) {
                return a;
            }
        }
        return null;
    }
}
