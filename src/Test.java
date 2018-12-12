import vbee.nlp.segmentation.sentence.SegmentationSentence;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        try {
//            String inputText = "\"Khi thẩm vấn, bị cáo cũng có những phân tích đánh giá, mong muốn HĐXX, VKS phân tích trên cơ sở những hành vi ấy để từ đó bị cáo được hưởng những chính sách giảm nhẹ hình sự. Từ khi điều tra, khi có cáo trạng và đến khi ra tòa bị cáo đã nhận tội, lỗi đến đâu bị cáo nhận đến đó, không đổ lỗi cho ai, trách nhiệm thuộc về bị cáo. Mong muốn HĐXX xem xét giảm hình phạt cho bị cáo ở mức thấp nhất của khung hình phạt\"- bị cáo Vĩnh nói.\n";
//            List<String> sentences = SegmentationSentence.process(inputText);
//            for(String s:sentences){
//                System.out.println(s);
//            }
//            Iterator var3 = sentences.iterator();
//
//            while(var3.hasNext()) {
//                String sentence = (String)var3.next();
//                System.out.println(sentence);
//            }
//        } catch (Exception var5) {
//            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, (String)null, var5);
//        }


//        FileWriter writer = null;
//        try {
//            writer = new FileWriter("sto1.csv");
//            List<String> test = new ArrayList<>();
//            test.add("Word1");
//            test.add("Word2");
//            test.add("Word3");
//            test.add("Word4");
//
//            String collect = test.stream().collect(Collectors.joining(","));
//            writer.write("\n");
//            System.out.println(collect);
//
//            writer.write(collect);
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        //Path out = Paths.get("output.txt");
//     //   List<String> arrayList = new ArrayList<> ( Arrays.asList ( "Xuân hội" , "b" , "c" ) );
//        try {
//           // Files.write(out,arrayList,Charset.defaultCharset());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        final File folder = new File("C:\\Users\\Stealer Of Souls\\Desktop\\Data\\original-texts");
        final File folder2 = new File("C:\\Users\\Stealer Of Souls\\Desktop\\Data\\references-texts");


//        for(ModelSententens model:listFilesForFolder(folder2)){
//            List<String> arrayList=new ArrayList<>();
//            try{
//                List<String> sentences = SegmentationSentence.process(readFile(model.getPath()));
//                for(String s:sentences){
//                  arrayList.add(s.trim());
//                }
//                Path out = Paths.get("sentences_references_"+model.getId()+".txt");
//                Files.write(out,arrayList,Charset.defaultCharset());
//
//
//                //System.out.println(sentences.size());
//            }catch (Exception e){
//
//            }
//
//
//        }
        OutputStream os = null;
//        try {
//            os = new FileOutputStream("js.csv");
//            os.write(239);
//            os.write(187);
//            os.write(191);
//
//            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
//            List<String> test = new ArrayList<>();
//            test.add("Xuân Hội Nguyễn");
//            test.add("Word2");
//            test.add("Word3");
//            test.add("Word4");
//            String collect = test.stream().collect(Collectors.joining("\n"));
//            System.out.println(collect);
//            writer.write(collect);
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        for(ModelSententens model:listFilesForFolder(folder)){
            List<String> arrayList=new ArrayList<>();
            try{
                List<String> sentences = SegmentationSentence.process(readFile(model.getPath()));
                for(String s:sentences){
                  arrayList.add(s.trim());
                }
                os = new FileOutputStream("sentences_original_"+model.getId()+".csv");
                os.write(239);
                os.write(187);
                os.write(191);

                PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
                String collect = arrayList.stream().collect(Collectors.joining("\n"));
                System.out.println(collect);
                writer.write(collect);
                writer.close();


                //System.out.println(sentences.size());
            }catch (Exception e){

            }


        }

    }

    public static List<ModelSententens> listFilesForFolder(final File folder) {
        List<ModelSententens>path=new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                path.add(new ModelSententens(fileEntry.getAbsolutePath(),fileEntry.getName()));
            }
        }
        return path;
    }


    public static String readFile(String path){
        BufferedReader br=null;
        try {
             br = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            return everything;
        }catch (Exception e){
            return null;

        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
