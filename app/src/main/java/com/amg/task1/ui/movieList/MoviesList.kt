package com.amg.task1.ui.movieList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.amg.task1.R
import com.amg.task1.adapter.MoviesAdapter
import com.amg.task1.databinding.FragmentMoviesListBinding
import com.amg.task1.model.Movie
import com.amg.task1.model.getDummyMoviesList1
import com.amg.task1.model.getDummyMoviesList2
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.google.android.material.transition.platform.MaterialElevationScale
import com.google.android.material.transition.platform.MaterialFadeThrough


class MoviesList : Fragment(), MoviesAdapter.Interaction {

    lateinit var binding: FragmentMoviesListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoviesListBinding.inflate(inflater)



        binding.listHor.adapter =
                MoviesAdapter(getDummyMoviesList1(), MoviesAdapter.ListOrientation.HORIZONTAL, this)
        binding.listVer.adapter =
                MoviesAdapter(getDummyMoviesList2(), MoviesAdapter.ListOrientation.VERTICAL, this)
        return binding.root
    }

    override fun onItemSelected(item: Movie, view: View) {
        exitTransition = MaterialElevationScale(true).apply {
            duration = 2000L
        }
        reenterTransition = MaterialElevationScale(false).apply {
            duration = 2000L
        }
        val bundle = bundleOf("movie" to item)
        Navigation.findNavController(requireView()).navigate(R.id.action_moviesList_to_movieDetails, bundle)
    }


}