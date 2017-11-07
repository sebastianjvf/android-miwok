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
public class NumbersFragment extends VocabularyFragment {

    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);

        // Inflate layout
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Add words and their translations to the numbers list
        final ArrayList<Word> englishWords = new ArrayList<Word>();
        englishWords.add(new Word("lutti", "one", R.drawable.number_one, R.raw.number_one));
        englishWords.add(new Word("otiiko", "two", R.drawable.number_two, R.raw.number_two));
        englishWords.add(new Word("tolookosu", "three", R.drawable.number_three, R.raw.number_three));
        englishWords.add(new Word("oyyisa", "four", R.drawable.number_four, R.raw.number_four));
        englishWords.add(new Word("massokka", "five", R.drawable.number_five, R.raw.number_five));
        englishWords.add(new Word("temmokka", "six", R.drawable.number_six, R.raw.number_six));
        englishWords.add(new Word("kenekaku", "seven", R.drawable.number_seven, R.raw.number_seven));
        englishWords.add(new Word("kawinta", "eight", R.drawable.number_eight, R.raw.number_eight));
        englishWords.add(new Word("wo’e", "nine", R.drawable.number_nine, R.raw.number_nine));
        englishWords.add(new Word("na’aacha", "ten", R.drawable.number_ten, R.raw.number_ten));

        // Use a custom ArrayAdapter to fill the ListView with word items
        WordAdapter adapter = new WordAdapter(getActivity(), englishWords, R.color.category_numbers);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        // Request AudioFocus
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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
