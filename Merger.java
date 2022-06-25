
public class Merger {

	public int[] doMerge(int[] arrayA, int[] arrayB) {
		
		int firstArrayLength;
		int secondArrayLength;
		
		if(arrayA != null) {
		 firstArrayLength = arrayA.length;
		}
		else {
		 firstArrayLength=0;
		}
		
		if(arrayB != null) {
			 secondArrayLength = arrayB.length;
			}
			else {
			 secondArrayLength=0;
			}
		
		int [] newArray = new int[firstArrayLength+secondArrayLength];
		
		int arrayAIterator=0, arrayBIterator=0,newArrayIterator=0;
		
		while(arrayAIterator<firstArrayLength && arrayBIterator<secondArrayLength) {
			if(arrayA[arrayAIterator]<arrayB[arrayBIterator]) {
				newArray[newArrayIterator++]= arrayA[arrayAIterator++];
			}
			else {
				newArray[newArrayIterator++]= arrayB[arrayBIterator++];
			}
		}
		while (arrayAIterator<firstArrayLength) {
			newArray[newArrayIterator++]= arrayA[arrayAIterator++];
		}
		while (arrayBIterator<secondArrayLength) {
			newArray[newArrayIterator++]= arrayB[arrayBIterator++];
		}
		return newArray;
	}

}
