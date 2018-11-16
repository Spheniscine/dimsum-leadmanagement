package app.salescandy.android.test.dimsum.di

import android.app.Application
import android.arch.persistence.room.Room
import app.salescandy.android.test.dimsum.data.SalespersonDao
import app.salescandy.android.test.dimsum.data.DimsumRepository
import app.salescandy.android.test.dimsum.data.DimsumDatabase
import app.salescandy.android.test.dimsum.data.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(val application: Application) {
    @get:Provides @get:Singleton
    val database = Room.databaseBuilder(application, DimsumDatabase::class.java, "dimsum").build()

    @Provides @Singleton
    fun getDao(database: DimsumDatabase) = database.salespersonDao()

    @Provides @Singleton
    fun getRepository(dao : SalespersonDao) : Repository = DimsumRepository(dao)
}