package infoglobo.com.br.infoglobo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.callback.BitmapAjaxCallback;

import java.util.List;

import infoglobo.com.br.infoglobo.R;
import infoglobo.com.br.infoglobo.model.Content;
import infoglobo.com.br.infoglobo.model.Imagem;

/**
 * Created by bruno on 07/04/2017.
 */

public class ContentAdapter extends BaseAdapter {


    private Context context;
    private List<Content> contents;

    public ContentAdapter(Context context, List<Content> contents) {

        this.context = context;
        this.contents = contents;
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public Object getItem(int i) {
        return contents.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_content, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        Content content = (Content) getItem(position);

        if (content.getImagens().size() > 0) {
            Imagem imagem = content.getImagens().get(0);
            AQuery aq = new AQuery(context);

            aq.id(holder.imgContent).progress(context).image(imagem.getUrl(), true, true, 0, 0, new BitmapAjaxCallback() {
                @Override
                public void callback(String url, ImageView iv, Bitmap bm, AjaxStatus status) {
                    iv.setImageBitmap(bm);
                }
            });
        }
        holder.txtTitle.setText(content.getTitulo());
        holder.txtEdit.setText(content.getSecao().getNome());

        return view;
    }

    public class ViewHolder {

        final ImageView imgContent;
        final TextView txtEdit;
        final TextView txtTitle;

        public ViewHolder(View view) {
            imgContent = (ImageView) view.findViewById(R.id.img_content);
            txtEdit = (TextView) view.findViewById(R.id.item_txt_edit);
            txtTitle = (TextView) view.findViewById(R.id.item_txt_title);
        }

    }
}
