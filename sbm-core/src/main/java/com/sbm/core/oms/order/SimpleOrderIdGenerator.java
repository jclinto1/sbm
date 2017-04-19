package com.sbm.core.oms.order;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Simple ID generator using an incrementing number.  Other options here
 * are to use system/nano time or some other sequence.
 */
public class SimpleOrderIdGenerator implements OrderIdGenerator {

    private final AtomicLong counter = new AtomicLong(0);

    @Override
    public long generate() {
        return this.counter.incrementAndGet();
    }
}
