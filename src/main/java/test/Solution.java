package test;

import java.util.stream.IntStream;

public class Solution {
    public static final int MAX_LANDSCAPE_SIZE = 32_000;
    public static final int MAX_HILL_HEIGHT = 32_000;
    public static final int MIN_HILL_HEIGHT = 0;

    public static long calculateWaterAmount(int[] landscape) {
        if (landscape.length < 2 || landscape.length > MAX_LANDSCAPE_SIZE) return 0;
        if (IntStream.of(landscape).anyMatch(i -> 0 > i || i > MAX_LANDSCAPE_SIZE)) return 0;

        int totalWaterAmount = 0;
        int currentWaterAmount = 0;

        int highestHillIndex = 0;
        int highestHillHeight = 0;

        int indexOfLastNonZeroHeightHill = -1;

        for (int i = 0; i < landscape.length; i++) {
            if (landscape[i] >= highestHillHeight) { // found  right border of the lowland
                totalWaterAmount += currentWaterAmount; // update total amount of water
                currentWaterAmount = 0;

                highestHillHeight = landscape[i]; // found hill height might be higher then the left border hill
                highestHillIndex = i; // update heist hill location index

                indexOfLastNonZeroHeightHill = -1; // reset index
            } else if (landscape[i] < highestHillHeight) {
                currentWaterAmount += highestHillHeight - landscape[i]; // collecting water
                if (landscape[i] != 0)
                    indexOfLastNonZeroHeightHill = i; // track index of last non zero height hill
            }
        }

        currentWaterAmount = 0; // reset collected water

        // handle the case when there is now right border at the en of the land scape
        // @see pyramid or trident tests
        if (indexOfLastNonZeroHeightHill != -1) { // begin from first non zero element on the right
            highestHillHeight = landscape[indexOfLastNonZeroHeightHill]; // this hill will be the highest from the right side

            for (int i = indexOfLastNonZeroHeightHill; i >= highestHillIndex; i--) { // move from the right until highest hill
                if (landscape[i] >= highestHillHeight) {
                    totalWaterAmount += currentWaterAmount;
                    currentWaterAmount = 0;

                    highestHillHeight = landscape[i];
                } else if (landscape[i] < highestHillHeight) {
                    currentWaterAmount += highestHillHeight - landscape[i];

                }
            }

        }

        return totalWaterAmount;
    }
}
