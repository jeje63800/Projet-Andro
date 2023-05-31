package com.example.vasysamarche;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vasysamarche.Item;
import com.example.vasysamarche.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private ItemAdapter adapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // Créer une liste d'items avec des informations factices
        itemList = new ArrayList<>();
        itemList.add(new Item("Item 1", "Description de l'item 1", "android.resource://com.example.vasysamarche/drawable/amande"));
        itemList.add(new Item("Item 2", "Description de l'item 2", "android.resource://com.example.vasysamarche/drawable/cacahuete"));
        itemList.add(new Item("Item 3", "Description de l'item 3", "android.resource://com.example.vasysamarche/drawable/pistache"));
        adapter = new ItemAdapter(this, itemList);

        // Créer un adaptateur pour afficher les items dans la liste déroulante
        //ItemAdapter adapter = new ItemAdapter(this, R.layout.item_list_row, itemList);

        listView.setAdapter(adapter);

        // Gérer les clics sur les items de la liste
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item selectedItem = itemList.get(position);
                // Passer les détails de l'item à l'activité de détails
                Intent intent = new Intent(MainActivity.this, ItemDetailsActivity.class);
                intent.putExtra("item", selectedItem);
                startActivity(intent);
            }


        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ajoutlist.class);
                startActivity(intent);
            }
        });
        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String imageUriString = data.getStringExtra("imageUriString");
            String value = data.getStringExtra("value");
            String stringValue = data.getStringExtra("stringValue");

            addData(imageUriString, value, stringValue);
        }
    }
    public void addData(String imageUriString, String value, String stringValue) {
        Item item = new Item(imageUriString, value, stringValue);
        itemList.add(item);
        adapter.notifyDataSetChanged();
    }
    public void editData(int position, String imageUriString, String  value, String stringValue) {
        Item item = itemList.get(position);
        item.setImageResId(imageUriString);
        item.setName(value);
        item.setDescription(stringValue);
        adapter.notifyDataSetChanged();
    }
    }
