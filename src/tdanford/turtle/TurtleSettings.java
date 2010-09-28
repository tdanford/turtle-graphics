package tdanford.turtle;

import java.util.*;

public class TurtleSettings { 

	public double forwardDistance;
	public double plusHeading, minusHeading;

	public TurtleSettings() { 
		forwardDistance = 1.0;
		plusHeading = Math.PI / 2.0;
		minusHeading = -Math.PI / 2.0;
	}

	public double plus(double heading) { return heading + plusHeading; }

	public double minus(double heading) { return heading + minusHeading; }

	public int fx(int x, double heading) { 
		return (int)Math.round((double)x + forwardDistance * Math.cos(heading));
	}

	public int fy(int y, double heading) { 
		return (int)Math.round((double)y + forwardDistance * Math.sin(heading));
	}
}
