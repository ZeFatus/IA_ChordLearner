package com.example.ia;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.pitch.PitchProcessor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;

public class ControllerMCPractice extends PitchDetectionPanel {

    public VBox detectionVBox;

    private AudioDispatcher dispatcher;
    private Mixer currentMixer;

    private PitchProcessor.PitchEstimationAlgorithm algo;

    @FXML
    public javafx.scene.control.Label NoteView;

    @FXML
    private ListView displayFeedback1 = new ListView();
    @FXML
    private ListView displayFeedback2 = new ListView();
    @FXML
    private ListView displayFeedback3 = new ListView();
    @FXML
    private ListView displayFeedback4 = new ListView();

    private ArrayList<String> feedback1 = new ArrayList<>();
    private ArrayList<String> feedback2 = new ArrayList<>();
    private ArrayList<String> feedback3 = new ArrayList<>();
    private ArrayList<String> feedback4 = new ArrayList<>();

    @FXML
    private Label results = new Label();
    @FXML
    private Label chordPlayed1 = new Label();
    @FXML
    private Label chordPlayed2 = new Label();
    @FXML
    private Label chordPlayed3 = new Label();
    @FXML
    private Label chordPlayed4 = new Label();

    @FXML
    private Label chord1 = new Label("");
    @FXML
    private Label chord2 = new Label("");
    @FXML
    private Label chord3 = new Label("");
    @FXML
    private Label chord4 = new Label("");

    @FXML
    private Label index1 = new Label();
    @FXML
    private Label index2 = new Label();
    @FXML
    private Label index3 = new Label();
    @FXML
    private Label index4 = new Label();

    @FXML
    Button practiceOne = new Button();
    @FXML
    Button practiceTwo = new Button();
    @FXML
    Button practiceThree = new Button();
    @FXML
    Button practiceFour = new Button();

    public void initialize() throws UnsupportedAudioFileException, LineUnavailableException {



displayFeedback1.setVisible(false);
displayFeedback2.setVisible(false);
displayFeedback3.setVisible(false);
displayFeedback4.setVisible(false);

chordPlayed1.setVisible(false);
chordPlayed2.setVisible(false);
chordPlayed3.setVisible(false);
chordPlayed4.setVisible(false);

practiceOne.setVisible(false);
practiceTwo.setVisible(false);
practiceThree.setVisible(false);
practiceFour.setVisible(false);

clearIndex();

for(int i = 0; i < MainClass.chords.size(); i++){
    switch (i){
        case 0: chord1.setText((String) MainClass.chords.get(i));
        break;
        case 1: chord2.setText((String) MainClass.chords.get(i));
            break;
        case 2: chord3.setText((String) MainClass.chords.get(i));
            break;
        case 3: chord4.setText((String) MainClass.chords.get(i));
            break;
    }

}

    }

    private void clearIndex(){
        index1.setVisible(false);
        index2.setVisible(false);
        index3.setVisible(false);
        index4.setVisible(false);
    }

//The code below occurs when the user selects to start the
// multiple chord practice
    @FXML
    private void startPractice() {
        //Creates a thread on which to execute the audio detector
        Task<Void> practiceTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                //Repeated for every chord selected by the user
                for (int i = 0; i < MainClass.chords.size(); i++) {

                    //The line below establish the names and frequencies of
                    // the different notes within the current chord
                    String chord = (String) MainClass.chords.get(i);
                    ChordMaker ChordData = new ChordMaker(chord);
                    String[] noteNames = ChordData.getNoteNames();
                    double[] NoteFrequencies = ChordData.getNoteFrequencies();

                    //The switch statement below indicates to the user which
                    // chord is being practiced by updating labels in the GUI
                    switch (i){
                        case 0:clearIndex();
                        index1.setVisible(true);
                        break;
                        case 1:clearIndex();
                            index2.setVisible(true);
                            break;
                        case 2:clearIndex();
                            index3.setVisible(true);
                            break;
                        case 3:clearIndex();
                            index4.setVisible(true);
                            break;
                    }

                    // Repeated for each note within the current chord
                    for (int j = 0; j < ChordData.getNoteNames().length; j++) {
                        final int index = j;
                        String noteName = noteNames[j];

                        // Update a label in the GUI to indicate the current note that has to be played
                        // by setting this task on a separate thread
                        javafx.application.Platform.runLater(() -> NoteView.setText("Play " + noteName));

                        note = false;
                        frequency = NoteFrequencies[j];

                        try {
                            setNewMixer(MainClass.mic);
                        } catch (LineUnavailableException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Chord finished");

                    switch (i){
                        case 0:
                            for(int j =0;j<noteNames.length; j++){
                                feedback1.add((noteNames[j]+": "+correctNotes.get(j).toString()));
                            }
                            correctNotes.clear();
                            break;
                        case 1:
                            for(int j =0;j<noteNames.length; j++){
                                feedback2.add((noteNames[j]+": "+correctNotes.get(j).toString()));
                            }
                            correctNotes.clear();
                            break;
                        case 2:
                            for(int j =0;j<noteNames.length; j++){
                                feedback3.add((noteNames[j]+": "+correctNotes.get(j).toString()));
                            }
                            correctNotes.clear();
                            break;
                        case 3:
                            for(int j =0;j<noteNames.length; j++){
                                feedback4.add((noteNames[j]+": "+correctNotes.get(j).toString()));
                            }
                            correctNotes.clear();
                            break;
                    }

                }

                return null;
            }
        };

        //The code below is executed once the task run on the thread has finished
        practiceTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                // Task completed successfully
                clearIndex();
                NoteView.setText("Practice completed");
                int practiceSize = MainClass.chords.size();

                {
                    //The code below display the results of the user's practice
                    displayFeedback1.setVisible(true);
                    chordPlayed1.setText((String) MainClass.chords.get(0));
                    chordPlayed1.setVisible(true);
                    ObservableList<String> observableList = FXCollections.observableArrayList(feedback1);
                    displayFeedback1.setItems(observableList);
                    practiceOne.setVisible(true);
                    practiceOne.setText("Practice: "+(String) MainClass.chords.get(0));

                    displayFeedback2.setVisible(true);
                    chordPlayed2.setText((String) MainClass.chords.get(1));
                    chordPlayed2.setVisible(true);
                    ObservableList<String> observableList2 = FXCollections.observableArrayList(feedback2);
                    displayFeedback2.setItems(observableList2);
                    practiceTwo.setVisible(true);
                    practiceTwo.setText("Practice: "+(String) MainClass.chords.get(1));
                }
                if(practiceSize>2){
                    displayFeedback3.setVisible(true);
                    chordPlayed3.setText((String) MainClass.chords.get(2));
                    chordPlayed3.setVisible(true);
                    ObservableList<String> observableList = FXCollections.observableArrayList(feedback3);
                    displayFeedback3.setItems(observableList);
                    practiceThree.setVisible(true);
                    practiceThree.setText("Practice: "+(String) MainClass.chords.get(2));
                }
                if(practiceSize>3){
                    displayFeedback4.setVisible(true);
                    chordPlayed4.setText((String) MainClass.chords.get(3));
                    chordPlayed4.setVisible(true);
                    ObservableList<String> observableList = FXCollections.observableArrayList(feedback4);
                    displayFeedback4.setItems(observableList);
                    practiceFour.setVisible(true);
                    practiceFour.setText("Practice: "+(String) MainClass.chords.get(3));
                }



            }
        });

        new Thread(practiceTask).start();
    }

@FXML
protected void practice(ActionEvent event)throws IOException{
    Button clickedButton = (Button) event.getSource();
int index = 0;
    String source = clickedButton.getId();
    switch (source){
        case "practiceOne":index = 0;
        break;
        case "practiceTwo":index = 1;
        break;
        case "practiceThree":index = 2;
            break;
        case "practiceFour":index = 3;
            break;
    }

    String tempChord = (String) MainClass.chords.get(index);
        MainClass.chords.clear();
        MainClass.chords.add(tempChord);
        MainClass.setRoot("SCPractice");
}


    @FXML
    protected void backtomenu()throws IOException {

        MainClass.setRoot("MC");
        MainClass.chords.clear();


    }



}
