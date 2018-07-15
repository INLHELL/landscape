import org.junit.jupiter.api.Test;
import test.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.Solution.calculateWaterAmount;

class SolutionAdvancedTest {

    private Solution s = new Solution();

    @Test
    void example_from_test() {
        assertEquals(9, calculateWaterAmount(new int[]{5, 2, 3, 4, 5, 4, 0, 3, 1}));
    }

    @Test
    void first_random() {
        assertEquals(6, calculateWaterAmount(new int[]{0, 2, 0, 3, 2, 0, 4, 1, 0}));
    }

    @Test
    void second_random() {
        assertEquals(15, calculateWaterAmount(new int[]{3, 2, 4, 1, 1, 2, 1, 1, 4, 0}));
    }

    @Test
    void fourth_random() {
        assertEquals(4, calculateWaterAmount(new int[]{0, 2, 1, 2, 0, 2, 1, 2, 0, 0}));
    }

    @Test
    void fifth_random() {
        assertEquals(10, calculateWaterAmount(new int[]{4, 3, 2, 5, 4, 3, 2, 4, 5, 6}));
    }

    @Test
    void seventh_random() {
        assertEquals(25, calculateWaterAmount(new int[]{5, 1, 3, 2, 0, 3, 0, 4, 2, 5}));
    }

    @Test
    void eighth_random() {
        assertEquals(19, calculateWaterAmount(new int[]{2, 4, 2, 0, 3, 2, 5, 0, 0, 5}));
    }

    @Test
    void ninth_random() {
        assertEquals(14, calculateWaterAmount(new int[]{5, 3, 7, 2, 6, 4, 5, 9, 1, 2}));
    }

    @Test
    void pyramid() {
        assertEquals(6, calculateWaterAmount(new int[]{0, 1, 0, 2, 0, 3, 0, 2, 0, 1, 0}));
    }

    @Test
    void trident() {
        assertEquals(24, calculateWaterAmount(new int[]{0, 3, 0, 2, 0, 1, 0, 4, 0, 1, 0, 2, 0, 3, 0}));
    }
}