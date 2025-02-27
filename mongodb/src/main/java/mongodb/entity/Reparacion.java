package mongodb.entity;

import java.util.Objects;

public class Reparacion {
	
	private static int idAuto = 1;
	private int id;
	
	private String matriculaCoche;
	private double PVP;
	private String descripcion;
	
	public Reparacion() {
		
	}
	
	public Reparacion(String matriculaCoche, double pVP, String descripcion) {
		super();
		this.id = idAuto;
		this.matriculaCoche = matriculaCoche;
		PVP = pVP;
		this.descripcion = descripcion;
		idAuto++;
		
	}

	@Override
	public String toString() {
		return "Reparacion [id=" + id +  ", matriculaCoche=" + matriculaCoche + ", PVP=" + PVP
				+ ", descripcion=" + descripcion + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void  setMatriculaCoche(String matricula) {
		this.matriculaCoche = matricula;
	}
	
	public String getMatriculaCoche() {
		return matriculaCoche;
	}

	public double getPVP() {
		return PVP;
	}

	public void setPVP(double pVP) {
		PVP = pVP;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Reparacion that = (Reparacion) obj;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }	
}
