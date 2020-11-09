package reobchichorro.inf311.pratica03;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private LatLng pos;
    private int from;

    public final static int CID_NATAL = 1;
    public final static int VIÇOSA = 2;
    public final static int DEPT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Intent intent = getIntent();
        from = intent.getIntExtra("from",1);

//        int from = 1;
        if(from == CID_NATAL) {
            pos = new LatLng(-20.756570, -41.538140);
        } else if (from == VIÇOSA) {
            pos = new LatLng(-20.753067, -42.880657);
        } else if (from == DEPT){
            pos = new LatLng(-20.764973, -42.868474);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void clickVoltar(View v) {
        finish();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(from == CID_NATAL) {
            mMap.addMarker(new MarkerOptions().position(pos).title("Casa Cidade natal"));
        } else if (from == VIÇOSA) {
            mMap.addMarker(new MarkerOptions().position(pos).title("Apto Viçosa"));
        } else if (from == DEPT){
            mMap.addMarker(new MarkerOptions().position(pos).title("DPI-UFV"));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(pos));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 17.0f ) );
    }
}