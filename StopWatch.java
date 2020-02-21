import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopWatch extends JApplet
{
	private final int TIME_DELAY = 1000;
	private int numSeconds = 0;
	private JTextField seconds;
	private JButton startButton;
	private JButton stopButton;
	private JPanel secondsPanel;
	private JPanel buttonPanel;
	private Timer timer;

	public void init()
	{
		buildButtonPanel();
		buildSecondPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		add(secondsPanel, BorderLayout.CENTER);
		timer = new Timer(TIME_DELAY, new TimerListener());
	}

	private void buildButtonPanel()
	{
		buttonPanel = new JPanel();
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		startButton.addActionListener(new StartButtonListener());
		stopButton.addActionListener(new StopButtonListener());
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
	}

	private void buildSecondPanel()
	{
		secondsPanel = new JPanel();
		seconds = new JTextField(10);
		seconds.setEditable(false);
		seconds.setFont(new Font("SansSerif", Font.BOLD, 18));
		seconds.setText("0");
		secondsPanel.add(seconds);
	}

	private class StartButtonListener implements ActionListener
	{
		/** @param e An ActionEvent object.*/

		public void actionPerformed(ActionEvent e)
		{
			timer.start();
		}
	}

	private class StopButtonListener implements ActionListener
	{
		/** @param e An ActionEvent object.*/

		public void actionPerformed(ActionEvent e)
		{
			timer.stop();
		}
	}

	private class TimerListener implements ActionListener
	{
		/** @param e An ActionEvent object.*/

		public void actionPerformed(ActionEvent e)
		{
			numSeconds++;
			seconds.setText(String.valueOf(numSeconds));
		}
	}
}
