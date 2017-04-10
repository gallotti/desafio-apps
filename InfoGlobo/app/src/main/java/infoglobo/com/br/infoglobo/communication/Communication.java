package infoglobo.com.br.infoglobo.communication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import infoglobo.com.br.infoglobo.R;
import infoglobo.com.br.infoglobo.util.DefaultProgressDialog;

/**
 * Created by bruno on 05/04/2017.
 */

public abstract class Communication {

    public interface Result {
        void onSuccess(String result);

        void onFail();

    }

    protected Context context;
    private Result handler;
    private ProgressDialog progressDialog;
    private AsyncTask<Void, Void, String> task;


    protected abstract HttpURLConnection getConnection() throws Exception;

    protected abstract void onSuccess(String result, Result handler);

    public Communication(Context context) {
        this.context = context;
    }

    public void execute(Result handler) {
        execute(handler, true, true);
    }

    public void execute(Result handler, final boolean showProgressBar, final boolean showAlertOnError) {
        this.handler = handler;

        task = new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                if (showProgressBar) {
                    if (progressDialog != null) {
                        progressDialog.dismiss();
                    }
                    progressDialog = DefaultProgressDialog.build(context);

                    progressDialog.show();
                }
            }

            @Override
            protected String doInBackground(Void... params) {
                String result = null;

                try {
                    result = doJob();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }

                if (result == null) {
                    onFail(showAlertOnError);
                } else {
                    Communication.this.onSuccess(result, Communication.this.handler);
                }
                super.onPostExecute(result);
            }
        };
        AsyncTaskCompat.executeParallel(task);
    }

    protected String doJob() throws Exception {

        HttpURLConnection connection = getConnection();
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setUseCaches(false);
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int code = connection.getResponseCode();

        if (code == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String aux = "";

            while ((aux = reader.readLine()) != null) {
                builder.append(aux);
            }
            String content = builder.toString();
            reader.close();
            connection.disconnect();
            return content;
        } else {
            connection.disconnect();
        }
        return null;
    }

    protected void onFail(boolean showAlertOnError) {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }

        if (showAlertOnError == true) {
            final AlertDialog d = new AlertDialog.Builder(context)
                    .setTitle(R.string.att)
                    .setMessage(context.getString(R.string.error_connect))
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            if (Communication.this.handler != null) {
                                Communication.this.handler.onFail();
                            }
                        }
                    }).create();
            d.show();
        } else {
            if (handler != null) {
                handler.onFail();
            }
        }
    }


    protected URL buildURL(String url) throws MalformedURLException {
        URL obj = new URL(url);
        return obj;
    }

}
