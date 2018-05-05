package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela PACIENTE
 * @generated
 */
@Entity
@Table(name = "\"PACIENTE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Paciente")
public class Paciente implements Serializable {

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
  @Column(name = "Cpf", nullable = false, unique = false, length=20, insertable=true, updatable=true)
  
  private java.lang.String cpf;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "DataNascimento", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataNascimento;

  /**
  * @generated
  */
  @Column(name = "Telefone1", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String telefone1;

  /**
  * @generated
  */
  @Column(name = "Telefone2", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
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
  @Column(name = "Cep", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
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
  @Column(name = "Sexo", nullable = false, unique = false, length=10, insertable=true, updatable=true)
  
  private java.lang.String sexo;

  /**
  * @generated
  */
  @Column(name = "Cancelado", nullable = true, unique = false, length=3, insertable=true, updatable=true)
  
  private java.lang.String cancelado;

  /**
  * @generated
  */
  @Column(name = "AgenteAutorizador", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String agenteAutorizador;

  /**
   * Construtor
   * @generated
   */
  public Paciente(){
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
  public Paciente setId(java.lang.String id){
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
  public Paciente setNome(java.lang.String nome){
    this.nome = nome;
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
  public Paciente setCpf(java.lang.String cpf){
    this.cpf = cpf;
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
  public Paciente setDataNascimento(java.util.Date dataNascimento){
    this.dataNascimento = dataNascimento;
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
  public Paciente setTelefone1(java.lang.String telefone1){
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
  public Paciente setTelefone2(java.lang.String telefone2){
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
  public Paciente setEndereco(java.lang.String endereco){
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
  public Paciente setBairro(java.lang.String bairro){
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
  public Paciente setNumero(java.lang.Integer numero){
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
  public Paciente setComplemento(java.lang.String complemento){
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
  public Paciente setCidade(java.lang.String cidade){
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
  public Paciente setEstado(java.lang.String estado){
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
  public Paciente setCep(java.lang.String cep){
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
  public Paciente setAtivo(java.lang.String ativo){
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
  public Paciente setBloqueado(java.lang.String bloqueado){
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
  public Paciente setDataInclusao(java.util.Date dataInclusao){
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
  public Paciente setDataAtivacao(java.util.Date dataAtivacao){
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
  public Paciente setUser(User user){
    this.user = user;
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
  public Paciente setSexo(java.lang.String sexo){
    this.sexo = sexo;
    return this;
  }

  /**
   * Obtém cancelado
   * return cancelado
   * @generated
   */
  
  public java.lang.String getCancelado(){
    return this.cancelado;
  }

  /**
   * Define cancelado
   * @param cancelado cancelado
   * @generated
   */
  public Paciente setCancelado(java.lang.String cancelado){
    this.cancelado = cancelado;
    return this;
  }

  /**
   * Obtém agenteAutorizador
   * return agenteAutorizador
   * @generated
   */
  
  public java.lang.String getAgenteAutorizador(){
    return this.agenteAutorizador;
  }

  /**
   * Define agenteAutorizador
   * @param agenteAutorizador agenteAutorizador
   * @generated
   */
  public Paciente setAgenteAutorizador(java.lang.String agenteAutorizador){
    this.agenteAutorizador = agenteAutorizador;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Paciente object = (Paciente)obj;
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
