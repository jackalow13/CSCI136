package Zombies;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

// Class to save to CSV
// **Used ArrayList due to known size/more adaptive?

public class SaveData {

    // Method to save using FileOutPutStream and Print writer
    // Includes headers
    public static void SaveZombieData(String fileName, ArrayList<String> zd)
            throws FileNotFoundException {
        //String[][] zd =convertDataToString(intZombieData);
        FileOutputStream fos = new FileOutputStream(fileName, false);
        PrintWriter pw = new PrintWriter(fos);

        pw.println("Iteration,Health,Infected,Time Elapsed");
        int i = 0;
        while (i<zd.size()){
            pw.println(zd.get(i)+zd.get(i+1)+zd.get(i+2)+zd.get(i+3));
            i+=4;
        }
        pw.close();
        System.out.println(fileName +" has been saved.");
    }
}
