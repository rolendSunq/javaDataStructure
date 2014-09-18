package stack.postfix.calculator;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PostFixGUIMain {
	// text field
	private static JTextField expressionText; // text field for postfix
												// expression

	// status Label
	private static JLabel statusLabel; // label for status/result info

	// Define a button listener.
	private static class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event)
		// listener for the button events
		{
			if (event.getActionCommand().equals("Evaluate")) { // Handles
																// Evaluate
																// event.
				int result = 0;
				String errMessage = null;
				try {
					result = PostFixEvaluator
							.evaluate(expressionText.getText());
					statusLabel.setText("Result = " + result);
				} catch (PostFixException error) {
					errMessage = error.getMessage();
					statusLabel.setText("Result = " + errMessage);
				}

			} else if (event.getActionCommand().equals("Clear")) { // Handles
																	// Clear
																	// event.
				statusLabel.setText("cleared");
				expressionText.setText("");
			}
		}
	}

	public static void main(String args[]) throws IOException {
		// Declare/instantiate/initialize display frame.
		JFrame displayFrame = new JFrame();
		displayFrame.setTitle("PostFix Expression Evaluator Program");
		displayFrame.setSize(400, 100);
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// displayFrame.setDefaultCloseOperation(3);

		// text box for expression
		expressionText = new JTextField("postfix expression goes here", 60);

		// Status/Result label
		statusLabel = new JLabel("status", JLabel.CENTER);
		statusLabel.setBorder(new LineBorder(Color.red, 3));

		// Evaluate and clear buttons
		JButton evaluate = new JButton("Evaluate");
		JButton clear = new JButton("Clear");

		// Button event listener
		ActionHandler action = new ActionHandler();

		// Register button listeners.
		evaluate.addActionListener(action);
		clear.addActionListener(action);

		// Instantiate content pane and information panels.
		Container contentPane = displayFrame.getContentPane();
		JPanel expressionPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		// Initialize expression panel.
		expressionPanel.setLayout(new GridLayout(2, 1));
		expressionPanel.add(expressionText);
		expressionPanel.add(statusLabel);

		// Initialize button panel.
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(evaluate);
		buttonPanel.add(clear);

		// Set up and show the frame.
		contentPane.add(expressionPanel, "North");
		contentPane.add(buttonPanel, "Center");

		displayFrame.pack();
		displayFrame.setVisible(true);
	}
}
