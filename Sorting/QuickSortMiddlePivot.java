package Sorting;

public class QuickSortMiddlePivot {

	public static void quickSort(int[] arr, int low, int high){
		if(low>=high)
			return;
		Result pivot = partition(arr,low,high);
		
		if(low<pivot.val2)
			quickSort(arr, low,pivot.val2);
		if(high>pivot.val1)
			quickSort(arr, pivot.val1,high);
		
	}
	
	public static Result partition(int[] arr, int low, int high){
		
		int pivot = arr[low+(high-low)/2];
		while(low<=high)
		{
			
			while(arr[low] < pivot)
				low++;

			while(arr[high] > pivot)
				high--;
			
			if(low<=high){  //If there is no equal sign then it can't break outer while loop if all elements equal
				swap(arr, low,high);
				low++;
				high--;
			}
		}
		
		return (new Result(low, high));
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        int arr[] = {10, 7, 8, 9, 1, 5,1};
//		int[] arr = { 10, 10, 7, 8, 9, 1, 5, 18, 1 };
		
		int[] arr = { 10, 10,9, 7, 8, 9, 1, 5, 18, 1,9 };
		int length = arr.length;
		
		quickSort(arr,0, length-1);
		
        System.out.println("sorted array");
        printArray(arr);
        
	}
	
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static final void swap( int [ ] a, int index1, int index2 ) {
        int tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }
}
