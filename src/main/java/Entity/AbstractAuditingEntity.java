package Entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class AbstractAuditingEntity {


        private LocalDateTime createdDate;

        private LocalDateTime lastModifiedDate;
}
