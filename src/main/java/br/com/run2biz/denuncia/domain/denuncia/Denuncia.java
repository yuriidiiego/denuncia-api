package br.com.run2biz.denuncia.domain.denuncia;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.run2biz.denuncia.domain.endereco.Endereco;

@Entity
@Table(name = "denuncia")
@Schema(name = "Denúncia", description = "Informações sobre uma denúncia")
public class Denuncia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "ID da denúncia", example = "1")
  private Long id;

  @Column(name = "latitude")
  @Schema(description = "Latitude da denúncia", example = "-23.5489")
  private Double latitude;

  @Column(name = "longitude")
  @Schema(description = "Longitude da denúncia", example = "-46.6388")
  private Double longitude;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "denunciante_id")
  @Schema(description = "Informações do denunciante")
  private Denunciante denunciante;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "endereco_cep", referencedColumnName = "cep")
  @Schema(description = "Endereço da denúncia")
  private Endereco endereco;

  @Column(nullable = false)
  private String titulo;

  @Column(nullable = false)
  private String descricao;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Denunciante getDenunciante() {
    return denunciante;
  }

  public void setDenunciante(Denunciante denunciante) {
    this.denunciante = denunciante;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
