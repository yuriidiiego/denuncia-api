package br.com.run2biz.denuncia.domain.denuncia;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "denunciante")
@Schema(description = "Representa a entidade Denunciante")
public class Denunciante {

  @Schema(description = "Identificador da denúncia", example = "1")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome")
  @Schema(description = "Nome do denunciante", example = "João da Silva")
  private String nome;

  @Column(name = "cpf")
  @Schema(description = "CPF do denunciante", example = "70989098230")
  private String cpf;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
