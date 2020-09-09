package com.mycompany.catapp.models;

import javax.swing.ImageIcon;
import java.awt.Image;

public class FavouriteCat {
  private String id; 
  private String user_id; 
  private String image_id; 
  private String sub_id; 
  private String created_at; 
  private CatImage image;
  private ImageIcon catPicture;

  public String getId() { return  id; }

  public String getUserId() { return  user_id; }

  public String getImageId() { return  image_id; }

  public String getSubId() { return  sub_id; }

  public String getCreateAt() { return  created_at; }

  public CatImage getImage() { return image; }

  public ImageIcon getCatPicture() { return catPicture; }

  public void setId(String id) {
    this.id = id;
  }

  public void setUserId(String user_id) {
    this.user_id = user_id;
  }

  public void setImageId(String image_id) {
    this.image_id = image_id;
  }

  public void setSubId(String sub_id) {
    this.sub_id = sub_id;
  }

  public void setCreateAt(String created_at) {
    this.created_at = created_at;
  }

  public void setImage(CatImage image) {
    this.image = image;
  }

  public void setCatPicture(Image catPicture) {
    this.catPicture = new ImageIcon(catPicture);
  }

  public class CatImage {
    private String id;
    private String url;

    public String getId() { return  id; }

    public String getUrl() { return  url; }

    public void setId(String id) {
      this.id = id;
    }

    public void setUrl(String url) {
      this.url = url;
    }
  }
}
