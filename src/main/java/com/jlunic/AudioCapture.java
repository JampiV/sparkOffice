package com.jlunic;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioCapture
{
    private static final int RECORD_TIME = 30000;
    private File audioFile = new File("audioCapture.wav");
    private AudioFormat format;
    private TargetDataLine microphone;

    public AudioCapture()
    {
        format = new AudioFormat(16000, 16, 1, true, true);
    }

    public void startRecording() throws LineUnavailableException
    {
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

        if(!AudioSystem.isLineSupported(info))
        {
            System.out.println("Microphone not supported");
            return;
        }

        microphone = (TargetDataLine) AudioSystem.getLine(info);
        microphone.open(format);
        microphone.start();

        System.out.println("Recording audio ...");

        Thread captureThread = new Thread(() ->
        {
            AudioInputStream audioInputStream = new AudioInputStream(microphone);
            try
            {
                AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, audioFile);
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        });

        captureThread.start();

        try
        {
            Thread.sleep(RECORD_TIME);
        } catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }

        stopRecording();
    }

    public void stopRecording()
    {
        microphone.stop();
        microphone.close();
        System.out.println("Record stopped");
    }

    public File getAudioFile()
    {
        return audioFile;
    }
}
