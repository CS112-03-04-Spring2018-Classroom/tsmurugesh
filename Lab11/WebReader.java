import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
public class WebReader{
	public static void main(String[] args) throws IOException{
		System.out.print("Enter url to read: ");
		Scanner sc = new Scanner(System.in);
		URL u = new URL(sc.next());
		URLConnection connect = u.openConnection();
		InputStream instream = connect.getInputStream();
		InputStreamReader isr = new InputStreamReader(instream);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null){
			System.out.println(line);
		}

	}
}