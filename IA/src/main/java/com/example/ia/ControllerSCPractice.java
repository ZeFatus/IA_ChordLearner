package com.example.ia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.*;
import java.io.IOException;


import javax.sound.sampled.LineUnavailableException;

public class ControllerSCPractice extends PitchDetectionPanel{

    public javafx.scene.control.Label welcomeText;

    @FXML
        public javafx.scene.control.Label NoteView;
    @FXML
    private Label chordPlayed = new Label();

@FXML
private ListView displayFeedback = new ListView();
    private ArrayList<String> feedback = new ArrayList<>();

    String selection = (String) MainClass.chords.get(0);

public ImageView SelectedImage;


@FXML
private static Pane myPane = new Pane();

    public void initialize()  {
        displayFeedback.setVisible(false);
        chordPlayed.setText("Notes played correctly");
chordPlayed.setVisible(false);

        if (Objects.equals(selection, "C Major")) {
            System.out.println("yes");
            SelectedImage.setImage(new Image(getClass().getResource("/Images/C-chord-265x300.png").toExternalForm()));
        } else if (Objects.equals(selection, "D Major")) {
            System.out.println(selection);
            SelectedImage.setImage(new Image(getClass().getResource("/Images/D-2-265x300.png").toExternalForm()));
        } else if (Objects.equals(selection, "E Major")) {
            System.out.println(selection);
            SelectedImage.setImage(new Image(getClass().getResource("/Images/E-3-265x300.png").toExternalForm()));
        } else if (Objects.equals(selection, "F Major")) {
            System.out.println(selection);
            SelectedImage.setImage(new Image(getClass().getResource("/Images/F-1-290x300.png").toExternalForm()));
        } else if (Objects.equals(selection, "G Major")) {
            System.out.println(selection);
            SelectedImage.setImage(new Image(getClass().getResource("/Images/G-1-265x300.png").toExternalForm()));
        } else if (Objects.equals(selection, "A Major")) {
            System.out.println(selection);
            SelectedImage.setImage(new Image(getClass().getResource("/Images/A-2-265x300.png").toExternalForm()));
        } else if (Objects.equals(selection, "B Major")) {
            System.out.println(selection);
            SelectedImage.setImage(new Image(getClass().getResource("/Images/B-2-265x300.png").toExternalForm()));
        } else if (Objects.equals(selection, "D Minor")) {
            System.out.println(selection);
            SelectedImage.setImage(new Image(getClass().getResource("/Images/Dm-1-265x300.png").toExternalForm()));
        } else if (Objects.equals(selection, "E Minor")) {
            System.out.println(selection);
            SelectedImage.setImage(new Image(getClass().getResource("/Images/Em-1-265x300.png").toExternalForm()));
        } else if (Objects.equals(selection, "F Minor")) {
            System.out.println(selection);
            SelectedImage.setImage(new Image(getClass().getResource("/Images/Fm-290x300.png").toExternalForm()));
        } else if (Objects.equals(selection, "A Minor")) {
            System.out.println(selection);
            SelectedImage.setImage(new Image(getClass().getResource("/Images/Am-265x300.png").toExternalForm()));
        } else if (Objects.equals(selection, "B Minor")) {
            System.out.println(selection);
            SelectedImage.setImage(new Image(getClass().getResource("/Images/Bm-265x300.png").toExternalForm()));
        }


        System.out.println("practice: " + selection);
/*
        c_chord.setImage(new Image(getClass().getResource("/Images/C-chord-265x300.png").toExternalForm()));
        d_chord.setImage(new Image(getClass().getResource("/Images/D-2-265x300.png").toExternalForm()));
        e_chord.setImage(new Image(getClass().getResource("/Images/E-3-265x300.png").toExternalForm()));
        f_chord.setImage(new Image(getClass().getResource("/Images/F-1-290x300.png").toExternalForm()));
        g_chord.setImage(new Image(getClass().getResource("/Images/G-1-265x300.png").toExternalForm()));
        a_chord.setImage(new Image(getClass().getResource("/Images/A-2-265x300.png").toExternalForm()));
        b_chord.setImage(new Image(getClass().getResource("/Images/B-2-265x300.png").toExternalForm()));
        dm_chord.setImage(new Image(getClass().getResource("/Images/Dm-1-265x300.png").toExternalForm()));
        em_chord.setImage(new Image(getClass().getResource("/Images/Em-1-265x300.png").toExternalForm()));
        fm_chord.setImage(new Image(getClass().getResource("/Images/Fm-290x300.png").toExternalForm()));
        am_chord.setImage(new Image(getClass().getResource("/Images/Am-265x300.png").toExternalForm()));
        bm_chord.setImage(new Image(getClass().getResource("/Images/Bm-265x300.png").toExternalForm()));
*/



        System.out.println("Added pitch detection Panel");


    }

    //Code for practicing a single chord
    @FXML
    private void startPractice() {
        displayFeedback.setVisible(false);
        feedback.clear();
        chordPlayed.setVisible(false);

        Task<Void> practiceTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                    /*The lines below establish the names and frequencies
                    of every note in the chord through the class "ChordMaker"*/
                    String chord = (String) MainClass.chords.get(0);
                    ChordMaker ChordData = new ChordMaker(chord);
                    String[] NoteNames = ChordData.getNoteNames();
                    double[] NoteFrequencies = ChordData.getNoteFrequencies();
                    System.out.println("Searching for chord: "+chord);

                    // Searches through every note within a chord
                    for (int j = 0; j < ChordData.getNoteNames().length; j++) {
                        String noteName = NoteNames[j];

                        // The lines below update the label on the GUI by
                        // using a separate thread
                        javafx.application.Platform.runLater(() -> NoteView.setText("Play " + noteName));
                        note = false;
                        frequency = NoteFrequencies[j];
                        System.out.println("play note " + NoteNames[j]);
                        System.out.println("Searching for " + frequency);

                        //The lines below use the method "setNewMixer" inherited from class
                        //PitchDetectionPanel. This method gathers audio frequency data for
                        //one second, and uses the public static variable "frequency" established
                        //above the validate whether a note has been correctly played.
                        try {
                            setNewMixer(MainClass.mic);
                        } catch (LineUnavailableException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Chord finished");
                return null;
            }
        };

        practiceTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                // Task completed successfully
                System.out.println("Practice completed");
                NoteView.setText("Practice completed");

                String chord = (String) MainClass.chords.get(0);
                ChordMaker ChordData = new ChordMaker(chord);
                String[] noteNames = ChordData.getNoteNames();
                for(int g = 0; g<noteNames.length; g++){
feedback.add((noteNames[g]+": "+correctNotes.get(g).toString()));
                }

                displayFeedback.setVisible(true);
                chordPlayed.setVisible(true);
                ObservableList<String> observableList = FXCollections.observableArrayList(feedback);
                displayFeedback.setItems(observableList);

            }
        });

        new Thread(practiceTask).start();
    }









    @FXML
    protected void backtomenu()throws IOException {
MainClass.chords.clear();
        MainClass.setRoot("SC");
    }



}
