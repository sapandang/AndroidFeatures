package skd.app.androidfeatures.maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.schibstedspain.leku.LocationPickerActivity;

import skd.app.androidfeatures.R;

public class LocationPickerTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_picker);

        Intent locationPickerIntent = new LocationPickerActivity.Builder()
                .withLocation(41.4036299, 2.1743558)
                .withSearchZone("es_ES")
                .withGeolocApiKey("AIzaSyDjxwcVDhltsOxaA-gCQt7bi-k4eD_w3BY")
                .shouldReturnOkOnBackPressed()
                .withStreetHidden()
                .withCityHidden()
                .withZipCodeHidden()
                .withSatelliteViewHidden()
                .build(getApplicationContext());

        startActivityForResult(locationPickerIntent, 123);

    }
}
