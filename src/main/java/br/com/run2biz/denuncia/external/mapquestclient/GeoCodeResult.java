package br.com.run2biz.denuncia.external.mapquestclient;

import java.util.List;

public class GeoCodeResult {

  private List<Result> results;

  public List<Result> getResults() {
    return results;
  }

  public void setResults(List<Result> results) {
    this.results = results;
  }
}
