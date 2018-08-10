package agronomia.coprotrab.agrokot.Clases.Adapters

import agronomia.coprotrab.agrokot.Clases.Entidades.Instructor
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class Instructor_Adapter(var contex:Context, items:ArrayList<Instructor>):BaseAdapter() {

    //////ACA PUEDEN IR LAS CONSULTAS A LA BD?
    var items:ArrayList<Instructor>? = null

    init {
        this.items = items
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

//        var holder: ViewHolder?=null
//
        var vista:View? = convertView
//        if(vista == null){
//            vista = LayoutInflater.from(contex).inflate(R.layout.template_instr, null)
//            holder = ViewHolder(vista)
//            vista.tag = holder
//        }
//        else    {
//            holder = vista.tag as? ViewHolder
//        }
//
//        val item = getItem(position) as Instructor
//        holder?.nombre?.text = item.nombre
//        holder?.usuario?.text = item.usuario
//
      return  vista!!

    }





    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }





    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }





    override fun getCount(): Int {
        return items?.count()!!
    }





    private class ViewHolder(vista: View){
//        var nombre:TextView?=null
//        var usuario:TextView?=null
//        init {
//            nombre = vista.findViewById(R.id.tv_temp_nombre)
//            usuario = vista.findViewById(R.id.tv_temp_usuario)
//        }
    }


    //ESTO VA EN EL MAIN
    //LIST VIEW INSTRUCTORES
/*
    var instr: ArrayList<Instructor> = ArrayList()
    instr.add(Instructor("Juan", "userjuan", "1234"))
    instr.add(Instructor("Pedro", "userpedro", "1234"))
    instr.add(Instructor("Pablo", "userpablo", "1234"))
    instr.add(Instructor("Ale", "userale", "1234"))
    instr.add(Instructor("Pinto", "userpinto", "1234"))

    val lista = findViewById<ListView>(R.id.lv_Instr)

    //val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, instr)

    val adaptador = Instructor_Adapter(this, instr)
    lista.adapter = adaptador

    lista.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
        Toast.makeText(this, instr.get(position).nombre, Toast.LENGTH_LONG).show()*/




}