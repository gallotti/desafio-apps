package infoglobo.com.br.infoglobo.util;

import android.app.ProgressDialog;
import android.content.Context;

import infoglobo.com.br.infoglobo.R;

/**
 * Created by bruno on 05/04/2017.
 */

public class DefaultProgressDialog {

    public static ProgressDialog build(final Context context){
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setTitle(context.getString(R.string.app_name));
        dialog.setMessage(context.getString(R.string.wait));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setIndeterminate(true);
        return dialog;
    }
}
