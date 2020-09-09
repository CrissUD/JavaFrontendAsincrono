package com.mycompany.catapp;

import javax.swing.SwingUtilities;

import com.mycompany.catapp.client.mainView.MainViewComponent;

/**
 * @author CrissUD / Cristian Patiño
 */
public class App {

  /**
   * @param args the command line arguments
   */

  public static void main(String[] args) {
    Runnable runApplication = new Runnable () {
      public void run(){
        MainViewComponent view = new MainViewComponent();
        view.getClass();
      }
    };
    SwingUtilities.invokeLater(runApplication);
  }
}
