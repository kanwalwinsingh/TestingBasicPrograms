import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


class OuterClass
{
    private int i;   //private field of OuterClass
 
    int j;           //Default field of OuterClass
 
    protected int k; //protected field of OuterClass
 
    public int m;    //public field of OuterClass
 
    void methodOfOuterClass()
    {
        InnerClass inner = new InnerClass(); //creating instance of InnerClass
 
        System.out.println(inner.a);  //accessing private field of InnerClass
 
        System.out.println(inner.b);  //accessing default field of InnerClass
 
        System.out.println(inner.c);  //accessing protected field of InnerClass
 
        System.out.println(inner.d);  //accessing public field of InnerClass
    }
 
    class InnerClass
    {
        private int a;    //private field of InnerClass
 
        int b;            //Default field of InnerClass
 
        protected int c;  //protected field of InnerClass
 
        public int d;     //public field of InnerClass
 
        void methodOfInnerClass()
        {
            OuterClass outer = new OuterClass(); //creating an instance of OuterClass
 
            System.out.println(outer.i);    //accessing private field of OuterClass
 
            System.out.println(outer.j);    //accessing default field of OuterClass
 
            System.out.println(outer.k);    //accessing protected field of OuterClass
 
            System.out.println(outer.m);    //accessing public field of OuterClass
        }
    }
}
 
public class FinalExample 
{    
    public static void main(String[] args)
    {
        		
        		ThreadPoolExecutor p = new ThreadPoolExecutor(10, 10,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>());
        		
        		int i = 0;
        		for( i = 0; i < 100; i++)
        		{
        			p.execute(new sss());
        		}
        		
    }
}
	


 


