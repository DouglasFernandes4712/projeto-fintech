package br.com.fiap.fintech.Fintech.repository;

import br.com.fiap.fintech.Fintech.model.LoginModel;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginModel, Long> {
}
