package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class RetornaIdEntidadesLogadas {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// RetornaIdEntidadesLogadas
	public static Var retornarIdUsuario() throws Exception {
		return new Callable<Var>() {

			private Var consultaUsuario = Var.VAR_NULL;
			private Var idUsuario = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaUsuario = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.login = :login"),
						Var.valueOf("login", cronapi.util.Operations.getCurrentUserName()));
				idUsuario = cronapi.database.Operations.getField(consultaUsuario, Var.valueOf("this[0].id"));
				return idUsuario;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarIdConvenio() throws Exception {
		return new Callable<Var>() {

			private Var consultaConvenio = Var.VAR_NULL;
			private Var idConvenio = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaConvenio = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.id = :id"),
						Var.valueOf("id", Var.valueOf(retornarIdUsuario())));
				idConvenio = cronapi.database.Operations.getField(consultaConvenio, Var.valueOf("this[0].convenio.id"));
				return idConvenio;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarIdEstabelecimento() throws Exception {
		return new Callable<Var>() {

			private Var consultaEstabelecimento = Var.VAR_NULL;
			private Var idEstabelecimento = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaEstabelecimento = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.id = :id"),
						Var.valueOf("id", Var.valueOf(retornarIdUsuario())));
				idEstabelecimento = cronapi.database.Operations.getField(consultaEstabelecimento,
						Var.valueOf("this[0].estabelecimentoDeSaude.id"));
				return idEstabelecimento;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarIdPaciente() throws Exception {
		return new Callable<Var>() {

			private Var consultaPaciente = Var.VAR_NULL;
			private Var idPaciente = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaPaciente = cronapi.database.Operations.query(Var.valueOf("app.entity.Paciente"),
						Var.valueOf("select p from Paciente p where p.user.id = :userId"),
						Var.valueOf("userId", Var.valueOf(retornarIdUsuario())));
				idPaciente = cronapi.database.Operations.getField(consultaPaciente, Var.valueOf("this[0].id"));
				return idPaciente;
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
						Var.valueOf("userId", Var.valueOf(retornarIdUsuario())));
				idProfissional = cronapi.database.Operations.getField(consultaProfissional, Var.valueOf("this[0].id"));
				return idProfissional;
			}
		}.call();
	}

}
