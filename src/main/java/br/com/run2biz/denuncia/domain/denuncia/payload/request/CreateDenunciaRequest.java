package br.com.run2biz.denuncia.domain.denuncia.payload.request;

import br.com.run2biz.denuncia.domain.denuncia.Denunciante;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Schema(
  name = "CreateDenunciaRequest",
  description = "Dados para criação de uma denúncia"
)
public class CreateDenunciaRequest {

  @NotBlank
  @Schema(
    description = "Título da denúncia",
    example = "Denúncia de buraco na rua"
  )
  private String titulo;

  @NotBlank
  @Schema(
    description = "Descrição da denúncia",
    example = "Buraco na esquina da Avenida Paulista com Rua Augusta"
  )
  private String descricao;

  @NotNull(message = "latitude não pode ser nulo")
  @Schema(description = "Latitude da denúncia", example = "51.509865")
  private Double latitude;

  @NotNull(message = "longitude não pode ser nulo")
  @Schema(description = "Longitude da denúncia", example = "-0.118092")
  private Double longitude;

  @NotNull
  @Schema(description = "Denunciante que realizou a denúncia")
  private Denunciante denunciante;

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
