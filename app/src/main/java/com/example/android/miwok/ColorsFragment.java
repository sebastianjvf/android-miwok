package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends VocabularyFragment {

    public ColorsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);

        // Inflate layout
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Add words and their translations to the numbers list
        final ArrayList<Word> englishWords = new ArrayList<Word>();
        englishWords.add(new Word("weṭeṭṭi", "red", R.drawable.color_red, R.raw.color_red));
        englishWords.add(new Word("chokokki", "green", R.drawable.color_green, R.raw.color_green));
        englishWords.add(new Word("ṭakaakki", "brown", R.drawable.color_brown, R.raw.color_brown));
        englishWords.add(new Word("ṭopoppi", "gray", R.drawable.color_gray, R.raw.color_gray));
        englishWords.add(new Word("kululli", "black", R.drawable.color_black, R.raw.color_black));
        englishWords.add(new Word("kelelli", "white", R.drawable.color_white, R.raw.color_white));
        englishWords.add(new Word("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        englishWords.add(new Word("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        // Use a custom ArrayAdapter to fill the ListView with word items
        WordAdapter adapter = new WordAdapter(getActivity(), englishWords, R.color.category_colors);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = englishWords.get(position);

                // Release the resources and abandon AudioFocus
                releaseMediaPlayer();

                final int result = audioManager.requestAudioFocus(mAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // And play
                    mediaPlayer = MediaPlayer.create(getActivity(), word.getSoundResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        return rootView;
    }

}
