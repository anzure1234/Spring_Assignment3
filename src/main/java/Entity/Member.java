package Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ValueGenerationType;

import java.util.Set;

@Entity
@Getter
@Setter
public class Member extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private int phone;

    @Column
    private String email;

    @Column
    private String description;

    @OneToMany(mappedBy = "member", cascade ={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<Content> content;

}
