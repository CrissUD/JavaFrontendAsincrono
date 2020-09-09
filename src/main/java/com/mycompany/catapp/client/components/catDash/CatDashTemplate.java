package com.mycompany.catapp.client.components.catDash;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mycompany.catapp.services.graphicServices.ObjGraficosService;
import com.mycompany.catapp.services.graphicServices.RecursosService;

public class CatDashTemplate extends JPanel{
  private static final long serialVersionUID = 1L;

  // Declaracion inyeccion y servicios
  private CatDashComponent catDashComponent;
  private ObjGraficosService sObjGraphics;
  private RecursosService sResources;

  // Declaracion objetos graficos
  private JLabel lCatImage, lLoader, lTitle, lSubTitle, lText;
  private JButton bFavourite, bNext;

  // Declaracion Objetos Decoradores
  private ImageIcon iLoader, iFavouriteD, iFavouriteF, iNext, iDimAux;
  
  public CatDashTemplate(CatDashComponent catDashComponent) {
    this.catDashComponent = catDashComponent;
    sObjGraphics = ObjGraficosService.getService();
    sResources = RecursosService.getService();

    this.createDecoratorObjects();
    this.createJLabels();
    this.createJButtons();

    this.setSize(500, 590);
    this.setLayout(null);
    this.setBackground(Color.WHITE);
    this.setVisible(true);
  }

  public void createDecoratorObjects() {
    iLoader = new ImageIcon("assets/images/loader.gif");
    iFavouriteD = new ImageIcon("assets/images/favouriteD.png");
    iFavouriteF = new ImageIcon("assets/images/favouriteF.png");
    iNext = new ImageIcon("assets/images/next.png");
  }

  public void createJLabels() {
    lTitle = sObjGraphics.construirJLabel(
      "¿Te gusta este Mishi?", 
      0, 50, 500, 40, 
      null, null, 
      sResources.getFontSubtitulo(),
      null, sResources.getColorGrisOscuro(), 
      null, 
      "c"
    );
    this.add(lTitle);

    lCatImage = sObjGraphics.construirJLabel(
      null,
      (500 - 350) / 2, 100, 350, 250,
      null, null, null, null, null,
      sResources.getBordeRedondeado(),
      "c"
    );
    lCatImage.setVisible(false);
    this.add(lCatImage);

    lLoader = sObjGraphics.construirJLabel(
      null,
      (500 - 200) / 2, 125, 200, 200,
      null,
      iLoader,
      null, null, null,
      sResources.getBordeRedondeado(),
      "c"
    );
    lLoader.setVisible(false);
    this.add(lLoader);

    lSubTitle = sObjGraphics.construirJLabel(
      "Ayuda a un mishi", 
      0, 400, 500, 40, 
      null, null, 
      sResources.getFontSubtitulo(),
      null, sResources.getColorGrisOscuro(), 
      null, 
      "c"
    );
    this.add(lSubTitle);
    
    lText = sObjGraphics.construirJLabel(
      "<html><div align='center'>" +
      "Este es un proyecto creado desde la fundacion Java" + 
      "el cual pretende ayudar a todos los gatitos sun hogar" + 
      "para que tengan proteccion, salud y cariño," + 
      "para mas informacion enrta a www.fudacioncatjava.com" + 
      "</div></html>", 
      (500 - 400) / 2, 435, 400, 80, 
      null, null, 
      sResources.getFontPequeña(),
      null, sResources.getColorGrisOscuro(), 
      null, 
      "c"
    );
    this.add(lText);
  }

  public void createJButtons() {
    iDimAux = new ImageIcon(iFavouriteD.getImage()
      .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
    );

    bFavourite = sObjGraphics.construirJButton(
      null, 
      ((500 - 40) / 2) - 50, 350, 40, 40, 
      sResources.getCMano(), 
      iDimAux, 
      null, null, null, null, 
      "c", 
      false
    );
    bFavourite.setEnabled(false);
    bFavourite.addActionListener(catDashComponent);
    this.add(bFavourite);
    
    iDimAux = new ImageIcon(iNext.getImage()
      .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
    );

    bNext = sObjGraphics.construirJButton(
      null, 
      ((500 - 40) / 2) + 50, 350, 40, 40, 
      sResources.getCMano(), 
      iDimAux, 
      null, null, null, null, 
      "c", 
      false
    );
    bNext.addActionListener(catDashComponent);
    this.add(bNext);
  }

  public void insertImage(Image image) {
    iDimAux = new ImageIcon(
      image.getScaledInstance(350, 250, Image.SCALE_AREA_AVERAGING)
    );
    lCatImage.setIcon(iDimAux);
    bFavourite.setIcon(this.getFavouriteImage(1));
    bFavourite.setEnabled(true);
    lLoader.setVisible(false);
    lCatImage.setVisible(true);
  }

  public JButton getBFavourite() { return bFavourite; }

  public JButton getBNext() { return bNext; }

  public JLabel getLCatImage() { return lCatImage; }

  public JLabel getLLoader() { return lLoader; }

  public ImageIcon getFavouriteImage (int option) {
    if (option == 1) {
      iDimAux = new ImageIcon(iFavouriteD.getImage()
        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
      );
    }
    if (option == 2) {
      iDimAux = new ImageIcon(iFavouriteF.getImage()
        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
      );
    }
    return iDimAux;
  }
}
