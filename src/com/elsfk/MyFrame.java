package com.elsfk;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.naming.ldap.LdapName;
import javax.swing.*;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.elsfk.Node;

public class MyFrame extends JFrame implements KeyListener {
	Fangkuai fangkuai=new Fangkuai();
	Fangkuai fangkuai2;
	JPanel jpanel;
	Timer timer;
	String goal="分数";
	public long[] x = new long[10000000];
	public long[] y = new long[10000000];
	LinkedList<Node> cunzai = new LinkedList<Node>();
	long[] panduan = new long[1000000];
	
	
	
	public MyFrame() throws HeadlessException{
		initMyFrame();
		initGamePanel();
		initFangkuai();
		initTimer();
		setKeyListener();
		
	}

	private void initTimer() {
		// TODO Auto-generated method stub
		timer = new Timer();
		TimerTask timertask= new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				//fangkuai.move();
				
				if(fangkuai.move()) {
					
					initFangkuai();
					
					                       
				}else  {
					
					
				}
				for(int i=0;i<fangkuai.getFangkuai().size();i++) {
					y[i]=fangkuai.getFangkuai().get(i).getY();
//					System.out.println(y[i]);
//					x[i]=cunzai.get(i).getX();
//					y[i]=cunzai.get(i).getY();
//					System.out.println(y[i]);
				}
				
				
				jpanel.repaint();
			}
			
		};
		timer.scheduleAtFixedRate(timertask, 0, 300);
	}

	private void setKeyListener() {
		// TODO Auto-generated method stub
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				switch(e.getKeyCode()) {
				case 65:
					fangkuai.setDirection(Direction.LEFT);
					break;
				case 68:
					fangkuai.setDirection(Direction.RIGHT);
					break;
				}
			}
			
		});
	}

	private void initFangkuai() {
		// TODO Auto-generated method stub
		for(int i=0;i<cunzai.size();i++) {
			
			panduan[i]= cunzai.get(i).getY();
			
			System.out.println(panduan[i]);
		
		}
		fangkuai2=fangkuai;
		
		fangkuai =new Fangkuai();
		
	}

	private void initGamePanel() {
		// TODO Auto-generated method stub
		jpanel = new JPanel() {
			public void paint(Graphics g) {
				g.clearRect(0, 0, 600, 640);
				//绘制40条竖线
				for(int i= 0 ; i<41;i++) {
					g.drawLine(0, i*15, 600, i*15);
				}
				//绘制40条横线
				for(int i= 0 ; i<41;i++) {
					g.drawLine(i*15, 0, i*15, 600);
				}
				g.drawString(goal, 680, 50);
				
				for(int i=0;i<fangkuai.getFangkuai().size();i++) {
					
					g.fillRect(fangkuai.getFangkuai().get(i).getX()*15,fangkuai.getFangkuai().get(i).getY()*15,15,15);
					
				}
				if(!fangkuai2.getCunzai().isEmpty()) {
					
				cunzai.addAll(fangkuai2.getCunzai());
				
			
				
				}
				if(duidie()) {
					cunzai.addAll(fangkuai2.getCunzai());
				}
				
				if(!fangkuai2.getCunzai().isEmpty())
				for(int i=0;i<cunzai.size();i++) {
					
					g.fillRect(cunzai.get(i).getX()*15,cunzai.get(i).getY()*15,15,15);
					
				}
				
				
			}
		};
		add(jpanel);
	}

	public boolean duidie() {
		
		
		
		for(int i = 0;i>panduan.length;i++) {
			if(y[i]>panduan[i]+1) {
				return true;
			}else {
				
			}
		}
		return false;
		
	}
	private void initMyFrame() {
		// TODO Auto-generated method stub
		setSize(800, 640);
		setResizable(false);
		setLocation(1000,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new  MyFrame().setVisible(true);
		}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

