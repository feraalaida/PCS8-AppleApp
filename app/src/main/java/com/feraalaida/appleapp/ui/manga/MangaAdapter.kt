package com.feraalaida.appleapp.ui.manga

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.feraalaida.appleapp.R
import com.feraalaida.appleapp.data.model.Manga
import com.feraalaida.appleapp.databinding.ItemMangaBinding
import com.feraalaida.appleapp.ui.base.BaseAdapter
import com.bumptech.glide.Glide

class MangaAdapter (val context: Context) : BaseAdapter<Manga>(R.layout.item_manga) {
    override fun onBind(binding: ViewDataBinding?, data: Manga) {
        val mBinding = binding as ItemMangaBinding
        Glide.with(context).load(data.thumb).into(mBinding.itemThumb)
    }

    override fun onClick(binding: ViewDataBinding?, data: Manga) {
        val intent = Intent(context, MangaActivity::class.java)
        intent.putExtra(MangaActivity.OPEN_MANGA, data)
        context.startActivity(intent)
    }
}