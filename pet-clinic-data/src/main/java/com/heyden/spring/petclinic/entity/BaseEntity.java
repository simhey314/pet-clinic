package com.heyden.spring.petclinic.entity;

import javax.persistence.Id;
import java.io.Serializable;

public class BaseEntity implements Serializable {
	@Id
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}
}
