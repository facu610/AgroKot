package agronomia.coprotrab.agrokot.Clases.Entidades

class MaeSocio(id_socio:Int, fet_socio:Int, nombre_socio:String, kilos_socio:Int, domicilio_socio:String, localidad_socio:String, tel_soc:String) {

    var ID_Soc: Int = 0
    var FET_Soc: Int = 0
    var Nombre_Soc: String = ""
    var Kilos_Soc: Int = 0
    var Domicilio_Soc: String = ""
    var Localidad_Soc: String = ""
    var Telefono_Soc: String = ""

    init {
        this.ID_Soc = id_socio
        this.FET_Soc = fet_socio
        this.Nombre_Soc = nombre_socio
        this.Kilos_Soc = kilos_socio
        this.Domicilio_Soc = domicilio_socio
        this.Localidad_Soc = localidad_socio
        this.Telefono_Soc = tel_soc
    }
}

