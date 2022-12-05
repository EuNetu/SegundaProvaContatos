package tads.eaj.ufrn.segundaprovacontatos.ui.detalhes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import tads.eaj.ufrn.segundaprovacontatos.R
import tads.eaj.ufrn.segundaprovacontatos.databinding.FragmentAlteraBinding
import tads.eaj.ufrn.segundaprovacontatos.databinding.FragmentDetalhesBinding

@AndroidEntryPoint
class AlteraFragment : Fragment() {

    private lateinit var _binding: FragmentAlteraBinding
    private lateinit var _viewmodel: AlteraViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlteraBinding.inflate(inflater, container, false)
        _viewmodel = ViewModelProvider(this)[AlteraViewModel::class.java]

        _binding.viewmodel = _viewmodel
        _binding.lifecycleOwner = this

        val id = arguments?.getLong("id")
        _viewmodel.contatoSelecionado(id!!)

        _binding.buttonAltera.setOnClickListener{
            _viewmodel.alteraButtonEvent()
            Navigation.findNavController(it).navigate(R.id.navigation_home)
            Toast.makeText(requireContext(), "Sucesso! Seu contato foi alterado", Toast.LENGTH_SHORT).show()
        }

        return _binding.root
    }
}