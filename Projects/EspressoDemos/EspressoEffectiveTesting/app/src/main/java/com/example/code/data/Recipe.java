package com.example.code.data;

import java.io.InputStream;

public class Recipe {
    public final String id;
    public final String title;
    public final String description;

    private Recipe(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    /**
     * Method to read from stream from the assets folder
     * @param stream
     * @return
     */
    public static Recipe readFromStream(InputStream stream) {
        String id = null;
        String title = null;
        StringBuilder description = new StringBuilder();

        return new Recipe(id,title,description.toString());
    }

}
