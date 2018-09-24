import org.junit.Assert;
import org.junit.Test;

public class RelationTests {

    @Test
    public void calculateTest1(){
        Relation factor = new Relation(Relation.Opcode.equal, new Number(0), new Number(0));
        long result = factor.calculate();
        Assert.assertEquals(1, result);
    }

    @Test
    public void calculateTest2(){
        Relation factor = new Relation(Relation.Opcode.equal, new Number(0), new Number(1));
        long result = factor.calculate();
        Assert.assertEquals(0, result);
    }


    @Test
    public void calculateTest10(){
        Relation factor = new Relation(Relation.Opcode.equal, new Number(-1), new Number(1));
        long result = factor.calculate();
        Assert.assertEquals(0, result);
    }

    @Test
    public void calculateTest3(){
        Relation factor = new Relation(Relation.Opcode.less, new Number(-4), new Number(-1));
        long result = factor.calculate();
        Assert.assertEquals(1, result);
    }

    @Test
    public void calculateTest4(){
        Relation factor = new Relation(Relation.Opcode.less, new Number(-4), new Number(-10));
        long result = factor.calculate();
        Assert.assertEquals(0, result);
    }

    @Test
    public void calculateTest5(){
        Relation factor = new Relation(Relation.Opcode.less, new Number(4), new Number(-1));
        long result = factor.calculate();
        Assert.assertEquals(0, result);
    }

    @Test
    public void calculateTest6(){
        Relation factor = new Relation(Relation.Opcode.greater, new Number(-4), new Number(-1));
        long result = factor.calculate();
        Assert.assertEquals(0, result);
    }

    @Test
    public void calculateTest7(){
        Relation factor = new Relation(Relation.Opcode.greater, new Number(-4), new Number(-17));
        long result = factor.calculate();
        Assert.assertEquals(1, result);
    }


    @Test
    public void calculateTest8(){
        Relation factor = new Relation(Relation.Opcode.greater, new Number(9), new Number(9));
        long result = factor.calculate();
        Assert.assertEquals(0, result);
    }
}
