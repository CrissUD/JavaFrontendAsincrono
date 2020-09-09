package com.mycompany.catapp.client.components.home;

import com.mycompany.catapp.client.components.catDash.CatDashComponent;
import com.mycompany.catapp.client.components.catList.CatListComponent;

public class HomeComponent {
  
  private HomeTemplate homeTemplate;
  private CatListComponent catListComponent;
  private CatDashComponent catDashComponent;
  
  public HomeComponent() {
    this.homeTemplate = new HomeTemplate(this);
    this.catListComponent = new CatListComponent();
    this.catDashComponent = new CatDashComponent(this);
    
    this.homeTemplate.addContent(
      catListComponent.getCatListTemplate(), 0, 0
    );
    this.homeTemplate.addContent(
      catDashComponent.getCatDashTemplate(), 233, 0
    );
    this.homeTemplate.setVisible(true);
  }

  public void updateFavouriteList() {
    catListComponent.getCatListTemplate().remove(catListComponent.getCatListTemplate().getPList());
    catListComponent.getFavouriteCatList();
  }
  
  public HomeTemplate getHomeTemplate() {
    return homeTemplate;
  }
}
