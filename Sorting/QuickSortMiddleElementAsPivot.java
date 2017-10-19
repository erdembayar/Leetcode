package Sorting;
//http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
public class QuickSortMiddleElementAsPivot {
    private int[] numbers;
    private int number;

    public void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
//        int pivot = numbers[low + (high-low)/2];
        int pivot = numbers[(high+low)/2]; //ingevel Integer.Integer.MAX_VALUE-aas davbal overflow bolno.
//        int middle = ( left + right ) >>> 1; 
        
        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            
            if (i <= j) {  // If there is no equal sign then it turn to infinite loop if all items are equal.
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    
    public  static void main(String[] args)
    {
//        int arr[] = {10, 7, 8, 9, 1, 5,1};
    	int[] arr = { 10, 10, 7, 8, 9, 1, 5, 18, 1 };
//        int arr[] = {6, 3, 1, 2, 5};
        int n = arr.length;
 
        QuickSortMiddleElementAsPivot ob = new QuickSortMiddleElementAsPivot();
        ob.sort(arr);
 
        System.out.println("sorted array");
        printArray(arr);
    }
    
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
 
     
}
