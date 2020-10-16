import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

public class FileHandle {
	
	Vector<Integer> count = new Vector<Integer>();
	Vector<Double> prob = new Vector<Double>();
	
	FileHandle(){
		for(int i=0;i<128;i++) {
			count.add(i, 0);
			prob.add(i, (double) 0);
		}
	}
	
	void readFile() throws IOException {
		File f=new File("text.txt");     //Creation of File Descriptor for input file
		FileReader fr=new FileReader(f);   //Creation of File Reader object
		BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object
		int c = 0;
		double cnt = 0;
		while((c = br.read()) != -1)         //Read char by Char
		{
			cnt++;
			char character = (char) c;          //converting integer to char
			count.set(character,count.get(character)+1);
			//System.out.print(character);        //Display the Character
        }
		br.close();
		fr.close();
		for(int i=32;i<127;i++) {
			System.out.println((char)i+": "+count.get(i));
		}
		
		System.out.println(cnt+", "+count.stream().mapToLong(Integer::longValue).sum());
		
		for(int i=32;i<127;i++) {
			prob.set(i, count.get(i)/cnt);
			System.out.println((char)i+": "+String.format("%.5f", prob.get(i)));
		}
	}
	
}
