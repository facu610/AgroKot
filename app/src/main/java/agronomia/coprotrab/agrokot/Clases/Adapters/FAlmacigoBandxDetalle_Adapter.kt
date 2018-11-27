package agronomia.coprotrab.agrokot.Clases.Adapters

import agronomia.coprotrab.agrokot.Clases.Entidades.FichaAlmacigoBandxDetalle
import agronomia.coprotrab.agrokot.R
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.template_falma.view.*

class FAlmacigoBandxDetalle_Adapter(val context: Context, items: ArrayList<FichaAlmacigoBandxDetalle>, val tipo:Int ): RecyclerView.Adapter<FAlmacigoBandxDetalle_Adapter.ViewHolder>(){


    var items: ArrayList<FichaAlmacigoBandxDetalle>? = null

    init{
        this.items = ArrayList(items)
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.template_falma, parent, false)
        val viewHolder = ViewHolder(vista)
        return  viewHolder
    }
    override fun getItemCount(): Int {
        return items?.count()!!
    }

    fun getItem(position: Int): Any {
        return this.items?.get(position)!!
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        if (tipo == 5){
        holder.id_af?.text = item?.ID_AF_APC_Band.toString()
        holder.nombre_af?.text = item?.Nombre_AF_APC_Band.toString()
        holder.dosis?.text = item?.AF_APC_Dosis_Band.toString()}
        else {
            holder.id_af?.text = item?.ID_AF_Fert_Band.toString()
            holder.nombre_af?.text = item?.Nombre_AF_Fert_Band.toString()
            holder.dosis?.text = item?.AF_Fert_Dosis_Band.toString()}
    }

    class ViewHolder(vista:View): RecyclerView.ViewHolder(vista){

        var vista = vista
        var id_af: TextView? = vista.tv_temp_id_af
        var nombre_af: TextView? = vista.tv_temp_nombre_af
        var dosis: TextView? = vista.tv_temp_dosis

    }
}

