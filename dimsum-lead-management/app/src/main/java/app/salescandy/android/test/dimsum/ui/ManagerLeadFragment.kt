package app.salescandy.android.test.dimsum.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import app.salescandy.android.test.dimsum.R



/**
 * A simple [Fragment] subclass.
 *
 */
class ManagerLeadFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lead_mng, container, false)


    }


}
