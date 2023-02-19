package br.com.run2biz.denuncia.domain.denuncia;

import br.com.run2biz.denuncia.domain.denuncia.payload.request.CreateDenuncia;
import br.com.run2biz.denuncia.domain.denuncia.payload.response.ResponseDenuncia;
import br.com.run2biz.denuncia.domain.endereco.Endereco;
import br.com.run2biz.denuncia.domain.endereco.IEnderecoService;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DenunciaServiceImpl implements IDenunciaService {

  private final DenunciaRepository denunciaRepository;
  private final DenunciaMapper denunciaMapper;
  private final IEnderecoService service;

  public DenunciaServiceImpl(
    final DenunciaRepository denunciaRepository,
    final DenunciaMapper denunciaMapper,
    final IEnderecoService service
  ) {
    this.denunciaRepository = denunciaRepository;
    this.denunciaMapper = denunciaMapper;
    this.service = service;
  }

  @Transactional
  public ResponseDenuncia criarDenuncia(CreateDenuncia createDenunciaRequest) {
    Denuncia denuncia = denunciaMapper.toDenuncia(createDenunciaRequest);
    Endereco endereco = service.recuperarEndereco(
      createDenunciaRequest.getLatitude(),
      createDenunciaRequest.getLongitude()
    );
    denuncia.setEndereco(endereco);
    Denuncia savedDenuncia = denunciaRepository.save(denuncia);

    return denunciaMapper.toResponseDenuncia(savedDenuncia);
  }
}
