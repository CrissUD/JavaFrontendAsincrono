package com.mycompany.catapp.client.components.bar;

import com.mycompany.catapp.client.mainView.MainViewComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BarComponent extends MouseAdapter implements ActionListener{
  private BarTemplate barTemplate;
  private MainViewComponent mainViewComponent;

  private int initPosX, initPosY;
  
  public BarComponent(MainViewComponent mainViewComponent) {
    this.mainViewComponent = mainViewComponent;
    this.barTemplate = new BarTemplate(this);
  }
  
  public BarTemplate getBarTemplate() {
    return barTemplate;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == barTemplate.getBMin()) {
      this.mainViewComponent.minWindow();
    }
    if(e.getSource() == barTemplate.getBClose()) {
      this.mainViewComponent.closeWindow();
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
    initPosX = e.getX() + 219;
    initPosY = e.getY() + 5;
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    this.mainViewComponent.moveWindow(
        e.getXOnScreen() - initPosX,
        e.getYOnScreen() - initPosY
      );
  }
}
