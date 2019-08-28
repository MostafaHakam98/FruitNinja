package System;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileLoader {
	
	private static FileLoader instance;
	
	public static FileLoader getFileLoader() {
		if (instance == null)
			instance = new FileLoader();
		return instance;
	}
	
	private FileLoader() {
	}
	
	int highScoreBanana;
	int highScorePeach;
	int highScoreMelon;
	int highScoreArcade;
	
	public void saveGame() {
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
		    Document doc = dBuilder.newDocument();

		    Element rootElement = doc.createElement("FruitNinja");
            doc.appendChild(rootElement);
		    
        	Element BananaScore = doc.createElement("HighScoreBanana");
            rootElement.appendChild(BananaScore);
            
            Attr attrType = doc.createAttribute("score");
            attrType.setValue(Integer.toString(highScoreBanana));
            
            BananaScore.setAttributeNode(attrType);
            
            Element PeachScore = doc.createElement("HighScorePeach");
            rootElement.appendChild(PeachScore);
            
            Attr attrType1 = doc.createAttribute("score");
            attrType1.setValue(Integer.toString(highScorePeach));
            
            PeachScore.setAttributeNode(attrType1);
            
            Element MelonScore = doc.createElement("HighScoreMelon");
            rootElement.appendChild(MelonScore);
            
            Attr attrType2 = doc.createAttribute("score");
            attrType2.setValue(Integer.toString(highScoreMelon));
            
            MelonScore.setAttributeNode(attrType2);
            
            Element ArcadeScore = doc.createElement("HighScoreArcade");
            rootElement.appendChild(ArcadeScore);
            
            Attr attrType3 = doc.createAttribute("score");
            attrType3.setValue(Integer.toString(highScoreArcade));
	         
            ArcadeScore.setAttributeNode(attrType3);
	         
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Fruit Ninja.xml"));
            transformer.transform(source, result);

            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
	         
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public void loadGame() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("Fruit Ninja.xml");
			
			NodeList score1 = doc.getElementsByTagName("HighScoreBanana");
			Node score= score1.item(0); 
		
				if(score.getNodeType()==Node.ELEMENT_NODE) {
					Element s = (Element) score;
					highScoreBanana = Integer.parseInt( s.getAttribute("score"));
				}

				NodeList score2 = doc.getElementsByTagName("HighScorePeach");
				Node score22= score2.item(0); 
			
				if(score.getNodeType()==Node.ELEMENT_NODE) {
					Element s = (Element) score22;
					highScorePeach = Integer.parseInt( s.getAttribute("score"));
				}	
					
				NodeList score3 = doc.getElementsByTagName("HighScoreMelon");
				Node score33= score3.item(0); 
				
				if(score.getNodeType()==Node.ELEMENT_NODE) {
					Element s = (Element) score33;
					highScoreMelon = Integer.parseInt( s.getAttribute("score"));
				}	
					
				NodeList score4 = doc.getElementsByTagName("HighScoreArcade");
				Node score44= score4.item(0); 					
				
				if(score.getNodeType()==Node.ELEMENT_NODE) {
					Element s = (Element) score44;
					highScoreArcade = Integer.parseInt( s.getAttribute("score"));
				}	
		
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}