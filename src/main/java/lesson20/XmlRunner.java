package lesson20;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lesson20.factory.EmployeeFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlRunner {

    private static File xmlFile = new File("F:/test/XMLemployees.xml");

    public static void main(String[] args) throws Throwable {

        Company myCompany = new Company();
        myCompany.setEmployees(EmployeeFactory.getListOfRandomEmployees(10));
        writeToXml(myCompany, xmlFile);
        try (InputStream inputStream = new FileInputStream(xmlFile)) {
            Document xmlDocument = getXml(inputStream);
            XPath xPath = XPathFactory.newInstance().newXPath();
            double avg = (Double) xPath.compile("sum(//employee/job/salary) div count(//employee/job/salary)").evaluate(xmlDocument, XPathConstants.NUMBER);
            List<String> names = getEmployeeMoreThanAvgSalary(xmlDocument, xPath, avg);
           for (String name : names) {
               System.out.println(name);
           }
        }
    }

    private static void writeToXml(Company company, File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Company.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(company, file);
    }

    private static Document getXml(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        return builder.parse(inputStream);
    }

    private static List<String> getEmployeeMoreThanAvgSalary(Document document, XPath xPath, double salary) {
        List<String> listOfEmployees = new ArrayList<>();
        try {
            XPathExpression xPathExpression = xPath.compile("//employee[job[salary[1]>" + salary + "]]/fio/text()");
            NodeList nodeList = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++)
                listOfEmployees.add(nodeList.item(i).getNodeValue());
        }catch (XPathExpressionException ex) {
            System.out.println("oшибка: " + ex.getMessage());
        }
        return listOfEmployees;
    }
}
