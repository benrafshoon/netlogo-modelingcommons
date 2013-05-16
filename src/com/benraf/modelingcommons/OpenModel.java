package com.benraf.modelingcommons;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 5/14/13
 * Time: 1:26 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class OpenModel {
    public OpenModel() {

    }

    //Call to open the model selection interface
    public void openModel() {

    }

    //Called by modeling commons when the user has selected a model
    //modelBody is the downloaded nlogo file
    public abstract void onModelSelected(String modelBody);

    //Called by modeling commons when the user cancels selecting a model
    public abstract void onCancel();
}
