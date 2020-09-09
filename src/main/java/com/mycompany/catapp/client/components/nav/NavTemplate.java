package com.mycompany.catapp.client.components.nav;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mycompany.catapp.services.graphicServices.ObjGraficosService;
import com.mycompany.catapp.services.graphicServices.RecursosService;

public class NavTemplate extends JPanel{
  private static final long serialVersionUID = 1L;
  
  // Declaración inyección y servicios
  private NavComponent navComponent;
  private ObjGraficosService sObjGraphics;
  private RecursosService sResources;

  // Declaración Objetos Gráficos
  private JLabel lLogo, lTitle, lCopy;
  private JButton bHome, bProfile, bList, bSettings, bSignOut;

  // Declaración Objetos Decoradores
  private ImageIcon iLogo, iDimAux;
  private ImageIcon iHomeW, iProfileW, iListW, iSettingsW, iSignOutW;
  private ImageIcon iHomeB, iProfileB, iListB, iSettingsB, iSignOutB;

  
  public NavTemplate(NavComponent navComponent) {
    this.navComponent = navComponent;
    sObjGraphics = ObjGraficosService.getService();
    sResources = RecursosService.getService();

    createDecoratorObjects();
    createJLabels();
    createJButtons();

    this.setSize(220, 600);
    this.setBackground(sResources.getColorAzul());
    this.setLayout(null);
    this.setVisible(true);
  }

  public void createDecoratorObjects() {
    iLogo = new ImageIcon("assets/images/logo.png");
    iHomeW = new ImageIcon("assets/images/homeW.png");
    iProfileW = new ImageIcon("assets/images/profileW.png");
    iListW = new ImageIcon("assets/images/listW.png");
    iSettingsW = new ImageIcon("assets/images/settingW.png");
    iSignOutW = new ImageIcon("assets/images/signoutW.png");
    iHomeB = new ImageIcon("assets/images/homeB.png");
    iProfileB = new ImageIcon("assets/images/profileB.png");
    iListB = new ImageIcon("assets/images/listB.png");
    iSettingsB = new ImageIcon("assets/images/settingB.png");
    iSignOutB = new ImageIcon("assets/images/signoutB.png");
  }

  public void createJLabels() {
    iDimAux = new ImageIcon(iLogo.getImage()
      .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
    );

    lLogo = sObjGraphics.construirJLabel(
      null, 
      30, 35, 40, 40, 
      sResources.getCMano(), 
      iDimAux, 
      null, null, null, null, 
      "c"
    );
    this.add(lLogo);

    lTitle = sObjGraphics.construirJLabel(
      "CatApp", 
      80, 30, 120, 50, 
      sResources.getCMano(), 
      null, 
      sResources.getFontTitulo(), 
      null, 
      Color.WHITE, 
      null, 
      "l"
    );
    this.add(lTitle);

    lCopy = sObjGraphics.construirJLabel(
      "<html><div align='center'> © 2020 - Derechos reservados CrissUD - Cristian Patiño </div></html>", 
      20, 530, 180, 30, 
      null, null, 
      sResources.getFontPequeña(), 
      null, 
      Color.WHITE, 
      null, 
      "c"
    );
    this.add(lCopy);
  }

  public void createJButtons() {
    // BUTTON HOME -----------------------------------------------------------------
    iDimAux = new ImageIcon(iHomeW.getImage()
      .getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
    );

    bHome = sObjGraphics.construirJButton(
      "     Inicio", 
      40, 160, 200, 45, 
      sResources.getCMano(), 
      iDimAux, 
      sResources.getFontBotones(), 
      null, 
      Color.WHITE, 
      sResources.getBordeRedondeadoBoton(), 
      "l", 
      false
    );
    bHome.addActionListener(navComponent);
    bHome.addMouseListener(navComponent);
    this.add(bHome);

    // BUTTON PROFILE -----------------------------------------------------------------
    iDimAux = new ImageIcon(iProfileW.getImage()
      .getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
    );

    bProfile = sObjGraphics.construirJButton(
      "     Perfil", 
      40, 220, 200, 45, 
      sResources.getCMano(), 
      iDimAux, 
      sResources.getFontBotones(), 
      null, 
      Color.WHITE, 
      sResources.getBordeRedondeadoBoton(), 
      "l", 
      false
    );
    bProfile.addActionListener(navComponent);
    bProfile.addMouseListener(navComponent);
    this.add(bProfile);

    // BUTTON LISTS -----------------------------------------------------------------
    iDimAux = new ImageIcon(iListW.getImage()
      .getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
    );

    bList = sObjGraphics.construirJButton(
      "     Listas", 
      40, 280, 200, 45, 
      sResources.getCMano(), 
      iDimAux, 
      sResources.getFontBotones(), 
      null, 
      Color.WHITE, 
      sResources.getBordeRedondeadoBoton(), 
      "l", 
      false
    );
    bList.addActionListener(navComponent);
    bList.addMouseListener(navComponent);
    this.add(bList);

    // BUTTON SETINGS -----------------------------------------------------------------
    iDimAux = new ImageIcon(iSettingsW.getImage()
      .getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
    );

    bSettings = sObjGraphics.construirJButton(
      "     Ajustes", 
      40, 340, 200, 45, 
      sResources.getCMano(), 
      iDimAux, 
      sResources.getFontBotones(), 
      null, 
      Color.WHITE, 
      sResources.getBordeRedondeadoBoton(), 
      "l", 
      false
    );
    bSettings.addActionListener(navComponent);
    bSettings.addMouseListener(navComponent);
    this.add(bSettings);

    // BUTTON SIGN OUT -----------------------------------------------------------------
    iDimAux = new ImageIcon(iSignOutW.getImage()
      .getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
    );

    bSignOut = sObjGraphics.construirJButton(
      "     Ajustes", 
      40, 400, 200, 45, 
      sResources.getCMano(), 
      iDimAux, 
      sResources.getFontBotones(), 
      null, 
      Color.WHITE, 
      sResources.getBordeRedondeadoBoton(), 
      "l", 
      false
    );
    bSignOut.addActionListener(navComponent);
    bSignOut.addMouseListener(navComponent);
    this.add(bSignOut);
  }

  public RecursosService getResourcesService(){ return  sResources; }

  public ImageIcon getIWhite(JButton button) {
    if (button == bHome) 
      iDimAux = new ImageIcon(
        iHomeW.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
      );
    if (button == bProfile) 
      iDimAux = new ImageIcon(
        iProfileW.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
      );
    if (button == bList) 
      iDimAux = new ImageIcon(
        iListW.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
      );
    if (button == bSettings) 
      iDimAux = new ImageIcon(
        iSettingsW.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
      );
    if (button == bSignOut) 
      iDimAux = new ImageIcon(
        iSignOutW.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
      );
    return iDimAux;
  }

  public ImageIcon getIBlue(JButton button) {
    if (button == bHome) 
      iDimAux = new ImageIcon(
        iHomeB.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
      );
    if (button == bProfile) 
      iDimAux = new ImageIcon(
        iProfileB.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
      );
    if (button == bList) 
      iDimAux = new ImageIcon(
        iListB.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
      );
    if (button == bSettings) 
      iDimAux = new ImageIcon(
        iSettingsB.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
      );
    if (button == bSignOut) 
      iDimAux = new ImageIcon(
        iSignOutB.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
      );
    return iDimAux;
  }
}
