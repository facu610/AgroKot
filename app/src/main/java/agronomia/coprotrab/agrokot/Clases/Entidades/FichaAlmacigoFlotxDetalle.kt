package agronomia.coprotrab.agrokot.Clases.Entidades

class FichaAlmacigoFlotxDetalle (id_alma_flot_detalle:Int,
                                 id_soc:Int,
                                 fecha:String,

                                 nombre_af_apc_flot:String?,
                                 id_af_apc_flot:Int?,
                                 af_apc_unid_flot:String?,
                                 af_apc_dosis_flot:Float?,

                                 nombre_af_fert_flot:String?,
                                 id_af_fert_flot:Int?,
                                 af_fert_unid_flot:String?,
                                 af_fert_dosis_flot:Float?,
                                 codigo_tipoaf:Int?,
                                 densidad:String?

){

    var ID_Alma_Flot_Detalle: Int = 0
    var ID_Soc: Int = 0
    var Fecha: String = ""

    var ID_AF_APC_Flot: Int?
    var Nombre_AF_APC_Flot: String?
    var AF_APC_Unid_Flot: String?
    var AF_APC_Dosis_Flot: Float?

    var Nombre_AF_Fert_Flot:String?
    var ID_AF_Fert_Flot: Int?
    var AF_Fert_Unid_Flot: String?
    var AF_Fert_Dosis_Flot: Float?
    var Codigo_TipoAF: Int?
    var Densidad:String?

    init {
        this.ID_Alma_Flot_Detalle = id_alma_flot_detalle
        this.ID_Soc = id_soc
        this.Fecha = fecha

        this.Nombre_AF_APC_Flot = nombre_af_apc_flot
        this.ID_AF_APC_Flot = id_af_apc_flot
        this.AF_APC_Unid_Flot = af_apc_unid_flot
        this.AF_APC_Dosis_Flot = af_apc_dosis_flot

        this.Nombre_AF_Fert_Flot = nombre_af_fert_flot
        this.ID_AF_Fert_Flot = id_af_fert_flot
        this.AF_Fert_Unid_Flot = af_fert_unid_flot
        this.AF_Fert_Dosis_Flot = af_fert_dosis_flot
        this.Codigo_TipoAF = codigo_tipoaf
        this.Densidad = densidad
    }
}