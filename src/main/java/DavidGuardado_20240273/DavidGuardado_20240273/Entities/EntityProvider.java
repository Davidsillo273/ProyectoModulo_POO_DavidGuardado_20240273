package DavidGuardado_20240273.DavidGuardado_20240273.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "TBPROVIDER")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EntityProvider {

    @Id
    @Column(name = "PROVIDERID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROVIDER")
    @SequenceGenerator(name = "SEQ_PROVIDER", sequenceName = "SEQ_PROVIDER", allocationSize = 1)
    private Long providerID;

    @Column(name = "PROVIDERNAME", unique = true)
    private String providerName;

    @Column(name = "PROVIDERPHONE")
    private String providerPhone;

    @Column(name = "PROVIDERADDRESS")
    private String providerAddress;

    @Column(name = "PROVIDEREMAIL")
    private String providerEmail;

    @Column(name = "PROVIDERCODE", unique = true)
    private String providerCode;

    @Column(name = "PROVIDERSTATUS")
    private Long providerStatus;

    @Column(name = "PROVIDERCOMMENTS")
    private String providerComments;
}
