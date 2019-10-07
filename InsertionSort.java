public class InsertionSort {
    
    //instance variable used to count the number of times line 17 is being executed
    private int count;
    
    //empty constructor used to initialize the InsertionSort class
    public InsertionSort(){
        
    }
    
    //method used to sort array by the given sorting class
    public int[] sortArray(int[] arr, int size) {
        for (int j = 1; j < size; j++){
            int key = arr[j];
            int i = j-1;
            while(i > -1 && arr[i] > key){
                count++;
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }
        return arr;
    }
    
    //getter function for count
    public int getCount(){
        return count;
    }
    
}
