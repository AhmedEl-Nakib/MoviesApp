package com.amg.task1.ui.movieDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.amg.task1.databinding.FragmentMovieDetailsBinding
import com.amg.task1.model.Movie
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback


class MovieDetails : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieDetailsBinding.inflate(inflater)
        val movie = requireArguments().getParcelable<Movie>("movie") as Movie
        binding.movie = movie
        binding.backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        return binding.root
    }


}