package com.dodgethis.main;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    private static final long serialVersionUID = 2213650390035810883L;

    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); //Disables window resizing for now to avoid unwanted technical complexities
        frame.setLocationRelativeTo(null); //Centers rendered window
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }

}
