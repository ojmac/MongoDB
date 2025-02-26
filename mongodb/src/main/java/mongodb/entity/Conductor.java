package mongodb.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Conductor {
	
	private String idCond;
	private int numCarnet;
	private List<String> matriculasCoches = new ArrayList(); 
	
	public Conductor() {
		
	}
	
	public Conductor(String idCond, int numCarnet) {
		super();
		this.idCond = idCond;
		this.numCarnet = numCarnet;
		
		
	}
	
	@Override
	public String toString() {
		return "Conductor [idCond=" + idCond + ", numCarnet=" + numCarnet + ", matriculasCoches="
				+ matriculasCoches + "]";
	}

	public String getIdCond() {
		return idCond;
	}

	public void setIdCond(String idCond) {
		this.idCond = idCond;
	}

	public int getNumCarnet() {
		return numCarnet;
	}

	public void setNumCarnet(int numCarnet) {
		this.numCarnet = numCarnet;
	}

	
    public List<String> getMatriculasCoches() {
		return matriculasCoches;
	}

	public void setMatriculasCoches(List<String> matriculasCoches) {
		this.matriculasCoches = matriculasCoches;
	}

	public void addMatriculaCoche(String matricula) {
		this.matriculasCoches.add(matricula);
		
	}
	public void delMatriculaCoche(String matricula) {
		this.matriculasCoches.remove(matricula);
		
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Conductor that = (Conductor) obj;
        return Objects.equals(idCond, that.idCond);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCond);
    }	
}
