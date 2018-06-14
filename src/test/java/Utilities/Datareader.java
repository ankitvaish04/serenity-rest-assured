package Utilities;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by ankit.vaish on 19-02-2018.
 */
public class Datareader {

    public static String readJson(String jsonPath)
    {
        BufferedReader bfd=null;
        JSONObject js=null;
        String s=null;
        try {
            bfd=new BufferedReader(new FileReader(new File(jsonPath)));
            s=bfd.readLine();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  s;
    }
}
