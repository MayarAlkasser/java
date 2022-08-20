package pk.foto.ui;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pk.foto.Album;
import pk.foto.Foto;
import pk.foto.FotoVerwaltung;
import pk.foto.ui.util.DialogUtil;

public class AlbumErfassungView  extends ErfassungView<Album>  {
	
	private DialogUtil dialogUtil;
	public AlbumErfassungView(Stage primaryStage  ) {
		super(primaryStage);
		
	}

	public Node getPane() {

		var label1 = new Label ("name") ;
		var label2 = new Label ( "bestizer") ;
		var textf1 = new TextField ( " Seen und F�ssen") ;
		var textf2 = new TextField ( " Jack Sparrow") ;
		//   setTitle("Neues Album Erstellen") ;
		var vbox = new VBox  (label1 , label2 )  ;
		var vbox2 = new VBox  (textf1 , textf2 )  ;
		var hbox = new HBox  ( vbox , vbox2 )  ;
		gp.getChildren().addAll(hbox );

		gp.setPadding(new Insets( 10,10,10,10)) ;
		gp.setHgap(5.0);
		gp.setVgap(5.0);
		setScene( new Scene(gp)) ;
		setTitle( " Neus Album Erstellen") ;

		return gp;
	}

  public boolean showView() {
	 
		var label1 = new Label ("name") ;
		var label2 = new Label ( "bestizer") ;
		var textf1 = new TextField ( " Seen und F�ssen") ;
		var textf2 = new TextField ( " Jack Sparrow") ;
		//   setTitle("Neues Album Erstellen") ;
		var vbox = new VBox  (label1 , label2 )  ;
		var vbox2 = new VBox  (textf1 , textf2 )  ;
		var hbox = new HBox  ( vbox , vbox2 )  ;
		gp.getChildren().addAll(hbox );
		
		gp.setPadding(new Insets( 10,10,10,10)) ;
		gp.setHgap(5.0);
	    gp.setVgap(5.0);
		setScene( new Scene(gp)) ;
		setTitle( " Neus Album Erstellen") ;
		show() ;
		return super.showView() ;
	}
  
@Override
  public Album gibNeuesObjekt() {
	
	return null  ;
}
}
