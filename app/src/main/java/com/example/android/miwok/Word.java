package com.example.android.miwok;

public class Word {

    String miwokTranslation;
    String defaultTranslation;

    /**
     * Creates a word object encapsulating a miwok word and its translation. Use a string resource to
     * allow for easy translation.
     *
     * @param miwokTranslation
     * @param defaultTranslation
     */
    public Word(String miwokTranslation, String defaultTranslation) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

}
