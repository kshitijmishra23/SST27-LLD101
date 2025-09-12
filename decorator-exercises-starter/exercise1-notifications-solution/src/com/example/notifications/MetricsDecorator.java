package com.example.notifications;

/** Cross-cutting decorator to measure latency of notify(). */
public class MetricsDecorator extends NotifierDecorator {
    public MetricsDecorator(Notifier inner) { super(inner); }
    @Override public void notify(String text) {
        long t0 = System.nanoTime();
        try { super.notify(text); }
        finally {
            long ms = (System.nanoTime() - t0) / 1_000_000;
            System.out.println("[METRICS] notify latency = " + ms + " ms");
        }
    }
}
