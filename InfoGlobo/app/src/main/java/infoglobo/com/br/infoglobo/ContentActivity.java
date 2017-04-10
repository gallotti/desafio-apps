package infoglobo.com.br.infoglobo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.callback.BitmapAjaxCallback;

import infoglobo.com.br.infoglobo.model.Content;
import infoglobo.com.br.infoglobo.model.Imagem;
import infoglobo.com.br.infoglobo.model.Secao;
import infoglobo.com.br.infoglobo.util.Util;

public class ContentActivity extends AppCompatActivity {

    private TextView txtTitle, txtSubTitle, txtTextContent;
    private Content mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent i = getIntent();
        mContent = (Content) i.getSerializableExtra("content");

        builActionBar();
        loadValuesInterface();
        loadLayoutImage();
        loadLayoutDate();

    }

    private void builActionBar(){

        Secao secao = mContent.getSecao();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setCustomView(R.layout.actionbar);
        TextView title=(TextView)findViewById(getResources().getIdentifier("action_bar_title", "id", getPackageName()));
        title.setText(secao.getNome());

    }

    private void loadValuesInterface() {

        txtTitle = (TextView) findViewById(R.id.txt_titulo);
        txtSubTitle = (TextView) findViewById(R.id.txt_sub_titulo);
        txtTextContent = (TextView) findViewById(R.id.txt_texto);

        txtTitle.setText(mContent.getTitulo());
        txtSubTitle.setText(mContent.getSubTitulo());
        txtTextContent.setText(mContent.getTexto());

    }

    private void loadLayoutDate() {

        View viewPorData = findViewById(R.id.view_por_data);

        TextView txtAutor = (TextView) viewPorData.findViewById(R.id.txt_autor);
        txtAutor.setText(Util.parseListToString(mContent.getAutores()));

        TextView txtDate = (TextView) viewPorData.findViewById(R.id.txt_date);
        txtDate.setText(mContent.getPublicadoEm());

    }

    private void loadLayoutImage() {

        if (!mContent.getImagens().isEmpty()) {
            Imagem imagem = mContent.getImagens().get(0);

            View viewImage = findViewById(R.id.view_image);
            viewImage.setVisibility(View.VISIBLE);
            TextView txtLegend = (TextView) viewImage.findViewById(R.id.txt_legend);
            txtLegend.setText(imagem.getLegenda());

            ImageView img = (ImageView) viewImage.findViewById(R.id.img_content);
            AQuery aq = new AQuery(this);

            aq.id(img).progress(this).image(imagem.getUrl(), true, true, 0, 0, new BitmapAjaxCallback() {
                @Override
                public void callback(String url, ImageView iv, Bitmap bm, AjaxStatus status) {
                    iv.setImageBitmap(bm);
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;

            case R.id.menu_upload:
                Toast.makeText(this, "UpLoad de Foto", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

        return (super.onOptionsItemSelected(item));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_content, menu);
        return true;
    }
}
