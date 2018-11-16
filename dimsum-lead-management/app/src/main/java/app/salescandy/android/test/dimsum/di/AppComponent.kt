package app.salescandy.android.test.dimsum.di

import android.app.Application
import app.salescandy.android.test.dimsum.data.SalespersonDao
import app.salescandy.android.test.dimsum.data.DimsumDatabase
import app.salescandy.android.test.dimsum.data.Repository
import app.salescandy.android.test.dimsum.viewmodel.SalespersonMngViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton @Component(dependencies = [], modules = [AppModule::class, RoomModule::class])
interface AppComponent {
    fun inject(viewModel: SalespersonMngViewModel)
    fun dao() : SalespersonDao
    fun database() : DimsumDatabase
    fun repository() : Repository
    fun application() : Application
}