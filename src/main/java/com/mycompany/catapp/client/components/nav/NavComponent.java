package com.mycompany.catapp.client.components.nav;

import com.mycompany.catapp.client.mainView.MainViewComponent;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class NavComponent extends MouseAdapter implements ActionListener{
  private NavTemplate navTemplate;
  private MainViewComponent mainViewComponent;
  
  public NavComponent(MainViewComponent mainViewComponent) {
    this.mainViewComponent = mainViewComponent;
    this.navTemplate = new NavTemplate(this);
  }
  
  public NavTemplate getNavTemplate() {
    return navTemplate;
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    JButton button = (JButton) e.getSource();
    button.setContentAreaFilled(true);
    button.setForeground(navTemplate.getResourcesService().getColorAzul());
    button.setBackground(Color.WHITE);
    button.setIcon(navTemplate.getIBlue(button));
  }

  @Override
  public void mouseExited(MouseEvent e) {
    JButton button = (JButton) e.getSource();
    button.setContentAreaFilled(false);
    button.setForeground(Color.WHITE);
    button.setIcon(navTemplate.getIWhite(button));
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    this.mainViewComponent.showComponents(e.getActionCommand().trim());
  }
}
