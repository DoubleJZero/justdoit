package justdoit.data;

import jakarta.persistence.*;

import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;

/**
 * BaseTimeEntity
 *
 * <pre>
 * audit 정보 공통 entity
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public class BaseTimeEntity {

    @Column(name="RGST_ID", length=20)
    @Setter
    private String rgstId;

    @Column(name="RGST_DTTM")
    @CreatedDate
    private LocalDateTime rgstDttm;

    @Column(name="UPDT_ID", length=20)
    @Setter
    private String updtId;

    @Column(name="UPDT_DTTM")
    @LastModifiedDate
    private LocalDateTime updtDttm;
}