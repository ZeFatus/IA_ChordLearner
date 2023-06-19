package com.example.ia;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import javax.sound.sampled.Mixer;
import java.io.IOException;
import java.util.ArrayList;


public class MainClass extends Application {


    public static Mixer mic;
public static String micName;
/*Variables for selected Microphone device name
and data are public static, making them accessible
across all classes
 */
public static void input(Mixer mixer, String name){
    mic = mixer; micName=name;
//Constructor/setter for variables
}
public static String printmic(){
    if (mic == null){
        return "";
    }
    else {
        return mic.toString();
        //returns String value of Mic data
    }
}


public static ArrayList chords = new ArrayList();
    private static Scene scene;

   static void setRoot(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource(fxml + ".fxml"));
        scene.setRoot(fxmlLoader.load());
    }



      public ObservableList<Mixer.Info> mixerList;
   @Override
    public void start(Stage stage) throws IOException {


       FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("hello-view.fxml"));
       scene = new Scene(fxmlLoader.load(), 1080, 720);

       ComboBox<String> comboBox = new ComboBox<>();

       comboBox.setPromptText("Select a microphone");

       stage.setScene(scene);
       stage.show();
   }




    public static void main(String[] args) {
        launch(args);
    }
}