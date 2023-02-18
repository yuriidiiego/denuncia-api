package br.com.run2biz.denuncia.domain.endereco;

public interface IEnderecoService {
  Endereco recuperarEndereco(Double latitude, Double longitude);
}
