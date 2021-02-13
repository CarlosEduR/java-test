package br.com.sysmanager;

import br.com.sysmanager.composition.TrainComposition;
import org.junit.jupiter.api.*;

public class TrainCompositionTest {

    private static TrainComposition trainComposition;

    @BeforeAll
    static void testAddTrainCarriage() {
        trainComposition = new TrainComposition();
        trainComposition.addTrainCarriage(1, trainComposition.LEFT_SIDE);
        trainComposition.addTrainCarriage(3, trainComposition.RIGHT_SIDE);
        trainComposition.addTrainCarriage(4, trainComposition.RIGHT_SIDE);

        Assertions.assertEquals(3, trainComposition.train.trainCarriages.size());
    }

    @Test
    public void testShowAllRemovalPossibilities() {
        RemovalPossibilities removalPossibilities = trainComposition.listAllPossibilities();
        Assertions.assertEquals(1, removalPossibilities.getLeftPossibility().get(0));
        Assertions.assertEquals(4, removalPossibilities.getRightPossibility().get(0));
    }

    @Test
    public void testListAllVagoes() {
        int vagoesQuantity = trainComposition.listAllTrainCarriages().size();
        Assertions.assertEquals(3, vagoesQuantity);
    }

    @AfterAll
    static void testRemoveAllVagoes() {
        trainComposition.removeAllTrainCarriages();
        Assertions.assertEquals(0, trainComposition.train.trainCarriages.size());
    }

    @AfterAll
    static void testPresetTrainCarriages() {
        trainComposition.removeAllTrainCarriages();
        trainComposition.initializeFiveRandomTrainCarriage();
        Assertions.assertEquals(5, trainComposition.train.trainCarriages.size());
    }

}
