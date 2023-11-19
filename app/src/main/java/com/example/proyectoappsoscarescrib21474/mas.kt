package com.example.proyectoappsoscarescrib21474

import android.content.Intent
import android.net.Uri
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
 * Use the [mas.newInstance] factory method to
 * create an instance of this fragment.
 */
class mas : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val view = inflater.inflate(R.layout.fragment_mas, container, false)
        //--------Botones para enviar las cosas---------------------
        val btnInEle: Button = view.findViewById(R.id.ButtonInElec)
        btnInEle.setOnClickListener {
            val uri = Uri.parse("https://www.youtube.com/watch?v=kHZ8SD7jiiA&list=PLTIdiuUvwYCHQe19DgjiingeKulmq5drf")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        val btnInQ: Button = view.findViewById(R.id.ButtonIngQ)
        btnInQ.setOnClickListener {
            val uri = Uri.parse("https://www.youtube.com/watch?v=-JJyweKseeE&list=PLfVlEQZrO3q2G1RhlhuQ7iMu_04xYSqwD")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        val btnInS: Button = view.findViewById(R.id.ButtonIngS)
        btnInS.setOnClickListener {
            val uri = Uri.parse("https://www.youtube.com/watch?v=o_78Ue_EUeI&list=PL2Z95CSZ1N4HLqf215jj9ZJgmWIXm7gOo")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment mas.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            mas().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}