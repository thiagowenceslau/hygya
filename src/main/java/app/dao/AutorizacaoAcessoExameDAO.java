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
@Repository("AutorizacaoAcessoExameDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface AutorizacaoAcessoExameDAO extends JpaRepository<AutorizacaoAcessoExame, java.lang.String> {

  /**
   * Obtém a instância de AutorizacaoAcessoExame utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM AutorizacaoAcessoExame entity WHERE entity.id = :id")
  public AutorizacaoAcessoExame findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de AutorizacaoAcessoExame utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM AutorizacaoAcessoExame entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM ExameAutorizado entity WHERE entity.autorizacaoAcessoExame.id = :id")
  public Page<ExameAutorizado> findExameAutorizado(@Param(value="id") java.lang.String id, Pageable pageable);
  
  /**
   * ManyToOne Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity.resultado FROM ExameAutorizado entity WHERE entity.autorizacaoAcessoExame.id = :id AND (entity.resultado.nomeExame like concat('%',coalesce(:search,''),'%'))")
  public Page<Resultado> listResultadoGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity.resultado FROM ExameAutorizado entity WHERE entity.autorizacaoAcessoExame.id = :id AND (:nomeExame is null OR entity.resultado.nomeExame like concat('%',:nomeExame,'%')) AND (:dataEmissao is null OR entity.resultado.dataEmissao = :dataEmissao)")
  public Page<Resultado> listResultadoSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="nomeExame") java.lang.String nomeExame, @Param(value="dataEmissao") java.util.Date dataEmissao, Pageable pageable);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.resultado FROM ExameAutorizado entity WHERE entity.autorizacaoAcessoExame.id = :id")
  public Page<Resultado> listResultado(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM ExameAutorizado entity WHERE entity.autorizacaoAcessoExame.id = :instanceId AND entity.resultado.id = :relationId")
  public int deleteResultado(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  /**
   * Foreign Key paciente
   * @generated
   */
  @Query("SELECT entity FROM AutorizacaoAcessoExame entity WHERE entity.paciente.id = :id")
  public Page<AutorizacaoAcessoExame> findAutorizacaoAcessoExamesByPaciente(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key profissional
   * @generated
   */
  @Query("SELECT entity FROM AutorizacaoAcessoExame entity WHERE entity.profissional.id = :id")
  public Page<AutorizacaoAcessoExame> findAutorizacaoAcessoExamesByProfissional(@Param(value="id") java.lang.String id, Pageable pageable);

}
