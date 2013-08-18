/**
 * 
 */
package fft;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.sun.media.sound.FFT;

/**
 * @author Xiaoran Liu zxac064@live.rhul.ac.uk
 * @version 1.6
 * @date 12 Aug 2013 00:04:38
 */
public class Process {

    private String dataAddress = "";
    private double[][] dataArrayAfterFFT;
    private int numRow;
    private int numColumn;
    private ReadCSV csvFile = new ReadCSV();
    private FFT fftData;
    private FrequencyData frequencyData;
    private double [] magnitude;
    private ArrayList<FrequencyData> listOfSleepness;
    
    
    
    /**
     * @return the frequencyData
     */
    public FrequencyData getFrequencyData() {
        return frequencyData;
    }

    public Process (String address, int sleepnessLevel) throws FileNotFoundException {
        dataAddress = address;
        this.frequencyData=new FrequencyData(sleepnessLevel);
    }
    
    public void loadFile () throws FileNotFoundException {
        csvFile.run(dataAddress);
        numRow = csvFile.getNumLine();
        numColumn = csvFile.getNumColumn();
        dataArrayAfterFFT = new double [numRow][numColumn];
        fftData = new FFT(128,1);
    }
    public void fftConvertAndGetMagnitude () {
        dataArrayAfterFFT = csvFile.getDataResults();
        for (int z =0;z<14;z++) {
            for (int x = 0;x<numColumn-128;x=x+128) {
                double [] temp = new double[2*128];
                for (int i = 0;i<128;i++) {
                    temp [2*i] = dataArrayAfterFFT[z][x+i];
                    temp [2*i+1] = 0;
                    //System.out.println(temp[2*i]+"-"+temp[2*i+1]+"--");
                }
                //System.out.println(temp.length);
                fftData.transform(temp);
                frequencyData.resetAll();
                magnitude = new double [128];
                for (int y=0;y<128;y++) {
                    magnitude[y] = Math.sqrt(temp[2*y]*temp[2*y]+temp[2*y+1]*temp[2*y+1]);
                }
                for (int a = 1; a < 4;a++) {
                    frequencyData.setDelta(frequencyData.getDelta()+magnitude[a]);
                }
                for (int a = 4; a < 8;a++) {
                    frequencyData.setTheta(frequencyData.getTheta()+magnitude[a]);
                }
                for (int a = 8; a < 13;a++) {
                    frequencyData.setAlpha(frequencyData.getAlpha()+magnitude[a]);
                }
                for (int a = 13; a < 30;a++) {
                    frequencyData.setBeta(frequencyData.getBeta()+magnitude[a]);
                }
                for (int a = 30; a < 100;a++) {
                    frequencyData.setGamma(frequencyData.getGamma()+magnitude[a]);
                }
                for (int a = 8; a < 13;a++) {
                    frequencyData.setMu(frequencyData.getMu()+magnitude[a]);
                }
                if (z==1|z==2|z==4|z==11|z==12) {
                    if (frequencyData.compareDeltaMagnitude()) {
                        
                        
                    }
                }
                //System.out.println(frequencyData.getDelta());
                
            }
            //System.out.println();
            //System.out.println(frequencyData.getSleepnessCount());
        }
        /*for (int i = 0;i<numColumn;i++) {
            System.out.println(temp[2*i]+"="+temp[2*i+1]+"==");
        }
        System.out.println();
        System.out.println(temp.length);
        */
    }
    
}
