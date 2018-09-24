import org.junit.Assert;
import org.junit.Test;

public class ParserTests {

    @Test
    public void test1(){
        Parser parser = new Parser("4+9");
        Expression expTree = parser.parse();
        long result = expTree.calculate();
        Assert.assertEquals(13,result);
    }

    @Test
    public void test2(){
        Parser parser = new Parser("(4+9)*2");
        Expression expTree = parser.parse();
        long result = expTree.calculate();
        Assert.assertEquals(26,result);
    }

    @Test
    public void test3(){
        Parser parser = new Parser("2>29");
        Expression expTree = parser.parse();
        long result = expTree.calculate();
        Assert.assertEquals(0,result);
    }

    @Test
    public void test4(){
        Parser parser = new Parser("6+7=7+6");
        Expression expTree = parser.parse();
        long result = expTree.calculate();
        Assert.assertEquals(1,result);
    }

    @Test
    public void test5(){
        Parser parser = new Parser("(15-6-6)*3");
        Expression expTree = parser.parse();
        long result = expTree.calculate();
        Assert.assertEquals(9,result);
    }

    @Test
    public void test6(){
        Parser parser = new Parser("1+1-1+1+0-0");
        Expression expTree = parser.parse();
        long result = expTree.calculate();
        Assert.assertEquals(2,result);
    }

    @Test
    public void test7(){
        Parser parser = new Parser("4+9<4*9");
        Expression expTree = parser.parse();
        long result = expTree.calculate();
        Assert.assertEquals(1,result);
    }

}
