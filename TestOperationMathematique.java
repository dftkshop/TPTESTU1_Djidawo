
import static jdk.internal.lang.stable.StableUtil.array;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TestOperationMathematique {
    OperationMathematique op = new OperationMathematique();
    @Test
    void testEstPositif() {
        assertTrue(op.estPositif(5));
        assertFalse(op.estPositif(-3));
    }
    @Test
    void testFactoriel() {
        assertEquals(120, op.factoriel(5));
        assertEquals(1, op.factoriel(0));
    }
    @Test
    void testTrier(){
        Integer[] liste = {1,2,4,57,4,1,5};
        assertArrayEquals(liste, op.trier(liste));

    }
    @Test
    void testMax(){
        double[] liste = {1,2,4,57,4,1,5};
        assertArrayEquals(liste, new double[]{op.maxNumba(liste)});

    }



}
