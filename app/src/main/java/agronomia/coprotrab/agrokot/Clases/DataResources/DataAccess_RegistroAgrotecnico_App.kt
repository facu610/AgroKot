package agronomia.coprotrab.agrokot.Clases.DataResources

import agronomia.coprotrab.agrokot.Clases.Entidades.Instructor
import android.content.Context
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert

import org.jetbrains.anko.db.select

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

    fun delete_Instructores(instr: Instructor) = context.database.use {
        delete("AA_Instructores")
    }
}


