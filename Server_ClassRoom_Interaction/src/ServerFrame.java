//hello 
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ServerFrame extends JFrame implements ActionListener
{
	JPanel studentMsg;
	JLabel ipLabel,sessionIdLabel,ipValueLabel,sessionIdValueLabel;
	public int width,height;
	
	JComboBox studentNumberComboBox;
	JPanel audioPanel,textPanel,studentPanel;
	String ipAddress="127.0.0.1";
	String sessionId="1234";
	LinkedList<JButton>addButton=new LinkedList<JButton>();
	LinkedList<JButton>deleteButton=new LinkedList<JButton>();
	
	LinkedList<JButton>addButtonText=new LinkedList<JButton>();
	LinkedList<JButton>deleteButtonText=new LinkedList<JButton>();
	
	ServerFrame()
	{
		initializeGraphicComponents();
		setSize(width,height);
		setLocation(0,0);
		
		this.setLayout(new BorderLayout(10,10));
		
		JPanel ipPanel=new JPanel();
		ipPanel.setLayout(new GridLayout(3,2,10,10));
		ipPanel.setBorder(BorderFactory.createTitledBorder(""));
		
		ipPanel.add(ipLabel);
		ipPanel.add(ipValueLabel);
		ipPanel.add(sessionIdLabel);
		ipPanel.add(sessionIdValueLabel);
		
		createAudioPanel();
		createTextPanel();
		
		ipPanel.add(new JLabel("Number of Visible Students"));
		ipPanel.add(studentNumberComboBox);
		
		textPanel=new JPanel();
		textPanel.setLayout(new BorderLayout(10,10));
		JTabbedPane tabbedPane=new JTabbedPane();
		tabbedPane.addTab("Audio",audioPanel);
		tabbedPane.addTab("Text",textPanel);
		
		
		add(ipPanel,BorderLayout.NORTH);
		add(tabbedPane,BorderLayout.CENTER);
		
		studentNumberComboBox.addActionListener(this);		
	}
	
	private void createAudioPanel()
	{
		audioPanel=new JPanel();
		audioPanel.setLayout(new BorderLayout(10,10));
		
		studentPanel=new JPanel();
		studentPanel.setLayout(new GridLayout(15,1,10,10));
		audioPanel.add(studentPanel,BorderLayout.CENTER);
	}
	private void createTextPanel()
	{
		textPanel=new JPanel();
		textPanel.setLayout(new BorderLayout(10,10));
	    
		
		studentMsg=new JPanel();
	    studentMsg.setLayout(new GridLayout(5,1,1,1));
		textPanel.add(studentMsg,BorderLayout.CENTER);
	}	

	private JPanel createStudentTextMsgPanel(int i,Student student)
	{

		JPanel panel = new JPanel(new GridLayout(1,2,10,10));
  	 	  
    	JPanel Leftpanel=new JPanel(new GridLayout(1,2,10,10));
    	JPanel Rightpanel=new JPanel(new BorderLayout(10,10));
    	 
	    ImagePanel imagePanel=new ImagePanel("/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg",width/4,100);
		imagePanel.setSize(100, 100);
		Leftpanel.add(imagePanel);
		
    	Leftpanel.setBackground(Color.green);
	      
	    JPanel leftInnerPannel=new JPanel(new GridLayout(2,1,10,10));
	      
	      
	    leftInnerPannel.setBackground(Color.green);
	      
	    leftInnerPannel.add(new JLabel(student.studentName));
	    leftInnerPannel.add(new JLabel(student.doubtSubject));
	      
	    Leftpanel.add(leftInnerPannel);
	      
	      
	    JPanel right1=new JPanel(new BorderLayout(10,10));
	    JPanel right2=new JPanel(new GridLayout(1,2,10,10));
	    
	      
	      
	    right1.add(new JTextArea(student.textMessage));
	    right1.setBackground(Color.green);
	      
	      
		  	
	    right2.add(addButtonText.get(i));
		right2.add(deleteButtonText.get(i));
		
		    
	    Rightpanel.add(right1,BorderLayout.CENTER);
	    Rightpanel.add(right2,BorderLayout.SOUTH);
	      
	      
	    panel.add(Leftpanel);
	    panel.add(Rightpanel);
	     
	      	  return panel;
	  }

	private void initializeGraphicComponents()
	{
		for(int i=0;i<Student.studentListAudio.size();i++)
		{
			addButton.add(new JButton("\u2714"));
			addButton.get(i).setBackground(new Color(200,240,200));
			deleteButton.add(new JButton("X"));
			deleteButton.get(i).setBackground(new Color(240,200,200));
			
			addButton.get(i).addActionListener(this);
			deleteButton.get(i).addActionListener(this);
		}
		for(int i=0;i<Student.studentListText.size();i++)
		{
			addButtonText.add(new JButton("\u2714"));
			addButtonText.get(i).setBackground(new Color(200,240,200));
			deleteButtonText.add(new JButton("X"));
			deleteButtonText.get(i).setBackground(new Color(240,200,200));
			
			
			addButtonText.get(i).addActionListener(this);
			deleteButtonText.get(i).addActionListener(this);
		}
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int)screenSize.getWidth();
		height = (int)screenSize.getHeight();
		
		ipLabel=new JLabel("IP Address : ");
		sessionIdLabel=new JLabel("Session ID : ");
		
		ipValueLabel=new JLabel(ipAddress);
		sessionIdValueLabel=new JLabel(sessionId);
		
		studentNumberComboBox=new JComboBox();

		studentNumberComboBox.addItem("0");
		studentNumberComboBox.addItem("1");
		studentNumberComboBox.addItem("2");
		studentNumberComboBox.addItem("3");
		studentNumberComboBox.addItem("4");
		studentNumberComboBox.addItem("5");
		studentNumberComboBox.addItem("6");
		studentNumberComboBox.addItem("7");
		studentNumberComboBox.addItem("8");
		studentNumberComboBox.addItem("9");
		studentNumberComboBox.addItem("10");
		studentNumberComboBox.addItem("11");
		studentNumberComboBox.addItem("12");
		studentNumberComboBox.addItem("13");
		studentNumberComboBox.addItem("14");
		studentNumberComboBox.addItem("15");
		
	}
	
	private JPanel createStudentPanel(int i,Student student)
	{
		JPanel studentPanel=new JPanel();
		studentPanel.setLayout(new GridLayout(1,5,5,5));
		studentPanel.setBorder(BorderFactory.createTitledBorder(""));
		ImagePanel imagePanel=new ImagePanel("/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg",30,30);
		imagePanel.setSize(100, 100);
		studentPanel.add(imagePanel);
		studentPanel.add(new JLabel(student.studentName));
		studentPanel.add(new JLabel(student.doubtSubject));
		studentPanel.add(addButton.get(i));
		studentPanel.add(deleteButton.get(i));
		return studentPanel;
	}
	public Insets getInsets()
	{
		return new Insets(40,20,20,20);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==studentNumberComboBox)
		{
			studentPanel.setVisible(false);
			studentPanel=new JPanel();
			studentPanel.setLayout(new GridLayout(15,1,10,10));
			studentPanel.setBackground(Color.white);
			
			for(int i=0;i<Integer.parseInt(studentNumberComboBox.getSelectedItem().toString()) && i<Student.studentListAudio.size();i++)
			{
				System.out.println(i);
				studentPanel.add(createStudentPanel(i,Student.studentListAudio.get(i)));
			}
			
			audioPanel.add(studentPanel,BorderLayout.CENTER);
			//////////////
			studentMsg.setVisible(false);
			studentMsg=new JPanel();
			studentMsg.setLayout(new GridLayout(5,1,10,10));
		
			for(int i=0;i<Integer.parseInt(studentNumberComboBox.getSelectedItem().toString()) && i<Student.studentListText.size();i++)
			{
				studentMsg.add(createStudentTextMsgPanel(i,Student.studentListText.get(i)));
			}
			
			textPanel.add(studentMsg,BorderLayout.CENTER);
			
			return;
		}
		
		for(int i=0;i<Student.studentListAudio.size();i++)
		{
			if(ae.getSource()==addButton.get(i))
			{
				new GeneralDialogBox(this, Student.studentListAudio.get(i)).setVisible(true);
				return;
			}
			if(ae.getSource()==deleteButton.get(i))
			{
				/////////////////////////////////
				Student.studentListAudio.remove(i);
				////////////////////////////////
				studentPanel.setVisible(false);
				studentPanel=new JPanel();
				studentPanel.setLayout(new GridLayout(15,1,10,10));
				studentPanel.setBackground(Color.white);
			
				for(int j=0;j<Integer.parseInt(studentNumberComboBox.getSelectedItem().toString()) && j<Student.studentListAudio.size();j++)
				{
					System.out.println(j);
					studentPanel.add(createStudentPanel(j,Student.studentListAudio.get(j)));
				}
				audioPanel.add(studentPanel,BorderLayout.CENTER);
				System.out.println("Finish");
				return;
			}
			
		}
		for(int i=0;i<Student.studentListText.size();i++)
		{
			if(ae.getSource()==deleteButtonText.get(i))
			{
				Student.studentListText.remove(i);
				//textPanel.setVisible(false);
				//1createTextPanel();
				
				studentMsg.setVisible(false);
				studentMsg=new JPanel(new GridLayout(5,1,1,1));
				
				for(int j=0;j<Integer.parseInt(studentNumberComboBox.getSelectedItem().toString()) && j<Student.studentListText.size();j++)
				{
					studentMsg.add(createStudentTextMsgPanel(j,Student.studentListText.get(j)));
				}
				textPanel.add(studentMsg,BorderLayout.CENTER);
				return;
			}
			if(ae.getSource()==addButtonText.get(i))
			{
				new GeneralDialogBox(this, Student.studentListText.get(i)).setVisible(true);
				return;
			
			}
		}
	}
}

class Main
{
	public static void main(String []args)
	{
		
		new Student("A","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("B","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("C","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("D","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("E","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("F","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("G","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("H","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("I","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("J","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("K","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("L","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("M","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("N","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("O","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		new Student("P","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","audio");
		
		new Student("a","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("b","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("c","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("d","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("e","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("f","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("g","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("h","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("i","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("j","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("k","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("l","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("m","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("n","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("o","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		new Student("p","123.123.123","/home/lavish/Server_ClassRoom_Interaction/Server_ClassRoom_Interaction/Images/a.jpg","Computer Graphics","text");
		
		System.out.println("all Students initialized");
		ServerFrame sf=new ServerFrame();
		sf.setVisible(true);
		sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}