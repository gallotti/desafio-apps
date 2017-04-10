package infoglobo.com.br.infoglobo.util;

import java.util.List;

/**
 * Created by bruno on 07/04/2017.
 */

public class Util {

    /*
       Metodo Responsavel por fazer o parse de um List<String> para String separado por -
     */
    public static String parseListToString(List<String> list) {

        if (list == null || list.isEmpty())
            return "";

        String result = "";
        for (String string : list){
            if (list.size() == 0)
                return string;
            result = result + string + "-";
        }

        return result.substring(0,result.length()-1);
    }



}
