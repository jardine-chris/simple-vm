package code;

import java.util.Stack;

/**
 * Object to perform a pop operation on a stack.
 *
 * @author Chris Jardine
 * @version May 21, 2021
 */
public class PopOperation implements Operation {
    private final String variable;

    /**
     * Default constructor.
     *
     * @param variable The variable to store the value in.
     */
    public PopOperation(String variable) {
        this.variable = variable;
    }

    @Override
    public int execute(int programCounter, Stack<Integer> stack,
                       SymbolTable symbolTable) {
        Integer value = stack.pop();
        symbolTable.setValue(variable, value);
        return ++programCounter;
    }
}
