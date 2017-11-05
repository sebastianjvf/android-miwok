package com.example.android.miwok;

public class Word {

    private String miwokTranslation;
    private String defaultTranslation;
    private int soundResourceId;
    private int imageResourceId = HAS_IMAGE;

    private static final int HAS_IMAGE = -1;

    /**
     * Creates a word object encapsulating a miwok word and its translation. Use a string resource to
     * allow for easy translation.
     *
     * @param miwokTranslation
     * @param defaultTranslation
     */
    public Word(String miwokTranslation, String defaultTranslation, int soundResourceId) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.soundResourceId = soundResourceId;
    }

    /**
     * Creates a word object encapsulating a miwok word, its translation and an ImageResourceID. Use a string resource to
     * allow for easy translation.
     *
     * @param miwokTranslation
     * @param defaultTranslation
     */
    public Word(String miwokTranslation, String defaultTranslation, int imageResourceId, int soundResourceId) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.imageResourceId = imageResourceId;
        this.soundResourceId = soundResourceId;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getSoundResourceId() { return soundResourceId; }
}
