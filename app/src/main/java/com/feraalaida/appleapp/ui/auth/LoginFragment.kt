package com.feraalaida.appleapp.ui.auth
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.feraalaida.appleapp.R
import com.feraalaida.appleapp.data.repository.AuthRepository
import com.feraalaida.appleapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    val parent:AuthActivity by lazy { activity as AuthActivity }
    val viewModel: AuthViewModel by lazy { AuthViewModel(AuthRepository(parent)) }
    lateinit var binding : FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container,false)
        binding.lifecycleOwner=this
        binding.viewModel = viewModel
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observe()
    }

    private fun observe() {
        binding.butonRegister.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }
    private fun init() {
        viewModel.authLogin.observe(viewLifecycleOwner){
            if (it.isConsumed){
                Log.i("Login","isConsumed")
            }else if(!it.isSuccess){
                Toast.makeText(parent, "Anda Belum Terdaftar", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(parent, "Anda Berhasil Login", Toast.LENGTH_SHORT).show()
                parent.onSuccess(it.data)
            }
            it.isConsumed = true
        }
    }
}