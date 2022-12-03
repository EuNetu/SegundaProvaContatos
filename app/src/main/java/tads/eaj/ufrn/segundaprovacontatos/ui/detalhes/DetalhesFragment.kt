package tads.eaj.ufrn.segundaprovacontatos.ui.detalhes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import tads.eaj.ufrn.segundaprovacontatos.R
import tads.eaj.ufrn.segundaprovacontatos.databinding.FragmentCadastraBinding
import tads.eaj.ufrn.segundaprovacontatos.databinding.FragmentDetalhesBinding
import tads.eaj.ufrn.segundaprovacontatos.model.Contact
import tads.eaj.ufrn.segundaprovacontatos.ui.cadastra.CadastraViewModel
import tads.eaj.ufrn.segundaprovacontatos.ui.home.HomeViewModel

@AndroidEntryPoint
class DetalhesFragment : Fragment() {

    private lateinit var _binding: FragmentDetalhesBinding
    private lateinit var _viewmodel: DetalhesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalhesBinding.inflate(inflater, container, false)
        _viewmodel = ViewModelProvider(this)[DetalhesViewModel::class.java]

        _binding.viewmodel = _viewmodel
        _binding.lifecycleOwner = this

        var id = arguments?.getInt("position")
        _viewmodel.contatoSelecionado(id!!)
        return _binding.root
    }
}