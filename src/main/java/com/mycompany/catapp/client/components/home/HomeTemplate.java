package com.mycompany.catapp.client.components.home;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class HomeTemplate extends JPanel{
  private static final long serialVersionUID = 1L;
  
  private HomeComponent homeComponent;
  
  public HomeTemplate(HomeComponent homeComponent) {
    this.homeComponent = homeComponent;
    this.homeComponent.getClass();

    this.setPreferredSize(new Dimension(733, 400));
    this.setLayout(null);
    this.setBackground(Color.WHITE);
  }

  public void addContent(JPanel panel, int posX, int posY) {
    panel.setLocation(posX, posY);
    this.add(panel);
  }
}
