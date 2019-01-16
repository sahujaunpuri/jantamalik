package in.filternet.jantamalik.IssuesJava;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.view.Window;
import android.widget.TextView;

import in.filternet.jantamalik.R;

public class IssuesItem extends AppCompatActivity {
   private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Fade());
        }

        setContentView(R.layout.issues_fragment_item_layout);

        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(IssuesFragment.itemName);
        textView.setText(msg);
    }
}