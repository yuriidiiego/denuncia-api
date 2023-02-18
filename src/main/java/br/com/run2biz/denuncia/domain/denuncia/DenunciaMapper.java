package br.com.run2biz.denuncia.domain.denuncia;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.run2biz.denuncia.domain.denuncia.payload.request.CreateDenuncia;
import br.com.run2biz.denuncia.domain.denuncia.payload.response.ResponseDenuncia;

@Mapper(componentModel = "spring")
public interface DenunciaMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "endereco", ignore = true)
  Denuncia toDenuncia(CreateDenuncia request);

  ResponseDenuncia toResponseDenuncia(Denuncia denuncia);
}
