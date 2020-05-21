package symboltable;

public class VariableSymbol extends Symbol {
    public VariableSymbol(String name, Type type) {
        super(name, type);
    }

    @Override
    public String toString() {
        return "var " + super.toString();
    }
}
