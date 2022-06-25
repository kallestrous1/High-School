public class RecursiveSearcher {
	
	
	public int doBinarySearch(IntegerArray arrayToSort, int i) {	
		int low=0;
		int high = arrayToSort.length()-1;	
		return doBinarySearch(arrayToSort, i, high, low);
	}
	
	private int doBinarySearch(IntegerArray arrayToSort, int i, int high, int low) {
		
		if (low>high) {
			return -1;
		}
		
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
			return doBinarySearch(arrayToSort, i, mid-1, low);
		}
		else if (i>currentRead) {
			return doBinarySearch(arrayToSort, i, high, mid+1);
		}
		
	return -1;	
}
}

