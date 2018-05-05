package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela ITEMEXAME
 * @generated
 */
@Entity
@Table(name = "\"ITEMEXAME\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.ItemExame")
public class ItemExame implements Serializable {

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
  @JoinColumn(name="fk_resultado", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Resultado resultado;

  /**
  * @generated
  */
  @Column(name = "nome", nullable = true, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String nome;

  /**
  * @generated
  */
  @Column(name = "observacao", nullable = true, unique = false, length=300, insertable=true, updatable=true)
  
  private java.lang.String observacao;

  /**
   * Construtor
   * @generated
   */
  public ItemExame(){
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
  public ItemExame setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém resultado
   * return resultado
   * @generated
   */
  
  public Resultado getResultado(){
    return this.resultado;
  }

  /**
   * Define resultado
   * @param resultado resultado
   * @generated
   */
  public ItemExame setResultado(Resultado resultado){
    this.resultado = resultado;
    return this;
  }

  /**
   * Obtém nome
   * return nome
   * @generated
   */
  
  public java.lang.String getNome(){
    return this.nome;
  }

  /**
   * Define nome
   * @param nome nome
   * @generated
   */
  public ItemExame setNome(java.lang.String nome){
    this.nome = nome;
    return this;
  }

  /**
   * Obtém observacao
   * return observacao
   * @generated
   */
  
  public java.lang.String getObservacao(){
    return this.observacao;
  }

  /**
   * Define observacao
   * @param observacao observacao
   * @generated
   */
  public ItemExame setObservacao(java.lang.String observacao){
    this.observacao = observacao;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    ItemExame object = (ItemExame)obj;
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
