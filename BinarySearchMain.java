import processing.core.PApplet;

import java.util.Stack;

public class BinarySearchMain extends PApplet {
	BinarySearchTree bst;
	public static void main(String[] args) {

		PApplet.main("BinarySearchMain");


	}
	public void settings(){
		bst = new BinarySearchTree(new Node(100,null,null));
		bst.insert(50);
		bst.insert(30);
		bst.insert(40);
		bst.insert(120);
		bst.insert(243);
		bst.insert(200);
		bst.insert(110);
		bst.insert(20);
//		bst.inOrderTraversal();
//		System.out.println("MINIMUM: " + bst.min());
//		System.out.println("MINIMUM: " + bst.max());
//		System.out.println("NODE 240: " + bst.search(240));
//		System.out.println("NODE 243: " + bst.search(243));




		size(800,800);
	}
	public void draw(){
		int factor = 40;
		noLoop();
		Stack<Node> stack = new Stack();
		stack.add(bst.getRoot());
		Stack<location> stack2 = new Stack();
		stack2.add(new location(400,100,0));
		while (!stack.empty()){
			Node node = stack.pop();
			location location = stack2.pop();
			int key = node.getKey();
			ellipse(location.x,location.y,40,40);
			fill(0);
			text(key,location.x,location.y);
			fill(255);
			if (node.getLeftChild() != null){
				line(location.x-20,location.y+20,location.x-(120-location.depth*factor),location.y+(80+location.depth*factor));
				stack.add(node.getLeftChild());
				stack2.add(new location(location.x-(120-location.depth*factor),location.y+(80+location.depth*factor),location.depth+1));
			}
			if (node.getRightChild() != null){
				line(location.x+20,location.y+20,location.x+(120-location.depth*factor),location.y+(80+location.depth*factor));
				stack.add(node.getRightChild());
				stack2.add(new location(location.x+(120-location.depth*factor),location.y+(80+location.depth*factor),location.depth+1));
			}

		}




	}

}
class location{
	public int x,y,depth;
	public location(int x, int y, int depth){
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}
