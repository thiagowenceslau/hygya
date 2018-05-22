package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Authenticated;Profissional", get = "Authenticated;Profissional", execute = "Authenticated;Profissional", delete = "Authenticated;Profissional", put = "Authenticated;Profissional")
public class ProfissionalEntidade {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var AtualizarProfissional() throws Exception {
		return new Callable<Var>() {

			private Var idProfissional = Var.VAR_NULL;

			public Var call() throws Exception {
				idProfissional = cronapi.database.Operations.query(Var.valueOf("app.entity.Profissional"),
						Var.valueOf("select p.id from Profissional p where p.user.login = :userLogin"),
						Var.valueOf("userLogin", cronapi.util.Operations.getCurrentUserName()));
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Profissional"),
						Var.valueOf(
								"update Profissional set bairro = :bairro, cep = :cep, cidade = :cidade, complemento = :complemento, cpF = :cpF, crM = :crM, dataNascimento = :dataNascimento, endereco = :endereco, estado = :estado, nome = :nome, numCRM = :numCRM, numero = :numero, sexo = :sexo, telefone1 = :telefone1 where id = :id"),
						Var.valueOf("bairro",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtComplemento"))),
						Var.valueOf("cep",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Profissional.active.cep"))),
						Var.valueOf("cidade",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Profissional.active.cidade"))),
						Var.valueOf("complemento",
								cronapi.screen.Operations
										.getValueOfField(Var.valueOf("Profissional.active.complemento"))),
						Var.valueOf("cpF",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Profissional.active.cpF"))),
						Var.valueOf("crM",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Profissional.active.crM"))),
						Var.valueOf("dataNascimento",
								cronapi.screen.Operations
										.getValueOfField(Var.valueOf("Profissional.active.dataNascimento"))),
						Var.valueOf("endereco",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Profissional.active.endereco"))),
						Var.valueOf("estado",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Profissional.active.estado"))),
						Var.valueOf("nome",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Profissional.active.nome"))),
						Var.valueOf("numCRM",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Profissional.active.numCRM"))),
						Var.valueOf("numero",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Profissional.active.numero"))),
						Var.valueOf("sexo",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Profissional.active.sexo"))),
						Var.valueOf("telefone1",
								cronapi.screen.Operations
										.getValueOfField(Var.valueOf("Profissional.active.telefone1"))),
						Var.valueOf("id", idProfissional));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						idProfissional);
				return idProfissional;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var obterUsuarioLogado() throws Exception {
		return new Callable<Var>() {

			private Var idProfissional = Var.VAR_NULL;

			public Var call() throws Exception {
				return cronapi.util.Operations.getCurrentUserName();
			}
		}.call();
	}

}
