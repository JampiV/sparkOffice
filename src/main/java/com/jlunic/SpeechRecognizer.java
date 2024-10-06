package com.jlunic;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;


public class SpeechRecognizer {
    public String recognizeSpeech(File audioFile) {

        String recognizedText = "";

        try
        {
            String[] command  = {"python","src/main/java/com/jlunic/speech_reconizer.py", audioFile.getAbsolutePath()};

            // Crear un proceso que ejecutará el comando
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Leer la salida del script Python
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                recognizedText = output.toString();
            } else {
                recognizedText = "Error al ejecutar el script de Python.";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return recognizedText;
    }
}