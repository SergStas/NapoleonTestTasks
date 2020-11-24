package com.sergstas.recorder.db

import android.content.Context
import com.sergstas.recorder.R

class DBController constructor(private val _context: Context) {
    private val _helper = OpenHelper(_context, _context.getString(R.string.db_tableName_records))

    fun getTotalAmount(): Double {
        var result = 0.0
        val query = "SELECT DELTA FROM ${_context.getString(R.string.db_tableName_records)}"
        val cursor = _helper.readableDatabase.rawQuery(query, null)
        cursor.moveToFirst()
        while (cursor.moveToNext())
            result+=cursor.getDouble(cursor.getColumnIndex("DELTA"))
        return result
    }

    fun addEntry(delta: Double) {
        val query = "INSERT INTO ${_context.getString(R.string.db_tableName_records)} (ID, DELTA) VALUES (null, $delta)"
        _helper.writableDatabase.execSQL(query)
    }
}