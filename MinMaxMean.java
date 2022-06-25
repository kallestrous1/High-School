import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MinMaxMean {
	private double minimum=0;
	private double maximum=0;
	private double mean=0;
	private double totalFileValue=0;
	private int numberOfNumbers=0;
	
	
	public Object readFile(String string) {
		File inputFile = new File(string);
		Scanner in=null;
		
		try {
			in= new Scanner(inputFile);
			try {
				while(in.hasNextLine()) {			
					double currentValue=Double.parseDouble(in.nextLine());
					if(currentValue<minimum||numberOfNumbers==0) {
						minimum=currentValue;
						}
					if(currentValue>maximum||numberOfNumbers==0) {
						maximum=currentValue;
					}			
					totalFileValue=totalFileValue+currentValue;
					numberOfNumbers++;
				}
				if(numberOfNumbers==0) {
					mean=0;
				}
				else {
				mean=(totalFileValue/numberOfNumbers);  
				}
			}			
			catch(IllegalArgumentException e) {
				System.out.printf("Object number %d is not a number",numberOfNumbers+1);
				numberOfNumbers=0;maximum=0;minimum=0;mean=0;
				return false;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return false;
		}
		finally {
			if(in!=null) {
				in.close();
			}
		}
	return true;
	}

	public double getMinimum() {
		return minimum;
	}

	public double getMaximum() {
		return maximum;
	}

	public double getMean() {
		return mean;
	}

	public Object getNumberOfValues() {
		return numberOfNumbers;
	}

}


