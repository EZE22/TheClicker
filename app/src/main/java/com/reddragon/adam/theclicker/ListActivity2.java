package com.reddragon.adam.theclicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity2 extends Activity {

    EditText et2;
    Button bt2;
    ListView lv2;
    EditText editText;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list2);

        et2 = (EditText)findViewById(R.id.editText2);
        bt2 = (Button)findViewById(R.id.btn2);
        lv2 = (ListView)findViewById(R.id.listView2);
        editText = (EditText)findViewById(R.id.editText2);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(ListActivity2.this,
                android.R.layout.simple_list_item_1, arrayList);
        lv2.setAdapter(adapter);

        onBtn2Click();
    }

    public void onBtn2Click(){
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String results2 = et2.getText().toString();
                arrayList.add(results2);
                adapter.notifyDataSetChanged();
                editText.setText(" ");
            }
        });
    }

    // Overflow Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.mnuMain:
                startActivity(new Intent(getApplicationContext(),
                        MainMenuActivity.class));
                return true;
            case R.id.mnuExit:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

