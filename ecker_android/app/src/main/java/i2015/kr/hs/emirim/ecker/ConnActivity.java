package i2015.kr.hs.emirim.ecker;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class ConnActivity extends ActionBarActivity {
     static EditText edit;
     static WebView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setBackgroundDrawable(new BitmapDrawable(
                BitmapFactory
                        .decodeResource(getResources(), R.drawable.action)));

        edit = (EditText)findViewById(R.id.edit);
        Button show = (Button)findViewById(R.id.show);
        view = (WebView)findViewById(R.id.webView);
        view.setWebViewClient(new MyBrowser());
        view.setInitialScale(305);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(view);
            }
        });

    }

    public void open(View v){
        String url = edit.getText().toString();
        if(url.equals("temp")){
            url = "http://api.thingspeak.com/channels/35193/charts/1?width=450&height=260&results=60&dynamic=true";
        }else if(url.equals("light")){
            url = "http://api.thingspeak.com/channels/35193/charts/2?width=450&height=260&results=60&dynamic=true";
        }
        else{
            url = "http://api.thingspeak.com/channels/35193/charts/3?width=450&height=260&results=60&dynamic=true";
        }
        view.getSettings().setLoadsImagesAutomatically(true);
        view.getSettings().setJavaScriptEnabled(true);
        view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        view.loadUrl(url);
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_conn, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
