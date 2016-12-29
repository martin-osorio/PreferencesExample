package com.example.martinosorio.preferencesexample;

import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    public class Contact {

        //private variables
        int _id;
        String _name;
        String _phone_number;

        // Empty constructor
        public Contact(){

        }
        // constructor
        public Contact(int id, String name, String _phone_number){
            this._id = id;
            this._name = name;
            this._phone_number = _phone_number;
        }

        // constructor
        public Contact(String name, String _phone_number){
            this._name = name;
            this._phone_number = _phone_number;
        }
        // getting ID
        public int getID(){
            return this._id;
        }

        // setting id
        public void setID(int id){
            this._id = id;
        }

        // getting name
        public String getName(){
            return this._name;
        }

        // setting name
        public void setName(String name){
            this._name = name;
        }

        // getting phone number
        public String getPhoneNumber(){
            return this._phone_number;
        }

        // setting phone number
        public void setPhoneNumber(String phone_number){
            this._phone_number = phone_number;
        }
    }

}
