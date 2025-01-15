import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String[]> records = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        String filePath = "src/spielorte.xml";
        List<Euro2024> records = readFile(filePath);


        System.out.println("Enter a capacity: ");
        Scanner scanner = new Scanner(System.in);
        int inputCap = Integer.parseInt(scanner.nextLine());
        records.stream().filter(c -> c.getCapacity() >= inputCap).toList().forEach(System.out::println);



    }

//    public static List<Euro2024> readFile(String dateiname) throws IOException {
//        List<Euro2024> eintraege = new ArrayList<>();
//        try {
//            // Initialize the XML parser
//            File xmlFile = new File(dateiname);
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document document = builder.parse(xmlFile);
//
//            // Normalize the XML structure
//            document.getDocumentElement().normalize();
//
//            // Get all "Eintrag" elements
//            NodeList nodeList = document.getElementsByTagName("*");
//
//            // Iterate through each "Eintrag"
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                Node node = nodeList.item(i);
//
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Element element = (Element) node;
//
//
//                    System.out.println("DA");
//                    // Extract values from the XML
//                    int id = Integer.parseInt(element.getElementsByTagName("Id").item(0).getTextContent().trim());
//                    String team1 = element.getElementsByTagName("Team1").item(0).getTextContent().trim();
//                    String team2 = element.getElementsByTagName("Team2").item(0).getTextContent().trim();
//                    String date = element.getElementsByTagName("Datum").item(0).getTextContent().trim();
//                    String city = element.getElementsByTagName("Spielort").item(0).getTextContent().trim();
//                    int capacity = Integer.parseInt(element.getElementsByTagName("Kapazität").item(0).getTextContent().trim());
//
//                    // Create a new PunkteEintrag and add it to the list
//                    eintraege.add(new Euro2024(id, team1, team2, date, city, capacity));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new IOException("Fehler beim Lesen der XML-Datei: " + e.getMessage());
//        }
//        return eintraege;
//    }

    public static List<Euro2024> readFile(String fileName) {
        List<Euro2024> records = new ArrayList<>();
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    int id = Integer.parseInt(element.getElementsByTagName("Id").item(0).getTextContent().trim());
                    String team1 = element.getElementsByTagName("Team1").item(0).getTextContent().trim();
                    String team2 = element.getElementsByTagName("Team2").item(0).getTextContent().trim();
                    String date = element.getElementsByTagName("Datum").item(0).getTextContent().trim();
                    String city = element.getElementsByTagName("Spielort").item(0).getTextContent().trim();
                    int capacity = Integer.parseInt(element.getElementsByTagName("Kapazität").item(0).getTextContent().trim());

                    records.add(new Euro2024(id, team1, team2, date, city, capacity));

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

}
