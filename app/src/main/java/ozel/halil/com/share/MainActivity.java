package ozel.halil.com.share;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText editText= (EditText) findViewById(R.id.etMessage);
        ImageView image= (ImageView) findViewById(R.id.ivShare);


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence mesaj=editText.getText();
                shareMessage(mesaj);
            }
        });
    }

    private void shareMessage(CharSequence mesaj) {
        Intent shareIntent=new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,mesaj);
        startActivity(Intent.createChooser(shareIntent,"Paylaş"));
    }
}
