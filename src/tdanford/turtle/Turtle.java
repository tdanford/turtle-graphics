package tdanford.turtle;

import java.util.*;
import java.awt.Graphics2D;

public class Turtle { 
	
	public TurtleSettings settings;
	public int x, y;
	public double heading;

	public Turtle(TurtleSettings s, int x, int y, double h) { 
		this.x = x; 
		this.y = y;
		this.heading = h;
		this.settings = s;
	}

	public Turtle(TurtleSettings settings) { 
		this(settings, 0, 0, 0.0);
	}

	public void execute(Graphics2D g2, Program p) {
		for(Command c : p.commands) { 
			execute(g2, c);
		}
	}

	public void execute(Graphics2D g2, Command command) { 
		int px = x, py = y;

		if(command.key.equals("F")) { 
			x = settings.fx(x, heading);
			y = settings.fy(y, heading);
			g2.drawLine(px, py, x, y);

		} else if (command.key.equals("f")) { 
			x = settings.fx(x, heading);
			y = settings.fy(y, heading);
			
		} else if (command.key.equals("+")) { 
			heading = settings.plus(heading);

		} else if (command.key.equals("-")) { 
			heading = settings.minus(heading);	
		}
	}
}
