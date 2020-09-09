package com.mycompany.catapp.client.components.catList;

import javax.imageio.ImageIO;
import javax.swing.SwingWorker;

import java.awt.Image;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import com.mycompany.catapp.models.FavouriteCat;
import com.mycompany.catapp.services.logicServices.CatService;

public class CatListComponent {
  private CatListTemplate catListTemplate;
  private CatService sCat;
  private FavouriteCat[] favouriteCatList;
  
  public CatListComponent() {
    sCat = CatService.getService();
    this.catListTemplate = new CatListTemplate(this);
    getFavouriteCatList();
  }

  public void getFavouriteCatList() {
    SwingWorker<FavouriteCat[], Void> worker = new SwingWorker<FavouriteCat[], Void>() {
      @Override
      protected void done() {
        try {
          favouriteCatList = get();
          try {
            for(FavouriteCat cat: favouriteCatList) {
              Image image = null;
              URL url = new URL(cat.getImage().getUrl());
              image = ImageIO.read(url);
              cat.setCatPicture(image);
            }
            catListTemplate.createList();
          } catch (Exception ex) {
            System.out.println(ex);
          }
        } catch (InterruptedException | ExecutionException ex) {
          System.out.println(ex);
        }
      }

      @Override
      protected FavouriteCat[] doInBackground() throws Exception {
        return sCat.getFavouriteList();
      }
    };
    worker.execute();
  }
  
  public CatListTemplate getCatListTemplate() {
    return catListTemplate;
  }

  public FavouriteCat getFavouriteCat(int position) {
    try {
      return favouriteCatList[position];
    } catch (Exception e) {
      return null;
    }
  }

  public int getFavouriteListLen() {
    return favouriteCatList.length;
  }
}
