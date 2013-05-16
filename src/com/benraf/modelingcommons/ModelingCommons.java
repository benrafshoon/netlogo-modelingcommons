package com.benraf.modelingcommons;

import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 5/3/13
 * Time: 7:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ModelingCommons {
    public static void main(String[] args) {
        System.out.println("test");
    }

    public ModelFromModelingCommons openModel() {
        System.out.println("Opening from modeling commons");
        return null;
    }

    public void saveNewModel(String title, String modelBody, BufferedImage currentImage) {
        System.out.println("Saving to modeling commons");
    }

    public void saveNewVersionOfExistingModel(String title, String modelBody, BufferedImage currentImage, Integer existingModelID) {
        System.out.println("Saving new version of existing model");
    }

    public void forkModel(String title, String modelBody, BufferedImage currentImage, Integer existingModelID) {
        System.out.println("Forking model");
    }

}
