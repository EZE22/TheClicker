package com.reddragon.adam.theclicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_menu);

        // Listener for List 1 button
        Button btnList1 = (Button)findViewById(R.id.btnList1);
        btnList1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goList_1();
            }
        });

        // Listener for List 2 button
        Button btnList2 = (Button)findViewById(R.id.btnList2);
        btnList2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goList_2();
            }
        });
    }

private void goList_1(){
        Intent intent = new Intent(MainMenuActivity.this, ListActivity1.class);
        this.startActivity(intent);
}

private void goList_2(){
    Intent intent = new Intent(MainMenuActivity.this, ListActivity2.class);
    this.startActivity(intent);
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
                startActivity(new Intent(getApplicationContext(), MainMenuActivity.class));
                return true;
            case R.id.mnuExit:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

