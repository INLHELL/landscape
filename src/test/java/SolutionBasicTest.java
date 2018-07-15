import org.junit.jupiter.api.Test;
import test.Solution;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.Solution.*;

class SolutionBasicTest {

    @Test
    void zero_height_hill() {
        assertEquals(0, calculateWaterAmount(new int[]{MIN_HILL_HEIGHT}));
    }

    @Test
    void three_squares_with_zero_height_hill() {
        assertEquals(0, calculateWaterAmount(new int[]{MIN_HILL_HEIGHT, MIN_HILL_HEIGHT, MIN_HILL_HEIGHT}));
    }

    @Test
    void one_height_hill() {
        assertEquals(0, calculateWaterAmount(new int[]{1}));
    }

    @Test
    void three_squares_with_one_height_hill() {
        assertEquals(0, calculateWaterAmount(new int[]{1, 1, 1}));
    }

    @Test
    void column_of_max_hill_size() {
        assertEquals(0, calculateWaterAmount(new int[]{MAX_HILL_HEIGHT}));
    }

    @Test
    void three_squares_with_max_hill_size() {
        assertEquals(0, calculateWaterAmount(new int[]{MAX_HILL_HEIGHT, MAX_HILL_HEIGHT, MAX_HILL_HEIGHT}));
    }

    @Test
    void from_one_to_max_height_hill() {
        assertEquals(0, calculateWaterAmount(IntStream.rangeClosed(1, MAX_HILL_HEIGHT).toArray()));
    }

    @Test
    void max_height_hill_minus_one_decreases_to_zero() {
        assertEquals(0, calculateWaterAmount(IntStream.iterate(MAX_HILL_HEIGHT - 1, i -> i - 1).limit(MAX_LANDSCAPE_SIZE).toArray()));
    }

    @Test
    void max_height_hill_decreases_to_one() {
        assertEquals(0, calculateWaterAmount(IntStream.iterate(MAX_HILL_HEIGHT, i -> i - 1).limit(MAX_LANDSCAPE_SIZE).toArray()));
    }

    @Test
    void half_max_height_hill_at_start_decrease_to_one_at_the_middle_and_increase_to_half_max_height_hill() {
        int n = MAX_HILL_HEIGHT / 2 - 1;
        IntStream decStream = IntStream.iterate(n, i -> i - 1).limit(MAX_HILL_HEIGHT / 2);
        IntStream incStream = IntStream.range(1, MAX_HILL_HEIGHT / 2);
        int expectedWaterAmount = n * n;
        assertEquals(expectedWaterAmount, calculateWaterAmount(IntStream.concat(decStream, incStream).toArray()));
    }

    @Test
    void giant_hill_of_max_size() {
        assertEquals(0, calculateWaterAmount(IntStream.generate(() -> MAX_HILL_HEIGHT).limit(MAX_LANDSCAPE_SIZE).toArray()));
    }

    @Test
    void flat_plateau_of_max_size() {
        assertEquals(0, calculateWaterAmount(IntStream.generate(() -> MIN_HILL_HEIGHT).limit(MAX_LANDSCAPE_SIZE).toArray()));
    }

    @Test
    void one_max_height_hill_at_start_and_one_max_height_hill_at_the_end() {
        int[] landscape = IntStream.generate(() -> MIN_HILL_HEIGHT).limit(MAX_LANDSCAPE_SIZE).toArray();
        landscape[0] = MAX_HILL_HEIGHT;
        landscape[landscape.length - 1] = MAX_HILL_HEIGHT;
        int expectedWaterAmount = (MAX_HILL_HEIGHT - 2) * MAX_HILL_HEIGHT;
        assertEquals(expectedWaterAmount, calculateWaterAmount(landscape));
    }

    @Test
    void two_max_height_hills_with_single_gap_in_between() {
        int[] landscape = IntStream.generate(() -> MIN_HILL_HEIGHT).limit(MAX_LANDSCAPE_SIZE).toArray();
        landscape[landscape.length / 2 + 1] = MAX_HILL_HEIGHT;
        landscape[landscape.length / 2 - 1] = MAX_HILL_HEIGHT;
        assertEquals(MAX_HILL_HEIGHT, calculateWaterAmount(landscape));
    }

    @Test
    void four_max_height_hills_with_one_square_gaps() {
        int[] landscape = IntStream.generate(() -> MIN_HILL_HEIGHT).limit(MAX_LANDSCAPE_SIZE).toArray();
        landscape[landscape.length / 2 - 3] = MAX_HILL_HEIGHT;
        landscape[landscape.length / 2 - 1] = MAX_HILL_HEIGHT;
        landscape[landscape.length / 2 + 2] = MAX_HILL_HEIGHT;
        landscape[landscape.length / 2 + 3] = MAX_HILL_HEIGHT;
        assertEquals(MAX_HILL_HEIGHT * 3, calculateWaterAmount(landscape));
    }
}