package br.com.criandojogosandroid.cap05ex01_textos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TextPathActivity extends AppCompatActivity {

    private Tela tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tela = new Tela(this);
        setContentView(tela);
    }

    private class Tela extends View {

        private Paint drawPaint = new Paint();
        private Paint textPaint = new Paint();

        public Tela(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            drawPaint.setColor(Color.rgb(0, 120, 0));
            canvas.drawRect(40, 100, 440, 360, drawPaint);
            drawPaint.setColor(Color.rgb(220, 220, 50));
            Path losango = new Path();
            losango.moveTo(60, 230);
            losango.lineTo(240, 120);
            losango.lineTo(420, 230);
            losango.lineTo(240, 340);
            losango.close();
            canvas.drawPath(losango, drawPaint);
            drawPaint.setColor(Color.rgb(0, 0, 160));
            canvas.drawCircle(240, 230, 80, drawPaint);
            drawPaint.setColor(Color.WHITE);
            Path faixa = new Path();
            faixa.moveTo(160, 223);
            faixa.quadTo(240, 190, 320, 223);
            faixa.lineTo(320, 237);
            faixa.quadTo(240, 204, 160, 237);
            faixa.close();
            Matrix matrix = new Matrix();
            matrix.preRotate(12, 240, 230);
            faixa.transform(matrix);
            canvas.drawPath(faixa, drawPaint);
            Path linhaBase = new Path();
            linhaBase.moveTo(160, 230);
            linhaBase.quadTo(240, 197, 320, 230);
            linhaBase.transform(matrix);
            textPaint.setColor(Color.rgb(0, 120, 0));
            textPaint.setTextSize(10);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setFakeBoldText(true);
            textPaint.setTextScaleX(1.4f);
            textPaint.setAntiAlias(true);
            canvas.drawTextOnPath("ORDEM E PROGRESSO", linhaBase, 0, 5, textPaint);
        }
    }
}
