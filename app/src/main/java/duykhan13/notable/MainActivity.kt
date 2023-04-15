package duykhan13.notable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    //input init
    private lateinit var userWeight: EditText
    private lateinit var userHeight: EditText
    private lateinit var userAge: EditText
    private lateinit var userActivityLevel: EditText
    private lateinit var calButton: Button
    //output init
    private lateinit var outputBMR: TextView
    private lateinit var outputBMI: TextView
    private lateinit var outputTDEE: TextView
    private lateinit var outputWater: TextView

    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //user-input
        userWeight = findViewById(R.id.userWeight)
        userHeight = findViewById(R.id.myHeight)
        userAge = findViewById(R.id.ageInput)
        userActivityLevel = findViewById(R.id.activityLevel)

        //button
        calButton = findViewById(R.id.calculateButton)

        //output
        outputBMI = findViewById(R.id.outputBMI)
        outputBMR = findViewById(R.id.outputBMR)
        outputTDEE = findViewById(R.id.energyValue)
        outputWater = findViewById(R.id.waterValue)


        calButton.setOnClickListener {
            if (userWeight.text.isEmpty() || userHeight.text.isEmpty() ||userAge.text.isEmpty() || userActivityLevel.text.isEmpty()) {
                outputBMR.text = "".toEditable()
                outputBMI.text = "".toEditable()
                outputWater.text = "".toEditable()
                outputTDEE.text = "".toEditable()
            }
            val initWeight = userWeight.text.toString().toDouble()
            val initHeight = userHeight.text.toString().toDouble()
            val age = userAge.text.toString().toDouble()
            val initLevel = userActivityLevel.text.toString().toDouble()

            val calBMI = initWeight / (initHeight * initHeight)
            val calBMR = 66.5 + (13.75 * initWeight) + (5.003 * initHeight * 100) - (6.775 * age)
            val calWaterLevel = initWeight * 0.03
            val calEnergyValue = calBMR * initLevel

            outputBMR.text = "%.2f".format(calBMR) + " kcl"
            outputBMI.text = "%.2f".format(calBMI)
            outputWater.text = "%.2f".format(calWaterLevel) + " litre"
            outputTDEE.text = "%.2f".format(calEnergyValue) + " kcl"
        }

    }

//    private fun calculateTheFinalResult() {
//
//    }


}