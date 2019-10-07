public class MergeSort {
    //instance variable used to count the number of times line 42 is being executed
    private int count;
    
    //empty constructor used to initialize the MergeSort class
    public MergeSort(){
        
    }
    
    //method used to sort array by the given sorting class
    public int[] sortArray(int[] arr, int low, int high) {
        if (low < high){
            int mid = Math.floorDiv(low + high, 2);
            sortArray(arr,low, mid);
            sortArray(arr,mid+1,high);
            merge(arr,low, mid, high);
        }
        
        return arr;
        
    }
    
    //merge function for merge sort
    private void merge(int[] arr, int low, int mid, int high) {
        
        int n1 = mid-low+1;
        int n2 = (high-mid);
        int[] left = new int[n1+1];
        int[] right = new int[n2+1];
        for(int i = 0; i < n1; i++){
            left[i] = arr[low+i];
        }
        for(int j = 0; j < n2; j++){
            right[j] = arr[mid+j+1];
        }
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        
        int i = 0;
        int j = 0;
        for(int k = low; k < high+1; k++){
            count++;
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
        }
    }
    
    //getter function for count
    public int getCount(){
        return count;
    }
}
