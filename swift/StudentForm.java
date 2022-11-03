import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class StudentForm extends JFrame implements ActionListener
{
  JLabel dl,nl,rl,yl;
  JTextField nt,rt;
  JRadioButton r1,r2,r3;
  JTextArea ja;
  JPanel p1;
  JScrollPane js ;
  JButton addb,clearb;
  ButtonGroup bg;
  public StudentForm(){
     dl = new JLabel("Data Entry");
     nl = new JLabel("Name");
     rl = new JLabel("Reg No");
     yl = new JLabel("Year");
     nt = new JTextField(20);
     rt = new JTextField(20);
     r1 = new JRadioButton("2");
     r2 = new JRadioButton("3");
     r3 = new JRadioButton("4");
     bg = new ButtonGroup();
     ja = new JTextArea();
     js = new JScrollPane();
     addb = new JButton("ADD");
     clearb = new JButton("CLEAR");
     addb.addActionListener(this);
     clearb.addActionListener(this);
     ja.add(js);
     bg.add(r1);
     bg.add(r2);
     bg.add(r3);
     p1 = new JPanel();
     p1.setLayout(null);
     p1.add(dl); 
     p1.add(nl);
     p1.add(nt);
     p1.add(rl);
     p1.add(rt);
     p1.add(yl);
     p1.add(r1);
     p1.add(r2);
     p1.add(r3);
     p1.add(addb);
     p1.add(clearb);
     p1.add(ja);
     dl.setBounds(10,10,100,20);
     nl.setBounds(10,40,50,20);
     nt.setBounds(60,40,100,20);
     rl.setBounds(10,70,50,20);
     rt.setBounds(60,70,100,20);
     yl.setBounds(10,100,50,20);
     r1.setBounds(60,100,40,20);
     r2.setBounds(100,100,40,20);
     r3.setBounds(140,100,40,20);
     addb.setBounds(10,130,70,25);
     clearb.setBounds(90,130,70,25);
     ja.setBounds(200,10,100,200);
     add(p1);
  }
  public void actionPerformed(ActionEvent ae){
   String cmd = ae.getActionCommand();
   if(cmd.equals("CLEAR")){
      nt.setText("");
      rt.setText("");
      bg.clearSelection();
      addb.setEnabled(true);
   }else{
      String val = ""+nt.getText()+"\n"+rt.getText()+"\n";
      if(r1.isSelected()){
         val+="2nd year\n";
      }else if(r2.isSelected()){
         val+="3nd year\n";
      }if(r3.isSelected()){
         val+="3nd year\n";
      }
      val+="########################\n";
      ja.append(val);
      addb.setEnabled(false);

   }
  }
  public static void main(String argv[]){
     StudentForm sf = new StudentForm();
     sf.setVisible(true);
     sf.setTitle("Student Form");
     sf.setSize(400,200);
  }
}
