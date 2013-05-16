package com.benraf.modelingcommons;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.web.WebEngine;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 5/16/13
 * Time: 6:05 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ModelDownloader {
    private WebEngine webEngine;
    public ModelDownloader() {

    }

    public void downloadModel(String modelURL) {
        System.out.println("Starting download");
        webEngine = new WebEngine(modelURL);
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State oldState, Worker.State newState) {
                if(newState.equals(Worker.State.SUCCEEDED)) {
                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            Document document = webEngine.getDocument();
                            Node body = document.getElementsByTagName("BODY").item(0);
                            Node textNode = getFirstTextNode(body);
                            onSuccess(textNode.getNodeValue());
                        }
                    });
                } else {
                    System.out.println(newState);
                }
            }
        });
    }

    public abstract void onSuccess(String string);

    private Node getFirstTextNode(Node node) {
        if(node == null) {
            return null;
        } else if(node.getNodeType() == Node.TEXT_NODE) {
            return node;
        } else {
            NodeList list = node.getChildNodes();
            for(int i = 0; i < list.getLength(); i++) {
                Node childNode = getFirstTextNode(list.item(i));
                if(childNode!= null) {
                    return childNode;
                }
            }
            return null;
        }
    }
}
