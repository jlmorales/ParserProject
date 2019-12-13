import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class Parser {
    public static void main(String args[]){
        try{
            //check for arguments
            if(args.length < 2) {
                System.out.println("Please give command line arguements. Refer to readme.");
                return;
            }
            String sortedBy = args[0];
            String filePath = args[1];

            //read first line of file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String flag = reader.readLine();
            if(flag == null){
                System.out.println("The first line is not what was expected. Please refer to Readme");
                return;
            }
            ArrayList<Record> records;
            //if first line is 1 then parse in format 1
            if(flag.equals("1")){
                records = format1Parsing(reader);
            }
            //if first line is 2 then parse using format 2
            else if (flag.equals("2")){
                records = format2Parsing(reader);
            }
            //if not 1 or 2 then something is wrong with file
            else{
                System.out.println("Not a valid File Format. Refer to Readme");
                return;
            }
            //sort according to args options are first, last, date
            if(sortedBy.equals("first")){
                Collections.sort(records, new FirstNameCompare());
            }
            else if (sortedBy.equals("last")) {
                Collections.sort(records, new LastNameCompare());
            }
            else if (sortedBy.equals("date")){
                Collections.sort(records, new StartDateCompare());
            }
            else{
                System.out.println("Not a vaild sorting arg. Please Refer to Readme");
                return;
            }
            //once we are done with sort then write sorted list to output
            PrintWriter writer = new PrintWriter("output.txt");
            for(int i = 0; i < records.size(); i++){
                writer.println(i + 1);
                writer.print(records.get(i));
            }
            writer.close();

        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static ArrayList<Record> format1Parsing(BufferedReader rd) throws Exception {
        String currentLine = rd.readLine();
        ArrayList<Record> records = new ArrayList<>();
        while (currentLine != null){
            if(currentLine.length() < 80){
                throw new Exception("Record is not 80 chars wide");
            }
            if(currentLine.length() > 80){
                throw new Exception("Record exceeds expected 80 chars. Please refer to Readme");
            }
            String firstName = currentLine.substring(0,10);

            String lastName = currentLine.substring(10,27);

            String date = currentLine.substring(27,35);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            Date startDate = formatter.parse(date);

            String address1 = currentLine.substring(35,45);

            String address2 = currentLine.substring(45,55);

            String city = currentLine.substring(55,65);

            String state = currentLine.substring(65,67);

            String country = currentLine.substring(67,70);

            String zip = currentLine.substring(71, currentLine.length());

            Record record = new Record(firstName, lastName,startDate,address1, address2, city,state,country,zip);
            records.add(record);
            currentLine = rd.readLine();
        }
        return records;
    }

    public static ArrayList<Record> format2Parsing(BufferedReader rd) throws Exception {
        String currentLine = rd.readLine();
        ArrayList<Record> records = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        while(currentLine != null) {
            ArrayList<String> items = new ArrayList<String>(Arrays.asList(currentLine.split(",")));
            if(items.size() < 9)
                throw new Exception("Not enough record elements");
            if(items.size() > 9)
                throw new Exception("Too many record elements");

            Record record = new Record();

            record.setFirstName(items.get(0));

            record.setLastName(items.get(1));

            record.setStartDate(formatter.parse(items.get(2)));

            record.setAddress1(items.get(3));

            record.setAddress2(items.get(4));

            record.setCity(items.get(5));

            record.setState(items.get(6));

            record.setCountry(items.get(7));

            record.setZip(items.get(8));

            records.add(record);

            currentLine = rd.readLine();
        }
        return records;

    }
}
