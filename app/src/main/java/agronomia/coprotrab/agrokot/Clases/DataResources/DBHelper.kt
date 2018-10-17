package agronomia.coprotrab.agrokot.Clases.DataResources

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DBHelper (ctx: Context) : ManagedSQLiteOpenHelper(ctx, "RegistroAgrotecnico_App") {

    companion object {
        private var instance: DBHelper? = null
        @Synchronized
        fun getInstance(ctx: Context): DBHelper {
            if (instance == null) {
                instance = DBHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable("AA_MaeSocios", true,
                "ID_Soc" to INTEGER,
                          "FET_Soc" to INTEGER,
                          "Nombre_Soc" to TEXT,
                          "Kilos_Soc" to INTEGER,
                          "Domicilio_Soc" to TEXT,
                          "Localidad_Soc" to TEXT,
                          "Telefono_Soc" to TEXT)

        db.createTable("AA_Instructores", true,
                "ID_Instr" to INTEGER,
                "User_Instr" to TEXT,
                "Nombre_Instr" to TEXT,
                "Zona_Instr" to INTEGER,
                "Issuper_Instr" to INTEGER,
                "Idvehiculo_Instr" to INTEGER,
                "Idmovil_Instr" to INTEGER,
                "Pass_Instr" to TEXT)

        db.createTable("AA_FichasGenerales", true,
                "ID_Ficha" to INTEGER,
                "Fecha_Grales" to TEXT,
                "ID_Camp" to INTEGER,
                "ID_Soc" to INTEGER,
                "Fet_Soc" to INTEGER,
                "ID_Instr" to INTEGER,
                "Finca_Soc" to TEXT,
                "Local_Soc" to TEXT,
                "Coord_Soc" to TEXT,
                "Zona_Soc" to INTEGER,
                "ToSincro" to INTEGER,
                "Grado_RiesgoAPC" to INTEGER,
                "Nombre_RiesgoAPC" to TEXT,
                "Agro_Has_Propias" to INTEGER,
                "Agro_Has_Arren" to INTEGER,
                "Agro_Has_Tot" to INTEGER,
                "Agro_Cat_DTR" to INTEGER,
                "Agro_Verdeos_Has" to INTEGER,
                "Agro_Rot_Has" to INTEGER,
                "Agro_Dep_APC" to INTEGER,
                "Agro_Cumple_Rec" to INTEGER,
                "Agro_MangaRiego_Has" to INTEGER,
                "Agro_Suelo_N" to INTEGER,
                "Agro_Suelo_NUd" to TEXT,
                "Agro_Suelo_P" to INTEGER,
                "Agro_Suelo_PUd" to TEXT,
                "Agro_Suelo_K" to INTEGER,
                "Agro_Suelo_KUd" to TEXT,
                "Agro_Suelo_MO" to INTEGER,
                "Agro_Suelo_MOUd" to TEXT,
                "Agro_Suelo_PH" to INTEGER,
                "Agro_Agua_CE" to INTEGER,
                "Agro_Agua_CEUd" to TEXT,
                "Agro_Agua_Carb" to INTEGER,
                "Agro_Agua_CarbUd" to TEXT,
                "Agro_Agua_PH" to INTEGER,
                "Agro_Obs" to TEXT,
                "Infra_Cumple_Rec" to INTEGER,
                "Infra_Posee_Galp" to INTEGER,
                "Infra_Galpon_m3" to INTEGER,
                "Infra_Total_Canas" to INTEGER,
                "Infra_HasEstuf" to INTEGER,
                "Infra_Obs" to TEXT,
                "Infra_Est_Conv" to INTEGER,
                "Infra_Conv_Gas" to INTEGER,
                "Infra_Conv_Gas_CI" to INTEGER,
                "Infra_Conv_Gas_SI" to INTEGER,
                "Infra_Conv_Gas_Canas" to INTEGER,
                "Infra_Conv_Gas_Perchas" to INTEGER,
                "Infra_Conv_Lena" to INTEGER,
                "Infra_Conv_Lena_Perchas" to INTEGER,
                "Infra_Conv_Lena_Canas" to INTEGER,
                "Infra_Bulk_Cur" to INTEGER,
                "Infra_BC_Gas" to INTEGER,
                "Infra_BC_Gas_CI" to INTEGER,
                "Infra_BC_Gas_SI" to INTEGER,
                "Infra_BC_Gas_Peines" to INTEGER,
                "Infra_BC_Lena" to INTEGER,
                "Infra_BC_Lena_CI" to INTEGER,
                "Infra_BC_Lena_Peines" to INTEGER
        )

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //NOTA: Por simplicidad aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.

        //Se elimina la versión anterior de la tabla
//        db.dropTable("AA_Socios")
//
//        db.createTable("AA_MaeSocios", true,
//                "ID_Soc" to INTEGER + PRIMARY_KEY,
//                "FET_Soc" to INTEGER,
//                "Nombre_Soc" to TEXT,
//                "Kilos_Soc" to INTEGER,
//                "Domicilio_Soc" to TEXT,
//                "Localidad_Soc" to TEXT,
//                "Telefono_Soc" to TEXT)

        }

}

val Context.database: DBHelper
    get() = DBHelper.getInstance(applicationContext)