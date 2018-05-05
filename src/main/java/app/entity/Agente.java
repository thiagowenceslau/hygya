package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela AGENTE
 * @generated
 */
@Entity
@Table(name = "\"AGENTE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Agente")
public class Agente implements Serializable {

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
  @Column(name = "cpf", nullable = false, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String cpf;

  /**
  * @generated
  */
  @OneToOne
  @JoinColumn(name="fk_user", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
  
  private User user;

  /**
  * @generated
  */
  @Column(name = "cnpjSolicitante", nullable = true, unique = false, length=20, insertable=true, updatable=true)
  
  private java.lang.String cnpjSolicitante;

  /**
  * @generated
  */
  @Column(name = "rg", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String rg;

  /**
  * @generated
  */
  @Column(name = "idSolicitante", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.lang.String idSolicitante;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "dataSolicitacao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataSolicitacao;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "dataAtivacao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataAtivacao;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "dataRemocao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataRemocao;

  /**
  * @generated
  */
  @Column(name = "nomeSolicitante", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String nomeSolicitante;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "dataNascimento", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataNascimento;

  /**
  * @generated
  */
  @Column(name = "sexo", nullable = false, unique = false, length=10, insertable=true, updatable=true)
  
  private java.lang.String sexo;

  /**
  * @generated
  */
  @Column(name = "orgaoEmissor", nullable = true, unique = false, length=10, insertable=true, updatable=true)
  
  private java.lang.String orgaoEmissor;

  /**
  * @generated
  */
  @Column(name = "telefone", nullable = false, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String telefone;

  /**
  * @generated
  */
  @Column(name = "solicitacaoAtendida", nullable = true, unique = false, length=3, insertable=true, updatable=true)
  
  private java.lang.String solicitacaoAtendida;

  /**
  * @generated
  */
  @Column(name = "tipoSolicitante", nullable = false, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String tipoSolicitante;

  /**
  * @generated
  */
  @Column(name = "ativo", nullable = true, unique = false, length=10, insertable=true, updatable=true)
  
  private java.lang.String ativo;

  /**
  * @generated
  */
  @Column(name = "usuarioAprovador", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String usuarioAprovador;

  /**
   * Construtor
   * @generated
   */
  public Agente(){
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
  public Agente setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém cpf
   * return cpf
   * @generated
   */
  
  public java.lang.String getCpf(){
    return this.cpf;
  }

  /**
   * Define cpf
   * @param cpf cpf
   * @generated
   */
  public Agente setCpf(java.lang.String cpf){
    this.cpf = cpf;
    return this;
  }

  /**
   * Obtém user
   * return user
   * @generated
   */
  
  public User getUser(){
    return this.user;
  }

  /**
   * Define user
   * @param user user
   * @generated
   */
  public Agente setUser(User user){
    this.user = user;
    return this;
  }

  /**
   * Obtém cnpjSolicitante
   * return cnpjSolicitante
   * @generated
   */
  
  public java.lang.String getCnpjSolicitante(){
    return this.cnpjSolicitante;
  }

  /**
   * Define cnpjSolicitante
   * @param cnpjSolicitante cnpjSolicitante
   * @generated
   */
  public Agente setCnpjSolicitante(java.lang.String cnpjSolicitante){
    this.cnpjSolicitante = cnpjSolicitante;
    return this;
  }

  /**
   * Obtém rg
   * return rg
   * @generated
   */
  
  public java.lang.String getRg(){
    return this.rg;
  }

  /**
   * Define rg
   * @param rg rg
   * @generated
   */
  public Agente setRg(java.lang.String rg){
    this.rg = rg;
    return this;
  }

  /**
   * Obtém idSolicitante
   * return idSolicitante
   * @generated
   */
  
  public java.lang.String getIdSolicitante(){
    return this.idSolicitante;
  }

  /**
   * Define idSolicitante
   * @param idSolicitante idSolicitante
   * @generated
   */
  public Agente setIdSolicitante(java.lang.String idSolicitante){
    this.idSolicitante = idSolicitante;
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
  public Agente setDataSolicitacao(java.util.Date dataSolicitacao){
    this.dataSolicitacao = dataSolicitacao;
    return this;
  }

  /**
   * Obtém dataAtivacao
   * return dataAtivacao
   * @generated
   */
  
  public java.util.Date getDataAtivacao(){
    return this.dataAtivacao;
  }

  /**
   * Define dataAtivacao
   * @param dataAtivacao dataAtivacao
   * @generated
   */
  public Agente setDataAtivacao(java.util.Date dataAtivacao){
    this.dataAtivacao = dataAtivacao;
    return this;
  }

  /**
   * Obtém dataRemocao
   * return dataRemocao
   * @generated
   */
  
  public java.util.Date getDataRemocao(){
    return this.dataRemocao;
  }

  /**
   * Define dataRemocao
   * @param dataRemocao dataRemocao
   * @generated
   */
  public Agente setDataRemocao(java.util.Date dataRemocao){
    this.dataRemocao = dataRemocao;
    return this;
  }

  /**
   * Obtém nomeSolicitante
   * return nomeSolicitante
   * @generated
   */
  
  public java.lang.String getNomeSolicitante(){
    return this.nomeSolicitante;
  }

  /**
   * Define nomeSolicitante
   * @param nomeSolicitante nomeSolicitante
   * @generated
   */
  public Agente setNomeSolicitante(java.lang.String nomeSolicitante){
    this.nomeSolicitante = nomeSolicitante;
    return this;
  }

  /**
   * Obtém dataNascimento
   * return dataNascimento
   * @generated
   */
  
  public java.util.Date getDataNascimento(){
    return this.dataNascimento;
  }

  /**
   * Define dataNascimento
   * @param dataNascimento dataNascimento
   * @generated
   */
  public Agente setDataNascimento(java.util.Date dataNascimento){
    this.dataNascimento = dataNascimento;
    return this;
  }

  /**
   * Obtém sexo
   * return sexo
   * @generated
   */
  
  public java.lang.String getSexo(){
    return this.sexo;
  }

  /**
   * Define sexo
   * @param sexo sexo
   * @generated
   */
  public Agente setSexo(java.lang.String sexo){
    this.sexo = sexo;
    return this;
  }

  /**
   * Obtém orgaoEmissor
   * return orgaoEmissor
   * @generated
   */
  
  public java.lang.String getOrgaoEmissor(){
    return this.orgaoEmissor;
  }

  /**
   * Define orgaoEmissor
   * @param orgaoEmissor orgaoEmissor
   * @generated
   */
  public Agente setOrgaoEmissor(java.lang.String orgaoEmissor){
    this.orgaoEmissor = orgaoEmissor;
    return this;
  }

  /**
   * Obtém telefone
   * return telefone
   * @generated
   */
  
  public java.lang.String getTelefone(){
    return this.telefone;
  }

  /**
   * Define telefone
   * @param telefone telefone
   * @generated
   */
  public Agente setTelefone(java.lang.String telefone){
    this.telefone = telefone;
    return this;
  }

  /**
   * Obtém solicitacaoAtendida
   * return solicitacaoAtendida
   * @generated
   */
  
  public java.lang.String getSolicitacaoAtendida(){
    return this.solicitacaoAtendida;
  }

  /**
   * Define solicitacaoAtendida
   * @param solicitacaoAtendida solicitacaoAtendida
   * @generated
   */
  public Agente setSolicitacaoAtendida(java.lang.String solicitacaoAtendida){
    this.solicitacaoAtendida = solicitacaoAtendida;
    return this;
  }

  /**
   * Obtém tipoSolicitante
   * return tipoSolicitante
   * @generated
   */
  
  public java.lang.String getTipoSolicitante(){
    return this.tipoSolicitante;
  }

  /**
   * Define tipoSolicitante
   * @param tipoSolicitante tipoSolicitante
   * @generated
   */
  public Agente setTipoSolicitante(java.lang.String tipoSolicitante){
    this.tipoSolicitante = tipoSolicitante;
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
  public Agente setAtivo(java.lang.String ativo){
    this.ativo = ativo;
    return this;
  }

  /**
   * Obtém usuarioAprovador
   * return usuarioAprovador
   * @generated
   */
  
  public java.lang.String getUsuarioAprovador(){
    return this.usuarioAprovador;
  }

  /**
   * Define usuarioAprovador
   * @param usuarioAprovador usuarioAprovador
   * @generated
   */
  public Agente setUsuarioAprovador(java.lang.String usuarioAprovador){
    this.usuarioAprovador = usuarioAprovador;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Agente object = (Agente)obj;
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
