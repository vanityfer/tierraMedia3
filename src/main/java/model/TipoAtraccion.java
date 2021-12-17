package model;

import java.util.HashMap;
import java.util.Map;

public class TipoAtraccion {
	  	private int ID;
	    private String name;
	    
	    public TipoAtraccion(int ID, String name) {
	       
	        this.ID = ID;
	        this.name = name;
	    }

	    public TipoAtraccion(String nombre) {
	       
	        this.name = nombre;
	    }

	    public int getID() {
	        return ID;
	    }

	    public void setID(int ID) {
	        this.ID = ID;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
}

