package reobchichorro.inf311.pratica03;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Map;

import reobchichorro.inf311.pratica03.R;

public class MainActivity extends Activity {

    public final static int CID_NATAL = 1;
    public final static int VIÇOSA = 2;
    public final static int DEPT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickCidNatal(View v){
        try {
            Intent it = new Intent(this, MapsActivity.class);
            it.putExtra("from", CID_NATAL);
            startActivityForResult(it,CID_NATAL);
        } catch (Exception e){
            Log.e("MAIN_MAPA", "ERRO: " + e.getMessage());
        }
    }

    public void clickViçosa(View v){
        try {
            Intent it = new Intent(this, MapsActivity.class);
            it.putExtra("from", VIÇOSA);
            startActivityForResult(it,VIÇOSA);
        } catch (Exception e){
            Log.e("MAIN_MAPA", "ERRO: " + e.getMessage());
        }
    }

    public void clickDept(View v){
        try {
            Intent it = new Intent(this, MapsActivity.class);
            it.putExtra("from", DEPT);
            startActivityForResult(it,DEPT);
        } catch (Exception e){
            Log.e("MAIN_MAPA", "ERRO: " + e.getMessage());
        }
    }
    public void clickFechar(View v){
        System.exit(0);
    }
}
