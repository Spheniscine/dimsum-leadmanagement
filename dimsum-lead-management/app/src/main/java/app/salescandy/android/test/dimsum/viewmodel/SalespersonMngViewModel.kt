package app.salescandy.android.test.dimsum.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import app.salescandy.android.test.dimsum.data.Repository
import app.salescandy.android.test.dimsum.data.model.Salesperson
import app.salescandy.android.test.dimsum.di.AppComponent
import app.salescandy.android.test.dimsum.di.AppModule
import app.salescandy.android.test.dimsum.di.DaggerAppComponent
import app.salescandy.android.test.dimsum.di.RoomModule
import javax.inject.Inject

class SalespersonMngViewModel(application: Application) : AndroidViewModel(application) {

    @Inject lateinit var repository: Repository

    private val daggerAppComponent : AppComponent = DaggerAppComponent.builder()
        .appModule(AppModule(application))
        .roomModule(RoomModule(application))
        .build()

    init {
        daggerAppComponent.inject(this)
    }

    val allSalespeople = repository.allSalespeople


    fun insert(salesperson: Salesperson) {
        repository.insert(salesperson)
    }

    fun update(salesperson: Salesperson) {
        repository.update(salesperson)
    }

    fun delete(salesperson: Salesperson) {
        repository.delete(salesperson)
    }
}