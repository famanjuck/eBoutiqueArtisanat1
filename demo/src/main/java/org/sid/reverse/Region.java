package org.sid.reverse;
// Generated 30 avr. 2019 01:04:31 by Hibernate Tools 3.6.0.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Region generated by hbm2java
 */
@Entity
@Table(name = "region", schema = "public")
public class Region implements java.io.Serializable {

	private int idRegion;
	private String nomregion;
	private Set<Departement> departements = new HashSet(0);

	public Region() {
	}

	public Region(int idRegion) {
		this.idRegion = idRegion;
	}

	public Region(int idRegion, String nomregion, Set<Departement> departements) {
		this.idRegion = idRegion;
		this.nomregion = nomregion;
		this.departements = departements;
	}

	@Id

	@Column(name = "id_region", unique = true, nullable = false)
	public int getIdRegion() {
		return this.idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	@Column(name = "nomregion", length = 254)
	public String getNomregion() {
		return this.nomregion;
	}

	public void setNomregion(String nomregion) {
		this.nomregion = nomregion;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "region")
	@JsonIgnoreProperties("Region")
	public Set<Departement> getDepartements() {
		return this.departements;
	}

	public void setDepartements(Set<Departement> departements) {
		this.departements = departements;
	}

}
