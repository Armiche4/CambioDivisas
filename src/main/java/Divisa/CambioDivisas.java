package Divisa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CambioDivisas extends Application  {
	
	
	private Divisa euro = new Divisa("Euro", 1.0);
	private Divisa libra = new Divisa("Libra", 0.9);
	private Divisa dolar = new Divisa("Dolar", 1.2);
	private Divisa yen = new Divisa("Yen", 133.6);
	
	private Divisa [] divisas = { euro, libra, dolar, yen };
	
	
    private TextField origenText, destinoText;	
	private Button boton;
	private ComboBox<Divisa> origenCombo;
	private ComboBox<Divisa> destinoCombo;
	private Label etiqueta;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		origenText = new TextField("0");
		origenText.setPrefColumnCount(10);
		
		destinoText = new TextField("0");
		destinoText.setPrefColumnCount(10);
		destinoText.setEditable(false);
		
		
		
		origenCombo = new ComboBox<>();
		origenCombo.getItems().addAll(divisas);
		origenCombo.getSelectionModel().select(euro);
	    origenCombo.getSelectionModel().selectFirst();
		
		
		
		    destinoCombo= new ComboBox<>();
			destinoCombo.getItems().addAll(divisas);
			//destinoCombo.getSelectionModel().select(libra);
			
			
		 HBox origenhbox = new HBox(8);
		 origenhbox.setAlignment(Pos.BASELINE_CENTER);
         origenhbox.setSpacing(7);
		 origenhbox.getChildren().addAll(origenText, origenCombo);
		 
		 
		 HBox destinohBox = new HBox(50);
			destinohBox.setAlignment(Pos.BASELINE_CENTER);
			destinohBox.setSpacing(7);
			destinohBox.getChildren().addAll(destinoText, destinoCombo);
		 
		 
		//creamos un buton
			boton = new Button();
			boton.setText("Cambiar");
			boton.setOnAction(e -> onSaludarButtonAction(e));
			boton.setDefaultButton(true);
			//boton.setTranslateY(100);
			
			
			etiqueta = new Label();
			etiqueta.setText("CAMBIA DIVISAS");
			etiqueta.setTranslateY(-10);
	
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(etiqueta, origenhbox, destinohBox,boton);

		Scene escena = new Scene(root, 240, 200);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("Cambio de divisas");
		primaryStage.show();
	}

	private void onSaludarButtonAction(ActionEvent e) {
		Double cantidadOrigen = Double.parseDouble(origenText.getText());
		
		
		Divisa divisaOrigen = origenCombo.getSelectionModel().getSelectedItem();
		Divisa divisaDestino = destinoCombo.getSelectionModel().getSelectedItem();
		
		Double enEuros = divisaOrigen.toEuro(cantidadOrigen);
		Double cantidadDestino = divisaDestino.fromEuro(enEuros);
		
		destinoText.setText( cantidadDestino +"" );
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	
	
	
	
	
	
	
}
