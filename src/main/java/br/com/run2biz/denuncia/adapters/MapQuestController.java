package br.com.run2biz.denuncia.adapters;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.run2biz.denuncia.external.mapquestclient.GeoLocationResult;
import br.com.run2biz.denuncia.external.mapquestclient.IGeoLocationService;

@Tag(name = "Geocoding API", description = "Reverse geocoding API")
@RestController
public class MapQuestController {

  private IGeoLocationService mapQuestService;

  public MapQuestController(IGeoLocationService mapQuestService) {
    this.mapQuestService = mapQuestService;
  }

  @Operation(
    summary = "Reverse geocoding",
    description = "Reverse geocoding API",
    operationId = "geocode",
    tags = { "Geocoding API" }
  )
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "success",
        content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = GeoLocationResult.class)
        )
      ),
      @ApiResponse(responseCode = "404", description = "geocode not found"),
    }
  )
  @GetMapping("/geocode")
  public ResponseEntity<GeoLocationResult> geocode(
    @Parameter(
      description = "Latitude to reverse geocode",
      required = true,
      example = "47.605554"
    ) @RequestParam("lat") Double latitude,
    @Parameter(
      description = "Longitude to reverse geocode",
      required = true,
      example = "-122.332099"
    ) @RequestParam("lng") Double longitude
  ) {
    GeoLocationResult geocodeResult = mapQuestService.reverseGeocode(
      latitude,
      longitude
    );

    return ResponseEntity.ok(geocodeResult);
  }
}
