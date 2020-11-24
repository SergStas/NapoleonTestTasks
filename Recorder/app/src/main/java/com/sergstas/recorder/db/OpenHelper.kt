package com.sergstas.recorder.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class OpenHelper constructor(context: Context?, private val name: String) :
    SQLiteOpenHelper(context, name, null, VERSION) {
    companion object{
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val request = "CREATE TABLE $name (ID INTEGER PRIMARY KEY AUTOINCREMENT, DELTA DOUBLE NOT NULL DEFAULT 0)"
        db.execSQL(request)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Log.w("SQLite", "Update from $oldVersion to $newVersion");
        db.execSQL("DROP TABLE IF IT EXISTS " + name)
        onCreate(db)
    }
}