import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Toolbox {

    public static void write1DArrayToFile(String filename, double[] data){
        try{
            File file = new File(filename+".txt");
            if(!file.exists()) file.createNewFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);



            // iterate down all the measurements from each time
            for(int i = 0; i < data.length; i++){

                String output = String.format("%.4f", data[i]);
                bw.write(output.trim());
                bw.newLine();
            }
            bw.close();

        }catch (IOException e){}

    }

    public static void write_2_1DArraysToFile(String filename, double[] xData, double[] yData){

        try{
            File file = new File(filename+".txt");
            if(!file.exists()) file.createNewFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);



            // iterate down all the measurements from each time
            for(int i = 0; i < xData.length; i++){

                String output = String.format("%.4f\t%.4f", xData[i], yData[i]);
                bw.write(output.trim());
                bw.newLine();
            }
            bw.close();

        }catch (IOException e){}
    }

}
