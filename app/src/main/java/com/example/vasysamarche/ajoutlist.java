package com.example.vasysamarche;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ajoutlist extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView mImageView;
    private Uri mImageUri;
    private EditText nameEditText;
    private EditText descriptionEditText;



    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoutlist);

        Button importButton = findViewById(R.id.button_import_photo);
        mImageView = findViewById(R.id.imageView_preview);

        nameEditText = findViewById(R.id.editTextText);
        descriptionEditText = findViewById(R.id.editTextText2);

        Button addButton = findViewById(R.id.Validé);
        addButton.setOnClickListener(view -> {

            String name = nameEditText.getText().toString();
            String value = descriptionEditText.getText().toString();

            if (name.isEmpty() || value.isEmpty()) {
                Toast.makeText(ajoutlist.this, "Remplissez les cases", Toast.LENGTH_SHORT).show();
            } else {
                String imageUriString = (mImageUri != null) ? mImageUri.toString() : null;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("imageUriString", imageUriString);
                resultIntent.putExtra("value", value);
                resultIntent.putExtra("stringValue", name);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
            });
        importButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();

            }



        });
        Button backButton = findViewById(R.id.retour);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            mImageUri = data.getData();
            mImageView.setImageURI(mImageUri);
            mImageView.setVisibility(View.VISIBLE);
        }


    }

}
