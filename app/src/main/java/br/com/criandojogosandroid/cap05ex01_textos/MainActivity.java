package br.com.criandojogosandroid.cap05ex01_textos;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String items[] = {
                "Textos Simples",
                "Fontes True Type",
                "Textos sobre Caminhos",
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {
            case 0:
                startActivity(new Intent(this, SimpleActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, TTFActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, TextPathActivity.class));
                break;
        }
    }
}