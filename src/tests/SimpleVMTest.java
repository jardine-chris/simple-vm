package tests;
import java.io.BufferedReader;
import java.io.StringReader;

import code.SimpleVM;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the simple virtual machine.
 *
 * @author Tim
 * @author Chris Jardine
 * @version May 21, 2021
 */
public class SimpleVMTest {

    /**
     * Test the simple vm.
     * @throws Exception
     */
    @Test
    public void testWriteup() throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(
                "push 5\n"
                + "push 7\n"
                + "add\n"
                + "pop x\n"
                + "push x\n"
                + "push 3\n"
                + "add\n"
                + "pop y\n"
                ));
        
        SimpleVM vm = new SimpleVM(reader);
        vm.run();
        assertEquals(12, vm.getValue("x"));
        assertEquals(15, vm.getValue("y"));
    }
}
