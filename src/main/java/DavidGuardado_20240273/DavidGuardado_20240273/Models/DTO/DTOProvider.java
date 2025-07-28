package DavidGuardado_20240273.DavidGuardado_20240273.Models.DTO;


import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Anotaciones
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DTOProvider {

    //Campos

    @Positive
    @NotNull
    private Long providerID;

    @NotBlank
    @Size(max = 50)
    private String providerName;

    @NotBlank
    @Size(max = 50)
    private Long providerPhone;

    @NotBlank
    @Size(max = 128)
    private String providerAddress;

    @Email
    @NotBlank
    @Size(max = 100)
    private String providerEmail;

    @NotBlank
    @Size(max = 35)
    private Long providerCode;

    @NotBlank
    private String providerStatus;

    @NotBlank
    @Size(max = 256)
    private String providerComments;

}
