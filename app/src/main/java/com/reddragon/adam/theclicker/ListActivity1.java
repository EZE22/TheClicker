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

public class ListActivity1 extends Activity {

    EditText et;
    Button bt;
    ListView lv;
    EditText editText;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list1);

        et = (EditText)findViewById(R.id.editText1);
        bt = (Button)findViewById(R.id.btn1);
        lv = (ListView)findViewById(R.id.listView1);
        editText =(EditText)findViewById(R.id.editText1);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(ListActivity1.this,
                android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(adapter);

        onBtnClick();
    }

    public void onBtnClick(){
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
         public void onClick(View v){
                String results = et.getText().toString();
                arrayList.add(results);
                adapter.notifyDataSetChanged();
                editText.setText(" ");
            }
        });
    }

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
