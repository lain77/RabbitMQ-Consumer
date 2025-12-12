package producer.victor.projetoAvictor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import producer.victor.projetoAvictor.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
