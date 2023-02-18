package br.com.run2biz.denuncia.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
  info = @Info(
    title = "API para denúncia",
    version = "1.0",
    description = "API para denunciar irregularidades na sua cidade",
    license = @License(
      name = "Apache 2.0",
      url = "http://www.apache.org/licenses/LICENSE-2.0.html"
    ),
    contact = @Contact(
      name = "Yuri Nascimento",
      email = "yuriidiiego@gmail.com",
      url = "https://github.com/yuriidiiego"
    )
  ),
  servers = {
    @Server(url = "http://localhost:8080", description = "Local server"),
  }
)
public class OpenApiConfig {}
