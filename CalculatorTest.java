import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testCalculatePriority() {
        
        String testIzraz = "10+5*4+3";
        
        
        String stvarniRezultat = Calculator.Run(testIzraz);
        
       
        String ocekivaniRezultat = "33.0";
        
        
        assertEquals("Metoda Run nije ispravno izračunala prioritet računskih operacija!", 
                     ocekivaniRezultat, stvarniRezultat);
    }
}
