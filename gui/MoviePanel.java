package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import static javafx.scene.paint.Color.rgb;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import user.*;
import movie.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shenghu
 */
public class MoviePanel extends JPanel{
    
    
    public MoviePanel(Movie m, MoviePage mp) {
        BoxLayout l = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(l);
        this.setPreferredSize(new Dimension(120,200));
        
        JLabel title = new JLabel(m.getTitle());
        JLabel poster = new JLabel();
        JButton details = new JButton("details");
        details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("movie switched to : " + m.getTitle());
                mp.refresh(m);
            }
        });


        title.setPreferredSize(new Dimension(120, 50));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);       
        poster.setAlignmentX(Component.CENTER_ALIGNMENT);
        details.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        try {
            URL url = new URL(m.getPoster());
            ImageIcon icon = new ImageIcon(ImageIO.read(url));
            ImageIcon newIcon = new ImageIcon(icon.getImage().getScaledInstance(120, 150, Image.SCALE_DEFAULT));
            poster.setIcon(newIcon);
        } catch(IOException ex) {

        }   
        this.add(poster);      
        this.add(title);
        this.add(details);
        this.setBackground(new Color(204,204,204));
        
    }
     
}
