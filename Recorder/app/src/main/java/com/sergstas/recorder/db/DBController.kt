package com.sergstas.recorder.db

import android.content.Context
import com.sergstas.recorder.R

class DBController constructor(private val _context: Context) {
    private val _helper = OpenHelper(_context, _context.getString(R.string.db_tableName_records))

    fun getTotalAmount(): Int {
        var result = 0
        val query = "SELECT * FROM ${_context.getString(R.string.db_tableName_records)}"
        val cursor = _helper.readableDatabase.rawQuery(query, null)
        while (cursor.moveToNext())
            result+=cursor.getInt(cursor.getColumnIndex("DELTA"))
        return result
    }

    fun addEntry(delta: Int) {
        val query = "INSERT INTO ${_context.getString(R.string.db_tableName_records)} (DELTA) VALUES $delta"
        _helper.writableDatabase.rawQuery(query, null)
    }
}