package code;

import java.util.Stack;

public class LabelOperation implements Operation {
    private String name;
    private int index;

    public LabelOperation(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public int execute(int programCounter, Stack<Integer> stack, SymbolTable symbolTable) {
        symbolTable.setValue(name, index);
        return 0;
    }
}
