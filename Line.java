//package practica1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Line{
	ArrayList<Integer> vector;
	int poscursor;
	boolean escriptura;
	public Line(){
		this.poscursor=0;
		this.vector=new ArrayList<Integer>();
		this.escriptura=true;
	}

	public void right(){
		this.poscursor=poscursor+1;
	}

	public void left(){
		this.poscursor=poscursor-1;
	}

	public void backspace(){
		vector.remove(poscursor-1);
		this.poscursor=vector.size();
	}

	public void end(){
		this.poscursor=vector.size()-1;
	}

	public void delete(){
		vector.remove(poscursor);
		this.poscursor=vector.size();
	}
	
	public void addChar(int caracter){
		int i;
		if(escriptura==true){
			vector.add(caracter);
		}else{
			vector.add(poscursor,caracter);	
		}
		this.poscursor=vector.size();
	}
	public void insert(){
		if(escriptura==true){
			escriptura=false;
		}
	}
}
		
