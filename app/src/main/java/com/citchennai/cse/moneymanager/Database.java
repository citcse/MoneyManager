package com.citchennai.cse.moneymanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Database extends SQLiteOpenHelper {
    public static String DATABASE="items.db";

    public static String[] tables={
     "users", "expen" ,"cat","notes"
    };


    public Database(Context context) {
        super(context,DATABASE,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+tables[0]+" (username TEXT PRIMARY KEY,password TEXT)");
        db.execSQL("CREATE TABLE "+tables[1]+" (" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "type integer," +
                "delta integer," +
                "cat integer," +
                "text string," +
                "datee datetime default CURRENT_TIMESTAMP" +
                ");" );
        db.execSQL("" +
                "CREATE TABLE "+tables[2]+" (" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "name string," +
                "balance integer" +
                ");");
        db.execSQL(
                "CREATE TABLE "+tables[3]+" (" +
                        "id integer PRIMARY KEY AUTOINCREMENT," +
                        "note string" +
                        ");"
        );
    }
    public Cursor GetTotal()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("select sum(delta) from "+tables[1],null);
        return result;
    }
    public Cursor GetMessage()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("select id,type,delta,cat,text,strftime( '%d-%m-%Y  %H:%m', datee) as datees from "+tables[1]+" order by datee desc;",null);
        return result;
    }
    public Cursor GetChart(String from)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("select sum(delta) from "+tables[1]+" where datee BETWEEN \"2016-"+from+"-01\" AND \"2016-"+from+"-31\"",null);
        return result;
    }
    public void deletemessage(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from "+tables[1]+" where id="+id);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for(String tablename:tables)
        {
            db.execSQL("DROP TABLE IF EXISTS "+tablename);
        }
        onCreate(db);
//        db.execSQL("DROP TABLE IF EXISTS"+TABLENAME);
//        db.execSQL("DROP TABLE IF EXISTS expen");
//        db.execSQL("DROP TABLE IF EXISTS cat");

    }
    public boolean InsertMyExpenses(boolean credited,int delta,String cat,String text)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("type",credited);
        values.put("delta",delta);
        values.put("cat",cat);
        values.put("text",text);
        long isInserted=db.insert(tables[1],null,values);
        if(isInserted==-1)
            return false;
        else
            return true;
        //db.execSQL("insert into expen (type,delta,cat,text) values ("+credited+","+delta+","+cat+",'"+text+"');");
        //return true;
    }

    public boolean InsertUser(String user_name, String user_password)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put("username",user_name);
        values.put("password",user_password);
        long isInserted=db.insert(tables[0],null,values);
        if(isInserted==-1)
            return false;
        else
            return true;
    }
    public Cursor GetUserData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("select * from "+tables[0],null);
        return result;
    }
    public boolean updatepassword(String user_name,String new_password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+tables[0]);
        db.execSQL("create table "+tables[0]+" (username TEXT PRIMARY KEY,password TEXT)");
        ContentValues values=new ContentValues();
        values.put("username",user_name);
        values.put("password",new_password);
        long isInserted=db.insert(tables[0],null,values);
        if(isInserted==-1)
            return false;
        else
            return true;

    }
    public void update()
    {
        //SQLiteDatabase db=this.getWritableDatabase();
       // this.onUpgrade(db,0,5);

    }
    public boolean InsertNote(String notes)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("type",3);
        values.put("delta",0);
        values.put("cat","");
        values.put("text",notes);
        long isInserted=db.insert(tables[1],null,values);
        if(isInserted==-1)
            return false;
        else
            return true;
    }


}
