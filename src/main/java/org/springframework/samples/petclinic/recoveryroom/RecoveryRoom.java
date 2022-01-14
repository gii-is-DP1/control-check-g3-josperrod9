package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RecoveryRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
	@Size(min = 3, max = 50)
	@NotNull
    String name;
	@Positive
	@NotNull
    double size;
	@NotNull
    boolean secure;

    @NotNull
    @JoinColumn
    @ManyToOne(optional=false)
    RecoveryRoomType roomType;
}
