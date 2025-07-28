package DavidGuardado_20240273.DavidGuardado_20240273.Repositories;

import DavidGuardado_20240273.DavidGuardado_20240273.Entities.EntityProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProvider extends JpaRepository<EntityProvider, Long> {
//    static boolean existById(Long id) {
//        return false;
//    }
//
//    static void deletebyId(Long id) {
//    }
}
