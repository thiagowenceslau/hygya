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
@Repository("ResultadoDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface ResultadoDAO extends JpaRepository<Resultado, java.lang.String> {

  /**
   * Obtém a instância de Resultado utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Resultado entity WHERE entity.id = :id")
  public Resultado findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Resultado utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Resultado entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM ItemExame entity WHERE entity.resultado.id = :id")
  public Page<ItemExame> findItemExame(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM ExameAutorizado entity WHERE entity.resultado.id = :id")
  public Page<ExameAutorizado> findExameAutorizado(@Param(value="id") java.lang.String id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.autorizacaoAcessoExame FROM ExameAutorizado entity WHERE entity.resultado.id = :id")
  public Page<AutorizacaoAcessoExame> listAutorizacaoAcessoExame(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM ExameAutorizado entity WHERE entity.resultado.id = :instanceId AND entity.autorizacaoAcessoExame.id = :relationId")
  public int deleteAutorizacaoAcessoExame(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Resultado entity WHERE entity.nomeExame like concat('%',coalesce(:search,''),'%')")
  public Page<Resultado> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Resultado entity WHERE (:nomeExame is null OR entity.nomeExame like concat('%',:nomeExame,'%')) AND (:dataEmissao is null OR entity.dataEmissao = :dataEmissao)")
  public Page<Resultado> specificSearch(@Param(value="nomeExame") java.lang.String nomeExame, @Param(value="dataEmissao") java.util.Date dataEmissao, Pageable pageable);
  
  /**
   * Foreign Key estabelecimentoDeSaude
   * @generated
   */
  @Query("SELECT entity FROM Resultado entity WHERE entity.estabelecimentoDeSaude.id = :id")
  public Page<Resultado> findResultadosByEstabelecimentoDeSaude(@Param(value="id") java.lang.String id, Pageable pageable);

}
