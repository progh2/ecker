package i2015.kr.hs.emirim.ecker;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class IntroActivity extends Activity {
    Handler h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(i2015.kr.hs.emirim.ecker.R.layout.activity_intro);
        h = new Handler();
        h.postDelayed(irun, 1500);
    }
    Runnable irun = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(IntroActivity.this,MainActivity.class);
            startActivity(i);
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }
    };

    public void onBackPressed() {
        h.removeCallbacks(irun);
    };

}