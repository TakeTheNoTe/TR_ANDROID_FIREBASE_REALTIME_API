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

public class Sate_Map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sate_map);
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
        LatLng sate1 = new LatLng(-7.327427, 110.504747);
        mMap.addMarker(new MarkerOptions().position(sate1).title("Sate sapi suruh dan bakso"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(sate1,11f));

        LatLng sate2 = new LatLng(-7.296283, 110.479392);
        mMap.addMarker(new MarkerOptions().position(sate2).title("Sate Kambing Muda & Sate Ayam Wijoyo Blotongan"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(sate2,11f));

        LatLng sate3 = new LatLng(-7.297073, 110.481521);
        mMap.addMarker(new MarkerOptions().position(sate3).title("Warung Sate Cempe Pak Darn"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(sate3,11f));

        LatLng sate4 = new LatLng(-7.330956, 110.509886);
        mMap.addMarker(new MarkerOptions().position(sate4).title("Sate Kambing Pak H.yono"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(sate4,11f));

    }
}
