package com.dp.userservice.role;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Table(name = "roles")
@Builder
public class Role {
	@Id
	@Column(name = "role_id", nullable = false, updatable = false)
	private Long id;

	@Size(min = 1, max = 50)
	@Column(nullable = false, updatable = false, name = "role_type")
	private String name;


}
