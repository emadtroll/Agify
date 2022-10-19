package com.example.myapplication
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.google.accompanist.systemuicontroller.rememberSystemUiController

import com.example.myapplication.data.local.dao.Dao
import com.example.myapplication.data.local.table.PersonTable
import com.example.myapplication.viewmodel.AgifyViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModel: AgifyViewModel
    @Inject
    lateinit var dao: Dao



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestPermission()
        setContent {
            val nameState= remember{
                mutableStateOf("")
            }
            val ageState= remember {
                mutableStateOf(0)
            }

            Box(modifier= Modifier
                .background(color = Color.Black)
                .fillMaxSize() ){
                Toolbar()
                Column(modifier=Modifier.align(Alignment.Center) ,
                horizontalAlignment = Alignment.CenterHorizontally) {
                    com.example.myapplication.uipackage.TextField(nameState =nameState )
                   com.example.myapplication.uipackage.Button(viewModel = viewModel, nameState = nameState, activity =this@MainActivity
                        , ageState =ageState ,dao=dao)
                   com.example.myapplication.uipackage.Text(ageState = ageState, nameState = nameState, dao = dao)


                }









            }


        }


    }












    fun checkPermission():Boolean{
        return ContextCompat.checkSelfPermission(applicationContext,
            Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }
    @SuppressLint("SuspiciousIndentation")
    fun requestPermission() {
        if(!checkPermission())
        ActivityCompat.requestPermissions(
            this, arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ), 1
        )

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            1->
                if(grantResults.isNotEmpty()&& grantResults[0]==PackageManager.PERMISSION_GRANTED
                    &&grantResults[1]==PackageManager.PERMISSION_GRANTED){
                    Log.i("Testtt","Permission granted")

                }else{
                    finishAffinity()

                }

    }






    }

}










@Composable
fun Toolbar(){
    TopAppBar(
        title = {
            Text(text = "Agify.io")
        },
        modifier = Modifier.background(Color.Green)
        ,
        backgroundColor = Color.Green,
        contentColor = Color.Black,
        elevation = 2.dp
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {


}