//package practica1;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;


/**
 *
 * @author Ignacio Poza i Blanca Ruiz
 */
public class EditableBufferedReader extends BufferedReader {
   // Definim valor numéric de la tecla associada en ASCII
    static final int RIGHT = 67;   // 'C' ja que en el terminal -> = ^[[C
    static final int LEFT = 68;    // 'D' ja que en el terminal <- = ^[[D
    static final int HOME = 72;
    static final int END = 70;
    static final int INSERT = 50;   // '2' ja que en el terminal ^[[2~
    static final int DELETE = 51;   // '3' ja que en el terminal ^[[3~
    static final int BACKSPACE = 127;   //tecla per borrar 
    static final int ESC = 27;      // ^[   es d'on partim
    static final int ENTER = 13; 
    static final int TILDE = 126; //pertany al símbol ~
    static final int CORCHETE = 91;
    
    //Definim les constants anteriors amb aquestes següents per tal de no interferir en els valors d'abans
    //Els hi donem un valor alt per assegurar-nos que no estan agafats de la taula
    //Els sencers retornats com a símbols no es solapin amb els sencers retornats com a caràcters simples
    static final int SEC_RIGHT = 2001;
    static final int SEC_LEFT = 2002;
    static final int SEC_HOME = 2003;    
    static final int SEC_END = 2004;
    static final int SEC_INSERT = 2005;
    static final int SEC_DELETE = 2006;
    Console console;
	Line line;
    public EditableBufferedReader(InputStreamReader in) {
        super(in);
        this.line = new Line();
		this.console=new Console(this.line);
		this.line.addObserver(this.console);
    }

    
    public void unsetRaw() throws IOException {
    //passa la consola de mode raw a mode cooked
        String [] cmd = {"/bin/sh", "-c", "stty cooked </dev/tty"};
        try {
        Runtime.getRuntime().exec(cmd).waitFor();
        }catch (IOException | InterruptedException e) {
            System.out.println("Error ");
        }
    }
    
    public void setRaw() throws IOException {
    //passa la consola de mode cooked a mode raw
        String [] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
        try {
        Runtime.getRuntime().exec(cmd).waitFor();  
        }catch (Exception e) {
            System.out.println("Error");
        }   
    }
    

    public int read() throws IOException {
    //llegeix el següent caràcter o la següent tecla de cursor
    int caracter = 0;
    
    caracter = super.read();
    //Aquesta funció la realitzem indagant amb el TestReadLine amb BufferedReader
    //Retorna el número del caracter llegit o en cas d'arribar al final retorna -1
    if(caracter == ESC) {   //detectar que es una seqüència escape
        caracter = super.read();    //torna a llegir
        if(caracter == CORCHETE) {  //detectar que el següent es un corchete
            caracter = super.read();    //torna a llegir
        switch(caracter) {  //mirem el cas que ens trobem despres del corchete
                case RIGHT:
                    return SEC_RIGHT;
                case LEFT:
                    return SEC_LEFT;
                case HOME:
                    return SEC_HOME;
                case END:
                    return SEC_END;
                case INSERT:
                    caracter = super.read();
                    if(caracter == TILDE) {
                        return SEC_INSERT;
                    }
                    return -1;
                case DELETE:
                    caracter = this.read();
                    if (caracter == TILDE) {
                        return SEC_DELETE;
                    }
                    return -1;
                default:
                    return -1;
        }
    }
    }else if (caracter == BACKSPACE) {  
                return BACKSPACE;
   }else {
	return caracter;
   }
        return -1;
}
   
public String readLine() throws IOException {
//llegeix la línia amb possibilitat d'editar-la
//funció lligada amb la classe Line
    String st = null;
    int caracter = 0;
    this.setRaw();  //veure seq escape
    while((caracter = this.read())!= ENTER) {	//mentres el caracter llegit no sigui la tecla enter
        switch(caracter) {	//mirem el cas en el que ens trobem
            case SEC_RIGHT:
                this.line.right();
                break;
            case SEC_LEFT:
                this.line.left();
                break;
            case SEC_INSERT:
                this.line.insert();
                break;
            case SEC_DELETE:
                this.line.delete();
                break;
	    case SEC_HOME:
		this.line.home();
		break;
            case SEC_END:
                this.line.end();
                break;
            case BACKSPACE:
                this.line.backspace();
		break;
            default:    //si no es un caracter especial, el guardem
                this.line.addChar((char) caracter);
        }
    }
    this.unsetRaw();    //desfer l'accio d'abans
    st = this.line.toString();	//podriem declarar una funció dins de Line per el toString

	return st;
	}

}
