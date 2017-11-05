package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(@NonNull Context context, @NonNull List<Word> objects) {
        super(context, R.layout.list_item_image_play, objects);
    }

    /**
     * Returns a custom list item inflated with the information provided from the data model attached to the ArrayAdapter.
     *
     * @param position    The position of the item which the ListView is requesting.
     * @param convertView The view from the scrap pile whose content is to be inflated with the item from the given position.
     * @param parent      The parent ViewGroup to which the returned list item is to be added.
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        // Use an LayoutInflater in case that the listItemView is null upon creation of the first items.
        if (listItemView == null) {
            // Parent refers to the outer root view of the newly created item; 'false' is passed to the function because we want to populate
            // the list item before attaching it to the listItemView
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_image_play, parent, false);
        }

        // Get the word at the given position
        Word currentWord = getItem(position);

        // Populate the list item
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_word);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTranslationTextView = (TextView) listItemView.findViewById(R.id.default_translation_word);
        defaultTranslationTextView.setText(currentWord.getDefaultTranslation());

        ImageView wordImage = (ImageView) listItemView.findViewById(R.id.word_image);

        if(currentWord.getImageResourceId() != -1) {
            wordImage.setImageResource(currentWord.getImageResourceId());
        } else {
            wordImage.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
