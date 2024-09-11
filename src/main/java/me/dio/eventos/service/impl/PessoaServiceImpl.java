package me.dio.eventos.service.impl;

import java.util.Optional;
import me.dio.eventos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.dio.eventos.model.Pessoa;
import me.dio.eventos.model.Endereco;
import me.dio.eventos.repository.EnderecoRepository;
import me.dio.eventos.service.PessoaService;
import me.dio.eventos.service.ViaCepService;

@Service
public class PessoaServiceImpl implements PessoaService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;


    @Override
    public Iterable<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.get();
    }

    @Override
    public void inserir(Pessoa pessoa) {
        salvarPessoaComCep(pessoa);
    }

    @Override
    public void atualizar(Long id, Pessoa pessoa) {
        Optional<Pessoa> pessoaBd = pessoaRepository.findById(id);
        if (pessoaBd.isPresent()) {
            salvarPessoaComCep(pessoa);
        }
    }

    @Override
    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }

    private void salvarPessoaComCep(Pessoa pessoa) {
        String cep = pessoa.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        pessoa.setEndereco(endereco);
        pessoaRepository.save(pessoa);
    }

}
