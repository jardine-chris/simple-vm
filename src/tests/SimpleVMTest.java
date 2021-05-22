package tests;

import java.io.BufferedReader;
import java.io.IOException;
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
     * Test the add operation.
     *
     * @throws IOException
     */
    @Test
    public void testAdd() throws IOException {
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

    /**
     * Test the subtract operation.
     *
     * @throws IOException
     */
    @Test
    public void testSubtract() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(
                "push 5\n"
                        + "push 7\n"
                        + "subtract\n"
                        + "pop x\n"
                        + "push x\n"
                        + "push 3\n"
                        + "subtract\n"
                        + "pop y\n"
        ));

        SimpleVM vm = new SimpleVM(reader);
        vm.run();
        assertEquals(2, vm.getValue("x"));
        assertEquals(1, vm.getValue("y"));
    }

    /**
     * Test the subtract operation.
     *
     * @throws IOException
     */
    @Test
    public void testMultiply() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(
                "push 5\n"
                        + "push 7\n"
                        + "multiply\n"
                        + "pop x\n"
                        + "push x\n"
                        + "push 3\n"
                        + "multiply\n"
                        + "pop y\n"
        ));

        SimpleVM vm = new SimpleVM(reader);
        vm.run();
        assertEquals(35, vm.getValue("x"));
        assertEquals(105, vm.getValue("y"));
    }

    /**
     * Test the subtract operation.
     *
     * @throws IOException
     */
    @Test
    public void testDivide() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(
                "push 5\n"
                        + "push 7\n"
                        + "divide\n"
                        + "pop x\n"
                        + "push x\n"
                        + "push 3\n"
                        + "divide\n"
                        + "pop y\n"
        ));

        SimpleVM vm = new SimpleVM(reader);
        vm.run();
        assertEquals(1, vm.getValue("x"));
        assertEquals(3, vm.getValue("y"));
    }

    /**
     * Test the subtract operation.
     *
     * @throws IOException
     */
    @Test
    public void testCombo() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(
                "push 5\n"
                        + "push 7\n"
                        + "subtract\n"
                        + "pop x\n"
                        + "push x\n"
                        + "push 3\n"
                        + "multiply\n"
                        + "pop y\n"
        ));

        SimpleVM vm = new SimpleVM(reader);
        vm.run();
        assertEquals(2, vm.getValue("x"));
        assertEquals(6, vm.getValue("y"));
    }
}
