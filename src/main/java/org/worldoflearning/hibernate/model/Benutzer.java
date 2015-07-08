package org.worldoflearning.hibernate.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "Benutzer", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Benutzer {

	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	private int id;

	@Column(name = "NAME", length = 20, nullable = true)
	private String name;

	@Column(unique = true)
	private String email;

	@Column
	private String password;

	@Column
	private String role = ROLE_USER;

	@Column(name = "insert_time", nullable = true)
	private Date insertTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEMail() {
		return email;
	}

	public void setEMail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(getRole()));

    }
    
    public boolean isAdmin() {
        return ROLE_ADMIN.equals(getRole());
    }
}
