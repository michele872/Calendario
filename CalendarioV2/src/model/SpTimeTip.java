package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sp_time_tips database table.
 * 
 */
@Entity
@Table(name="sp_time_tips")
@NamedQuery(name="SpTimeTip.findAll", query="SELECT s FROM SpTimeTip s")
public class SpTimeTip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSpt;

	private String descrizione;

	private String label;

	//bi-directional many-to-one association to SpTime
	@ManyToOne
	@JoinColumn(name="idSpTime")
	private SpTime spTime;

	public SpTimeTip() {
	}

	public int getIdSpt() {
		return this.idSpt;
	}

	public void setIdSpt(int idSpt) {
		this.idSpt = idSpt;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public SpTime getSpTime() {
		return this.spTime;
	}

	public void setSpTime(SpTime spTime) {
		this.spTime = spTime;
	}

}