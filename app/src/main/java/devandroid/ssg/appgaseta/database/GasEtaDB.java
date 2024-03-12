package devandroid.ssg.appgaseta.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GasEtaDB extends SQLiteOpenHelper {

    //psfs
    public static final String DB_NAME = "gaseta.db";
    public static final int DB_VERSION = 1;
    Cursor cursor;
    SQLiteDatabase DB;
    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        DB = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqltabelacombustivel = "CREAT TABLE combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeDoCombustivel TEXT, " +
                "precoDoCombustivel REAL, " +
                "recomendacao TEXT)";

        DB.execSQL(sqltabelacombustivel);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
