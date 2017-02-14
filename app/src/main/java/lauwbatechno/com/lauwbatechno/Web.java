package lauwbatechno.com.lauwbatechno;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Web extends Fragment {

    WebView wb;
    ProgressBar prb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tampilan = inflater.inflate(R.layout.activity_web, null);

        wb = (WebView)tampilan.findViewById(R.id.web_view);
        prb = (ProgressBar)tampilan.findViewById(R.id.pb);

        wb.setWebViewClient(new WebViewClient());
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        wb.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                prb.setVisibility(View.VISIBLE);
                if(newProgress == 100){
                    prb.setVisibility(View.GONE);
                }
            }
        });
        wb.loadUrl("http://www.lauwba.com/");


        return  tampilan;
    }
}
