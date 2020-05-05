package com.ivanhadzhi.popularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ivanhadzhi.popularmovies.databinding.MovieTrailerItemBinding;
import com.ivanhadzhi.popularmovies.model.Trailer;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder> {

    private final Context context;
    private List<Trailer> trailers;

    public TrailerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TrailerAdapter.TrailerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        MovieTrailerItemBinding binding = MovieTrailerItemBinding.inflate(layoutInflater, parent, false);
        return new TrailerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerAdapter.TrailerViewHolder holder, int position) {
        Trailer trailer = trailers.get(position);
        holder.bind(trailer);
    }

    @Override
    public int getItemCount() {
        return trailers != null ? trailers.size() : 0;
    }

    public void addTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
        notifyDataSetChanged();
    }

    public class TrailerViewHolder extends RecyclerView.ViewHolder {

        MovieTrailerItemBinding dataBinding;

        TrailerViewHolder(MovieTrailerItemBinding binding) {
            super(binding.getRoot());
            dataBinding = binding;
        }

        void bind(Trailer trailer) {
            dataBinding.setTrailer(trailer);
            String photoUrl = String.format("https://img.youtube.com/vi/%s/0.jpg", trailer.getKey());
            Picasso.get()
                    .load(photoUrl)
                    .placeholder(R.drawable.no_image)
                    .into(dataBinding.trailerPoster);
        }

    }
}
