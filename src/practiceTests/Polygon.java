package practiceTests;
public class Polygon
{
private int[] testArray = {3, 4, 5};
/** @param n an int to be incremented by 1 */
public void increment (int n)
{ n++; }
public void firstTestMethod()
{
for (int i = 0; i < testArray.length; i++)
{
increment(testArray[i]);
System.out.print(testArray[i] + " ");
}
}
public void secondTestMethod()
{
for (int element : testArray)
{
increment(element);
System.out.print(element + " ");
}
}

public void thirdTestMethod(Polygon input) {
	input.testArray[0] = 1;
}

@SuppressWarnings("null")
public static void main(String args[]) {
	String a = null;
	String b = "hi";
	if(a.equals(b)) System.out.println("a");
	System.out.println("h");
}
}
