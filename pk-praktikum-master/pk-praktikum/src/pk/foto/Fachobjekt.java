package pk.foto;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.UUID;

public abstract class Fachobjekt implements CsvExportable , Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3987277430279416787L;
	private String  ID;
	private String name;
	
	public Fachobjekt(String name) {
		this.name = name;
		UUID uuid  = UUID.randomUUID();
		this.ID =  uuid.toString();		
	}
	
	  public String getName() {
	        return name;
	    }
	  
//	public abstract void drucke();
	  
	  public abstract void drucke(OutputStream stream);
	
	public String toString() {
		
		return "ID: "+this.ID+"\n"+
				"Name: "+this.name+"\n";
	}
	
	


}
