package com.mycompany.catapp.services.logicServices;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;

import com.mycompany.catapp.models.Cat;
import com.mycompany.catapp.models.FavouriteCat;

/**
 * @author CrissUD / Cristian Patiño
 */
public class CatService {

  private static CatService servicio;
  private FavouriteCat[] favouriteCatList;
  private final String API_KEY = "a91bbd76-2104-425f-b02e-5b675babd788";
  private final String URL = "https://api.thecatapi.com/v1/";

  public Cat getCat() {
    try {
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder()
        .url(URL + "images/search?")
        .method("GET", null)
        .build();
      Response response = client.newCall(request).execute();
  
      String data = response.body().string();
  
      data = data.substring(1, data.length());
      data = data.substring(0, (data.length() - 1));
  
      Gson gson = new Gson();
      Cat cat = gson.fromJson(data, Cat.class);
  
      return cat;
    } catch (IOException ex) {
      System.out.println(ex);
    }
    return null;
  }

  public Boolean saveFavourite(Cat cat) {
    try {
      OkHttpClient client = new OkHttpClient();
      MediaType mediaType = MediaType.parse("application/json");
      RequestBody body = RequestBody.create(mediaType, "{\r\n    \"image_id\": \""+ cat.getId() +"\"\r\n}");
      Request request = new Request.Builder()
        .url(URL + "favourites")
        .method("POST", body)
        .addHeader("Content-Type", "application/json")
        .addHeader("x-api-key", API_KEY)
        .build();
      Response response = client.newCall(request).execute();
      if(response.code() == 200)
        return true;
    } catch (IOException ex) {
      System.out.println(ex);
    }
    return false;
  }

  public FavouriteCat[] getFavouriteList() {
    try {
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder()
        .url(URL + "favourites")
        .method("GET", null)
        .addHeader("x-api-key", API_KEY)
        .build();
      Response response = client.newCall(request).execute();

      String data = response.body().string();
  
      Gson gson = new Gson();
      favouriteCatList = gson.fromJson(data, FavouriteCat[].class);

      if(favouriteCatList.length > 0)
        return favouriteCatList;
    } catch (IOException ex) {
      System.out.println(ex);
    }
    return null;
  }

  public Boolean deleteFavourite (FavouriteCat cat) {
    try {
      OkHttpClient client = new OkHttpClient();
      MediaType mediaType = MediaType.parse("text/plain");
      RequestBody body = RequestBody.create(mediaType, "");
      Request request = new Request.Builder()
        .url(URL + "favourites/" + cat.getId())
        .method("DELETE", body)
        .addHeader("x-api-key", API_KEY)
        .build();
      Response response = client.newCall(request).execute();
      if(response.code() == 200)
        return true;
    } catch (IOException ex) {
      System.out.println(ex);
    }
    return false;
  }

  public FavouriteCat getFavouriteCat(int position) {
    try {
      return favouriteCatList[position];
    } catch (Exception e) {
      return null;
    }
  }

  public static CatService getService() {
    if (servicio == null) servicio = new CatService();
    return servicio;
  }
}
