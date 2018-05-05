package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela AUTORIZACAOACESSOEXAME
 * @generated
 */
@Entity
@Table(name = "\"AUTORIZACAOACESSOEXAME\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.AutorizacaoAcessoExame")
public class AutorizacaoAcessoExame implements Serializable {

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
  @JoinColumn(name="fk_paciente", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Paciente paciente;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_profissional", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Profissional profissional;

  /**
  * @generated
  */
  @Column(name = "ativo", nullable = true, unique = false, length=3, insertable=true, updatable=true)
  
  private java.lang.String ativo;

  /**
  * @generated
  */
  @Column(name = "autorizado", nullable = true, unique = false, length=10, insertable=true, updatable=true)
  
  private java.lang.String autorizado;

  /**
  * @generated
  */
  @Column(name = "todosExames", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Boolean todosExames;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "dataExpiracao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataExpiracao;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "dataAutorizacao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataAutorizacao;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "dataSolicitacao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataSolicitacao;

  /**
   * Construtor
   * @generated
   */
  public AutorizacaoAcessoExame(){
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
  public AutorizacaoAcessoExame setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém paciente
   * return paciente
   * @generated
   */
  
  public Paciente getPaciente(){
    return this.paciente;
  }

  /**
   * Define paciente
   * @param paciente paciente
   * @generated
   */
  public AutorizacaoAcessoExame setPaciente(Paciente paciente){
    this.paciente = paciente;
    return this;
  }

  /**
   * Obtém profissional
   * return profissional
   * @generated
   */
  
  public Profissional getProfissional(){
    return this.profissional;
  }

  /**
   * Define profissional
   * @param profissional profissional
   * @generated
   */
  public AutorizacaoAcessoExame setProfissional(Profissional profissional){
    this.profissional = profissional;
    return this;
  }

  /**
   * Obtém ativo
   * return ativo
   * @generated
   */
  
  public java.lang.String getAtivo(){
    return this.ativo;
  }

  /**
   * Define ativo
   * @param ativo ativo
   * @generated
   */
  public AutorizacaoAcessoExame setAtivo(java.lang.String ativo){
    this.ativo = ativo;
    return this;
  }

  /**
   * Obtém autorizado
   * return autorizado
   * @generated
   */
  
  public java.lang.String getAutorizado(){
    return this.autorizado;
  }

  /**
   * Define autorizado
   * @param autorizado autorizado
   * @generated
   */
  public AutorizacaoAcessoExame setAutorizado(java.lang.String autorizado){
    this.autorizado = autorizado;
    return this;
  }

  /**
   * Obtém todosExames
   * return todosExames
   * @generated
   */
  
  public java.lang.Boolean getTodosExames(){
    return this.todosExames;
  }

  /**
   * Define todosExames
   * @param todosExames todosExames
   * @generated
   */
  public AutorizacaoAcessoExame setTodosExames(java.lang.Boolean todosExames){
    this.todosExames = todosExames;
    return this;
  }

  /**
   * Obtém dataExpiracao
   * return dataExpiracao
   * @generated
   */
  
  public java.util.Date getDataExpiracao(){
    return this.dataExpiracao;
  }

  /**
   * Define dataExpiracao
   * @param dataExpiracao dataExpiracao
   * @generated
   */
  public AutorizacaoAcessoExame setDataExpiracao(java.util.Date dataExpiracao){
    this.dataExpiracao = dataExpiracao;
    return this;
  }

  /**
   * Obtém dataAutorizacao
   * return dataAutorizacao
   * @generated
   */
  
  public java.util.Date getDataAutorizacao(){
    return this.dataAutorizacao;
  }

  /**
   * Define dataAutorizacao
   * @param dataAutorizacao dataAutorizacao
   * @generated
   */
  public AutorizacaoAcessoExame setDataAutorizacao(java.util.Date dataAutorizacao){
    this.dataAutorizacao = dataAutorizacao;
    return this;
  }

  /**
   * Obtém dataSolicitacao
   * return dataSolicitacao
   * @generated
   */
  
  public java.util.Date getDataSolicitacao(){
    return this.dataSolicitacao;
  }

  /**
   * Define dataSolicitacao
   * @param dataSolicitacao dataSolicitacao
   * @generated
   */
  public AutorizacaoAcessoExame setDataSolicitacao(java.util.Date dataSolicitacao){
    this.dataSolicitacao = dataSolicitacao;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    AutorizacaoAcessoExame object = (AutorizacaoAcessoExame)obj;
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
