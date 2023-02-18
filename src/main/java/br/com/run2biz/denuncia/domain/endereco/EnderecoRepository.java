package br.com.run2biz.denuncia.domain.endereco;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
  boolean existsByCep(String cep);
}
