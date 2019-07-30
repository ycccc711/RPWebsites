package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webView extends AppCompatActivity {
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        Intent getIntent = getIntent();
        String url = getIntent.getStringExtra("URL");
        webView.loadUrl(url);

        //Disable file access within WebView
        webView.getSettings().setAllowFileAccess(false);
        //Tell the WebView to enable JavaScript execution
        webView.getSettings().setJavaScriptEnabled(true);
        //Enable the built-in zoom control for the WebView
        webView.getSettings().setBuiltInZoomControls(true);

    }
}
