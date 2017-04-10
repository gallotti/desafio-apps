package infoglobo.com.br.infoglobo.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Created by bruno on 10/04/2017.
 */

public class UtilTest {


    @Test
    public void testeParseListToStringNull(){
        List<String> list = new ArrayList<String>();
        String result = Util.parseListToString(list);
        assertTrue(result.equals(""));

    }

    @Test
    public void testeParseListToStringEmpty(){
        List<String> list = new ArrayList<String>();
        String result = Util.parseListToString(list);
        assertTrue(result.equals(""));

    }

    @Test
    public void testeParseListToString(){
        List<String> list = new ArrayList<String>();
        list.add("Bruno");
        list.add("Globo");
        list.add("Luana");
        String result = Util.parseListToString(list);
        System.out.println(result);
        assertTrue(result.equalsIgnoreCase("Bruno-Globo-Luana"));

    }

}
