package br.com.criandojogosandroid.cap05ex01_textos;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TTFActivity extends AppCompatActivity {

    private Tela tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tela = new Tela(this);
        setContentView(tela);
    }

    private class Tela extends View {

        private Paint paint = new Paint();

        public Tela(Context context) {
            super(context);
            AssetManager assetManager = context.getAssets();
            Typeface android = Typeface.createFromAsset(assetManager, "android.ttf");
            paint.setTypeface(android);
            paint.setTextSize(80);
            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(Color.rgb(0, 140, 0));
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawText("Android", 240, 300, paint);
        }
    }
}
