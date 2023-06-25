package at.pavlov.cannons.utils;

public abstract class DelayedTask<T> implements Runnable {

    private final T wrapper;

    public DelayedTask(T wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public final void run() {
        run(wrapper);
    }

    public abstract void run(T wrapper2);

}
