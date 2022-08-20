 package pk.foto;

import java.io.Serializable;

public class Foto implements CsvExportable  , Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2292879228008597346L;

	private FotoMetadaten metadaten;

    private String name;
    private String dateiName;

    public Foto (String name, String dateiName ) {
		this.name = name;
        this.dateiName = dateiName;
       // this.metadaten = metadaten;
    }

    public void drucke () {
        System.out.println("\t" + "Fotoname: " + this.name);
        System.out.println("\t" + "Dateiname: " + this.dateiName);
        System.out.println("\t" + "Größe: " + this.metadaten.getBreite() + " x " + this.metadaten.getHoehe());
        System.out.println("\t" + "Kamera: " + this.metadaten.getKameraaMarke() + " " + this.metadaten.getKameraModell());
        System.out.println("\t" + "Erstellungsdatum: " + this.metadaten.getErstellungszeitpunktDruckVersion());
    }

    @Override
    public String toString() {
        return "Foto{" +
                "metadaten=" + metadaten +
                ", name='" + name + '\'' +
                ", dateiName='" + dateiName + '\'' +
                '}';
    }

	public FotoMetadaten getMetadaten() {
		return metadaten;
	}

	public void setMetadaten(FotoMetadaten metadaten) {
		this.metadaten = metadaten;
	}

	public String getDateiName() {
		return dateiName;
	}

	public void setDateiName(String dateiName) {
		this.dateiName = dateiName;
	}

	@Override
	public String exportiereAlsCsv() {
		
		return 
                "metadaten=" + metadaten +
                ", name='" + name + '\'' +
                ", dateiName='" + dateiName + '\'' 
                ;
	}

}
