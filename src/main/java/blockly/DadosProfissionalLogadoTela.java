package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class DadosProfissionalLogadoTela {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var atualizar() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations
						.execute(Var.valueOf("app.entity.Profissional"),
								Var.valueOf(
										"update Profissional set bairro = :bairro, telefone2 = :telefone2, cep = :cep, cidade = :cidade, complemento = :complemento, cpF = :cpF, crM = :crM, dataNascimento = :dataNascimento, endereco = :endereco, estado = :estado, nome = :nome, numCRM = :numCRM, numero = :numero, sexo = :sexo, telefone1 = :telefone1 where id = :id"),
								Var.valueOf("bairro",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.bairro"))),
								Var.valueOf("telefone2",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.telefone2"))),
								Var.valueOf("cep",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.cep"))),
								Var.valueOf("cidade",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.cidade"))),
								Var.valueOf("complemento",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.complemento"))),
								Var.valueOf("cpF",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.cpF"))),
								Var.valueOf("crM",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.crM"))),
								Var.valueOf("dataNascimento",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.dataNascimento"))),
								Var.valueOf("endereco",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.endereco"))),
								Var.valueOf("estado",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.estado"))),
								Var.valueOf("nome",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.nome"))),
								Var.valueOf("numCRM",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.numCRM"))),
								Var.valueOf("numero",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.numero"))),
								Var.valueOf("sexo",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.sexo"))),
								Var.valueOf("telefone1",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Profissional.active.telefone1"))),
								Var.valueOf("id", Var.valueOf(retornarIdProfissional())));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("Cadastro atualizado com sucesso!"));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 */
	// Descreva esta função...
	public static void buscarCep() throws Exception {
		new Callable<Var>() {

			private Var url = Var.VAR_NULL;
			private Var retornaCep = Var.VAR_NULL;

			public Var call() throws Exception {
				url = Var.valueOf(Var.valueOf("https://viacep.com.br/ws/").toString()
						+ cronapi.screen.Operations.getValueOfField(Var.valueOf("Profissional.active.cep")).toString()
						+ Var.valueOf("/json").toString());
				retornaCep = cronapi.util.Operations.getURLFromOthers(Var.valueOf("GET"),
						Var.valueOf("application/json"), url, Var.VAR_NULL, Var.VAR_NULL);
				retornaCep = cronapi.json.Operations.toJson(retornaCep);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Profissional.active.endereco"),
						cronapi.json.Operations.getJsonOrMapField(retornaCep, Var.valueOf("logradouro")));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Profissional.active.cidade"),
						cronapi.json.Operations.getJsonOrMapField(retornaCep, Var.valueOf("localidade")));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Profissional.active.bairro"),
						cronapi.json.Operations.getJsonOrMapField(retornaCep, Var.valueOf("bairro")));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Profissional.active.estado"),
						cronapi.json.Operations.getJsonOrMapField(retornaCep, Var.valueOf("uf")));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarIdProfissional() throws Exception {
		return new Callable<Var>() {

			private Var consultaProfissional = Var.VAR_NULL;
			private Var idProfissional = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaProfissional = cronapi.database.Operations.query(Var.valueOf("app.entity.Profissional"),
						Var.valueOf("select p from Profissional p where p.user.id = :userId"),
						Var.valueOf("userId", blockly.UsuarioEntidade.retornarIdUsuarioLogado()));
				idProfissional = cronapi.database.Operations.getField(consultaProfissional, Var.valueOf("this[0].id"));
				return idProfissional;
			}
		}.call();
	}

}
