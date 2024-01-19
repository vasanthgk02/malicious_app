package io.hansel.core.base.task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class HSLTaskHandler {
    public a exService;
    public BlockingQueue<Runnable> queue = new LinkedBlockingQueue();

    public HSLTaskHandler() {
        a aVar = new a(1, 1, 0, TimeUnit.MILLISECONDS, this.queue);
        this.exService = aVar;
    }

    public void clear() {
        this.queue.clear();
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public boolean isPaused() {
        return this.exService.a();
    }

    public void pause() {
        this.exService.b();
    }

    public void resume() {
        this.exService.c();
    }

    public void schedule(Runnable runnable) {
        this.exService.execute(runnable);
    }
}
