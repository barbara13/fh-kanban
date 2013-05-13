package edu.fh.kanban.example;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import org.junit.Test;

public class XomTest {

	@Test
	public void readDocument() throws Exception {
		Builder builder = new Builder();
		String xml = "<kanban><tickets/><backlog/></kanban>";
		ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes());
		Document document = builder.build(stream);
		print(document);
	}

	private void print(Document document) throws IOException {
		Serializer s = new Serializer(System.out);
		s.setIndent(2);
		s.write(document);
	}
	
	@Test
	public void createDocument() throws Exception {
		Element root = new Element("kanban");
		root.appendChild(new Element("tickets"));
		root.appendChild(new Element("backlog"));
		root.appendChild(new Element("columns"));
		root.addAttribute(new Attribute("name", "test"));
		Document document = new Document(root);
		print(document);
	}

}
