package com.mycompany.catapp.services.graphicServices;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/** @author Cristian Felipe Patiño Cáceres Github: CrissUD*/

public class RecursosService {
  private GraficosAvanzadosService sGraficosAvanzados;
  private Color colorAzul, colorAzulOscuro, colorAzulClaro, colorAzulMarino, colorMorado;
  private Color colorGrisOscuro, colorGrisClaro, colorTransparente;
  private Font fontTPrincipal, fontTitulo, fontSubtitulo;
  private Font fontBotones, fontPequeña, fontTProducto;
  private Cursor cMano;
  private Border borderInferiorAzul, borderInferiorGris, bordeLateralAzul, borderGris, borderAzul;
  private Border bordeCircular, bordeRedondeado, bordeRedondeadoLineal, bordeDifuminado, bordeRedondeadoBoton;
  private ImageIcon iClose;

  private static RecursosService servicio;

  private RecursosService() {
    sGraficosAvanzados = GraficosAvanzadosService.getService();
    this.generarFuentes();
    this.personalizarJOptionPane();

    this.crearColores();
    this.crearFuentes();
    this.crearCursores();
    this.crearBordes();
    this.crearImagenes();
  }

  private void crearColores() {
    colorMorado = new Color(151, 0, 158);
    colorAzul = new Color(0, 112, 218);
    colorAzulOscuro = new Color(30, 48, 90);
    colorAzulClaro = new Color(231, 244, 253);
    colorAzulMarino = new Color(52, 195, 219);
    colorGrisOscuro = new Color(102, 102, 102);
    colorGrisClaro = new Color(243, 244, 247);
    colorTransparente = new Color(0, 0, 0, 0);
  }

  private void crearFuentes() {
    fontTitulo = new Font("Oswald", Font.PLAIN, 25);
    fontSubtitulo = new Font("Oswald", Font.PLAIN, 17);
    fontBotones = new Font("LuzSans-Book", Font.PLAIN, 16);
    fontPequeña = new Font("LuzSans-Book", Font.PLAIN, 12);
  }

  private void crearCursores() { cMano = new Cursor(Cursor.HAND_CURSOR); }

  private void crearBordes() {
    borderInferiorAzul = BorderFactory.createMatteBorder(0, 0, 2, 0, colorAzul);
    bordeLateralAzul = BorderFactory.createMatteBorder(2, 0, 2, 2, colorAzul);
    borderInferiorGris = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY);
    borderGris = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
    borderAzul = BorderFactory.createLineBorder(colorAzul, 2, true);
    bordeCircular = sGraficosAvanzados.DibujarBordeCircular(null, false, null);
    bordeRedondeado = sGraficosAvanzados.DibujarBordeRedondeado(null, 40, false, null);
    bordeRedondeadoLineal = sGraficosAvanzados.DibujarBordeRedondeado(colorAzulMarino, 40, true, null);
    bordeDifuminado = sGraficosAvanzados.devolverBordeDifuminado(new Color(215, 215, 215), 8);
    bordeRedondeadoBoton = BorderFactory.createCompoundBorder(bordeRedondeado, new EmptyBorder(new Insets(5, 20, 5, 5)));
  }

  private void crearImagenes() {
    iClose = new ImageIcon("assets/images/close.png");
  }

  private void generarFuentes() {
    try {
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont( Font.createFont(
          Font.TRUETYPE_FONT,
          new File("assets/fonts/LUZRO.ttf")
      ));
      ge.registerFont( Font.createFont(
          Font.TRUETYPE_FONT,
          new File("assets/fonts/Oswald-VariableFont_wght.ttf")
      ));
    } catch (IOException | FontFormatException e) {
      System.out.println(e);
    }
  }

  private void personalizarJOptionPane() {
    UIManager.put("OptionPane.background", Color.WHITE);
    UIManager.put("OptionPane.messageForeground", this.colorAzulOscuro);
    UIManager.put("Button.background", this.colorAzul);
    UIManager.put("Button.foreground", Color.WHITE);
    UIManager.put("Panel.background", Color.WHITE);
  }

  public Color getColorMorado() { return colorMorado; }

  public Color getColorAzul() { return colorAzul; }

  public Color getColorAzulOscuro() { return colorAzulOscuro; }

  public Color getColorAzulClaro() { return colorAzulClaro; }

  public Color getColorAzulMarino() { return colorAzulMarino; }

  public Color getColorGrisOscuro() { return colorGrisOscuro; }

  public Color getColorGrisClaro() { return colorGrisClaro; }

  public Color getColorTransparente() { return colorTransparente; }

  public Font getFontTProducto() { return fontTProducto; }

  public Font getFontTPrincipal() { return fontTPrincipal; }

  public Font getFontTitulo() { return fontTitulo; }

  public Font getFontSubtitulo() { return fontSubtitulo; }

  public Font getFontBotones() { return fontBotones; }

  public Font getFontPequeña() { return fontPequeña; }

  public Cursor getCMano() { return cMano; }

  public Border getBorderInferiorAzul() { return borderInferiorAzul; }

  public Border getBordeLateralAzul() { return bordeLateralAzul; }

  public Border getBorderInferiorGris() { return borderInferiorGris; }

  public Border getBorderGris() { return borderGris; }

  public Border getBorderAzul() { return borderAzul; }

  public Border getBordeCircular() { return bordeCircular; }

  public Border getBordeRedondeadoBoton() { return bordeRedondeadoBoton; }

  public Border getBordeRedondeado() { return bordeRedondeado; }

  public Border getBordeRedondeadoLineal() { return bordeRedondeadoLineal; }

  public Border getBordeDifuminado() { return bordeDifuminado; }

  public ImageIcon getIClose() { return iClose; }

  public static RecursosService getService() {
    if (servicio == null) servicio = new RecursosService();
    return servicio;
  }
}