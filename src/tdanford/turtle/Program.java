package tdanford.turtle;

import java.util.*;

public class Program { 
	
	public LinkedList<Command> commands;

	public Program() { 
		commands = new LinkedList<Command>();
	}

	public Program(String str) { 
		this();
		for(int i = 0; i < str.length(); i++) { 
			commands.add(new Command(String.valueOf(str.charAt(i))));
		}
	}

	public String toString() { 
		StringBuilder sb = new StringBuilder();
		for(Command c : commands) { 
			sb.append(c.toString());
		}
		return sb.toString();
	}

	public int length() { return commands.size(); }

	public Command getCommand(int i) { return commands.get(i); }

	public Collection<Command> getCommands() { return new LinkedList<Command>(commands); }
}
