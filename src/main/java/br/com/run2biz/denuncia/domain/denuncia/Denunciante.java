package br.com.run2biz.denuncia.domain.denuncia;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "denunciante")
@Schema(
  name = "Denunciante",
  description = "Enttidade que representa um denunciante"
)
public class Denunciante {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Identificador do denunciante", example = "1")
  private Long id;

  @NotNull
  @Column(name = "nome")
  @Schema(
    description = "Nome do denunciante",
    example = "José da Silva"
  )
  private String nome;

  @NotNull
  @Column(name = "cpf")
  @Schema(
    description = "CPF do denunciante",
    example = "123.456.789-10"
  )
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
