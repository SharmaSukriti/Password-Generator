import java.awt.Font; 
import java.awt.GridLayout; 
import java.awt.Toolkit; 
import java.awt.datatransfer.Clipboard; 
import java.awt.datatransfer.StringSelection; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.security.SecureRandom; 
import javax.swing.*; 
import java.io.*; 
import java.util.Random; 
import java.util.*; 
public class PWGen extends JFrame { 
 public static void main(String args[]) { 
 PWGen f = new PWGen(); 
 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 f.setLocationRelativeTo(null); 
 f.setVisible(true); 
 } 
 private final SecureRandom secureRandom = new SecureRandom(); 
 private final JTextArea textArea = new JTextArea(); 
 private final JButton generateButton = new JButton("Generate"); 
 private final JButton copyButton = new JButton("Copy"); 
 public PWGen() { 
 super("Easy Password Generator"); 
 generateButton.addActionListener(new ActionListener() { 
 @Override 
 public void actionPerformed(ActionEvent e) { 
 textArea.setText(generate()); 
 } 
 }); 
 copyButton.addActionListener(new ActionListener() { 
 @Override 
 public void actionPerformed(ActionEvent e) {
     Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard(); 
 clip.setContents(new StringSelection(textArea.getText()), null); 
 } 
 }); 
 textArea.setColumns(20); 
 textArea.setFont(new Font("SansSerif", Font.PLAIN, 18)); 
 JPanel optionPanel = new JPanel(); 
 JPanel buttonPanel = new JPanel(); 
 buttonPanel.add(textArea); 
 buttonPanel.add(generateButton); 
 buttonPanel.add(copyButton); 
 JPanel contentPanel = new JPanel(new GridLayout(2, 1)); 
 contentPanel.add(optionPanel); 
 contentPanel.add(buttonPanel); 
 setContentPane(contentPanel); 
 pack(); 
 } 
 public String generate() { 
 String password = ""; 
 String consonants = "bcdfghjklmnprstvwz"; 
 String vowels = "aeiou"; 
 String all = consonants + vowels; 
 for (int i = 0; i < 2; i++) { 
 if (rndNum(5) % 2 == 0) { 
 password += Character.toUpperCase(consonants.charAt(rndNum(consonants.length() - 1))); 
 password += vowels.charAt(rndNum(vowels.length() - 1)); 
 } else { 
 password += consonants.charAt(rndNum(consonants.length() - 1)); 
 password += Character.toUpperCase(vowels.charAt(rndNum(vowels.length() - 1))); 
 } 
 password += all.charAt(rndNum(all.length() - 1)); 
 } 
 password += Integer.toString(rndNum(99)); 
 return password; 
 } 
 public static int rndNum(int size) { 
 Random generator = new Random(); 
 return generator.nextInt(size) + 1; 
 } 
}