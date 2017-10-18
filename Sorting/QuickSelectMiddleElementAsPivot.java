package Sorting;

import java.util.Random;

//https://github.com/mpollmeier/Selection-Algorithms/blob/master/src/main/java/com/michaelpollmeier/selection/QuickSelect.java

public class QuickSelectMiddleElementAsPivot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {11,3,3,3,4,3,6,1,3,3,3};

        System.out.println( "1st lowest = " + select( input, 0 ) );
        System.out.println( "2nd lowest = " + select( input, 1 ) );
        System.out.println( "3rd lowest = " + select( input, 2 ) );
	}
    /** Helper method for select( int[ ], int, int, int ) */
    public static int select( int[ ] array, int k ) {
        return select( array, 0, array.length - 1, k );
    }
 
    /** 
     * Returns the value of the kth lowest element. 
     * Do note that for nth lowest element, k = n - 1.
     */
    private static int select( int[ ] array, int left, int right, int k ) {
 
        while( true ) {
 
            if( right <= left + 1 ) { 
 
                if( right == left + 1 && array[ right ] < array[ left ] ) {
                    swap( array, left, right );
                }
 
                return array[ k ];
 
            } else {
 
                int middle = ( left + right ) >>> 1; 
            
				//   about >>>         https://stackoverflow.com/questions/19058859/what-does-mean-in-java
				//   int middle = ( low + high ) / 2; It can overflow
            
                swap( array, middle, left + 1 );
 
                if( array[ left ] > array[ right ] ) {
                    swap( array, left, right );
                }
 
                if( array[ left + 1 ] > array[ right ] ) {
                    swap( array, left + 1, right );
                }
 
                if( array[ left ] > array[ left + 1 ] ) {
                    swap( array, left, left + 1 );
                }
 
                int i = left + 1;
                int j = right;
                int pivot = array[ left + 1 ];
 
                while( true ) { 
                    do i++; while( array[ i ] < pivot ); 
                    do j--; while( array[ j ] > pivot ); 
 
                    if( j < i ) {
                        break; 
                    }
 
                    swap( array, i, j );
                } 
 
                array[ left + 1 ] = array[ j ];
                array[ j ] = pivot;
 
                if( j >= k ) {
                    right = j - 1;
                }
 
                if( j <= k ) {
                    left = i;
                }
            }
        }
    }
 
    /** Helper method for swapping array entries */
    private static void swap( int[ ] array, int a, int b ) {
        int temp = array[ a ];
        array[ a ] = array[ b ];
        array[ b ] = temp;
    }

}