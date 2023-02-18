package br.com.run2biz.denuncia.domain.denuncia.payload.request;

import br.com.run2biz.denuncia.domain.denuncia.Denunciante;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CreateDenuncia")
public class CreateDenuncia {

  @Schema(description = "Latitude da denúncia", example = "51.509865")
  private Double latitude;

  @Schema(description = "Longitude da denúncia", example = "-0.118092")
  private Double longitude;

  private Denunciante denunciante;

  private String titulo;

  private String descricao;

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
