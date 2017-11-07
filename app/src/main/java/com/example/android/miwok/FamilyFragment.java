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
public class FamilyFragment extends VocabularyFragment {

    public FamilyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);

        // Inflate layout
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Add words and their translations to the numbers list
        final ArrayList<Word> englishWords = new ArrayList<Word>();
        englishWords.add(new Word("әpә", "father", R.drawable.family_father, R.raw.family_father));
        englishWords.add(new Word("әṭa", "mother", R.drawable.family_mother, R.raw.family_mother));
        englishWords.add(new Word("angsi", "son", R.drawable.family_son, R.raw.family_son));
        englishWords.add(new Word("tune", "daughter", R.drawable.family_daughter, R.raw.family_daughter));
        englishWords.add(new Word("taachi", "older brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        englishWords.add(new Word("chalitti", "younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        englishWords.add(new Word("teṭe", "older sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        englishWords.add(new Word("kolliti", "younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        englishWords.add(new Word("ama", "grandmother", R.drawable.family_grandmother, R.raw.family_grandmother));
        englishWords.add(new Word("paapa", "grandfather", R.drawable.family_grandfather, R.raw.family_grandfather));

        // Use a custom ArrayAdapter to fill the ListView with word items
        WordAdapter adapter = new WordAdapter(getActivity(), englishWords, R.color.category_family);
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
