package br.com.run2biz.denuncia.domain.endereco;

import org.springframework.stereotype.Service;

import br.com.run2biz.denuncia.external.mapquestclient.GeoCodeResult;
import br.com.run2biz.denuncia.external.mapquestclient.IMapQuestService;
import br.com.run2biz.denuncia.external.mapquestclient.Location;

@Service
public class EnderecoServiceImpl implements IEnderecoService {

  private final IMapQuestService service;
  private final EnderecoMapper enderecoMapper;

  public EnderecoServiceImpl(
    IMapQuestService service,
    EnderecoMapper enderecoMapper
  ) {
    this.service = service;
    this.enderecoMapper = enderecoMapper;
  }

  @Override
  public Endereco recuperarEndereco(Double latitude, Double longitude) {
    GeoCodeResult result = service.reverseGeocode(latitude, longitude);

    if (result.getResults().isEmpty()) {
      throw new EnderecoNaoEncontradoException(
        "Não foi possível encontrar o endereço da denúncia."
      );
    }

    Location location = result.getResults().get(0).getLocations().get(0);
    return enderecoMapper.toEndereco(location);
  }
}
