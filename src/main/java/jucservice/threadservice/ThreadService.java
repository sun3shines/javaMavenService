package jucservice.threadservice;

class Setf implements  Runnable{

    public  ThreadService s;

    public void run() {

        while (true){
            s.a = s.a + 1;
            okay.Util.Util.Sleep(1);
        }
    }
}

class Getf implements  Runnable{
    public  static ThreadService s;

    public void run() {

        while (true){
            System.out.println(s.a);
            okay.Util.Util.Sleep((float)0.5);
        }
    }
}
public class ThreadService {

    public  int a=0;

    public static  void main(String[] args){
        System.out.println("Hello Juc");

        ThreadService ts = new ThreadService();

        Setf setf = new Setf();
        setf.s = ts;

        Getf getf = new Getf();
        getf.s = ts;

        Thread t1 = new Thread(getf);
        t1.setDaemon(true);
        t1.start();
        Thread t2 = new Thread(setf);
        t2.setDaemon(true);
        t2.start();

        while(true){
            okay.Util.Util.Sleep(1);
        }

    }
}
