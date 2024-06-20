package jp.artan.dmlreloaded.util;

public class MathHelper {
    public static int ensureRange(int value, int min, int max) {
        return Math.min(Math.max(value, min), max);
    }

    public static boolean inRange(int value, int min, int max) {
        return (value>= min) && (value<= max);
    }
}

