package lesson20;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lesson20.models.Employee;
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
    private static File jsonFile = new File("F:/test/JSONemployees.json");
    private static XPath xPath = XPathFactory.newInstance().newXPath();


    public static void main(String[] args) throws Throwable {

        Company myCompany = new Company();
        myCompany.setEmployees(EmployeeFactory.getListOfRandomEmployees(10));
        writeToXml(myCompany, xmlFile);
        try (InputStream inputStream = new FileInputStream(xmlFile)) {
            Document xmlDocument = getXml(inputStream);
            double avgSalary = calcAvgSalary(xmlDocument);
            List<String> names = getEmployeeMoreThanAvgSalary(xmlDocument, avgSalary);
            for (String name : names) {
               System.out.println(name);
           }
        }
        xmlToJson(xmlFile, jsonFile);
        printEmployeeOdd(jsonFile);
    }

    public static double calcAvgSalary(Document document) throws XPathExpressionException {
        return (Double) xPath.compile("sum(//employee/job/salary) div count(//employee/job/salary)").evaluate(document, XPathConstants.NUMBER);

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

    private static List<String> getEmployeeMoreThanAvgSalary(Document document, double salary) {
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

    private static void xmlToJson(File xmlFile, File jsonFile) throws IOException {
        Company company = JAXB.unmarshal(xmlFile, Company.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, company);
    }

    private static void printEmployeeOdd(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Company company = objectMapper.readValue(file, Company.class);
        int i = 1;
        for (Employee employee : company.getEmployees()) {
            if (i % 2 != 0) {
                System.out.println(employee);
            }
            i++;
        }
    }
}
