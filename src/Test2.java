import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {

//    private static final String SEPARATOR = "\n";
//    public static void main(String[] args) {
//        List<String> cities = Arrays.asList(
//                "Xuân Hội",
//                "London",
//                "New York",
//                "San Francisco");
//        StringBuilder csvBuilder = new StringBuilder();
//        for(String city : cities){
//            csvBuilder.append(city);
//            csvBuilder.append(SEPARATOR);
//        }
//        String csv = csvBuilder.toString();
//        System.out.println(csv);
//        //OUTPUT: Milan,London,New York,San Francisco,
//        //Remove last comma
//        csv = csv.substring(0, csv.length() - SEPARATOR.length());
//        System.out.println(csv);
//        //OUTPUT: Milan,London,New York,San Francisco
//    }
//public static void main(String arg[])throws IOException
//{
//    ArrayList<String> list1 = new ArrayList<>();
//    list1.add("2212");
//    list1.add("gmail.com");
//
//    ArrayList<String> list2 = new ArrayList<>();
//    list2.add("Xuân Hội");
//    list2.add("403");
//    list2.add("192.168.0.26");
//    list2.add("1809");
//
//
//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test.csv"), StandardCharsets.UTF_8));
//
//    bw.write("Domain,Total");
//    bw.newLine();
//    for(int i=0;i<list1.size();i++)
//    {
//        bw.write(list1.get(i+1)+","+list1.get(i++));
//        bw.newLine();
//    }
//    bw.write("\nApplication,Total");
//    bw.newLine();
//    for(int i=0;i<list2.size();i++)
//    {
//        bw.write(list2.get(i++)+","+list2.get(i));
//        bw.newLine();
//    }
//    bw.close();
//}

    public static void main(String args[]) {
        String csvFilename = "OpenCSVWriteByList.csv";
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(csvFilename));
            List<String[]> csvData = new ArrayList<String[]>();
            String[] profile = "Xuân Hội,Ragi,30".split(",");
            String[] header="FIRSTNAME,LASTNAME,AGE".split(",");
            csvData.add(header);
            csvData.add(profile);

            writer.writeAll(csvData);
            writer.close();
            System.out.println("CSV file created succesfully.");
        } catch (Exception e) {
            System.out.println("exception :" + e.getMessage());
        }

    }
}
