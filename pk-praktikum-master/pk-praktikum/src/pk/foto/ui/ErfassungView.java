package pk.foto.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pk.foto.Album;
import pk.foto.Foto;
import pk.foto.FotoVerwaltung;


public abstract class ErfassungView<T> extends Stage {

	boolean erg ;
  protected GridPane gp = new GridPane() ;
	
	public ErfassungView(Stage primaryStage ) {
	
	this.initOwner(primaryStage);
	this.initModality(Modality.WINDOW_MODAL);
	
	
	}
	public boolean showView() {
		//border
		BorderPane bP = new BorderPane(gp) ;
		var  button1 = new Button("ok")  ; 
		var button2 = new Button ("abbrechen") ;
		button1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
			
				erg = true ;
				close();
			}
		} );
		button2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				erg = false ;
				close() ;
			}
		});
		 FlowPane fp =  new FlowPane () ;
		fp.getChildren().addAll(button1,button2);
		bP.setBottom(fp);
		Scene M = new Scene (bP) ;
		setScene(M) ;
		 return erg ;
		 
		 
	}
	public  abstract T gibNeuesObjekt() ;
}
