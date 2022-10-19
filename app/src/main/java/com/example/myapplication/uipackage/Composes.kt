package com.example.myapplication.uipackage

import android.util.Log
import androidx.compose.foundation.border

import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.MainActivity
import com.example.myapplication.data.local.dao.Dao
import com.example.myapplication.data.local.table.PersonTable
import com.example.myapplication.viewmodel.AgifyViewModel


@Composable
fun TextField(modifier: Modifier =Modifier
,nameState:MutableState<String>){
    androidx.compose.material.TextField(value = nameState.value, onValueChange ={
        nameState.value=it
    } , label = {
        Text(text = "Enter your name", color = Color.Gray)
    }, modifier = modifier.border(width = 3.dp, color = Color.Green), colors = TextFieldDefaults.textFieldColors(textColor = Color.White))


}

@Composable
fun Button(modifier:Modifier=Modifier, viewModel:AgifyViewModel
           , nameState: MutableState<String>, activity: MainActivity, ageState: MutableState<Int>,dao:Dao){
    androidx.compose.material.Button(onClick = {
        dao.getInformation().forEach {
            if(it.name==nameState.value){
                ageState.value=it.age
            }else{
                viewModel.getData(nameState.value).observe(activity){
                    dao.addName(PersonTable(age=it.age,name=nameState.value))
                    ageState.value=it.age
                    Log.i("Testtt",ageState.value.toString())
                }

            }
        }





    }) {
        Text(text = "Guess my age")

    }


}

@Composable
fun Text(modifier: Modifier=Modifier,ageState: MutableState<Int>,nameState: MutableState<String>,dao: Dao){


    if(ageState.value==0){
        Text("your name is not available in database")
    }else{
        Text(text = "Your age is ${ageState.value}", color = Color.White, textAlign = TextAlign.Center)
    }
    
}
