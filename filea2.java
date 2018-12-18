import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
class file extends Frame implements ActionListener
{
Label l1,l2,l3;
Button b1,b2,b3,b4,b5,b6,b7;
TextField t1,t2,t3,t4;
String s1,s2,s3,buf;
long l;
RandomAccessFile raf;
long[] fp=new long[10];
int i=0,k=0;
file()throws FileNotFoundException
{
setLayout(null);
raf=new RandomAccessFile("c:/RandomProject","rw");
l1=new Label("Name");
l2=new Label("ID");
l3=new Label("Branch");
b1=new Button("Add");
b2=new Button("First");
b3=new Button("Next");
b4=new Button("Previous");
b5=new Button("Last");
b6=new Button("Clear");
b7=new Button("Position");
t1=new TextField(90);
t2=new TextField(90);
t3=new TextField(90);
t4=new TextField(90);
add(l1);
add(t1);
add(l2);
add(t2);
add(l3);
add(t3);
add(b1);
add(b2);
add(b3);
add(b4);
add(b5);
add(b6);
add(t4);
add(b7);
l1.setBounds(85,100,50,20);
t1.setBounds(155,100,80,20);
l2.setBounds(85,130,50,20);
t2.setBounds(155,130,80,20);
l3.setBounds(85,160,50,20);
t3.setBounds(155,160,80,20);
b1.setBounds(70,190,50,20);
b2.setBounds(135,190,50,20);
b3.setBounds(200,190,50,20);
b4.setBounds(70,220,50,20);
b5.setBounds(135,220,50,20);
b6.setBounds(200,220,50,20);
t4.setBounds(85,250,50,20);
b7.setBounds(155,250,50,20);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});
}
public void actionPerformed(ActionEvent e)
{
try 
{
if(e.getSource()==b1)
{
fp[i]=raf.getFilePointer();
s1=t1.getText();
s2=t2.getText();
s3=t3.getText();
buf=s1+"|"+s2+"|"+s3+"|";
raf.writeUTF(buf);
i++;
}
if(e.getSource()==b2)
{
raf.seek(fp[0]);
buf=raf.readUTF();
StringTokenizer st=new StringTokenizer(buf,"|");
s1=st.nextToken();
s2=st.nextToken();
s3=st.nextToken();
t1.setText(s1);
t2.setText(s2);
t3.setText(s3);
}
if(e.getSource()==b3)
{
buf=raf.readUTF();
StringTokenizer st=new StringTokenizer(buf,"|");
s1=st.nextToken();
s2=st.nextToken();
s3=st.nextToken();
t1.setText(s1);
t2.setText(s2);
t3.setText(s3);
}
if(e.getSource()==b4)
{
l=raf.getFilePointer();
for(int j=0;j<10;j++)
{
if(l==fp[j])
{
k=j;
break;
}
}
raf.seek(fp[k-2]);
buf=raf.readUTF();
StringTokenizer st=new StringTokenizer(buf,"|");
s1=st.nextToken();
s2=st.nextToken();
s3=st.nextToken();
t1.setText(s1);
t2.setText(s2);
t3.setText(s3);
}
if(e.getSource()==b5)
{
raf.seek(fp[i-1]);
buf=raf.readUTF();
StringTokenizer st=new StringTokenizer(buf,"|");
s1=st.nextToken();
s2=st.nextToken();
s3=st.nextToken();
t1.setText(s1);
t2.setText(s2);
t3.setText(s3);
}
if(b6==e.getSource())
{
t1.setText(" ");
t2.setText(" ");
t3.setText(" ");
}
if(b7==e.getSource())
{
int a=Integer.parseInt(t4.getText());
raf.seek(fp[a-1]);
buf=raf.readUTF();
StringTokenizer st=new StringTokenizer(buf,"|");
s1=st.nextToken();
s2=st.nextToken();
s3=st.nextToken();
t1.setText(s1);
t2.setText(s2);
t3.setText(s3);

}
}
catch(Exception ex)
{
}
}
}
class filea2
{
public static void main(String args[])throws FileNotFoundException
{
file f=new file();
f.setVisible(true);
f.setSize(400,400);
f.setTitle("RandomAccessFile Using AWT");
f.setBackground(Color.pink);
}
}



