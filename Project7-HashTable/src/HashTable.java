


public class HashTable {

	private class HashEntry 
	{
	    String key;
	    HashEntry next;
	 
	    /* Constructor */
	    HashEntry(String key) 
	    {
	        this.key = key;
	        this.next = null;
	    }
	}
	
	private int TableSize = 0;
	private HashEntry[] table;
	int inspectedCount = 0;
	
	
	int getHash(String key)
	{
		// use hash code provided by string, then use mod operator to constrain to hash table size
		int hashVal = key.hashCode();
		hashVal = hashVal % TableSize;
		if (hashVal < 0)
			hashVal = hashVal + TableSize;
		return hashVal;
	}
	
	
	
	public HashTable(int size)
	{
		TableSize = size;
		table = new HashEntry[size];
		for(int i=0; i < size; i++)
		{
			table[i] = null;
		}
	}
	
	
	public void put(String key)
	{
		// compute the hash
		int hash = getHash(key);
		
		if (table[hash] == null) 
		{
			table[hash] = new HashEntry(key);
		}
		else 
		{
			HashEntry entry = table[hash];
			while (entry.next != null && !entry.key.equals(key))
			{
				entry = entry.next;
			}
			if (entry.key.equals(key))
			{
				entry.key = key;
			}
			else
			{
				entry.next = new HashEntry(key);
			}
		}
	}
	
	
	
	public String get(String key)
	{
		inspectedCount = 0;
		// compute hash
		int hash = getHash(key);
		
		// retrieve from hash table
		if (table[hash] == null)
		{
			System.out.println("Inspected " + inspectedCount + " elements");
			return null;
		}
		else
		{
			HashEntry entry = table[hash];
			while (entry != null && !entry.key.equals(key)) 
			{
				entry = entry.next;
				inspectedCount ++;
			}
			if (entry == null) 
			{
				System.out.println("Inspected " + inspectedCount + " elements");
				return null;
			}
			else 
			{
				inspectedCount ++;
				System.out.println("Inspected " + inspectedCount + " elements");
				return entry.key;
			}
			
		}
	
	
	}
	
	
	public void print() 
	{
		
		for(int i=0; i < TableSize; i++)
		{
			HashEntry entry = table[i];
			System.out.print("["+i+"] ");
			while (entry != null) 
			{
				System.out.print("["+ entry.key +"] ");
				entry = entry.next;
			}
			System.out.println("");
		}
	}
	
}
