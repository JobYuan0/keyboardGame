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
		//�����Ƿ񴴽�����ĸ��ÿʮ�ߴδ���һ��
		isAddAp++;			
    	if(isAddAp>=17-MyFrame.level){
    		Alphabet.build();
    		isAddAp=0;
    	}
    	
		//���û��ʵ�����
		g.setFont(new Font("TimesRoman", Font.BOLD, 35));
		g.setColor(Color.BLUE);
		//��������ͼ
		g.drawImage(images.background[MyFrame.BG],0,0,MyFrame.MyFrame_Width,MyFrame.MyFrame_Length,null);
		g.drawString("������"+MyFrame.score, (int) (MyFrame.MyFrame_Width*0.2), (int) (MyFrame.MyFrame_Length*0.04)); 
        g.drawString("�ȼ���"+MyFrame.level, (int) (MyFrame.MyFrame_Width*0.4), (int) (MyFrame.MyFrame_Length*0.04) ); 
        g.drawString("����ֵ��"+MyFrame.life, (int) (MyFrame.MyFrame_Width*0.6), (int) (MyFrame.MyFrame_Length*0.04) );
        //������ǰ����ĸͼ
        for(int i=0;i<MyFrame.apList.size();i++){
    		g.drawImage(MyFrame.apList.get(i).img, MyFrame.apList.get(i).x, MyFrame.apList.get(i).y,120, 90, null);
    	}
        //�ж��Ƿ�����
    	if(MyFrame.life<=0){
    		for(Alphabet element:MyFrame.apList){
				element.islive=false;
			}
    		MyFrame.apList.clear();
    		MyFrame.paintable=false;
    		System.out.println("��Ϸ����");
    		System.out.println("��ķ���Ϊ��  "+MyFrame.score);
    		g.setFont(new Font("TimesRoman", Font.BOLD, 135));
    		g.drawImage(images.background[MyFrame.BG],0,0,MyFrame.MyFrame_Width,MyFrame.MyFrame_Length,null);
    		g.drawImage(images.alphabet[26], (int)(MyFrame.MyFrame_Width*0.25),(int)(MyFrame.MyFrame_Length*0.1),
    				(int)(MyFrame.MyFrame_Width*0.5), (int)(MyFrame.MyFrame_Length*0.5), null);
    		g.drawString("��ķ���Ϊ:"+MyFrame.score, (int)(MyFrame.MyFrame_Width*0.25), (int)(MyFrame.MyFrame_Length*0.1)+
    				(int)(MyFrame.MyFrame_Length*0.5)+80);
    	}
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			if(MyFrame.paintable){
				repaint();
			}
		}
	}
	
}
