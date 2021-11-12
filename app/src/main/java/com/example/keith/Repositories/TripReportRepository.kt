package com.example.keith.Repositories

import com.example.keith.LiveData.TripReportsLiveData
import com.google.firebase.firestore.FirebaseFirestore

class TripReportRepository {

    private var db: FirebaseFirestore = FirebaseFirestore.getInstance();

    fun getTripReportLiveData(): TripReportsLiveData {
        var ref = this.db.collection("trip-reports");
        return TripReportsLiveData(ref);
    }
}