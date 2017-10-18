package Sorting;

public class MergeSorting {

	static int[] arr = {7,2,9,4};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = arr.length;
		
		int[] temp = new int[n];
		mergeSort(temp,0,n-1 );
		
		for(int i:arr){
			System.out.printf("%d ", i);
		}
	}

	public static void mergeSort(int[] temp, int lowerPointer, int upperPointer){
		if(lowerPointer == upperPointer){
			return;
		}
		
		int mid = (lowerPointer+upperPointer)/2;
		
		mergeSort(temp, lowerPointer,mid);
		mergeSort(temp,mid+1,upperPointer);
		merge(temp,lowerPointer, mid+1, upperPointer);
	}
	
	public static void merge(int[] temp, int lowerPointer, int pointer, int upperPointer){
		
		int mid = pointer-1;
		int size = upperPointer-lowerPointer+1;
		int i=0;
		int lowerBound = lowerPointer;
		while(lowerPointer<=mid && pointer<=upperPointer){
			if(arr[lowerPointer]<=arr[pointer])
			{
				temp[i++]=arr[lowerPointer++];

			}
			else
			{
				temp[i++]=arr[pointer++];
			
			}

		}
		
		while(lowerPointer<=mid){
			temp[i++]=arr[lowerPointer++];
	
		}
		
		while(pointer<=upperPointer){
			temp[i++]=arr[pointer++];
		
		}
			
		for(int j=0;j<size;j++)
		{
			arr[lowerBound+j]= temp[j];
		}
	}
}
