
public class HeapSort {
    private int count; //instance variable used to count the number of times line 40 is being executed
    private int heap_size;
    
    //empty constructor used to initialize the InsertionSort class
    public HeapSort(){
        
    }
    
    //method used to sort array by the given sorting class
    public int[] sortArray(int[] arr, int size) {
        buildMaxHeap(arr,size);
        for(int i = size-1; i >= 1; i--){
            swap(arr,0,i);
            heap_size--;
            maxHeapify(arr,0);
        }
        return arr;
    }
    
    //max heapify method for heap sort
    private void maxHeapify(int[] arr, int i) {
        int left = 2*i+1;
        int right = 2*i+2;
        int largest;
        if (left < heap_size && arr[left] > arr[i]){
            largest = left;
        }
        else{
            largest = i;
        }
        
        if (right < heap_size && arr[right] > arr[largest]){
            largest = right;
        }
        
        if (largest != i){
            swap(arr, i, largest);
            count++;
            maxHeapify(arr, largest);
        }
    }
    
    //build max heap method for heap sort
    private void buildMaxHeap(int[] arr, int size) {
        heap_size = size;
        for(int i = Math.floorDiv(size-1,2);i >=0; i--)
            maxHeapify(arr,i);
    }
    
    //swaps elements in an array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    //getter function for count
    public int getCount(){
        return count;
    }
}
