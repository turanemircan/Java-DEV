import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Practice04Test {

    Practice05 mockPractice=mock(Practice05.class);
    Practice04 practice=new Practice04(mockPractice);
    @Test
    public void testIfNumberCanBeDividedBy6WithDivisibleNumber(){
        int divisibleNumber=6;
        when(mockPractice.findRemainderDividedBy2(divisibleNumber)).thenReturn(0);
        when(mockPractice.findRemainderDividedBy3(divisibleNumber)).thenReturn(0);

        assertTrue(practice.ifNumberCanBeDividedBy6(divisibleNumber));
    }

    @Test
    public void testIfNumberCanBeDividedBy6WitNonDivisibleNumber(){
        int divisibleNumber=5;
        when(mockPractice.findRemainderDividedBy2(divisibleNumber)).thenReturn(1);
        when(mockPractice.findRemainderDividedBy3(divisibleNumber)).thenReturn(2);
        assertFalse(practice.ifNumberCanBeDividedBy6(divisibleNumber));
    }



}
