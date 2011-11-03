
		//set up a timer to simulate the elapse of time in the game
		void setStatsTimer(int dayCounter);
		
		
		---------------------------
		
			public void setStatsTimer(int param, int delay) {
		ActionListener TaskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				final JTextField paramField = new JTextField(8);
				paramField.setEditable(false);
				
				Switch 
				
				paramField.setText(param+ " ");
				param++;
				paramField.setText(param + " ");
			}
		};
		new Timer(delay, TaskPerformer).start();
	}

		