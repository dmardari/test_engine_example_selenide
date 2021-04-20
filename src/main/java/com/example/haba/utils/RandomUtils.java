package com.example.haba.utils;

import java.util.List;

import static org.apache.commons.lang3.RandomUtils.nextInt;

public class RandomUtils {

    public static <T> T getRandomItem(List<T> list) {
        if (list.isEmpty())
            throw new RuntimeException("Unable to get random element from empty list");
        return list.get(nextInt(0, list.size()));
    }
}
