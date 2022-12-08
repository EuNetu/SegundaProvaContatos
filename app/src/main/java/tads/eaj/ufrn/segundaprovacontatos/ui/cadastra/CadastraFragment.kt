package tads.eaj.ufrn.segundaprovacontatos.ui.cadastra

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import tads.eaj.ufrn.segundaprovacontatos.R
import tads.eaj.ufrn.segundaprovacontatos.databinding.FragmentCadastraBinding


@AndroidEntryPoint
class CadastraFragment : Fragment() {

    private lateinit var _binding: FragmentCadastraBinding
    val _viewmodel: CadastraViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCadastraBinding.inflate(inflater, container, false)

        _binding.viewmodel = _viewmodel
        _binding.lifecycleOwner = this

        _binding.buttonCadastra.setOnClickListener {
            _viewmodel.cadastrarButtonEvent()
            Navigation.findNavController(it).navigate(R.id.navigation_home)
            Toast.makeText(
                requireContext(),
                getString(R.string.sucessoContatoCadastrado),
                Toast.LENGTH_SHORT
            ).show()
        }

        return _binding.root
    }
}