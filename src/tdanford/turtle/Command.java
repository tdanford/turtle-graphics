package tdanford.turtle;

import java.util.*;

public class Command { 
	
	public String key;
	public Object[] args;

	public Command(String k, Object... args) { 
		key = k;
		this.args = args.clone();
	}

	public String toString() { 
		if(args.length > 0) { 
			String str = key + "(";
			for(int i =0; i < args.length; i++) { 
				str += i != 0 ? "," : "";
				str += args[i].toString();
			}
			str += ")";
			return str;
		} else { 
			return key;	
		}
	}
}
