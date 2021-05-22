package code;

import java.util.Stack;

/**
 * Object to perform an add operation from the stack.
 *
 * @author Chris Jardine
 * @version May 21, 2021
 */
public class AddOperation implements Operation {

    @Override
    public int execute(int programCounter, Stack<Integer> stack,
                       SymbolTable symbolTable) {
        Integer x = stack.pop();
        Integer y = stack.pop();
        stack.push(x + y);
        return 0;
    }
}
