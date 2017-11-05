package com.example.android.miwok;

public class Word {

    String miwokTranslation;
    String defaultTranslation;
    int resourceId;

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
        this.resourceId = -1;
    }

    /**
     * Creates a word object encapsulating a miwok word, its translation and an ImageResourceID. Use a string resource to
     * allow for easy translation.
     *
     * @param miwokTranslation
     * @param defaultTranslation
     */
    public Word(String miwokTranslation, String defaultTranslation, int resourceId) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.resourceId = resourceId;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public int getResourceId() {
        return resourceId;
    }

}
