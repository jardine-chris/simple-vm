package tests;

import code.SimpleVM;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * Test the simple virtual machine.
 *
 * @author Tim
 * @author Chris Jardine
 * @version May 21, 2021
 */
public class ComplexVMTest {

    /**
     * Test the simple vm.
     *
     * @throws Exception
     */
    @Test
    public void testWriteup() throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(
                 "push 0\n" +
                    "pop sum\n" +
                    "push 0\n" +
                    "pop count\n" +
                    "loop: push count\n" +
                    "push 100\n" +
                    "compareGT\n" +
                    "branchT end\n" +
                    "push sum\n" +
                    "push count\n" +
                    "add\n" +
                    "pop sum\n" +
                    "push count\n" +
                    "push 1\n" +
                    "add\n" +
                    "pop count\n" +
                    "branch loop\n" +
                    "end: nop\n"
                    ));

        SimpleVM vm = new SimpleVM(reader);
        vm.run();
        assertEquals(12, vm.getValue("x"));
        assertEquals(15, vm.getValue("y"));
    }
}
