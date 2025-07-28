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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_provider")
    @SequenceGenerator(name = "seq_provider", sequenceName = "seq_provider", allocationSize = 1)
    private Long providerID;

    @Column(name = "PROVIDERNAME")
    private String providerName;

    @Column(name = "PROVIDERPHONE")
    private Long providerPhone;

    @Column(name = "PROVIDERADDRESS")
    private String providerAddress;

    @Column(name = "PROVIDEREMAIL")
    private String providerEmail;

    @Column(name = "PROVIDEREMAIL")
    private Long providerCode;

    @Column(name = "PROVIDERSTATUS")
    private String providerStatus;

    @Column(name = "PROVIDERCOMMENTS")
    private String providerComments;
}
