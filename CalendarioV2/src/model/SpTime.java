package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sp_time database table.
 * 
 */
@Entity
@Table(name="sp_time")
@NamedQuery(name="SpTime.findAll", query="SELECT s FROM SpTime s")
public class SpTime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSpTime;

	@Temporal(TemporalType.DATE)
	private Date data;

	private int ore;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	//bi-directional many-to-one association to SpTimeTip
	@OneToMany(mappedBy="spTime")
	private List<SpTimeTip> spTimeTips;

	public SpTime() {
	}

	public int getIdSpTime() {
		return this.idSpTime;
	}

	public void setIdSpTime(int idSpTime) {
		this.idSpTime = idSpTime;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getOre() {
		return this.ore;
	}

	public void setOre(int ore) {
		this.ore = ore;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<SpTimeTip> getSpTimeTips() {
		return this.spTimeTips;
	}

	public void setSpTimeTips(List<SpTimeTip> spTimeTips) {
		this.spTimeTips = spTimeTips;
	}

	public SpTimeTip addSpTimeTip(SpTimeTip spTimeTip) {
		getSpTimeTips().add(spTimeTip);
		spTimeTip.setSpTime(this);

		return spTimeTip;
	}

	public SpTimeTip removeSpTimeTip(SpTimeTip spTimeTip) {
		getSpTimeTips().remove(spTimeTip);
		spTimeTip.setSpTime(null);

		return spTimeTip;
	}

}