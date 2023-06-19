package com.example.ia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerMC {
    
        public ImageView c_chord;
        public ImageView d_chord;
        public ImageView e_chord;
        public ImageView f_chord;
        public ImageView g_chord;
        public ImageView a_chord;
        public ImageView b_chord;
        public ImageView dm_chord;
        public ImageView em_chord;
        public ImageView fm_chord;
        public ImageView am_chord;
        public ImageView bm_chord;

    public Label atLeast = new Label("Choose at least two chords  to continue");

    private ArrayList MCchords = new ArrayList();
    public static ObservableList<String> chordsObservableList = FXCollections.observableArrayList();


    @FXML
    private ListView<String> chordsListView;



    public void initialize() throws IOException {

System.out.println(MCchords.size());

        //problem

        chordsListView.setItems(chordsObservableList);


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
        atLeast.setVisible(false);

    }



//The method below is activated once the user selects
//"Continue" in the multiple chord selection screen
//to begin with his practice
    @FXML
    private void MCContinue()throws IOException{

        //"MCchords" is a temporary Arraylist used
        // to hold the user's selected chords
        if(MCchords.size()>1){

            //Each of the user's selected chords in "MCchords" are
            //passed into the public static Arraylist "chords" in "MainClass"
            //to be accessed throughout the user's practice
           for(int i = 0; i < MCchords.size(); i++){
               MainClass.chords.add(MCchords.get(i));
           }
           //The method "clearList()" clears the
            //MCchords Arraylist
           clearList();
MainClass.setRoot("MCPractice");
        }
        else{
atLeast.setVisible(true);
//Shows a label indicating the user to select at least two chords
        }
    }



@FXML
protected void clearList(){
        MCchords.clear();
        chordsObservableList.clear();
}

    @FXML
    protected void addChord(String Chord){
        MCchords.add(Chord);
        chordsObservableList.add(Chord);

    }

    @FXML
    protected void backtomenu()throws IOException {


clearList();
        MainClass.setRoot("hello-view");
    }

    public void MC(ActionEvent actionEvent) {
    }

    @FXML
    protected void addC_chord() throws IOException {
        if (MCchords.size() != 4){
            addChord("C Major");}
        else{
            System.out.println("Im full ._.");
        }
    }

    @FXML
    protected void addD_chord() throws IOException {
        if (MCchords.size() != 4){
            addChord("D Major");}
        else{
            System.out.println("Im full ._.");}
    }

    @FXML
    protected void addE_chord() throws IOException {
        if (MCchords.size() != 4){
            addChord("E Major");}
        else{
            System.out.println("Im full ._.");}
    }

    @FXML
    protected void addF_chord() throws IOException {
        if (MCchords.size() != 4) {
            addChord("F Major");
        }
    }

    @FXML
    protected void addG_chord() throws IOException {
        if (MCchords.size() != 4) {
            addChord("G Major");
        }
    }

    @FXML
    protected void addA_chord() throws IOException {
        if (MCchords.size() != 4) {
            addChord("A Major");
        }
    }

    @FXML
    protected void addB_chord() throws IOException {
        if (MCchords.size() != 4) {
            addChord("B Major");
        }
    }

    // minor chords


    @FXML
    protected void addDm_chord() throws IOException {
        if (MCchords.size() != 4) {
            addChord("D Minor");
        }
    }

    @FXML
    protected void addEm_chord() throws IOException {
        if (MCchords.size() != 4) {
            addChord("E Minor");
        }
    }

    @FXML
    protected void addFm_chord() throws IOException {
        if (MCchords.size() != 4) {
            addChord("F Minor");
        }
    }


    @FXML
    protected void addAm_chord() throws IOException {
        if (MCchords.size() != 4) {
            addChord("A Minor");
        }
    }

    @FXML
    protected void addBm_chord() throws IOException {
        if (MCchords.size() != 4) {
            addChord("B Minor");
        }
    }


    public void setChordsListView(ListView<String> chordsListView) {
        this.chordsListView = chordsListView;
    }
}