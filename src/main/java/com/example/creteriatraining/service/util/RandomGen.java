package com.example.creteriatraining.service.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGen {

    public static int randomGen(int from, int toIncluding) {
        return ThreadLocalRandom.current().nextInt(from, toIncluding + 1);
    }
}
