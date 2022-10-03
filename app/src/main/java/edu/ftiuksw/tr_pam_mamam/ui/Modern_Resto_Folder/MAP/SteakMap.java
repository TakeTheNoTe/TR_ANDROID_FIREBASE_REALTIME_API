package edu.ftiuksw.tr_pam_mamam.ui.Modern_Resto_Folder.MAP;

import androidx.fragment.app.FragmentActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import edu.ftiuksw.tr_pam_mamam.R;

public class SteakMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.steak_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(this,R.raw.mapstyle2)
            );
            if (!success){
                Log.e("Maps Activity","Style parshing failed.");
            }
        }catch (Resources.NotFoundException e){
            Log.e("Maps Activity","Cant find the style. Error",e);
        }

        // Add a marker in Sydney and move the camera
        LatLng steak1 = new LatLng(-7.332005, 110.491785);
        mMap.addMarker(new MarkerOptions().position(steak1).title("Nine Steak"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(steak1,11f));

        LatLng steak2 = new LatLng(-7.322601, 110.499493);
        mMap.addMarker(new MarkerOptions().position(steak2).title("Cosmo Steak & Gelato"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(steak2,11f));

        LatLng steak3 = new LatLng(-7.321136, 110.499874);
        mMap.addMarker(new MarkerOptions().position(steak3).title("Yege Resto Salatiga"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(steak3,11f));

        LatLng steak4 = new LatLng(-7.330026, 110.498148);
        mMap.addMarker(new MarkerOptions().position(steak4).title("Star Steak Pancasila"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(steak4,11f));
    }
}
