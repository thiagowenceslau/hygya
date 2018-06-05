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
@Repository("ProfissionalDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface ProfissionalDAO extends JpaRepository<Profissional, java.lang.String> {

  /**
   * Obtém a instância de Profissional utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Profissional entity WHERE entity.id = :id")
  public Profissional findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Profissional utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Profissional entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM AutorizacaoAcessoExame entity WHERE entity.profissional.id = :id")
  public Page<AutorizacaoAcessoExame> findAutorizacaoAcessoExame(@Param(value="id") java.lang.String id, Pageable pageable);
  
  /**
   * ManyToOne Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity.paciente FROM AutorizacaoAcessoExame entity WHERE entity.profissional.id = :id AND (entity.paciente.nome like concat('%',coalesce(:search,''),'%') OR entity.paciente.cpf like concat('%',coalesce(:search,''),'%'))")
  public Page<Paciente> listPacienteGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity.paciente FROM AutorizacaoAcessoExame entity WHERE entity.profissional.id = :id AND (:nome is null OR entity.paciente.nome like concat('%',:nome,'%')) AND (:cpf is null OR entity.paciente.cpf like concat('%',:cpf,'%'))")
  public Page<Paciente> listPacienteSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="nome") java.lang.String nome, @Param(value="cpf") java.lang.String cpf, Pageable pageable);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.paciente FROM AutorizacaoAcessoExame entity WHERE entity.profissional.id = :id")
  public Page<Paciente> listPaciente(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM AutorizacaoAcessoExame entity WHERE entity.profissional.id = :instanceId AND entity.paciente.id = :relationId")
  public int deletePaciente(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Profissional entity WHERE entity.nome like concat('%',coalesce(:search,''),'%') OR entity.cpF like concat('%',coalesce(:search,''),'%')")
  public Page<Profissional> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Profissional entity WHERE (:nome is null OR entity.nome like concat('%',:nome,'%')) AND (:cpF is null OR entity.cpF like concat('%',:cpF,'%')) AND (:numCRM is null OR entity.numCRM = :numCRM)")
  public Page<Profissional> specificSearch(@Param(value="nome") java.lang.String nome, @Param(value="cpF") java.lang.String cpF, @Param(value="numCRM") java.lang.Integer numCRM, Pageable pageable);
  
}
