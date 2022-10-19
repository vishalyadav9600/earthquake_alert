package com.example.android.quakereport;

public class Earthquake {private double mMagnitude ;
    private String mLocation ;
    private  long mTimeInMilliSeconds;
    private String mUrl;

    public Earthquake(double magnitude, String location, long timeInMilliSeconds, String url){
        mMagnitude= magnitude;
        mLocation = location;
        mTimeInMilliSeconds = timeInMilliSeconds;
        mUrl = url;

    }
    public double getMagnitude(){ return mMagnitude ;}
    public String getLocation(){ return mLocation ;}
    public long getTimeInMilliSeconds(){ return mTimeInMilliSeconds ; }
    public String getUrl() {return mUrl;}
}
