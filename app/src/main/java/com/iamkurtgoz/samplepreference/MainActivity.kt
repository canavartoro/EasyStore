package com.iamkurtgoz.samplepreference

import android.database.Observable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.iamkurtgoz.easystore.EasyModel
import com.iamkurtgoz.easystore.EasyState
import com.iamkurtgoz.easystore.EasyStore
import com.iamkurtgoz.easystore.save


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EasyStore.liveData().observe(this, Observer {
            when(it){
                is EasyState.onDataSaved -> println("Key: ${it.key} -- Value: ${it.value}")
            }
        })

        val name = "Mehmet Kurtgöz"
        val age = 22
        val weight = 80.5f
        val total_days = 15L
        val is_developer = true

        /**********************************************************************************************/
        /**********************************************************************************************/
        /************************************** STRING DATA *******************************************/
        /**********************************************************************************************/
        /**********************************************************************************************/

        name.save("Name")
        //or
        "Mehmet Kurtgöz".save("Name")
        //or
        EasyStore.save("Name", name)


        /**********************************************************************************************/
        /**********************************************************************************************/
        /************************************** INTEGER DATA *******************************************/
        /**********************************************************************************************/
        /**********************************************************************************************/

        age.save("AGE")
        //or
        22.save("AGE")
        //or
        EasyStore.save("AGE", age)

        /**********************************************************************************************/
        /**********************************************************************************************/
        /************************************** FLOAT DATA *******************************************/
        /**********************************************************************************************/
        /**********************************************************************************************/

        weight.save("WEIGHT")
        //or
        80f.save("WEIGHT")
        //or
        EasyStore.save("WEIGHT", weight)

        /**********************************************************************************************/
        /**********************************************************************************************/
        /************************************** LONG DATA *******************************************/
        /**********************************************************************************************/
        /**********************************************************************************************/

        total_days.save("TOTAL_DAYS")
        //or
        15L.save("TOTAL_DAYS")
        //or
        EasyStore.save("TOTAL_DAYS", total_days)

        /**********************************************************************************************/
        /**********************************************************************************************/
        /************************************** BOOLEAN DATA *******************************************/
        /**********************************************************************************************/
        /**********************************************************************************************/

        is_developer.save("DEVELOPER")
        //or
        true.save("DEVELOPER")
        //or
        EasyStore.save("DEVELOPER", is_developer)

        /**********************************************************************************************/
        /**********************************************************************************************/
        /************************************** LIST DATA *******************************************/
        /**********************************************************************************************/
        /**********************************************************************************************/

        listOf(
                EasyModel("NAME", name),
                EasyModel("AGE", age),
                EasyModel("WEIGHT", weight),
                EasyModel("TOTAL_DAYS", total_days),
                EasyModel("DEVELOPER", is_developer)
        ).save()

        /**********************************************************************************************/
        /**********************************************************************************************/
        /************************************** READ DATA *******************************************/
        /**********************************************************************************************/
        /**********************************************************************************************/

        Log.d("MyLog", "NAME: ${EasyStore.readString("NAME")}")
        Log.d("MyLog", "AGE: ${EasyStore.readInt("AGE")}")
        Log.d("MyLog", "WEIGHT: ${EasyStore.readFloat("WEIGHT")}")
        Log.d("MyLog", "TOTAL_DAYS: ${EasyStore.readLong("TOTAL_DAYS")}")
        Log.d("MyLog", "DEVELOPER: ${EasyStore.readBoolean("DEVELOPER")}")

        /**********************************************************************************************/
        /**********************************************************************************************/
        /************************************** EXIST DATA *******************************************/
        /**********************************************************************************************/
        /**********************************************************************************************/

        val nameExist = EasyStore.existString("NAME")
        val ageExist = EasyStore.existInt("AGE")
        val weightExist = EasyStore.existFloat("WEIGHT")
        val totalDaysExist = EasyStore.existLong("TOTAL_DAYS")
        val developerExist = EasyStore.existBoolean("DEVELOPER")

    }
}