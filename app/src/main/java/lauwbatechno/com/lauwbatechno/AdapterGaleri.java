package lauwbatechno.com.lauwbatechno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.content.*;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AdapterGaleri extends RecyclerView.Adapter<AdapterGaleri.ViewHolder>{

    private String url[], judul[], location[];
    private Context context;

    public AdapterGaleri(String[] judul, String[] lokasi, String[] url, Context context) {
        this.url = url;
        this.judul = judul;
        this.location = lokasi;
        this.context = context;
    }

    @Override
    public AdapterGaleri.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter_galeri, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterGaleri.ViewHolder holder, final int position) {
        Picasso.with(context)
                .load(url[position])
                .placeholder(R.drawable.def)
                .error(R.drawable.def)
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("judul", judul[position]);
                bundle.putString("gambar", url[position]);
                bundle.putString("lokasi", location[position]);

                Intent intent = new Intent(context, DetailGaleri.class);
                intent.putExtras(bundle);
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return url.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.gambar);
        }
    }
}
