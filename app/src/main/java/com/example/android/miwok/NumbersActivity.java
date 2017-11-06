/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    // Save into a private variable to save resources
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Release media file when completed playing
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

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
        WordAdapter adapter = new WordAdapter(this, englishWords, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        /*
        AudioManager audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        AudioManager.OnAudioFocusChangeListener focusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int i) {

            }
        };

        AudioFocusRequest audioFocusRequest = new AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
                .setFocusGain(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
                .setOnAudioFocusChangeListener(focusChangeListener).build();

        audioManager.requestAudioFocus(audioFocusRequest);
        audioManager.abandonAudioFocusRequest(audioFocusRequest);
        */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = englishWords.get(position);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getSoundResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        // Release media file when completed playing
                        mediaPlayer.release();
                    }
                });
            }
        });
    }

    /**
     * Releases the media resource when the app is stopped
     */
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Releases the media file used by the MediaPlayer and sets it to null if a resource is still being played
     */
    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
