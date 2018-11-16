package app.salescandy.android.test.dimsum.util.android

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.salescandy.android.test.dimsum.data.model.Model

/**
 * Generic model adapter class for RecyclerViews.
 * @param T The class of the items in the adapter.
 * @property itemLayoutId The layout resource ID for the items.
 * @property bindItemToView Lambda function (item : T, view : View) for binding an item to a view.
 */
open class ModelAdapter<T : Model>(private var itemLayoutId : Int, private var bindItemToView : (item : T, view : View) -> Unit) :
    ListAdapter<T, ModelAdapter<T>.Holder>(object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(p0: T, p1: T): Boolean = p0.id == p1.id

        override fun areContentsTheSame(p0: T, p1: T): Boolean = p0 == p1
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = LayoutInflater.from(parent.context).inflate(itemLayoutId, parent, false)
        return Holder(itemView)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        bindItemToView(getItem(position), holder.itemView)
    }

    /**
     * Lambda function, acts as onItemClickListener. Set it after creating the adapter.
     */
    var onItemClick : (T) -> Unit = {}

    fun get(position: Int) : T? = getItem(position)

    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                if(adapterPosition != RecyclerView.NO_POSITION) {
                    onItemClick(getItem(adapterPosition))
                }
            }
        }
    }
}