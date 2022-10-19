package com.example.android.quakereport;

public class EarthquakeAdapter extends android.widget.ArrayAdapter {
    public EarthquakeAdapter(@android.support.annotation.NonNull android.content.Context context, java.util.List<com.example.android.quakereport.Earthquake> earthquakes) {
    super(context, 0,earthquakes);
}

    @android.support.annotation.NonNull

    private static final String LOCATION_SEPARATOR = " of ";
    @Override
    public android.view.View getView(int position, @android.support.annotation.Nullable android.view.View convertView, @android.support.annotation.NonNull android.view.ViewGroup parent) {

        android.view.View listItemView = convertView;
        if (listItemView == null) {
            listItemView = android.view.LayoutInflater.from(getContext()).inflate(com.example.android.quakereport.R.layout.earthquake_list_item, parent, false);
        }
        Earthquake currentEarthquake = (Earthquake) getItem(position);
        android.widget.TextView magnitudeView= (android.widget.TextView) listItemView.findViewById(com.example.android.quakereport.R.id.magnitude);
       String formattedMagnitude = formatmagnitude(currentEarthquake.getMagnitude());
       magnitudeView.setText(formattedMagnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        android.graphics.drawable.GradientDrawable magnitudeCircle = (android.graphics.drawable.GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String origialLocation = currentEarthquake.getLocation();
        String offsetLocation ;
        String primaryLocation;
        if(origialLocation.contains(LOCATION_SEPARATOR)){
            String []parts = origialLocation.split(LOCATION_SEPARATOR);
            offsetLocation = parts[0]+LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        }
        else
        {
            offsetLocation = getContext().getString(com.example.android.quakereport.R.string.near_the);
            primaryLocation = origialLocation;
        }
        android.widget.TextView primaryLocationView = (android.widget.TextView) listItemView.findViewById(com.example.android.quakereport.R.id.primary_location);
        primaryLocationView.setText(primaryLocation);
        android.widget.TextView offsetLocationView =(android.widget.TextView) listItemView.findViewById(com.example.android.quakereport.R.id.location_offset);
        offsetLocationView.setText(offsetLocation);
        java.util.Date dateObject = new java.util.Date(currentEarthquake.getTimeInMilliSeconds());
        android.widget.TextView dateView = (android.widget.TextView) listItemView.findViewById(com.example.android.quakereport.R.id.date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);
        android.widget.TextView timeView = (android.widget.TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return android.support.v4.content.ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    private String formatmagnitude(double magnitude) {
        java.text.DecimalFormat magnitudeFormat =  new java.text.DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private String formatTime(java.util.Date dateObject) {
        java.text.SimpleDateFormat timeFormat =  new java.text.SimpleDateFormat("hh:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatDate(java.util.Date dateObject) {
        java.text.SimpleDateFormat dateFormat= new java.text.SimpleDateFormat("LLL dd ,yyyy");
        return dateFormat.format(dateObject);
    }

}
