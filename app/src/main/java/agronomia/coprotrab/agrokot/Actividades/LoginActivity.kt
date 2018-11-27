package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.DataResources.SharedApp
import agronomia.coprotrab.agrokot.Clases.Entidades.Instructor
import agronomia.coprotrab.agrokot.R
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

class LoginActivity : AppCompatActivity() {

    val TAGACT = "agronomia.coprotab.agrokot.INSTRUCTOR"

    private lateinit var progressBar: ProgressBar
    private lateinit var et_login_user: EditText
    private lateinit var et_login_contra: EditText
    private lateinit var b_log_login: Button
    private lateinit var tv_log_msj: TextView
    var toolbar: Toolbar? =null


    override fun onCreate(savedInstanceState: Bundle?) {

        var instructor: Instructor? = null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        toolbar = findViewById(R.id.tb_act_sincro)
        toolbar?.title = "Ingreso de Instructor"
        toolbar?.setTitleMargin(10,10,10,10)
        setSupportActionBar(toolbar)

        et_login_user = findViewById(R.id.et_Log_User)
        et_login_contra = findViewById(R.id.et_Log_Contra)
        progressBar= ProgressBar(this)

        b_log_login = findViewById(R.id.b_Log_Login)
        b_log_login.setOnClickListener {

            val user:String = et_login_user.text.toString()
            val contra:String = et_login_contra.text.toString()

            if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(contra)){
                progressBar.visibility = View.VISIBLE

                instructor = DataAccess_RegistroAgrotecnico_App(this).select_Instructor(user)

                if(instructor != null && instructor?.Pass_Instr == contra) {

                    SharedApp.prefs?.user = instructor?.User_Instr.toString()

                    val intentMain = Intent(this, MainActivity::class.java)
                    intentMain.putExtra(TAGACT, instructor?.Nombre_Instr)
                    startActivity(intentMain)
                }
                else
                {
                    Toast.makeText(this, "Instructor no registrado", Toast.LENGTH_LONG).show()
                }
            }
            progressBar.visibility = View.INVISIBLE
        }

        tv_log_msj = findViewById(R.id.tv_Log_Msj)
        tv_log_msj.setOnClickListener {
            val intent = Intent(this, AyudaActivity::class.java)
            startActivity(intent)
        }

    }


}
