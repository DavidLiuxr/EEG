/**
 * 
 */
package fft;

import java.util.ArrayList;

/**
 * @author Xiaoran Liu zxac064@live.rhul.ac.uk
 * @version 1.6
 * @date 17 Aug 2013 14:07:19
 */
public class FrequencyData {
    private double delta;
    private ArrayList<DataTime> deltaArray;
    private double theta;
    private ArrayList<DataTime> thetaArray;
    private double alpha;
    private ArrayList<DataTime> alphaArray;
    private double beta;
    private ArrayList<DataTime> betaArray;
    private double gamma;
    private double mu;
    private int sleepnessCount=0;
    private int sleepnessLevel;
    private double sleepnessTime;
    
    
    /**
     * @param deltaArray
     * @param thetaArray
     * @param alphaArray
     * @param betaArray
     * @param sleepnessCount
     */
    public FrequencyData(int sleepnessCount) {
        super();
        this.deltaArray = new ArrayList<DataTime>();
        this.thetaArray = new ArrayList<DataTime>();
        this.alphaArray = new ArrayList<DataTime>();
        this.betaArray = new ArrayList<DataTime>();
        this.sleepnessCount = sleepnessCount;
    }
    /**
     * @return the sleepnessTime
     */
    public double getSleepnessTime() {
        return sleepnessTime;
    }
    /**
     * @param sleepnessTime the sleepnessTime to set
     */
    public void setSleepnessTime(double sleepnessTime) {
        this.sleepnessTime = sleepnessTime;
    }
    /**
     * @return the sleepnessLevel
     */
    public int getSleepnessLevel() {
        return sleepnessLevel;
    }
    /**
     * @param sleepnessLevel the sleepnessLevel to set
     */
    public void setSleepnessLevel(int sleepnessLevel) {
        this.sleepnessLevel = sleepnessLevel;
    }
    /**
     * @param delta the delta to set
     */
    public void setDelta(double delta) {
        this.delta = delta;
    }
    /**
     * @param theta the theta to set
     */
    public void setTheta(double theta) {
        this.theta = theta;
    }
    /**
     * @param aplpa the aplpa to set
     */
    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }
    /**
     * @return the delta
     */
    public double getDelta() {
        return delta;
    }
    /**
     * @return the theta
     */
    public double getTheta() {
        return theta;
    }
    /**
     * @return the alpha
     */
    public double getAlpha() {
        return alpha;
    }
    /**
     * @return the beta
     */
    public double getBeta() {
        return beta;
    }
    /**
     * @return the gamma
     */
    public double getGamma() {
        return gamma;
    }
    /**
     * @return the mu
     */
    public double getMu() {
        return mu;
    }
    /**
     * @param beta the beta to set
     */
    public void setBeta(double beta) {
        this.beta = beta;
    }
    /**
     * @param gamma the gamma to set
     */
    public void setGamma(double gamma) {
        this.gamma = gamma;
    }
    /**
     * @param mu the mu to set
     */
    public void setMu(double mu) {
        this.mu = mu;
    }
    public void resetAll() {
        delta = 0;
        theta = 0;
        alpha = 0;
        beta = 0;
        gamma = 0;
        mu = 0;
    }
    public boolean compareDeltaMagnitude () {
        if (delta>sleepnessLevel) {
            sleepnessCount++;
            return true;
        }
        return false;
        
    }
    /**
     * @return the sleepnessCount
     */
    public int getSleepnessCount() {
        return sleepnessCount;
    }
    
}
