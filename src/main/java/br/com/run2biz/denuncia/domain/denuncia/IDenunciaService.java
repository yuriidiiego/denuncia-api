package br.com.run2biz.denuncia.domain.denuncia;

import br.com.run2biz.denuncia.domain.denuncia.payload.request.CreateDenuncia;
import br.com.run2biz.denuncia.domain.denuncia.payload.response.ResponseDenuncia;

public interface IDenunciaService {
  ResponseDenuncia criarDenuncia(CreateDenuncia denuncia);
}
