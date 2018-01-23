package the.appbuilder.coins.model;


import android.databinding.Bindable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.math.BigDecimal;
import java.text.NumberFormat;
import com.google.gson.annotations.SerializedName;

import com.android.databinding.library.baseAdapters.BR;

import the.appbuilder.coins.utils.SimpleTextWatcher;

import the.appbuilder.coins.utils.ABModel;



public class Front extends ABModel {

    public BigDecimal perc;
    @SerializedName("long")
    public String long_var;
    public BigDecimal vwapData;
    public BigDecimal cap24hrChange;
    public Long supply;
    public BigDecimal vwapDataBTC;
    public BigDecimal price;
    @SerializedName("short")
    public String short_var;
    public BigDecimal volume;
    public Boolean shapeshift;
    public BigDecimal mktcap;
    public BigDecimal usdVolume;


    // -------------------- Below are all methods for 2-way data-binding
    // -------------------- you can customize them to fit your business requirements


    /** Following methods are for 2-way Databinding **/
    /**
      * getPercWatcher()
      * on text changed in UI, update current object
      */
    public TextWatcher getPercWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Front.this.perc = new BigDecimal(s.toString());
            }
        };
    }

    /**
      * getPercError()
      * if text set in input doesn't fit requirement
      * display error
      */
    @Bindable
    public String getPercError() {
        return null;
    }

    public EditText.OnFocusChangeListener getPercFocusListener() {
        return new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) notifyPropertyChanged(BR.percError);
            }
        };
    }
    

    /**
      * getPercAsString()
      * return Perc as a string, it is useful to show attribute into textfields
      */

    public String getPercAsString() {
        // NOTE: You can customize how you want to render perc
        return (this.perc.floatValue() > 0 ? "+" : "") + super.getAsString(this.perc) + "%";
    }
    



    /**
      * getLong_varWatcher()
      * on text changed in UI, update current object
      */
    public TextWatcher getLong_varWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Front.this.long_var = s.toString();
            }
        };
    }

    /**
      * getLong_varError()
      * if text set in input doesn't fit requirement
      * display error
      */
    @Bindable
    public String getLong_varError() {
        if (long_var != null && long_var.isEmpty()) {
            return "Must enter a long_var";
        }
        return null;
    }

    public EditText.OnFocusChangeListener getLong_varFocusListener() {
        return new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) notifyPropertyChanged(BR.long_varError);
            }
        };
    }
    



    /**
      * getVwapdataWatcher()
      * on text changed in UI, update current object
      */
    public TextWatcher getVwapdataWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Front.this.vwapData = new BigDecimal(s.toString());
            }
        };
    }

    /**
      * getVwapdataError()
      * if text set in input doesn't fit requirement
      * display error
      */
    @Bindable
    public String getVwapdataError() {
        return null;
    }

    public EditText.OnFocusChangeListener getVwapdataFocusListener() {
        return new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) notifyPropertyChanged(BR.vwapdataError);
            }
        };
    }
    

    /**
      * getVwapdataAsString()
      * return Vwapdata as a string, it is useful to show attribute into textfields
      */
      
    public String getVwapdataAsString() {
        // NOTE: You can customize how you want to render vwapdata
        // Using NumberFormat ( NumberFormat.getCurrencyInstance(), NumberFormat.getPercentInstance() )
        // or building your own formatter
        return super.getAsString(this.vwapData);
    }
    



    /**
      * getCap24hrchangeWatcher()
      * on text changed in UI, update current object
      */
    public TextWatcher getCap24hrchangeWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Front.this.cap24hrChange = new BigDecimal(s.toString());
            }
        };
    }

    /**
      * getCap24hrchangeError()
      * if text set in input doesn't fit requirement
      * display error
      */
    @Bindable
    public String getCap24hrchangeError() {
        return null;
    }

    public EditText.OnFocusChangeListener getCap24hrchangeFocusListener() {
        return new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) notifyPropertyChanged(BR.cap24hrchangeError);
            }
        };
    }
    

    /**
      * getCap24hrchangeAsString()
      * return Cap24hrchange as a string, it is useful to show attribute into textfields
      */
      
    public String getCap24hrchangeAsString() {
        // NOTE: You can customize how you want to render cap24hrchange
        // Using NumberFormat ( NumberFormat.getCurrencyInstance(), NumberFormat.getPercentInstance() )
        // or building your own formatter
        return super.getAsString(this.cap24hrChange);
    }
    



    /**
      * getSupplyWatcher()
      * on text changed in UI, update current object
      */
    public TextWatcher getSupplyWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Front.this.supply = Long.valueOf(s.toString());
            }
        };
    }

    /**
      * getSupplyError()
      * if text set in input doesn't fit requirement
      * display error
      */
    @Bindable
    public String getSupplyError() {
        return null;
    }

    public EditText.OnFocusChangeListener getSupplyFocusListener() {
        return new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) notifyPropertyChanged(BR.supplyError);
            }
        };
    }
    

    /**
      * getSupplyAsString()
      * return Supply as a string, it is useful to show attribute into textfields
      */
      
    public String getSupplyAsString() {
        // NOTE: You can customize how you want to render supply
        // Using NumberFormat ( NumberFormat.getCurrencyInstance(), NumberFormat.getPercentInstance() )
        // or building your own formatter
        return super.getAsString(this.supply);
    }
    



    /**
      * getVwapdatabtcWatcher()
      * on text changed in UI, update current object
      */
    public TextWatcher getVwapdatabtcWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Front.this.vwapDataBTC = new BigDecimal(s.toString());
            }
        };
    }

    /**
      * getVwapdatabtcError()
      * if text set in input doesn't fit requirement
      * display error
      */
    @Bindable
    public String getVwapdatabtcError() {
        return null;
    }

    public EditText.OnFocusChangeListener getVwapdatabtcFocusListener() {
        return new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) notifyPropertyChanged(BR.vwapdatabtcError);
            }
        };
    }
    

    /**
      * getVwapdatabtcAsString()
      * return Vwapdatabtc as a string, it is useful to show attribute into textfields
      */
      
    public String getVwapdatabtcAsString() {
        // NOTE: You can customize how you want to render vwapdatabtc
        // Using NumberFormat ( NumberFormat.getCurrencyInstance(), NumberFormat.getPercentInstance() )
        // or building your own formatter
        return super.getAsString(this.vwapDataBTC);
    }


    public String getImageUrl() {
        return "http://coincap.io/images/coins/"
                + long_var
                .replace(" ", "")
                .toLowerCase()
                + ".png";
    }



    /**
      * getPriceWatcher()
      * on text changed in UI, update current object
      */
    public TextWatcher getPriceWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Front.this.price = new BigDecimal(s.toString());
            }
        };
    }

    /**
      * getPriceError()
      * if text set in input doesn't fit requirement
      * display error
      */
    @Bindable
    public String getPriceError() {
        return null;
    }

    public EditText.OnFocusChangeListener getPriceFocusListener() {
        return new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) notifyPropertyChanged(BR.priceError);
            }
        };
    }
    

    /**
      * getPriceAsString()
      * return Price as a string, it is useful to show attribute into textfields
      */
      
    public String getPriceAsString() {
        // NOTE: You can customize how you want to render price
        return super.getAsString(this.price, NumberFormat.getCurrencyInstance());
    }
    



    /**
      * getShort_varWatcher()
      * on text changed in UI, update current object
      */
    public TextWatcher getShort_varWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Front.this.short_var = s.toString();
            }
        };
    }

    /**
      * getShort_varError()
      * if text set in input doesn't fit requirement
      * display error
      */
    @Bindable
    public String getShort_varError() {
        if (short_var != null && short_var.isEmpty()) {
            return "Must enter a short_var";
        }
        return null;
    }

    public EditText.OnFocusChangeListener getShort_varFocusListener() {
        return new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) notifyPropertyChanged(BR.short_varError);
            }
        };
    }
    



    /**
      * getVolumeWatcher()
      * on text changed in UI, update current object
      */
    public TextWatcher getVolumeWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Front.this.volume = new BigDecimal(s.toString());
            }
        };
    }

    /**
      * getVolumeError()
      * if text set in input doesn't fit requirement
      * display error
      */
    @Bindable
    public String getVolumeError() {
        return null;
    }

    public EditText.OnFocusChangeListener getVolumeFocusListener() {
        return new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) notifyPropertyChanged(BR.volumeError);
            }
        };
    }
    

    /**
      * getVolumeAsString()
      * return Volume as a string, it is useful to show attribute into textfields
      */
      
    public String getVolumeAsString() {
        // NOTE: You can customize how you want to render volume
        return super.getAsString(this.volume);
    }
    



    /**
      * getShapeshiftWatcher()
      * on text changed in UI, update current object
      */
    public TextWatcher getShapeshiftWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Front.this.shapeshift = Boolean.valueOf(s.toString());
            }
        };
    }

    /**
      * getShapeshiftError()
      * if text set in input doesn't fit requirement
      * display error
      */
    @Bindable
    public String getShapeshiftError() {
        return null;
    }

    public EditText.OnFocusChangeListener getShapeshiftFocusListener() {
        return new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) notifyPropertyChanged(BR.shapeshiftError);
            }
        };
    }
    

    /**
      * getShapeshiftAsString()
      * return Shapeshift as a string, it is useful to show attribute into textfields
      */
      
    public String getShapeshiftAsString() {
        // NOTE: You can customize how you want to render shapeshift
        // Using NumberFormat ( NumberFormat.getCurrencyInstance(), NumberFormat.getPercentInstance() )
        // or building your own formatter
        return super.getAsString(this.shapeshift);
    }
    



    /**
      * getMktcapWatcher()
      * on text changed in UI, update current object
      */
    public TextWatcher getMktcapWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Front.this.mktcap = new BigDecimal(s.toString());
            }
        };
    }

    /**
      * getMktcapError()
      * if text set in input doesn't fit requirement
      * display error
      */
    @Bindable
    public String getMktcapError() {
        return null;
    }

    public EditText.OnFocusChangeListener getMktcapFocusListener() {
        return new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) notifyPropertyChanged(BR.mktcapError);
            }
        };
    }
    

    /**
      * getMktcapAsString()
      * return Mktcap as a string, it is useful to show attribute into textfields
      */
      
    public String getMktcapAsString() {
        // NOTE: You can customize how you want to render mktcap
        // Using NumberFormat ( NumberFormat.getCurrencyInstance(), NumberFormat.getPercentInstance() )
        // or building your own formatter
        return super.getAsString(this.mktcap);
    }
    



    /**
      * getUsdvolumeWatcher()
      * on text changed in UI, update current object
      */
    public TextWatcher getUsdvolumeWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Front.this.usdVolume = new BigDecimal(s.toString());
            }
        };
    }

    /**
      * getUsdvolumeError()
      * if text set in input doesn't fit requirement
      * display error
      */
    @Bindable
    public String getUsdvolumeError() {
        return null;
    }

    public EditText.OnFocusChangeListener getUsdvolumeFocusListener() {
        return new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) notifyPropertyChanged(BR.usdvolumeError);
            }
        };
    }
    

    /**
      * getUsdvolumeAsString()
      * return Usdvolume as a string, it is useful to show attribute into textfields
      */
      
    public String getUsdvolumeAsString() {
        // NOTE: You can customize how you want to render usdvolume
        // Using NumberFormat ( NumberFormat.getCurrencyInstance(), NumberFormat.getPercentInstance() )
        // or building your own formatter
        return super.getAsString(this.usdVolume);
    }
    




}