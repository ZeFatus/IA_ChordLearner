package com.example.ia;


import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.io.jvm.JVMAudioInputStream;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import javax.sound.sampled.*;
import java.util.ArrayList;


public class PitchDetectionPanel implements PitchDetectionHandler {

    private static AudioDispatcher dispatcher;

    private PitchProcessor.PitchEstimationAlgorithm algo = PitchProcessor.PitchEstimationAlgorithm.YIN;
    
    public void setNewMixer(Mixer mixer) throws LineUnavailableException{

        if (dispatcher != null) {
            dispatcher.stop();
        }

        float sampleRate = 44100;
        int bufferSize = 1024;
        int overlap = 0;

      System.out.println("Started listening with " + MainClass.micName + "\n");

        final AudioFormat format = new AudioFormat(sampleRate, 16, 1, true,
                true);
        final DataLine.Info dataLineInfo = new DataLine.Info(
                TargetDataLine.class, format);
        TargetDataLine line;
        line = (TargetDataLine) mixer.getLine(dataLineInfo);
        final int numberOfSamples = bufferSize;
        line.open(format, numberOfSamples);
        line.start();
        final AudioInputStream stream = new AudioInputStream(line);

        JVMAudioInputStream audioStream = new JVMAudioInputStream(stream);
        // create a new dispatcher
        dispatcher = new AudioDispatcher(audioStream, bufferSize,
                overlap);

        // add a processor
        note = false;
        dispatcher.addAudioProcessor(new PitchProcessor(algo, sampleRate, bufferSize, (PitchDetectionHandler) this));
        System.out.println("Audio dispatching started");
        System.out.println(Thread.activeCount());
        new Thread(dispatcher, "Audio dispatching").start();



        while (note == false) {
            Thread.onSpinWait();
        }


    }

    private void resetVariables(){
        constantTime = 0;
        constantPitch = 0;
        played = false;
        freq.clear();
        note = true;
    }


    private  double constantTime = 0;
    private  double constantPitch = 0;
    private  boolean played = false;
    private  ArrayList freq = new ArrayList();
    public static volatile boolean note = false;
    public static double frequency = 0;
    public static ArrayList correctNotes = new ArrayList();

    //The code fragment below is a modified version of the code
    //provided by Joren Six on GitHub
    //Source: https://github.com/JorenSix/TarsosDSP

    @Override
    public void handlePitch(PitchDetectionResult pitchDetectionResult,AudioEvent audioEvent) {

        if(constantTime<2) { //Searches for a specific note for two second

            constantTime = audioEvent.getTimeStamp();
            constantPitch = pitchDetectionResult.getPitch();
            freq.add(constantPitch); //Adds every frequency detected to an arraylist
            /*
                System.out.println("Searching for: "+ frequency);

            System.out.println("time: " + constantTime);
            System.out.println("pitch: " + constantPitch);
            System.out.println(Thread.activeCount());

             */
        }

        else if(note == false){

            //boolean "played" starts as false
            for (int i = 0; i < freq.size(); i++) {
               //freq contains all the frequencies detected

                double e = (double) freq.get(i);

                if (e > (frequency -25) && e < (frequency + 25)) {
                    //if the frequency is within the appropriate range
                    // "played" is turned to true, and the loop ends
                    played = true;
                    break;
                }
            }
            //System.out.println("RESULT: "+ played);
            //System.out.println("FREQUENCIES SIZE: "+freq.size());
String correct = String.valueOf(played);
            correctNotes.add(correct);

          resetVariables();

//System.out.println(Thread.activeCount());


        }


    }

}
