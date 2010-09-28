package tdanford.turtle;

import java.util.*;

public interface RewritingRule { 
	public boolean canFire(Program p);
	public Program rewrite(Program p);
}

