package DavidGuardado_20240273.DavidGuardado_20240273.Services;

import DavidGuardado_20240273.DavidGuardado_20240273.Entities.EntityProvider;
import DavidGuardado_20240273.DavidGuardado_20240273.Exceptions.ExceptionProviderNotFound;
import DavidGuardado_20240273.DavidGuardado_20240273.Exceptions.ExceptionProviderNotRegistred;
import DavidGuardado_20240273.DavidGuardado_20240273.Models.DTO.DTOProvider;
import DavidGuardado_20240273.DavidGuardado_20240273.Repositories.RepositoryProvider;
import jakarta.validation.Valid;
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
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private DTOProvider convertToDTO(EntityProvider entity) {
        DTOProvider dto = new DTOProvider();
        dto.setProviderID(entity.getProviderID());
        dto.setProviderName(entity.getProviderName());
        dto.setProviderPhone(entity.getProviderPhone());
        dto.setProviderAddress(entity.getProviderAddress());
        dto.setProviderEmail(entity.getProviderEmail());
        dto.setProviderCode(entity.getProviderCode());
        dto.setProviderStatus(entity.getProviderStatus());
        dto.setProviderComments(entity.getProviderComments());
        return dto;
    }

    private EntityProvider convertToEntity(@Valid DTOProvider json) {
        EntityProvider entity = new EntityProvider();
        entity.setProviderID(json.getProviderID());
        entity.setProviderName(json.getProviderName());
        entity.setProviderPhone(json.getProviderPhone());
        entity.setProviderAddress(json.getProviderAddress());
        entity.setProviderEmail(json.getProviderEmail());
        entity.setProviderCode(json.getProviderCode());
        entity.setProviderStatus(json.getProviderStatus());
        entity.setProviderComments(json.getProviderComments());
        return entity;
    }

    public DTOProvider insertProvider(@Valid DTOProvider json) {

        //Se valida que no sea nulo ningún campo
        if (json == null || json.getProviderName() == null || json.getProviderPhone() == null || json.getProviderAddress() == null || json.getProviderEmail() == null || json.getProviderCode() == null || json.getProviderStatus() == null || json.getProviderComments() == null ||

                //Se valida que no vaya vacio
                json.getProviderName().isEmpty() || json.getProviderAddress().isEmpty() || json.getProviderEmail().isEmpty() || json.getProviderComments().isEmpty()
        ) {
            throw new IllegalArgumentException("Los campos no puede ni deben ser nulos");
        }
        try {
            EntityProvider entity = convertToEntity(json);
            EntityProvider answer = repo.save(entity);
            return convertToDTO(answer);
        }catch (Exception e){
            log.error("Error al registrar el proveedor: " + e.getMessage());
            throw new ExceptionProviderNotRegistred("Error");
        }
    }

    public DTOProvider updateProvider(Long id, @Valid DTOProvider json) {

        EntityProvider providerExist = repo.findById(id).orElseThrow(() -> new ExceptionProviderNotFound("Proveedor no encontrado"));

        providerExist.setProviderName(json.getProviderName());
        providerExist.setProviderPhone(json.getProviderPhone());
        providerExist.setProviderAddress(json.getProviderAddress());
        providerExist.setProviderEmail(json.getProviderEmail());
        providerExist.setProviderCode(json.getProviderCode());
        providerExist.setProviderStatus(json.getProviderStatus());
        providerExist.setProviderComments(json.getProviderComments());

        EntityProvider providerUpdate = repo.save(providerExist);

        return convertToDTO(providerUpdate);
    }

//    public boolean deleteProvider(Long id){
//        if (RepositoryProvider.existById(id)){
//            RepositoryProvider.deletebyId(id);
//            return true;
//        }
//        return false;
//    }
}
