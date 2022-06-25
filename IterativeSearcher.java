import java.lang.reflect.Array;

public class IterativeSearcher {
	
	
	public int doBinarySearch(IntegerArray arrayToSort, int i) {
		
		int low=0;
		int high = arrayToSort.length()-1;
		
		while (low<=high) {
			
			int mid=low+(high-low)/2;
			int currentRead=arrayToSort.read(mid);
			
			if(i==currentRead) {
				try {
				while(arrayToSort.read(mid-1)==i) {
					mid--;
				}	
				
				return mid;
				}
				
				catch(IndexOutOfBoundsException e) {
					return mid;
				}
			}
			
			else if(i<currentRead) {
				high=mid-1;
			}
			else {
				low = mid+1;
			}
		}
		
		return -1;
}
}
