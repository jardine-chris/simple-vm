package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Creates a simple virtual machine.
 *
 * @author Chris Jardine
 * @version May 21, 2021
 */
public class SimpleVM {
    private ArrayList<Operation> operations;
    private Stack<Integer> stack;
    private SymbolTable symbolTable;

    /**
     * Creates a SimpleVM with the program contained in
     * the supplied BufferedReader.
     *
     * @param reader the BufferedReader containing the program
     */
    public SimpleVM(BufferedReader reader) throws IOException {
        operations = new ArrayList<>();
        stack = new Stack<>();
        symbolTable = new SymbolTable();

        // Convert the text program into a list of Operation objects.
        // Parse the reader object.
        Parser p = new Parser(reader);
        ArrayList<Statement> statements;
        // If there's anything to parse, parse into Statements and add
        // Operations to the operations ArrayList
        if (p.parse()) {
            statements = p.getStatements();
            for (Statement s : statements) {
                operations.add(s.getOperation());
            }
        }
    }

    /**
     * Runs the loaded program.
     */
    public void run() {
        //  Execute the program
        for (int index = 0; index < operations.size(); index++) {
            operations.get(index).execute(index, stack, symbolTable);
        }
    }

    /**
     * Returns the value of the given variable.
     *
     * @param name the variable name
     * @return the value
     */
    public int getValue(String name) {
        //  Looks things up in the symbol table
        return symbolTable.getValue(name);
    }
}
