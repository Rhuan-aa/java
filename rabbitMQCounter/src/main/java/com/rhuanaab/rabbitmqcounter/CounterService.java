package com.rhuanaab.rabbitmqcounter;

import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CounterService {

    private final AtomicInteger counter = new AtomicInteger(0);

    public int increment() {
        return counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }
}
