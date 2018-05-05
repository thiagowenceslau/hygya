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
@Repository("ItemExameDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface ItemExameDAO extends JpaRepository<ItemExame, java.lang.String> {

  /**
   * Obtém a instância de ItemExame utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM ItemExame entity WHERE entity.id = :id")
  public ItemExame findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de ItemExame utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM ItemExame entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM ItemValorExame entity WHERE entity.itemExame.id = :id")
  public Page<ItemValorExame> findItemValorExame(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key resultado
   * @generated
   */
  @Query("SELECT entity FROM ItemExame entity WHERE entity.resultado.id = :id")
  public Page<ItemExame> findItemExamesByResultado(@Param(value="id") java.lang.String id, Pageable pageable);

}
