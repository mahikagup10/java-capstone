import java.util.*;
import java.io.*;


class OOAJDlab6 implements Serializable{
    HashMap<String,String> map = new HashMap<String,String>();

    OOAJDlab6(){
        this.map.put("PATH","/Users/mahika/.nvm/versions/node/v16.14.2/bin:/Users/mahika/miniforge3/bin:/Users/mahika/miniforge3/condabin:/opt/homebrew/bin:/opt/homebrew/sbin:/opt/local/bin:/opt/local/sbin:/Library/Frameworks/Python.framework/Versions/3.9/bin:/opt/homebrew/bin:/opt/homebrew/sbin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:usr/local/mysql-8.0.30-macos12-arm64/bin:/usr/local/mysql-8.0.30-macos12-arm64/support-files:/Applications/VMware Fusion.app/Contents/Public:/Library/Apple/usr/bin:/Users/mahika/.local/bin");
        this.map.put("Version","13.1");
        this.map.put("SystemName","macOS Ventura");
    }

    void displayhashmap(){
        for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println("\n\nKey = " + entry.getKey() + " \nValue = " + entry.getValue());
        }
    }

    void insertKey(String key, String value){
        this.map.put(key,value);
    }

    void remove(String key){
        this.map.remove(key);
    }

}

class Main{
    public static void main(String args[]){
        File dir = new File("./");
        File dirList[] = dir.listFiles();
        File f = new File("./config.cfg");

        if(f.exists()){
            try{
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("./config.cfg"));
                OOAJDlab6 conf = (OOAJDlab6)in.readObject();
                in.close();
                System.out.println("Before adding Model: ");
                conf.displayhashmap();
                conf.insertKey("MODEL", "M1 MacBook Air");
                System.out.println("After adding Model: ");	 

                conf.displayhashmap();
                FileOutputStream fout = new FileOutputStream("./config.cfg");
                ObjectOutputStream out = new ObjectOutputStream(fout);
                out.writeObject(conf);
                out.flush();
                out.close();
            }

            catch(Exception e){
                System.out.println(e);
            }
        }

        else{
            try
	 	 	 {
	 	 	 	 OOAJDlab6 conf = new OOAJDlab6();
	 	 	 	 conf.displayhashmap();
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