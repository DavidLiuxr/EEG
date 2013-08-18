package fft;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class ReadCSV {
    
    double [] [] dataResults;
    private int numLine = 0;
    private int numColumn = 0;
    String [] nameOfChannel;
    
  /**
     * @return the numLine
     */
    public int getNumLine() {
        return numLine;
    }

    /**
     * @return the numColumn
     */
    public int getNumColumn() {
        return numColumn;
    }

/**
     * @return the dataResults
     */
    public double[][] getDataResults() {
        return dataResults;
    }

public void run(String dataAddress) {
    BufferedReader br = null;
    BufferedReader brTemp = null;
    String line = "";
    String cvsSplitBy = ",";
    try {
        br = new BufferedReader(new FileReader(dataAddress));
        while ((line = br.readLine()) != null) {
                // use comma as separator
            String [] temp = line.split(cvsSplitBy);
            numLine = temp.length-1;
            numColumn++;
        }
        dataResults = new double [numLine][numColumn];
        nameOfChannel = new String [numLine-1];
        numColumn = 0;
        brTemp = new BufferedReader(new FileReader(dataAddress));
        line = brTemp.readLine();
        String [] firstLine = line.split(cvsSplitBy) ;
        for (int i =0;i<nameOfChannel.length;i++) {
            nameOfChannel[i] = firstLine[i+1];
            //System.out.print(nameOfChannel[i]+", ");
        }
        while ((line = brTemp.readLine()) != null) {
 
                // use comma as separator
            String [] temp = line.split(cvsSplitBy);
            
            for (int i=0;i<numLine;i++) {
                dataResults [i] [numColumn] = Double.parseDouble(temp [i+1]);
            }
            numColumn++;
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
  }
  
}