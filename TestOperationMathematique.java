
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



}
