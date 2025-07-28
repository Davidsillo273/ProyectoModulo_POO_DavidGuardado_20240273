package DavidGuardado_20240273.DavidGuardado_20240273.Services;

import DavidGuardado_20240273.DavidGuardado_20240273.Entities.EntityProvider;
import DavidGuardado_20240273.DavidGuardado_20240273.Models.DTO.DTOProvider;
import DavidGuardado_20240273.DavidGuardado_20240273.Repositories.RepositoryProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//Anotaciones
@Slf4j
@Service
public class ServiceProvider {

    //Se obtiene los métodos Repository
    @Autowired
    RepositoryProvider repo;

    public List<DTOProvider> getProviders() {
        List<EntityProvider> list = repo.findAll();
        return list.stream()
                .map(this::ConvertToDTO)
                .collect(Collectors.toList());
    }

    private DTOProvider ConvertToDTO(EntityProvider entity) {
        DTOProvider dto = new DTOProvider();
        dto.setProviderID(entity.getProviderID());
        return dto;
    }

}
