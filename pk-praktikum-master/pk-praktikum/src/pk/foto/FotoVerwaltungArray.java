 package pk.foto;
import java.util.Arrays;
import java.util.HashSet;

public class FotoVerwaltungArray {

    private Album[] alben = new Album[2];

    public void druckeAlleAlben() {
        for(int i=0; i<this.alben.length; i++) {
            System.out.println("=== Album " + (i+1) + "===");
            alben[i].drucke();
        }
    }

    public int gibAnzahlAlben() {
        int counter = 0;
        for (Album album : this.alben) {
            if (album != null) counter++;
        }
        return counter;
    }

    public Album[] gibAlleAlben() {
        return this.alben;
    }

    public void addAlbum(Album album) {
        boolean voll = false;
        int laenge = this.alben.length;
        for(int i=0; i<laenge; i++) {
            if (alben[i]==null) {
                alben[i] = album;
                break;
            } else {
                if (i == laenge-1) voll = true;
            }
        }
        if (voll) {
            Album[] temp = Arrays.copyOf(this.alben, laenge+1);
            temp[laenge] = album;
            this.alben = temp;
        }
    }

    public Album findeAlbumMitName(String name) {
        if(name == null) return null;
        for( Album album : alben) {
            if (album.getName().equals(name)) return album;
        }
        return null;
    }
    public Album[]  findename(String name) {
		HashSet<Album> a1 = new HashSet<>();
		for(Album A: a1) {
			if(A.getName().equals(name)) {
				a1.add(A);
			}
		}
		return a1.toArray(new Album[a1.size()]);
	}


}