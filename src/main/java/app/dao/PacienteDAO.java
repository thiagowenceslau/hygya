package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("PacienteDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface PacienteDAO extends JpaRepository<Paciente, java.lang.String> {

  /**
   * Obtém a instância de Paciente utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Paciente entity WHERE entity.id = :id")
  public Paciente findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Paciente utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Paciente entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM AutorizacaoAcessoExame entity WHERE entity.paciente.id = :id")
  public Page<AutorizacaoAcessoExame> findAutorizacaoAcessoExame(@Param(value="id") java.lang.String id, Pageable pageable);
  
  /**
   * ManyToOne Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity.profissional FROM AutorizacaoAcessoExame entity WHERE entity.paciente.id = :id AND (entity.profissional.nome like concat('%',coalesce(:search,''),'%') OR entity.profissional.cpF like concat('%',coalesce(:search,''),'%'))")
  public Page<Profissional> listProfissionalGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity.profissional FROM AutorizacaoAcessoExame entity WHERE entity.paciente.id = :id AND (:nome is null OR entity.profissional.nome like concat('%',:nome,'%')) AND (:cpF is null OR entity.profissional.cpF like concat('%',:cpF,'%')) AND (:numCRM is null OR entity.profissional.numCRM = :numCRM)")
  public Page<Profissional> listProfissionalSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="nome") java.lang.String nome, @Param(value="cpF") java.lang.String cpF, @Param(value="numCRM") java.lang.Integer numCRM, Pageable pageable);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.profissional FROM AutorizacaoAcessoExame entity WHERE entity.paciente.id = :id")
  public Page<Profissional> listProfissional(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM AutorizacaoAcessoExame entity WHERE entity.paciente.id = :instanceId AND entity.profissional.id = :relationId")
  public int deleteProfissional(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Paciente entity WHERE entity.nome like concat('%',coalesce(:search,''),'%') OR entity.cpf like concat('%',coalesce(:search,''),'%')")
  public Page<Paciente> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Paciente entity WHERE (:nome is null OR entity.nome like concat('%',:nome,'%')) AND (:cpf is null OR entity.cpf like concat('%',:cpf,'%'))")
  public Page<Paciente> specificSearch(@Param(value="nome") java.lang.String nome, @Param(value="cpf") java.lang.String cpf, Pageable pageable);
  
}
