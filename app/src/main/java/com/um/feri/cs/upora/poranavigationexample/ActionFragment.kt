package com.um.feri.cs.upora.poranavigationexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.um.feri.cs.upora.poranavigationexample.databinding.FragmentActionBinding
import com.um.feri.cs.upora.poranavigationexample.databinding.FragmentInfoBinding
import com.um.feri.cs.upora.poranavigationexample.databinding.FragmentMainBinding
import java.time.Year
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ActionFragment : Fragment() {

    private var _binding: FragmentActionBinding? = null
    private var name="none"
    private var year=-1

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = requireArguments().getString("name")!!
        year = requireArguments().getInt("year")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActionBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvName.text = "Welcome $name!"
        val old = (Calendar.getInstance().get(Calendar.YEAR)-year).toString();
        binding.tvYear.text = "You are $old years old"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}