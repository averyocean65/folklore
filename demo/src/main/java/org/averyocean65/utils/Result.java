package org.averyocean65.utils;

public class Result<T> {
    public Result(boolean success, T value) {
        this.success = success;
        this.value = value;
    }

    public boolean success;
    public T value;

    public static Result<Integer> safeParseInt(String s) {
        try {
            return new Result<>(true, Integer.parseInt(s));
        } catch(Exception e) {
            return new Result<>(false, null);
        }
    }
}