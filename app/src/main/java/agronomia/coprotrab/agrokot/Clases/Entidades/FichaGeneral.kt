package agronomia.coprotrab.agrokot.Clases.Entidades

class FichaGeneral (id_ficha:Int,
                    fecha_grales:String,
                    id_camp:Int,
                    id_soc:Int,
                    fet_soc:Int,
                    id_inst:Int,
                    finca_soc:String,
                    local_soc:String,
                    coord_soc: String,
                    zona_soc:Int,
                    tosincro:Int,
                    grado_riesgoapc:Int,
                    nombre_riesgoapc: String,
                    agro_has_propias:Int,
                    agro_has_arren:Int,
                    agro_has_tot:Int,
                    agro_cat_dtr:Int,
                    agro_verdeos_has:Int,
                    agro_rot_has:Int,
                    agro_dep_apc:Int,
                    agro_cumple_rec:Int,
                    agro_mangariego_has:Int,
                    agro_suelo_n:Int,
                    agro_suelo_nud:String,
                    agro_suelo_p:Int,
                    agro_suelo_pud:String,
                    agro_suelo_k:Int,
                    agro_suelo_kud:String,
                    agro_suelo_mo:Int,
                    agro_suelo_moud:String,
                    agro_suelo_ph:Int,
                    agro_agua_ce:Int,
                    agro_agua_ceud:String,
                    agro_agua_carb:Int,
                    agro_agua_carbud:String,
                    agro_agua_ph:Int,
                    agro_obs:String,
                    infra_cumple_rec:Int,
                    infra_posee_galp:Int,
                    infra_galpon_m3:Int,
                    infra_total_canas:Int,
                    infra_hasestuf:Int,
                    infra_obs:String,
                    infra_est_conv:Int,
                    infra_conv_gas:Int,
                    infra_conv_gas_ci:Int,
                    infra_conv_gas_si:Int,
                    infra_conv_gas_canas:Int,
                    infra_conv_gas_perchas:Int,
                    infra_conv_lena:Int,
                    infra_conv_lena_perchas:Int,
                    infra_conv_lena_canas:Int,
                    infra_bulk_cur:Int,
                    infra_bc_gas:Int,
                    infra_bc_gas_ci:Int,
                    infra_bc_gas_si:Int,
                    infra_bc_gas_peines:Int,
                    infra_bc_lena:Int,
                    infra_bc_lena_ci:Int,
                    infra_bc_lena_peines:Int





){

    var ID_Ficha: Int = 0
    var Fecha_Grales: String = ""
    var ID_Camp: Int = 0
    var ID_Soc: Int = 0
    var Fet_Soc: Int = 0
    var ID_Instr: Int = 0
    var Finca_Soc: String = ""
    var Local_Soc: String = ""
    var Coord_Soc: String = ""
    var Zona_Soc: Int = 0
    var ToSincro = 0

    var Grado_RiesgoAPC: Int = 0
    var Nombre_RiesgoAPC: String = ""
    var Agro_Has_Propias: Int = 0
    var Agro_Has_Arren: Int = 0
    var Agro_Has_Tot: Int = 0
    var Agro_Cat_DTR: Int = 0
    var Agro_Verdeos_Has: Int = 0
    var Agro_Rot_Has: Int = 0
    var Agro_Dep_APC: Int = 0
    var Agro_Cumple_Rec: Int = 0
    var Agro_MangaRiego_Has: Int = 0
    var Agro_Suelo_N: Int = 0
    var Agro_Suelo_NUd: String = ""
    var Agro_Suelo_P: Int = 0
    var Agro_Suelo_PUd: String = ""
    var Agro_Suelo_K: Int = 0
    var Agro_Suelo_KUd: String = ""
    var Agro_Suelo_MO: Int = 0
    var Agro_Suelo_MOUd: String = ""
    var Agro_Suelo_PH: Int = 0
    var Agro_Agua_CE: Int = 0
    var Agro_Agua_CEUd: String = ""
    var Agro_Agua_Carb: Int = 0
    var Agro_Agua_CarbUd: String = ""
    var Agro_Agua_PH: Int = 0
    var Agro_Obs: String = ""
    var Infra_Cumple_Rec: Int = 0
    var Infra_Posee_Galp: Int = 0
    var Infra_Galpon_m3: Int = 0
    var Infra_Total_Canas: Int = 0
    var Infra_HasEstuf: Int = 0
    var Infra_Obs: String = ""
    var Infra_Est_Conv: Int = 0
    var Infra_Conv_Gas: Int = 0
    var Infra_Conv_Gas_CI: Int = 0
    var Infra_Conv_Gas_SI: Int = 0
    var Infra_Conv_Gas_Canas: Int = 0
    var Infra_Conv_Gas_Perchas: Int = 0
    var Infra_Conv_Lena: Int = 0
    var Infra_Conv_Lena_Perchas: Int = 0
    var Infra_Conv_Lena_Canas: Int = 0
    var Infra_Bulk_Cur: Int = 0
    var Infra_BC_Gas: Int = 0
    var Infra_BC_Gas_CI: Int = 0
    var Infra_BC_Gas_SI: Int = 0
    var Infra_BC_Gas_Peines: Int = 0
    var Infra_BC_Lena: Int = 0
    var Infra_BC_Lena_CI: Int = 0
    var Infra_BC_Lena_Peines: Int = 0

    init {
        this.ID_Ficha = id_ficha
        this.Fecha_Grales = fecha_grales
        this.ID_Camp = id_camp
        this.ID_Soc = id_soc
        this.Fet_Soc = fet_soc
        this.ID_Instr = id_inst
        this.Finca_Soc = finca_soc
        this.Local_Soc = local_soc
        this.Coord_Soc = coord_soc
        this.Zona_Soc = zona_soc
        this.ToSincro = tosincro

        this.Grado_RiesgoAPC = grado_riesgoapc
        this.Nombre_RiesgoAPC = nombre_riesgoapc
        this.Agro_Has_Propias = agro_has_propias
        this.Agro_Has_Arren = agro_has_arren


        this.Agro_Has_Tot =   agro_has_tot
        this.Agro_Cat_DTR = agro_cat_dtr
        this.Agro_Verdeos_Has = agro_verdeos_has
        this.Agro_Rot_Has = agro_rot_has
        this.Agro_Dep_APC = agro_dep_apc
        this.Agro_Cumple_Rec = agro_cumple_rec
        this.Agro_MangaRiego_Has = agro_mangariego_has
        this.Agro_Suelo_N = agro_suelo_n
        this.Agro_Suelo_NUd = agro_suelo_nud
        this.Agro_Suelo_P = agro_suelo_p
        this.Agro_Suelo_PUd = agro_suelo_pud
        this.Agro_Suelo_K = agro_suelo_k
        this.Agro_Suelo_KUd = agro_suelo_kud
        this.Agro_Suelo_MO = agro_suelo_mo
        this.Agro_Suelo_MOUd = agro_suelo_moud
        this.Agro_Suelo_PH = agro_suelo_ph
        this.Agro_Agua_CE = agro_agua_ce
        this.Agro_Agua_CEUd = agro_agua_ceud
        this.Agro_Agua_Carb = agro_agua_carb
        this.Agro_Agua_CarbUd = agro_agua_carbud
        this.Agro_Agua_PH = agro_agua_ph
        this.Agro_Obs = agro_obs
        this.Infra_Cumple_Rec = infra_cumple_rec
        this.Infra_Posee_Galp = infra_posee_galp
        this.Infra_Galpon_m3 = infra_galpon_m3
        this.Infra_Total_Canas = infra_total_canas
        this.Infra_HasEstuf = infra_hasestuf
        this.Infra_Obs = infra_obs
        this.Infra_Est_Conv = infra_est_conv
        this.Infra_Conv_Gas = infra_conv_gas
        this.Infra_Conv_Gas_CI = infra_conv_gas_ci
        this.Infra_Conv_Gas_SI = infra_conv_gas_si
        this.Infra_Conv_Gas_Canas = infra_conv_gas_canas
        this.Infra_Conv_Gas_Perchas = infra_conv_gas_perchas
        this.Infra_Conv_Lena = infra_conv_lena
        this.Infra_Conv_Lena_Perchas = infra_conv_lena_perchas
        this.Infra_Conv_Lena_Canas = infra_conv_lena_canas
        this.Infra_Bulk_Cur = infra_bulk_cur
        this.Infra_BC_Gas = infra_bc_gas
        this.Infra_BC_Gas_CI = infra_bc_gas_ci
        this.Infra_BC_Gas_SI = infra_bc_gas_si
        this.Infra_BC_Gas_Peines = infra_bc_gas_peines
        this.Infra_BC_Lena = infra_bc_lena
        this.Infra_BC_Lena_CI = infra_bc_lena_ci
        this.Infra_BC_Lena_Peines = infra_bc_lena_peines
    }
}