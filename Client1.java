import java.lang.*;
import java.net.*;
import java.io.*;

class Client1
{
    public static void main(String arg[])
    {
        System.out.println("Client application is running...");
        String s1 = null, s2 = null;
        Socket s = null;
        BufferedReader br = null, brK = null;
        PrintStream ps = null;

        try
        {
            s = new Socket("localhost",1100);


            brK = new BufferedReader(new InputStreamReader(System.in));
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            ps = new PrintStream(s.getOutputStream());
            while(!(s1 = brK.readLine()).equals("gn"))
            {
                    ps.println(s1);
                    s2 = br.readLine();
                    System.out.println("Server says : "+s2);
                    System.out.println("Enter message for server : ");
            }
        }
        catch(Exception obj)
        {}

        try
        {
            s.close();
            br.close();
            brK.close();
            ps.close();
          }
          catch(Exception obj)
          {}
    }
}