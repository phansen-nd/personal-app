package com.example.keith.Models

import android.graphics.Bitmap

class TripReport(val title: String, val blurb: String, val prettyDate: String, val thumbnailUrl: String) {
    lateinit var thumbnail: Bitmap;

}