package com.mycompany.catapp.client.mainView;

import java.awt.Color;
// import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.mycompany.catapp.services.graphicServices.GraficosAvanzadosService;
import com.mycompany.catapp.services.graphicServices.ObjGraficosService;
import com.mycompany.catapp.services.graphicServices.RecursosService;

public class MainViewTemplate extends JFrame{
  private static final long serialVersionUID = 1L;

  //Declaración servicios y objetos
  private MainViewComponent mainViewComponent;
  private ObjGraficosService sObjGraphics;
  private RecursosService sResources;
  private GraficosAvanzadosService sAdvancedGraphics;

  //Declaración Objetos Gráficos
  private JPanel pNav, pBar, pMain;
  private JScrollPane pContent;
  
  public MainViewTemplate (MainViewComponent mainViewComponent) {
    this.mainViewComponent = mainViewComponent;
    this.mainViewComponent.getClass();
    this.sObjGraphics = ObjGraficosService.getService();
    this.sResources = RecursosService.getService();
    this.sAdvancedGraphics = GraficosAvanzadosService.getService();

    this.createJPanels();
    // JPanel pContenido = sObjGraphics.construirJPanel(0, 0, 0, 0, Color.BLUE, null);
    // pContenido.setPreferredSize(new Dimension(733, 1200));
    // this.createContent(pContenido);

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(1000, 600);
    this.setLocationRelativeTo(this);
    this.setLayout(null);
    this.setUndecorated(true);
    this.getContentPane().setBackground(sResources.getColorAzul());
  }

  private void createJPanels() {
    this.pMain = sObjGraphics.construirJPanel(219, 5, 776, 590, Color.WHITE, sResources.getBordeRedondeado());
    this.add(pMain);

    this.pNav = sObjGraphics.construirJPanel(0, 0, 220, 600, sResources.getColorAzul(), null);
    this.add(pNav);

    this.pBar = sObjGraphics.construirJPanel(10, 5, 750, 50, Color.WHITE, null);
    pMain.add(pBar);
  }

  public void createContent(JPanel panel) {
    this.pContent = sObjGraphics.construirPanelBarra(panel, 10, 60, 750, 510, Color.WHITE, null);
    this.pContent.getVerticalScrollBar().setUI(
      sAdvancedGraphics.devolverScrollPersonalizado(
        7, 10,
        Color.WHITE,
        Color.LIGHT_GRAY,
        sResources.getColorGrisOscuro()
      )
    );
    this.pMain.add(pContent);
    this.pContent.revalidate();
  }

  public JPanel getPNav(){ return pNav; }

  public JPanel getPBar(){ return pBar; }
}
