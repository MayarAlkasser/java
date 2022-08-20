
package pk.foto;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.*;


public class Menue {
	FotoVerwaltung FV;
	Album a;
	Foto f;
	FotoMetadaten fm;

	
	public Menue (FotoVerwaltung fv) {
		this.FV=fv;
	}
	
	public void show()  {
 	Scanner sc = new Scanner(System.in);  //eingeabe //
		
		int auswahl=0;
		
		do {
			try {
				
				
			System.out.println("Foto App"+"\n"+
					"1. Add Album"+"\n"+
					"2. Drucke Alle Album"+"\n"+
					"3. Drucke Album alle mit Namen"+"\n"+ "4. CSV-Export"+ "\n"+"5. Lade aus Datei\n"
					+"6. Speichere in Datei\n"
					+"7. Beenden\n"
						+"Bitte Aktion wählen:");
			auswahl = sc.nextInt();
			
			switch(auswahl) {
			
			case 1:
					addAlbum();
				break;
				//q
			case 2:
				// printing all albums
				FV.druckeAlleAlben();
				
				break;
			case 3:
				// printing all albums with names
				String finn =  JOptionPane.showInputDialog(new Pane(), "Bitte geben Sie einen Namen ein: ");
				//System.out.println(Arrays.toString(FV.findename(finn)));
				System.out.println(Arrays.toString(FV.findename(finn)));
				break;
			case 4:

				// exporting to csv

				boolean ok = false ; 
				String sinn = ""  ;
				do {
					
				sinn =  JOptionPane.showInputDialog(null, "Bitte geben Sie einen Namen ein: ");
				
				if (sinn == null || sinn.isEmpty() ) { JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Namen ein: "); }
				else { File file = new  File (sinn + ".csv") ;
				if(file.exists() ) { 
					  int result = JOptionPane.showConfirmDialog(null, "möchten die datein überschreiben", null , JOptionPane.YES_NO_CANCEL_OPTION )  ;
					  if (result == JOptionPane.YES_OPTION ) {
						  ok = true ;
						  
					  }
					  else 	  ok = false ;	  
				}
				else {
					ok = true ;
					
				}
					
				}
				    } while  (ok == false ) ;
				    	
			FV.exportiereEintraegeAlsCsv(new File(sinn));	
			break;

			// serialization
			case 5: FV.SerializationLaden();
			break;
	
	        case 6:	FV.SerializationSpeichern ();
			break;
	        case 7:	System.out.println("Das programm hat sich beendet");
	    	break;		
	default: System.err.println("geben sie zahl zwischen 1-7");
			   }
			} 
			catch(InputMismatchException exb){
			System.out.println("zahl zwischen 1-7 eingeben und kein String") ;
			sc.nextLine() ; // hilft für unendliche schleife//
			
			} catch (AlbumVorhandenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		}while(auswahl!=7);
	}
	
//	exeption nur für eine case //
	public void addAlbum() throws AlbumVorhandenException {
		// exception nur für eine zeile//
		/* int breite = 0 ;
     try {
			 breite = Integer.parseInt(JOptionPane.showInputDialog(null , "Bitte geben Sie eine Breite  ein:"));
		}
     catch (NumberFormatException exc) {
    	 System.out.println("kein String") ; 
	} */
   /*  int hoehe = 0 ;
     try {
    	 hoehe = Integer.parseInt(JOptionPane.showInputDialog(null , "Bitte geben Sie einen höhe ein:")); }
     catch (NumberFormatException exc) {
	           System.out.println("kein String") ;} */
     
	/*	String KM =JOptionPane.showInputDialog(null, "Bitte geben Sie einen Kamera Marke ein: ");
		String KMO = JOptionPane.showInputDialog(null, "Bitte geben Sie einen Kamera Modell ein: ");
		fm = new FotoMetadaten(breite,hoehe,KM,KMO);
		String fn = JOptionPane.showInputDialog(null, "Bitte geben Sie einen Fotonamen ein: ");
		String dn = JOptionPane.showInputDialog(null, "Bitte geben Sie einen Dateinamen ein: ");
		f = new Foto(fn,dn,fm);  */

		JFrame jf=new JFrame();
		jf.setAlwaysOnTop(true);

		String an = JOptionPane.showInputDialog(jf, "Bitte geben Sie eine Albumnamen ein: ");
		String b = JOptionPane.showInputDialog(jf, "Bitte geben Sie einen Besitzer ein: ");

		a = new Album(an,b);
		String fotonamen = JOptionPane.showInputDialog(jf, "Bitte geben Sie eine FotoNamen ein: ");
		String fotodateinamen = JOptionPane.showInputDialog(jf, "Bitte geben Sie eine fotodateinamen ein: ");
		Foto foto = new Foto(fotonamen , fotodateinamen) ;
		try {
			a.addFoto(foto);
			System.out.println("adding album...");
		} catch (FotoMetadatenException e) {
			JOptionPane.showMessageDialog(null, "Fehler Meldung");
		}
		FV.addAlbum(a);

		System.out.println(a.getName() + " " + a.toString());

	 }
	
	public static void main(String[] args)  {
       
		Menue menue = new Menue(new FotoVerwaltung ()) ;
		menue.show();
		
	
	}
}
