package com.example.android.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class VocabularyActivity extends AppCompatActivity {

    protected MediaPlayer mediaPlayer;

    // Save into a private variable to save resources
    protected MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Release media file when completed playing
            releaseMediaPlayer();
        }
    };

    protected AudioManager audioManager;
    protected AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                Log.v("1111111111", "fired #1");
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // Permanently lost focus; release MediaPlayer and stop playing.
                releaseMediaPlayer();
                Log.v("1111111111", "fired #2");
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                Log.v("1111111111", "fired #3");
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
                Log.v("1111111111", "fired #4");
            }

            Log.v("1111111111", "fired #3");
        }
    };

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
    protected void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;

            // Abandon AudioFocus
            audioManager.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }
}
