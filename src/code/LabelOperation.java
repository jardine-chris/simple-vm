package code;

import java.util.Stack;

public class LabelOperation implements Operation {
    private Operation operation;
    private int index;

    public LabelOperation(Operation operation, int index) {
        this.operation = operation;
        this.index = index;
    }

    @Override
    public int execute(int programCounter, Stack<Integer> stack, SymbolTable symbolTable) {
        return 0;
    }
}
