package digital_clock;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Clock extends javax.swing.JFrame 
{

	private JFrame frame;
	private JLabel time_zone;
	private JLabel lblCurrentTimeIn;
	private JComboBox comboBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try 
				{
					Clock window = new Clock();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the application.
	 */
	
	int time_run =0;
	public Clock() 
	{
		initialize();
		new Thread() 
		{
			public void run()
			{
				while(time_run == 0)
				{
					//time_zone.setText(time_Ethiopia());
				}
			}
		}.start();	
	}
	
	public void time_Ethiopia()
	{
		Calendar cal = new GregorianCalendar();
		int AM_PM = cal.get(Calendar.AM_PM);
		
		ZoneId zone = ZoneId.of("Africa/Addis_Ababa");
		LocalTime local_time = LocalTime.now(zone);
		LocalTime new_time = local_time.minusHours(0);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
		String string = format.format(new_time);
		
		
		String day_time = "";
		if(AM_PM == 1)
		{
			day_time = "PM";
		}
		else
		{
			day_time = "AM";
		}
		
		time_zone.setText(string + " "+ day_time);
	}
	
	public void time_America()
	{
		Calendar cal = new GregorianCalendar();
		
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		int AM_PM = cal.get(Calendar.AM_PM);
		String time =hour + ":" + min + ":" + sec;
		
		String day_time = "AM";
		if(AM_PM == 1)
		{
			day_time = "PM";
		}
		
		time_zone.setText(time + " "+ day_time);
	}

	public void time_China()
	{
		Calendar cal = new GregorianCalendar();
		int AM_PM = cal.get(Calendar.AM_PM);
		
		ZoneId zone = ZoneId.of("Asia/Shanghai");
		LocalTime local_time = LocalTime.now(zone);
		LocalTime new_time = local_time.minusHours(0);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
		String string = format.format(new_time);
		
		String day_time = "";
		if(AM_PM == 1)
		{
			day_time = "PM";
		}
		else
		{
			day_time = "AM";
		}
		
		time_zone.setText(string + " "+ day_time);
	}
	public void time_Engaland()
	{
		Calendar cal = new GregorianCalendar();
		int AM_PM = cal.get(Calendar.AM_PM);
		
		ZoneId zone = ZoneId.of("Europe/London");
		LocalTime local_time = LocalTime.now(zone);
		LocalTime new_time = local_time.minusHours(0);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
		String string = format.format(new_time);
		
		String day_time = "";
		if(AM_PM == 1)
		{
			day_time = "PM";
		}
		else
		{
			day_time = "AM";
		}
		
		time_zone.setText(string + " "+ day_time);
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 682, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		 time_zone = new JLabel("00:00:00 ");
		time_zone.setForeground(Color.WHITE);
		time_zone.setBackground(Color.WHITE);
		time_zone.setHorizontalAlignment(SwingConstants.CENTER);
		time_zone.setFont(new Font("DS-Digital", Font.PLAIN, 90));
		time_zone.setBounds(126, 106, 465, 91);
		
		frame.getContentPane().add(time_zone);
		
	
		
		lblCurrentTimeIn = new JLabel("Current Time in");
		lblCurrentTimeIn.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblCurrentTimeIn.setForeground(Color.WHITE);
		lblCurrentTimeIn.setBounds(10, 11, 393, 61);
		frame.getContentPane().add(lblCurrentTimeIn);
		
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				new Thread() 
				{
					public void run()
					{
						while(time_run == 0)
						{
							if(comboBox.getSelectedItem().toString().equals("Ethiopia"))
							{
								time_Ethiopia();
							}
							else if(comboBox.getSelectedItem().toString().equals("New York"))
							{
								time_America();
							}
							else if(comboBox.getSelectedItem().toString().equals("China"))
							{
								time_China();
							}
							else if(comboBox.getSelectedItem().toString().equals("England"))
							{
								time_Engaland();
							}
							else if(comboBox.getSelectedItem().toString().equals("England"))
							{
								time_Engaland();
							}
							else if(comboBox.getSelectedItem().toString().equals("Choose"))
							{
								//time_Engaland();
							}
							
						}
					}
					
					
					
				}.start();
				
			}
		});
		
		
		comboBox.setMaximumRowCount(2);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 40));
		comboBox.setBounds(418, 11, 226, 55);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Choose");
		comboBox.addItem("Ethiopia");
		comboBox.addItem("New York");
		comboBox.addItem("China");
		comboBox.addItem("England");

		}
}
	

