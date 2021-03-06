package org.mcclone.domain.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author McClone
 */
@MappedSuperclass
@Data
public abstract class IdGenerator implements Serializable {
    private static final long serialVersionUID = 7321181240016768133L;

    @Id
    @Column(name = "id")
    protected String id;

    @PrePersist
    public void beforePersist() {
        this.setId(UUID.randomUUID().toString().replace("-", ""));
    }
}
