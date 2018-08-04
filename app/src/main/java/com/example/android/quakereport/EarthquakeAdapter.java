package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    /**
     * Create a new {@link EarthquakeAdapter} object.
     *
     * @param context     is the current context (i.e. Activity) that the adapter is being created in.
     * @param Earthquakes is the list of {@link Earthquake}s to be displayed.
     */
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> Earthquakes) {
        super(context, 0, Earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }

        /*
         * Get the {@link Earthquake} object located at this position in the list
         */
        Earthquake currentEarthquake = getItem(position);
        // Set the DecimalFormat to be like this 0.0

        // Find the TextView with view ID magnitude
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // Format the magnitude to show 1 decimal place
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
        // Display the magnitude of the current earthquake in that TextView
        magnitudeView.setText(formattedMagnitude);


        // Create new String to store Location.
        String fullLocation = new String(currentEarthquake.getLocation());
        // get the Location from fullLocation.
        String Location = getLocationFrom(fullLocation);
        // get the Distance from fullLocation.
        String Distance = getDistanceFrom(fullLocation);

        // Find the TextView in the list_item.xml layout with the ID location.
        TextView mPlaceTextView = (TextView) listItemView.findViewById(R.id.location);
        // Get the earthquake place from the currentEarthquake object and set this text on
        // the place TextView.
        mPlaceTextView.setText(Location);


        // Find the TextView in the list_item.xml layo ut with the ID distance.
        TextView mDistanceTextView = (TextView) listItemView.findViewById(R.id.distance);
        // Get the earthquake distance from the currentEarthquake object and set this text on
        // the distance TextView.
        mDistanceTextView.setText(Distance);

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        // Return the list item view that is now showing the appropriate data
        // Return the whole list item layout (containing 3 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * @param LocationFrom contain the full description location (i.e 80 Km N of San Francisco, CA).
     * @return Cut the full description location and get San Francisco, CA.
     */

    private String getLocationFrom(String LocationFrom) {
        if (LocationFrom.contains(LOCATION_SEPARATOR)) {
            String[] Location = LocationFrom.split(LOCATION_SEPARATOR);
            return Location[1];
        } else
            return LocationFrom;
    }

    /**
     * @param DistanceFrom contain the full description location (i.e 80 Km N of San Francisco, CA).
     * @return Cut the full description location and get 80 Km N of.
     */
    private String getDistanceFrom(String DistanceFrom) {
        if (DistanceFrom.contains(LOCATION_SEPARATOR)) {
            String[] Location = DistanceFrom.split(LOCATION_SEPARATOR);
            return Location[0] + LOCATION_SEPARATOR;
        } else
            return getContext().getString(R.string.near_the);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double Magnitude) {
        int magnitude1Color;

        switch ((int) Magnitude) {
            case 0:
            case 1:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            case 10:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
            default:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return magnitude1Color;
    }


}