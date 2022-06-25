public class IterativeSorter {
	
	public void doBubbleSort(IntegerArray arrayToSort) {
		for(int i=0; i<arrayToSort.length()-1;i++) {
			for (int j=0; j<arrayToSort.length()-i-1;j++) {				
				int currentValue=arrayToSort.read(j), nextValue=arrayToSort.read(j+1);																
				if (currentValue>nextValue) {
					arrayToSort.write(j+1, currentValue);
					arrayToSort.write(j, nextValue);
				}
			}
		}
	}

	public void doSelectionSort(IntegerArray arrayToSort) {
		for(int i=0; i<arrayToSort.length()-1;i++) {
			
			int lowestValueIndex=i;
			int lowestValue=arrayToSort.read(lowestValueIndex);
			int currentValue=0;
			
			for (int j=i+1; j<arrayToSort.length();j++) {
				currentValue=arrayToSort.read(j);
				if (currentValue<lowestValue) {
					lowestValueIndex=j;
					lowestValue=currentValue;
				}
			}
			int tempValue=arrayToSort.read(i);
			arrayToSort.write(i, lowestValue);
			arrayToSort.write(lowestValueIndex, tempValue);
		}
		
	}

	public void doInsertionSort(IntegerArray arrayToSort) {
		for(int i=1; i<arrayToSort.length();i++) {
			int currentValue= arrayToSort.read(i);
			int j=i-1;
			while(j>=0 && arrayToSort.read(j)>currentValue) {
				arrayToSort.write(j+1, arrayToSort.read(j));
				j--;
			}
			arrayToSort.write(j+1, currentValue);
		}
	}

}
