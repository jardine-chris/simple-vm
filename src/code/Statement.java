package code;

/**
 * Build a Statement object that represents one line of a command.
 *
 * @author Chris Jardine
 * @version May 21, 2021
 */
public class Statement {
    private String[] splitStatement;

    /**
     * Default constructor.
     *
     * @param statement a String to be represented as a Statement
     */
    public Statement(String statement) {
        splitStatement = statement.split(" ");
    }

    /**
     * Get the Operation declared in the command name.
     *
     * @return the Operation
     */
    public Operation getOperation() {
        String command = splitStatement[0];

        // Determine if operation has a label.
        if ((splitStatement.length > 1 && splitStatement.length <= 3)
                && command.charAt(command.length() - 1) == ':') {
            return getLabelOperation();
        }

        // Determine if operation is a stack or branch operation.
        if (splitStatement.length == 2) {
            String value = splitStatement[1];

            // Flag to declare if an Integer or variable was entered.
            boolean isVariable = isVariable(value);

            if (command.equalsIgnoreCase("push")) {
                return new PushOperation(value, isVariable);
            }
            else if (command.equalsIgnoreCase("pop")) {
                return new PopOperation(value);
            }
            else if (command.equalsIgnoreCase("branch")) {
                return new BranchOperation();
            }
            else if (command.equalsIgnoreCase("branchT")) {
                return new BranchTOperation();
            }
        }

        // Determine if operation is an arithmetic or compare operation.
        if (splitStatement.length == 1) {
            if (command.equalsIgnoreCase("add")) {
                return new AddOperation();
            }
            else if (command.equalsIgnoreCase("subtract")) {
                return new SubtractOperation();
            }
            else if (command.equalsIgnoreCase("multiply")) {
                return new MultiplyOperation();
            }
            else if (command.equalsIgnoreCase("divide")) {
                return new DivideOperation();
            }
            else if (command.equalsIgnoreCase("compareEQ")) {
                return new CompareEqOperation();
            }
            else if (command.equalsIgnoreCase("compareNEQ")) {
                return new CompareNeqOperation();
            }
            else if (command.equalsIgnoreCase("compareLT")) {
                return new CompareLtOperation();
            }
            else if (command.equalsIgnoreCase("compareLTE")) {
                return new CompareLteOperation();
            }
            else if (command.equalsIgnoreCase("compareGT")) {
                return new CompareGtOperation();
            }
            else if (command.equalsIgnoreCase("compareGTE")) {
                return new CompareGteOperation();
            }
        }
        return null;
    }

    private Operation getLabelOperation() {
        return null;
    }

    /**
     * Helper method to determine if the value is a constant or a variable.
     * @param value The value
     * @return True if it's a variable, false otherwise
     */
    private boolean isVariable(String value) {
        try {
            Integer.parseInt(value);
            return false;
        }
        // Can't be converted to an Integer because it's a variable name.
        catch (NumberFormatException e) {
            return true;
        }
    }
}
