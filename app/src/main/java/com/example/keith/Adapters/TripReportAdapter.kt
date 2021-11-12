package com.example.keith.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.keith.Models.TripReport
import com.example.keith.R
import com.squareup.picasso.Picasso

class TripReportAdapter(private val tripReports: List<TripReport>): RecyclerView.Adapter<TripReportAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val blurbTextView: TextView = view.findViewById(R.id.blurbTextView)
        val dateTextView: TextView = view.findViewById(R.id.dateTextView)
        val thumbnailImageView: ImageView = view.findViewById(R.id.imageView)

        fun updateWithUrl(url: String) {
            Picasso.get().load(url).into(thumbnailImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.trip_report_cell, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tr = tripReports[position]
        holder.titleTextView.text = tr.title
        holder.blurbTextView.text = tr.blurb
        holder.dateTextView.text = tr.prettyDate
        holder.updateWithUrl(tr.thumbnailUrl)
    }

    override fun getItemCount(): Int {
        return tripReports.size
    }
}