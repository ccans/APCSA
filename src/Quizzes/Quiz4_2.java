package Quizzes;

public class Quiz4_2 {
	
	private int length, width;
	
	public void Main() {
		length = 0;
		width = 0;
	}
	
	public void makeRectangle(int x, int y) {
		width = x;
		length = y;
	}
	
	public int findArea() {
		return width*length;
	}
	
	public int findPerimeter() {
		return (width + length)*2;
	}
	
	public boolean isSquare() {
		if(length == width) return true;
		return false;
	}
	
	public static void main(String args[]) {
		Quiz4_2 rectangle = new Quiz4_2();
		System.out.println(rectangle.findArea());
		
		rectangle.makeRectangle(5, 6);
		System.out.println(rectangle.findPerimeter());
		System.out.println(rectangle.isSquare());
	}
	
}
