package br.com.run2biz.denuncia.domain.denuncia.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

@Schema(description = "Dados para criação de um denunciante")
public class DenuncianteRequest {

  @NotNull
  @NotBlank(message = "O nome do denunciante é obrigatório")
  @Schema(description = "Nome do denunciante", example = "João Silva")
  private String nome;

  @NotNull
  @CPF(message = "CPF inválido")
  @Schema(description = "CPF do denunciante", example = "123.456.789-10")
  private String cpf;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
