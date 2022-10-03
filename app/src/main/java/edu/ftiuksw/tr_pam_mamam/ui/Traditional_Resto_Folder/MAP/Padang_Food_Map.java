package edu.ftiuksw.tr_pam_mamam.ui.Traditional_Resto_Folder.MAP;

import androidx.fragment.app.FragmentActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.core.Tag;

import edu.ftiuksw.tr_pam_mamam.R;

public class Padang_Food_Map extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.padang_food_maps);
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
        LatLng padang1 = new LatLng(-7.324888, 110.499307);
        mMap.addMarker(new MarkerOptions().position(padang1).title("Rumah Padang Ampera"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(padang1,11f)
        );
        LatLng padang2 = new LatLng(-7.330263, 110.498676);
        mMap.addMarker(new MarkerOptions().position(padang2).title("Rumah Makan Padang Beringin 2"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(padang2,11f)
        );
        LatLng padang3 = new LatLng(-7.325384, 110.502353);
        mMap.addMarker(new MarkerOptions().position(padang3).title("Rumah Makan Padang Andalas"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(padang3,11f)
        );
        LatLng padang4 = new LatLng(-7.320136, 110.493006);
        mMap.addMarker(new MarkerOptions().position(padang4).title("Rumah Makan Padang Dek Saiyo"));
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(padang4,11f)
        );
    }
}
