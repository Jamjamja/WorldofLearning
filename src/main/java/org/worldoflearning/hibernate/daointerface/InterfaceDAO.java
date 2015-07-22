package org.worldoflearning.hibernate.daointerface;

import java.util.List;

public interface InterfaceDAO<T> {

	public void hinzufuegen(T object);

	public void update(T object);

	public List<T> listObject();

	public void loesche(String name);

	public Object findeObjektNachName(String name);
	
	
}