
package com.near.ProjetoNear.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.near.ProjetoNear.models.Loja;
import com.near.ProjetoNear.repository.LojaRepositorio;

@Controller
@RequestMapping("/adm")
public class AdmController {

    @Autowired
    private LojaRepositorio lojaRepositorio;

    // Acesso ao painel do administrador
    @GetMapping("/dashboard")
    public ModelAndView dashboard() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("adm/dashboard");

        return mv;
    }

    // Abrir tela de cadastro de lojas
    @GetMapping("/cadastrarClientes")
    public ModelAndView cadastrarClientes() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("adm/cadastrarClientes");

        mv.addObject("cadastro", new Loja());

        return mv;
    }

    // Salvar nova loja no banco de dados
    @PostMapping("/cadastrarClientes")
    public ModelAndView salvarCliente(Loja cadastro) {

        ModelAndView mv = new ModelAndView();

        lojaRepositorio.save(cadastro);

        mv.setViewName("redirect:/adm/deletarClientes");

        return mv;
    }

    // Listar todas as lojas cadastradas
    @GetMapping("/deletarClientes")
    public ModelAndView deletarClientes() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("adm/deletarClientes");

        mv.addObject("clientes", lojaRepositorio.findAll());

        return mv;
    }

    // Excluir uma loja pelo ID
    @PostMapping("/deletarClientes/{id}")
    public ModelAndView excluirCliente(@PathVariable("id") Long id) {

        ModelAndView mv = new ModelAndView();

        lojaRepositorio.deleteById(id);

        mv.setViewName("redirect:/adm/deletarClientes");

        return mv;
    }

}
