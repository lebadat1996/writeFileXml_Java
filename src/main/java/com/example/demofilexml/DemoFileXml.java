package com.example.demofilexml;

import org.w3c.dom.Element;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DemoFileXml {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element students = document.createElement("students");
        document.appendChild(students);
        students.setAttribute("no", "1");

        Element student = document.createElement("student");
        students.appendChild(student);

        // Thêm thẻ name
        Element name = document.createElement("name");
        name.appendChild(document.createTextNode("John"));
        student.appendChild(name);

        // Thẻ code
        Element code = document.createElement("code");
        code.appendChild(document.createTextNode("12345"));
        student.appendChild(code);

        // Thẻ age
        Element age = document.createElement("age");
        age.appendChild(document.createTextNode("19"));
        student.appendChild(age);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(document);

        File f = new File("E:\\FILE_XML\\students.xml");
        StreamResult result = new StreamResult(f);

        transformer.transform(source, result);


    }
}
