package br.com.run2biz.denuncia.external.mapquestclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class MapQuestServiceImpl implements IMapQuestService {

  private final String geocodingUrl;

  private final RestTemplate restTemplate;

  public MapQuestServiceImpl(
    @Value("${geocoding.url}") String geocodingUrl,
    RestTemplate restTemplate
  ) {
    this.geocodingUrl = geocodingUrl;
    this.restTemplate = restTemplate;
  }

  @Override
  public GeoCodeResult reverseGeocode(Double latitude, Double longitude) {
    try {
      final ResponseEntity<GeoCodeResult> response = restTemplate.getForEntity(
        geocodingUrl + latitude + "," + longitude,
        GeoCodeResult.class
      );
      return response.getBody();
    } catch (RestClientException e) {
      throw new MapQuestException("Erro ao chamar API do MapQuest", e);
    }
  }
}
