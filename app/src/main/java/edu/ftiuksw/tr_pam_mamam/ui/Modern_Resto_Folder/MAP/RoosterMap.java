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

public class RoosterMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rooster_map);
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
        LatLng geprek1 = new LatLng(-7.321809, 110.497890);
        mMap.addMarker(new MarkerOptions().position(geprek1).title("Ayam Geprek Seruni & Aneka Penyet"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(geprek1,11f));

        LatLng geprek2 = new LatLng(-7.323152, 110.497312);
        mMap.addMarker(new MarkerOptions().position(geprek2).title("Ayam Gepruk Geprek"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(geprek2,11f));

        LatLng geprek3 = new LatLng(-7.320068, 110.498340);
        mMap.addMarker(new MarkerOptions().position(geprek3).title("Ayam Geprek Raja"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(geprek3,11f));

        LatLng geprek4 = new LatLng(-7.336705, 110.487678);
        mMap.addMarker(new MarkerOptions().position(geprek4).title("Ayam Geprek Barokah"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(geprek4,11f));
    }
}
