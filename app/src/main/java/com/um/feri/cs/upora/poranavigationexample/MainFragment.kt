package com.um.feri.cs.upora.poranavigationexample

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.um.feri.cs.upora.poranavigationexample.databinding.FragmentMainBinding
import java.util.*

private const val ARG_NAME = "name"
private const val ARG_YEAR = "year"

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSomeAction.setOnClickListener {
            if (isDataValid()) {
                val bundle = bundleOf(
                    ARG_NAME to binding.etName.text.toString(),
                    ARG_YEAR to binding.etYear.text.toString().toInt()
                )
                findNavController().navigate(R.id.action_MainFragment_to_ActionFragment, bundle)
            } else {
                Snackbar.make(view,"Invalid data", Snackbar.LENGTH_LONG).show()
            }
        }
        binding.btnInfo.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_InfoFragment)
        }

    }

    fun isDataValid(): Boolean {
        var ok = true
        if (TextUtils.isEmpty(binding.etName.text.toString())) {
            binding.etName.setError("Empty text")
            ok = false
        }
        if (TextUtils.isEmpty(binding.etYear.text.toString())) {
            binding.etYear.setError("Set year")
            ok = false
        } else {
            val tmp = binding.etYear.text.toString().toInt()
            val year = Calendar.getInstance().get(Calendar.YEAR)
            if (tmp < year - 200) {
                binding.etYear.setError("Too old")
                ok = false
            }
            if (tmp > year) {
                binding.etYear.setError("Not born yet")
                ok = false
            }
        }
        return ok
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}