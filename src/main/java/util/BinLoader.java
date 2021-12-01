package util;

import contracts.Holding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class BinLoader {
    private BinLoader(){

    }

    public static String loadBinary(String path) {
        String bin = "";
        File file = new File(Holding.class.getClassLoader().getResource(path).getPath());
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String tmp;
            while ((tmp = br.readLine()) != null) {
                bin += tmp;
            }
        } catch (IOException e){
            //do nothing
        }
        return bin;
    }
}
