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

public class Angkringan_Map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.angkringan_map);
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
        LatLng Angkringan1 = new LatLng(-7.322990, 110.499198);
        mMap.addMarker(new MarkerOptions().position(Angkringan1).title("BOS Angkringan"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(Angkringan1,11f));

        LatLng Angkringan2 = new LatLng(-7.317675, 110.478039);
        mMap.addMarker(new MarkerOptions().position(Angkringan2).title("Angkringan Nahnu"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(Angkringan2,11f));

        LatLng Angkringan3 = new LatLng(-7.307618, 110.476963);
        mMap.addMarker(new MarkerOptions().position(Angkringan3).title("Angkringan Latansa"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(Angkringan3,11f));

        LatLng Angkringan4 = new LatLng(-7.322409, 110.503044);
        mMap.addMarker(new MarkerOptions().position(Angkringan4).title("Angkringan Ing Sinode"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(Angkringan4,11f));

    }
}
