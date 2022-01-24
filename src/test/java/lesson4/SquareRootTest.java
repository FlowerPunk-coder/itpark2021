package lesson4;

import org.junit.Assert;
import org.junit.Test;

public class SquareRootTest {


    @Test
    public void shouldSquareRoot() {

        Assert.assertEquals(5, SquareRoot.sqrt(25));

        Assert.assertEquals(9, SquareRoot.sqrt(81));

        Assert.assertEquals(-31, SquareRoot.sqrt(1000));

    }
}
