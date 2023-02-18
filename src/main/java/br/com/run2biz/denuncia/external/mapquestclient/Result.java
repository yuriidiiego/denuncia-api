package br.com.run2biz.denuncia.external.mapquestclient;

import java.util.List;

public class Result {

  private List<Location> locations;

  public List<Location> getLocations() {
    return locations;
  }

  public void setLocations(List<Location> locations) {
    this.locations = locations;
  }
}
