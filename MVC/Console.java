import java.io.*;
import java.util.*;

public class Console implements Observer {
    static final String RIGHT = "\033[C";
    static final String LEFT = "\033[D";
    static final String INSERT = "\033[4h";
    static final String BACKSPACE = "\b";
    static final String DELETE = "\033[P";
    static final String HOME = "\033[1~";
    static final String END = "\033[4~";
    static final String ESPAI = "\033[ ";
    static final String BLANK_SPACE = "\033[@";
	static final int SEC_RIGHT = 2001;
	static final int SEC_LEFT = 2002;
	static final int SEC_HOME = 2003;
	static final int SEC_END = 2004;
	static final int SEC_INSERT = 2005;
	static final int SEC_DELETE = 2006;
	static final int SEC_CHAR = 2007;
	static final int SEC_BACKSPACE = 127;
    Line line;
   public Console(Line l){
   	this.line=l;
   }
   public void update(Observable ob, Object o){
	int comanda = (int) o;
	switch(comanda){
		case SEC_RIGHT:
		   System.out.print(RIGHT);
		   break;
		case SEC_LEFT:
		   System.out.print(LEFT);
		   break;
		case SEC_HOME:
		   System.out.print(HOME);
		   break;
		case SEC_END:
		   System.out.print(END);
		   break;	
		case SEC_INSERT:
		   System.out.print(RIGHT);
		   break;
		case SEC_DELETE:
		   System.out.print(DELETE);
		   break;
		case SEC_CHAR:
		   if(line.escriptura){
		   	System.out.print(ESPAI);
		   }
		   System.out.print(line.vector.get(line.vector.size()-1));
		   break;
		case SEC_BACKSPACE:
		   System.out.print(BACKSPACE);
	}
   }
}
