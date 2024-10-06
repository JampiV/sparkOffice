package com.jlunic;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.image.BufferedImage;

public class TextExtractor
{
    public String extractText(BufferedImage image)
    {
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:/Users/JAMPIER/OneDrive/Documentos/sparkOffice/sparkOffice/tessdata");
        tesseract.setLanguage("spa");
        try {
            return tesseract.doOCR(image);
        } catch (TesseractException ex)
        {
            ex.printStackTrace();
            return "";
        }
    }
}
