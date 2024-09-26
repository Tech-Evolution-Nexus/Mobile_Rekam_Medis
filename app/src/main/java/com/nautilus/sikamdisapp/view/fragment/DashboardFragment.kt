package com.nautilus.sikamdisapp.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.nautilus.sikamdisapp.R
import com.nautilus.sikamdisapp.helper.helpp
import com.nautilus.sikamdisapp.view.LaporanActivity
import com.nautilus.sikamdisapp.view.ObatActivity
import com.nautilus.sikamdisapp.view.RekmedActivity
import com.nautilus.sikamdisapp.view.RiwayatPasienActivity


class DashboardFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val btnrekmed = view.findViewById<View>(R.id.btn_rekammed)
        val btnobat = view.findViewById<View>(R.id.btn_obat)
        val btnlaporan = view.findViewById<View>(R.id.btn_laporan)
        val btnhistory = view.findViewById<View>(R.id.btn_riwayat)

        btnrekmed.setOnClickListener {
            helpp.startActivity(requireContext(), RekmedActivity::class.java)
        }
        btnobat.setOnClickListener {
            helpp.startActivity(requireContext(), ObatActivity::class.java)
        }
        btnlaporan.setOnClickListener {
            helpp.startActivity(requireContext(), LaporanActivity::class.java)
        }
        btnhistory.setOnClickListener {
            helpp.startActivity(requireContext(), RiwayatPasienActivity::class.java)
        }
        return view;
    }
}