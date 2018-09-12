package com.heyden.spring.petclinic.entity;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BaseEntity<ID> implements Serializable {
	@Id
	private ID id;

	public ID getId() {
		return id;
	}

	public void setId(final ID id) {
		this.id = id;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof BaseEntity)) {
			return false;
		}
		final BaseEntity that = (BaseEntity) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "BaseEntity{" +
				"id=" + id +
				'}';
	}
}
