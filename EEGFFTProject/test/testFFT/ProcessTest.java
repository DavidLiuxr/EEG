/**
 * 
 */
package testFFT;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import fft.Process;

/**
 * @author Xiaoran Liu zxac064@live.rhul.ac.uk
 * @version 1.6
 * @date 12 Aug 2013 21:36:17
 */
public class ProcessTest {

    //ReadCSV test;
    Process test;
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        test = new Process("C:\\Users\\Setup\\Desktop\\EEGdata\\20130731_223757.csv",10000);
        //test = new ReadCSV();
    }

    @Test
    public void test() throws FileNotFoundException {
        //test.run("C:\\Users\\Setup\\Desktop\\EEGdata\\20130731_223757.csv");
        //System.out.println(test.getNumLine());
        //System.out.println(test.getNumColumn());
        //System.out.println(test.getDataResults()[0][0]);
        //System.out.println(test.getDataResults()[test.getNumLine()-1][test.getNumColumn()-1]);
        test.loadFile();
        test.fftConvertAndGetMagnitude();
        System.out.println(test.getFrequencyData().getSleepnessCount());
    }

}
