package org.fj.test;

public  class Test {
	
	public static void main(String[] args) {
		Link l = new Link();
		l.addNode("A");
		l.addNode("B");
		l.addNode("C");
		l.printNode();
		System.out.println("");
		System.out.println("========");
		l.deleteNode("B");
		l.printNode();
	}
}

class Link{
	
	class Node{
		private String data;
		private Node next;
		public Node(String data){
			this.data = data;
		}
		public void add(Node newNode){
			if(this.next == null){
				this.next = newNode;
			}else{
				this.next.add(newNode);
			}
				
		}
		public void print(){
			System.out.print(this.data + "\t");
			if(this.next != null){
				this.next.print();
			}
		}
		public boolean search(String data){
			if(data.equals(this.data)){
				return true;
			}else{
				if(this.next != null){
					return this.next.search(data);
				}else{
					return false;
				}
			}
		}
		public void delete(Node previous,String data){
			if(data.equals(this.data)){
				previous.next = this.next;
			}else{
				if(this.next != null){
					this.next.delete(this, data);
				}
			}
		}
	}
	private Node root;
	public void addNode(String date){
		Node node = new Node(date);
		if(root != null){
			this.root.add(node);
		}else{
			this.root = node;
		}
	}
	public void printNode(){
		if(root != null)
			this.root.print();
	}
	public boolean contains(String data){
		return this.root.search(data);
	}
	public void deleteNode(String data){
		if(this.contains(data)){
			if(this.root.data.equals(data)){
				this.root = this.root.next;
			}else{
				this.root.next.delete(root, data);
			}
		}
	}
}