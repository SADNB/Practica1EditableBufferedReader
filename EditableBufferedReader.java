import java.io.IOException;

/**
 *
 * @author virtual
 */
public class EditableBufferedReader{

    /**
     * @param args the command line arguments
     */
    public static void unsetRaw() throws IOException, InterruptedException {
        String [] cmd = {"/bin/sh", "-c", "stty cooked </dev/tty"}; //String con el comando a ejecutar
        Runtime.getRuntime().exec(cmd).waitFor(); //ejecuta el comando
    }

    public static void setRaw() throws IOException, InterruptedException {
        String [] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
        Runtime.getRuntime().exec(cmd).waitFor();
    }

    public static void main(String args[]){
	try {
 		 unsetRaw();//para probar
	}
	catch(IOException | InterruptedException e) {
  		e.printStackTrace();
		
	}
    }
    
}
