package org.worldoflearning.hibernate.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/*
 * Die Klasse "Forum" enth‰lt auﬂer unserer Vorgabe im Entwurf zus‰tzlich noch das Attribut ID.
 */
@Entity
@Table(name = "Forum", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Forum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	private int forum_id;

	@Column(name = "FORUM_NAME", length = 20, nullable = true)
	private String forum_name;

	public int getForum_Id() {
		return forum_id;
	}

	public void setForum_Id(int forum_id) {
		this.forum_id = forum_id;
	}

	public String getForum_Name() {
		return forum_name;
	}

	public void setForum_Name(String forum_name) {
		this.forum_name = forum_name;
	}

}