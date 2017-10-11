import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class typing_tutor extends JFrame  implements KeyListener{
	 private static final long serialVersionUID = 1L;	 
	 
	 //save Keycode representing Jbutton
	 private Map<Integer, JButton> keyCodeButtonMap = new HashMap<Integer, JButton>();
	 private String Sample_text = "The quick brown fox jumped over a lazy dog";

	 int key; 
	 public typing_tutor(){
		 super("Typing Application");
		  setBackground(Color.WHITE);
		  
		  //keyboard keys
		  String first[] = {"~" , "1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "0" , "-" , "+" , "BackSpace"};
		  String second[] = {"Tab" , "Q" , "W" , "E" , "R" , "T" , "Y" , "U" , "I" , "O" , "P" , "[" , "]" , "\\"};
		  String third[] = {"Caps" , "A" , "S" , "D" , "F" , "G" , "H" , "J" , "K" , "L" , ":" , "\"" , "Enter"};
		  String fourth[] = {"Shift" , "Z" , "X" , "C" , "V" , "B" , "N" , "M" , "," , "." , "?" , "¡ô"};
		  String Space = "         Space         ";
		  String left = "¡ö";
		  String down = "¡õ";
		  String right = "¡÷";
		 
		 //declare different panels
		 JPanel message_value = new JPanel();
		 JPanel keyboard_value = new JPanel(new GridBagLayout());
		 JPanel textboard_Value = new JPanel();
		 
		 //tips message panel
		 //put message panel to north area
		 add(message_value,BorderLayout.NORTH);
		 JLabel message_line1 = new JLabel("<html>Type some text using your keyboard. The keys you press will be highlighted and text will be displayed.<br>Note : Clicking the buttons with your mouse will not perform any action.</html>");
		 //set layout by method BorderLayout()
		 message_value.setLayout(new BorderLayout());
		 message_value.add(message_line1);
		 //put GetAccuary button to the east of this panel
		 JButton GetAccuary = new JButton("GetAccuary");
		 message_value.add(GetAccuary, BorderLayout.EAST);
		 
		 //user text input panel
		 JTextArea text = new JTextArea(50,50);
		 add(textboard_Value,BorderLayout.CENTER);
		 JLabel message_line2 = new JLabel("<html>Compare with : &nbsp;&nbsp;" + Sample_text + "</html>");
		 textboard_Value.setLayout(new BorderLayout());
		 textboard_Value.add(text);
		 textboard_Value.add(message_line2, BorderLayout.SOUTH);
		 
		 //keyboard button
		 JButton first_row[] = new JButton[first.length];
		 JButton second_row[] = new JButton[second.length];
		 JButton third_row[] = new JButton[third.length];
		 JButton fourth_row[] = new JButton[fourth.length];
		 JButton __space__ = new JButton(Space);
		 JButton __left__ = new JButton(left);
		 JButton __right__ = new JButton(right);
		 JButton __down__ = new JButton(down);
		 
		 //put keyboard keys to jbutton
		 for(int i = 0 ; i<first.length ; i++){
			 first_row[i] = new JButton(first[i]);
			 first_row[i].setBackground(Color.WHITE);
			 //use method GridBagConstraints to put row in line 0
			 GridBagConstraints gbc = new GridBagConstraints();
			 gbc.gridy = 0;
			 keyboard_value.add(first_row[i],gbc);
			 //save this button to map
			 keyCodeButtonMap.put(getKey(first[i]), first_row[i]);
		 }
		 

		 
		 for(int i = 0 ; i<second.length ; i++){
			 second_row[i] = new JButton(second[i]);
			 second_row[i].setBackground(Color.WHITE);
			 GridBagConstraints gbc = new GridBagConstraints();
			 gbc.gridy = 1;
			 keyboard_value.add(second_row[i],gbc);
			 keyCodeButtonMap.put(getKey(second[i]), second_row[i]);
			 
		 }
		 
		 for(int i = 0 ; i<third.length ; i++){
			 third_row[i] = new JButton(third[i]);
			 third_row[i].setBackground(Color.WHITE);
			 GridBagConstraints gbc = new GridBagConstraints();
			 gbc.gridy = 2;
			 keyboard_value.add(third_row[i],gbc);
			 keyCodeButtonMap.put(getKey(third[i]), third_row[i]);
		 }
		 
		 for(int i = 0 ; i<fourth.length ; i++){
			 fourth_row[i] = new JButton(fourth[i]);
			 fourth_row[i].setBackground(Color.WHITE);
			 GridBagConstraints gbc = new GridBagConstraints();
			 gbc.gridy = 3;
			 keyboard_value.add(fourth_row[i],gbc);
			 keyCodeButtonMap.put(getKey(fourth[i]), fourth_row[i]);
		 }
		 if(true){
			 GridBagConstraints gbc = new GridBagConstraints();
			 gbc.gridy = 4;
			 //adjust the space button width
			 gbc.gridwidth = 10;
			 __space__.setBackground(Color.WHITE);
			 keyboard_value.add(__space__,gbc);
			 keyCodeButtonMap.put(KeyEvent.VK_SPACE, __space__);
		 }
		 if(true){
			 GridBagConstraints gbc = new GridBagConstraints();
			 gbc.gridy = 4;
			 __left__.setBackground(Color.WHITE);
			 keyboard_value.add(__left__,gbc);
			 keyCodeButtonMap.put(KeyEvent.VK_LEFT, __left__);
			 __down__.setBackground(Color.WHITE);
			 keyboard_value.add(__down__,gbc);
			 keyCodeButtonMap.put(KeyEvent.VK_DOWN, __down__);
			 __right__.setBackground(Color.WHITE);
			 keyboard_value.add(__right__,gbc);
			 keyCodeButtonMap.put(KeyEvent.VK_RIGHT, __right__);
		 }
		 add(keyboard_value,BorderLayout.SOUTH);
		 
		 //key listener
		 text.addKeyListener(this);
		 
		 GetAccuary.addActionListener(
				 new ActionListener(){
					 @Override
					 	public void actionPerformed(ActionEvent event){
						 int correct = 0;
						 
						 char[] user_input = text.getText().toCharArray();
						 char[] sample_char = Sample_text.toCharArray();
						 int length_min = Math.min(user_input.length,sample_char.length);
						 
						 char[] Wrong_key = new char[user_input.length];
						 int j = 0;
						 //calculate accuary
						 for(int i = 0 ; i < length_min ; i++)
							 if(user_input[i] == sample_char[i])
								 {
								 correct++;
								 Wrong_key[j++] = ' ';
								 }
							 else
								 Wrong_key[j++] = user_input[i];
						 
						 int Races = 0;
						 String Race_WrongKey = new String("");
						 if(user_input.length > sample_char.length)
							 {
							 Race_WrongKey = text.getText().substring(Races + sample_char.length, user_input.length);
							 Races = user_input.length - sample_char.length;
							 correct -= Races;
							 if(correct < 0)
								 correct = 0;
							 }
						 String Wrong_keyString = new String(String.valueOf(Wrong_key));
						 
						 
						 String result = String.format("Correct Ratio : %d/%d", correct ,Sample_text.length());
						 String Wrong_message = "Wrong : ";
						 if(correct != Sample_text.length())
						 {
							 if(!Wrong_keyString.isEmpty())
								 Wrong_message += Wrong_keyString;
							 if(!Race_WrongKey.isEmpty())
								 Wrong_message += Race_WrongKey;
						 }
						 //System.out.print(Wrong_message);
						 //open a new frame
						JFrame Accuary_frame = new JFrame("Accuary");
						JLabel accuary_text = new JLabel("<html>" + result + "<br>" + "Text : &nbsp;&nbsp;&nbsp;"  + Sample_text + "<br>" + Wrong_message + "</html>");
						Accuary_frame.add(accuary_text);
						Accuary_frame.setSize(400,160);
						Accuary_frame.setVisible(true);
					 }
				 }
		);
		 
	 }	
	 
	 //get key value
	 private int getKey(String input){
		 if(input == "~")
			 return KeyEvent.VK_BACK_QUOTE;
		 else if (input == "-")
			 return KeyEvent.VK_SUBTRACT;
		 else if (input == "+")
			 return KeyEvent.VK_ADD;
		 else if (input == "BackSpace")
			 return KeyEvent.VK_BACK_SPACE;
		 else if (input == "Tab")
			 return KeyEvent.VK_TAB;
		 else if (input == "[")
			 return KeyEvent.VK_OPEN_BRACKET;
		 else if (input == "]")
			 return KeyEvent.VK_CLOSE_BRACKET;
		 else if (input == "\\")
			 return KeyEvent.VK_BACK_SLASH;
		 else if (input == "Caps")
			 return KeyEvent.VK_CAPS_LOCK;
		 else if (input == ":")
			 return KeyEvent.VK_SEMICOLON;
		 else if (input == "\"")
			 return KeyEvent.VK_QUOTE;
		 else if (input == "Enter")
			 return KeyEvent.VK_ENTER;
		 else if (input == "Shift")
			 return KeyEvent.VK_SHIFT;
		 else if (input == ",")
			 return KeyEvent.VK_COMMA;
		 else if (input == ".")
			 return KeyEvent.VK_PERIOD;
		 else if (input == "?")
			 return KeyEvent.VK_SLASH;
		 else if (input == "¡ô")
			 return KeyEvent.VK_UP;
		 else if (input == "¡õ")
			 return KeyEvent.VK_DOWN;
		 else if (input == "¡ö")
			 return KeyEvent.VK_LEFT;
		 else if (input == "¡÷")
			 return KeyEvent.VK_RIGHT;
		 else if(input == " ")
			 return KeyEvent.VK_SPACE;
		 else 
			 return (int)input.charAt(0);     
	 }
	 
	 //implement keylistener
	 @Override
	    public void keyPressed(KeyEvent input) {
	       key = input.getKeyCode();
	       //when key pressed , set button background to black
	       keyCodeButtonMap.get(key).setBackground(Color.BLACK);     
	 }
	 
	 @Override
	 	public void keyReleased(KeyEvent input){
		 key = input.getKeyCode();
		//when key Released, set button background to default background color
		 keyCodeButtonMap.get(key).setBackground(getBackground());
	 }
	 
	 @Override
	 	public void keyTyped(KeyEvent input){
	 }
	
}