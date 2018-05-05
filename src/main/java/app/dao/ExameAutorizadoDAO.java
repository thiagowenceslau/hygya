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
@Repository("ExameAutorizadoDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface ExameAutorizadoDAO extends JpaRepository<ExameAutorizado, java.lang.String> {

  /**
   * Obtém a instância de ExameAutorizado utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM ExameAutorizado entity WHERE entity.id = :id")
  public ExameAutorizado findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de ExameAutorizado utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM ExameAutorizado entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * Foreign Key autorizacaoAcessoExame
   * @generated
   */
  @Query("SELECT entity FROM ExameAutorizado entity WHERE entity.autorizacaoAcessoExame.id = :id")
  public Page<ExameAutorizado> findExameAutorizadosByAutorizacaoAcessoExame(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key resultado
   * @generated
   */
  @Query("SELECT entity FROM ExameAutorizado entity WHERE entity.resultado.id = :id")
  public Page<ExameAutorizado> findExameAutorizadosByResultado(@Param(value="id") java.lang.String id, Pageable pageable);

}
