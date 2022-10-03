package edu.ftiuksw.tr_pam_mamam.ui.Modern_Resto_Folder.MAP;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
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

public class KfcMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kfc_map);
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

        LatLng kfc1 = new LatLng(-7.322840, 110.501357);
        mMap.addMarker(new MarkerOptions().position(kfc1).title("KFC"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(kfc1,11f));

        LatLng kfc2 = new LatLng(-7.324943, 110.505785);
        mMap.addMarker(new MarkerOptions().position(kfc2).title("Kfc box ramayana salatiga"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(kfc2,11f));
    }

}
