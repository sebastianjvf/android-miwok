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

public class FamilyActivity extends AppCompatActivity {

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
        WordAdapter adapter = new WordAdapter(this, englishWords, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = englishWords.get(position);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getSoundResourceId());
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
     * Releases the media file used by the MediaPlayer and sets it to null if a resource is still being played
     */
    private void releaseMediaPlayer() {
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
