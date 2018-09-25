import java.util.Random;
import java.util.Arrays;


/**
 * A Program designed to design and implement a naive sorting program presented
 * in the lecture to sort a list of numbers. We are interested in exploring the
 * relationship between the time complexity and the "real time". For this 
 * exploration, you will collect the execution time T(n) as a function of n and
 * plot T(n)/n^2.
 *
 * @author Tom Fenyak.
 * @version August 25 2018.
 */
 
public class TimeComplexityFunction {
 
   public static void main(String[] args) {
      
      Random random = new Random();
      // create our "large" array G
      int G[] = new int [100000];
      
      int i = 0;
      // fill array G with random integers from 1 - 10000
      while (i < 100000) {
         int randomInteger = random.nextInt(10000) + 1;
         G[i++] = randomInteger;
      }
      
      int n = 10;
      int step = 1000;
      int buffer;
      
      /** 
       * We are going to start array A at size 10 and increment by
       * 1000 until we surpass the size of array G
       */
      for (n = 10; n < 100000; n+= step) {
         int A[] = new int [n];
         // copies n integers from array G to array A starting at index 0
         System.arraycopy(G, 0, A, 0, n);
      
         // Tracks the start time of the sort
         long start = System.currentTimeMillis();
         for (int j = 1; j < n-1; j++) {
            for (int t = j + 1; t < n; t++) {
               if (A[t] < A[j]) {
               //swap A[i] and A[j]
                  buffer = A[j];
                  A[j] = A[t];
                  A[t] = buffer;
               }
            }
         }
         // Tracks the end time of the sort
         long finish = System.currentTimeMillis();
         long total = finish - start;
         System.out.print("T(n) = " + total + " ");
      }
      
   }
   
   
 
 
}