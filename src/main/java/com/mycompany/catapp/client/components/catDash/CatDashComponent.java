package com.mycompany.catapp.client.components.catDash;

import com.mycompany.catapp.client.components.home.HomeComponent;
import com.mycompany.catapp.models.Cat;
import com.mycompany.catapp.services.logicServices.CatService;

import java.awt.Image;
import java.awt.event.ActionListener;

import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import java.awt.event.ActionEvent;

public class CatDashComponent implements ActionListener {

  private CatDashTemplate catDashTemplate;
  private HomeComponent homeComponent;
  private CatService sCat;
  private Cat cat;

  public CatDashComponent(HomeComponent homeComponent) {
    this.homeComponent = homeComponent;
    sCat = CatService.getService();
    sCat.getFavouriteList();
    this.catDashTemplate = new CatDashTemplate(this);
  }

  public CatDashTemplate getCatDashTemplate() {
    return catDashTemplate;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == catDashTemplate.getBNext()) {
      this.getCat();
    }
    if (e.getSource() == catDashTemplate.getBFavourite()) {
      this.sendFavourite();
    }
  }

  public void getCat() {
    catDashTemplate.getLCatImage().setVisible(false);
    catDashTemplate.getLLoader().setVisible(true);

    SwingWorker<Cat, Void> worker = new SwingWorker<Cat, Void>() {
      @Override
      protected void done() {
        try {
          cat = get();
          Image image = null;
          try {
            URL url = new URL(cat.getUrl());
            image = ImageIO.read(url);
            catDashTemplate.insertImage(image);
            catDashTemplate.repaint();
          } catch (Exception ex) {
            System.out.println(ex);
          }
        } catch (InterruptedException | ExecutionException ex) {
          System.out.println(ex);
          
        }
      }

      @Override
      protected Cat doInBackground() throws Exception {
        return sCat.getCat();
      }
    };
    worker.execute();
  }

  public void sendFavourite() {
    SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
      @Override
      protected void done() {
        try {
          Boolean result = get();
          if (result) {
            catDashTemplate.getBFavourite().setIcon(
              catDashTemplate.getFavouriteImage(2)
            );
            catDashTemplate.getBFavourite().setEnabled(false);
            homeComponent.updateFavouriteList();
            JOptionPane.showMessageDialog(null, "Guardado Exitoso", "Advertencia", 1);
          }
        } catch (InterruptedException | ExecutionException ex) {
          System.out.println(ex);
        }
      }

      @Override
      protected Boolean doInBackground() throws Exception {
        return sCat.saveFavourite(cat);
      }
    };
    worker.execute();
  }
}
