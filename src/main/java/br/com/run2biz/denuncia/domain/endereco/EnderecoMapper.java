package br.com.run2biz.denuncia.domain.endereco;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.run2biz.denuncia.external.mapquestclient.Location;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
  @Mapping(target = "cep", source = "postalCode")
  @Mapping(target = "logradouro", source = "street")
  @Mapping(target = "bairro", source = "adminArea6")
  @Mapping(target = "cidade", source = "adminArea5")
  @Mapping(target = "estado", source = "adminArea3")
  @Mapping(target = "pais", source = "adminArea1")
  Endereco toEndereco(Location location);
}
