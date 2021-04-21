import java.net.*;
import java.io.*;

public class Dict{
    public static void main(final String... args){
        try(final Socket socket = new Socket("dict.org", 2628)){
            socket.setSoTimeout(15000);
            final OutputStream out = socket.getOutputStream();
            final Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer.write("DEFINE eng-lat gold\r\n");
            writer.flush();
            socket.shutdownOutput();

            final BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), "UTF-8"));
            
            for(String line = reader.readLine();
                line != null && !line.equals(".");
                line = reader.readLine()){
                System.out.format(" > %s.%n", line);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
