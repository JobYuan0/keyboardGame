package keyboardGame2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class MyPanel extends JPanel implements Runnable{
	public static int isAddAp=0;
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//控制是否创建新字母，每十七次创建一个
		isAddAp++;			
    	if(isAddAp>=17-MyFrame.level){
    		Alphabet.build();
    		isAddAp=0;
    	}
    	
		//设置画笔的属性
		g.setFont(new Font("TimesRoman", Font.BOLD, 35));
		g.setColor(Color.BLUE);
		//画出背景图
		g.drawImage(images.background[MyFrame.BG],0,0,MyFrame.MyFrame_Width,MyFrame.MyFrame_Length,null);
		g.drawString("分数："+MyFrame.score, (int) (MyFrame.MyFrame_Width*0.2), (int) (MyFrame.MyFrame_Length*0.04)); 
        g.drawString("等级："+MyFrame.level, (int) (MyFrame.MyFrame_Width*0.4), (int) (MyFrame.MyFrame_Length*0.04) ); 
        g.drawString("生命值："+MyFrame.life, (int) (MyFrame.MyFrame_Width*0.6), (int) (MyFrame.MyFrame_Length*0.04) );
        //画出当前的字母图
        for(int i=0;i<MyFrame.apList.size();i++){
    		g.drawImage(MyFrame.apList.get(i).img, MyFrame.apList.get(i).x, MyFrame.apList.get(i).y,120, 90, null);
    	}
        //判定是否死亡
    	if(MyFrame.life<=0){
    		for(Alphabet element:MyFrame.apList){
				element.islive=false;
			}
    		MyFrame.apList.clear();
    		MyFrame.paintable=false;
    		System.out.println("游戏结束");
    		System.out.println("你的分数为：  "+MyFrame.score);
    		g.setFont(new Font("TimesRoman", Font.BOLD, 135));
    		g.drawImage(images.background[MyFrame.BG],0,0,MyFrame.MyFrame_Width,MyFrame.MyFrame_Length,null);
    		g.drawImage(images.alphabet[26], (int)(MyFrame.MyFrame_Width*0.25),(int)(MyFrame.MyFrame_Length*0.1),
    				(int)(MyFrame.MyFrame_Width*0.5), (int)(MyFrame.MyFrame_Length*0.5), null);
    		g.drawString("你的分数为:"+MyFrame.score, (int)(MyFrame.MyFrame_Width*0.25), (int)(MyFrame.MyFrame_Length*0.1)+
    				(int)(MyFrame.MyFrame_Length*0.5)+80);
    	}
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(MyFrame.paintable){
				repaint();
			}
		}
	}
	
}
