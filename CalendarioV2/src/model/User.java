package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUser;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	private String email;

	private String nome;

	private String password;

	//bi-directional many-to-one association to SpTime
	@OneToMany(mappedBy="user")
	private List<SpTime> spTimes;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<SpTime> getSpTimes() {
		return this.spTimes;
	}

	public void setSpTimes(List<SpTime> spTimes) {
		this.spTimes = spTimes;
	}

	public SpTime addSpTime(SpTime spTime) {
		getSpTimes().add(spTime);
		spTime.setUser(this);

		return spTime;
	}

	public SpTime removeSpTime(SpTime spTime) {
		getSpTimes().remove(spTime);
		spTime.setUser(null);

		return spTime;
	}

}