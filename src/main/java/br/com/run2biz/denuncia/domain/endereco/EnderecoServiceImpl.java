package br.com.run2biz.denuncia.domain.endereco;

import org.springframework.stereotype.Service;

import br.com.run2biz.denuncia.external.mapquestclient.GeoLocationResult;
import br.com.run2biz.denuncia.external.mapquestclient.IGeoLocationService;
import br.com.run2biz.denuncia.external.mapquestclient.LocationResult;

@Service
public class EnderecoServiceImpl implements IEnderecoService {

  private final IGeoLocationService service;
  private final EnderecoMapper enderecoMapper;

  public EnderecoServiceImpl(
    IGeoLocationService service,
    EnderecoMapper enderecoMapper
  ) {
    this.service = service;
    this.enderecoMapper = enderecoMapper;
  }

  @Override
  public Endereco recuperarEndereco(Double latitude, Double longitude) {
    GeoLocationResult result = service.reverseGeocode(latitude, longitude);

    if (result.getResults().isEmpty()) {
      throw new EnderecoNaoEncontradoException(
        "Não foi possível encontrar o endereço da denúncia."
      );
    }

    LocationResult location = result.getResults().get(0).getLocations().get(0);
    return enderecoMapper.toEndereco(location);
  }
}
