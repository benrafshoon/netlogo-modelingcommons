package com.benraf.modelingcommons;

import java.awt.image.BufferedImage;

public class ModelFromModelingCommons {
    private int id;
    private String title;
    private String modelBody;
    private BufferedImage previewImage;

    public ModelFromModelingCommons(int id, String title, String modelBody, BufferedImage previewImage) {
        this.id = id;
        this.title = title;
        this.modelBody = modelBody;
        this.previewImage = previewImage;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getModelBody() {
        return modelBody;
    }

    public BufferedImage getPreviewImage() {
        return previewImage;
    }
}
