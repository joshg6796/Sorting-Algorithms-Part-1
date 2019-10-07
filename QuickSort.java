public class QuickSort {
    //instance variable used to count the number of times line 25 is being executed
    private int count;
    
    //empty constructor used to initialize the QuickSort class
    public QuickSort(){
        
    }
    
    //method used to sort array by the given sorting class
    public int[] sortArray(int[] arr, int low, int high) {
        if (low < high){
            int mid = partition(arr, low, high);
            sortArray(arr, low, mid-1);
            sortArray(arr, mid+1, high);
        }
        return arr;
    }
    
    //partition function for quick sort
    private int partition(int[] arr, int low, int high) {
        int x = arr[high];
        int i = low-1;
        for(int j = low; j <= high-1; j++){
            count++;
            if (arr[j] <= x){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
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
