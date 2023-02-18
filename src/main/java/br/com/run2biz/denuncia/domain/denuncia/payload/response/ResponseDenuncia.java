package br.com.run2biz.denuncia.domain.denuncia.payload.response;

import br.com.run2biz.denuncia.domain.denuncia.Denunciante;
import br.com.run2biz.denuncia.domain.endereco.Endereco;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ResponseDenuncia")
public class ResponseDenuncia {

  @Schema(description = "Identificador da denúncia", example = "1")
  private Long id;

  @Schema(description = "Latitude da denúncia", example = "51.509865")
  private Double latitude;

  @Schema(description = "Longitude da denúncia", example = "-0.118092")
  private Double longitude;

  @Schema(
    description = "Título da denúncia",
    example = "Denúncia de buraco na rua"
  )
  private String titulo;

  private String descricao;

  private Denunciante denunciante;

  private Endereco endereco;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
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

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
}
