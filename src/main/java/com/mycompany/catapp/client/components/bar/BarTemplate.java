package com.mycompany.catapp.client.components.bar;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mycompany.catapp.services.graphicServices.ObjGraficosService;
import com.mycompany.catapp.services.graphicServices.RecursosService;

public class BarTemplate extends JPanel{
  private static final long serialVersionUID = 1L;

  // Declaración Inyección y Servicios
  private BarComponent barComponent;
  private ObjGraficosService sObjGraphics;
  private RecursosService sResources;
  
  // Declaración Objetos Gráficos
  private JButton bClose, bMin, bNotifications, bCalendary;
  private JLabel lTitle;

  // Declaración Objetos Decoradores
  private ImageIcon iMin, iNotifications, iCalendary, iDimAux;

  public BarTemplate(BarComponent barComponent) {
    this.barComponent = barComponent;
    this.sObjGraphics = ObjGraficosService.getService();
    this.sResources = RecursosService.getService();

    this.createDecoratorObjects();
    this.createJLabels();
    this.createJButtons();

    this.setSize(750, 50);
    this.setLayout(null);
    this.setBackground(Color.WHITE);
    this.setBorder(sResources.getBorderInferiorGris());
    this.addMouseListener(barComponent);
    this.addMouseMotionListener(barComponent);
    this.setVisible(true);
  }

  public void createDecoratorObjects() {
    iMin = new ImageIcon("assets/images/min.png");
    iNotifications = new ImageIcon("assets/images/notification.png");
    iCalendary = new ImageIcon("assets/images/calendary.png");
  }

  public void createJLabels() {
    lTitle = sObjGraphics.construirJLabel(
      "Escoge a tus mishis favoritos", 
      20, 7, 220, 40,
      null, null,
      sResources.getFontSubtitulo(),
      null,
      sResources.getColorGrisOscuro(),
      null,
      "l"
    );
    this.add(lTitle);
  }

  public void createJButtons() {
    // BUTTON NOTIFICATIONS -----------------------------------------------------------------
    iDimAux = new ImageIcon(iNotifications.getImage()
      .getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)
    );

    bNotifications = sObjGraphics.construirJButton(
      null, 
      600, 13, 20, 20, 
      sResources.getCMano(), 
      iDimAux, 
      null, null, null, null, 
      "c", 
      false
    );
    bNotifications.addActionListener(barComponent);
    this.add(bNotifications);
    
    // BUTTON CALENDARY -----------------------------------------------------------------
    iDimAux = new ImageIcon(iCalendary.getImage()
      .getScaledInstance(17, 17, Image.SCALE_AREA_AVERAGING)
    );

    bCalendary = sObjGraphics.construirJButton(
      null, 
      640, 15, 17, 17, 
      sResources.getCMano(), 
      iDimAux, 
      null, null, null, null, 
      "c", 
      false
    );
    bCalendary.addActionListener(barComponent);
    this.add(bCalendary);
    
    // BUTTON MIN -----------------------------------------------------------------
    iDimAux = new ImageIcon(iMin.getImage()
      .getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)
    );

    bMin = sObjGraphics.construirJButton(
      null, 
      680, 13, 20, 20, 
      sResources.getCMano(), 
      iDimAux, 
      null, null, null, null, 
      "c", 
      false
    );
    bMin.addActionListener(barComponent);
    this.add(bMin);
    
    // BUTTON CLOSE -----------------------------------------------------------------
    iDimAux = new ImageIcon(sResources.getIClose().getImage()
      .getScaledInstance(17, 17, Image.SCALE_AREA_AVERAGING)
    );

    bClose = sObjGraphics.construirJButton(
      null, 
      715, 15, 17, 17, 
      sResources.getCMano(), 
      iDimAux, 
      null, null, null, null, 
      "c", 
      false
    );
    bClose.addActionListener(barComponent);
    this.add(bClose);
  }

  public JButton getBMin() { return bMin; }

  public JButton getBClose() { return bClose; }
}
