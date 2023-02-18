package br.com.run2biz.denuncia.domain.endereco;

public class EnderecoNaoEncontradoException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public EnderecoNaoEncontradoException() {
    super();
  }

  public EnderecoNaoEncontradoException(String message, Throwable cause) {
    super(message, cause);
  }

  public EnderecoNaoEncontradoException(String message) {
    super(message);
  }

  public EnderecoNaoEncontradoException(Throwable cause) {
    super(cause);
  }
}
