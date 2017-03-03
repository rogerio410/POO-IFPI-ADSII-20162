package codes.wise.androidintro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

/**
 * Created by rogermac on 03/03/17.
 */

public class MySendListener implements View.OnClickListener {

    private Context context;

    public MySendListener(Context context){
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        //TODO
        context.startActivity(new Intent(context, SegundaActivity.class));

    }
}
