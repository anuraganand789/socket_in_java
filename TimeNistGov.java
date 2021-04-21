import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;


public class TimeNistGov{
    public static void main(final String... args){
        try(final Socket socket = new Socket("time.nist.gov", 13)){
            socket.setSoTimeout(15000);

            final InputStreamReader 
            reader = new InputStreamReader(socket.getInputStream(), 
                                           "ASCII");

            final StringBuilder timeString = new StringBuilder();
            for(int ch = reader.read(); ch != -1; ch = reader.read()){
                System.out.print((char) ch);
                //timeString.append((char) ch);
            }

            System.out.println();
            //System.out.println(timeString.toString());

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
