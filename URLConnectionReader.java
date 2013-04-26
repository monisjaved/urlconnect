import java.net.*;
import java.io.*;

public class URLConnectionReader 
{
    public static void main(String[] args) throws Exception 
	{
        URL oracle = new URL("http://localhost:8080");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
		try
		{
			FileWriter fstream = new FileWriter("output.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			String inputLine;
			while ((inputLine = in.readLine()) != null) 
			{
				//System.out.println(inputLine);
				out.write(inputLine);
				out.newLine();
			}
			in.close();
			out.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
    }
}