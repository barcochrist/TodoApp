package co.barcochrist.todoapp.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by christianbarco on 8/12/17.
 * Convertor personalizado para trabajar con tipos de datos
 * en base de datos SQLite.
 */

public class TypeTransmogrifiers {
    @TypeConverter
    public static Long fromDate(Date date) {
        if (date==null) {
            return(null);
        }

        return(date.getTime());
    }

    @TypeConverter
    public static Date toDate(Long millisSinceEpoch) {
        if (millisSinceEpoch==null) {
            return(null);
        }

        return(new Date(millisSinceEpoch));
    }
}
