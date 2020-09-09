package com.mycompany.catapp.client.components.favCat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mycompany.catapp.models.FavouriteCat;
import com.mycompany.catapp.services.graphicServices.ObjGraficosService;
import com.mycompany.catapp.services.graphicServices.RecursosService;

import java.awt.Color;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class FavCatTemplate extends JPanel{
  private static final long serialVersionUID = 1L;

  // Declaración Servicios y dependencias
  private FavCatComponent favCatComponent;
  private ObjGraficosService sObjGraphics;
  private RecursosService sResources;
  private FavouriteCat cat;
  
  // Declaración LayoutManager
  private GridBagLayout lGrid;
  private GridBagConstraints gbc;

  // Declaración Objetos Gráficos
  private JLabel lIdUser, lCreateAt;
  private JLabel lImage, lIdUserIcon, lCreateAtIcon;
  private JButton bClose;

  // Declaración Objetos Decoradores
  private ImageIcon iUser, iDate, iDimAux;
  
  public FavCatTemplate(FavCatComponent favCatComponent, FavouriteCat cat) {
    this.favCatComponent = favCatComponent;
    this.sObjGraphics = ObjGraficosService.getService();
    this.sResources = RecursosService.getService();
    this.cat = cat;

    lGrid = new GridBagLayout();
    gbc = new GridBagConstraints();
    this.setLayout(lGrid);

    createDecoratorObjects();
    createJLabels();
    createJButtons();

    this.setPreferredSize(new Dimension(215, 80));
    this.setBackground(Color.WHITE);
    this.setVisible(true);
  }

  public void createDecoratorObjects() {
    iUser = new ImageIcon("assets/images/user.png");
    iDate = new ImageIcon("assets/images/date.png");
  }

  public void createJLabels() {
    iDimAux = new ImageIcon(cat.getCatPicture().getImage()
      .getScaledInstance(55, 55, Image.SCALE_AREA_AVERAGING)
    );
    // LABEL IMAGE -----------------------------------------------------------
    lImage = sObjGraphics.construirJLabel(
      null,
      0, 0, 0, 0,
      null, 
      iDimAux,
      null, null, null,
      sResources.getBordeCircular(),
      "c"
    );
    modificarGbc(0, 0, 1, 2, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0);
    this.add(lImage, gbc);

    // LABEL L_ID_USER_ICON -----------------------------------------------------------
    iDimAux = new ImageIcon(iUser.getImage()
      .getScaledInstance(15, 15, Image.SCALE_AREA_AVERAGING)
    );
    lIdUserIcon = sObjGraphics.construirJLabel(
      null,
      0, 0, 0, 0,
      null, 
      iDimAux,
      null, null, null, null,
      "c"
    );
    modificarGbc(1, 0, 1, 1, 0, 10, 10, 0, 0, 0, 0, 0, 1, 0);
    this.add(lIdUserIcon, gbc);

    // LABEL L_DATE -----------------------------------------------------------
    iDimAux = new ImageIcon(iDate.getImage()
      .getScaledInstance(15, 15, Image.SCALE_AREA_AVERAGING)
    );
    lCreateAtIcon = sObjGraphics.construirJLabel(
      null,
      0, 0, 0, 0,
      null, 
      iDimAux,
      null, null, null, null,
      "c"
    );
    modificarGbc(1, 1, 1, 1, 0, 10, 0, 0, 0, 0, 0, 0, 1, 0);
    this.add(lCreateAtIcon, gbc);

    // LABEL L_ID_USER -----------------------------------------------------------
    lIdUser = sObjGraphics.construirJLabel(
      cat.getUserId(),
      0, 0, 0, 0,
      null, null,
      sResources.getFontPequeña(), 
      null, 
      sResources.getColorGrisOscuro(), 
      null,
      "l"
    );
    modificarGbc(2, 0, 1, 1, 0, 17, 10, 0, 0, 0, 0, 0, 1, 0);
    this.add(lIdUser, gbc);

    // LABEL L_CREATE_AT -----------------------------------------------------------
    lCreateAt = sObjGraphics.construirJLabel(
      cat.getCreateAt().substring(0, 10),
      0, 0, 0, 0,
      null, null,
      sResources.getFontPequeña(), 
      null, 
      sResources.getColorGrisOscuro(), 
      null,
      "l"
    );
    modificarGbc(2, 1, 1, 1, 0, 17, 0, 0, 0, 0, 0, 0, 1, 0);
    this.add(lCreateAt, gbc);
  }

  public void createJButtons() {
    // BUTTON CLOSE -----------------------------------------------------------------
    iDimAux = new ImageIcon(sResources.getIClose().getImage()
    .getScaledInstance(12, 12, Image.SCALE_AREA_AVERAGING)
    );

    bClose = sObjGraphics.construirJButton(
    null, 
    0, 0, 0, 0, 
    sResources.getCMano(), 
    iDimAux, 
    null, null, null, null, 
    "c", 
    false
    );
    bClose.addActionListener(favCatComponent);
    modificarGbc(3, 0, 1, 2, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0);
    this.add(bClose, gbc);
  }

  public void modificarGbc(
    int posColumna, int posFila,
    int numColumnas, int numFilas,
    int tipoEstirado,
    int posicionInterna,
    int marginArriba, int marginDerecha, int marginAbajo, int marginIzquierda,
    int paddingX, int paddingY,
    int estiramientoColumna, int estiramientoFila
  ) {
    gbc.gridx = posColumna; 
    gbc.gridy = posFila;
    gbc.gridwidth = numColumnas;
    gbc.gridheight = numFilas;
    gbc.fill = tipoEstirado;
    gbc.anchor = posicionInterna;
    gbc.insets.top = marginArriba;
    gbc.insets.right = marginDerecha;
    gbc.insets.bottom = marginAbajo;
    gbc.insets.left = marginIzquierda;
    gbc.ipadx = paddingX;
    gbc.ipady = paddingY;
    gbc.weightx = estiramientoColumna;
    gbc.weighty = estiramientoFila;
  }
}
