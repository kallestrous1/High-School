public class RecursiveSorter {
	
	public void doQuickSort(IntegerArray clone) {
		int low = 0;
		int high = clone.length()-1;
		doQuickSort(clone, low, high);
	}
	private void doQuickSort(IntegerArray clone, int low, int high) {
		if(low<high) {
		int pivotPoint = partition(clone,low, high);	
		doQuickSort(clone,low, pivotPoint -1);
		doQuickSort(clone,pivotPoint+1, high);		
		}
	}
	
	private static int partition(IntegerArray clone, int low, int high) {
		int pivot=clone.read(high);
		int i = low-1;
		for (int j=low; j<=high-1; j++) {
			if(clone.read(j)<pivot) {
				i++;
				int temp = clone.read(i);
				clone.write(i, clone.read(j));
				clone.write(j, temp);
			}
		}
		int temp = clone.read(i+1);
		clone.write(i+1, clone.read(high));
		clone.write(high, temp);
		return i+1;
	}


	
	public void doMergeSort(IntegerArray array) {
		
		int high=array.length();
		int mid=array.length()/2;
		
		if(high<2) {
			return;
		}
		
		IntegerArray leftArray=new IntegerArray(new int[mid],false);
		IntegerArray rightArray=  new IntegerArray(new int[high-mid], false);
		
		for(int i =0; i<mid; i++) {
			leftArray.write(i, array.read(i));
		}
		
		for(int i =0; i<rightArray.length(); i++) {
			rightArray.write(i, array.read(mid+i));
		}
		
		doMergeSort(leftArray);
		doMergeSort(rightArray);		
		merge(array, leftArray, rightArray);
				
	}
	
	private void merge(IntegerArray array, IntegerArray leftArray, IntegerArray rightArray) {	
			
		int leftIndex=0, rightIndex=0, finalIndex=0;
		
		while(leftIndex<leftArray.length()&&rightIndex<rightArray.length()) {
			if(leftArray.read(leftIndex)<=rightArray.read(rightIndex)) {
				array.write(finalIndex, leftArray.read(leftIndex));
				finalIndex++;
				leftIndex++;
				}
			else {
				array.write(finalIndex, rightArray.read(rightIndex));
				finalIndex++;
				rightIndex++;
			}			
		}
		
		while(leftIndex<leftArray.length()) {
			array.write(finalIndex, leftArray.read(leftIndex));
			finalIndex++;
			leftIndex++;
			}
		while(rightIndex<rightArray.length()) {
			array.write(finalIndex, rightArray.read(rightIndex));
			finalIndex++;
			rightIndex++;
		}
		
	}
}


