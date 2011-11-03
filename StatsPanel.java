/**
 * Filename:    StatsPanel.java 
 * Author:      Manny Kung
 * Date:   		31 Oct 2011
 * Revision:	0
 * Subject:     LunarOne--my first java-based game
 * Input:      
 * Output:      
 * */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel cashLabel, dayLabel, oxygenLabel, waterLabel, powerLabel, greeting; 
	
	final private int TIME_ELAPSE = 2000; // in milliseconds
	final private int CASH_FUNDING_CYCLE= 10000; // in milliseconds
	final private int WATER_USAGE = 5000; // in milliseconds
	final private int OXYGEN_USAGE = 8000; // in milliseconds
	final private int POWER_USAGE = 8000; // in milliseconds
	// player parameters:
	private double cashReserve = 1000.0; // available cash in $
	private double cashInvestment = 100.0; // current investment from outside
	private int dayCounter = 0; // number of day you're the CEO since the colony starts
	private double oxygenReserve = 1000.0; // available O2 in kg
	private double waterReserve = 1000.0; // available H2O in kg
	private double powerReserve = 1000.0; // available power in kiloWatt (kW)
	private double totalMachinePowerUsage; // the combined total of power usage in kW
	
	private double getMachinePowerUsage() {
		return totalMachinePowerUsage; 
	}
	private double getCashFlow() {
		return cashInvestment; 
	}
	// will write member methods for accessing each private object member
	
	
	
	public StatsPanel() {
		// define labels
		greeting = new JLabel("Welcome to the LunarOneCity Java Game    ");
		dayLabel = new JLabel("   Day ");
		cashLabel = new JLabel("   Cash: ");
		oxygenLabel = new JLabel("   Oxygen: ");
		waterLabel = new JLabel("   Water: ");
		powerLabel = new JLabel("   Power: ");
		
	
		// define textfields
		final JTextField cashField = new JTextField(8);
		cashField.setEditable(false);
		cashField.setText(cashReserve+ " ");
		
		final JTextField dayField = new JTextField(4);
		dayField.setEditable(false);
		dayField.setText(dayCounter + " ");
		
		final JTextField waterField = new JTextField(4);
		waterField.setEditable(false);
		waterField.setText(waterReserve + " ");
		
		final JTextField oxygenField = new JTextField(4);
		oxygenField.setEditable(false);
		oxygenField.setText(oxygenReserve + " ");

		final JTextField powerField = new JTextField(4);
		powerField.setEditable(false);
		powerField.setText(powerReserve + " ");
		
		// print out player stats bar on the top
		//add(greeting);
		add(dayLabel);
		add(dayField);
		add(cashLabel);
		add(cashField);
		add(waterLabel);
		add(waterField);
		add(oxygenLabel);
		add(oxygenField);
		add(powerLabel);
		add(powerField);
		
		//set up a timer to simulate the elapse of time in the game
		ActionListener timeElapseTaskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dayField.setText(dayCounter + " ");
				dayCounter++;
			}
		};
		new Timer(TIME_ELAPSE, timeElapseTaskPerformer).start();

		//set up a timer to simulate the consumption of water
		ActionListener waterUsageTaskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {			    	  
				waterReserve--;
				waterField.setText(waterReserve + " ");
			}
		};
		new Timer(OXYGEN_USAGE, waterUsageTaskPerformer).start();
			  
		//set up a timer to simulate the consumption of oxygen
		ActionListener oxygenUsageTaskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				oxygenReserve--;
				oxygenField.setText(oxygenReserve + " ");
			}
		};
		new Timer(WATER_USAGE, oxygenUsageTaskPerformer).start();
			  
		//set up a timer to simulate the power usage
		ActionListener powerUsageTaskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				powerReserve = powerReserve - getMachinePowerUsage();
				powerField.setText(powerReserve + " ");
			}
		};
		new Timer(POWER_USAGE, powerUsageTaskPerformer).start();
		
		//set up a timer to simulate the cash flow
		ActionListener cashReserveTaskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cashReserve = cashReserve + getCashFlow();
				cashField.setText(cashReserve + " ");
			}
		};
		new Timer(CASH_FUNDING_CYCLE, cashReserveTaskPerformer).start();
		
	} // end of public StatsPanel()
} // end of public class StatsPanel extends JPanel
