package Quizzes;

public class quizTest {

	public static void main(String[] args) {
		start();
	}

	public static void changeit(int[] list, int num) {
		list = new int[5];
		num = 0;
		for(int x = 0; x < list.length; x++) {
			list[x] = 0;
		}
	}
	
	public static void start() {
		int[] nums = {1,2,3,4,5};
		int value = 6;
		changeit(nums, value);
		for(int k = 0; k < nums.length; k++) {
			System.out.println(nums[k] + " ");
		}
		System.out.println(value);
	}
	
	
}
