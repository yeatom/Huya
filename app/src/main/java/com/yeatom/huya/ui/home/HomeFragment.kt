package com.yeatom.huya.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.yeatom.huya.databinding.FragmentHomeBinding
import com.yeatom.huya.ui.RecyclerViewFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.homePageViewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return 8
            }

            override fun createFragment(position: Int): Fragment {
                return RecyclerViewFragment.newInstance(2)
            }
        }

        binding.homePageTabLayout.run {}

        TabLayoutMediator(binding.homePageTabLayout, binding.homePageViewPager, false, true) { tab, position ->
            tab.text = "frag$position"
        }.attach()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}