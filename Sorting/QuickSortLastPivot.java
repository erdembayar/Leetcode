package Sorting;

public class QuickSortLastPivot {

	public static void quickSort(int[] arr, int low, int high){
		if(low>=high){
			return;
		}
		
		int pivot = partition(arr, low, high);
		quickSort(arr, low,pivot-1);
		quickSort(arr, pivot+1, high);
		
	}
	
	static int partition(int[] arr, int low, int high){
		int pivot = arr[high];
		int i = low-1;
		
		for (int j = low; j < high; j++) {
			if(arr[j]<pivot){
				i++;
				swap(arr,i,j);
			}
		}
		
		swap(arr, ++i, high);
		
		return i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 10, 7, 8, 9, 1, 5, 18, 1 };
//		int[] arr = { 1, 1, 2, 2, 5, 6, 7, 8 };
//		int[] arr = { 1, 1, 1, 1, 1, 1 };
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
