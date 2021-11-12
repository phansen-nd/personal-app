package com.example.keith.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.keith.LiveData.TripReportsLiveData
import com.example.keith.Models.TripReport
import com.example.keith.Repositories.TripReportRepository

class TripReportViewModel() : ViewModel() {
    private var liveData: TripReportsLiveData? = null;

    fun getTripReports(): LiveData<List<TripReport>> {
        if (this.liveData == null) {
            val repo = TripReportRepository();
            this.liveData = repo.getTripReportLiveData();
        }
        return this.liveData!!.tripReportsList;
    }
}