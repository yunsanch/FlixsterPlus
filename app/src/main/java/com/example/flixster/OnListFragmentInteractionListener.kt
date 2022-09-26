package com.example.flixster

/**
 * This interface is used by the [MoviesRecyclerViewAdpater] to ensure
 * it has an appropriate Listener.
 *
 * In this app, it's implemented by [MoviesFrafment]
 */
interface OnListFragmentInteractionListener {
    fun onItemClick(item: Movies)
}
