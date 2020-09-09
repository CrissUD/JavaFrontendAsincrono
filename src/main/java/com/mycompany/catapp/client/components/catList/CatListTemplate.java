package com.mycompany.catapp.client.components.catList;

import java.awt.Color;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.mycompany.catapp.client.components.favCat.FavCatComponent;
import com.mycompany.catapp.client.components.favCat.FavCatTemplate;
import com.mycompany.catapp.models.FavouriteCat;
import com.mycompany.catapp.services.graphicServices.GraficosAvanzadosService;
import com.mycompany.catapp.services.graphicServices.ObjGraficosService;
import com.mycompany.catapp.services.graphicServices.RecursosService;

public class CatListTemplate extends JPanel{
  private static final long serialVersionUID = 1L;

  // Declaracion inyeccion y servicios
  private CatListComponent catListComponent;
  private ObjGraficosService sObjGraphics;
  private RecursosService sResources;
  private GraficosAvanzadosService sAdvancedGraphics;

  // Declaración LayoutManager
  private GridBagLayout lGrid;
  private GridBagConstraints gbc;

  // Declaracion objetos graficos
  private JPanel pSearch, pContent;
  private JTextField tSearch;
  private JLabel lSearch;
  private JScrollPane pList;

  // Declaracion objetos decoradores
  private ImageIcon iSearch, iDimAux;
  
  public CatListTemplate(CatListComponent catListComponent) {
    this.catListComponent = catListComponent;
    sObjGraphics = ObjGraficosService.getService();
    sResources = RecursosService.getService();
    sAdvancedGraphics = GraficosAvanzadosService.getService();
    lGrid = new GridBagLayout();
    gbc = new GridBagConstraints();

    this.createDecoratorObjects();
    this.createSearchContent();

    this.setSize(233, 590);
    this.setLayout(null);
    this.setBackground(Color.WHITE);
    this.setVisible(true);
  }

  public void createDecoratorObjects() {
    iSearch = new ImageIcon("assets/images/search.png");
  }

  public void createSearchContent() {
    pSearch = sObjGraphics.construirJPanel(
      9, 10, 215, 40, 
      sResources.getColorGrisClaro(), 
      sResources.getBordeRedondeadoLineal()
    );
    this.add(pSearch);

    tSearch = sObjGraphics.construirJTextField(
      "Buscar Favoritos", 
      20, 12, 155, 20, 
      sResources.getFontPequeña(), 
      sResources.getColorGrisClaro(), 
      sResources.getColorGrisOscuro(), 
      sResources.getColorGrisOscuro(), 
      null, 
      "l"
    );
    pSearch.add(tSearch);

    iDimAux = new ImageIcon(iSearch.getImage()
      .getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
    );
    lSearch = sObjGraphics.construirJLabel(
      null,
      180, 7, 25, 25,
      sResources.getCMano(),
      iDimAux,
      null, null, null, null,
      "c"
    );
    pSearch.add(lSearch);
  }

  public void createList() {
    pContent = null;
    pList = null;
    pContent = sObjGraphics.construirJPanel(0, 0, 0, 0, Color.WHITE, null);
    pContent.setLayout(lGrid);

    int numCat = 0;
    gbc.anchor = 11;
    FavouriteCat cat = catListComponent.getFavouriteCat(numCat);

    while (cat != null) {
      FavCatTemplate pFavCat = new FavCatComponent(catListComponent, cat).getFavCatTemplate();
      gbc.gridx = 0;
      gbc.gridy = numCat;
      if (numCat == (catListComponent.getFavouriteListLen() - 1)) gbc.weighty = 1;
      lGrid.setConstraints(pFavCat, gbc);
      pContent.add(pFavCat);
      numCat++;
      gbc.weighty = 0;
      cat = catListComponent.getFavouriteCat(numCat);
    }

    this.pList = sObjGraphics.construirPanelBarra(pContent, 0, 60, 233, 450, Color.WHITE, null);
    this.pList.getVerticalScrollBar().setUI(
      sAdvancedGraphics.devolverScrollPersonalizado(
        7, 10,
        Color.WHITE,
        Color.LIGHT_GRAY,
        sResources.getColorGrisOscuro()
      )
    );
    this.add(pList);
    this.pList.revalidate();
  }

  public JPanel getPContent() { return pContent; }

  public JScrollPane getPList() { return pList; }
}
