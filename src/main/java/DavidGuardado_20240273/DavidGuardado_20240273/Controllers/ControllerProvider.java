package DavidGuardado_20240273.DavidGuardado_20240273.Controllers;

import DavidGuardado_20240273.DavidGuardado_20240273.Entities.EntityProvider;
import DavidGuardado_20240273.DavidGuardado_20240273.Exceptions.ExceptionProviderNotFound;
import DavidGuardado_20240273.DavidGuardado_20240273.Models.DTO.DTOProvider;
import DavidGuardado_20240273.DavidGuardado_20240273.Services.ServiceProvider;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Anotaciones
@RestController
@RequestMapping("/apiProvider") //Ruta del EndPoint
public class ControllerProvider {

    @Autowired
    ServiceProvider service;

    //localhost:8080/apiProvider/getData
    @GetMapping("/getData")
    //Se pide una lista para obtener a los proveedores
    public List<DTOProvider> getAllData() {
        return service.getProviders();
    }

    //localhost:8080/apiProvider/insertData
    @PostMapping("/insertData")
    //Para insertar datos
    public ResponseEntity<?> newProvider(@Valid @RequestBody DTOProvider json, HttpServletRequest request) {
        try {
            DTOProvider answer = service.insertProvider(json);
            if (answer == null) {
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "Insercción fallida",
                        "errorType", "VALIDATION_ERROR",
                        "message", "Los datos no pudieron ser registrados"
                ));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status", "Success",
                    "data", answer
            ));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "Error",
                    "message", "Error no controlado al registrar",
                    "detail", e.getMessage()
            ));
        }
    }

    //localhost:8080/apiProvider/updateData
    @PutMapping("/updateData")                                                                           //Resultado de validación
    public ResponseEntity<?> updateProvider(@PathVariable Long id, @Valid @RequestBody DTOProvider json, BindingResult bindingResult) {
        //Verifica si hay errores
        if (bindingResult.hasErrors()){
            Map<String, String>errors = new HashMap<>();
            //Itera cada error
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            //Retornar error HTTP 400 (bad Request)
            return ResponseEntity.badRequest().body(errors);
        }
        try {
            DTOProvider dto = service.updateProvider(id, json);
            return ResponseEntity.ok(dto);
        }
        catch (ExceptionProviderNotFound e){
            return ResponseEntity.notFound().build();
        }
//        catch (ExceptionProviderDuplicate e) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
////                    "Error", "Datos duplicados",
////                    "Field", e.getField()
//            ));
//        }
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProvider(@PathVariable Long id){
//        boolean deleted = ServiceProvider.deleteProvider(id);
//        if (deleted){
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
}
