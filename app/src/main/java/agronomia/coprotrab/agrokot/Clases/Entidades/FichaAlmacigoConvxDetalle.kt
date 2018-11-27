package agronomia.coprotrab.agrokot.Clases.Entidades

class FichaAlmacigoConvxDetalle (id_alma_conv_detalle:Int,
                                 id_soc:Int,
                                 fecha:String,

                                 nombre_af_apc_conv:String?,
                                 id_af_apc_conv:Int?,
                                 af_apc_unid_conv:String?,
                                 af_apc_dosis_conv:Float?,

                                 nombre_af_fert_conv:String?,
                                 id_af_fert_conv:Int?,
                                 af_fert_unid_conv:String?,
                                 af_fert_dosis_conv:Float?,
                                 codigo_tipoaf:Int?,
                                 densidad:String?

){

    var ID_Alma_Conv_Detalle: Int = 0
    var ID_Soc: Int = 0
    var Fecha: String = ""

    var ID_AF_APC_Conv: Int?
    var Nombre_AF_APC_Conv: String?
    var AF_APC_Unid_Conv: String?
    var AF_APC_Dosis_Conv: Float?

    var Nombre_AF_Fert_Conv:String?
    var ID_AF_Fert_Conv: Int?
    var AF_Fert_Unid_Conv: String?
    var AF_Fert_Dosis_Conv: Float?
    var Codigo_TipoAF: Int?
    var Densidad:String?

    init {
        this.ID_Alma_Conv_Detalle = id_alma_conv_detalle
        this.ID_Soc = id_soc
        this.Fecha = fecha

        this.Nombre_AF_APC_Conv = nombre_af_apc_conv
        this.ID_AF_APC_Conv = id_af_apc_conv
        this.AF_APC_Unid_Conv = af_apc_unid_conv
        this.AF_APC_Dosis_Conv = af_apc_dosis_conv

        this.Nombre_AF_Fert_Conv = nombre_af_fert_conv
        this.ID_AF_Fert_Conv = id_af_fert_conv
        this.AF_Fert_Unid_Conv = af_fert_unid_conv
        this.AF_Fert_Dosis_Conv = af_fert_dosis_conv
        this.Codigo_TipoAF = codigo_tipoaf
        this.Densidad = densidad
    }
}