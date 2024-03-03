package com.example.lab2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CharacterAdapter(private val characters: List<Character>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int = characters[position].getType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            Character.TYPE_IMAGE -> ImageViewHolder(inflater.inflate(R.layout.item_character_image, parent, false))
            Character.TYPE_NAME -> NameViewHolder(inflater.inflate(R.layout.item_character_name, parent, false))
            else -> SpeciesViewHolder(inflater.inflate(R.layout.item_character_species, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ImageViewHolder -> holder.bind(characters[position])
            is NameViewHolder -> holder.bind(characters[position])
            is SpeciesViewHolder -> holder.bind(characters[position])
        }
    }

    override fun getItemCount(): Int = characters.size

    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(character: Character) {
            val imageView: ImageView = itemView.findViewById(R.id.characterImage)
            Picasso.get().load(character.image).into(imageView)
        }
    }

    inner class NameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(character: Character) {
            val nameView: TextView = itemView.findViewById(R.id.characterName)
            nameView.text = character.name
        }
    }

    inner class SpeciesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(character: Character) {
            val speciesView: TextView = itemView.findViewById(R.id.characterSpecies)
            speciesView.text = character.species
        }
    }
}
