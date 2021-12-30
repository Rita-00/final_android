package com.example.afinal.ui.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.afinal.databinding.FragmentTodayBinding

class TodayFragment : Fragment() {

    private lateinit var todayViewModel: TodayViewModel
    private var _binding: FragmentTodayBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        todayViewModel =
            ViewModelProvider(this).get(TodayViewModel::class.java)

        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val imageView: ImageView = binding.image
        val textViewTitle: TextView = binding.textTitle
        val textViewArtist: TextView = binding.textAuthor
        val textViewYear: TextView = binding.textYear
        val textViewHistory: TextView = binding.textHistory

        todayViewModel.image.observe(viewLifecycleOwner, Observer{
            imageView.setImageResource(it)
        })

        todayViewModel.name.observe(viewLifecycleOwner, Observer {
            textViewTitle.text = it
        })
        todayViewModel.artist.observe(viewLifecycleOwner, Observer {
            textViewArtist.text = it
        })
        todayViewModel.years.observe(viewLifecycleOwner, Observer {
            textViewYear.text = it
        })
        todayViewModel.histor.observe(viewLifecycleOwner, Observer {
            textViewHistory.text = it
        })


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}