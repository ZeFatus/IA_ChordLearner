package com.example.ia;

import java.util.Arrays;

public class ChordMaker{

    //Private arrays for the notes in a chord
    // and the frequency of each note
   private String[] noteNames;
   private double[] noteFrequencies;

//Constructor
    public ChordMaker(String chord){

        //When an instance of the class is created, a string value is
        //taken in as a parameter. This string represents the name of
        //a chord, and it is used to define the names and frequencies of
        //the notes in the chord with the methods below
        noteNames = setNoteNames(chord);
        noteFrequencies = setChordNotes(chord);

    }

    public String[] getNoteNames(){
        return noteNames;
    }
    public double[] getNoteFrequencies(){
        return noteFrequencies;
    }


    private double[] setChordNotes(String chord){


        double[] chordNotes;


        switch (chord) {
            case "C Major":
                chordNotes = new double[5];


                chordNotes[0] = 130.81; // frequency of C3

                chordNotes[1] = 164.81; // frequency of E3

                chordNotes[2] = 196.00; // frequency of G3

                chordNotes[3] = 261.63; // frequency of C4

                chordNotes[4] = 329.63; // frequency of E4

                break;
            case "D Major":
                chordNotes = new double[4];


                chordNotes[0] = 146.83; // frequency of D3

                chordNotes[1] = 220.00; // frequency of A3

                chordNotes[2] = 293.66; // frequency of D4

                chordNotes[3] = 369.99; // frequency of F#4

                break;
            case "E Major":
                chordNotes = new double[6];


                chordNotes[0] = 82.41;  // frequency of E2

                chordNotes[1] = 123.47; // frequency of B2

                chordNotes[2] = 164.81; // frequency of E3

                chordNotes[3] = 207.65; // frequency of G#3

                chordNotes[4] = 246.94; // frequency of B3

                chordNotes[5] = 329.63; // frequency of E4

                break;
            case "F Major":
                chordNotes = new double[6];


                chordNotes[0] = 87.31; // frequency of F2

                chordNotes[1] = 130.81; // frequency of C3

                chordNotes[2] = 174.61; // frequency of F3

                chordNotes[3] = 220.00; // frequency of A3

                chordNotes[4] = 261.63; // frequency of C4

                chordNotes[5] = 349.23; // frequency of F4

                break;
            case "G Major":
                chordNotes = new double[6];


                chordNotes[0] = 97.999; // frequency of G2

                chordNotes[1] = 123.471; // frequency of B2

                chordNotes[2] = 146.832; // frequency of D3

                chordNotes[3] = 195.998; // frequency of G3

                chordNotes[4] = 293.665; // frequency of D4

                chordNotes[5] = 392.00; // frequency of G4

                break;
            case "A Major":
                chordNotes = new double[5];

                chordNotes[0] = 110.00; // frequency of A2

                chordNotes[1] = 164.81; // frequency of E3

                chordNotes[2] = 220.00; // frequency of A3

                chordNotes[3] = 277.18; // frequency of C#4

                chordNotes[4] = 329.63; // frequency of E4


                break;
            case "B Major":
                chordNotes = new double[5];


                chordNotes[0] = 123.47; // frequency of B2

                chordNotes[1] = 185.00; // frequency of F#3

                chordNotes[2] = 246.94; // frequency of B3

                chordNotes[3] = 311.13; // frequency of D#4

                chordNotes[4] = 369.99; // frequency of F#4


                break;
            case "D Minor":
                chordNotes = new double[4];


                chordNotes[0] = 146.83; // frequency of D3

                chordNotes[1] = 220.00; // frequency of A3

                chordNotes[2] = 293.66; // frequency of D4

                chordNotes[3] = 349.23; // frequency of F4

                break;
            case "E Minor":
                chordNotes = new double[6];


                chordNotes[0] = 82.41; // frequency of E2

                chordNotes[1] = 98.00; // frequency of G2

                chordNotes[2] = 123.47; // frequency of B2

                chordNotes[3] = 164.81; // frequency of E3

                chordNotes[4] = 196.00; // frequency of G3

                chordNotes[5] = 329.63; // frequency of E4


                break;
            case "F Minor":
                chordNotes = new double[6];

                chordNotes[0] = 87.31;  // frequency of F2

                chordNotes[1] = 130.81; // frequency of C3

                chordNotes[2] = 174.61; // frequency of F3

                chordNotes[3] = 207.65; // frequency of G#3

                chordNotes[4] = 261.63; // frequency of C4

                chordNotes[5] = 349.23; // frequency of F4


                break;
            case "A Minor":
                chordNotes = new double[5];


                chordNotes[0] = 110.00; // frequency of A2

                chordNotes[1] = 164.81; // frequency of E3

                chordNotes[2] = 220.00; // frequency of A3

                chordNotes[3] = 261.63; // frequency of C4

                chordNotes[4] = 329.63; // frequency of E4


                break;
            default:
                chordNotes = new double[5];

                chordNotes[0] = 123.47; // frequency of B2

                chordNotes[1] = 185.00; // frequency of F#3

                chordNotes[2] = 246.94; // frequency of B3

                chordNotes[3] = 293.66; // frequency of D4

                chordNotes[4] = 369.99; // frequency of F#4

                break;
        }
        System.out.println(Arrays.toString(chordNotes));
        return chordNotes;  }

    private String[] setNoteNames(String theChord){
        String[] noteNames;
        String chord = theChord;
        System.out.println("HelloChord:"+chord+":");

        switch (chord) {
            case "C Major":
                System.out.println("Successss");
                noteNames = new String[5];

                noteNames[0] = "C3";
                noteNames[1] = "E3";
                noteNames[2] = "G3";
                noteNames[3] = "C4";
                noteNames[4] = "E4";
                break;
            case "D Major":
                noteNames = new String[4];

                noteNames[0] = "D3";
                noteNames[1] = "A3";
                noteNames[2] = "D4";
                noteNames[3] = "F#4";

                break;
            case "E Major":

                noteNames = new String[6];

                noteNames[0] = "E2";
                noteNames[1] = "B2";
                noteNames[2] = "E3";
                noteNames[3] = "G#3";
                noteNames[4] = "B3";
                noteNames[5] = "E4";

                break;
            case "F Major":
                noteNames = new String[6];

                noteNames[0] = "F2";
                noteNames[1] = "C3";
                noteNames[2] = "F3";
                noteNames[3] = "A3";
                noteNames[4] = "C4";
                noteNames[5] = "F4";
                break;
            case "G Major":
                noteNames = new String[6];

                noteNames[0] = "G3";
                noteNames[1] = "B3";
                noteNames[2] = "D4";
                noteNames[3] = "G4";
                noteNames[4] = "B4";
                noteNames[5] = "D5";
                break;
            case "A Major":
                noteNames = new String[5];

                noteNames[0] = "A2";
                noteNames[1] = "E3";
                noteNames[2] = "A3";
                noteNames[3] = "C#4";
                noteNames[4] = "E4";

                break;
            case "B Major":
                noteNames = new String[5];

                noteNames[0] = "B2";
                noteNames[1] = "F#3";
                noteNames[2] = "B3";
                noteNames[3] = "D#4";
                noteNames[4] = "F#4";
                break;
            case "D Minor":
                noteNames = new String[4];

                noteNames[0] = "D3";
                noteNames[1] = "A3";
                noteNames[2] = "D4";
                noteNames[3] = "F4";

                break;
            case "E Minor":
                noteNames = new String[6];

                noteNames[0] = "E2";
                noteNames[1] = "G2";
                noteNames[2] = "B2";
                noteNames[3] = "E3";
                noteNames[4] = "G3";
                noteNames[5] = "E4";
                break;
            case "F Minor":
                noteNames = new String[6];

                noteNames[0] = "F2";
                noteNames[1] = "C3";
                noteNames[2] = "F3";
                noteNames[3] = "G#3";
                noteNames[4] = "C4";
                noteNames[5] = "F4";

                break;
            case "A Minor":
                noteNames = new String[5];

                noteNames[0] = "A2";
                noteNames[1] = "E3";
                noteNames[2] = "A3";
                noteNames[3] = "C4";
                noteNames[4] = "E4";

                break;
            default:
                noteNames = new String[5];

                noteNames[0] = "B2";
                noteNames[1] = "F#3";
                noteNames[2] = "B3";
                noteNames[3] = "D4";
                noteNames[4] = "F#4";

                break;

        }



        return noteNames;

    }

}
