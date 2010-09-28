package tdanford.turtle;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TurtlePanel extends JPanel { 
	
	public static void main(String[] args) { 
		TurtleSettings settings = new TurtleSettings();
		Turtle t = new Turtle(settings);
		Program p = new Program("F-F-F-F-");
		RewritingRule rule = new MatchingRewrite("F", "+F-F-F+");
		TurtlePanel panel = new TurtlePanel(t, p);
		TurtleFrame frame = new TurtleFrame(panel, rule);
	}
	
	private Turtle turtle;
	private Program program;

	public TurtlePanel(Turtle t, Program p) { 
		turtle = t;	
		program = p;
	}

	public void setState(Turtle t, Program p) { 
		turtle = t;
		program = p;
	}

	public Turtle getTurtle() { return turtle; }
	public Program getProgram() { return program; }

	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		int w = getWidth(), h = getHeight();
		int cx = w/2, cy = h/2;
		Graphics2D g2 = (Graphics2D)g;

		g2.setColor(Color.white);
		g2.fillRect(0, 0, w, h);
		g2.setColor(Color.black);

		g2.translate(cx, cy);

		turtle.execute(g2, program);

		g2.translate(-cx, -cy);
	}
}

class TurtleFrame extends JFrame { 
	
	private TurtlePanel panel;
	private RewritingRule rule;

	public TurtleFrame(TurtlePanel tp, RewritingRule rule) { 
		super("Turtle");
		panel = tp;
		this.rule = rule;

		Container c = (Container)getContentPane();
		c.setLayout(new BorderLayout());

		c.add(panel, BorderLayout.CENTER);
		JPanel buttons = new JPanel(new FlowLayout());
		c.add(buttons, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setPreferredSize(new Dimension(500, 500));

		JButton rewrite = new JButton(getRewriteAction());
		buttons.add(rewrite);

		setVisible(true);
		pack();
	}

	public Action getRewriteAction() { 
		return new AbstractAction("Rewrite") { 
			public void actionPerformed(ActionEvent e) { 
				Program p = rule.rewrite(panel.getProgram());	
				panel.setState(panel.getTurtle(), p);
				panel.repaint();
			}
		};
	}
}

