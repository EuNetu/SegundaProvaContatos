package tads.eaj.ufrn.segundaprovacontatos.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import tads.eaj.ufrn.segundaprovacontatos.databinding.FragmentHomeBinding
import tads.eaj.ufrn.segundaprovacontatos.ui.home.adapters.ContactAdapter

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private lateinit var _viewmodel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewmodel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        _binding.viewmodel = _viewmodel
        _binding.lifecycleOwner = this

        val adapter = ContactAdapter()

        _viewmodel.contacts.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        _binding.recyclerview.adapter = adapter

        _binding.recyclerview.addOnItemTouchListener(
            RecyclerView(_binding.recyclerview, object : RecyclerView.OnItemClickListener{
                override fun onItemClick(view: View, position: Int) {
                    Toast.makeText(requireContext(), "Toque simples", Toast.LENGTH_SHORT).show()
                }

                override fun onItemLongClick(view: View, position: Int) {
                    Toast.makeText(requireContext(), "Toque longo", Toast.LENGTH_SHORT).show()
                }

            }))

        return _binding.root
    }
}