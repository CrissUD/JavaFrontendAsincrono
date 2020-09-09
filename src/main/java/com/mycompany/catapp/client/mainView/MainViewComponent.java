package com.mycompany.catapp.client.mainView;

import com.mycompany.catapp.client.components.bar.BarComponent;
import com.mycompany.catapp.client.components.home.HomeComponent;
import com.mycompany.catapp.client.components.nav.NavComponent;

import java.awt.Frame;

public class MainViewComponent {
  
  private MainViewTemplate mainViewTemplate;
  private NavComponent navComponent;
  private BarComponent barComponent;
  private HomeComponent homeComponent;
  
  public MainViewComponent () {
    this.mainViewTemplate = new MainViewTemplate(this);
    this.navComponent = new NavComponent(this);
    this.barComponent = new BarComponent(this);
    this.homeComponent = new HomeComponent();

    mainViewTemplate.getPNav()
      .add(navComponent.getNavTemplate());
    mainViewTemplate.getPBar()
      .add(barComponent.getBarTemplate());
    mainViewTemplate.createContent(
      homeComponent.getHomeTemplate()
    );

    mainViewTemplate.setVisible(true);
  }
  
  public MainViewTemplate getMainViewTemplate () {
    return mainViewTemplate;
  }

  public void showComponents(String command) {

  }

  public void moveWindow(int posX, int posY) {
    this.mainViewTemplate.setLocation(posX, posY);
  }

  public void minWindow() {
    this.mainViewTemplate.setExtendedState(Frame.ICONIFIED);
  }

  public void closeWindow() {
    System.exit(0);
  }
}
