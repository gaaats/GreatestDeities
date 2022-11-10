package com.kiloo.subwaysurfo.gamagame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.snackbar.Snackbar
import com.kiloo.subwaysurfo.databinding.FragmentLeaderboardBinding


class LeaderboardFragment : Fragment() {
    private var _binding: FragmentLeaderboardBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")

    private val frggtyhyyhy by lazy {
        UserRaitingListAdapter()
    }

    val tghyh = listOf(
        "William",
        "James",
        "Robert",
        "John",
        "David",
        "Elizabeth",
        "Richard",
        "Barbara",
        "Susan",
        "Joseph",
        "Jessica",
        "Thomas",
        "Sarah",
        "Karen",
        "Lisa",
        "Charles",
        "Christopher",
        "Daniel",
        "Nancy",
        "Betty",
        "Matthew"
    )

    val edfrgthy = mutableListOf<SingleUser>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaderboardBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        for (i in 1..50){
            val person = SingleUser(name = tghyh.random())
            edfrgthy.add(person)
        }

        try {
            initOnItemClickListenerdfrghy()
            addVertAndHorDividersedfrgtg()
            frggtyhyyhy.submitList(edfrgthy)
            binding.recyclerViewRaitlist.adapter = frggtyhyyhy
            binding.btnImgExitRaitFragment.setOnClickListener {
                requireActivity().onBackPressed()
            }
            binding.btnGoUnderstand.setOnClickListener {
                requireActivity().onBackPressed()
            }

        } catch (e: Exception) {
            jujujujujujuuj()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun jujujujujujuuj() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

    private fun addVertAndHorDividersedfrgtg() {
        binding.recyclerViewRaitlist.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun initOnItemClickListenerdfrghy() {
        frggtyhyyhy.setOnItemClickListener {
            Snackbar.make(
                binding.root,
                "My name is ${it.name}",
                Snackbar.LENGTH_LONG
            ).show()

        }
    }
}