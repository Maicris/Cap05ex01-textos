package br.com.criandojogosandroid.cap05ex01_textos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

public class SimpleActivity extends AppCompatActivity {

    private Tela tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tela = new Tela(this);
        setContentView(tela);
    }

    private class Tela extends View {

        private Paint paint = new Paint();
        private Random rnd = new Random();

        public Tela(Context context) {
            super(context);
            paint.setTextSize(30);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(Color.BLUE);
            paint.setTypeface(Typeface.MONOSPACE);
            paint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            String text = "ANDROID_GAMES";
            float skewFactor = 2.0f / text.length();
            float scaleFactor = 1.0f / text.length();
            for (int i = 0; i < text.length(); i++) {
                paint.setColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                paint.setTextSkewX(1.0f - skewFactor * i);
                paint.setTextScaleX(1.0f + scaleFactor * i);
                canvas.drawText(text, 0, i + 1, 240, 50 + i * 45, paint);
            }
        }
    }
}
