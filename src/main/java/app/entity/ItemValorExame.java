package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela ITEMVALOREXAME
 * @generated
 */
@Entity
@Table(name = "\"ITEMVALOREXAME\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.ItemValorExame")
public class ItemValorExame implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_itemExame", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private ItemExame itemExame;

  /**
  * @generated
  */
  @Column(name = "decricao", nullable = true, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String descricao;

  /**
  * @generated
  */
  @Column(name = "valorEncontrado", nullable = false, unique = false, length=60, insertable=true, updatable=true)
  
  private java.lang.String valorEncontrado;

  /**
  * @generated
  */
  @Column(name = "valorReferencia", nullable = true, unique = false, length=60, insertable=true, updatable=true)
  
  private java.lang.String valorReferencia;

  /**
   * Construtor
   * @generated
   */
  public ItemValorExame(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public ItemValorExame setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém itemExame
   * return itemExame
   * @generated
   */
  
  public ItemExame getItemExame(){
    return this.itemExame;
  }

  /**
   * Define itemExame
   * @param itemExame itemExame
   * @generated
   */
  public ItemValorExame setItemExame(ItemExame itemExame){
    this.itemExame = itemExame;
    return this;
  }

  /**
   * Obtém descricao
   * return descricao
   * @generated
   */
  
  public java.lang.String getDescricao(){
    return this.descricao;
  }

  /**
   * Define descricao
   * @param descricao descricao
   * @generated
   */
  public ItemValorExame setDescricao(java.lang.String descricao){
    this.descricao = descricao;
    return this;
  }

  /**
   * Obtém valorEncontrado
   * return valorEncontrado
   * @generated
   */
  
  public java.lang.String getValorEncontrado(){
    return this.valorEncontrado;
  }

  /**
   * Define valorEncontrado
   * @param valorEncontrado valorEncontrado
   * @generated
   */
  public ItemValorExame setValorEncontrado(java.lang.String valorEncontrado){
    this.valorEncontrado = valorEncontrado;
    return this;
  }

  /**
   * Obtém valorReferencia
   * return valorReferencia
   * @generated
   */
  
  public java.lang.String getValorReferencia(){
    return this.valorReferencia;
  }

  /**
   * Define valorReferencia
   * @param valorReferencia valorReferencia
   * @generated
   */
  public ItemValorExame setValorReferencia(java.lang.String valorReferencia){
    this.valorReferencia = valorReferencia;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    ItemValorExame object = (ItemValorExame)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
