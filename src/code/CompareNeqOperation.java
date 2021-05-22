package code;

import java.util.Stack;

public class CompareNeqOperation implements Operation {
    @Override
    public int execute(int programCounter, Stack<Integer> stack, SymbolTable symbolTable) {
        Integer x = stack.pop();
        Integer y = stack.pop();
        if (!x.equals(y)) {
            stack.push(1);
        }
        else {
            stack.push(0);
        }
        return ++programCounter;
    }
}
