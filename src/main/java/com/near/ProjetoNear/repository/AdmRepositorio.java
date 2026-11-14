
package com.near.ProjetoNear.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.near.ProjetoNear.models.Adm;

@Repository
public interface AdmRepositorio extends JpaRepository<Adm, Long> {

}