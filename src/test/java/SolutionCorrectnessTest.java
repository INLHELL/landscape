import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.Solution.*;

class SolutionCorrectnessTest {

    @Test
    void empty_landscape() {
        assertEquals(0, calculateWaterAmount(new int[]{}));
    }

    @Test
    void negative_number() {
        assertEquals(0, calculateWaterAmount(new int[]{MIN_HILL_HEIGHT, 1, -1}));
    }

    @Test
    void hill_height_exceeds_max_height() {
        assertEquals(0, calculateWaterAmount(new int[]{MIN_HILL_HEIGHT, MAX_LANDSCAPE_SIZE + 1, 1}));
    }

    @Test
    void landscape_exceeds_max_size() {
        assertEquals(0, calculateWaterAmount(IntStream.rangeClosed(MIN_HILL_HEIGHT, MAX_HILL_HEIGHT).toArray()));
    }
}