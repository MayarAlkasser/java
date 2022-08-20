 package pk.foto;
import java.util.ArrayList;


public class Tester {
    public static void main(String[] args) {

    	FotoVerwaltung fotoVerwaltung = new FotoVerwaltung(); //instanz//

   /*     FotoMetadaten fotoMetadaten =
                new FotoMetadaten(1024, 1024, "NIKON CORPORATION", "NIKON D750");

        Foto foto1 = new Foto("sky", "images/09330192369_111213_o.jpg", fotoMetadaten);
        Foto foto2 = new Foto("sea", "images/09730192399_117214_o.jpg", fotoMetadaten);
        Foto foto3 = new Foto("mayar", "images/09700192369_110215_o.jpg", fotoMetadaten);
        Foto foto4 = new Foto("Mira", "images/09759092369_113016_o.jpg", fotoMetadaten);
        Foto foto5 = new Foto("dilan", "images/09734102369_13217_o.jpg", fotoMetadaten);  */

        Album album1 = new Album("nature", "Mayar");
        Album album2 = new Album("people", "Dilan");

    /*    album1.addFoto(foto1);
        album1.addFoto(foto2);
        album2.addFoto(foto3);
        album2.addFoto(foto4);
        album2.addFoto(foto5);*/

        try {
			fotoVerwaltung.addAlbum(album1);
		} catch (AlbumVorhandenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			fotoVerwaltung.addAlbum(album2);
		} catch (AlbumVorhandenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();
        System.out.println(fotoVerwaltung.gibAnzahlAlben());
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();
        System.out.println(fotoVerwaltung.findeAlbumMitName("nature").toString());
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();
        System.out.println((fotoVerwaltung.gibAlleAlben()));
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();
        fotoVerwaltung.druckeAlleAlben();
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();
    }
}
