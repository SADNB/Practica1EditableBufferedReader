//package practica1;

import java.io.*;
import java.util.*;
import java.io.IOException;
//import java.io.Reader;
//import java.io.InputStreamReader;
import java.util.ArrayList;



public class Line {
	//Necessaries per el patró mvc
	static final int SEC_RIGHT = 2001;
	static final int SEC_LEFT = 2002;
	static final int SEC_HOME = 2003;
	static final int SEC_END = 2004;
	static final int SEC_INSERT = 2005;
	static final int SEC_DELETE = 2006;
	static final int SEC_CHAR = 2007;
	static final int BACKSPACE = 127;

	ArrayList<Character> vector;
	int poscursor;
	//char lastChar;
	boolean escriptura;

	public Line(){
		this.poscursor=0;
		this.vector=new ArrayList<>();
		this.escriptura=false;
	}

	
    	public int getPos(){
        	return this.poscursor;				
    	}
    
    	public void setPos(int pos) {
        	this.poscursor = poscursor;			
    	}


	public void right(){						//posar el poscursor una posició a la dreta
		if(this.poscursor < this.vector.size()) {		//mirem si estem al final de la línia
			this.poscursor=poscursor+1;			//ens movem a la dreta una posició
		}
		//si poscursor està al final de la línia, no tindria sentit anar a la dreta
		//per tant, ens quedariem a la mateixa posició
		
	}

	public void left(){						//posar el poscursor una posició a l'esquerra
		if(this.poscursor > 0) {				//mirem que la poscursor no sigui a l'inici
			this.poscursor=poscursor-1;			//ens movem a l'esquerra una posició
		}
		//si poscursor = 0, llavors ens seguirem quedant en aquesta posició

		
	}

	public void backspace(){					//esborra caràcter a l'esquerra
		if (this.poscursor > 0) {				//podrem esborrar si la poscursor no està a l'inici
			this.vector.remove(this.poscursor-1);		//esborrem caràcter de la posicio poscursor-1
				//this.poscursor=vector.size();
           			this.left();				//ens movem una posició a l'esquerra
		}
		       	
	}
	
	public void home(){
		this.poscursor=0;					//ens posa a principi de la linia
			
	}
	
	public void end(){
		this.poscursor=this.vector.size();			//ens posa al final de la línia
		
	}

	public void delete(){						//esborrar el caràcter actual
		 if(this.poscursor < this.vector.size()){		//mirem que estiguem dins del limit de l'array
            		this.vector.remove(this.poscursor);		//esborrem el caràcter de la posició actual
        	}
		
	}
	
	public void addChar(char caracter){				//afegir caràcter o substituir per un altre
		if(this.escriptura){					//si estem en mode sobre-escriptura
			if(this.poscursor < this.vector.size()) {	//si poscursor està en alguna posició dins del vector
				this.vector.set(this.poscursor, caracter); 	//substituim el caràcter de la posició actual per el nou caràcter passat per paràmetre
			}else {						//si estem a final de línia (poscursor = vector.size())
				this.vector.add(this.poscursor, caracter);	//simplement afegirem el caràcter al final
			}
		}else {							//si ens trobem en mode inserció
                    	this.vector.add(this.poscursor, caracter);	//afegim el caràcter en la psoició que estigui el cursor, sense substituir el que hi havia
        	}
        	//this.lastChar = caracter;				//variable aux
        	this.poscursor = this.poscursor + 1;			//avançem una posició 
		
			
	}
	public void insert(){						//commuta mode inserció/sobre-escriptura
		this.escriptura = !this.escriptura;			//canvia el mode inserció per el de sobre-escriptura i viceversa
		
	}


	public String toString() {

		String str = "";
		for (Character car: vector) {
			str = str + car;
		}
		return str;

	}

}
		
