package Singleton;

import Singleton.IDGenerator.IDGenerator;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-15 17:40:54
 */
public class test {
    public static void main(String[] args) {
        long id = 0;
        for(int i =0;i<10;i++){
            id = IDGenerator.getInstance().getId();
            System.out.println(id);
        }
    }
}
