package com.example.keith.LiveData;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.keith.Models.TripReport;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TripReportsLiveData extends LiveData<List<TripReport>> implements EventListener<QuerySnapshot> {
    private CollectionReference ref;

    public MutableLiveData<List<TripReport>> tripReportsList = new MutableLiveData<>();

    public TripReportsLiveData(CollectionReference ref) {
        this.ref = ref;
        this.ref.addSnapshotListener(this);
    }

    @Override
    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
        if (value != null) {
            List<TripReport> tripReports = new ArrayList<>();

            for (QueryDocumentSnapshot doc : value) {
                TripReport tr = new TripReport(doc.getString("title"), doc.getString("blurb"), doc.getString("dateString"));
                tripReports.add(tr);
            }

            tripReportsList.setValue(tripReports);
        } else {
            Log.d("TripReportsLiveData", error.getLocalizedMessage());
        }
    }
}
