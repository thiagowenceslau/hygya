package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela RESULTADO
 * @generated
 */
@Entity
@Table(name = "\"RESULTADO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Resultado")
public class Resultado implements Serializable {

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
  @Column(name = "cpfPaciente", nullable = false, unique = false, length=12, insertable=true, updatable=true)
  
  private java.lang.String cpfPaciente;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_estabelecimentoDeSaude", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
  
  private EstabelecimentoDeSaude estabelecimentoDeSaude;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "dataImportacao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataImportacao;

  /**
  * @generated
  */
  @Column(name = "exame", nullable = false, unique = false, length=240, insertable=true, updatable=true)
  
  private java.lang.String nomeExame;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "dataEmissao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataEmissao;

  /**
  * @generated
  */
  @Temporal(TemporalType.TIME)
  @Column(name = "horaEmissao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date horaEmissao;

  /**
  * @generated
  */
  @Column(name = "materialExame", nullable = true, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String materialExame;

  /**
  * @generated
  */
  @Column(name = "nota", nullable = true, unique = false, length=300, insertable=true, updatable=true)
  
  private java.lang.String nota;

  /**
  * @generated
  */
  @Column(name = "nomePaciente", nullable = true, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String nomePaciente;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "dataNascimento", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataNascimento;

  /**
  * @generated
  */
  @Column(name = "valorReferencia", nullable = true, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String valorReferencia;

  /**
  * @generated
  */
  @Column(name = "valorResultado", nullable = true, unique = false, length=60, insertable=true, updatable=true)
  
  private java.lang.String valorResultado;

  /**
  * @generated
  */
  @Column(name = "metodo", nullable = true, unique = false, length=60, insertable=true, updatable=true)
  
  private java.lang.String metodo;

  /**
  * @generated
  */
  @Column(name = "comentario", nullable = true, unique = false, length=300, insertable=true, updatable=true)
  
  private java.lang.String comentario;

  /**
  * @generated
  */
  @Column(name = "conclusao", nullable = true, unique = false, length=2000, insertable=true, updatable=true)
  
  private java.lang.String conclusao;

  /**
  * @generated
  */
  @Column(name = "metodoExame", nullable = true, unique = false, length=60, insertable=true, updatable=true)
  
  private java.lang.String metodoExame;

  /**
  * @generated
  */
  @Column(name = "medico", nullable = true, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String medico;

  /**
   * Construtor
   * @generated
   */
  public Resultado(){
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
  public Resultado setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém cpfPaciente
   * return cpfPaciente
   * @generated
   */
  
  public java.lang.String getCpfPaciente(){
    return this.cpfPaciente;
  }

  /**
   * Define cpfPaciente
   * @param cpfPaciente cpfPaciente
   * @generated
   */
  public Resultado setCpfPaciente(java.lang.String cpfPaciente){
    this.cpfPaciente = cpfPaciente;
    return this;
  }

  /**
   * Obtém estabelecimentoDeSaude
   * return estabelecimentoDeSaude
   * @generated
   */
  
  public EstabelecimentoDeSaude getEstabelecimentoDeSaude(){
    return this.estabelecimentoDeSaude;
  }

  /**
   * Define estabelecimentoDeSaude
   * @param estabelecimentoDeSaude estabelecimentoDeSaude
   * @generated
   */
  public Resultado setEstabelecimentoDeSaude(EstabelecimentoDeSaude estabelecimentoDeSaude){
    this.estabelecimentoDeSaude = estabelecimentoDeSaude;
    return this;
  }

  /**
   * Obtém dataImportacao
   * return dataImportacao
   * @generated
   */
  
  public java.util.Date getDataImportacao(){
    return this.dataImportacao;
  }

  /**
   * Define dataImportacao
   * @param dataImportacao dataImportacao
   * @generated
   */
  public Resultado setDataImportacao(java.util.Date dataImportacao){
    this.dataImportacao = dataImportacao;
    return this;
  }

  /**
   * Obtém nomeExame
   * return nomeExame
   * @generated
   */
  
  public java.lang.String getNomeExame(){
    return this.nomeExame;
  }

  /**
   * Define nomeExame
   * @param nomeExame nomeExame
   * @generated
   */
  public Resultado setNomeExame(java.lang.String nomeExame){
    this.nomeExame = nomeExame;
    return this;
  }

  /**
   * Obtém dataEmissao
   * return dataEmissao
   * @generated
   */
  
  public java.util.Date getDataEmissao(){
    return this.dataEmissao;
  }

  /**
   * Define dataEmissao
   * @param dataEmissao dataEmissao
   * @generated
   */
  public Resultado setDataEmissao(java.util.Date dataEmissao){
    this.dataEmissao = dataEmissao;
    return this;
  }

  /**
   * Obtém horaEmissao
   * return horaEmissao
   * @generated
   */
  
  public java.util.Date getHoraEmissao(){
    return this.horaEmissao;
  }

  /**
   * Define horaEmissao
   * @param horaEmissao horaEmissao
   * @generated
   */
  public Resultado setHoraEmissao(java.util.Date horaEmissao){
    this.horaEmissao = horaEmissao;
    return this;
  }

  /**
   * Obtém materialExame
   * return materialExame
   * @generated
   */
  
  public java.lang.String getMaterialExame(){
    return this.materialExame;
  }

  /**
   * Define materialExame
   * @param materialExame materialExame
   * @generated
   */
  public Resultado setMaterialExame(java.lang.String materialExame){
    this.materialExame = materialExame;
    return this;
  }

  /**
   * Obtém nota
   * return nota
   * @generated
   */
  
  public java.lang.String getNota(){
    return this.nota;
  }

  /**
   * Define nota
   * @param nota nota
   * @generated
   */
  public Resultado setNota(java.lang.String nota){
    this.nota = nota;
    return this;
  }

  /**
   * Obtém nomePaciente
   * return nomePaciente
   * @generated
   */
  
  public java.lang.String getNomePaciente(){
    return this.nomePaciente;
  }

  /**
   * Define nomePaciente
   * @param nomePaciente nomePaciente
   * @generated
   */
  public Resultado setNomePaciente(java.lang.String nomePaciente){
    this.nomePaciente = nomePaciente;
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
  public Resultado setDataNascimento(java.util.Date dataNascimento){
    this.dataNascimento = dataNascimento;
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
  public Resultado setValorReferencia(java.lang.String valorReferencia){
    this.valorReferencia = valorReferencia;
    return this;
  }

  /**
   * Obtém valorResultado
   * return valorResultado
   * @generated
   */
  
  public java.lang.String getValorResultado(){
    return this.valorResultado;
  }

  /**
   * Define valorResultado
   * @param valorResultado valorResultado
   * @generated
   */
  public Resultado setValorResultado(java.lang.String valorResultado){
    this.valorResultado = valorResultado;
    return this;
  }

  /**
   * Obtém metodo
   * return metodo
   * @generated
   */
  
  public java.lang.String getMetodo(){
    return this.metodo;
  }

  /**
   * Define metodo
   * @param metodo metodo
   * @generated
   */
  public Resultado setMetodo(java.lang.String metodo){
    this.metodo = metodo;
    return this;
  }

  /**
   * Obtém comentario
   * return comentario
   * @generated
   */
  
  public java.lang.String getComentario(){
    return this.comentario;
  }

  /**
   * Define comentario
   * @param comentario comentario
   * @generated
   */
  public Resultado setComentario(java.lang.String comentario){
    this.comentario = comentario;
    return this;
  }

  /**
   * Obtém conclusao
   * return conclusao
   * @generated
   */
  
  public java.lang.String getConclusao(){
    return this.conclusao;
  }

  /**
   * Define conclusao
   * @param conclusao conclusao
   * @generated
   */
  public Resultado setConclusao(java.lang.String conclusao){
    this.conclusao = conclusao;
    return this;
  }

  /**
   * Obtém metodoExame
   * return metodoExame
   * @generated
   */
  
  public java.lang.String getMetodoExame(){
    return this.metodoExame;
  }

  /**
   * Define metodoExame
   * @param metodoExame metodoExame
   * @generated
   */
  public Resultado setMetodoExame(java.lang.String metodoExame){
    this.metodoExame = metodoExame;
    return this;
  }

  /**
   * Obtém medico
   * return medico
   * @generated
   */
  
  public java.lang.String getMedico(){
    return this.medico;
  }

  /**
   * Define medico
   * @param medico medico
   * @generated
   */
  public Resultado setMedico(java.lang.String medico){
    this.medico = medico;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Resultado object = (Resultado)obj;
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
