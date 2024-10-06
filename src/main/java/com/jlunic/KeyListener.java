package com.jlunic;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class KeyListener implements java.awt.event.KeyListener
{
    private boolean isCaptureKey(KeyEvent event)
    {
        return event.getKeyCode() == KeyEvent.VK_SPACE;
    }

    private boolean isRecordAudioKey(KeyEvent event)
    {
        return event.getKeyCode() == KeyEvent.VK_ENTER;
    }

    @Override
    public void keyPressed(KeyEvent event)
    {

       if(isCaptureKey(event))
       {
           System.out.println("Screen Shooting ...");

           ScreenCapture screenCapture = new ScreenCapture();
           TextExtractor textExtractor = new TextExtractor();
           WordExporter wordExporter = new WordExporter();

           try {
               BufferedImage screenshot = screenCapture.captureScreen();
               screenCapture.saveImage(screenshot, "screenshot.png");

               String extractedText = textExtractor.extractText(screenshot);
               System.out.println("extractedText = " + extractedText);

               wordExporter.exportToWord(extractedText, "capturedText.docx");

           } catch (Exception e)
           {
               e.printStackTrace();
           }
       }

       if(isRecordAudioKey(event))
       {
           System.out.println("Starting Audio Recording ...");

           AudioCapture audioCapture = new AudioCapture();
           SpeechRecognizer speechRecognizer = new SpeechRecognizer();

           try
           {
               audioCapture.startRecording();
               File audioFile = audioCapture.getAudioFile();
               String recognizedText = speechRecognizer.recognizeSpeech(audioFile);
               System.out.println("recognizedText = " + recognizedText);
           } catch (Exception ex)
           {
               ex.printStackTrace();
           }
       }
    }

    @Override
    public void keyReleased(KeyEvent event) {}

    @Override
    public void keyTyped(KeyEvent event) {}
}
