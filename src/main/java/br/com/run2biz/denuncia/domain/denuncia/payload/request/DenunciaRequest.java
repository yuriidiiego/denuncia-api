package br.com.run2biz.denuncia.domain.denuncia.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Schema(
  name = "DenunciaRequest",
  description = "Dados para criação de uma denúncia"
)
public class DenunciaRequest {

  @NotBlank(message = "O título da denúncia é obrigatório")
  @Schema(
    description = "Título da denúncia",
    example = "Denúncia de buraco na rua"
  )
  private String titulo;

  @NotBlank(message = "A descrição da denúncia é obrigatória")
  @Schema(
    description = "Descrição da denúncia",
    example = "Buraco na esquina da Avenida Paulista com Rua Augusta"
  )
  private String descricao;

  @NotNull(message = "latitude não pode ser nulo")
  @DecimalMin(
    value = "-90.0",
    inclusive = true,
    message = "Latitude deve ser maior ou igual a -90.0"
  )
  @DecimalMax(
    value = "90.0",
    inclusive = true,
    message = "Latitude deve ser menor ou igual a 90.0"
  )
  @Schema(description = "Latitude da denúncia", example = "51.509865")
  private Double latitude;

  @NotNull(message = "longitude não pode ser nulo")
  @DecimalMin(
    value = "-180.0",
    inclusive = true,
    message = "Longitude deve ser maior ou igual a -180.0"
  )
  @DecimalMax(
    value = "180.0",
    inclusive = true,
    message = "Longitude deve ser menor ou igual a 180.0"
  )
  @Schema(description = "Longitude da denúncia", example = "-0.118092")
  private Double longitude;

  @Valid
  @Schema(description = "Denunciante que realizou a denúncia")
  private DenuncianteRequest denunciante;

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

  public DenuncianteRequest getDenunciante() {
    return denunciante;
  }

  public void setDenunciante(DenuncianteRequest denunciante) {
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
