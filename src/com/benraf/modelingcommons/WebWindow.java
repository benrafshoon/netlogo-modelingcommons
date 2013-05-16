package com.benraf.modelingcommons;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 5/16/13
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class WebWindow extends JDialog {
    private JPanel topLevelContainer;

    private JFXPanel javaFXPanel;

    public WebWindow(Frame frame, String windowTitle) {
        super(frame, windowTitle, true);
        topLevelContainer = new JPanel();
        setContentPane(topLevelContainer);

        topLevelContainer.setLayout(new BorderLayout());
        javaFXPanel = new JFXPanel();
        topLevelContainer.add(javaFXPanel, BorderLayout.CENTER);
        this.setSize(500, 600);

        Platform.runLater(new Runnable() {
            public void run() {
                StackPane root  = new StackPane();
                Scene scene = new Scene(root);
                WebView browser = new WebView();
                final WebEngine webEngine = browser.getEngine();
                root.getChildren().add(browser);
                javaFXPanel.setScene(scene);
                webEngine.load("http://localhost:3000/");
                Worker<Void> pageProgress = webEngine.getLoadWorker();
                pageProgress.stateProperty().addListener(new ChangeListener<Worker.State>() {
                  public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State oldState, Worker.State newState) {
                      if(newState == Worker.State.SUCCEEDED) {
                          System.out.println("Page loaded");
                      } else {
                          System.out.println(newState);
                      }
                  }

                });
                /*final WebEngine downloadEngine = new WebEngine("http://localhost:3000/browse/model_contents/3588");
                Worker<Void> pageProgress = downloadEngine.getLoadWorker();
                pageProgress.stateProperty().addListener(new ChangeListener<Worker.State>() {
                    public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State oldState, Worker.State newState) {
                        System.out.println(newState);
                        Platform.runLater(new Runnable() {

                            public void run() {
                                Document document = downloadEngine.getDocument();
                                Element element = document.getDocumentElement();
                                System.out.println("Got document");
                                printTree(element, 0);

                            }
                        });
                        if (newState == Worker.State.SUCCEEDED) {
                            System.out.println("Page loaded");
                        }
                    }

                });
*/
            }
        });
    }

    static void printTree(Node node, int depth) {
        if(node == null) {
            return;
        } else {
            for(int i = 0; i < depth; i++) {
                System.out.print(" ");
            }
            System.out.println(node.getNodeName());
            for(int i = 0; i < depth; i++) {
                System.out.print(" ");
            }
            System.out.println(node.getNodeType());
            for(int i = 0; i < depth; i++) {
                System.out.print(" ");
            }
            System.out.println(node.getNodeValue());

            NodeList children = node.getChildNodes();
            for(int i = 0; i < children.getLength(); i++) {
                printTree(children.item(i), depth + 1);

            }
        }
    }

    private String getModelBody() {
        return null;
    }
}
