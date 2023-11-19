package com.example.proyectoappsoscarescrib21474

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [calculadora.newInstance] factory method to
 * create an instance of this fragment.
 */
class calculadora : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //--------botones para mandar a llamar las otras paginas-----------------------------
    //-----------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calculadora, container, false)
        //---------------botones para cambiar de actividad-----------------------------
        //encuentra el boton en el disenio
        val btnPantallaDeCalculadora: Button = view.findViewById(R.id.button2)
        //configurar un OnClickListerner para el boton
        btnPantallaDeCalculadora.setOnClickListener{
            val intent = Intent(requireContext(), CalculadoraActivity::class.java)
            startActivity(intent)
        }
        //encuentra el boton para el diseño...
        val btnPantallaDeConversionesE: Button = view.findViewById(R.id.button3)
        btnPantallaDeConversionesE.setOnClickListener{
            val intet = Intent(requireContext(), ConversionesE::class.java)
            startActivity(intet)
        }
        //boton para la tabla periodica...
        val btnPantallaTablaPeriodica: Button = view.findViewById(R.id.button4)
        btnPantallaTablaPeriodica.setOnClickListener{
            val intent = Intent(requireContext(), TablaP::class.java)
            startActivity(intent)
        }
        //boton para la parte de conversiones fisicas...
        val btnPantallaConversionesF: Button = view.findViewById(R.id.button5)
        btnPantallaConversionesF.setOnClickListener {
            val intent = Intent(requireContext(), ConversionesF::class.java)
            startActivity(intent)
        }
        //------------------------------------------------------------------------------
        return view

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment calculadora.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            calculadora().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}