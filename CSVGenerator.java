import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CSVGenerator {
	FileWriter writer;
		
	public void open(String outputFromCsv, boolean append) throws IOException {		
			writer=new FileWriter(outputFromCsv,true);				
	}
	
	public void add(StudentRecord studentRecord) throws IOException {
			writer.append(studentRecord.getStudentID());	
			writer.write(",");
			writer.write(String.valueOf(studentRecord.getBirthYear()));
			writer.write(",");
			writer.write(String.valueOf(studentRecord.getBirthMonth()));
			writer.write(",");
			writer.write(String.valueOf(studentRecord.getBirthDay()));
			writer.write(",");
			writer.write(studentRecord.getLastName());
			writer.write(",");
			writer.write(studentRecord.getFirstName());
			writer.write(",");
			writer.write(studentRecord.getGender());
			writer.append("\r\n");
		}
		
	public void importFromCSV(String importFromCsv) throws IOException {
		Scanner scanner = new Scanner(Paths.get(importFromCsv).toFile());
		scanner.useDelimiter(",");
		while(scanner.hasNextLine()) {
			String newData=scanner.nextLine().replace("\"", "");
			writer.append(newData);
			writer.append("\r\n");
		}
		scanner.close();
	}
	
	public void importFromTXT(String importFromTxt) throws IOException {
		Scanner scanner = new Scanner(Paths.get(importFromTxt).toFile());
		
		while(scanner.hasNextLine()) {
			String newData=scanner.nextLine().trim().replaceAll("\\s+",",");
			writer.append(newData);
			writer.append("\r\n");
		}
		scanner.close();
	}

	public void importFromXML(String importFromXml) throws IOException {
		File xmlDoc = new File(importFromXml);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=null;;
        Document document=null;
        try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {}
        try {
			document = builder.parse(xmlDoc);
		} catch (SAXException | IOException e) {}
        
        NodeList mainList = document.getElementsByTagName("Student");          
        
        for(int i=0; i<mainList.getLength();i++) {
        	Element idk = (Element) mainList.item(i);
        	String gender="";
        	String studentID=idk.getElementsByTagName("StudentID").item(0).getTextContent()+",";
        	String birthYear=idk.getElementsByTagName("BirthYear").item(0).getTextContent()+",";
        	String birthMonth=document.getElementsByTagName("BirthMonth").item(i).getTextContent()+",";
        	String birthDay=document.getElementsByTagName("BirthDay").item(i).getTextContent()+",";
        	String lastName=document.getElementsByTagName("LastName").item(i).getTextContent()+",";
        	String firstName=document.getElementsByTagName("FirstName").item(i).getTextContent()+",";
        	if(((Element) idk).getElementsByTagName("Gender").item(0)!=null) {
        	gender=idk.getElementsByTagName("Gender").item(0).getTextContent();
        	}
        	String csvString = studentID+birthYear+birthMonth+birthDay+lastName+firstName+gender;
        	writer.append(csvString);
			writer.append("\r\n");

        }
	}


	public void importFromJSON(String importFromJson) throws IOException {
		Scanner scanner = new Scanner(Paths.get(importFromJson).toFile());
        String studentID="";
        String birthYear="";
        String birthMonth="";
        String birthDay="";
        String lastName="";
        String firstName="";
        String gender="";
        String resultOne="oops";
        String resultTwo="oops";
        String resultThree="oops";
        int index =0;
        while(scanner.hasNextLine()) {
        	index++;
			String newData=scanner.nextLine().trim();		
			
        	if((index>2&&index<10)) {
			String subStrings[]=newData.split("\\: ");	
			String dataType = subStrings[0].replaceAll("[^A-Za-z]+", "").replaceAll("[\r\n]", "");
			if(dataType.contains("StudentID")) {
				 studentID=(subStrings[1].replaceAll("\"", ""));
			}
			else if(dataType.contains("BirthYear")) {
				 birthYear=(subStrings[1].replaceAll("\"", ""));
			}
			else if(dataType.contains("BirthMonth")) {
				 birthMonth=(subStrings[1].replaceAll("\"", ""));
			}
			else if(dataType.contains("BirthDay")) {
				 birthDay=(subStrings[1].replaceAll("\"", ""));
			}
			else if(dataType.contains("LastName")) {
				 lastName=(subStrings[1].replaceAll("\"", ""));
			}
			else if(dataType.contains("FirstName")) {
				 firstName=(subStrings[1].replaceAll("\"", ""));
			}
			else if(dataType.contains("Gender")) {
				 gender=(subStrings[1].replaceAll("\"", ""));
			}
			resultOne=studentID+birthYear+birthMonth+birthDay+lastName+firstName+gender+"\r\n";
        }
        	if((index>11&&index<19)) {
    			String subStrings[]=newData.split("\\: ");	
    			String dataType = subStrings[0].replaceAll("[^A-Za-z]+", "").replaceAll("[\r\n]", "");
    			if(dataType.contains("StudentID")) {
    				 studentID=(subStrings[1].replaceAll("\"", ""));
    			}
    			else if(dataType.contains("BirthYear")) {
    				 birthYear=(subStrings[1].replaceAll("\"", ""));
    			}
    			else if(dataType.contains("BirthMonth")) {
    				 birthMonth=(subStrings[1].replaceAll("\"", ""));
    			}
    			else if(dataType.contains("BirthDay")) {
    				 birthDay=(subStrings[1].replaceAll("\"", ""));
    			}
    			else if(dataType.contains("LastName")) {
    				 lastName=(subStrings[1].replaceAll("\"", ""));
    			}
    			else if(dataType.contains("FirstName")) {
    				 firstName=(subStrings[1].replaceAll("\"", ""));
    			}
    			else if(dataType.contains("Gender")) {
    				 gender=(subStrings[1].replaceAll("\"", ""));
    			}
    			resultTwo=studentID+birthYear+birthMonth+birthDay+lastName+firstName+gender+"\r\n";
            }
        	if((index>20&&index<27)) {
    			String subStrings[]=newData.split("\\: ");	
    			String dataType = subStrings[0].replaceAll("[^A-Za-z]+", "").replaceAll("[\r\n]", "");
    			if(dataType.contains("StudentID")) {
    				 studentID=(subStrings[1].replaceAll("\"", ""));
    			}
    			else if(dataType.contains("BirthYear")) {
    				 birthYear=(subStrings[1].replaceAll("\"", ""));
    			}
    			else if(dataType.contains("BirthMonth")) {
    				 birthMonth=(subStrings[1].replaceAll("\"", ""));
    			}
    			else if(dataType.contains("BirthDay")) {
    				 birthDay=(subStrings[1].replaceAll("\"", ""));
    			}
    			else if(dataType.contains("LastName")) {
    				 lastName=(subStrings[1].replaceAll("\"", ""));
    			}
    			else if(dataType.contains("FirstName")) {
    				 firstName=(subStrings[1].replaceAll("\"", ""));
    			}
    			else if(dataType.contains("Gender")) {
    				 gender=(subStrings[1].replaceAll("\"", ""));
    			}
    			resultThree=studentID+birthYear+birthMonth+birthDay+lastName+firstName+gender+"\r\n";
            }
        
        }
        writer.append(resultOne);
        writer.append(resultTwo);
        writer.append(resultThree);
}
	
	public void close() throws IOException {
		writer.close();
	}
	
}
