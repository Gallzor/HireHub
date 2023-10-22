package com.example.hirehub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hirehub.adapters.MainProfileListAdapter
import com.example.hirehub.clicklisteners.MainProfileClickListener
import com.example.hirehub.databases.HireHubApplication
import com.example.hirehub.databinding.FragmentMainProfileListBinding
import com.example.hirehub.factories.ProfileModelFactory
import com.example.hirehub.models.Profile
import com.example.hirehub.viewmodels.ProfileViewModel


class MainProfileListFragment : Fragment() {
    private var _binding: FragmentMainProfileListBinding? = null
    private val binding get() = _binding!!

    private val profileViewModel: ProfileViewModel by viewModels {
        ProfileModelFactory((requireActivity().application as HireHubApplication).profileRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainProfileListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView
        val recyclerView = binding.mainProfileListRecyclerView

        // Observe the profiles and update the adapter when there are changes
        profileViewModel.profiles.observe(viewLifecycleOwner) { profiles ->
            // Create and set the adapter with the click listener
            val adapter = MainProfileListAdapter(profiles, object : MainProfileClickListener {
                override fun onProfileItemClick(profile: Profile) {
                    // Handle the click event and show the ProfileListViewSheetFragment
                    val profileListViewSheetFragment = ProfileListViewSheetFragment()
                    profileListViewSheetFragment.setProfile(profile)
                    profileListViewSheetFragment.show(parentFragmentManager, "profileViewTag")
                }
            })
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}