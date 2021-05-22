package code;

import java.util.Stack;

/**
 * Object to perform a push operation on a stack.
 *
 * @author Chris Jardine
 * @version May 21, 2021
 */
public class PushOperation implements Operation {
    private final String value;
    private boolean isVariable;

    /**
     * Default constructor.
     *
     * @param value      The value
     * @param isVariable Flag specifying if the value is a variable or not
     */
    public PushOperation(String value, boolean isVariable) {
        this.value = value;
        this.isVariable = isVariable;
    }

    @Override
    public int execute(int programCounter, Stack<Integer> stack,
                       SymbolTable symbolTable) {
        if (isVariable) {
            stack.push(symbolTable.getValue(value));
            return 0;
        }
        stack.push(Integer.parseInt(value));
        return 0;
    }
}
