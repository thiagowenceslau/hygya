package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela CONVENIO
 * @generated
 */
@Entity
@Table(name = "\"CONVENIO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Convenio")
public class Convenio implements Serializable {

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
  @Column(name = "RazaoSocial", nullable = false, unique = false, length=160, insertable=true, updatable=true)
  
  private java.lang.String razaoSocial;

  /**
  * @generated
  */
  @Column(name = "CNPJ", nullable = false, unique = false, length=20, insertable=true, updatable=true)
  
  private java.lang.String cnPJ;

  /**
  * @generated
  */
  @Column(name = "Registro", nullable = false, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String registroANS;

  /**
  * @generated
  */
  @Column(name = "Cep", nullable = true, unique = false, length=10, insertable=true, updatable=true)
  
  private java.lang.String cep;

  /**
  * @generated
  */
  @Column(name = "Endereco", nullable = true, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String endereco;

  /**
  * @generated
  */
  @Column(name = "Bairro", nullable = true, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String bairro;

  /**
  * @generated
  */
  @Column(name = "Numero", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer numero;

  /**
  * @generated
  */
  @Column(name = "Complemento", nullable = true, unique = false, length=60, insertable=true, updatable=true)
  
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
  @Column(name = "Email", nullable = true, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String email;

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
  @Column(name = "ContatoResponsavel", nullable = true, unique = false, length=80, insertable=true, updatable=true)
  
  private java.lang.String contatoResponsavel;

  /**
  * @generated
  */
  @Column(name = "TipoCobranca", nullable = true, unique = false, length=12, insertable=true, updatable=true)
  
  private java.lang.String tipoCobranca;

  /**
  * @generated
  */
  @Column(name = "Ativo", nullable = true, unique = false, length=10, insertable=true, updatable=true)
  
  private java.lang.String ativo;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "DataInclusao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataInclusao;

  /**
   * Construtor
   * @generated
   */
  public Convenio(){
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
  public Convenio setId(java.lang.String id){
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
  public Convenio setNome(java.lang.String nome){
    this.nome = nome;
    return this;
  }

  /**
   * Obtém razaoSocial
   * return razaoSocial
   * @generated
   */
  
  public java.lang.String getRazaoSocial(){
    return this.razaoSocial;
  }

  /**
   * Define razaoSocial
   * @param razaoSocial razaoSocial
   * @generated
   */
  public Convenio setRazaoSocial(java.lang.String razaoSocial){
    this.razaoSocial = razaoSocial;
    return this;
  }

  /**
   * Obtém cnPJ
   * return cnPJ
   * @generated
   */
  
  public java.lang.String getCnPJ(){
    return this.cnPJ;
  }

  /**
   * Define cnPJ
   * @param cnPJ cnPJ
   * @generated
   */
  public Convenio setCnPJ(java.lang.String cnPJ){
    this.cnPJ = cnPJ;
    return this;
  }

  /**
   * Obtém registroANS
   * return registroANS
   * @generated
   */
  
  public java.lang.String getRegistroANS(){
    return this.registroANS;
  }

  /**
   * Define registroANS
   * @param registroANS registroANS
   * @generated
   */
  public Convenio setRegistroANS(java.lang.String registroANS){
    this.registroANS = registroANS;
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
  public Convenio setCep(java.lang.String cep){
    this.cep = cep;
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
  public Convenio setEndereco(java.lang.String endereco){
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
  public Convenio setBairro(java.lang.String bairro){
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
  public Convenio setNumero(java.lang.Integer numero){
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
  public Convenio setComplemento(java.lang.String complemento){
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
  public Convenio setCidade(java.lang.String cidade){
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
  public Convenio setEstado(java.lang.String estado){
    this.estado = estado;
    return this;
  }

  /**
   * Obtém email
   * return email
   * @generated
   */
  
  public java.lang.String getEmail(){
    return this.email;
  }

  /**
   * Define email
   * @param email email
   * @generated
   */
  public Convenio setEmail(java.lang.String email){
    this.email = email;
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
  public Convenio setTelefone1(java.lang.String telefone1){
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
  public Convenio setTelefone2(java.lang.String telefone2){
    this.telefone2 = telefone2;
    return this;
  }

  /**
   * Obtém contatoResponsavel
   * return contatoResponsavel
   * @generated
   */
  
  public java.lang.String getContatoResponsavel(){
    return this.contatoResponsavel;
  }

  /**
   * Define contatoResponsavel
   * @param contatoResponsavel contatoResponsavel
   * @generated
   */
  public Convenio setContatoResponsavel(java.lang.String contatoResponsavel){
    this.contatoResponsavel = contatoResponsavel;
    return this;
  }

  /**
   * Obtém tipoCobranca
   * return tipoCobranca
   * @generated
   */
  
  public java.lang.String getTipoCobranca(){
    return this.tipoCobranca;
  }

  /**
   * Define tipoCobranca
   * @param tipoCobranca tipoCobranca
   * @generated
   */
  public Convenio setTipoCobranca(java.lang.String tipoCobranca){
    this.tipoCobranca = tipoCobranca;
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
  public Convenio setAtivo(java.lang.String ativo){
    this.ativo = ativo;
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
  public Convenio setDataInclusao(java.util.Date dataInclusao){
    this.dataInclusao = dataInclusao;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Convenio object = (Convenio)obj;
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
