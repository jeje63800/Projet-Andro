package com.example.vasysamarche;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    private final List<Item> itemList;

    public ItemAdapter(Context context, List<Item> itemList) {
        super(context, 0, itemList);
        this.itemList = itemList;
    }


    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_row, parent, false);
        }

        Item currentItem = getItem(position);

        TextView itemName = convertView.findViewById(R.id.item_name);
        TextView itemDescription = convertView.findViewById(R.id.item_description);
        ImageView itemImage = convertView.findViewById(R.id.item_image);

        String imageUriString = currentItem.getImageResId();

        Context context = itemImage.getContext();
        itemName.setText(currentItem.getName());
        itemDescription.setText(currentItem.getDescription());
        Glide.with(context)
                .load(Uri.parse(imageUriString))
                .error(R.drawable.cacahuete)
                .into(itemImage);

        return convertView;


    }
}
