package infoglobo.com.br.infoglobo.communication;

import android.content.Context;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import infoglobo.com.br.infoglobo.model.Couver;
import infoglobo.com.br.infoglobo.parse.CouverParseJson;

/**
 * Created by bruno on 05/04/2017.
 */

public class RequestCouver extends Communication {


    public interface ResultCouver extends Result {
        void onSuccess(List<Couver> list);
    }

    protected ResultCouver handler;
    private boolean mShowAlertOnError;

    public RequestCouver(Context context) {
        super(context);
    }

    public void execute(ResultCouver handler) {
        this.handler = handler;
        execute(handler, true, true);
    }

    @Override
    protected HttpURLConnection getConnection() throws Exception {
        URL url = buildURL("https://raw.githubusercontent.com/Infoglobo/desafio-apps/master/capa.json");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        return connection;
    }

    @Override
    protected void onSuccess(String result, Result handler) {
        try {

            CouverParseJson c = new CouverParseJson();
            List<Couver> list = c.getCouver(result);
            this.handler.onSuccess(list);
        } catch (Exception e) {
            onFail(mShowAlertOnError);
        }
    }
}
