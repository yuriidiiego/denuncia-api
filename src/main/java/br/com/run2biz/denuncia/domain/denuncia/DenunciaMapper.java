package br.com.run2biz.denuncia.domain.denuncia;

import br.com.run2biz.denuncia.domain.denuncia.payload.request.DenunciaRequest;
import br.com.run2biz.denuncia.domain.denuncia.payload.response.DenunciaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DenunciaMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "endereco", ignore = true)
  Denuncia toDenuncia(DenunciaRequest createDenunciaRequest);

  DenunciaResponse toResponseDenuncia(Denuncia denuncia);
}
