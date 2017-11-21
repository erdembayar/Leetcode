package Misc;

import java.util.Arrays;

//https://stackoverflow.com/questions/32260445/implementing-binary-search-on-an-array-of-strings
public class binaryStringSearchForString {

	   public static void main(String[] args) {

	        String array[] ={"EWRSFSFSFSB","BB","AA","SDFSFJ","WRTG","FF","ERF","FED","TGH"};
	        String search = "BBC";

	        Arrays.sort(array);

	        int searchIndex = binarySearch(array,search);

	        System.out.println(searchIndex != -1 ? array[searchIndex]+ " - Index is "+searchIndex : "Not found");
	    }

	    public static int binarySearch(String[] a, String x) {
	        int low = 0;
	        int high = a.length - 1;
	        int mid;

	        while (low <= high) {
	            mid = (low + high) / 2;

	            if (a[mid].compareTo(x) < 0) {
	                low = mid + 1;
	            } else if (a[mid].compareTo(x) > 0) {
	                high = mid - 1;
	            } else {
	                return mid;
	            }
	        }

	        return -1;
	    }

}
