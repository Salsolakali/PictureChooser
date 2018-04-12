package com.example.fernana6.picturechooser;


import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    Button boton;
    ImageView imageView = null;
    Uri uri = null;

    private Intent chooser;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.btnSelectPhoto);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/jpg");
                startActivityForResult(intent, 0);
            }
        });
        imageView = findViewById(R.id.ivImage);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        uri = data.getData();
        imageView.setImageURI(uri);

    }
}
