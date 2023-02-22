package br.com.run2biz.denuncia.domain.denuncia;

import br.com.run2biz.denuncia.domain.denuncia.payload.request.CreateDenunciaRequest;
import br.com.run2biz.denuncia.domain.denuncia.payload.response.DenunciaResponse;
import br.com.run2biz.denuncia.domain.endereco.Endereco;
import br.com.run2biz.denuncia.domain.endereco.IEnderecoService;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DenunciaServiceImpl implements IDenunciaService {

  private final DenunciaRepository denunciaRepository;
  private final DenunciaMapper denunciaMapper;
  private final IEnderecoService enderecoService;

  public DenunciaServiceImpl(
    DenunciaRepository denunciaRepository,
    DenunciaMapper denunciaMapper,
    IEnderecoService enderecoService
  ) {
    this.denunciaRepository = denunciaRepository;
    this.denunciaMapper = denunciaMapper;
    this.enderecoService = enderecoService;
  }

  @Transactional
  public DenunciaResponse criarDenuncia(
    CreateDenunciaRequest createDenunciaRequest
  ) {
    Denuncia denuncia = denunciaMapper.toDenuncia(createDenunciaRequest);
    Endereco endereco = enderecoService.recuperarEndereco(
      createDenunciaRequest.getLatitude(),
      createDenunciaRequest.getLongitude()
    );
    denuncia.setEndereco(endereco);
    Denuncia savedDenuncia = denunciaRepository.save(denuncia);

    return denunciaMapper.toResponseDenuncia(savedDenuncia);
  }
}
