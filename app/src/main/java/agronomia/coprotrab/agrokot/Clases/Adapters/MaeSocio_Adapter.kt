package agronomia.coprotrab.agrokot.Clases.Adapters

import agronomia.coprotrab.agrokot.Clases.Entidades.MaeSocio
import agronomia.coprotrab.agrokot.Interfaces.rvMaeSoc_ClickListener
import agronomia.coprotrab.agrokot.R
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import kotlin.system.measureTimeMillis

class MaeSocio_Adapter( items: ArrayList<MaeSocio>, var listener: rvMaeSoc_ClickListener): RecyclerView.Adapter<MaeSocio_Adapter.ViewHolder>(){


    var items: ArrayList<MaeSocio>? = null
    var copiaItems: ArrayList<MaeSocio>? = null

    init{
        this.items = ArrayList(items)
        this.copiaItems = items
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.template_maesocio, parent, false)
        val viewHolder = ViewHolder(vista, listener)
        return  viewHolder
    }
    override fun getItemCount(): Int {
        return items?.count()!!
    }

    fun getItem(position: Int): Any {
        return this.items?.get(position)!!
    }

    fun filtrar(str: String){
        items?.clear()
        if(str.isEmpty()){
            items = ArrayList(copiaItems)
            notifyDataSetChanged()
            return
        }

        var busqueda = str
        busqueda = busqueda.toLowerCase()
        for (item in copiaItems!!){
            val nombre = item.Nombre_Soc.toLowerCase()
            if(nombre.contains(busqueda)){
                items?.add(item)
            }
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.id_soc?.text = item?.ID_Soc.toString()
        holder.nombre_soc?.text = item?.Nombre_Soc.toString()
        holder.loc_soc?.text = item?.Localidad_Soc.toString()
    }

    class ViewHolder(vista:View, listener: rvMaeSoc_ClickListener): RecyclerView.ViewHolder(vista), View.OnClickListener{

        var vista = vista
        var id_soc: TextView? = null
        var nombre_soc: TextView? = null
        var loc_soc: TextView? = null
        var listener: rvMaeSoc_ClickListener? = null
        init {
            id_soc = vista.findViewById(R.id.tv_temp_id_soc)
            nombre_soc = vista.findViewById(R.id.tv_temp_nombre_soc)
            loc_soc = vista.findViewById(R.id.tv_temp_loc_soc)
            this.listener = listener
            vista.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            this.listener?.onClick(v!!,adapterPosition)
        }
    }
}

