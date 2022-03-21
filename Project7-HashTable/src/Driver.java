import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		
		HashTable table = LoadData();
		
		// Perform search for user input
		String input = "";
		Scanner sc = new Scanner(System.in);
		while(!input.equals("-1"))
		{
			System.out.print("Enter string, enter -1 to quit: ");
			input = sc.nextLine();
			if (input.equals("-1"))
				break;
			
			// TODO: Search hash table for string, print out result and number of elements visited
			String result = table.get(input);
			if (result != null) {
				System.out.println("'" + result + "' located");
			}
			else {
				System.out.println("'" + input + "' not in hash table");
			}
			System.out.println("");
		}
		
		
		System.out.println("End of program");
	}
	
	
	
	public static HashTable LoadData()
	{
		HashTable table = new HashTable(5);
		
		List<String> strings = ReadFile("Data.in");
		
		System.out.println("Reading Test Data...");
		
		for (String value : strings) {
			// Insert item into Hash Table
			table.put(value);
			System.out.print(value + " ");
		}
		System.out.println("");
		table.print();
	    System.out.println("");
	    System.out.println("END: Reading Test Data");
	    System.out.println("");
	    
		return table;
	}
	
	//------------------------------------------------------------------------------------------------------------
	//   Helper method for reading the files
	//------------------------------------------------------------------------------------------------------------
	public static List<String> ReadFile(String filename)
	{
		List<String> strings = new ArrayList<String>();
		
		// assume a file with a list of words (multiple per line, multiple lines)
		try {
			Scanner fin = new Scanner(new File(filename));
			
			while(fin.hasNext()) {
				String item = fin.next();
				strings.add(item);
			}
			
			fin.close();
			
		} catch (Exception e) {
			System.out.println("Error trying to read input file");
			e.printStackTrace();
		}

		return strings;
	}

}
