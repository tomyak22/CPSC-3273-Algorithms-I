import java.util.Random;
import java.util.Arrays;

/**
 * The objective of this programming assignment is to implement in Java the InsertSort, QuickSort, and MergeSort
 * algorithms presented in the lectures to sort a list of numbers. We are interested in comparing the three algorithms. For
 * this exploration, you will collect the execution time T(n) as a function of n and plot on the same graph the execution
 * times T(n) of the three algorithms. Finally, discuss your results
 * @author Tom Fenyak
 * CPSC 3273
 */

public class ComparingTimeComplexities {

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
      
      System.out.println("MergeSort Times");
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
      System.out.println();
      System.out.println("QuickSort Times");
      
      // Run QuickSort for Arrays and print out RunTimes
      for (n = 10; n < 1000000; n+= step) {
         int A[] = new int[n];
         System.arraycopy(G, 0, A, 0, n);
      
         long startQuick = System.currentTimeMillis();
         quickSort(A, 0, A.length - 1);
         long finishQuick = System.currentTimeMillis();
         long totalQuick = finishQuick - startQuick;
         System.out.print("T(n) = " + totalQuick + " ");
      }
      
      System.out.println();
      System.out.println("InsertSort Times");
     
     // Run InsertSort for Arrays and print out RunTimes 
      for (n = 10; n < 100010; n+= step) {
         int A[] = new int[n];
         System.arraycopy(G, 0, A, 0, n);
      
         long startInsert = System.currentTimeMillis();
         insertSort(A);
         long finishInsert = System.currentTimeMillis();
         long totalInsert = finishInsert - startInsert;
         System.out.print("T(n) = " + totalInsert + " ");
      }
         
   }
   
   // Complete insertSort from Algorithm in appendix
   public static void insertSort(int[] A) {
   
      for (int j = 2; j < A.length; j++) {
         int key = A[j];
      // insert A[j] into the sorted sequence
         int i = j - 1;
         while (i > 0 && A[i] > key) {
            A[i + 1] = A [i];
            i = i - 1;
         }
         A[i +1] = key;
      }
   
   }
   
   // Complete quickSort from Algorithm in appendix
   public static void quickSort(int[] A, int p, int r) {
   
      if (p < r) {
         int q = partition(A, p, r);
         quickSort(A, p, q - 1);
         quickSort(A, q + 1, r);
      }
   }
   
   // Completes partition portion for the quickSort Algorithm
   public static int partition(int[] A, int p, int r) {
      int x = A[r];
      int i = p - 1;
   
      for (int j = p; j < r; j++) {
         if (A[j] <= x) {
            i = i + 1; 
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
         }
      }
   
      int temp = A[i + 1];
      A[i + 1] = A[r];
      A[r] = temp;
   
      return i + 1; 
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
   
   // Completes merge from mergeSort Algorithm
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