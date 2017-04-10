package infoglobo.com.br.infoglobo.parse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import infoglobo.com.br.infoglobo.model.Couver;

/**
 * Created by bruno on 06/04/2017.
 */

public class CouverParseJson {

    public List<Couver> getCouver(String result) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Couver> listCouver = null;
        try {
            TypeReference<List<Couver>> mapType = new TypeReference<List<Couver>>() {
            };
            listCouver = objectMapper.readValue(result, mapType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listCouver;
    }

}
