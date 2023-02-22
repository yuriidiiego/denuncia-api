package br.com.run2biz.denuncia.adapters;

import br.com.run2biz.denuncia.domain.denuncia.IDenunciaService;
import br.com.run2biz.denuncia.domain.denuncia.payload.request.CreateDenunciaRequest;
import br.com.run2biz.denuncia.domain.denuncia.payload.response.DenunciaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.net.URI;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/denuncias")
@Tag(name = "Denúncias", description = "Endpoint para gerenciar as denúncias")
public class DenunciaController {

  private final IDenunciaService denunciaService;

  public DenunciaController(IDenunciaService denunciaService) {
    this.denunciaService = denunciaService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Criar nova denúncia")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "201",
        description = "Denúncia criada com sucesso"
      ),
      @ApiResponse(responseCode = "400", description = "Requisição inválida"),
      @ApiResponse(responseCode = "409", description = "Conflito de recurso"),
      @ApiResponse(
        responseCode = "500",
        description = "Erro interno no servidor"
      ),
    }
  )
  public ResponseEntity<DenunciaResponse> createDenuncia(
    @Valid @RequestBody CreateDenunciaRequest createDenunciaRequest
  ) {
    DenunciaResponse responseDenuncia = denunciaService.criarDenuncia(
      createDenunciaRequest
    );

    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(responseDenuncia.getId())
      .toUri();

    return ResponseEntity.created(location).body(responseDenuncia);
  }
}
