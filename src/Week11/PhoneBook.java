package Week11;

import java.io.FileNotFoundException;

public interface PhoneBook {     
	public void ReadInfo() throws FileNotFoundException;     
	public String FindNumber(String name);     
	public String FindName(String phonenumber);
}