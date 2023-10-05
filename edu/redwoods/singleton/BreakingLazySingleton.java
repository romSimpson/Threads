package edu.redwoods.singleton;

import java.util.stream.IntStream;

public class BreakingLazySingleton implements Runnable {
    private String type;

    public BreakingLazySingleton(String type) {
        this.type = type;
    }

    @Override
    public void run() {
        switch(type) {
            case "lazy" -> System.out.println(LazyInitializedSingleton.getInstance().hashCode());
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, 10).forEach( (a) -> {
            new Thread(new BreakingLazySingleton("lazy"), "Thread"+a).start();
        });
    }
}