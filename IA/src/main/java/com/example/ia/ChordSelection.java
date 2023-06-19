package com.example.ia;

public class ChordSelection {
    static String selection = "";

    public ChordSelection(String c){
        selection = c;
    }

    public static String getSelection(){
        return selection;
    }
    public void setSelection(String c){
        selection = c;
    }

}
