package mongodb.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Coche {

	private String matricula;
	private String marca;
	private String modelo;
	private PermisoCirc permisoCirc;
	private List<Integer> reparacionesIds= new ArrayList();
	private List<String> conductoresIds= new ArrayList();

	public Coche() {

	}

	public Coche(String matricula, String marca, String modelo, PermisoCirc permisoCirc) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.permisoCirc = permisoCirc;
			
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", reparacionesIds=" + reparacionesIds + ", conductoresIds=" + conductoresIds + "]";
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public PermisoCirc getPermisoCirc() {
		return permisoCirc;
	}

	public void setPermisoCirc(Object object) {
		this.permisoCirc = (PermisoCirc) object;
		
		this.permisoCirc.setCoche(this);
	}

	public List<Integer> getReparacionesIds() {
		return reparacionesIds;
	}

	public void setReparacionesIds(List<Integer> reparaciones) {
		this.reparacionesIds = reparaciones;
	}

	public void addReparacion(int reparacionId) {
		this.reparacionesIds.add(reparacionId);
	}
	public void delReparacion(int reparacionId) {
		this.reparacionesIds.remove(reparacionId);
	}
	
	public void addConductor(String conductorId) {
		this.conductoresIds.add(conductorId);
		
	}
	public void delConductor(String reparacionId) {
		this.conductoresIds.remove(reparacionId);
	}
	
	public List<String> getConductoresIds() {
		return conductoresIds;
	}

	public void setConductoresIds(List<String> conductoresIds) {
		this.conductoresIds = conductoresIds;
	}




}
