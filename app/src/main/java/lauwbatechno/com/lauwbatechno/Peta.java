package lauwbatechno.com.lauwbatechno;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Peta extends Fragment implements OnMapReadyCallback, View.OnClickListener{
    GoogleMap map;
    Button a, b, c, d;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tampilan = inflater.inflate(R.layout.activity_peta, null);

        SupportMapFragment mp = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapFragment);
        mp.getMapAsync(this);

        a = (Button) tampilan.findViewById(R.id.normal);
        b = (Button) tampilan.findViewById(R.id.satellite);
        c = (Button) tampilan.findViewById(R.id.hybrid);
        d = (Button) tampilan.findViewById(R.id.terrain);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);

        return  tampilan;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng atmajaya = new LatLng(-7.7872008, 110.4132256);
        LatLng lauwba = new LatLng(-7.7867443, 110.4132115);
        map.addMarker(new MarkerOptions().position(lauwba).title("Kantor Lauwba Techno"));
        map.addMarker(new MarkerOptions().position(atmajaya).title("Universitas Atma Jaya"));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(lauwba, 20));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.normal :
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.satellite :
                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.hybrid :
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.terrain :
                map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;

        }
    }
}
