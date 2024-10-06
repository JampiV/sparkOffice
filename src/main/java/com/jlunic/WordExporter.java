package com.jlunic;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileOutputStream;
import java.io.IOException;

public class WordExporter
{
    public void exportToWord(String text, String filePath)
    {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.createRun().setText(text);

        try (FileOutputStream out = new FileOutputStream(filePath))
        {
            document.write(out);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
