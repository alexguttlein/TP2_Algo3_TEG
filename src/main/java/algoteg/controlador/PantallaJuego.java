package algoteg.controlador;

import algoteg.modelo.Juego;
import algoteg.modelo.Jugador;
import algoteg.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PantallaJuego {
    Juego juego;

    @FXML
    public TextField tropasAColocar;
    @FXML
    public Label cantTropas;
    @FXML
    public Label cantJugadores;
    @FXML
    public ToggleButton gran_bretaña;
    @FXML
    public Button prueba;
    @FXML
    public Button canada;
    @FXML
    public ToggleButton yukon;
    @FXML
    public Button terranova;
    @FXML
    public Button groenlandia;
    @FXML
    public Button alaska;
    @FXML
    public Button labrador;
    @FXML
    public Button mexico;
    @FXML
    public Button california;
    @FXML
    public Button oregon;
    @FXML
    public Button colombia;
    @FXML
    public Button chile;
    @FXML
    public Button uruguay;
    @FXML
    public Button peru;
    @FXML
    public Button argentina;
    @FXML
    public Button brasil;
    @FXML
    public Button nueva_york;
    @FXML
    public Button islandia;
    @FXML
    public Button alemania;
    @FXML
    public Button francia;
    @FXML
    public Button españa;
    @FXML
    public Button polonia;
    @FXML
    public ToggleButton suecia;
    @FXML
    public ToggleButton rusia;
    @FXML
    public ToggleButton italia;
    @FXML
    public ToggleButton israel;
    @FXML
    public ToggleButton turquia;
    @FXML
    public ToggleButton sudafrica;
    @FXML
    public ToggleButton madagascar;
    @FXML
    public ToggleButton egipto;
    @FXML
    public ToggleButton etiopia;
    @FXML
    public ToggleButton zaire;
    @FXML
    public ToggleButton sahara;
    @FXML
    public ToggleButton gobi;
    @FXML
    public ToggleButton iran;
    @FXML
    public ToggleButton mongolia;
    @FXML
    public ToggleButton china;
    @FXML
    public ToggleButton taymir;
    @FXML
    public ToggleButton siberia;
    @FXML
    public ToggleButton aral;
    @FXML
    public ToggleButton malasia;
    @FXML
    public ToggleButton india;
    @FXML
    public ToggleButton kamchatka;
    @FXML
    public ToggleButton arabia;
    @FXML
    public ToggleButton australia;
    @FXML
    public ToggleButton borneo;
    @FXML
    public ToggleButton sumatra;
    @FXML
    public ToggleButton japon;
    @FXML
    public ToggleButton tartaria;
    @FXML
    public ToggleButton java;
    @FXML
    public Button colocar;
    @FXML
    public Button reagrupar;
    @FXML
    public Button atacar;
    @FXML
    public Button finalizarAtaque;

    Map<String, ToggleButton>  botones =  new HashMap<>();
    Map<ToggleButton, String>  botonesPaises =  new HashMap<>();
    List<Jugador> jugadores;
    Map<String,Pais> paises = new HashMap<>();
    String primerPaisSeleccionado;
    String segundoPaisSeleccionado;








    public void mostrarTropasDisponibles() {
        this.cantTropas.setText("0");
    }

    public void mostrarCantJugadores(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(this.prueba)){
            this.cantJugadores.setText( Integer.toString(this.juego.getCantidadJugadores()));
        }
    }


    public void pantalla(Juego juego) {

        this.juego = juego;
        this.inicializarPaises();
        this.jugadores = juego.getListaJugadores();
        this.inicializarColoresDePaises();
        this.mostrarBotonesRondaColocacion();

    }

    public void mostrarBotonesRondaColocacion() {
        this.colocar.setVisible(true);
        this.reagrupar.setVisible(false);
        this.atacar.setVisible(false);
        //this.finalizarAtaque.setVisible(false);
    }

    public void mostrarBotonesRondaAtaque() {
        this.colocar.setVisible(false);
        this.reagrupar.setVisible(false);
        this.atacar.setVisible(false);
        //this.finalizarAtaque.setVisible(true);
    }

    @FXML
    public void finalizarTurnoAtaque(){
        this.juego.pasarAJugadorSiguiente();
        if (this.juego.esTurnoDeColocacion()) {
            mostrarBotonesRondaColocacion();
        }
    }

    private void inicializarColoresDePaises(){
        for (Jugador jugador : jugadores
        ) {
            List<Pais> paisesJugador = jugador.getPaisesConquistados();
            for (Pais paisConquistado : paisesJugador) {
                String colorJugador = jugador.getColor();

                Color fondo = Color.web(colorJugador);
                String nombrePais = paisConquistado.getNombre();
                ToggleButton botonPais = botones.get(nombrePais);
                botonPais.setStyle("-fx-background-color: " + colorJugador + ";");

            }
        }
    }



    private void inicializarPaises(){
        botones.put("Canada",canada);
        botones.put("Yukon",yukon );
        botones.put("Terranova", terranova);
        botones.put("Groenlandia", groenlandia);
        botones.put("Alaska", alaska);
        botones.put("Labrador", labrador);
        botones.put("Mexico", mexico);
        botones.put("California", california);
        botones.put("Oregon", oregon);
        botones.put("Colombia", colombia);
        botones.put("Chile", chile);
        botones.put("Uruguay", uruguay);
        botones.put("Peru", peru);
        botones.put("Argentina", argentina);
        botones.put("Brasil", brasil);
        botones.put("Nueva York", nueva_york);
        botones.put("Islandia", islandia);
        botones.put("Alemania", alemania);
        botones.put("Francia", francia);
        botones.put("Espana", españa);
        botones.put("Polonia", polonia);
        botones.put("Suecia", suecia);
        botones.put("Rusia", rusia);
        botones.put("Italia", italia);
        botones.put("Israel", israel);
        botones.put("Turquia", turquia);
        botones.put("Sudafrica", sudafrica);
        botones.put("Madagascar", madagascar);
        botones.put("Egipto", egipto);
        botones.put("Etiopia", etiopia);
        botones.put("Zaire", zaire);
        botones.put("Sahara", sahara);
        botones.put("Gobi", gobi);
        botones.put("Iran", iran);
        botones.put("Mongolia", mongolia);
        botones.put("China", china);
        botones.put("Taimir", taymir);
        botones.put("Siberia", siberia);
        botones.put("Aral", aral);
        botones.put("Malasia", malasia);
        botones.put("India", india);
        botones.put("Kamchatka", kamchatka);
        botones.put("Arabia", arabia);
        botones.put("Australia", australia);
        botones.put("Borneo", borneo);
        botones.put("Sumatra", sumatra);
        botones.put("Japon", japon);
        botones.put("Tartaria", tartaria);
        botones.put("Gran Bretana", gran_bretaña);
        botones.put("Java", java);
    }

    private void inicializarPaises2(){
        for(String s : botones.keySet()){
            botonesPaises.put(botones.get(s), s);
        }
    }




    @FXML
    public void paisSeleccionado(ActionEvent event){
        if(botonesPaises.containsValue(event.getSource())) {
            if (primerPaisSeleccionado != botonesPaises.get(event.getSource())) {
                if(segundoPaisSeleccionado != botonesPaises.get(event.getSource())){
                    primerPaisSeleccionado = botonesPaises.get(event.getSource());
                    ToggleButton boton = (botonesPaises.get(event.getSource()));
                    boton
                }
                else{
                    segundoPaisSeleccionado = null;
                }

            }
            else{
                primerPaisSeleccionado = null;
            }
        }
    }

    @FXML
    public void colocar(ActionEvent  event ){
        if(event.getSource().equals(colocar) && !tropasAColocar.getText().isEmpty() && primerPaisSeleccionado != null){
            try{
                Integer tropas = Integer.parseInt(cantJugadores.getText());
                juego.colocar(tropas.intValue(), primerPaisSeleccionado);
                cantJugadores.setText(Integer.toString(juego.obtenerTropasEnPais(primerPaisSeleccionado)));

            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }
        }



        if (this.juego.esTurnoDeAtaque()) {
            mostrarBotonesRondaAtaque();
        }
    }



}
