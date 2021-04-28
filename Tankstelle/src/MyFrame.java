import javax.swing.JFrame;

public class MyFrame  extends JFrame{
	MyPanel myPanel= new MyPanel();
	MyFrame(){
		this.add(myPanel);
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
	}
	

}
