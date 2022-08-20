package pk.foto.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pk.foto.Album;
import pk.foto.Foto;
import pk.foto.FotoVerwaltung;
import pk.foto.ui.util.DialogUtil;

public class FotoErfassungView extends ErfassungView<Foto> {
  
	private DialogUtil dialogUtil;
	
	public FotoErfassungView(Stage primaryStage ) {
		super(primaryStage  );
		
	}

	public Node getPane() {


		var label1 = new Label ("name") ;
		var textf1 = new TextField ( " Der Rhine bei Regen") ;
		var label2 = new Label ("Datei") ;
		var  button1 = new Button("wählen")  ;

		button1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				DialogUtil.showFileChooser(getTitle(), null) ;

			}
		} );
		setTitle("Foto hinzufügen ") ;

		var vbox = new VBox  (label1 , label2 )  ;
		var vbox2 = new VBox  (textf1 , button1 )  ;
		var hbox = new HBox  ( vbox , vbox2 )  ;
		gp.getChildren().addAll(hbox );
		gp.setPadding(new Insets( 10,10,10,10)) ;
		gp.setHgap(5.0);
		gp.setVgap(5.0);
		setScene( new Scene(gp)) ;
		setTitle( " Foto Hinzufügen") ;

		return gp;
	}

     public boolean showView() {
    	 
    	 var label1 = new Label ("name") ;
    	 var textf1 = new TextField ( " Der Rhine bei Regen") ;
    	 var label2 = new Label ("Datei") ;
    	 var  button1 = new Button("wählen")  ;
    	 
    	 button1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				
				DialogUtil.showFileChooser(getTitle(), null) ;
				
			}
		} ); 
    	 setTitle("Foto hinzufügen ") ;
    	
    	 var vbox = new VBox  (label1 , label2 )  ;
 		var vbox2 = new VBox  (textf1 , button1 )  ;
 		var hbox = new HBox  ( vbox , vbox2 )  ;
 		gp.getChildren().addAll(hbox );
        gp.setPadding(new Insets( 10,10,10,10)) ;
 		gp.setHgap(5.0);
 		gp.setVgap(5.0);
 		setScene( new Scene(gp)) ;
 		setTitle( " Foto Hinzufügen") ;
 		show() ;
 		 return super.showView() ;
    	 
    	 
	}
	@Override
	public Foto gibNeuesObjekt() {
		
		return null ;
		
	}
}
