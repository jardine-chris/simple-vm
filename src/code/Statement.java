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

        // Flag to declare if an Integer or variable was entered.
        boolean isVariable = false;
        if (splitStatement.length > 1) {
            try {
                Integer.parseInt(splitStatement[1]);
            }
            // Can't be converted to an Integer because it's a variable name.
            catch (NumberFormatException e) {
                isVariable = true;
            }
        }

        // Create Operation objects based on the command name.
        if (command.equalsIgnoreCase("push")) {
            return new PushOperation(splitStatement[1], isVariable);
        }
        else if (command.equalsIgnoreCase("pop")) {
            return new PopOperation(splitStatement[1]);
        }
        else if (command.equalsIgnoreCase("add")) {
            return new AddOperation();
        }
        return null;
    }
}
