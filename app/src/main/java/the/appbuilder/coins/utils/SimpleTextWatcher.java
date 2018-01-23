package the.appbuilder.coins.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

/**
 * Created by sonique on 4/02/2017.
 */

public class SimpleTextWatcher implements TextWatcher {
    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d("SimpleTextWatcher", "onTextChanged: "+s);
    }
}