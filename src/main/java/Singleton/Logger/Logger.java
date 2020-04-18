package Singleton.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-15 17:46:41
 */
public class Logger {
    private FileWriter fileWriter;
    private static Logger instance = new Logger();

    private Logger(){
        File file = new File("log.txt");
        try {
            fileWriter = new FileWriter(file,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        return instance;
    }

    public void log(String log){
        try {
            fileWriter.write(log);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
