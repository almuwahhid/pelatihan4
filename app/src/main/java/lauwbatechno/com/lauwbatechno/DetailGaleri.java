package lauwbatechno.com.lauwbatechno;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailGaleri extends AppCompatActivity {
    ImageView img;
    TextView judul, lokasi;

    String a, b, c;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_galeri);

        judul = (TextView)findViewById(R.id.judul);
        lokasi = (TextView)findViewById(R.id.lokasi);
        img = (ImageView) findViewById(R.id.gambardetail);

        Intent intent = getIntent();
        a = intent.getStringExtra("judul");
        b = intent.getStringExtra("gambar");
        c = intent.getStringExtra("lokasi");

        judul.setText(a);
        Picasso.with(this)
                .load(b)
                .placeholder(R.drawable.def)
                .error(R.drawable.def)
                .into(img);
        lokasi.setText(c);

        ActionBar act = getSupportActionBar();
        if(act != null){
            act.setTitle(a);
            act.setDisplayHomeAsUpEnabled(true);
        }

    }
}
