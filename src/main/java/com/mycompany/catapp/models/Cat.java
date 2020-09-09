package com.mycompany.catapp.models;

/**
 * @author CrissUD / Cristian Patiño
 */
public class Cat {
  private String id;
  private String url;
  private String width;
  private String height;

  public String getId() { return id; }

  public String getUrl() { return url; }

  public int getWidth() { return Integer.parseInt(width); }

  public int getHeight() { return Integer.parseInt(height); }

  public void setId(String id) {
    this.id = id;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setWidth(String width) {
    this.width = width;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  
}