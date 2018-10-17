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
                                        Agro_Suelo_N.toString().toInt(),
                                        Agro_Suelo_NUd.toString(),
                                        Agro_Suelo_P.toString().toInt(),
                                        Agro_Suelo_PUd.toString(),
                                        Agro_Suelo_K.toString().toInt(),
                                        Agro_Suelo_KUd.toString(),
                                        Agro_Suelo_MO.toString().toInt(),
                                        Agro_Suelo_MOUd.toString(),
                                        Agro_Suelo_PH.toString().toInt(),
                                        Agro_Agua_CE.toString().toInt(),
                                        Agro_Agua_CEUd.toString(),
                                        Agro_Agua_Carb.toString().toInt(),
                                        Agro_Agua_CarbUd.toString(),
                                        Agro_Agua_PH.toString().toInt(),
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
                                Agro_Suelo_N.toString().toInt(),
                                Agro_Suelo_NUd.toString(),
                                Agro_Suelo_P.toString().toInt(),
                                Agro_Suelo_PUd.toString(),
                                Agro_Suelo_K.toString().toInt(),
                                Agro_Suelo_KUd.toString(),
                                Agro_Suelo_MO.toString().toInt(),
                                Agro_Suelo_MOUd.toString(),
                                Agro_Suelo_PH.toString().toInt(),
                                Agro_Agua_CE.toString().toInt(),
                                Agro_Agua_CEUd.toString(),
                                Agro_Agua_Carb.toString().toInt(),
                                Agro_Agua_CarbUd.toString(),
                                Agro_Agua_PH.toString().toInt(),
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
                                Agro_Suelo_N.toString().toInt(),
                                Agro_Suelo_NUd.toString(),
                                Agro_Suelo_P.toString().toInt(),
                                Agro_Suelo_PUd.toString(),
                                Agro_Suelo_K.toString().toInt(),
                                Agro_Suelo_KUd.toString(),
                                Agro_Suelo_MO.toString().toInt(),
                                Agro_Suelo_MOUd.toString(),
                                Agro_Suelo_PH.toString().toInt(),
                                Agro_Agua_CE.toString().toInt(),
                                Agro_Agua_CEUd.toString(),
                                Agro_Agua_Carb.toString().toInt(),
                                Agro_Agua_CarbUd.toString(),
                                Agro_Agua_PH.toString().toInt(),
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


