package Sorting;
//https://www.java-tips.org/java-se-tips-100019/24-java-lang/1896-quick-sort-implementation-with-median-of-three-partitioning-and-cutoff-for-small-arrays.html
//	http://www.cs.fsu.edu/~breno/COP-4530/slides/21-anim.pdf
public class QuickSortMedianof3PivotHybrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] s = new Integer[] { 8,5, 1,4,9,9,6,5,2,7,0, 0,3};
		
		 quicksort(s);
		 for (Integer i : s) {
			System.out.print(i+" ");
		}
	}
	/**
     * Quicksort algorithm.
     * @param a an array of Comparable items.
     */
    public static Comparable[] quicksort( Comparable [ ] a ) {
        quickSortHybrid( a, 0, a.length - 1 );
        return a;
    }
     
    private static final int CUTOFF = 10;
     
    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * @param a an array of Comparable items.
     * @param low the left-most index of the subarray.
     * @param high the right-most index of the subarray.
     */
    private static void quickSortHybrid( Comparable [ ] a, int low, int high ) {
        if( low + CUTOFF > high )
            insertionSort( a, low, high );
        else {
            // Sort low, middle, high
            int middle = ( low + high ) / 2;
//            int middle = ( left + right ) >>> 1; 
            
            if( a[ middle ].compareTo( a[ low ] ) < 0 )
                swapReferences( a, low, middle );
            if( a[ high ].compareTo( a[ low ] ) < 0 )
                swapReferences( a, low, high );
            if( a[ high ].compareTo( a[ middle ] ) < 0 )
                swapReferences( a, middle, high );
             
            // Place pivot at position high - 1. Because a[high] is already >= a[middle] so It's already in correct position.
            swapReferences( a, middle, high - 1 );
            Comparable pivot = a[ high - 1 ];
             
            // Begin partitioning
            int i, j;
            for( i = low, j = high - 1; ; ) {

                while( a[ ++i ].compareTo( pivot ) < 0 ) //here ++i means already a[lower]<=pivot at begining
                    ;
                while( pivot.compareTo( a[ --j ] ) < 0 ) //here --j means no need to check pivot<=pivot at begining 
                    ;
                if( i >= j )
                    break;
                swapReferences( a, i, j );
            }
             
            // Restore pivot
            swapReferences( a, i, high - 1 );
         // Recursion
            quickSortHybrid( a, low, i - 1 );    // Sort small elements
            quickSortHybrid( a, i + 1, high );   // Sort large elements
            
//            // Recursion
//            if (low < j)
//            	 quickSortHybrid( a, low, j );
//            if (i < high)
//            	quickSortHybrid( a, i+1, high );
            
        }
    }
     
    /**
     * Method to swap to elements in an array.
     * @param a an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static final void swapReferences( Object [ ] a, int index1, int index2 ) {
        Object tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }
     
     
    /**
     * Internal insertion sort routine for subarrays
     * that is used by quicksort.
     * @param a an array of Comparable items.
     * @param low the left-most index of the subarray.
     * @param n the number of items to sort.
     */
    private static void insertionSort( Comparable [ ] a, int low, int high ) {
        for( int p = low + 1; p <= high; p++ ) {
            Comparable tmp = a[ p ];
            int j;
             
            for( j = p; j > low && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }
}
