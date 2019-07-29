package com.github.oahnus.datastructure.Sort;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by oahnus on 2019/7/29
 * 20:38.
 */
public class DataUtil {
    private static Random random = new Random();

    public static int[] genRandomDataArr(int n) {
        return IntStream.generate(() -> random.nextInt(n) + 1)
                .distinct()
                .limit(n)
                .toArray();
    }
}
