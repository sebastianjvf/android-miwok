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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Add words and their translations to the numbers list
        ArrayList<Word> englishWords = new ArrayList<Word>();
        englishWords.add(new Word("weṭeṭṭi", "red", R.drawable.color_red));
        englishWords.add(new Word("chokokki", "green", R.drawable.color_green));
        englishWords.add(new Word("ṭakaakki", "brown", R.drawable.color_brown));
        englishWords.add(new Word("ṭopoppi", "gray", R.drawable.color_gray));
        englishWords.add(new Word("kululli", "black", R.drawable.color_black));
        englishWords.add(new Word("kelelli", "white", R.drawable.color_white));
        englishWords.add(new Word("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow));
        englishWords.add(new Word("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow));

        // Use a custom ArrayAdapter to fill the ListView with word items
        WordAdapter adapter = new WordAdapter(this, englishWords, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
