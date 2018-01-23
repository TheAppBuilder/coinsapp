package the.appbuilder.coins.utils;

import java.util.Date;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import java.lang.reflect.Type;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.google.gson.JsonPrimitive;


/**
 *
 * DateTypeAdapter
 * This adapter allow date parsing with different format
 * Date only
 * Date time
 * Timestamp
 * Date time with time zone
 **/
public class DateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

    private DateFormat dateFormat;

    public DateTypeAdapter(String defaultFormat) {
        dateFormat = new SimpleDateFormat(defaultFormat);
    }

    @Override public synchronized JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(dateFormat.format(date));
    }

    @Override public synchronized Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        try {
            String dateString = jsonElement.getAsString();
            String dateFormatStr = "yyyy-MM-dd";
            if(dateString.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$")) {
                dateFormatStr = "yyyy-MM-dd";
            } else if(dateString.matches("^[0-9]{2}-[0-9]{2}-[0-9]{4}$")) {
                dateFormatStr = "dd-MM-yyyy";
            } else if(dateString.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$")) {
                dateFormatStr = "dd/MM/yyyy";
            } else if (dateString.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$")) {
                dateFormatStr = "yyyy-MM-dd HH:mm:ss";
            } else if (dateString.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}+[0-9]{2}(:)?[0-9]{2}$")) {
                dateFormatStr = "yyyy-MM-dd'T'HH:mm:ssZ";
            } else if (dateString.matches("^[A-Za-z]{3} [A-Za-z]{3} [0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2} [+0-9]{5} [0-9]{4}$")) {
                dateFormatStr = "EEE MMM dd HH:mm:ss Z yyyy";
            } else { // timestamps
                try {
                    Integer timestamp = Integer.parseInt(dateString);
                    Date date = new Date();
                    date.setTime(timestamp * 1000);
                    return date;
                } catch (Exception e) {
                    //throw new Exception(e);
                    e.printStackTrace();
                }
            }

            DateFormat dateFormatDeSer = new SimpleDateFormat(dateFormatStr);

            return dateFormatDeSer.parse(jsonElement.getAsString());
        } catch (ParseException e) {
            throw new JsonParseException(e);
        }
    }
}