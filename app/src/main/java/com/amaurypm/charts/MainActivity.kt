package com.amaurypm.charts

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amaurypm.charts.databinding.ActivityMainBinding
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Para el Pie Chart
        val listPie = mutableListOf<PieEntry>()

        listPie.add(PieEntry(200f, "Candidato 1"))
        listPie.add(PieEntry(100f, "Candidato 2"))
        listPie.add(PieEntry(52f, "Candidato 3"))
        listPie.add(PieEntry(88f, "Candidato 4"))

        val pieDataSet = PieDataSet(listPie, "").apply {
            setColors(ColorTemplate.MATERIAL_COLORS, 255)
            valueTextSize = 15f
            valueTextColor = Color.BLACK
        }

        val pieData = PieData(pieDataSet)

        binding.pcView.apply {
            data = pieData
            description.text = "Encuesta"
            centerText = "Resultados"
            animateY(2000)
        }

        //Para el Bar Chart
        val listBar = mutableListOf<BarEntry>()

        listBar.add(BarEntry(0.0f, 400f))
        listBar.add(BarEntry(1.0f, 180f))
        listBar.add(BarEntry(2.0f, 300f))
        listBar.add(BarEntry(3.0f, 220f))
        listBar.add(BarEntry(4.0f, 80f))

        val barDataSet = BarDataSet(listBar, "Deporte favorito").apply {
            setColors(ColorTemplate.MATERIAL_COLORS, 255)
            valueTextColor = Color.BLACK
            valueTextSize = 15f
        }


        val barData = BarData(barDataSet)

        //Para usar textos en el eje X
        val labelsBar = listOf("Fútbol", "Béisbol", "Tenis", "Natación", "Ninguno")

        binding.bcView.apply {
            xAxis.valueFormatter = IndexAxisValueFormatter(labelsBar)
            setFitBars(true)
            data = barData
            description.text = "Encuesta Diplo"
            animateY(2000)
        }

        //Para el Radar Chart
        val listRadar = mutableListOf<RadarEntry>()

        listRadar.add(RadarEntry(62f))
        listRadar.add(RadarEntry(47f))
        listRadar.add(RadarEntry(50f))
        listRadar.add(RadarEntry(66f))
        listRadar.add(RadarEntry(63f))
        listRadar.add(RadarEntry(58f))
        listRadar.add(RadarEntry(40f))
        listRadar.add(RadarEntry(55f))

        val radarDataSet = RadarDataSet(listRadar, "Producción Frutas (en toneladas)").apply {
            setColors(ColorTemplate.MATERIAL_COLORS, 255)
            color = Color.BLUE
            lineWidth = 2f
            valueTextColor = Color.BLUE
            valueTextSize = 15f
        }


        val radarData = RadarData(radarDataSet)

        val labelsRadar = listOf("2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023")

        binding.rcView.apply {
            xAxis.valueFormatter = IndexAxisValueFormatter(labelsRadar)
            data = radarData
            description.text = "Empresa Diplo SA de CV"
        }

    }

}