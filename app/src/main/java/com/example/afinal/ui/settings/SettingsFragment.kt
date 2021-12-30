package com.example.afinal.ui.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.afinal.R
import com.example.afinal.databinding.FragmentSettingsBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel
    private var _binding: FragmentSettingsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textViewHead: TextView = binding.about
        val textViewAbout: TextView = binding.text
        val textViewText: TextView = binding.head
        val textViewName: TextView = binding.name
        val textViewLink: TextView = binding.link

        settingsViewModel.head.observe(viewLifecycleOwner, Observer {
            textViewHead.text = it
        })

        settingsViewModel.about.observe(viewLifecycleOwner, Observer {
            textViewAbout.text = it
        })

        settingsViewModel.text.observe(viewLifecycleOwner, Observer {
            textViewText.text = it
        })

        settingsViewModel.name.observe(viewLifecycleOwner, Observer {
            textViewName.text = it
        })

       settingsViewModel.link.observe(viewLifecycleOwner, Observer {
            textViewLink.text = it
        })

        val retrofit: Retrofit =  Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val gitAPI: GitApi = retrofit.create(GitApi::class.java)

        gitAPI.getUser("Rita-00").enqueue(object: Callback<GitApi.GitUser> {
            override fun onFailure(call: Call<GitApi.GitUser>, t: Throwable) {

            }

            override fun onResponse(call: Call<GitApi.GitUser>, response: Response<GitApi.GitUser>) {
                val user: GitApi.GitUser? = response.body()

                Log.d("AvatarURL", "${user?.avatarURL}")
                Log.d("Login", "${user?.login}")

                val imageView: ImageView = binding.avatar

                Picasso.get()
                    .load(user?.avatarURL)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_background)
                    .into(imageView);
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}