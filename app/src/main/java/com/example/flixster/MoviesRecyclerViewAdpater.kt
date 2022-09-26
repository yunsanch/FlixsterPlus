package com.example.flixster
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flixster.R.id

/**
 * [RecyclerView.Adapter] that can display a [Movies] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */

class MoviesRecyclerViewAdpater(
    private val Movies: List<Movies>,
    private val mListener: OnListFragmentInteractionListener?
    )
    : RecyclerView.Adapter<MoviesRecyclerViewAdpater.MovieViewHolder>()
    {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }
        /**
         * This inner class lets us refer to all the different View elements
         * (Yes, the same ones as in the XML layout files!)
         */
        inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
            var mItem: Movies? = null
            val mMovieTitle: TextView = mView.findViewById<View>(id.Movie_title) as TextView
//            val mBookAuthor: TextView = mView.findViewById<View>(id.book_author) as TextView
            val mMovieImage: ImageView = mView.findViewById<View>(id.Movie_image) as ImageView
//            val mRanking: TextView = mView.findViewById<View>(id.ranking) as TextView
            val mDescription: TextView = mView.findViewById<View>(id.movie_description) as TextView
//            val mButton: Button = mView.findViewById<View>(id.buy_button) as Button


            override fun toString(): String {
                return mMovieTitle.toString() + " '" + mDescription.text + "'"
            }
        }

        /**
         * This lets us "bind" each Views in the ViewHolder to its' actual data!
         */
        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            val movie = Movies[position]



            holder.mItem = movie
            holder.mMovieTitle.text = movie.title
//            holder.mBookAuthor.text = book.author
//            holder.mRanking.text = book.rank.toString()
            holder.mDescription.text = movie.description
            Glide.with(holder.mView)
                .load("https://image.tmdb.org/t/p/w500/" + movie.MoviePosterImageUrl)
                .centerInside()
                .into(holder.mMovieImage)

//            holder.mButton.setOnClickListener {
//                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(book.amazonUrl))
//                startActivity(it.context, browserIntent, null)
//            }

            holder.mView.setOnClickListener {

                holder.mItem?.let { book ->
                    mListener?.onItemClick(book)
                }
            }
        }

        /**
         * Remember: RecyclerView adapters require a getItemCount() method.
         */
        override fun getItemCount(): Int {
            return Movies.size
        }
    }