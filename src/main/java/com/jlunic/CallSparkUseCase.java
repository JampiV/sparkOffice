package com.jlunic;

import javax.swing.*;

public class CallSparkUseCase extends JFrame
{
    public CallSparkUseCase()
    {
        setTitle("Call Spark UseCase");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);

        this.addKeyListener(new KeyListener());

        setVisible(true);
    }

}
