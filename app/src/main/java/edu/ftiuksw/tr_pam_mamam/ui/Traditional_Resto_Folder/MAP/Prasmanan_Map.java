package edu.ftiuksw.tr_pam_mamam.ui.Traditional_Resto_Folder.MAP;

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

public class Prasmanan_Map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prasmanan_map);
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
                    MapStyleOptions.loadRawResourceStyle(this,R.raw.mapstyle)
            );
            if (!success){
                Log.e("Maps Activity","Style parshing failed.");
            }
        }catch (Resources.NotFoundException e){
            Log.e("Maps Activity","Cant find the style. Error",e);
        }

        LatLng prasmanan1 = new LatLng(-7.321328, 110.497477);
        mMap.addMarker(new MarkerOptions().position(prasmanan1).title("WM Prasmanan Idola"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(prasmanan1,11f));

        LatLng prasmanan2 = new LatLng(-7.327952, 110.494996);
        mMap.addMarker(new MarkerOptions().position(prasmanan2).title("RM Barokah Prasmanan"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(prasmanan2,11f));

        LatLng prasmanan3 = new LatLng(-7.319909, 110.493729);
        mMap.addMarker(new MarkerOptions().position(prasmanan3).title("Warung Makan Prasmanan Agung Lestari"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(prasmanan3,11f));

        LatLng prasmanan4 = new LatLng(-7.318729, 110.502460);
        mMap.addMarker(new MarkerOptions().position(prasmanan4).title("Rumah makan prasmanan dan ayam geprak"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(prasmanan4,11f));
    }
}
