package agronomia.coprotrab.agrokot.Clases.DataResources

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DBHelper (ctx: Context) : ManagedSQLiteOpenHelper(ctx, "RegistroAgrotecnico_App",null, 193) {

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

        db.insert("AA_Instructores",
                    "ID_Instr" to 1,
                    "User_Instr" to "admin",
                    "Nombre_Instr" to "Administrador",
                    "Zona_Instr" to 1,
                    "Issuper_Instr" to 1,
                    "Idvehiculo_Instr" to 1,
                    "Idmovil_Instr" to 1,
                    "Pass_Instr" to "root")

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
                "Agro_Suelo_N" to REAL,
                "Agro_Suelo_NUd" to TEXT,
                "Agro_Suelo_P" to REAL,
                "Agro_Suelo_PUd" to TEXT,
                "Agro_Suelo_K" to REAL,
                "Agro_Suelo_KUd" to TEXT,
                "Agro_Suelo_MO" to REAL,
                "Agro_Suelo_MOUd" to TEXT,
                "Agro_Suelo_PH" to REAL,
                "Agro_Agua_CE" to REAL,
                "Agro_Agua_CEUd" to TEXT,
                "Agro_Agua_Carb" to REAL,
                "Agro_Agua_CarbUd" to TEXT,
                "Agro_Agua_PH" to REAL,
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
                "Infra_BC_Lena_Peines" to INTEGER,

                "AlmaConv_Is" to INTEGER,
                "To_Sincro_AlmaConv" to INTEGER,
                "AlmaFlot_Is" to INTEGER,
                "To_Sincro_AlmaFlot" to INTEGER,
                "AlmaBand_Is" to INTEGER,
                "To_Sincro_AlmaBand" to INTEGER,
                "AlmaApoya_Is" to INTEGER,
                "To_Sincro_AlmaApoya" to INTEGER,
                "AlmaVar_Is" to INTEGER,
                "To_Sincro_AlmaVar" to INTEGER
        )

        db.createTable("AgroFertilizantes", true,
                "Codigo_AF" to INTEGER,
                "Nombre_AF" to TEXT,
                "Codigo_TipoAF" to INTEGER,
                "Permitido_AF" to TEXT
        )

        db.createTable("AA_Almacigo_ConvxDetalle", true,
                "ID_Alma_Conv_Detalle" to INTEGER,
                "ID_Socio" to INTEGER,
                "Fecha" to TEXT,
                "ID_AF_APC_Conv" to INTEGER,
                "Nombre_AF_APC_Conv" to TEXT,
                "AF_APC_Unid_Conv" to TEXT,
                "AF_APC_Dosis_Conv" to REAL,
                "ID_AF_Fert_Conv" to INTEGER,
                "Nombre_AF_Fert_Conv" to TEXT,
                "AF_Fert_Unid_Conv" to INTEGER,
                "AF_Fert_Dosis_Conv" to TEXT,
                "Codigo_TipoAF" to INTEGER,
                "Densidad" to TEXT
        )

        db.createTable("AA_Almacigo_BandxDetalle", true,
                "ID_Alma_Band_Detalle" to INTEGER,
                "ID_Socio" to INTEGER,
                "Fecha" to TEXT,
                "ID_AF_APC_Band" to INTEGER,
                "Nombre_AF_APC_Band" to TEXT,
                "AF_APC_Unid_Band" to TEXT,
                "AF_APC_Dosis_Band" to REAL,
                "ID_AF_Fert_Band" to INTEGER,
                "Nombre_AF_Fert_Band" to TEXT,
                "AF_Fert_Unid_Band" to INTEGER,
                "AF_Fert_Dosis_Band" to TEXT,
                "Codigo_TipoAF" to INTEGER,
                "Densidad" to TEXT
        )

        db.createTable("AA_Almacigo_ApoyaxDetalle", true,
                "ID_Alma_Apoya_Detalle" to INTEGER,
                "ID_Socio" to INTEGER,
                "Fecha" to TEXT,
                "ID_AF_APC_Apoya" to INTEGER,
                "Nombre_AF_APC_Apoya" to TEXT,
                "AF_APC_Unid_Apoya" to TEXT,
                "AF_APC_Dosis_Apoya" to REAL,
                "ID_AF_Fert_Apoya" to INTEGER,
                "Nombre_AF_Fert_Apoya" to TEXT,
                "AF_Fert_Unid_Apoya" to INTEGER,
                "AF_Fert_Dosis_Apoya" to TEXT,
                "Codigo_TipoAF" to INTEGER,
                "Densidad" to TEXT
        )

        db.createTable("AA_Almacigo_FlotxDetalle", true,
                "ID_Alma_Flot_Detalle" to INTEGER,
                "ID_Socio" to INTEGER,
                "Fecha" to TEXT,
                "ID_AF_APC_Flot" to INTEGER,
                "Nombre_AF_APC_Flot" to TEXT,
                "AF_APC_Unid_Flot" to TEXT,
                "AF_APC_Dosis_Flot" to REAL,
                "ID_AF_Fert_Flot" to INTEGER,
                "Nombre_AF_Fert_Flot" to TEXT,
                "AF_Fert_Unid_Flot" to INTEGER,
                "AF_Fert_Dosis_Flot" to TEXT,
                "Codigo_TipoAF" to INTEGER,
                "Densidad" to TEXT
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

        onCreate(db)

        db.dropTable("AA_MaeSocios")
        db.dropTable("AA_Instructores")
        db.dropTable("AA_FichasGenerales")
        db.dropTable("AgroFertilizantes")
        db.dropTable("AA_Almacigo_ApoyaxDetalle")
        db.dropTable("AA_Almacigo_BandxDetalle")
        db.dropTable("AA_Almacigo_ConvxDetalle")
        db.dropTable("AA_Almacigo_FlotxDetalle")

        onCreate(db)



    }

}

val Context.database: DBHelper
    get() = DBHelper.getInstance(applicationContext)