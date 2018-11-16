package app.salescandy.android.test.dimsum.ui


import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import app.salescandy.android.test.dimsum.R
import app.salescandy.android.test.dimsum.data.model.Salesperson
import app.salescandy.android.test.dimsum.util.android.ModelAdapter
import app.salescandy.android.test.dimsum.util.android.showToast
import app.salescandy.android.test.dimsum.viewmodel.SalespersonMngViewModel
import kotlinx.android.synthetic.main.fragment_manager_salespeople.view.*
import kotlinx.android.synthetic.main.salesperson_item.view.*


/**
 * A simple [Fragment] subclass.
 *
 */
class ManagerSalespeopleFragment : Fragment() {

    companion object {
        const val ADD_REQUEST = 1
        const val EDIT_REQUEST = 2
    }

    private lateinit var viewModel: SalespersonMngViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_manager_salespeople, container, false)

        // set up recycler view and adapter
        val recyclerView = rootView.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        val adapter =
            ModelAdapter<Salesperson>(R.layout.salesperson_item) { item, view ->
                view.textView_displayName.text = item.displayName
                view.textView_phone.text = item.phone
            }
        recyclerView.adapter = adapter

        // set up viewmodel and observe
        viewModel = ViewModelProviders.of(this)[SalespersonMngViewModel::class.java]
        viewModel.allSalespeople.observe(this, Observer<List<Salesperson>> {
            adapter.submitList(it)
        })

        adapter.onItemClick = {salesperson ->
            editSalesperson(salesperson)
        }



        // hook up add salesperson button
        rootView.button_addSalesperson.setOnClickListener {
            val intent = Intent(this@ManagerSalespeopleFragment.context, AddEditSalespersonActivity::class.java)
            startActivityForResult(intent, ADD_REQUEST)
        }

        return rootView
    }

    private fun editSalesperson(salesperson: Salesperson) {
        val intent = Intent(this.context, AddEditSalespersonActivity::class.java).apply {
            putExtra(AddEditSalespersonActivity.EXTRA_ID, salesperson.id)
            putExtra(AddEditSalespersonActivity.EXTRA_USERNAME, salesperson.username)
            putExtra(AddEditSalespersonActivity.EXTRA_PHONE, salesperson.phone)
        }
        startActivityForResult(intent, EDIT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(data != null && resultCode == Activity.RESULT_OK) {
            when(requestCode) {
                ADD_REQUEST -> {
                    val username = data.getStringExtra(AddEditSalespersonActivity.EXTRA_USERNAME)
                    val phone = data.getStringExtra(AddEditSalespersonActivity.EXTRA_PHONE)

                    val salesperson = Salesperson(username, phone)
                    viewModel.insert(salesperson)
                }
                EDIT_REQUEST -> {
                    val id = data.getIntExtra(AddEditSalespersonActivity.EXTRA_ID, -1)
                    if(id == -1) {
                        context?.showToast("Unexpected error")
                    }

                    val username = data.getStringExtra(AddEditSalespersonActivity.EXTRA_USERNAME)
                    val phone = data.getStringExtra(AddEditSalespersonActivity.EXTRA_PHONE)

                    val salesperson = Salesperson(username, phone)
                    salesperson.id = id
                    viewModel.update(salesperson)

                    context?.showToast("Salesperson updated")
                }
            }
        }
    }


}
