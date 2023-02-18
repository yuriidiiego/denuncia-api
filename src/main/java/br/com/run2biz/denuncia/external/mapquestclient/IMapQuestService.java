package br.com.run2biz.denuncia.external.mapquestclient;

import org.springframework.cache.annotation.Cacheable;

public interface IMapQuestService {
  @Cacheable("reverseGeocode")
  GeoCodeResult reverseGeocode(Double latitude, Double longitude);
}
