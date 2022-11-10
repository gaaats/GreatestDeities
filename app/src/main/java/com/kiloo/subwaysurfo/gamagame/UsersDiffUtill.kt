package com.kiloo.subwaysurfo.gamagame
import androidx.recyclerview.widget.DiffUtil
import com.kiloo.subwaysurfo.gamagame.SingleUser

class UsersDiffUtill: DiffUtil.ItemCallback<SingleUser>() {
    override fun areItemsTheSame(oldItem: SingleUser, newItem: SingleUser): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SingleUser, newItem: SingleUser): Boolean {
        return oldItem == newItem
    }
}