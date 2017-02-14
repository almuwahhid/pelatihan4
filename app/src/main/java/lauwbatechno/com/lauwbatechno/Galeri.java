package lauwbatechno.com.lauwbatechno;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Galeri extends Fragment {

    RecyclerView rc;
    public String images[] = {
            "http://www.lauwba.com/layanan/training-web-android-lauwba-techno.jpg",
            "http://www.gamemasterid.com/img_galeri/347534web%20lauwba.jpg",
            "http://www.lauwba.com/img_galeri/kecil_221221training%20kursus%20web%20android%20teknisi%20lauwba%20makassar%20jogja6.JPG",
            "http://www.lauwba.com/img_galeri/857147training%20kursus%20web%20android%20teknisi%20lauwba%20makassar%20jogja4.JPG",
            "http://www.lauwba.com/img_galeri/849304training%20kursus%20web%20android%20teknisi%20lauwba%20makassar%20jogja.jpg",
            "https://lh3.googleusercontent.com/proxy/xRBIpPI6L9SrOdxgcKa6z_uRrBygoZZ_hPLlgEr-NY66vjp67sBSezfr1NUMHq6iEWY7-s1imgdmCW45Y-6Kew=w426-h240-n"
    };
    public String judul[] = {
            "Borobudur",
            "Amplas",
            "LauwbaTechno",
            "aasd",
            "alkjsd",
            "asd"
    };
    public String lokasi[] = {
            "Yogyakarta",
            "Samping kosku",
            "Deket Janti",
            "Jalan Raya ",
            "blbalbalba",
            "blablabla"
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tampilan = inflater.inflate(R.layout.activity_galeri, null);

        rc = (RecyclerView)tampilan.findViewById(R.id.rv);
        rc.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new GridLayoutManager(getContext(), 2);
        rc.setLayoutManager(lm);

        AdapterGaleri galeri = new AdapterGaleri(judul, lokasi, images, getContext());
        rc.setAdapter(galeri);

        return  tampilan;
    }
}
