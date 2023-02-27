package br.com.run2biz.denuncia.external.mapquestclient;

import java.util.List;

public class Result {

  private List<LocationResult> locations;

  public List<LocationResult> getLocations() {
    return locations;
  }

  public void setLocations(List<LocationResult> locations) {
    this.locations = locations;
  }
}
