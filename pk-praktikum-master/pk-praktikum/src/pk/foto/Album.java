 package pk.foto;
 import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.MetadataException;

import pk.foto.util.FotoUtil;


public class Album implements CsvExportable, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3344845118831347625L;

	private ArrayList<Foto> fotos = new ArrayList<Foto>();

    private String name;
    private String besitzer;

    public Album (String name, String besitzer) {
        this.name = name;
        this.besitzer = besitzer;
    }
    public String getName() {
        return name;
    }

    public String getBesitzer() {
        return besitzer;
    }

    public void drucke () {
        System.out.println("Name: " + this.name);
        System.out.println("Besitzer: " + this.besitzer);
       // for(int i=0; i<this.fotos.length; i++) {
        //    System.out.println("=== Foto " + (i+1) + " ===");
          //  fotos[i].drucke();   
            Iterator<Foto> iterator = fotos.iterator() ;
            int i = 1 ;
            while (iterator.hasNext() ) {
            	 Foto next = iterator.next();
                System.out.println("=== Foto " + i++ + "===");
                next.drucke() ;
        }
    }

    public ArrayList<Foto> getFotos() {
        return this.fotos;
    }

    public void addFoto(Foto foto) throws FotoMetadatenException {
 //      boolean full = false;
    	//        int Long = this.fotos.length;
    	//   for(int i=0; i<Long; i++) {
        	//         if (fotos[i]==null) {
    	//          fotos[i] = foto;
    	//       break;
                //       } else {
    	//      if (i == Long-1) full = true;
                //   }
    	//  }
    	//   if (full) {
        	//       Foto[] temp = Arrays.copyOf(this.fotos, Long+1);
    	//    temp[Long] = foto;
    	//  this.fotos = temp;
    	try {
			foto.setMetadaten(FotoUtil.readMetadata(new File ("pk-praktikum\\images\\" + foto.getDateiName()))) ;
		} catch (ImageProcessingException | MetadataException | NullPointerException | IOException e) {
			 
			throw new FotoMetadatenException ("", e ) ; 
		}
    	fotos.add(foto);
				
        }
   

    @Override
    public String toString() {
    	
        return "Album{" +
                "fotos=" + fotos +
                ", name='" + name + '\'' +
                ", besitzer='" + besitzer + '\'' +
                '}';
    }
	@Override
	public String exportiereAlsCsv() {
		return 
                "fotos=" + fotos +
                ", name='" + name + '\'' +
                ", besitzer='" + besitzer + '\'' +
                '}';
	}

}
