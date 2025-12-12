package producer.victor.projetoAvictor.service;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import producer.victor.projetoAvictor.dto.CompanyDTO;
import producer.victor.projetoAvictor.entity.Company;
import producer.victor.projetoAvictor.repository.CompanyRepository;

@Component
public class RabbitConsumer {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public RabbitConsumer(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @RabbitListener(queues = "${app.queue}")
    public void receberMensagem(CompanyDTO dto) {

        System.out.println("Mensagem recebida do RabbitMQ:");
        System.out.println(dto);

        Company company = new Company();
        company.setName(dto.getName());
        company.setDescription(dto.getDescription());
        company.setCountry(dto.getCountry());

        companyRepository.save(company);

        System.out.println("Empresa salva no banco com sucesso!");
    }
}