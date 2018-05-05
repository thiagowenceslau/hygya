package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela PROFISSIONAL
 * @generated
 */
@Entity
@Table(name = "\"PROFISSIONAL\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Profissional")
public class Profissional implements Serializable {

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
  @Column(name = "Nome", nullable = false, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String nome;

  /**
  * @generated
  */
  @Column(name = "CPF", nullable = false, unique = false, length=20, insertable=true, updatable=true)
  
  private java.lang.String cpF;

  /**
  * @generated
  */
  @Column(name = "CRM", nullable = false, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String crM;

  /**
  * @generated
  */
  @Column(name = "NumCRM", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer numCRM;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "DataNascimento", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataNascimento;

  /**
  * @generated
  */
  @Column(name = "Sexo", nullable = false, unique = false, length=10, insertable=true, updatable=true)
  
  private java.lang.String sexo;

  /**
  * @generated
  */
  @Column(name = "Telefone1", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.lang.String telefone1;

  /**
  * @generated
  */
  @Column(name = "Telefone2", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String telefone2;

  /**
  * @generated
  */
  @Column(name = "Endereco", nullable = true, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String endereco;

  /**
  * @generated
  */
  @Column(name = "Bairro", nullable = true, unique = false, length=60, insertable=true, updatable=true)
  
  private java.lang.String bairro;

  /**
  * @generated
  */
  @Column(name = "Numero", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer numero;

  /**
  * @generated
  */
  @Column(name = "Complemento", nullable = true, unique = false, length=80, insertable=true, updatable=true)
  
  private java.lang.String complemento;

  /**
  * @generated
  */
  @Column(name = "Cidade", nullable = true, unique = false, length=60, insertable=true, updatable=true)
  
  private java.lang.String cidade;

  /**
  * @generated
  */
  @Column(name = "Estado", nullable = true, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String estado;

  /**
  * @generated
  */
  @Column(name = "Cep", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String cep;

  /**
  * @generated
  */
  @Column(name = "Ativo", nullable = true, unique = false, length=10, insertable=true, updatable=true)
  
  private java.lang.String ativo;

  /**
  * @generated
  */
  @Column(name = "Bloqueado", nullable = true, unique = false, length=3, insertable=true, updatable=true)
  
  private java.lang.String bloqueado;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "DataInclusao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataInclusao;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "DataAtivacao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataAtivacao;

  /**
  * @generated
  */
  @OneToOne
  @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private User user;

  /**
  * @generated
  */
  @OneToOne
  @JoinColumn(name="fk_user_1", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private User userAutorizador;

  /**
   * Construtor
   * @generated
   */
  public Profissional(){
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
  public Profissional setId(java.lang.String id){
    this.id = id;
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
  public Profissional setNome(java.lang.String nome){
    this.nome = nome;
    return this;
  }

  /**
   * Obtém cpF
   * return cpF
   * @generated
   */
  
  public java.lang.String getCpF(){
    return this.cpF;
  }

  /**
   * Define cpF
   * @param cpF cpF
   * @generated
   */
  public Profissional setCpF(java.lang.String cpF){
    this.cpF = cpF;
    return this;
  }

  /**
   * Obtém crM
   * return crM
   * @generated
   */
  
  public java.lang.String getCrM(){
    return this.crM;
  }

  /**
   * Define crM
   * @param crM crM
   * @generated
   */
  public Profissional setCrM(java.lang.String crM){
    this.crM = crM;
    return this;
  }

  /**
   * Obtém numCRM
   * return numCRM
   * @generated
   */
  
  public java.lang.Integer getNumCRM(){
    return this.numCRM;
  }

  /**
   * Define numCRM
   * @param numCRM numCRM
   * @generated
   */
  public Profissional setNumCRM(java.lang.Integer numCRM){
    this.numCRM = numCRM;
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
  public Profissional setDataNascimento(java.util.Date dataNascimento){
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
  public Profissional setSexo(java.lang.String sexo){
    this.sexo = sexo;
    return this;
  }

  /**
   * Obtém telefone1
   * return telefone1
   * @generated
   */
  
  public java.lang.String getTelefone1(){
    return this.telefone1;
  }

  /**
   * Define telefone1
   * @param telefone1 telefone1
   * @generated
   */
  public Profissional setTelefone1(java.lang.String telefone1){
    this.telefone1 = telefone1;
    return this;
  }

  /**
   * Obtém telefone2
   * return telefone2
   * @generated
   */
  
  public java.lang.String getTelefone2(){
    return this.telefone2;
  }

  /**
   * Define telefone2
   * @param telefone2 telefone2
   * @generated
   */
  public Profissional setTelefone2(java.lang.String telefone2){
    this.telefone2 = telefone2;
    return this;
  }

  /**
   * Obtém endereco
   * return endereco
   * @generated
   */
  
  public java.lang.String getEndereco(){
    return this.endereco;
  }

  /**
   * Define endereco
   * @param endereco endereco
   * @generated
   */
  public Profissional setEndereco(java.lang.String endereco){
    this.endereco = endereco;
    return this;
  }

  /**
   * Obtém bairro
   * return bairro
   * @generated
   */
  
  public java.lang.String getBairro(){
    return this.bairro;
  }

  /**
   * Define bairro
   * @param bairro bairro
   * @generated
   */
  public Profissional setBairro(java.lang.String bairro){
    this.bairro = bairro;
    return this;
  }

  /**
   * Obtém numero
   * return numero
   * @generated
   */
  
  public java.lang.Integer getNumero(){
    return this.numero;
  }

  /**
   * Define numero
   * @param numero numero
   * @generated
   */
  public Profissional setNumero(java.lang.Integer numero){
    this.numero = numero;
    return this;
  }

  /**
   * Obtém complemento
   * return complemento
   * @generated
   */
  
  public java.lang.String getComplemento(){
    return this.complemento;
  }

  /**
   * Define complemento
   * @param complemento complemento
   * @generated
   */
  public Profissional setComplemento(java.lang.String complemento){
    this.complemento = complemento;
    return this;
  }

  /**
   * Obtém cidade
   * return cidade
   * @generated
   */
  
  public java.lang.String getCidade(){
    return this.cidade;
  }

  /**
   * Define cidade
   * @param cidade cidade
   * @generated
   */
  public Profissional setCidade(java.lang.String cidade){
    this.cidade = cidade;
    return this;
  }

  /**
   * Obtém estado
   * return estado
   * @generated
   */
  
  public java.lang.String getEstado(){
    return this.estado;
  }

  /**
   * Define estado
   * @param estado estado
   * @generated
   */
  public Profissional setEstado(java.lang.String estado){
    this.estado = estado;
    return this;
  }

  /**
   * Obtém cep
   * return cep
   * @generated
   */
  
  public java.lang.String getCep(){
    return this.cep;
  }

  /**
   * Define cep
   * @param cep cep
   * @generated
   */
  public Profissional setCep(java.lang.String cep){
    this.cep = cep;
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
  public Profissional setAtivo(java.lang.String ativo){
    this.ativo = ativo;
    return this;
  }

  /**
   * Obtém bloqueado
   * return bloqueado
   * @generated
   */
  
  public java.lang.String getBloqueado(){
    return this.bloqueado;
  }

  /**
   * Define bloqueado
   * @param bloqueado bloqueado
   * @generated
   */
  public Profissional setBloqueado(java.lang.String bloqueado){
    this.bloqueado = bloqueado;
    return this;
  }

  /**
   * Obtém dataInclusao
   * return dataInclusao
   * @generated
   */
  
  public java.util.Date getDataInclusao(){
    return this.dataInclusao;
  }

  /**
   * Define dataInclusao
   * @param dataInclusao dataInclusao
   * @generated
   */
  public Profissional setDataInclusao(java.util.Date dataInclusao){
    this.dataInclusao = dataInclusao;
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
  public Profissional setDataAtivacao(java.util.Date dataAtivacao){
    this.dataAtivacao = dataAtivacao;
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
  public Profissional setUser(User user){
    this.user = user;
    return this;
  }

  /**
   * Obtém userAutorizador
   * return userAutorizador
   * @generated
   */
  
  public User getUserAutorizador(){
    return this.userAutorizador;
  }

  /**
   * Define userAutorizador
   * @param userAutorizador userAutorizador
   * @generated
   */
  public Profissional setUserAutorizador(User userAutorizador){
    this.userAutorizador = userAutorizador;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Profissional object = (Profissional)obj;
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
