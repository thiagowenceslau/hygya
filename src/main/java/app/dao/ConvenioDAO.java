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
@Repository("ConvenioDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface ConvenioDAO extends JpaRepository<Convenio, java.lang.String> {

  /**
   * Obtém a instância de Convenio utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Convenio entity WHERE entity.id = :id")
  public Convenio findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Convenio utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Convenio entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM User entity WHERE entity.convenio.id = :id")
  public Page<User> findUser(@Param(value="id") java.lang.String id, Pageable pageable);
  
  /**
   * ManyToOne Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity.estabelecimentoDeSaude FROM User entity WHERE entity.convenio.id = :id AND (entity.estabelecimentoDeSaude.nome like concat('%',coalesce(:search,''),'%') OR entity.estabelecimentoDeSaude.cnPJ like concat('%',coalesce(:search,''),'%') OR entity.estabelecimentoDeSaude.razaoSocial like concat('%',coalesce(:search,''),'%'))")
  public Page<EstabelecimentoDeSaude> listEstabelecimentoDeSaudeGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity.estabelecimentoDeSaude FROM User entity WHERE entity.convenio.id = :id AND (:nome is null OR entity.estabelecimentoDeSaude.nome like concat('%',:nome,'%')) AND (:cnPJ is null OR entity.estabelecimentoDeSaude.cnPJ like concat('%',:cnPJ,'%')) AND (:razaoSocial is null OR entity.estabelecimentoDeSaude.razaoSocial like concat('%',:razaoSocial,'%'))")
  public Page<EstabelecimentoDeSaude> listEstabelecimentoDeSaudeSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="nome") java.lang.String nome, @Param(value="cnPJ") java.lang.String cnPJ, @Param(value="razaoSocial") java.lang.String razaoSocial, Pageable pageable);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.estabelecimentoDeSaude FROM User entity WHERE entity.convenio.id = :id")
  public Page<EstabelecimentoDeSaude> listEstabelecimentoDeSaude(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM User entity WHERE entity.convenio.id = :instanceId AND entity.estabelecimentoDeSaude.id = :relationId")
  public int deleteEstabelecimentoDeSaude(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Convenio entity WHERE entity.nome like concat('%',coalesce(:search,''),'%') OR entity.cnPJ like concat('%',coalesce(:search,''),'%')")
  public Page<Convenio> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Convenio entity WHERE (:nome is null OR entity.nome like concat('%',:nome,'%')) AND (:cnPJ is null OR entity.cnPJ like concat('%',:cnPJ,'%'))")
  public Page<Convenio> specificSearch(@Param(value="nome") java.lang.String nome, @Param(value="cnPJ") java.lang.String cnPJ, Pageable pageable);
  
}
