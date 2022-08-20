 package pk.foto;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FotoMetadaten implements CsvExportable , Serializable{

   
	/**
	 * 
	 */
	private static final long serialVersionUID = 5093773607468955081L;
	private int breite;
    private int hoehe;
    private String kameraaMarke;
    private String kameraModell;
    private LocalDateTime erstellungszeitpunkt;

    public FotoMetadaten(int breite, int hoehe, String kameraaMarke, String kameraModell, LocalDateTime ofInstant) { //leer?//
        this.breite = breite;
        this.hoehe = hoehe;
        this.kameraaMarke = kameraaMarke;
        this.kameraModell = kameraModell;
        this.erstellungszeitpunkt = ofInstant ;
    }

    @Override
    public String toString() {
        return "FotoMetadaten{" +
                "breite=" + breite +
                ", hoehe=" + hoehe +
                ", kameraaMarke='" + kameraaMarke + '\'' +
                ", kameraModell='" + kameraModell + '\'' +
                ", erstellungszeitpunkt=" + erstellungszeitpunkt.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) +
                '}';
    }

    public int getBreite() {
        return breite;
    }

    public int getHoehe() {
        return hoehe;
    }

    public String getKameraaMarke() {
        return kameraaMarke;
    }

    public String getKameraModell() {
        return kameraModell;
    }

    public LocalDateTime getErstellungszeitpunkt() {
        return erstellungszeitpunkt;
    }

    public String getErstellungszeitpunktDruckVersion() {
        return erstellungszeitpunkt.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

	@Override
	public String exportiereAlsCsv() {
		return  
                "breite=" + breite +
                ", hoehe=" + hoehe +
                ", kameraaMarke='" + kameraaMarke + '\'' +
                ", kameraModell='" + kameraModell + '\'' +
                ", erstellungszeitpunkt=" + erstellungszeitpunkt.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) +
                '}';
	}

}
