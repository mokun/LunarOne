/**
 * Filename:    LunarOne.java 
 * Author:      Manny Kung
 * Date:   		31 Oct 2011
 * Revision:	0
 * Subject:     LunarOne--my first java-based game
 * Input:      
 * Output:      
 * */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class LunarOne extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int WINDOWS_WIDTH = 800;
	private final int WINDOWS_HEIGHT = 200;
	private StatsPanel sPanel;
	
	
	public LunarOne() {
	
		setTitle("LunarOneCity Simulator");
		setSize(WINDOWS_WIDTH, WINDOWS_HEIGHT );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setLayout(new BorderLayout());
		sPanel = new StatsPanel(); // create statsPanel.java
		//mainPanel = new RateCategoryPanel();
		//statusPanel = new statusPanel()
		
		add(sPanel, BorderLayout.NORTH);
		//add(mainPanel, BorderLayout.CENTER);
		//add(statusPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
}
