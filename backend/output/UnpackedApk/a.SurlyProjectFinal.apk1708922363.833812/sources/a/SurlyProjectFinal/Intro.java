package a.SurlyProjectFinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Intro extends Activity {
    /* access modifiers changed from: private */
    public Intent _Intent;
    private LinearLayout _LinearLayout;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        Animation animation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        animation.setRepeatMode(2);
        animation.setRepeatCount(1);
        animation.setRepeatCount(-1);
        animation.setDuration(500);
        ((TextView) findViewById(R.id.text2)).setAnimation(animation);
        this._LinearLayout = (LinearLayout) findViewById(R.id.introLayout);
        this._LinearLayout.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return false;
                }
                Intro.this._Intent = new Intent(Intro.this, AudioPlayerInSDCardActivity.class);
                Intro.this.startActivity(Intro.this._Intent);
                Intro.this.finish();
                return true;
            }
        });
    }
}
