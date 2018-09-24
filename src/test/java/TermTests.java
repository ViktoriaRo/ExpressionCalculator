import org.junit.Assert;
import org.junit.Test;

public class TermTests {

    @Test
    public void calculateTest1(){
        Term term = new Term(Term.OpCode.plus, new Number(0), new Number(5));
        long result = term.calculate();
        Assert.assertEquals(5, result);
    }

    @Test
    public void calculateTest2(){
        Term term = new Term(Term.OpCode.plus, new Number(-4), new Number(4));
        long result = term.calculate();
        Assert.assertEquals(0, result);
    }

    @Test
    public void calculateTest3(){
        Term term = new Term(Term.OpCode.plus, new Number(-4), new Number(10));
        long result = term.calculate();
        Assert.assertEquals(6, result);
    }

    @Test
    public void calculateTest4(){
        Term term = new Term(Term.OpCode.plus, new Number(-4), new Number(-3));
        long result = term.calculate();
        Assert.assertEquals(-7, result);
    }

    @Test
    public void calculateTest5(){
        Term term = new Term(Term.OpCode.plus, new Number(4), new Number(-20));
        long result = term.calculate();
        Assert.assertEquals(-16, result);
    }

    @Test
    public void calculateTest6(){
        Term term = new Term(Term.OpCode.minus, new Number(2), new Number(2));
        long result = term.calculate();
        Assert.assertEquals(0, result);
    }

    @Test
    public void calculateTest7(){
        Term term = new Term(Term.OpCode.minus, new Number(-4), new Number(10));
        long result = term.calculate();
        Assert.assertEquals(-14, result);
    }

    @Test
    public void calculateTest8(){
        Term term = new Term(Term.OpCode.minus, new Number(-4), new Number(-10));
        long result = term.calculate();
        Assert.assertEquals(6, result);
    }

    @Test
    public void calculateTest9(){
        Term term = new Term(Term.OpCode.minus, new Number(0), new Number(3));
        long result = term.calculate();
        Assert.assertEquals(-3, result);
    }

    @Test
    public void calculateTest10(){
        Term term = new Term(Term.OpCode.minus, new Number(5), new Number(10));
        long result = term.calculate();
        Assert.assertEquals(-5, result);
    }

}
