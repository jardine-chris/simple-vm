package code;

import java.util.Stack;

public class SubtractOperation implements Operation {
    @Override
    public int execute(int programCounter, Stack<Integer> stack,
                       SymbolTable symbolTable) {
        Integer x = stack.pop();
        Integer y = stack.pop();
        stack.push(x - y);
        return ++programCounter;
    }
}
