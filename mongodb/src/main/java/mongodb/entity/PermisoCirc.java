package mongodb.entity;

public class PermisoCirc {
	


	private String numID;
	private Coche coche;
	private String matriculaCoche;
	private String fechaVto;
	private String fechaExp;
	
	public PermisoCirc() {
		
	}
	
	public PermisoCirc(String numID, Coche coche, String fechaVto, String fechaExp) {
		super();
		this.numID = numID;
		this.coche = coche;
		this.fechaVto = fechaVto;
		this.fechaExp = fechaExp;
		this.matriculaCoche = coche.getMatricula();
	}
	@Override
	public String toString() {
		return "PermisoCirc [numID=" + numID + ", matriculaCoche=" + matriculaCoche + ", fechaVto="
				+ fechaVto + ", fechaExp=" + fechaExp + "]";
	}

	public String getNumID() {
		return numID;
	}

	public void setNumID(String numID) {
		this.numID = numID;
	}

	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	public String getFechaVto() {
		return fechaVto;
	}

	public void setFechaVto(String fechaVto) {
		this.fechaVto = fechaVto;
	}

	public String getFechaExp() {
		return fechaExp;
	}
	

	public String getMatriculaCoche() {
		return matriculaCoche;
	}

	public void setMatriculaCoche(String matriculaCoche) {
		this.matriculaCoche = matriculaCoche;
	}

	public void setFechaExp(String fechaExp) {
		this.fechaExp = fechaExp;
	}


	
	
	
}
