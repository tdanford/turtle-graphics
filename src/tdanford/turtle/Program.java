package tdanford.turtle;

import java.util.*;

public class Program { 
	
	public LinkedList<Command> commands;

	public Program() { 
		commands = new LinkedList<Command>();
	}

	public int length() { return commands.size(); }
}
