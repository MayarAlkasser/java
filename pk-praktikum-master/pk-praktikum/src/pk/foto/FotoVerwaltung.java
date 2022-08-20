package pk.foto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class FotoVerwaltung {
	
	private ArrayList<Album> albenlist = new ArrayList<Album>();
	
	
	public void druckeAlleAlben() {
        Iterator<Album> iterator = albenlist.iterator() ;
        int i = 1 ;
        while (iterator.hasNext() ) {
        	 Album next = iterator.next();
            System.out.println("=== Album " + i++ + "===");
           next.drucke();
            }
        }
	  public int gibAnzahlAlben() {
	        int counter = 0;
	        for (Album album : this.albenlist) {
	            if (album != null) counter++;
	        }
	        return counter;
	    }

	    public ArrayList<Album> gibAlleAlben() {
	        return this.albenlist;
	    }

	    public void addAlbum (Album album) throws AlbumVorhandenException {
	       boolean ok = false ;
	          for ( Album a : albenlist   )
	    {
	    	 if ( a.getName().equals(album.getName())){ 
	    		ok = true ;
	    	 } 
	     }
	          if (ok== false  ) {
	        	  albenlist.add(album);
	          }
	          else  { throw  new AlbumVorhandenException() ;
	        	  
	          }
	    	}
	    	 public Album findeAlbumMitName(String name) {
	    	        if(name == null) return null;
	    	        for( Album album : albenlist) {
	    	            if (album.getName().equals(name)) return album;
	    	        }
	    	        return null;
	    }
	    	 public Album[]  findename(String name) {
	    			HashSet<Album> a1 = new HashSet<>();
	    			for(Album A: albenlist) {
						if(A.getName().equals(name)) {
	    					a1.add(A);
						}
	    			}
	    			return a1.toArray(new Album[a1.size()]);
	    		}
	    	public void exportiereEintraegeAlsCsvNio(File datei) throws IOException {
	    		
	    		StringBuilder ma = new StringBuilder();
	    		 for( Album album : albenlist) {
	    			 
	    			 ma.append(album.exportiereAlsCsv()) ;// exp method bringt  werte der objekten //
	    		 }
	    	       Files.writeString(datei.toPath(), ma.toString())  ;
	    	        
	    		
	  }
	    	public void exportiereEintraegeAlsCsv(File datei) {
	    
	    	try(FileOutputStream my = new FileOutputStream (datei); PrintWriter mo = new PrintWriter (my)){
			StringBuilder ms = new StringBuilder();
			
			for( Album album : albenlist) {
   			 
   			ms.append(album.exportiereAlsCsv()) ;}
			mo.println(ms);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
		public void SerializationSpeichern (){
			File file = new File("Alben.ser");
			try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			/*	StringBuilder mg = new StringBuilder();
				
				for( Album album : albenlist) {
	   			 
	   			 mg.append(album.exportiereAlsCsv()) ;}*/
				oos.writeObject(albenlist);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void SerializationLaden ()
		{
			File file = new File("Alben.ser");
			
			try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {

				ArrayList<Album> albenlist = (ArrayList<Album>) ois.readObject();
				
			} catch (IOException |ClassNotFoundException e) {
				System.err.println("Fehler beim Laden");
				e.printStackTrace();
			} 
	    		
	    		
	    		
	    		
	    	}
}

	

