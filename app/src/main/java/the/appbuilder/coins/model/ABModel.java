package the.appbuilder.coins.utils;

import android.databinding.BaseObservable;
import java.text.NumberFormat;
import java.math.BigDecimal;

public class ABModel extends BaseObservable {
    
    
    public String getAsString(Object value, NumberFormat numberFormat) {
        if(value instanceof BigDecimal) {            
            if (value != null) {
                return numberFormat.format(value);
            } else {
                
            }
        } else if(value != null) {
            return value.toString();
        }
        
        return "";
    }
    
    public String getAsString(Object value) {
        // Default NumberFormat
        NumberFormat numberFormat = NumberFormat.getInstance();
        return getAsString(value, numberFormat);
    }
    
}