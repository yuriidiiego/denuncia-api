package br.com.run2biz.denuncia.domain.denuncia;

public class DenunciaExistenteException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public DenunciaExistenteException() {
    super();
  }

  public DenunciaExistenteException(String message, Throwable cause) {
    super(message, cause);
  }

  public DenunciaExistenteException(String message) {
    super(message);
  }

  public DenunciaExistenteException(Throwable cause) {
    super(cause);
  }
}
