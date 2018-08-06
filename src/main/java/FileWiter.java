import java.io.*;
import java.util.Scanner;

/**
 * Author nzb
 * Create Time 05/08/2018
 * Description
 */
public class FileWiter {
    public static void main(String[] args) throws IOException {
        DataInputStream in = null;
        try {

//        reading file and getting no. of files to be generated
            String inputFile = "D:/export_data/public.zst_crm_weight.txt";
            double no1 = 2000.0;
            File file = new File(inputFile);
            Scanner scanner = new Scanner(file);
            int count = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
//       display no. of lines in the input file
            System.out.println("Lines in the file: " + count);

            double temp = (count/no1);
            int temp1 = (int)temp;
            int nof = 0;
            if(temp1 == temp) {
                nof = temp1;
            }
            nof = temp1 + 1;
//        display no. of files to be generated
            System.out.println("No. of files to be generated" + nof);

//        actual splitting of file into smaller files
            FileInputStream fStream = new FileInputStream(inputFile);

            in = new DataInputStream(fStream);

            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            for(int j = 1; j <= nof; j++) {
//            destination file location
                FileWriter fStream1 = new FileWriter("E:/export_data1/file" + j + ".txt");
                BufferedWriter out = new BufferedWriter(fStream1);
                for(int i = 1; i <no1; i++) {
                    strLine = br.readLine();
                    if(strLine != null) {
                        out.write(strLine);
                        if(i != no1) {
                            out.newLine();
                        }
                    }
                }
            }
//            in.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            in.close();
        }
    }
}
