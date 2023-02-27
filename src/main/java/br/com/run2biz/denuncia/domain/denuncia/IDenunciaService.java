package br.com.run2biz.denuncia.domain.denuncia;

import br.com.run2biz.denuncia.domain.denuncia.payload.request.DenunciaRequest;
import br.com.run2biz.denuncia.domain.denuncia.payload.response.DenunciaResponse;

public interface IDenunciaService {
  DenunciaResponse criarDenuncia(DenunciaRequest createDenunciaRequest);
}
