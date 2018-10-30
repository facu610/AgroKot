package agronomia.coprotrab.agrokot.Clases.DataResources

import agronomia.coprotrab.agrokot.Clases.Entidades.FichaGeneral
import agronomia.coprotrab.agrokot.Clases.Entidades.Instructor
import agronomia.coprotrab.agrokot.Clases.Entidades.MaeSocio
import android.content.Context
import org.jetbrains.anko.db.*

class DataAccess_RegistroAgrotecnico_App(val context: Context) {
    fun select_Instructores(): ArrayList<Instructor> = context.database.use {
        val instructores = ArrayList<Instructor>()

        select("AA_Instructores", "ID_Instr", "User_Instr", "Nombre_Instr", "Zona_Instr", "Issuper_Instr", "Idvehiculo_Instr", "Idmovil_Instr", "Pass_Instr")
                .parseList(object : MapRowParser<List<Instructor>> {
                    override fun parseRow(columns: Map<String, Any?>): List<Instructor> {
                        val ID_Instr = columns.getValue("ID_Instr")
                        val User_Instr = columns.getValue("User_Instr")
                        val Nombre_Instr = columns.getValue("Nombre_Instr")
                        val Zona_Instr = columns.getValue("Zona_Instr")
                        val Issuper_Instr = columns.getValue("Issuper_Instr")
                        val Idvehiculo_Instr = columns.getValue("Idvehiculo_Instr")
                        val Idmovil_Instr = columns.getValue("Idmovil_Instr")
                        val Pass_Instr = columns.getValue("Pass_Instr")

                        val instructor = Instructor(ID_Instr.toString().toInt(),
                                User_Instr.toString(),
                                Nombre_Instr.toString(),
                                Zona_Instr.toString().toInt(),
                                Issuper_Instr.toString().toInt(),
                                Idvehiculo_Instr.toString().toInt(),
                                Idmovil_Instr.toString().toInt(),
                                Pass_Instr.toString())

                        instructores.add(instructor)

                        return instructores
                    }
                })

        instructores
    }

    fun select_Instructor(user:String): Instructor = context.database.use {

        var instructor: Instructor? = null

        select("AA_Instructores")
                .where("(User_Instr = {user})",
                        "user" to user)
                .parseOpt(object : MapRowParser<Instructor> {
                    override fun parseRow(columns: Map<String, Any?>): Instructor {
                        val ID_Instr = columns.getValue("ID_Instr")
                        val User_Instr = columns.getValue("User_Instr")
                        val Nombre_Instr = columns.getValue("Nombre_Instr")
                        val Zona_Instr = columns.getValue("Zona_Instr")
                        val Issuper_Instr = columns.getValue("Issuper_Instr")
                        val Idvehiculo_Instr = columns.getValue("Idvehiculo_Instr")
                        val Idmovil_Instr = columns.getValue("Idmovil_Instr")
                        val Pass_Instr = columns.getValue("Pass_Instr")

                        instructor = Instructor(ID_Instr.toString().toInt(),
                                User_Instr.toString(),
                                Nombre_Instr.toString(),
                                Zona_Instr.toString().toInt(),
                                Issuper_Instr.toString().toInt(),
                                Idvehiculo_Instr.toString().toInt(),
                                Idmovil_Instr.toString().toInt(),
                                Pass_Instr.toString())

                        return instructor!!
                    }
                })

        instructor!!
    }

    fun insert_Instructores(instr: Instructor) = context.database.use {
        insert("AA_Instructores",
                "ID_Inst" to instr.ID_Instr,
                "User_Instr" to instr.User_Instr,
                "Nombre_Instr" to instr.Nombre_Instr,
                "Zona_Instr" to instr.Zona_Instr,
                "Issuper_Instr" to instr.Issuper_Instr,
                "Idvehiculo_Instr" to instr.Idvehiculo_Instr,
                "Idmovil_Instr" to instr.Idmovil_Instr,
                "Pass_Instr" to instr.Pass_Instr
        )
    }

    fun delete_Instructores() = context.database.use {
        delete("AA_Instructores")
    }

    fun select_MaeSocios(): ArrayList<MaeSocio> = context.database.use {
        val maesocios = ArrayList<MaeSocio>()

        select("AA_MaeSocios", "ID_Soc", "FET_Soc", "Nombre_Soc", "Kilos_Soc", "Domicilio_Soc", "Localidad_Soc", "Telefono_Soc")
                .parseList(object : MapRowParser<List<MaeSocio>> {
                    override fun parseRow(columns: Map<String, Any?>): List<MaeSocio> {
                        val ID_Soc = columns.getValue("ID_Soc")
                        val FET_Soc = columns.getValue("FET_Soc")
                        val Nombre_Soc = columns.getValue("Nombre_Soc")
                        val Kilos_Soc = columns.getValue("Kilos_Soc")
                        val Domicilio_Soc = columns.getValue("Domicilio_Soc")
                        val Localidad_Soc = columns.getValue("Localidad_Soc")
                        val Telefono_Soc = columns.getValue("Telefono_Soc")

                        val maesocio = MaeSocio(ID_Soc.toString().toInt(),
                                FET_Soc.toString().toInt(),
                                Nombre_Soc.toString(),
                                Kilos_Soc.toString().toInt(),
                                Domicilio_Soc.toString(),
                                Localidad_Soc.toString(),
                                Telefono_Soc.toString()
                        )

                        maesocios.add(maesocio)

                        return maesocios
                    }
                })

        maesocios
    }

    fun select_MaeSocio(id_socio:Int): MaeSocio = context.database.use {

        var maesocio: MaeSocio? = null

        select("AA_MaeSocios")
                .where("(ID_Soc = {id})",
                        "id" to id_socio)
                .parseOpt(object : MapRowParser<MaeSocio> {
                    override fun parseRow(columns: Map<String, Any?>): MaeSocio {
                        val ID_Soc = columns.getValue("ID_Soc")
                        val FET_Soc = columns.getValue("FET_Soc")
                        val Nombre_Soc = columns.getValue("Nombre_Soc")
                        val Kilos_Soc = columns.getValue("Kilos_Soc")
                        val Domicilio_Soc = columns.getValue("Domicilio_Soc")
                        val Localidad_Soc = columns.getValue("Localidad_Soc")
                        val Telefono_Soc = columns.getValue("Telefono_Soc")

                        maesocio = MaeSocio(
                                ID_Soc.toString().toInt(),
                                FET_Soc.toString().toInt(),
                                Nombre_Soc.toString(),
                                Kilos_Soc.toString().toInt(),
                                Domicilio_Soc.toString(),
                                Localidad_Soc.toString(),
                                Telefono_Soc.toString())

                        return maesocio!!
                    }
                })
        maesocio!!
    }

    fun delete_MaeSocios() = context.database.use {
        delete("AA_MaeSocios")
    }


    fun select_FGenerales(): ArrayList<FichaGeneral> = context.database.use {
        val fichasgrales = ArrayList<FichaGeneral>()

        select("AA_FichasGenerales")
                .parseList(object : MapRowParser<List<FichaGeneral>> {
                    override fun parseRow(columns: Map<String, Any?>): List<FichaGeneral> {
                        val ID_Ficha = columns.getValue("ID_Ficha")
                        val Fecha_Grales= columns.getValue("Fecha_Grales")
                        val ID_Camp = columns.getValue("ID_Camp")
                        val ID_Soc = columns.getValue("ID_Soc")
                        val Fet_Soc = columns.getValue("Fet_Soc")
                        val ID_Instr = columns.getValue("ID_Instr")
                        val Finca_Soc = columns.getValue("Finca_Soc")
                        val Local_Soc = columns.getValue("Local_Soc")
                        val Coord_Soc = columns.getValue("Coord_Soc")
                        val Zona_Soc = columns.getValue("Zona_Soc")
                        val ToSincro = columns.getValue("ToSincro")

                        val Grado_RiesgoAPC = columns.getValue("Grado_RiesgoAPC")
                        val Nombre_RiesgoAPC = columns.getValue("Nombre_RiesgoAPC")
                        val Agro_Has_Propias = columns.getValue("Agro_Has_Propias")
                        val Agro_Has_Arren = columns.getValue("Agro_Has_Arren")
                        val Agro_Has_Tot = columns.getValue("Agro_Has_Tot")
                        val Agro_Cat_DTR = columns.getValue("Agro_Cat_DTR")
                        val Agro_Verdeos_Has = columns.getValue("Agro_Verdeos_Has")
                        val Agro_Rot_Has = columns.getValue("Agro_Rot_Has")
                        val Agro_Dep_APC = columns.getValue("Agro_Dep_APC")
                        val Agro_Cumple_Rec = columns.getValue("Agro_Cumple_Rec")
                        val Agro_MangaRiego_Has = columns.getValue("Agro_MangaRiego_Has")
                        val Agro_Suelo_N = columns.getValue("Agro_Suelo_N")
                        val Agro_Suelo_NUd = columns.getValue("Agro_Suelo_NUd")
                        val Agro_Suelo_P = columns.getValue("Agro_Suelo_P")
                        val Agro_Suelo_PUd = columns.getValue("Agro_Suelo_PUd")
                        val Agro_Suelo_K = columns.getValue("Agro_Suelo_K")
                        val Agro_Suelo_KUd = columns.getValue("Agro_Suelo_KUd")
                        val Agro_Suelo_MO = columns.getValue("Agro_Suelo_MO")
                        val Agro_Suelo_MOUd = columns.getValue("Agro_Suelo_MOUd")
                        val Agro_Suelo_PH = columns.getValue("Agro_Suelo_PH")
                        val Agro_Agua_CE = columns.getValue("Agro_Agua_CE")
                        val Agro_Agua_CEUd = columns.getValue("Agro_Agua_CEUd")
                        val Agro_Agua_Carb = columns.getValue("Agro_Agua_Carb")
                        val Agro_Agua_CarbUd = columns.getValue("Agro_Agua_CarbUd")
                        val Agro_Agua_PH = columns.getValue("Agro_Agua_PH")
                        val Agro_Obs = columns.getValue("Agro_Obs")
                        val Infra_Cumple_Rec = columns.getValue("Infra_Cumple_Rec")
                        val Infra_Posee_Galp = columns.getValue("Infra_Posee_Galp")
                        val Infra_Galpon_m3 = columns.getValue("Infra_Galpon_m3")
                        val Infra_Total_Canas = columns.getValue("Infra_Total_Canas")
                        val Infra_HasEstuf = columns.getValue("Infra_HasEstuf")
                        val Infra_Obs = columns.getValue("Infra_Obs")
                        val Infra_Est_Conv = columns.getValue("Infra_Est_Conv")
                        val Infra_Conv_Gas = columns.getValue("Infra_Conv_Gas")
                        val Infra_Conv_Gas_CI = columns.getValue("Infra_Conv_Gas_CI")
                        val Infra_Conv_Gas_SI = columns.getValue("Infra_Conv_Gas_SI")
                        val Infra_Conv_Gas_Canas = columns.getValue("Infra_Conv_Gas_Canas")
                        val Infra_Conv_Gas_Perchas = columns.getValue("Infra_Conv_Gas_Perchas")
                        val Infra_Conv_Lena = columns.getValue("Infra_Conv_Lena")
                        val Infra_Conv_Lena_Perchas = columns.getValue("Infra_Conv_Lena_Perchas")
                        val Infra_Conv_Lena_Canas = columns.getValue("Infra_Conv_Lena_Canas")
                        val Infra_Bulk_Cur = columns.getValue("Infra_Bulk_Cur")
                        val Infra_BC_Gas = columns.getValue("Infra_BC_Gas")
                        val Infra_BC_Gas_CI = columns.getValue("Infra_BC_Gas_CI")
                        val Infra_BC_Gas_SI = columns.getValue("Infra_BC_Gas_SI")
                        val Infra_BC_Gas_Peines = columns.getValue("Infra_BC_Gas_Peines")
                        val Infra_BC_Lena = columns.getValue("Infra_BC_Lena")
                        val Infra_BC_Lena_CI = columns.getValue("Infra_BC_Lena_CI")
                        val Infra_BC_Lena_Peines = columns.getValue("Infra_BC_Lena_Peines")

                        val fichagral = FichaGeneral(ID_Ficha.toString().toInt(),
                                Fecha_Grales.toString(),
                                ID_Camp.toString().toInt(),
                                ID_Soc.toString().toInt(),
                                Fet_Soc.toString().toInt(),
                                ID_Instr.toString().toInt(),
                                Finca_Soc.toString(),
                                Local_Soc.toString(),
                                Coord_Soc.toString(),
                                Zona_Soc.toString().toInt(),
                                ToSincro.toString().toInt(),
                                Grado_RiesgoAPC.toString().toInt(),
                                        Nombre_RiesgoAPC.toString(),
                                        Agro_Has_Propias.toString().toInt(),
                                        Agro_Has_Arren.toString().toInt(),
                                        Agro_Has_Tot.toString().toInt(),
                                        Agro_Cat_DTR.toString().toInt(),
                                        Agro_Verdeos_Has.toString().toInt(),
                                        Agro_Rot_Has.toString().toInt(),
                                        Agro_Dep_APC.toString().toInt(),
                                        Agro_Cumple_Rec.toString().toInt(),
                                        Agro_MangaRiego_Has.toString().toInt(),
                                        Agro_Suelo_N.toString().toFloat(),
                                        Agro_Suelo_NUd.toString(),
                                        Agro_Suelo_P.toString().toFloat(),
                                        Agro_Suelo_PUd.toString(),
                                        Agro_Suelo_K.toString().toFloat(),
                                        Agro_Suelo_KUd.toString(),
                                        Agro_Suelo_MO.toString().toFloat(),
                                        Agro_Suelo_MOUd.toString(),
                                        Agro_Suelo_PH.toString().toFloat(),
                                        Agro_Agua_CE.toString().toFloat(),
                                        Agro_Agua_CEUd.toString(),
                                        Agro_Agua_Carb.toString().toFloat(),
                                        Agro_Agua_CarbUd.toString(),
                                        Agro_Agua_PH.toString().toFloat(),
                                        Agro_Obs.toString(),
                                        Infra_Cumple_Rec.toString().toInt(),
                                        Infra_Posee_Galp.toString().toInt(),
                                        Infra_Galpon_m3.toString().toInt(),
                                        Infra_Total_Canas.toString().toInt(),
                                        Infra_HasEstuf.toString().toInt(),
                                        Infra_Obs.toString(),
                                        Infra_Est_Conv.toString().toInt(),
                                        Infra_Conv_Gas.toString().toInt(),
                                        Infra_Conv_Gas_CI.toString().toInt(),
                                        Infra_Conv_Gas_SI.toString().toInt(),
                                        Infra_Conv_Gas_Canas.toString().toInt(),
                                        Infra_Conv_Gas_Perchas.toString().toInt(),
                                        Infra_Conv_Lena.toString().toInt(),
                                        Infra_Conv_Lena_Perchas.toString().toInt(),
                                        Infra_Conv_Lena_Canas.toString().toInt(),
                                        Infra_Bulk_Cur.toString().toInt(),
                                        Infra_BC_Gas.toString().toInt(),
                                        Infra_BC_Gas_CI.toString().toInt(),
                                        Infra_BC_Gas_SI.toString().toInt(),
                                        Infra_BC_Gas_Peines.toString().toInt(),
                                        Infra_BC_Lena.toString().toInt(),
                                        Infra_BC_Lena_CI.toString().toInt(),
                                        Infra_BC_Lena_Peines.toString().toInt()
                        )

                        fichasgrales.add(fichagral)

                        return fichasgrales
                    }
                })

        fichasgrales
    }
    fun select_FGeneralesToSincro(): ArrayList<FichaGeneral> = context.database.use {
        val fichasgrales = ArrayList<FichaGeneral>()

        select("AA_FichasGenerales")
                .where("(ToSincro = {num})",
                        "num" to 1)
                .parseList(object : MapRowParser<List<FichaGeneral>> {
                    override fun parseRow(columns: Map<String, Any?>): List<FichaGeneral> {
                        val ID_Ficha = columns.getValue("ID_Ficha")
                        val Fecha_Grales= columns.getValue("Fecha_Grales")
                        val ID_Camp = columns.getValue("ID_Camp")
                        val ID_Soc = columns.getValue("ID_Soc")
                        val Fet_Soc = columns.getValue("Fet_Soc")
                        val ID_Instr = columns.getValue("ID_Instr")
                        val Finca_Soc = columns.getValue("Finca_Soc")
                        val Local_Soc = columns.getValue("Local_Soc")
                        val Coord_Soc = columns.getValue("Coord_Soc")
                        val Zona_Soc = columns.getValue("Zona_Soc")
                        val ToSincro = columns.getValue("ToSincro")
                        val Grado_RiesgoAPC = columns.getValue("Grado_RiesgoAPC")
                        val Nombre_RiesgoAPC = columns.getValue("Nombre_RiesgoAPC")
                        val Agro_Has_Propias = columns.getValue("Agro_Has_Propias")
                        val Agro_Has_Arren = columns.getValue("Agro_Has_Arren")
                        val Agro_Has_Tot = columns.getValue("Agro_Has_Tot")
                        val Agro_Cat_DTR = columns.getValue("Agro_Cat_DTR")
                        val Agro_Verdeos_Has = columns.getValue("Agro_Verdeos_Has")
                        val Agro_Rot_Has = columns.getValue("Agro_Rot_Has")
                        val Agro_Dep_APC = columns.getValue("Agro_Dep_APC")
                        val Agro_Cumple_Rec = columns.getValue("Agro_Cumple_Rec")
                        val Agro_MangaRiego_Has = columns.getValue("Agro_MangaRiego_Has")
                        val Agro_Suelo_N = columns.getValue("Agro_Suelo_N")
                        val Agro_Suelo_NUd = columns.getValue("Agro_Suelo_NUd")
                        val Agro_Suelo_P = columns.getValue("Agro_Suelo_P")
                        val Agro_Suelo_PUd = columns.getValue("Agro_Suelo_PUd")
                        val Agro_Suelo_K = columns.getValue("Agro_Suelo_K")
                        val Agro_Suelo_KUd = columns.getValue("Agro_Suelo_KUd")
                        val Agro_Suelo_MO = columns.getValue("Agro_Suelo_MO")
                        val Agro_Suelo_MOUd = columns.getValue("Agro_Suelo_MOUd")
                        val Agro_Suelo_PH = columns.getValue("Agro_Suelo_PH")
                        val Agro_Agua_CE = columns.getValue("Agro_Agua_CE")
                        val Agro_Agua_CEUd = columns.getValue("Agro_Agua_CEUd")
                        val Agro_Agua_Carb = columns.getValue("Agro_Agua_Carb")
                        val Agro_Agua_CarbUd = columns.getValue("Agro_Agua_CarbUd")
                        val Agro_Agua_PH = columns.getValue("Agro_Agua_PH")
                        val Agro_Obs = columns.getValue("Agro_Obs")
                        val Infra_Cumple_Rec = columns.getValue("Infra_Cumple_Rec")
                        val Infra_Posee_Galp = columns.getValue("Infra_Posee_Galp")
                        val Infra_Galpon_m3 = columns.getValue("Infra_Galpon_m3")
                        val Infra_Total_Canas = columns.getValue("Infra_Total_Canas")
                        val Infra_HasEstuf = columns.getValue("Infra_HasEstuf")
                        val Infra_Obs = columns.getValue("Infra_Obs")
                        val Infra_Est_Conv = columns.getValue("Infra_Est_Conv")
                        val Infra_Conv_Gas = columns.getValue("Infra_Conv_Gas")
                        val Infra_Conv_Gas_CI = columns.getValue("Infra_Conv_Gas_CI")
                        val Infra_Conv_Gas_SI = columns.getValue("Infra_Conv_Gas_SI")
                        val Infra_Conv_Gas_Canas = columns.getValue("Infra_Conv_Gas_Canas")
                        val Infra_Conv_Gas_Perchas = columns.getValue("Infra_Conv_Gas_Perchas")
                        val Infra_Conv_Lena = columns.getValue("Infra_Conv_Lena")
                        val Infra_Conv_Lena_Perchas = columns.getValue("Infra_Conv_Lena_Perchas")
                        val Infra_Conv_Lena_Canas = columns.getValue("Infra_Conv_Lena_Canas")
                        val Infra_Bulk_Cur = columns.getValue("Infra_Bulk_Cur")
                        val Infra_BC_Gas = columns.getValue("Infra_BC_Gas")
                        val Infra_BC_Gas_CI = columns.getValue("Infra_BC_Gas_CI")
                        val Infra_BC_Gas_SI = columns.getValue("Infra_BC_Gas_SI")
                        val Infra_BC_Gas_Peines = columns.getValue("Infra_BC_Gas_Peines")
                        val Infra_BC_Lena = columns.getValue("Infra_BC_Lena")
                        val Infra_BC_Lena_CI = columns.getValue("Infra_BC_Lena_CI")
                        val Infra_BC_Lena_Peines = columns.getValue("Infra_BC_Lena_Peines")

                        var grado_riesgoapc:Int?
                        grado_riesgoapc = null
                        if(Grado_RiesgoAPC != null){ grado_riesgoapc = Grado_RiesgoAPC.toString().toInt() }

                        var agro_has_propias:Int?
                        agro_has_propias = null
                        if(Agro_Has_Propias != null){ agro_has_propias = Agro_Has_Propias.toString().toInt() }

                        var agro_has_arren:Int?
                        agro_has_arren = null
                        if(Agro_Has_Arren != null){ agro_has_arren = Agro_Has_Arren.toString().toInt() }
                        var agro_has_tot:Int?
                        agro_has_tot = null
                        if(Agro_Has_Tot != null){ agro_has_tot = Agro_Has_Tot.toString().toInt() }
                        var agro_cat_dtr:Int?
                        agro_cat_dtr = null
                        if(Agro_Cat_DTR != null){ agro_cat_dtr = Agro_Cat_DTR.toString().toInt() }
                        var agro_verdeos_has:Int?
                        agro_verdeos_has = null
                        if(Agro_Verdeos_Has != null){ agro_verdeos_has = Agro_Verdeos_Has.toString().toInt() }
                        var agro_rot_has:Int?
                        agro_rot_has = null
                        if(Agro_Rot_Has != null){ agro_rot_has = Agro_Rot_Has.toString().toInt() }
                        var agro_dep_apc:Int?
                        agro_dep_apc = null
                        if(Agro_Dep_APC != null){ agro_dep_apc = Agro_Dep_APC.toString().toInt() }
                        var agro_cumple_rec:Int?
                        agro_cumple_rec = null
                        if(Agro_Cumple_Rec != null){ agro_cumple_rec = Agro_Cumple_Rec.toString().toInt() }
                        var agro_mangariego_has:Int?
                        agro_mangariego_has = null
                        if(Agro_MangaRiego_Has != null){ agro_mangariego_has = Agro_MangaRiego_Has.toString().toInt() }
                        var agro_suelo_n:Float?
                        agro_suelo_n = null
                        if(Agro_Suelo_N != null){ agro_suelo_n = Agro_Suelo_N.toString().toFloat() }
                        var agro_suelo_p:Float?
                        agro_suelo_p = null
                        if(Agro_Suelo_P != null){ agro_suelo_p = Agro_Suelo_P.toString().toFloat() }
                        var agro_suelo_k:Float?
                        agro_suelo_k = null
                        if(Agro_Suelo_K != null){ agro_suelo_k = Agro_Suelo_K.toString().toFloat() }
                        var agro_suelo_mo:Float?
                        agro_suelo_mo = null
                        if(Agro_Suelo_MO != null){ agro_suelo_mo = Agro_Suelo_MO.toString().toFloat() }
                        var agro_suelo_ph:Float?
                        agro_suelo_ph = null
                        if(Agro_Suelo_PH != null){ agro_suelo_ph = Agro_Suelo_PH.toString().toFloat() }
                        var agro_agua_ce:Float?
                        agro_agua_ce = null
                        if(Agro_Agua_CE != null){ agro_agua_ce = Agro_Agua_CE.toString().toFloat() }
                        var agro_agua_carb:Float?
                        agro_agua_carb = null
                        if(Agro_Agua_Carb != null){ agro_agua_carb = Agro_Agua_Carb.toString().toFloat() }
                        var agro_agua_ph:Float?
                        agro_agua_ph = null
                        if(Agro_Agua_PH != null){ agro_agua_ph = Agro_Agua_PH.toString().toFloat() }

                        var infra_cumple_rec:Int?
                        infra_cumple_rec = null
                        if(Infra_Cumple_Rec != null){ infra_cumple_rec = Infra_Cumple_Rec.toString().toInt() }
                        var infra_posee_galp:Int?
                        infra_posee_galp = null
                        if(Infra_Posee_Galp != null){ infra_posee_galp = Infra_Posee_Galp.toString().toInt() }
                        var infra_galpon_m3:Int?
                        infra_galpon_m3 = null
                        if(Infra_Galpon_m3 != null){ infra_galpon_m3 = Infra_Galpon_m3.toString().toInt() }
                        var infra_total_canas:Int?
                        infra_total_canas = null
                        if(Infra_Total_Canas != null){ infra_total_canas = Infra_Total_Canas.toString().toInt() }
                        var infra_hasestuf:Int?
                        infra_hasestuf = null
                        if(Infra_HasEstuf != null){ infra_hasestuf = Infra_HasEstuf.toString().toInt() }
                        var infra_est_conv:Int?
                        infra_est_conv = null
                        if(Infra_Est_Conv != null){ infra_est_conv = Infra_Est_Conv.toString().toInt() }
                        var infra_conv_gas:Int?
                        infra_conv_gas = null
                        if(Infra_Conv_Gas != null){ infra_conv_gas = Infra_Conv_Gas.toString().toInt() }
                        var infra_conv_gas_ci:Int?
                        infra_conv_gas_ci = null
                        if(Infra_Conv_Gas_CI != null){ infra_conv_gas_ci = Infra_Conv_Gas_CI.toString().toInt() }
                        var infra_conv_gas_si:Int?
                        infra_conv_gas_si = null
                        if(Infra_Conv_Gas_SI != null){ infra_conv_gas_si = Infra_Conv_Gas_SI.toString().toInt() }
                        var infra_conv_gas_canas:Int?
                        infra_conv_gas_canas = null
                        if(Infra_Conv_Gas_Canas!= null){ infra_conv_gas_canas = Infra_Conv_Gas_Canas.toString().toInt() }
                        var infra_conv_gas_perchas:Int?
                        infra_conv_gas_perchas = null
                        if(Infra_Conv_Gas_Perchas != null){ infra_conv_gas_perchas = Infra_Conv_Gas_Perchas.toString().toInt() }
                        var infra_conv_lena:Int?
                        infra_conv_lena = null
                        if(Infra_Conv_Lena != null){ infra_conv_lena = Infra_Conv_Lena.toString().toInt() }
                        var infra_conv_lena_perchas:Int?
                        infra_conv_lena_perchas = null
                        if(Infra_Conv_Lena_Perchas != null){ infra_conv_lena_perchas = Infra_Conv_Lena_Perchas.toString().toInt() }
                        var infra_conv_lena_canas:Int?
                        infra_conv_lena_canas = null
                        if(Infra_Conv_Lena_Canas != null){ infra_conv_lena_canas = Infra_Conv_Lena_Canas.toString().toInt() }
                        var infra_bulk_cur:Int?
                        infra_bulk_cur = null
                        if(Infra_Bulk_Cur != null){ infra_bulk_cur = Infra_Bulk_Cur.toString().toInt() }
                        var infra_bc_gas:Int?
                        infra_bc_gas = null
                        if(Infra_BC_Gas != null){ infra_bc_gas = Infra_BC_Gas.toString().toInt() }
                        var infra_bc_gas_ci:Int?
                        infra_bc_gas_ci = null
                        if(Infra_BC_Gas_CI != null){ infra_bc_gas_ci = Infra_BC_Gas_CI.toString().toInt() }
                        var infra_bc_gas_si:Int?
                        infra_bc_gas_si = null
                        if(Infra_BC_Gas_SI != null){ infra_bc_gas_si = Infra_BC_Gas_SI.toString().toInt() }
                        var infra_bc_gas_peines:Int?
                        infra_bc_gas_peines = null
                        if(Infra_BC_Gas_Peines!= null){ infra_bc_gas_peines = Infra_BC_Gas_Peines.toString().toInt() }
                        var infra_bc_lena:Int?
                        infra_bc_lena = null
                        if(Infra_BC_Lena != null){ infra_bc_lena = Infra_BC_Lena.toString().toInt() }
                        var infra_bc_lena_ci:Int?
                        infra_bc_lena_ci = null
                        if(Infra_BC_Lena_CI != null){ infra_bc_lena_ci = Infra_BC_Lena_CI.toString().toInt() }
                        var infra_bc_lena_peines:Int?
                        infra_bc_lena_peines = null
                        if(Infra_BC_Lena_Peines!= null){ infra_bc_lena_peines = Infra_BC_Lena_Peines.toString().toInt() }

                        val fichaGeneral = FichaGeneral(ID_Ficha.toString().toInt(),
                                Fecha_Grales.toString(),
                                ID_Camp.toString().toInt(),
                                ID_Soc.toString().toInt(),
                                Fet_Soc.toString().toInt(),
                                ID_Instr.toString().toInt(),
                                Finca_Soc.toString(),
                                Local_Soc.toString(),
                                Coord_Soc.toString(),
                                Zona_Soc.toString().toInt(),
                                ToSincro.toString().toInt(),

                                grado_riesgoapc,

                                Nombre_RiesgoAPC.toString(),
                                agro_has_propias,
                                agro_has_arren,
                                agro_has_tot,
                                agro_cat_dtr,
                                agro_verdeos_has,
                                agro_rot_has,
                                agro_dep_apc,
                                agro_cumple_rec,
                                agro_mangariego_has,
                                agro_suelo_n,

                                Agro_Suelo_NUd.toString(),

                                agro_suelo_p,

                                Agro_Suelo_PUd.toString(),

                                agro_suelo_k,

                                Agro_Suelo_KUd.toString(),

                                agro_suelo_mo,

                                Agro_Suelo_MOUd.toString(),

                                agro_suelo_ph,
                                agro_agua_ce,

                                Agro_Agua_CEUd.toString(),

                                agro_agua_carb,
                                Agro_Agua_CarbUd.toString(),
                                agro_agua_ph,

                                Agro_Obs.toString(),

                                infra_cumple_rec,
                                infra_posee_galp,
                                infra_galpon_m3,
                                infra_total_canas,
                                infra_hasestuf,

                                Infra_Obs.toString(),

                                infra_est_conv,
                                infra_conv_gas,
                                infra_conv_gas_ci,
                                infra_conv_gas_si,
                                infra_conv_gas_canas,
                                infra_conv_gas_perchas,
                                infra_conv_lena,
                                infra_conv_lena_perchas,
                                infra_conv_lena_canas,
                                infra_bulk_cur,
                                infra_bc_gas,
                                infra_bc_gas_ci,
                                infra_bc_gas_si,
                                infra_bc_gas_peines,
                                infra_bc_lena,
                                infra_bc_lena_ci,
                                infra_bc_lena_peines
                        )

                        fichasgrales.add(fichaGeneral)

                        return fichasgrales
                    }
                })

        fichasgrales
    }

    fun select_FGenerales(id_socio:Int): FichaGeneral? = context.database.use {

        var fichaGeneral: FichaGeneral? = null

        select("AA_FichasGenerales")
                .where("(ID_Soc = {id})",
                        "id" to id_socio)
                .parseOpt(object : MapRowParser<FichaGeneral> {
                    override fun parseRow(columns: Map<String, Any?>): FichaGeneral {
                        val ID_Ficha = columns.getValue("ID_Ficha")
                        val Fecha_Grales= columns.getValue("Fecha_Grales")
                        val ID_Camp = columns.getValue("ID_Camp")
                        val ID_Soc = columns.getValue("ID_Soc")
                        val Fet_Soc = columns.getValue("Fet_Soc")
                        val ID_Instr = columns.getValue("ID_Instr")
                        val Finca_Soc = columns.getValue("Finca_Soc")
                        val Local_Soc = columns.getValue("Local_Soc")
                        val Coord_Soc = columns.getValue("Coord_Soc")
                        val Zona_Soc = columns.getValue("Zona_Soc")
                        val ToSincro = columns.getValue("ToSincro")
                        val Grado_RiesgoAPC = columns.getValue("Grado_RiesgoAPC")
                        val Nombre_RiesgoAPC = columns.getValue("Nombre_RiesgoAPC")
                        val Agro_Has_Propias = columns.getValue("Agro_Has_Propias")
                        val Agro_Has_Arren = columns.getValue("Agro_Has_Arren")
                        val Agro_Has_Tot = columns.getValue("Agro_Has_Tot")
                        val Agro_Cat_DTR = columns.getValue("Agro_Cat_DTR")
                        val Agro_Verdeos_Has = columns.getValue("Agro_Verdeos_Has")
                        val Agro_Rot_Has = columns.getValue("Agro_Rot_Has")
                        val Agro_Dep_APC = columns.getValue("Agro_Dep_APC")
                        val Agro_Cumple_Rec = columns.getValue("Agro_Cumple_Rec")
                        val Agro_MangaRiego_Has = columns.getValue("Agro_MangaRiego_Has")
                        val Agro_Suelo_N = columns.getValue("Agro_Suelo_N")
                        val Agro_Suelo_NUd = columns.getValue("Agro_Suelo_NUd")
                        val Agro_Suelo_P = columns.getValue("Agro_Suelo_P")
                        val Agro_Suelo_PUd = columns.getValue("Agro_Suelo_PUd")
                        val Agro_Suelo_K = columns.getValue("Agro_Suelo_K")
                        val Agro_Suelo_KUd = columns.getValue("Agro_Suelo_KUd")
                        val Agro_Suelo_MO = columns.getValue("Agro_Suelo_MO")
                        val Agro_Suelo_MOUd = columns.getValue("Agro_Suelo_MOUd")
                        val Agro_Suelo_PH = columns.getValue("Agro_Suelo_PH")
                        val Agro_Agua_CE = columns.getValue("Agro_Agua_CE")
                        val Agro_Agua_CEUd = columns.getValue("Agro_Agua_CEUd")
                        val Agro_Agua_Carb = columns.getValue("Agro_Agua_Carb")
                        val Agro_Agua_CarbUd = columns.getValue("Agro_Agua_CarbUd")
                        val Agro_Agua_PH = columns.getValue("Agro_Agua_PH")
                        val Agro_Obs = columns.getValue("Agro_Obs")
                        val Infra_Cumple_Rec = columns.getValue("Infra_Cumple_Rec")
                        val Infra_Posee_Galp = columns.getValue("Infra_Posee_Galp")
                        val Infra_Galpon_m3 = columns.getValue("Infra_Galpon_m3")
                        val Infra_Total_Canas = columns.getValue("Infra_Total_Canas")
                        val Infra_HasEstuf = columns.getValue("Infra_HasEstuf")
                        val Infra_Obs = columns.getValue("Infra_Obs")
                        val Infra_Est_Conv = columns.getValue("Infra_Est_Conv")
                        val Infra_Conv_Gas = columns.getValue("Infra_Conv_Gas")
                        val Infra_Conv_Gas_CI = columns.getValue("Infra_Conv_Gas_CI")
                        val Infra_Conv_Gas_SI = columns.getValue("Infra_Conv_Gas_SI")
                        val Infra_Conv_Gas_Canas = columns.getValue("Infra_Conv_Gas_Canas")
                        val Infra_Conv_Gas_Perchas = columns.getValue("Infra_Conv_Gas_Perchas")
                        val Infra_Conv_Lena = columns.getValue("Infra_Conv_Lena")
                        val Infra_Conv_Lena_Perchas = columns.getValue("Infra_Conv_Lena_Perchas")
                        val Infra_Conv_Lena_Canas = columns.getValue("Infra_Conv_Lena_Canas")
                        val Infra_Bulk_Cur = columns.getValue("Infra_Bulk_Cur")
                        val Infra_BC_Gas = columns.getValue("Infra_BC_Gas")
                        val Infra_BC_Gas_CI = columns.getValue("Infra_BC_Gas_CI")
                        val Infra_BC_Gas_SI = columns.getValue("Infra_BC_Gas_SI")
                        val Infra_BC_Gas_Peines = columns.getValue("Infra_BC_Gas_Peines")
                        val Infra_BC_Lena = columns.getValue("Infra_BC_Lena")
                        val Infra_BC_Lena_CI = columns.getValue("Infra_BC_Lena_CI")
                        val Infra_BC_Lena_Peines = columns.getValue("Infra_BC_Lena_Peines")

                        var grado_riesgoapc:Int?
                        grado_riesgoapc = null
                        if(Grado_RiesgoAPC != null){ grado_riesgoapc = Grado_RiesgoAPC.toString().toInt() }

                        var agro_has_propias:Int?
                        agro_has_propias = null
                        if(Agro_Has_Propias != null){ agro_has_propias = Agro_Has_Propias.toString().toInt() }
                        var agro_has_arren:Int?
                        agro_has_arren = null
                        if(Agro_Has_Arren != null){ agro_has_arren = Agro_Has_Arren.toString().toInt() }
                        var agro_has_tot:Int?
                        agro_has_tot = null
                        if(Agro_Has_Tot != null){ agro_has_tot = Agro_Has_Tot.toString().toInt() }
                        var agro_cat_dtr:Int?
                        agro_cat_dtr = null
                        if(Agro_Cat_DTR != null){ agro_cat_dtr = Agro_Cat_DTR.toString().toInt() }
                        var agro_verdeos_has:Int?
                        agro_verdeos_has = null
                        if(Agro_Verdeos_Has != null){ agro_verdeos_has = Agro_Verdeos_Has.toString().toInt() }
                        var agro_rot_has:Int?
                        agro_rot_has = null
                        if(Agro_Rot_Has != null){ agro_rot_has = Agro_Rot_Has.toString().toInt() }
                        var agro_dep_apc:Int?
                        agro_dep_apc = null
                        if(Agro_Dep_APC != null){ agro_dep_apc = Agro_Dep_APC.toString().toInt() }
                        var agro_cumple_rec:Int?
                        agro_cumple_rec = null
                        if(Agro_Cumple_Rec != null){ agro_cumple_rec = Agro_Cumple_Rec.toString().toInt() }
                        var agro_mangariego_has:Int?
                        agro_mangariego_has = null
                        if(Agro_MangaRiego_Has != null){ agro_mangariego_has = Agro_MangaRiego_Has.toString().toInt() }
                        var agro_suelo_n:Float?
                        agro_suelo_n = null
                        if(Agro_Suelo_N != null){ agro_suelo_n = Agro_Suelo_N.toString().toFloat() }
                        var agro_suelo_p:Float?
                        agro_suelo_p = null
                        if(Agro_Suelo_P != null){ agro_suelo_p = Agro_Suelo_P.toString().toFloat() }
                        var agro_suelo_k:Float?
                        agro_suelo_k = null
                        if(Agro_Suelo_K != null){ agro_suelo_k = Agro_Suelo_K.toString().toFloat() }
                        var agro_suelo_mo:Float?
                        agro_suelo_mo = null
                        if(Agro_Suelo_MO != null){ agro_suelo_mo = Agro_Suelo_MO.toString().toFloat() }
                        var agro_suelo_ph:Float?
                        agro_suelo_ph = null
                        if(Agro_Suelo_PH != null){ agro_suelo_ph = Agro_Suelo_PH.toString().toFloat() }
                        var agro_agua_ce:Float?
                        agro_agua_ce = null
                        if(Agro_Agua_CE != null){ agro_agua_ce = Agro_Agua_CE.toString().toFloat() }
                        var agro_agua_carb:Float?
                        agro_agua_carb = null
                        if(Agro_Agua_Carb != null){ agro_agua_carb = Agro_Agua_Carb.toString().toFloat() }
                        var agro_agua_ph:Float?
                        agro_agua_ph = null
                        if(Agro_Agua_PH != null){ agro_agua_ph = Agro_Agua_PH.toString().toFloat() }

                        var infra_cumple_rec:Int?
                        infra_cumple_rec = null
                        if(Infra_Cumple_Rec != null){ infra_cumple_rec = Infra_Cumple_Rec.toString().toInt() }
                        var infra_posee_galp:Int?
                        infra_posee_galp = null
                        if(Infra_Posee_Galp != null){ infra_posee_galp = Infra_Posee_Galp.toString().toInt() }
                        var infra_galpon_m3:Int?
                        infra_galpon_m3 = null
                        if(Infra_Galpon_m3 != null){ infra_galpon_m3 = Infra_Galpon_m3.toString().toInt() }
                        var infra_total_canas:Int?
                        infra_total_canas = null
                        if(Infra_Total_Canas != null){ infra_total_canas = Infra_Total_Canas.toString().toInt() }
                        var infra_hasestuf:Int?
                        infra_hasestuf = null
                        if(Infra_HasEstuf != null){ infra_hasestuf = Infra_HasEstuf.toString().toInt() }
                        var infra_est_conv:Int?
                        infra_est_conv = null
                        if(Infra_Est_Conv != null){ infra_est_conv = Infra_Est_Conv.toString().toInt() }
                        var infra_conv_gas:Int?
                        infra_conv_gas = null
                        if(Infra_Conv_Gas != null){ infra_conv_gas = Infra_Conv_Gas.toString().toInt() }
                        var infra_conv_gas_ci:Int?
                        infra_conv_gas_ci = null
                        if(Infra_Conv_Gas_CI != null){ infra_conv_gas_ci = Infra_Conv_Gas_CI.toString().toInt() }
                        var infra_conv_gas_si:Int?
                        infra_conv_gas_si = null
                        if(Infra_Conv_Gas_SI != null){ infra_conv_gas_si = Infra_Conv_Gas_SI.toString().toInt() }
                        var infra_conv_gas_canas:Int?
                        infra_conv_gas_canas = null
                        if(Infra_Conv_Gas_Canas!= null){ infra_conv_gas_canas = Infra_Conv_Gas_Canas.toString().toInt() }
                        var infra_conv_gas_perchas:Int?
                        infra_conv_gas_perchas = null
                        if(Infra_Conv_Gas_Perchas != null){ infra_conv_gas_perchas = Infra_Conv_Gas_Perchas.toString().toInt() }
                        var infra_conv_lena:Int?
                        infra_conv_lena = null
                        if(Infra_Conv_Lena != null){ infra_conv_lena = Infra_Conv_Lena.toString().toInt() }
                        var infra_conv_lena_perchas:Int?
                        infra_conv_lena_perchas = null
                        if(Infra_Conv_Lena_Perchas != null){ infra_conv_lena_perchas = Infra_Conv_Lena_Perchas.toString().toInt() }
                        var infra_conv_lena_canas:Int?
                        infra_conv_lena_canas = null
                        if(Infra_Conv_Lena_Canas != null){ infra_conv_lena_canas = Infra_Conv_Lena_Canas.toString().toInt() }
                        var infra_bulk_cur:Int?
                        infra_bulk_cur = null
                        if(Infra_Bulk_Cur != null){ infra_bulk_cur = Infra_Bulk_Cur.toString().toInt() }
                        var infra_bc_gas:Int?
                        infra_bc_gas = null
                        if(Infra_BC_Gas != null){ infra_bc_gas = Infra_BC_Gas.toString().toInt() }
                        var infra_bc_gas_ci:Int?
                        infra_bc_gas_ci = null
                        if(Infra_BC_Gas_CI != null){ infra_bc_gas_ci = Infra_BC_Gas_CI.toString().toInt() }
                        var infra_bc_gas_si:Int?
                        infra_bc_gas_si = null
                        if(Infra_BC_Gas_SI != null){ infra_bc_gas_si = Infra_BC_Gas_SI.toString().toInt() }
                        var infra_bc_gas_peines:Int?
                        infra_bc_gas_peines = null
                        if(Infra_BC_Gas_Peines!= null){ infra_bc_gas_peines = Infra_BC_Gas_Peines.toString().toInt() }
                        var infra_bc_lena:Int?
                        infra_bc_lena = null
                        if(Infra_BC_Lena != null){ infra_bc_lena = Infra_BC_Lena.toString().toInt() }
                        var infra_bc_lena_ci:Int?
                        infra_bc_lena_ci = null
                        if(Infra_BC_Lena_CI != null){ infra_bc_lena_ci = Infra_BC_Lena_CI.toString().toInt() }
                        var infra_bc_lena_peines:Int?
                        infra_bc_lena_peines = null
                        if(Infra_BC_Lena_Peines!= null){ infra_bc_lena_peines = Infra_BC_Lena_Peines.toString().toInt() }

                        fichaGeneral = FichaGeneral(ID_Ficha.toString().toInt(),
                                Fecha_Grales.toString(),
                                ID_Camp.toString().toInt(),
                                ID_Soc.toString().toInt(),
                                Fet_Soc.toString().toInt(),
                                ID_Instr.toString().toInt(),
                                Finca_Soc.toString(),
                                Local_Soc.toString(),
                                Coord_Soc.toString(),
                                Zona_Soc.toString().toInt(),
                                ToSincro.toString().toInt(),

                                grado_riesgoapc,

                                Nombre_RiesgoAPC.toString(),
                                agro_has_propias,
                                agro_has_arren,
                                agro_has_tot,
                                agro_cat_dtr,
                                agro_verdeos_has,
                                agro_rot_has,
                                agro_dep_apc,
                                agro_cumple_rec,
                                agro_mangariego_has,
                                agro_suelo_n,

                                Agro_Suelo_NUd.toString(),

                                agro_suelo_p,

                                Agro_Suelo_PUd.toString(),

                                agro_suelo_k,

                                Agro_Suelo_KUd.toString(),

                                agro_suelo_mo,

                                Agro_Suelo_MOUd.toString(),

                                agro_suelo_ph,
                                agro_agua_ce,

                                Agro_Agua_CEUd.toString(),

                                agro_agua_carb,
                                Agro_Agua_CarbUd.toString(),
                                agro_agua_ph,

                                Agro_Obs.toString(),

                                infra_cumple_rec,
                                infra_posee_galp,
                                infra_galpon_m3,
                                infra_total_canas,
                                infra_hasestuf,

                                Infra_Obs.toString(),

                                infra_est_conv,
                                infra_conv_gas,
                                infra_conv_gas_ci,
                                infra_conv_gas_si,
                                infra_conv_gas_canas,
                                infra_conv_gas_perchas,
                                infra_conv_lena,
                                infra_conv_lena_perchas,
                                infra_conv_lena_canas,
                                infra_bulk_cur,
                                infra_bc_gas,
                                infra_bc_gas_ci,
                                infra_bc_gas_si,
                                infra_bc_gas_peines,
                                infra_bc_lena,
                                infra_bc_lena_ci,
                                infra_bc_lena_peines
                        )

                        return fichaGeneral!!
                    }
                })
        //return fichaGeneral!!
    }

    fun delete_FGenerales(id_socio:Int) = context.database.use {
        delete("AA_FichasGenerales", "ID_Soc = {id_socio}", "id_socio" to id_socio)
    }

    fun update_FGenerales(fichageneral: FichaGeneral) = context.database.use {
        update("AA_FichasGenerales",
                "ID_Ficha" to fichageneral.ID_Ficha,
                "Fecha_Grales" to fichageneral.Fecha_Grales,
                "ID_Camp" to fichageneral.ID_Camp,
                "ID_Soc" to fichageneral.ID_Soc,
                "Fet_Soc" to fichageneral.Fet_Soc,
                "ID_Instr" to fichageneral.ID_Instr,
                "Finca_Soc" to fichageneral.Finca_Soc,
                "Local_Soc" to fichageneral.Local_Soc,
                "Coord_Soc" to fichageneral.Coord_Soc,
                "Zona_Soc" to fichageneral.Zona_Soc,
                "ToSincro" to fichageneral.ToSincro
        ).where("ID_Soc = {id_socio}", "id_socio" to fichageneral.ID_Soc)
    }
}


