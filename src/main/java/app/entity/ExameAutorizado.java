package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela EXAMEAUTORIZADO
 * @generated
 */
@Entity
@Table(name = "\"EXAMEAUTORIZADO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.ExameAutorizado")
public class ExameAutorizado implements Serializable {

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
  @JoinColumn(name="fk_autorizacaoAcessoExame", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private AutorizacaoAcessoExame autorizacaoAcessoExame;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_resultado", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Resultado resultado;

  /**
   * Construtor
   * @generated
   */
  public ExameAutorizado(){
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
  public ExameAutorizado setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém autorizacaoAcessoExame
   * return autorizacaoAcessoExame
   * @generated
   */
  
  public AutorizacaoAcessoExame getAutorizacaoAcessoExame(){
    return this.autorizacaoAcessoExame;
  }

  /**
   * Define autorizacaoAcessoExame
   * @param autorizacaoAcessoExame autorizacaoAcessoExame
   * @generated
   */
  public ExameAutorizado setAutorizacaoAcessoExame(AutorizacaoAcessoExame autorizacaoAcessoExame){
    this.autorizacaoAcessoExame = autorizacaoAcessoExame;
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
  public ExameAutorizado setResultado(Resultado resultado){
    this.resultado = resultado;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    ExameAutorizado object = (ExameAutorizado)obj;
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
