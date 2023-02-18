package br.com.run2biz.denuncia.adapters;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.run2biz.denuncia.domain.denuncia.IDenunciaService;
import br.com.run2biz.denuncia.domain.denuncia.payload.request.CreateDenuncia;
import br.com.run2biz.denuncia.domain.denuncia.payload.response.ResponseDenuncia;

@RestController
@RequestMapping("/v1/denuncias")
@Tag(name = "Denúncias", description = "Controla as denúncias")
public class DenunciaController {

  private final IDenunciaService service;

  public DenunciaController(IDenunciaService service) {
    this.service = service;
  }

  @Operation(
    description = "Criar uma nova denúncia",
    operationId = "createDenuncia"
  )
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "201",
        description = "Denúncia criada com sucesso"
      ),
      @ApiResponse(responseCode = "400", description = "Solicitação inválida"),
      @ApiResponse(responseCode = "409", description = "Conflito de recurso"),
      @ApiResponse(
        responseCode = "500",
        description = "Erro interno do servidor"
      ),
    }
  )
  @PostMapping
  public ResponseEntity<ResponseDenuncia> createDenuncia(
    @Parameter(
      required = true,
      description = "Corpo da denúncia"
    ) @RequestBody CreateDenuncia denuncia
  ) {
    ResponseDenuncia response = service.criarDenuncia(denuncia);
    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(response.getId())
      .toUri();
    return ResponseEntity.created(location).body(response);
  }
}
