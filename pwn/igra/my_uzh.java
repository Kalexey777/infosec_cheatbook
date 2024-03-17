import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

public class FirstJavaProgram {
  public static void main(String[] args){
	String str;
	HttpConnection httpConnection = (HttpConnection)Connector.open(str = "http://q.2024.ugractf.ru:9276/scores/?secret=362434");
	httpConnection.setRequestMethod("POST");
    	httpConnection.setRequestProperty("Content-Type", "application/octet-stream");
    	OutputStream outputStream;
    	(outputStream = httpConnection.openOutputStream()).write(this.a.toByteArray());
    	outputStream.close();
    	int i;
    	if ((i = httpConnection.getResponseCode()) != 200) {
       		//this.a = (Graphics)("Error " + i + ": " + httpConnection.getResponseMessage());
    	} else {
       		InputStream inputStream = httpConnection.openInputStream();
    		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    		byte[] arrayOfByte = new byte[128];
    		int j;
    		while ((j = inputStream.read(arrayOfByte)) != -1)
       			byteArrayOutputStream.write(arrayOfByte, 0, j); 
    		inputStream.close();
    		//this.a = (Graphics)byteArrayOutputStream.toString();
	}
    //System.out.println("This is my first program in java");
  }//End of main
}

