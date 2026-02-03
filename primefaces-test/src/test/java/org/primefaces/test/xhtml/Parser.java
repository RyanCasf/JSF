package org.primefaces.test.xhtml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public interface Parser {
	
	String expression();
	void action(Node node, Path path);
	
	@Test
	default void test() throws IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);
		factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Files.walk(Paths.get("src/main/webapp"))
			.filter(path -> Files.isDirectory(path) == false)
			.filter(path -> path.toString().endsWith(".xhtml"))
			.forEach(path -> {
				try {
					Document document = builder.parse(path.toAbsolutePath().toFile());
					
					XPath xpath = XPathFactory.newInstance().newXPath();
					NodeList nodeList = (NodeList) xpath.evaluate(expression(), document, XPathConstants.NODESET);
					
					for (int i = 0; i < nodeList.getLength(); i++) {
						action(nodeList.item(i), path);
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			});
	}
}