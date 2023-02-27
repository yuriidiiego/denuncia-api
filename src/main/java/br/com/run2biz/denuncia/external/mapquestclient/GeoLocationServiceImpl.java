package br.com.run2biz.denuncia.external.mapquestclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoLocationServiceImpl implements IGeoLocationService {

  private final String mapQuestGeocodingUrl;
  private final RestTemplate restTemplate;

  public GeoLocationServiceImpl(
    @Value("${geocoding.mapquest.url}") String mapQuestGeocodingUrl,
    RestTemplate restTemplate
  ) {
    this.mapQuestGeocodingUrl = mapQuestGeocodingUrl;
    this.restTemplate = restTemplate;
  }

  @Override
  public GeoLocationResult reverseGeocode(Double latitude, Double longitude) {
    try {
      String url = mapQuestGeocodingUrl + latitude + "," + longitude;
      ResponseEntity<GeoLocationResult> response = restTemplate.getForEntity(
        url,
        GeoLocationResult.class
      );
      return response.getBody();
    } catch (RestClientException e) {
      throw new GeoLocationException("Erro ao chamar API de geolocalização", e);
    }
  }
}
