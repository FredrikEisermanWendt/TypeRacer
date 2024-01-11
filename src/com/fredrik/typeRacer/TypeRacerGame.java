package com.fredrik.typeRacer;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.round;

public class TypeRacerGame {
    
    
    Scanner scanner = new Scanner(System.in);
    String[] origSentence;
    String[] inputScentece;
    List<String> wrongWordsList = new ArrayList<>();
    
    
    public void startGame(String sentence) {
        // TODO: Refine this method
        
        
        System.out.println("Type the following sentence as fast as you can:");
        System.out.println(sentence);
        
        Instant start = startStopWatch();
        String userInput = scanner.nextLine();
        Instant end = stopStopwatch();
        
        boolean isCorrect = userInput.equals(sentence);
        System.out.println(isCorrect ? "Correct!" : "Incorrect!");
        
        divideOriginalString(sentence);
        divideInputString(userInput);
        
        double seconds = calculateStopWatch(start, end);
        printFaults(seconds);
        
        
    }
    
    
    private void printFaults(double seconds) {
//        tid det tog att skriva in
        System.out.print("Antal sekunder på försöket: ");
        System.out.println(seconds);
//        WPM
        System.out.print("WPM: ");
        System.out.println(wPM(seconds, inputScentece.length));
//        antal fel ord
        countWrongWords();
        System.out.print("Antal felskrivna ord: ");
        System.out.println(wrongWordsList.size());
    }
    
    
    private void divideInputString(String s) {
        inputScentece = s.split(" ");
    }
    
    
    public void divideOriginalString(String s) {
        origSentence = s.split(" ");
    }
    
    
    
    private double calculateStopWatch(Instant start, Instant end) {
        int nano = Duration.between(start, end).getNano();
        return nano / 9.0;
    }
    
    
    private Instant stopStopwatch() {
        return Instant.now();
        
    }
    
    
    public Instant startStopWatch() {
        return Instant.now();
    }
    
    
    public double wPM(double seconds, int noOfWords) {
        int minutes = (int) seconds / 60;
        double wPM = noOfWords / minutes;
        return wPM;
        
    }
    
    
    public void countWrongWords() {
        for (int i = 0; i < inputScentece.length; i++) {
            if (!inputScentece[i].equals(origSentence[i])) {
                wrongWordsList.add(inputScentece[i]);
            }
        }
    }
    
    
}
