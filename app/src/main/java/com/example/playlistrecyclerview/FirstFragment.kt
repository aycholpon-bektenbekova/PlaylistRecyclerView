package com.example.playlistrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import com.example.playlistrecyclerview.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val soundList = arrayListOf<Sound>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()

        val adapter = PlaylistAdapter(soundList, this::onClick)
        binding.rvPlaylist.adapter = adapter
    }

    private fun loadData() {
        soundList.add(Sound("I was made for lovin' u", "Kiss"))
        soundList.add(Sound("Young & Dumb", "Cigarettes after sex"))
        soundList.add(Sound("Love is for sucker", "Twisted sister"))
        soundList.add(Sound("Je te lasserai des mots", "Patrick Watson"))
        soundList.add(Sound("Still loving you", "Scorpions"))
        soundList.add(Sound("Francis forever", "Mitski"))

    }

    fun onClick(position: Int){
     requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container, SecondFragment()).commit()
      
    }
}
