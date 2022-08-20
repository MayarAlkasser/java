package pk.foto.ui;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pk.foto.Album;
import pk.foto.Foto;
import pk.foto.FotoVerwaltung;

import java.util.ArrayList;

public class FotoUI extends Application {

	Label albumNameValue = new Label("");
	Label besitzerValue = new Label("");
		
		public void start(Stage primaryStage) throws Exception {

			AlbumErfassungView ab = new AlbumErfassungView(primaryStage)  ;
			//ab.showView() ;
			FotoErfassungView fv = new FotoErfassungView(primaryStage) ;

			FotoVerwaltung fotoVerwaltung = new FotoVerwaltung();
			//fv.showView();

			// filling data

			Album albumA = new Album("album A", "mayar");
			Album albumB = new Album("album B", "ismail");

			Foto foto_1 = new Foto("image one", "7861351302_74a45956dd_o.jpg");
			Foto foto_2 = new Foto("image one", "16524319597_c735c777a8_o.jpg");
			Foto foto_3 = new Foto("image one", "35835723323_b3ed4bf5d1_o.jpg");
			Foto foto_4 = new Foto("image one", "DSC02033.jpg");

			albumA.addFoto(foto_1);
			albumA.addFoto(foto_2);
			albumA.addFoto(foto_3);

			albumB.addFoto(foto_4);
			albumB.addFoto(foto_1);
			albumB.addFoto(foto_2);

			fotoVerwaltung.addAlbum(albumA);
			fotoVerwaltung.addAlbum(albumB);

			// data ends .....................

			primaryStage.setTitle( "Foto-App ") ;
			MenuBar menubar = new MenuBar() ;
			Menu menu = new Menu("Datei" ) ;
			Menu menu1 = new Menu("Alben" ) ;
			MenuItem menuitem0 = new MenuItem ("Neues Album erstellen") ;
			MenuItem menuitem = new MenuItem ("Laden") ;
			MenuItem menuitem1 = new MenuItem ("Speichern") ;
			MenuItem menuitem2 = new MenuItem ("CSV-Export") ;
			MenuItem menuitem3 = new MenuItem ("Beenden") ;
			menu.getItems().addAll(menuitem , menuitem1, menuitem2, menuitem3) ;
			menu1.getItems().add(menuitem0) ;
			menubar.getMenus().addAll(menu ,menu1) ;


			BorderPane borderPane = new BorderPane();
			BorderPane innerBorderPane = new BorderPane();

			// Top
			AnchorPane topPanel = new AnchorPane();
			topPanel.getChildren().add(menubar);

			GridPane innerTopPane = new GridPane();

			Label albumName = new Label("Album:");
			Label besitzer = new Label("Besitzer:");


			innerTopPane.add(albumName, 0, 0);
			innerTopPane.add(albumNameValue, 1, 0);

			innerTopPane.add(besitzer, 0, 1);
			innerTopPane.add(besitzerValue, 1, 1);

			innerBorderPane.setTop(innerTopPane);

			// Bottom
			innerBorderPane.setBottom(ab.getPane());

			// Center
			AnchorPane centerPane = new AnchorPane();

			innerBorderPane.setCenter(centerPane);

			// Left
			ListView<String> listView = new ListView<>();

			ArrayList<Album> albumList = fotoVerwaltung.gibAlleAlben();

			for (Album album : albumList) {
				listView.getItems().add(album.getName());
			}

			// listener for listView

			listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

					String albumName = observableValue.getValue();
					Album album = fotoVerwaltung.findeAlbumMitName(albumName);

					showAlbum(album);

					//selectAlbum(list);

				}
			});


			borderPane.setLeft(listView);
			borderPane.setCenter(innerBorderPane);


			// by default select first album
			if(albumList.size() > 0) {
				showAlbum(albumList.get(0));
			}

			Scene ma = new Scene(borderPane,800 ,500) ;
			primaryStage.setScene(ma);
			primaryStage.show() ;
		  
		}

	private void showAlbum(Album album) {
			albumNameValue.setText(album.getName());
			besitzerValue.setText(album.getBesitzer());
	}

	public static void main(String[] args)
		{
			launch(args);
		}

}
