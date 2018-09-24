import org.junit.Assert;
import org.junit.Test;

public class FactorTests {

    @Test
    public void calculateTest1(){
        Factor factor = new Factor(new Number(0), new Number(10));
        long result = factor.calculate();
        Assert.assertEquals(0, result);
    }

    @Test
    public void calculateTest2(){
        Factor factor = new Factor(new Number(1), new Number(5));
        long result = factor.calculate();
        Assert.assertEquals(5, result);
    }

    @Test
    public void calculateTest3(){
        Factor factor = new Factor(new Number(4), new Number(3));
        long result = factor.calculate();
        Assert.assertEquals(12, result);
    }



}
