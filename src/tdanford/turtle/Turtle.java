package tdanford.turtle;

import java.util.*;
import java.awt.Graphics2D;

public class Turtle { 
	
	public TurtleSettings settings;
	public int x, y;
	public double heading;

	public Turtle(int x, int y, double h) { 
		this.x = x; 
		this.y = y;
		this.heading = h;
	}

	public void execute(Graphics2D g2, Program p) {
		for(Command c : p.commands) { 
			execute(g2, c);
		}
	}

	public void execute(Graphics2D g2, Command command) { 
		if(command.key.equals("F")) { 
			
		} else if (command.key.equals("+")) { 

		} else if (command.key.equals("-")) { 
			
		}
	}
}
