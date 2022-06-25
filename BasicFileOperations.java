import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

	public class BasicFileOperations {

		public String readFile(String inputForRead) {
			String output="";
			Scanner in=null;
			try {
				File inputFile = new File(inputForRead);		
				in= new Scanner(inputFile);
				while(in.hasNextLine()) {
					String value=in.nextLine();
					output=output+value;
				}
			}
				 catch (FileNotFoundException e) {
			}
			finally {
				if(in!=null) {
					in.close();		
				}
				}			
			return output;
		}

		public String readFileWithCRLF(String inputForRead) {
			File inputFile = new File(inputForRead);		
			String output="";
			Scanner inputReader=null;
			try {
				inputReader= new Scanner(inputFile);
				while(inputReader.hasNext()) {				
					String value=inputReader.nextLine();
					output=output+value+"\r\n";				
				}
			} catch (FileNotFoundException e) {
			}
			finally {
				if(inputReader!=null) {
					inputReader.close();		
				}
			}
			return output;
		}

		public void writeFile(String outputFromWrite, String[] dataToWrite) {
			PrintWriter out=null;
			try {
				out = new PrintWriter(new FileWriter("output/output-from-write.txt"));
				for(int i = 0; i<dataToWrite.length;i++) {
					if(i<dataToWrite.length-1) {
					out.println(dataToWrite[i]);
					}
					else {
						out.print(dataToWrite[i]);
					}
				}
			} catch (IOException e) {
			}
			finally {
				if(out!=null) {
				out.close();
				}
			}
		}

		public void appendFile(String outputFromAppend, String dataToAppend) {
			PrintWriter appendWriter=null;
				try {	
					appendWriter = new PrintWriter(new FileWriter("output/output-from-append.txt", true));
					appendWriter.println(dataToAppend);									
				} catch (IOException e) {
				}
				finally {
					if(appendWriter!=null) {
					appendWriter.close();
					}
				}
			
		}

	}






