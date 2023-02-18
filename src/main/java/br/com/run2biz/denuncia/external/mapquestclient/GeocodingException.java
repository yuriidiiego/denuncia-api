package br.com.run2biz.denuncia.external.mapquestclient;

public class GeocodingException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public GeocodingException(String message) {
    super(message);
  }

  public GeocodingException(String message, Throwable cause) {
    super(message, cause);
  }

  public GeocodingException(Throwable cause) {
    super(cause);
  }
}
