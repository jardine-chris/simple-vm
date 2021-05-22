package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    private final BufferedReader reader;

    // Parser will add each statement to a list
    private final ArrayList<Statement> statements;

    /**
     * Default constructor.
     *
     * @param reader BufferedReader to be parsed
     */
    public Parser(BufferedReader reader) {
        this.reader = reader;
        statements = new ArrayList<>();
    }

    /**
     * Parse the BufferedReader object, adding each line as a Statement object
     * to an ArrayList.
     *
     * @return true if successfully parsed, false otherwise
     */
    public boolean parse() throws IOException {
        // Attempt to read a line from the reader.
        String line = reader.readLine();

        // Return false if there's nothing to parse.
        if (line == null) {
            return false;
        }

        // If there's something to read:
        while (line != null) {
            // Create a new Statement and add it to the ArrayList.
            Statement fetchedLine = new Statement(line);
            statements.add(fetchedLine);

            // Read the next line.
            line = reader.readLine();
        }
        return true;
    }

    /**
     * Retrieve the list of Statements.
     *
     * @return the list of Statements
     */
    public ArrayList<Statement> getStatements() {
        return statements;
    }
}
