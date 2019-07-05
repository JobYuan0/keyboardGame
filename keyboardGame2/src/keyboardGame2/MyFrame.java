package keyboardGame2;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener{
//设置窗口
	protected final static int MyFrame_Length=1000;
	protected final static int MyFrame_Width=1800;
//设置菜单栏及选项
	protected MenuBar jmb=null;
	protected Menu jm1=null,jm2=null,jm3=null,jm4=null,jm5=null,jm6=null;
	protected MenuItem jmi1=null,jmi2=null,jmi3=null,jmi4=null,jmi5=null,jmi6=null,jmi7=null,
			jmi8=null,jmi9=null,jmi10=null,jmi11=null,jmi12=null,jmi13=null,
			jmi14=null,jmi15=null,jmi16=null,jmi17=null,jmi18=null,jmi19=null;
//存储当前字母
	public static ArrayList<Alphabet> apList=new ArrayList<Alphabet>();
//初始化属性值
	public static boolean paintable=true;
	public static int level=0;
	public static int score=0;
	public static int life=5;    
	public static boolean bgm=false;
//控制背景图片
	public static int BG=0;
//构造函数
	public MyFrame(){
		//设置菜单栏
		jmb=new MenuBar();
		jm1=new Menu("游戏");jm2=new Menu("暂停/继续");jm3=new Menu("级别");jm4=new Menu("帮助");jm5=new Menu("游戏背景");jm6=new Menu("背景音乐");
		jmi1=new MenuItem("开始新游戏");jmi2 = new MenuItem("退出");jmi3 = new MenuItem("暂停");
		jmi4 = new MenuItem("继续");jmi5 = new MenuItem("游戏说明");jmi6 = new MenuItem("级别0");
		jmi7 = new MenuItem("级别2");jmi8 = new MenuItem("级别5");jmi9 = new MenuItem("级别8");
		jmi10=new MenuItem("背景一");jmi11=new MenuItem("背景二");jmi12=new MenuItem("背景三");jmi13=new MenuItem("背景四");
		jmi14=new MenuItem("1");jmi15=new MenuItem("2");jmi16=new MenuItem("3");jmi17=new MenuItem("4");jmi18=new MenuItem("5");jmi19=new MenuItem("关");
		jmb.add(jm1);jmb.add(jm2);jmb.add(jm3);jmb.add(jm4);jmb.add(jm5);jmb.add(jm6);
		jm1.add(jmi1);jm1.add(jmi2);
		jm2.add(jmi3);jm2.add(jmi4);
		jm3.add(jmi6);jm3.add(jmi7);jm3.add(jmi8);jm3.add(jmi9);
		jm4.add(jmi5);
		jm5.add(jmi10);jm5.add(jmi11);jm5.add(jmi12);jm5.add(jmi13);
		jm6.add(jmi14);jm6.add(jmi15);jm6.add(jmi16);jm6.add(jmi17);jm6.add(jmi18);jm6.add(jmi19);
		jm1.setFont(new Font("TimesRoman", Font.BOLD, 15));// 设置菜单显示的字体
		jm2.setFont(new Font("TimesRoman", Font.BOLD, 15));// 设置菜单显示的字体
		jm3.setFont(new Font("TimesRoman", Font.BOLD, 15));// 设置菜单显示的字体
		jm4.setFont(new Font("TimesRoman", Font.BOLD, 15));// 设置菜单显示的字体
		jm5.setFont(new Font("TimesRoman", Font.BOLD, 15));// 设置菜单显示的字体
		jm6.setFont(new Font("TimesRoman", Font.BOLD, 15));// 设置菜单显示的字体
		//设置界面属性
		this.setMenuBar(jmb);
		this.setSize(MyFrame_Width, MyFrame_Length);
		this.setLocation(40, 10);
		this.setTitle("keyboardGame");
		this.addWindowListener(new WindowAdapter() { // 窗口监听关闭
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setResizable(false);		//不可改变窗体大小
		
		//为菜单栏添加事件监视
		jmi1.addActionListener(this);jmi1.setActionCommand("NewGame")   ;
		jmi2.addActionListener(this);jmi2.setActionCommand("Exit");
		jmi3.addActionListener(this);jmi3.setActionCommand("Stop");
		jmi4.addActionListener(this);jmi4.setActionCommand("Continue");
		jmi5.addActionListener(this);jmi5.setActionCommand("Help");
		jmi6.addActionListener(this);jmi6.setActionCommand("Level0");
		jmi7.addActionListener(this);jmi7.setActionCommand("Level2");
		jmi8.addActionListener(this);jmi8.setActionCommand("Level5");
		jmi9.addActionListener(this);jmi9.setActionCommand("Level8");
		jmi10.addActionListener(this);jmi10.setActionCommand("bg1");
		jmi11.addActionListener(this);jmi11.setActionCommand("bg2");
		jmi12.addActionListener(this);jmi12.setActionCommand("bg3");
		jmi13.addActionListener(this);jmi13.setActionCommand("bg4");
		jmi14.addActionListener(this);jmi14.setActionCommand("1");
		jmi15.addActionListener(this);jmi15.setActionCommand("2");
		jmi16.addActionListener(this);jmi16.setActionCommand("3");
		jmi17.addActionListener(this);jmi17.setActionCommand("4");
		jmi18.addActionListener(this);jmi18.setActionCommand("5");
		jmi19.addActionListener(this);jmi19.setActionCommand("close");
		
		//添加键盘事件
		this.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed (KeyEvent e){
				int key=e.getKeyCode();
				switch(key){
				case KeyEvent.VK_A:
					boom(1);break;
				case KeyEvent.VK_B:
					boom(2);break;
				case KeyEvent.VK_C:
					boom(3);break;	
				case KeyEvent.VK_D:
					boom(4);break;	
				case KeyEvent.VK_E:
					boom(5);break;
				case KeyEvent.VK_F:
					boom(6);break;
				case KeyEvent.VK_G:
					boom(7);break;
				case KeyEvent.VK_H:
					boom(8);break;
				case KeyEvent.VK_I:
					boom(9);break;
				case KeyEvent.VK_J:
					boom(10);break;
				case KeyEvent.VK_K:
					boom(11);break;
				case KeyEvent.VK_L:
					boom(12);break;
				case KeyEvent.VK_M:
					boom(13);break;
				case KeyEvent.VK_N:
					boom(14);break;
				case KeyEvent.VK_O:
					boom(15);break;
				case KeyEvent.VK_P:
					boom(16);break;
				case KeyEvent.VK_Q:
					boom(17);break;
				case KeyEvent.VK_R:
					boom(18);break;
				case KeyEvent.VK_S:
					boom(19);break;
				case KeyEvent.VK_T:
					boom(20);break;
				case KeyEvent.VK_U:
					boom(21);break;
				case KeyEvent.VK_V:
					boom(22);break;
				case KeyEvent.VK_W:
					boom(23);break;
				case KeyEvent.VK_X:
					boom(24);break;
				case KeyEvent.VK_Y:
					boom(25);break;
				case KeyEvent.VK_Z:
					boom(26);break;
				case KeyEvent.VK_ENTER:
					MyFrame.paintable=true;break;
				case KeyEvent.VK_SPACE:
					MyFrame.paintable=false;break;
				default:
					break;
				}
			}
		});
		
	
		MyPanel mp=new MyPanel();
		this.add(mp);
		this.setVisible(true);
		Thread t=new Thread(mp);
		t.start();
	}
	public static void main(String args[]){
		System.out.println("游戏开始");
		System.out.println("No Problem");
		new MyFrame();
	}
//事件处理
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("NewGame")){
			//System.out.println("123");
			MyFrame.life=5;
			MyFrame.level=0;
			MyFrame.score=0;
			/*for(int i=0;i<MyFrame.apList.size();i++){
				MyFrame.apList.get(i).islive=false;
			}*/
			for(Alphabet element:MyFrame.apList){
				element.islive=false;
			}
			MyFrame.apList.clear();
			Music.clear();
			MyFrame.paintable=true;
		}
		if(arg0.getActionCommand().equals("Exit")){
			System.exit(0);
		}
		if(arg0.getActionCommand().equals("Stop")){
			MyFrame.paintable=false;
		}
		if(arg0.getActionCommand().equals("Continue")){
			MyFrame.paintable=true;
		}
		if(arg0.getActionCommand().equals("Level0")){
			level=0;
		}
		if(arg0.getActionCommand().equals("Level2")){
			level=2;
		}
		if(arg0.getActionCommand().equals("Level5")){
			level=5;
		}
		if(arg0.getActionCommand().equals("Level8")){
			level=8;
		}
		if(arg0.getActionCommand().equals("Help")){
			JDialog jd=new JDialog();
			jd.setTitle("游戏提示");
			jd.setBounds(700, 300, 400, 200);
			jd.add(new JPanel(){
				public void paintComponent(Graphics g){
					g.setFont(new Font("Dialog", Font.BOLD, 30));
					g.drawString("请把输入法调成英文",10,40);
					g.drawString("空格键暂停",10,70);
					g.drawString("回车键继续",10,100);
				}
			});
			jd.setVisible(true);
		}
		if(arg0.getActionCommand().equals("bg1")){
			BG=0;
		}
		if(arg0.getActionCommand().equals("bg2")){
			BG=1;
		}
		if(arg0.getActionCommand().equals("bg3")){
			BG=2;
		}
		if(arg0.getActionCommand().equals("bg4")){
			BG=3;
		}
		if(arg0.getActionCommand().equals("1")){
			new Music(1);
			MyFrame.bgm=true;
		}
		if(arg0.getActionCommand().equals("2")){
			new Music(2);
			MyFrame.bgm=true;
		}
		if(arg0.getActionCommand().equals("3")){
			new Music(3);
			MyFrame.bgm=true;
		}
		if(arg0.getActionCommand().equals("4")){
			new Music(4);
			MyFrame.bgm=true;
		}
		if(arg0.getActionCommand().equals("5")){
			new Music(5);
			MyFrame.bgm=true;
		}
		if(arg0.getActionCommand().equals("close")){
			Music.clear();
			MyFrame.bgm=false;
		}
	}
	public void boom(int index){
		int i=0;
		/*for(;apList.get(i).imgIndex!=index||i<apList.size();i++){
			;	 
		}*/
		while(apList.get(i).imgIndex!=index){
			i++;
			if(i>=apList.size())
				break;
		}
		if(i<apList.size()){
			apList.get(i).islive=false;
			apList.remove(i);
			new Music();
			score++;
			if(score%50==0){
				level++;
				//new Music(level);
			}
		}
	}
}
