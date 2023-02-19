package br.com.run2biz.denuncia.domain.denuncia;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.run2biz.denuncia.domain.denuncia.payload.request.CreateDenunciaRequest;
import br.com.run2biz.denuncia.domain.denuncia.payload.response.ResponseDenuncia;

@Mapper(componentModel = "spring")
public interface DenunciaMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "endereco", ignore = true)
  Denuncia toDenuncia(CreateDenunciaRequest request);

  ResponseDenuncia toResponseDenuncia(Denuncia denuncia);
}
