package com.example.fwr.fwr;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg;
    EditText _txtName, _txtUser, _txtEmail, txtPhone, _txtAddress;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        openHelper = new DatabaseHelper(this);
        _txtName = (EditText)findViewById(R.id.txtName);
        _txtUser = (EditText)findViewById(R.id.txtUser);
        _txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtPhone = (EditText)findViewById(R.id.txtPhone);
        _txtAddress = (EditText)findViewById(R.id.txtAddress);
        _btnreg=(Button)findViewById(R.id.btnSign);

        //button = (Button) findViewById(R.id.viewDetails);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String name=_txtName.getText().toString();
                String username=_txtUser.getText().toString();
                String pass=_txtEmail.getText().toString();
                String email=txtPhone.getText().toString();
                String phone=_txtAddress.getText().toString();
                insertdata(name, username,pass,email,phone);
                Toast.makeText(getApplicationContext(), "register successfully", Toast.LENGTH_LONG).show();



            }
        });

    }

    public void insertdata(String name, String username, String email, String phone, String address){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, name);
        contentValues.put(DatabaseHelper.COL_3, username);
        contentValues.put(DatabaseHelper.COL_4, email);
        contentValues.put(DatabaseHelper.COL_5, phone);
        contentValues.put(DatabaseHelper.COL_6, address);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }
}
