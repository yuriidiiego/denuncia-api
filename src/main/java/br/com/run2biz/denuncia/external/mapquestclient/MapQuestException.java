package br.com.run2biz.denuncia.external.mapquestclient;

import org.springframework.web.client.RestClientException;

public class MapQuestException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public MapQuestException(String message, Throwable cause) {
    super(message, cause);
  }

  public MapQuestException(Throwable cause) {
    super(cause);
  }

  public MapQuestException(String message) {
    super(message);
  }

  public MapQuestException(String message, RestClientException e) {
    super(message, e);
  }
}
