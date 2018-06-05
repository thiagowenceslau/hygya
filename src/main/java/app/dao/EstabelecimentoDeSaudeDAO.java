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
@Repository("EstabelecimentoDeSaudeDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface EstabelecimentoDeSaudeDAO extends JpaRepository<EstabelecimentoDeSaude, java.lang.String> {

  /**
   * Obtém a instância de EstabelecimentoDeSaude utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM EstabelecimentoDeSaude entity WHERE entity.id = :id")
  public EstabelecimentoDeSaude findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de EstabelecimentoDeSaude utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM EstabelecimentoDeSaude entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM User entity WHERE entity.estabelecimentoDeSaude.id = :id")
  public Page<User> findUser(@Param(value="id") java.lang.String id, Pageable pageable);
    
  /**
   * OneToMany Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Resultado entity WHERE entity.estabelecimentoDeSaude.id = :id AND (entity.nomeExame like concat('%',coalesce(:search,''),'%'))")
  public Page<Resultado> findResultadoGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /** 
   * OneToMany Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Resultado entity WHERE entity.estabelecimentoDeSaude.id = :id AND (:nomeExame is null OR entity.nomeExame like concat('%',:nomeExame,'%')) AND (:dataEmissao is null OR entity.dataEmissao = :dataEmissao)")
  public Page<Resultado> findResultadoSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="nomeExame") java.lang.String nomeExame, @Param(value="dataEmissao") java.util.Date dataEmissao, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Resultado entity WHERE entity.estabelecimentoDeSaude.id = :id")
  public Page<Resultado> findResultado(@Param(value="id") java.lang.String id, Pageable pageable);
  
  /**
   * ManyToOne Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity.convenio FROM User entity WHERE entity.estabelecimentoDeSaude.id = :id AND (entity.convenio.nome like concat('%',coalesce(:search,''),'%') OR entity.convenio.cnPJ like concat('%',coalesce(:search,''),'%'))")
  public Page<Convenio> listConvenioGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity.convenio FROM User entity WHERE entity.estabelecimentoDeSaude.id = :id AND (:nome is null OR entity.convenio.nome like concat('%',:nome,'%')) AND (:cnPJ is null OR entity.convenio.cnPJ like concat('%',:cnPJ,'%'))")
  public Page<Convenio> listConvenioSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="nome") java.lang.String nome, @Param(value="cnPJ") java.lang.String cnPJ, Pageable pageable);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.convenio FROM User entity WHERE entity.estabelecimentoDeSaude.id = :id")
  public Page<Convenio> listConvenio(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM User entity WHERE entity.estabelecimentoDeSaude.id = :instanceId AND entity.convenio.id = :relationId")
  public int deleteConvenio(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM EstabelecimentoDeSaude entity WHERE entity.nome like concat('%',coalesce(:search,''),'%') OR entity.cnPJ like concat('%',coalesce(:search,''),'%') OR entity.razaoSocial like concat('%',coalesce(:search,''),'%')")
  public Page<EstabelecimentoDeSaude> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM EstabelecimentoDeSaude entity WHERE (:nome is null OR entity.nome like concat('%',:nome,'%')) AND (:cnPJ is null OR entity.cnPJ like concat('%',:cnPJ,'%')) AND (:razaoSocial is null OR entity.razaoSocial like concat('%',:razaoSocial,'%'))")
  public Page<EstabelecimentoDeSaude> specificSearch(@Param(value="nome") java.lang.String nome, @Param(value="cnPJ") java.lang.String cnPJ, @Param(value="razaoSocial") java.lang.String razaoSocial, Pageable pageable);
  
}
