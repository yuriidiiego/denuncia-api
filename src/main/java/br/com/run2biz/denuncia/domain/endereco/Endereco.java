package br.com.run2biz.denuncia.domain.endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "endereco")
@Schema(name = "Endereço", description = "Entidade que representa um endereço")
public class Endereco {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Identificador do endereço", example = "1")
  private Long id;

  @NotNull
  @Column(name = "cep")
  @Schema(description = "CEP do endereço", example = "12345678")
  private String cep;

  @NotNull
  @Column(name = "logradouro")
  @Schema(description = "Logradouro do endereço", example = "Rua das Palmeiras")
  private String logradouro;

  @NotNull
  @Column(name = "bairro")
  @Schema(description = "Bairro do endereço", example = "Centro")
  private String bairro;

  @NotNull
  @Column(name = "cidade")
  @Schema(description = "Cidade do endereço", example = "São Paulo")
  private String cidade;

  @NotNull
  @Column(name = "estado")
  @Schema(description = "Estado do endereço", example = "SP")
  private String estado;

  @NotNull
  @Column(name = "pais")
  @Schema(description = "País do endereço", example = "Brasil")
  private String pais;

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }
}
