package com.example.raushan.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Raushan on 5/22/2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "RouteList";
    public MySQLiteHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_ROUTE_TABLE = "CREATE TABLE routes ( "+"id INTEGER PRIMARY KEY AUTOINCREMENT, "+"rtno TEXT, "+"src TEXT,"+"dst TEXT,"+"pk1 TEXT,"+"pk2 TEXT)";
        db.execSQL(CREATE_ROUTE_TABLE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS routes");
        this.onCreate(db);
    }
    private static final String TABLE_ROUTES = "routes";
    private static final String RTID = "id";
    private static final String RTNO = "rtno";
    private static final String RTSRC = "src";
    private static final String RTDST = "dst";
    private static final String RTPK1 = "pk1";
    private static final String RTPK2 = "pk2";

    private static final String[] COLUMNS = {RTID,RTSRC,RTDST,RTPK1,RTPK2};
    public void addroute(Routes rt)
    {
        Log.i("addroute", rt.toString());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RTNO, rt.getrtno());
        values.put(RTSRC, rt.getrtsrc());
        values.put(RTDST, rt.getrtdst());
        values.put(RTPK1, rt.getrtpk1());
        values.put(RTPK2, rt.getrtpk2());

        db.insertOrThrow(TABLE_ROUTES,null,values);
        db.close();
    }
    //    public int updatecontact(Contact cont)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("KEY_FNAME", cont.getfname());
//        values.put("KEY_LNAME", cont.getlname());
//        values.put("KEY_PHONE", String.valueOf(cont.getphone()));
//        values.put("KEY_EMAIL", cont.getemail());
//        values.put("KEY_ADDRESS", cont.getaddress());
//        int i = db.update(TABLE_CONTACT,values,KEY_ID+" = ?",new String[] { String.valueOf(cont.getid()) });
//        db.close();
//        return i;
//    }
//    public void deletecontact(Contact cont)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_CONTACT,KEY_ID+" = ?",new String[] { String.valueOf(cont.getid()) });
//        db.close();
//        Log.d("deleteBook", cont.toString());
//    }
//    public Route getroute(Route route)
//    {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(TABLE_ROUTE,COLUMNS," id = ?",new String[] { String.valueOf(route) },null,null,null,null);
//        if (cursor != null)
//            cursor.moveToFirst();
//        Route rt4 = new Route();
//        rt4.setid(Integer.parseInt(cursor.getString(0)));
//        rt4.setrnum(cursor.getString(1));
//        rt4.setorgname(cursor.getString(2));
//        rt4.setdest(cursor.getString(3));
//        rt4.setpickup1(cursor.getString(4));
//        rt4.setpickup2(cursor.getString(5));
//        rt4.setpickup3(cursor.getString(6));
//        Log.d("getroute("+route+")", rt4.toString());
//        return rt4;
//    }
    public List<Routes> getAllNames()
    {
        List<Routes> nm1 = new LinkedList<Routes>();
        String query = "SELECT * FROM " + TABLE_ROUTES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Routes rt = null;
        if (cursor.moveToFirst())
        {
            do
            {
                rt = new Routes();
                rt.setrtid(Integer.parseInt(cursor.getString(cursor.getColumnIndex(RTID))));
                rt.setrtno(cursor.getString(cursor.getColumnIndex(RTNO)));
                rt.setrtsrc(cursor.getString(cursor.getColumnIndex(RTSRC)));
                rt.setrtdst(cursor.getString(cursor.getColumnIndex(RTDST)));
                rt.setrtpk1(cursor.getString(cursor.getColumnIndex(RTPK1)));
                rt.setrtpk2(cursor.getString(cursor.getColumnIndex(RTPK2)));
                nm1.add(rt);
            }while (cursor.moveToNext());
        }
        Log.d("getAllNames()", nm1.toString());
        return nm1;
    }
}