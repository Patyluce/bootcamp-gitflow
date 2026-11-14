
package com.near.ProjetoNear.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.near.ProjetoNear.models.Loja;

@Transactional
@Repository
public interface LojaRepositorio extends JpaRepository<Loja, Long> {

    @Query("select u from Loja u where u.id = :id")
    Iterable<Loja> exibirLoja(@Param("id") Long id);

    @Query("select i from Loja i where i.email = :email")
    public Loja buscarEmail(@Param("email") String email);

    @Query("select j from Loja j where j.email = :email and j.senha = :senha")
    public Loja buscarLogin(@Param("email") String email,
                            @Param("senha") String senha);

    @Modifying
    @Query("update Loja l set l.nome = :nome, l.cep = :cep, l.categoria = :categoria, l.bairro = :bairro where l.id = :id")
    public void editarLoja(@Param("nome") String nome,
                           @Param("cep") String cep,
                           @Param("categoria") String categoria,
                           @Param("bairro") String bairro,
                           @Param("id") Long id);

    @Query("select b from Loja b where b.bairro like %?1%")
    Iterable<Loja> buscarLojaporBairro(String bairro);

    @Query("select b from Loja b where b.bairro like %?1% and b.categoria like %?2%")
    List<Loja> buscarLojaporCategoria(String bairro, String categoria);

}
