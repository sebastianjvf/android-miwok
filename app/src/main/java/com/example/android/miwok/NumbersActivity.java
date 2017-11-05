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

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Add words and their translations to the numbers list
        ArrayList<Word> englishWords = new ArrayList<Word>();
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
    }
}
