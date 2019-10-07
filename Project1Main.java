import java.io.File;
import java.util.Scanner;

public class Project1Main {
    public static void main (String[] args){
        for(int i  = 0; i < args.length; i++){
            String fname = args[i];
            int size = countSize(fname);
            int[] unsortedArr = getUnsortedArray(fname, size);//unsorted array used for sorting
            System.out.println(fname + " before sorting:");
            printArray(unsortedArr,size);
            System.out.println();
            
            InsertionSort is = new InsertionSort();
            int[] sortedArr = is.sortArray(unsortedArr, size);
            System.out.println(fname + " after insertion sort:");
            printArray(sortedArr,size);
            System.out.println("count = "+ is.getCount() + "\n");
            
            unsortedArr = getUnsortedArray(fname, size);//reassign the unsorted array for the next sort
            MergeSort ms = new MergeSort();
            sortedArr = ms.sortArray(unsortedArr, 0, size-1);
            System.out.println(fname + " after merge sort:");
            printArray(sortedArr,size);
            System.out.println("count = "+ ms.getCount() + "\n");
            
            unsortedArr = getUnsortedArray(fname, size);//reassign the unsorted array for the next sort
            HeapSort hs = new HeapSort();
            sortedArr = hs.sortArray(unsortedArr, size);
            System.out.println(fname + " after heap sort:");
            printArray(sortedArr,size);
            System.out.println("count = "+ hs.getCount() + "\n");
            
            unsortedArr = getUnsortedArray(fname, size);//reassign the unsorted array for the next sort
            QuickSort qs = new QuickSort();
            unsortedArr = getUnsortedArray(fname, size+1);//add 1 extra space to the array to prevent overflow errors
            sortedArr = qs.sortArray(unsortedArr, 0, size-1);
            System.out.println(fname + " after quick sort:");
            printArray(sortedArr,size);
            System.out.println("count = "+ qs.getCount() + "\n");
        }
    }
    
    //method for printing array
    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    //counts the number of elements in the file
    public static int countSize(String fname) {
        int size = 0;
        Scanner sc = null;
        String tmps;
        int elem;
        
        try {
            sc = new Scanner(new File(fname));
            while (sc.hasNext()) {
                tmps = sc.next();
                elem = Integer.parseInt(tmps);
                size++;
            }
            sc.close();
            
        } catch (Exception e) {
            e.printStackTrace();;
        }
        
        return size;
    }
    
    //puts all the elements in the text file into an array
    public static int[] getUnsortedArray(String fname, int size) {
        // TODO Auto-generated method stub
        int[] arr = new int[size];
        Scanner sc = null;
        String tmps;
        int elem;
        
        try {
            sc = new Scanner(new File(fname));
            int idx = 0;
            while (sc.hasNext()) {
                tmps = sc.next();
                elem = Integer.parseInt(tmps);
                arr[idx] = elem;
                idx++;
            }
            sc.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return arr;
    }
}

