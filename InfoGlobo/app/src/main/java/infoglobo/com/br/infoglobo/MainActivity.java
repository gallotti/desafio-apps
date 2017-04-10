package infoglobo.com.br.infoglobo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.callback.BitmapAjaxCallback;

import java.util.List;

import infoglobo.com.br.infoglobo.adapter.ContentAdapter;
import infoglobo.com.br.infoglobo.communication.RequestCouver;
import infoglobo.com.br.infoglobo.communication.RequestCouver.ResultCouver;
import infoglobo.com.br.infoglobo.model.Content;
import infoglobo.com.br.infoglobo.model.Couver;
import infoglobo.com.br.infoglobo.model.Imagem;
import infoglobo.com.br.infoglobo.model.Secao;

public class MainActivity extends AppCompatActivity {

    private Couver couver;
    private Content content;
    private ImageView imgCapa;
    private TextView txtTitle;
    private TextView txtEdit;
    private ListView listContent;
    private ViewHeader mViewHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCapa = (ImageView) findViewById(R.id.img_capa);
        txtEdit = (TextView) findViewById(R.id.txt_editoria);
        txtTitle = (TextView) findViewById(R.id.txt_titulo);
        listContent = (ListView) findViewById(R.id.list_content);

        listContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                intent.putExtra("content", couver.getConteudos().get(i - 1));
                startActivity(intent);
            }
        });

        loadCouver();

    }

    private void builActionBar(){

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar);
        TextView title=(TextView)findViewById(getResources().getIdentifier("action_bar_title", "id", getPackageName()));
        title.setText(couver.getProduto());

    }


    private void loadCouver() {
        RequestCouver request = new RequestCouver(this);
        request.execute(new ResultCouver() {

            @Override
            public void onSuccess(List<Couver> list) {
                couver = list.get(0);
                content = couver.getConteudos().get(0);
                loadValuesInterface();
                builActionBar();
            }

            @Override
            public void onSuccess(String result) {

            }


            @Override
            public void onFail() {

            }

        });

    }
    /*
        carregar os valores interface
     */
    private void loadValuesInterface() {

        Imagem imagem = content.getImagens().get(0);
        Secao secao = content.getSecao();

        if (mViewHeader == null) {
            ViewGroup header = (ViewGroup) getLayoutInflater().inflate(R.layout.header, listContent, false);
            mViewHeader = new ViewHeader(header);
            listContent.addHeaderView(header);
        }

        loadImage(imagem);

        mViewHeader.txtTitle.setText(content.getTitulo());
        mViewHeader.txtEdit.setText(secao.getNome().toUpperCase());

        ContentAdapter adapter = new ContentAdapter(this, couver.getConteudos());

        listContent.setAdapter(adapter);

    }

    /*
        Carregar a imagem da capa do aplicativo utilizando o AQuery
     */
    private void loadImage(Imagem imagem) {
        AQuery aq = new AQuery(this);

        aq.id(mViewHeader.imgCapa).progress(this).image(imagem.getUrl(), true, true, 0, 0, new BitmapAjaxCallback() {
            @Override
            public void callback(String url, ImageView iv, Bitmap bm, AjaxStatus status) {
                iv.setImageBitmap(bm);
            }
        });
    }

    /*
        Classe referente ao Header do listview
     */
    public class ViewHeader {

        final ImageView imgCapa;
        final TextView txtEdit;
        final TextView txtTitle;

        public ViewHeader(ViewGroup view) {
            imgCapa = (ImageView) view.findViewById(R.id.img_capa);
            txtTitle = (TextView) view.findViewById(R.id.txt_titulo);
            txtEdit = (TextView) view.findViewById(R.id.txt_editoria);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;

            case R.id.menu_reload:
                loadCouver();
                break;

            default:
                break;
        }

        return (super.onOptionsItemSelected(item));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
