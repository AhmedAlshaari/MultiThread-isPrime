import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.io.File; 
import java.io.FileWriter;  

class isPrime {

  final static int n = 100000000;
  public static boolean prime [] = new boolean [n + 1];

  public static class MultiThread extends Thread
  {
    private static AtomicInteger primes = new AtomicInteger(0);
    private static AtomicLong sum = new AtomicLong(0);
    private static int[] maxArr = new int[10];
    private int start;
    private int end;

    public MultiThread(int start, int end) 
    {
      this.start = start;
      this.end = end;
    }

    public long getNumPrimes()
    {
      return primes.longValue();
    }

    public int[] getMaxArr()
    {
      return maxArr;
    }

    public long getSum()
    {
      return sum.longValue();
    }

    @Override
    public void run()
    {
      for(int i = this.start; i <= this.end; i++)
      {
        if(prime[i])
        {
          primes.getAndIncrement();
          sum.addAndGet(i);
          if (i > maxArr[0])
          {
            maxArr[0] = i;
            Arrays.sort(maxArr);
          }
        }
      }

    }

  }
  public static void main(String[] args) {
    long start = System.nanoTime();
    Arrays.fill(prime, true);
    for(int p = 2; p * p <= n; p++)
    {
      if(prime[p])
      {
        for(int i = p * p; i <= n; i += p)
          prime[i] = false;
      }
    }

    MultiThread t1 = new MultiThread(0, 12500000);
    MultiThread t2 = new MultiThread(12500000, 25000000);
    MultiThread t3 = new MultiThread(25000000, 37500000);
    MultiThread t4 = new MultiThread(37500000, 50000000);
    MultiThread t5 = new MultiThread(50000000, 62500000);
    MultiThread t6 = new MultiThread(62500000, 75000000);
    MultiThread t7 = new MultiThread(75000000, 87500000);
    MultiThread t8 = new MultiThread(87500000, 100000000);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();
    t7.start();
    t8.start();

    try
    {
      t1.join();
      t2.join();
      t3.join();
      t4.join();
      t5.join();
      t6.join();
      t7.join();
      t8.join();
    }
    catch (Exception e)
    {      
    }

    long end = System.nanoTime();
    double executionTime = ((double)(end - start) / (double)1000000000);
    long numPrimes = t1.getNumPrimes();
    long sum = t1.getSum();
    int[] max = t1.getMaxArr();

    File myObj = new File("primes.txt");

    try
    {    
      FileWriter fw=new FileWriter("primes.txt");    
      fw.write(executionTime + " " + (numPrimes-2) + " " + (sum-1));  
      for (int i = 0; i < 10; i++)
      {
        String s = String.valueOf(max[i]);
        fw.write("\n");
        fw.write(s);
      }  
      fw.close();    
    }
    catch(Exception e)
    {
      System.out.println(e);
    }    
  }


}