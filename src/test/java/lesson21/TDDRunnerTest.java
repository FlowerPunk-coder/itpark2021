package lesson21;

import org.junit.Assert;
import org.junit.Test;

public class TDDRunnerTest {

    @Test
    public void shouldGetMessage() {
        TDDRunner tddRunner = new TDDRunner();
        Assert.assertEquals("Hello, World!", tddRunner.printer("Hello, World!"));
    }

    @Test
    public void shouldGetBoolean() {
        TDDRunner tddRunner = new TDDRunner();
        Assert.assertTrue(tddRunner.compareTo(5, 5));
        Assert.assertFalse(tddRunner.compareTo(5, 8));
    }
}
