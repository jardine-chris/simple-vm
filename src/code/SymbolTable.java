package code;

import java.util.ArrayList;

/**
 * Manages the available variables.
 *
 * @author Tim
 * @author Chris Jardine
 * @version May 21, 2021
 */
public class SymbolTable {

    private ArrayList<Symbol> symbols;

    /**
     * Creates a SymbolTable.
     */
    public SymbolTable() {
        symbols = new ArrayList<Symbol>();
    }

    /**
     * Helper method to retrieve a Symbol from the table.
     *
     * @param name Name of the Symbol
     * @return the Symbol
     */
    private Symbol getSymbol(String name) {
        for (Symbol s : symbols) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Sets the value of the given variable.
     *
     * @param name  the name
     * @param value the value
     */
    public void setValue(String name, int value) {
        // Find the Symbol name
        Symbol refSymbol = getSymbol(name);
        // If it already exists, set the value.
        if (refSymbol != null) {
            refSymbol.setValue(value);
        }
        // If it doesn't exist, add a new Symbol to the ArrayList.
        else {
            symbols.add(new Symbol(name, value));
        }
    }

    /**
     * Returns the value of the given variable.
     *
     * @param name the name
     * @return the value
     * @throws RuntimeException if the variable is not defined
     */
    public int getValue(String name) {
        Symbol refSymbol = getSymbol(name);
        if (refSymbol != null) {
            return refSymbol.getValue();
        }
        return 0;
    }

    private static class Symbol {
        private String name;
        private int value;

        /**
         * Default constructor.
         *
         * @param name  The symbol name
         * @param value The symbol value
         */
        public Symbol(String name, int value) {
            this.name = name;
            this.value = value;
        }

        /**
         * Get the name.
         *
         * @return The name
         */
        public String getName() {
            return name;
        }

        /**
         * Set the name.
         *
         * @param name The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Get the value.
         *
         * @return The value
         */
        public int getValue() {
            return value;
        }

        /**
         * Set the value.
         *
         * @param value The value
         */
        public void setValue(int value) {
            this.value = value;
        }
    }
}
