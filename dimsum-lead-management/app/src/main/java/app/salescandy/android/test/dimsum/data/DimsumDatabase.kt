package app.salescandy.android.test.dimsum.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import app.salescandy.android.test.dimsum.data.model.Salesperson

@Database(entities = [Salesperson::class], version = DimsumDatabase.VERSION, exportSchema = false)
abstract class DimsumDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }

    abstract fun salespersonDao(): SalespersonDao
}