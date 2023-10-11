import java.io.*;
import java.util.*;
class Config implements Serializable
{
HashMap<String, String> map = new HashMap<String, String>();
Config()
{
	 	 this.map.put("PATH","/Users/shreyashchatterjee/opt/anaconda3/condabin:/Library/Frameworks/Python.framework/Versions/2.7/bin:/opt/homebrew/bin:/opt/homebrew/sbin:/usr/local/bin:/System/Cryptexes/App/usr/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Library/Apple/usr/bin:/Applications/Wireshark.app/Contents/MacOS:/Users/shreyashchatterjee/.cargo/bin");
	 	 this.map.put("VERSION", "Mac OSX 16.3");
	 	 this.map.put("SYSNAME", "Shreyash's MacBook");
	 	 this.map.put("ENV", "__CFBundleIdentifier=com.apple.Terminal");
}
void displaymap()
{
	 	 for(Map.Entry<String, String> entry : map.entrySet())
	 	 {
	 	 	 System.out.println("\n\nKey = " + entry.getKey() + " \nValue = " +
entry.getValue());
	 	 }
}
void insert(String key, String val)
{
	 	 this.map.put(key, val);
}
void remove(String key)
{
	 	 this.map.remove(key);
}
}
class OOADJ
{
public static void main(String[] args)
{
	 	 File dir = new File("./");
	 	 File[] directoryListing = dir.listFiles();
	 	 File f = new File("./config.cfg");
	 	 if(f.exists())
	 	 {
	 	 	 try
	 	 	 {
	 	 	 	 ObjectInputStream in = new ObjectInputStream(new
FileInputStream("./config.cfg"));
	 	 	 	 Config conf = (Config)in.readObject();
	 	 	 	 in.close();
	 	 	 	 System.out.println("Before Update - ");
	 	 	 	 conf.displaymap();
	 	 	 	 conf.insert("MODEL", "M1 MacBook Air");
	 	 	 	 System.out.println("After Update - ");	 

	 	 	 	 conf.displaymap();
	 	 	 	 FileOutputStream fout = new FileOutputStream("./config.cfg");
	 	 	 	 ObjectOutputStream out = new ObjectOutputStream(fout);
	 	 	 	 out.writeObject(conf);
	 	 	 	 out.flush();
	 	 	 	 out.close();
	 	 	 }	 

	 	 	 catch(Exception e)
	 	 	 {
	 	 	 	 System.out.println(e);
	 	 	 }
	 	 }
	 	 else
	 	 {
	 	 	 try
	 	 	 {
	 	 	 	 Config conf = new Config();
	 	 	 	 conf.displaymap();
	 	 	 	 FileOutputStream fout = new FileOutputStream("./config.cfg");
	 	 	 	 ObjectOutputStream out = new ObjectOutputStream(fout);
	 	 	 	 out.writeObject(conf);
	 	 	 	 out.flush();
	 	 	 	 out.close();
	 	 	 }
	 	 	 catch(Exception e)
	 	 	 {
	 	 	 	 System.out.println(e);
	 	 	 }
	 	 }
}
}
