package br.com.sysmanager;

import br.com.sysmanager.composition.CounterComposition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CounterCompositionTest {

    private static CounterComposition counterComposition;

    @BeforeAll
    static void initCounter(){
        counterComposition = new CounterComposition();
    }

    @Test
    public void testCountNumbers(){
        int[] arrayTest = { 10, 4, 5, 16, 20 };
        int lessThan = 10;

        Assertions.assertEquals(2,counterComposition.countNumbers(arrayTest, lessThan));
    }
}
