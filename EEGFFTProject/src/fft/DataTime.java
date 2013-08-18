/**
 * 
 */
package fft;

/**
 * @author Xiaoran Liu zxac064@live.rhul.ac.uk
 * @version 1.6
 * @date 18 Aug 2013 03:15:39
 */
public class DataTime {
    private double magnitude;
    private double time;
    
    /**
     * @param magnitude
     * @param time
     */
    public DataTime(double magnitude, double time) {
        super();
        this.magnitude = magnitude;
        this.time = time;
    }
    /**
     * @return the magnitude
     */
    public double getMagnitude() {
        return magnitude;
    }
    /**
     * @param magnitude the magnitude to set
     */
    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }
    /**
     * @return the time
     */
    public double getTime() {
        return time;
    }
    /**
     * @param time the time to set
     */
    public void setTime(double time) {
        this.time = time;
    }
    
    
}
