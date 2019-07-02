package org.sid.reverse;
// Generated 30 avr. 2019 01:04:31 by Hibernate Tools 3.6.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Boutique generated by hbm2java
 */
@Entity
@Table(name = "boutique", schema = "public")
public class Boutique implements java.io.Serializable {

	private int numboutique;
	private Artisan artisan;
	private String nomboutique;
	private String adresseboutique;
	private String commune;

	public Boutique() {
	}

	public Boutique(int numboutique, Artisan artisan) {
		this.numboutique = numboutique;
		this.artisan = artisan;
	}

	public Boutique(int numboutique, Artisan artisan, String nomboutique, String adresseboutique, String commune) {
		this.numboutique = numboutique;
		this.artisan = artisan;
		this.nomboutique = nomboutique;
		this.adresseboutique = adresseboutique;
		this.commune = commune;
	}

	@Id

	@Column(name = "numboutique", unique = true, nullable = false)
	public int getNumboutique() {
		return this.numboutique;
	}

	public void setNumboutique(int numboutique) {
		this.numboutique = numboutique;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_utilisateur", nullable = false)
	@JsonIgnoreProperties("boutiques")
	public Artisan getArtisan() {
		return this.artisan;
	}

	public void setArtisan(Artisan artisan) {
		this.artisan = artisan;
	}

	@Column(name = "nomboutique", length = 254)
	public String getNomboutique() {
		return this.nomboutique;
	}

	public void setNomboutique(String nomboutique) {
		this.nomboutique = nomboutique;
	}

	@Column(name = "adresseboutique", length = 254)
	public String getAdresseboutique() {
		return this.adresseboutique;
	}

	public void setAdresseboutique(String adresseboutique) {
		this.adresseboutique = adresseboutique;
	}

	@Column(name = "commune", length = 254)
	public String getCommune() {
		return this.commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

}
