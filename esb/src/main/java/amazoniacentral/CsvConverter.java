package amazoniacentral;
import net.sf.flatpack.DefaultDataSet;
import net.sf.flatpack.DefaultParserFactory;
import net.sf.flatpack.Parser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CsvConverter {

	 private static char delimiter = ',';
	 private static char qualifier = '"';
	 private static boolean ignoreFirstRecord = true;

	 public CsvConverter() {
	
	 }

	 public String convert(String csv)  {
		 StringReader sr = new StringReader(csv);
		 FileReader fr = null;
	  
	  //Get the configuration file for csv processing
	  try {
	   fr = new FileReader("usermap.xml");
	  } catch (FileNotFoundException e) {   
	   e.printStackTrace();
	  }
	  
	  //The csv parser
	  Parser p = DefaultParserFactory.getInstance().newDelimitedParser(fr, sr,delimiter, qualifier, ignoreFirstRecord);
	
	  DefaultDataSet d = (DefaultDataSet) p.parse();
	
	  //Build the xml
	  DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
	        DocumentBuilder build;
	        Document doc=null;
	  try {
	   build = dFact.newDocumentBuilder();
	  
	        doc = build.newDocument();
	  } catch (ParserConfigurationException e) {
	   
	   e.printStackTrace();
	  }
	        Element root = doc.createElement("root");
	        doc.appendChild(root);
	        
	        Element Details = doc.createElement("rows");
	        root.appendChild(Details);
	 
	  
	  while (d.next()) {
	   
	    String[] colums = d.getColumns();
	    for(int i=0; i<colums.length;i++ ){
	     Element name = doc.createElement(colums[i]);
	              name.appendChild(doc.createTextNode(d.getString(colums[i])));
	              Details.appendChild(name);
	    }
	 
	  }
	  TransformerFactory tf = TransformerFactory.newInstance();
	  Transformer transformer=null;
	  StringWriter writer = null;
	  
	  try {
	   transformer = tf.newTransformer();
	   writer = new StringWriter();
	   transformer.transform(new DOMSource(doc), new StreamResult(writer));
	  } catch (TransformerConfigurationException e) {
	   
	   e.printStackTrace();
	  } catch (TransformerException e) {
	
	   e.printStackTrace();
	  }
	  
	  
	  String output = writer.getBuffer().toString();
	  
	  return output;
	  
	 }
}