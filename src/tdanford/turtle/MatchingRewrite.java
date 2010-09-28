package tdanford.turtle;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MatchingRewrite implements RewritingRule { 
	
	private String target;
	private String expansion;
	private java.util.regex.Pattern targetPattern;

	public MatchingRewrite(String t, String e) { 
		target = t; 
		expansion = e;
		targetPattern = java.util.regex.Pattern.compile(target);
	}

	public boolean matches(String progStr) { 
		return targetPattern.matcher(progStr).find();
	}

	public String expand(String pstr) { 
		return pstr.replace(target, expansion);
	}
	
	public boolean canFire(Program p) { 
		return matches(p.toString());
	}

	public Program rewrite(Program p) { 
		String pstr = p.toString();
		if(matches(pstr)) { 
			String nstr = expand(pstr);
			return new Program(nstr);
		} else { 
			return p;
		}
	}
}

