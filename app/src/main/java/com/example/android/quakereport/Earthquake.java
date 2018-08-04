package com.example.android.quakereport;

import java.util.ArrayList;

public class Earthquake extends ArrayList<Earthquake> {

    /** Name of the place. */
    private String mLocation;

    /** Magnitude of the earthquake */
    private double mMagnitude;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    /** URL link for more details*/
    private String mURLLink;


    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location is the location where the earthquake happened
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     *                           earthquake happened
     * @param URLLink is the website URL to find more details about the earthquake
     */
    public Earthquake(double magnitude, String location, long timeInMilliseconds, String URLLink) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mURLLink = URLLink;
    }


    /**
     * Get the PlaceName of the earthquake.
     */
   public String getLocation(){
        return mLocation;
   }

    /**
     * Returns the magnitude of the earthquake.
     */
    public double getMagnitude() {
        return mMagnitude;
    }

    /**
     * Get the Date of the earthquake.
     */
    public long getTimeInMilliseconds(){
        return mTimeInMilliseconds;
    }

    /**
     * Get URLLink of the earthquake
     */
    public String getUrl(){
        return mURLLink;
    }
}
