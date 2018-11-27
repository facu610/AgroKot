package agronomia.coprotrab.agrokot.Clases.Entidades

class AgroFertilizantes (codigo_af:Int,
                         nombre_af:String?,
                         codigo_tipoaf:Int?,
                         permitido_af:String?
){

    var Codigo_AF: Int = 0
    var Nombre_AF: String?
    var Codigo_TipoAF: Int?
    var Permitido_AF:String?

    init {
        this.Codigo_AF = codigo_af
        this.Nombre_AF = nombre_af
        this.Codigo_TipoAF = codigo_tipoaf
        this.Permitido_AF = permitido_af
    }
}