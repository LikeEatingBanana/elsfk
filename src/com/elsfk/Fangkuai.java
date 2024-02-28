package com.elsfk;

import java.util.LinkedList;

public class Fangkuai {
	LinkedList<Node> fangkuai;
	Direction direction=Direction.DOWN;
	LinkedList<Node> cunzai=new LinkedList<Node>();
	
	
	public Fangkuai() {
		
		initFangkuai();
	}

	private void initFangkuai() {
		// TODO Auto-generated method stub
		fangkuai = new LinkedList<Node>();
		fangkuai.add(new Node(15,15));
		fangkuai.add(new Node(16,15));
		fangkuai.add(new Node(15,16));
		fangkuai.add(new Node(16,16));
		cunzai.add(new Node(0,0));
		cunzai.add(new Node(0,0));
		cunzai.add(new Node(0,0));
		cunzai.add(new Node(0,0));
		
	}
	

	public boolean move() {
		boolean luodi=false;
		
		if(fangkuai.get(3).getY()<39){
		fangkuai.set(0,new Node(fangkuai.get(0).getX(),fangkuai.get(0).getY()+1));
//		System.out.println(fangkuai.get(0).getX());
//		System.out.println(fangkuai.get(0).getY()+1);
		fangkuai.set(1,new Node(fangkuai.get(1).getX(),fangkuai.get(1).getY()+1));
//		System.out.println(fangkuai.get(1).getX());
//		System.out.println(fangkuai.get(1).getY()+1);
		fangkuai.set(2,new Node(fangkuai.get(2).getX(),fangkuai.get(2).getY()+1));
//		System.out.println(fangkuai.get(2).getX());
//		System.out.println(fangkuai.get(2).getY()+1);
		fangkuai.set(3,new Node(fangkuai.get(3).getX(),fangkuai.get(3).getY()+1));
//		System.out.println(fangkuai.get(3).getX());
//		System.out.println(fangkuai.get(3).getY()+1);
		
		luodi=false;
		}
		if(fangkuai.get(3).getY()==39){
			cunzai.addFirst(fangkuai.get(0));
			cunzai.addFirst(fangkuai.get(1));
			cunzai.addFirst(fangkuai.get(2));
			cunzai.addFirst(fangkuai.get(3));
			luodi=true;
			
		}
		
		switch (direction) {
		case LEFT:
			if(fangkuai.get(0).getX()>0) {
				fangkuai.set(0,new Node(fangkuai.get(0).getX()-1,fangkuai.get(0).getY()));
				fangkuai.set(1,new Node(fangkuai.get(1).getX()-1,fangkuai.get(1).getY()));
				fangkuai.set(2,new Node(fangkuai.get(2).getX()-1,fangkuai.get(2).getY()));
				fangkuai.set(3,new Node(fangkuai.get(3).getX()-1,fangkuai.get(3).getY()));
				direction=Direction.DOWN;
			}
			
			break;
			case RIGHT:
				if(fangkuai.get(0).getX()<38) {
					fangkuai.set(0,new Node(fangkuai.get(0).getX()+1,fangkuai.get(0).getY()));
					fangkuai.set(1,new Node(fangkuai.get(1).getX()+1,fangkuai.get(1).getY()));
					fangkuai.set(2,new Node(fangkuai.get(2).getX()+1,fangkuai.get(2).getY()));
					fangkuai.set(3,new Node(fangkuai.get(3).getX()+1,fangkuai.get(3).getY()));
					direction=Direction.DOWN;
				}

		default:
			break;
		}
		return luodi;
	}

	public LinkedList<Node> getFangkuai() {
		return fangkuai;
	}

	public void setFangkuai(LinkedList<Node> fangkuai) {
		this.fangkuai = fangkuai;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public LinkedList<Node> getCunzai() {
		return cunzai;
	}

	public void setCunzai(LinkedList<Node> cunzai) {
		this.cunzai = cunzai;
	}


}
