package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import code.SimpleVM;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
        // subtract and multiply
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

    /**
     * Test the compareEQ operation.
     *
     * @throws IOException
     */
    @Test
    public void testCompareEq() throws IOException {
        // compareEQ
        BufferedReader reader = new BufferedReader(new StringReader(
                "push 5\n" +
                        "pop x\n" +
                        "push 5\n" +
                        "pop y\n" +
                        "push x\n" +
                        "push y\n" +
                        "compareEQ\n" +
                        "pop z"
                        ));

        SimpleVM vm = new SimpleVM(reader);
        vm.run();
        assertEquals(1, vm.getValue("z"));
    }

    /**
     * Test the compareEQ operation.
     *
     * @throws IOException
     */
    @Test
    public void testCompareNeq() throws IOException {
        // compareNEQ
        BufferedReader reader = new BufferedReader(new StringReader(
                "push 5\n" +
                        "pop x\n" +
                        "push 8\n" +
                        "pop y\n" +
                        "push x\n" +
                        "push y\n" +
                        "compareNEQ\n" +
                        "pop z"
        ));

        SimpleVM vm = new SimpleVM(reader);
        vm.run();
        assertEquals(1, vm.getValue("z"));
    }

    /**
     * Test the compareGT operation.
     *
     * @throws IOException
     */
    @Test
    public void testCompareGt() throws IOException {
        // compareGT
        BufferedReader reader = new BufferedReader(new StringReader(
                "push 5\n" +
                        "pop x\n" +
                        "push 8\n" +
                        "pop y\n" +
                        "push x\n" +
                        "push y\n" +
                        "compareGT\n" +
                        "pop z"
        ));

        SimpleVM vm = new SimpleVM(reader);
        vm.run();
        assertEquals(1, vm.getValue("z"));
    }

    /**
     * Test the compareGTE operation.
     *
     * @throws IOException
     */
    @Test
    public void testCompareGte() throws IOException {
        // compareGTE when greater than but not equal
        BufferedReader reader = new BufferedReader(new StringReader(
                "push 5\n" +
                        "pop x\n" +
                        "push 8\n" +
                        "pop y\n" +
                        "push x\n" +
                        "push y\n" +
                        "compareGTE\n" +
                        "pop z"
        ));

        SimpleVM vm = new SimpleVM(reader);
        vm.run();
        assertEquals(1, vm.getValue("z"));

        // compareGTE when equal
        reader = new BufferedReader(new StringReader(
                "push 5\n" +
                        "pop x\n" +
                        "push 5\n" +
                        "pop y\n" +
                        "push x\n" +
                        "push y\n" +
                        "compareGTE\n" +
                        "pop z"
        ));

        vm = new SimpleVM(reader);
        vm.run();
        assertEquals(1, vm.getValue("z"));
    }

    /**
     * Test the compareLT operation.
     *
     * @throws IOException
     */
    @Test
    public void testCompareLt() throws IOException {
        // compareLT
        BufferedReader reader = new BufferedReader(new StringReader(
                "push 8\n" +
                        "pop x\n" +
                        "push 5\n" +
                        "pop y\n" +
                        "push x\n" +
                        "push y\n" +
                        "compareLT\n" +
                        "pop z"
        ));

        SimpleVM vm = new SimpleVM(reader);
        vm.run();
        assertEquals(1, vm.getValue("z"));
    }

    /**
     * Test the compareLTE operation.
     *
     * @throws IOException
     */
    @Test
    public void testCompareLte() throws IOException {
        // compareLTE when greater than but not equal
        BufferedReader reader = new BufferedReader(new StringReader(
                "push 8\n" +
                        "pop x\n" +
                        "push 5\n" +
                        "pop y\n" +
                        "push x\n" +
                        "push y\n" +
                        "compareLTE\n" +
                        "pop z"
        ));

        SimpleVM vm = new SimpleVM(reader);
        vm.run();
        assertEquals(1, vm.getValue("z"));

        // compareLTE when equal
        reader = new BufferedReader(new StringReader(
                "push 5\n" +
                        "pop x\n" +
                        "push 5\n" +
                        "pop y\n" +
                        "push x\n" +
                        "push y\n" +
                        "compareGTE\n" +
                        "pop z"
        ));

        vm = new SimpleVM(reader);
        vm.run();
        assertEquals(1, vm.getValue("z"));
    }
}