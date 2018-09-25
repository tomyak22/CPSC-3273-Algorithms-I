import java.util.Random;
import java.util.Arrays;



public class MergeSortTimeComplexity {

   public static void main(String[] args) {
   
      Random random = new Random();
      // create our "large" array G
      int G[] = new int [1000000];
      
      int i = 0;
      // fill array G with random integers from 1 - 10000
      while (i < 1000000) {
         int randomInteger = random.nextInt(100000) + 1;
         G[i++] = randomInteger;
      }
      
      int n = 10;
      int step = 1000;
      int buffer;
      
      /** 
       * We are going to start array A at size 10 and increment by
       * 1000 until we surpass the size of array G
       */
      for (n = 10; n < 1000000; n+= step) {
         int A[] = new int [n];
         // copies n integers from array G to array A starting at index 0
         System.arraycopy(G, 0, A, 0, n);
      
         long start = System.currentTimeMillis();
      
         mergeSort(A, 0, A.length - 1);
      
         long finish = System.currentTimeMillis();
         long total = finish - start;
         System.out.print("T(n) = " + total + " ");
      
      }
         
   }
   
   // Complete mergeSort from Algorithm in appendix
   public static void mergeSort(int[] A, int p, int r) {
   
      if (p < r) {
         int q = (p + r) / 2;
         mergeSort(A, p, q);
         mergeSort(A, q + 1, r);
         merge(A, p, q, r);
      }
   
   }
   
   public static void merge(int[] A, int p, int q, int r) {
   
      int n1 = q - p + 1;
      int n2 = r - q;
   
      int[] L = new int[n1 + 1];
      int[] R = new int[n2 + 1];
   
      for (int i = 0; i < n1; i++) {
         L[i] = A[p + i];
      }
   
      for (int j = 0; j < n2; j++) {
         R[j] = A[q + 1 + j];
      }
   
      L[n1] = 2147483647;
      R[n2] = 2147483647;
   
      int i = 0;
      int j = 0;
   
      for (int k = p; k <= r; k++) {
         if (L[i] <= R[j]) {
            A[k] = L[i];
            i = i + 1;
         }
         
         else {
            A[k] = R[j];
            j = j + 1;
         }
      }
   
   }
    
      
}