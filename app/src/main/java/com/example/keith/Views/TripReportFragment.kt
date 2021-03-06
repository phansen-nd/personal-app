package com.example.keith.Views

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.keith.Adapters.TripReportAdapter
import com.example.keith.R
import com.example.keith.ViewModels.TripReportViewModel
import kotlinx.android.synthetic.main.trip_report_fragment.*

class TripReportFragment : Fragment() {

    private lateinit var viewModel: TripReportViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.trip_report_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(TripReportViewModel::class.java)
        viewModel.getTripReports().observe(viewLifecycleOwner, { tripReports ->
            val adapter = TripReportAdapter(tripReports)
            tripReportsRecyclerView.adapter = adapter
        })
    }
}