package com.example.ia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class ControllerSC  {

    Button button1 = new Button("Button 1");


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



    public void initialize(){




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
        }


    @FXML
    private Label welcomeText;
/*
    @FXML
    protected void backtomenu()throws IOException {

        HelloApplication.setRoot("hello-view");


    }
 */
@FXML
private void backToMenu()throws IOException{
    MainClass.setRoot("hello-view");
}



    @FXML
    public void SCcontinue(ActionEvent event) throws IOException {

        Button clickedButton = (Button) event.getSource();
        String text = clickedButton.getText();
        MainClass.chords.add(text);

        //System.out.println("chord name: "+chord);
        //System.out.println("text name: "+text);



        MainClass.setRoot("SCPractice");
    }

/*
   @FXML
    protected void pC_Major()throws IOException{
        HelloApplication.setRoot("SCPractice");
        chord = "/Images/C-chord-265x300.png";


   }


 */

}