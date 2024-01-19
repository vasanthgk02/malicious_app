package com.badlogic.gdx.utils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.LifecycleListener;

public class Timer {
    public static TimerThread thread;
    public static final Object threadLock = new Object();
    public final Array<Task> tasks = new Array<>(false, 8);

    public static abstract class Task implements Runnable {
        public final Application app;
        public long executeTimeMillis;
        public long intervalMillis;
        public int repeatCount;
        public volatile Timer timer;

        public Task() {
            Application application = k.app;
            this.app = application;
            if (application == null) {
                throw new IllegalStateException("Gdx.app not available.");
            }
        }

        public void cancel() {
            Timer timer2 = this.timer;
            if (timer2 != null) {
                synchronized (timer2) {
                    synchronized (this) {
                        this.executeTimeMillis = 0;
                        this.timer = null;
                        timer2.tasks.removeValue(this, true);
                    }
                }
                return;
            }
            synchronized (this) {
                this.executeTimeMillis = 0;
                this.timer = null;
            }
        }
    }

    public static class TimerThread implements Runnable, LifecycleListener {
        public final Application app;
        public final Files files = k.files;
        public Timer instance;
        public final Array<Timer> instances = new Array<>(true, 1);
        public long pauseTimeMillis;

        public TimerThread() {
            Application application = k.app;
            this.app = application;
            application.addLifecycleListener(this);
            resume();
            Thread thread = new Thread(this, "Timer");
            thread.setDaemon(true);
            thread.start();
        }

        public void dispose() {
            synchronized (Timer.threadLock) {
                if (Timer.thread == this) {
                    Timer.thread = null;
                }
                this.instances.clear();
                Timer.threadLock.notifyAll();
            }
            this.app.removeLifecycleListener(this);
        }

        public void pause() {
            synchronized (Timer.threadLock) {
                this.pauseTimeMillis = System.nanoTime() / 1000000;
                Timer.threadLock.notifyAll();
            }
        }

        public void resume() {
            synchronized (Timer.threadLock) {
                long nanoTime = (System.nanoTime() / 1000000) - this.pauseTimeMillis;
                int i = this.instances.size;
                for (int i2 = 0; i2 < i; i2++) {
                    ((Timer) this.instances.get(i2)).delay(nanoTime);
                }
                this.pauseTimeMillis = 0;
                Timer.threadLock.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:23|(2:25|26)|27) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0072 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r10 = this;
            L_0x0000:
                java.lang.Object r0 = com.badlogic.gdx.utils.Timer.threadLock
                monitor-enter(r0)
                com.badlogic.gdx.utils.Timer$TimerThread r1 = com.badlogic.gdx.utils.Timer.thread     // Catch:{ all -> 0x007b }
                if (r1 != r10) goto L_0x0076
                com.badlogic.gdx.Files r1 = r10.files     // Catch:{ all -> 0x007b }
                com.badlogic.gdx.Files r2 = co.hyperverge.hypersnapsdk.c.k.files     // Catch:{ all -> 0x007b }
                if (r1 == r2) goto L_0x000e
                goto L_0x0076
            L_0x000e:
                r1 = 5000(0x1388, double:2.4703E-320)
                long r3 = r10.pauseTimeMillis     // Catch:{ all -> 0x007b }
                r5 = 0
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 != 0) goto L_0x005e
                long r3 = java.lang.System.nanoTime()     // Catch:{ all -> 0x007b }
                r7 = 1000000(0xf4240, double:4.940656E-318)
                long r3 = r3 / r7
                r7 = 0
                com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.Timer> r8 = r10.instances     // Catch:{ all -> 0x007b }
                int r8 = r8.size     // Catch:{ all -> 0x007b }
            L_0x0025:
                if (r7 >= r8) goto L_0x005e
                com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.Timer> r9 = r10.instances     // Catch:{ all -> 0x0036 }
                java.lang.Object r9 = r9.get(r7)     // Catch:{ all -> 0x0036 }
                com.badlogic.gdx.utils.Timer r9 = (com.badlogic.gdx.utils.Timer) r9     // Catch:{ all -> 0x0036 }
                long r1 = r9.update(r3, r1)     // Catch:{ all -> 0x0036 }
                int r7 = r7 + 1
                goto L_0x0025
            L_0x0036:
                r1 = move-exception
                com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x007b }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007b }
                r3.<init>()     // Catch:{ all -> 0x007b }
                java.lang.String r4 = "Task failed: "
                r3.append(r4)     // Catch:{ all -> 0x007b }
                com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.Timer> r4 = r10.instances     // Catch:{ all -> 0x007b }
                java.lang.Object r4 = r4.get(r7)     // Catch:{ all -> 0x007b }
                com.badlogic.gdx.utils.Timer r4 = (com.badlogic.gdx.utils.Timer) r4     // Catch:{ all -> 0x007b }
                java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x007b }
                java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x007b }
                r3.append(r4)     // Catch:{ all -> 0x007b }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x007b }
                r2.<init>(r3, r1)     // Catch:{ all -> 0x007b }
                throw r2     // Catch:{ all -> 0x007b }
            L_0x005e:
                com.badlogic.gdx.utils.Timer$TimerThread r3 = com.badlogic.gdx.utils.Timer.thread     // Catch:{ all -> 0x007b }
                if (r3 != r10) goto L_0x0074
                com.badlogic.gdx.Files r3 = r10.files     // Catch:{ all -> 0x007b }
                com.badlogic.gdx.Files r4 = co.hyperverge.hypersnapsdk.c.k.files     // Catch:{ all -> 0x007b }
                if (r3 == r4) goto L_0x0069
                goto L_0x0074
            L_0x0069:
                int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                if (r3 <= 0) goto L_0x0072
                java.lang.Object r3 = com.badlogic.gdx.utils.Timer.threadLock     // Catch:{ InterruptedException -> 0x0072 }
                r3.wait(r1)     // Catch:{ InterruptedException -> 0x0072 }
            L_0x0072:
                monitor-exit(r0)     // Catch:{ all -> 0x007b }
                goto L_0x0000
            L_0x0074:
                monitor-exit(r0)     // Catch:{ all -> 0x007b }
                goto L_0x0077
            L_0x0076:
                monitor-exit(r0)     // Catch:{ all -> 0x007b }
            L_0x0077:
                r10.dispose()
                return
            L_0x007b:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x007b }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.Timer.TimerThread.run():void");
        }
    }

    public Timer() {
        synchronized (threadLock) {
            Array<Timer> array = thread().instances;
            if (!array.contains(this, true)) {
                array.add(this);
                threadLock.notifyAll();
            }
        }
    }

    public static Task schedule(Task task, float f2) {
        Timer timer;
        synchronized (threadLock) {
            TimerThread thread2 = thread();
            if (thread2.instance == null) {
                thread2.instance = new Timer();
            }
            timer = thread2.instance;
        }
        if (timer != null) {
            synchronized (threadLock) {
                synchronized (timer) {
                    synchronized (task) {
                        if (task.timer == null) {
                            task.timer = timer;
                            long nanoTime = System.nanoTime() / 1000000;
                            long j = ((long) (f2 * 1000.0f)) + nanoTime;
                            if (thread.pauseTimeMillis > 0) {
                                j -= nanoTime - thread.pauseTimeMillis;
                            }
                            task.executeTimeMillis = j;
                            task.intervalMillis = (long) 0.0f;
                            task.repeatCount = 0;
                            timer.tasks.add(task);
                        } else {
                            throw new IllegalArgumentException("The same task may not be scheduled twice.");
                        }
                    }
                }
                threadLock.notifyAll();
            }
            return task;
        }
        throw null;
    }

    public static TimerThread thread() {
        TimerThread timerThread;
        synchronized (threadLock) {
            if (thread == null || thread.files != k.files) {
                if (thread != null) {
                    thread.dispose();
                }
                thread = new TimerThread();
            }
            timerThread = thread;
        }
        return timerThread;
    }

    public synchronized void delay(long j) {
        int i = this.tasks.size;
        for (int i2 = 0; i2 < i; i2++) {
            Task task = (Task) this.tasks.get(i2);
            synchronized (task) {
                task.executeTimeMillis += j;
            }
        }
    }

    public synchronized long update(long j, long j2) {
        int i = 0;
        int i2 = this.tasks.size;
        while (i < i2) {
            Task task = (Task) this.tasks.get(i);
            synchronized (task) {
                if (task.executeTimeMillis > j) {
                    j2 = Math.min(j2, task.executeTimeMillis - j);
                } else {
                    if (task.repeatCount == 0) {
                        task.timer = null;
                        this.tasks.removeIndex(i);
                        i--;
                        i2--;
                    } else {
                        task.executeTimeMillis = task.intervalMillis + j;
                        j2 = Math.min(j2, task.intervalMillis);
                        if (task.repeatCount > 0) {
                            task.repeatCount--;
                        }
                    }
                    task.app.postRunnable(task);
                }
            }
            i++;
        }
        return j2;
    }
}
