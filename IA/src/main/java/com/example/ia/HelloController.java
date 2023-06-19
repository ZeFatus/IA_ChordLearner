package com.example.ia;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.beans.PropertyChangeSupport;
import java.io.IOException;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;


public class HelloController {

    public static final ObjectProperty<Mixer> mixerProperty = new SimpleObjectProperty<>(null);
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);


    public Label selectMic = new Label("Select a input device");

    @FXML
    private ComboBox<String> micbox;

    private Mixer mixer;
    public void initialize() {
        selectMic.setVisible(false);
        // get a list of available mixer devices
        Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();

        // add the mixer device names to the ComboBox
        for (Mixer.Info mixerInfo : mixerInfos) {
            mixer = AudioSystem.getMixer(mixerInfo);
            if (mixer.getTargetLineInfo().length != 0) {
                micbox.getItems().add(mixerInfo.getName());
            }
        }
        micbox.setOnAction(event -> {
            Mixer newValue;
            String stringValue = micbox.getSelectionModel().getSelectedItem();
            for (Mixer.Info mixerInfo : mixerInfos) {
                if (stringValue == mixerInfo.getName()) {
                    newValue = AudioSystem.getMixer(mixerInfo);
                    mixerProperty.set(newValue);
                    Mixer oldValue =mixerProperty.get();
                    MainClass.input(newValue, stringValue);
                    System.out.println(MainClass.printmic()+" "+ MainClass.micName);
                    pcs.firePropertyChange("mixer", oldValue, newValue);
                }
            }


            //HelloApplication.input(micbox.getSelectionModel().getSelectedItem());
            //System.out.println(HelloApplication.printmic());  });
        }
        );

    }


    @FXML
    protected void MC()throws IOException{
        if (MainClass.printmic()!=""){
            MainClass.setRoot("MC");
        }
else{
    selectMic.setVisible(true);
        }
    }

    @FXML
protected void SC()throws IOException {

        if (MainClass.printmic()!=""){
            MainClass.setRoot("SC");
        }
        else{
            selectMic.setVisible(true);
        }
    }

}