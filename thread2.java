package socketprogrammingudp;

public class thread2 extends Thread 
{
   private Thread t;
   private String threadName;
   thread2( String name)
   {
       threadName = name;
       //System.out.println("Creating " +  threadName );
   }
   public void run() {
    //  System.out.println("Running " +  threadName );
      try {
          
         while(true) {
           // System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
     } catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
     }
     //System.out.println("Thread " +  threadName + " exiting.");
   }
   
   public void start ()
   {
     // System.out.println("Starting " +  threadName );
      if (t == null)
      {
         t = new Thread (this, threadName);
         t.start ();
      }
   }

}
/*public class thread2 {
   public static void main(String args[]) {
   
      ThreadDemo T1 = new ThreadDemo( "Thread-1");
      T1.start();
      
      ThreadDemo T2 = new ThreadDemo( "Thread-2");
      T2.start();
   }   
}*/