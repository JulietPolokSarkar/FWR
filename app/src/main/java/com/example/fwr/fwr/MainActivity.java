package com.example.fwr.fwr;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView about,registration,imageupload,map,faq,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        about = (CardView)findViewById(R.id.about);
        registration = (CardView)findViewById(R.id.registration);
        imageupload = (CardView)findViewById(R.id.imageupload);
        //map = (CardView)findViewById(R.id.gmap);
        faq = (CardView)findViewById(R.id.faq);
        contact = (CardView)findViewById(R.id.contact);


        about.setOnClickListener(this);
        registration.setOnClickListener(this);
        imageupload.setOnClickListener(this);
        //map.setOnClickListener(this);
        faq.setOnClickListener(this);
        contact.setOnClickListener(this);

    }

    public void process(View view){
        Intent intent = null;
        if (view.getId() ==R.id.map){
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:22.815966, 89.544257"));
            startActivity(intent);
        }
    }
    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){

            case R.id.about:i= new Intent(this,About_us.class);startActivity(i);break;
            case R.id.registration:i= new Intent(this,Registration.class);startActivity(i);break;
            case R.id.imageupload:i= new Intent(this,ImageUpload.class);startActivity(i);break;
            //case R.id.map:i= new Intent(this,GMap.class);startActivity(i);break;
            case R.id.faq:i= new Intent(this,faq.class);startActivity(i);break;
            case R.id.contact:i= new Intent(this,Contact_us.class);startActivity(i);break;
            default:break;


        }
    }

}
