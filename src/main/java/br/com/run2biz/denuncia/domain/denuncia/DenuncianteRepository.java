package br.com.run2biz.denuncia.domain.denuncia;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenuncianteRepository
  extends JpaRepository<Denunciante, Long> {
  Optional<Denunciante> findByCpf(String cpf);
}
