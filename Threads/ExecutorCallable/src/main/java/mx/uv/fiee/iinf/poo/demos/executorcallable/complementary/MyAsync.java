package mx.uv.fiee.iinf.poo.demos.executorcallable.complementary;

import mx.uv.fiee.iinf.poo.demos.executorcallable.interfaces.TaskDone;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyAsync extends FutureTask<String> {
    private TaskDone listener;

    public MyAsync (Callable<String> callable) {
        super (callable);
    }

    public void setTaskDoneListener (TaskDone listener) {
        this.listener = listener;
    }

    @Override
    protected void done () {
        super.done ();
        listener.finish ();
    }

}