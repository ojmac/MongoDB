package mongodb.entity;

import org.bson.types.ObjectId;

public class Actor {

	private ObjectId id;

	private String nombre;

	private int edad;

	public Actor(String nombre, int edad) {
		this.id = new ObjectId();
		this.nombre = nombre;
		this.edad = edad;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}