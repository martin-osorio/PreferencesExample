package com.example.martinosorio.preferencesexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.ET);

        SharedPreferences settings = getSharedPreferences("File", MODE_PRIVATE);
        String name = settings.getString("Name", "NO NAME");
        et.setHint(name);
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences("File", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        String name = et.getText().toString();
        if(name.equals("")){
            name = et.getHint().toString();
        }
        editor.putString("Name", name);
        editor.commit();
    }

    public void onTestDatabaseClick(View view) {
        Intent i = new Intent(this, AndroidSQLiteTutorialActivity.class);
        startActivity(i);
    }
}
