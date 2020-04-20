package keyboardGame;

import java.awt.Image;
import java.util.Random;



public class Alphabet implements Runnable{
	public int x;
	public int y;
	public int imgIndex;
	public boolean islive;
	public Image img;
	public final static Random rand=new Random();
	public static void build(){         //负责创建对象
		if(MyFrame.paintable){
			Alphabet ap=new Alphabet(rand.nextInt(MyFrame.MyFrame_Width-120),0);
			MyFrame.apList.add(ap);
			Thread t=new Thread(ap);
			t.start();
		}
	}
	public Alphabet(int x,int y){
		this.x=x;
		this.y=y;
		this.islive=true;
		this.imgIndex=rand.nextInt(26)+1;
		img=images.alphabet[this.imgIndex-1];
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
				this.y+=MyFrame.level+MyFrame.MyFrame_Length*0.005;
				if(this.islive==false){
					break;
				}
				if(this.y>MyFrame.MyFrame_Length){
					this.islive=false;
					MyFrame.apList.remove(this);
					MyFrame.life--;
					break;
				}
			}
			
		}
	}
}
