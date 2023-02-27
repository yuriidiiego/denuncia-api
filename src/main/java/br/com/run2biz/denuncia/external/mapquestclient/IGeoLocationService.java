package br.com.run2biz.denuncia.external.mapquestclient;

import org.springframework.cache.annotation.Cacheable;

public interface IGeoLocationService {
  @Cacheable("reverseGeocode")
  GeoLocationResult reverseGeocode(Double latitude, Double longitude);
}
