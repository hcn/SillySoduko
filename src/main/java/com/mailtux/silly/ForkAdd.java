package com.mailtux.silly;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkAdd extends RecursiveTask<Long> {

    public static final long threshold = 10_000;
    private final long[] numbers;
    private final int start;
    private final int end;

    public ForkAdd(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkAdd(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    public static long startForkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkAdd(numbers);
        return new ForkJoinPool().invoke(task);
    }

    @Override
    protected Long compute() {

        int length = end - start;
        if (length <= threshold) {
            return add();
        }

        ForkAdd firstTask = new ForkAdd(numbers, start, start + length / 2);
        firstTask.fork(); //start asynchronously

        ForkAdd secondTask = new ForkAdd(numbers, start + length / 2, end);

        Long secondTaskResult = secondTask.compute();
        Long firstTaskResult = firstTask.join();

        return firstTaskResult + secondTaskResult;

    }

    private long add() {
        long result = 0;
        for (int i = start; i < end; i++) {
            result += numbers[i];
        }
        return result;
    }

}

