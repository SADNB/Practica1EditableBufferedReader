package practica1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.List

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
		int i;
		for(i=poscursor;i<vector.length()-1;i++){
			vector[i]=vector[i+1];
		}
		vector[vector.length()-1]="";
	}

	public void end(){
		this.poscursor=vector.length()-1;
	}

	public void delete(){
		int i;
		for(i=poscursor+1;i<vector.length()-1;i++){
			vector[i]=vector[i+1];
		}
		vector[vector.length()-1]=null;
	}
	
	public void addChar(char caracter){
		int i;
		if(escriptura==true){
			vector[poscursor+1]=caracter;
			poscursor=poscursor+1;
		}else{
		for(i=vector.length();i>poscursor;i++){
			vector[i+1]=vector[i];
		}
		vector[poscursor]=caracter;
		}
	}
	public void insert(){
		if(escriptura==true){
			escriptura=false;
		}
	}
}
		
