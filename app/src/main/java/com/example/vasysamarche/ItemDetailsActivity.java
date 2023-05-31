package com.example.vasysamarche;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ItemDetailsActivity extends AppCompatActivity {

    private TextView itemNameTextView;
    private TextView itemDescriptionTextView;
    private ImageView itemImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        itemNameTextView = findViewById(R.id.itemNameTextView);
        itemDescriptionTextView = findViewById(R.id.itemDescriptionTextView);
        itemImageView = findViewById(R.id.itemImageView);

        // Récupérer les détails de l'item sélectionné depuis l'intent
        Intent intent = getIntent();
        Item selectedItem = (Item) intent.getSerializableExtra("item");

        Context context = itemImageView.getContext();
        String imageUriString = selectedItem.getImageResId();

        // Afficher les détails de l'item
        itemNameTextView.setText(selectedItem.getName());
        itemDescriptionTextView.setText(selectedItem.getDescription());

        Glide.with(context)
                .load(Uri.parse(imageUriString))
                .error(R.drawable.cacahuete)
                .into(itemImageView);

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}